package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Validates ASIL propagation and decomposition rules throughout the
 * safety requirement hierarchy.
 *
 * Rules checked:
 *  Rule 1: Child FSRs must not have a higher ASIL than their parent SafetyGoal.
 *          [ISO 26262-9:2018 §5.4.3 — ASIL Inheritance & Propagation]
 *
 *  Rule 2: When a Safety Goal is decomposed into multiple FSRs, the combined
 *          ASIL of the children must satisfy the decomposition table.
 *          [ISO 26262-9:2018 §5.4.6 Table 5 — Valid Decomposition Combinations]
 *
 *          Valid decompositions (Part 9 §5.4.6 Table 5):
 *            ASIL D → ASIL B(D) + ASIL B(D)   — i.e. both B or higher
 *            ASIL C → ASIL A(C) + ASIL B(C)   — i.e. A + B or higher
 *            ASIL B → ASIL A(B) + ASIL A(B)   — i.e. both A or higher
 *            ASIL A → QM(A) + ASIL A           — i.e. one QM + one A
 *
 *  Rule 3: TSRs must carry the same or lower ASIL as the FSR they refine.
 *          [ISO 26262-9:2018 §5.4.3]
 *
 *  Rule 4: ASIL D TSRs allocated to ASIL B or lower blocks are flagged.
 *          [ISO 26262-4:2018 §6.4.5.g — TSR Allocation to Architecture Elements]
 *
 * ISO 26262 References:
 *   ISO 26262-9:2018 §5   — ASIL-Oriented and Safety-Oriented Analyses
 *   ISO 26262-9:2018 §5.4 — ASIL Decomposition
 */
public class PropagateASILAction extends AbstractExternalJavaAction {

    // Numeric ASIL ordering: QM=0, A=1, B=2, C=3, D=4
    private static final Map<String, Integer> ASIL_RANK = new LinkedHashMap<>();
    static {
        ASIL_RANK.put("QM",     0);
        ASIL_RANK.put("ASIL_A", 1);
        ASIL_RANK.put("ASIL_B", 2);
        ASIL_RANK.put("ASIL_C", 3);
        ASIL_RANK.put("ASIL_D", 4);
        // Also accept without underscore
        ASIL_RANK.put("A",      1);
        ASIL_RANK.put("B",      2);
        ASIL_RANK.put("C",      3);
        ASIL_RANK.put("D",      4);
    }

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select a UnifiedSystemModel.");
            return;
        }

        List<String> failures = new ArrayList<>();
        List<String> warnings = new ArrayList<>();
        List<String> passes   = new ArrayList<>();

        // ── Rule 1 & 2: SafetyGoal → FSR propagation and decomposition ───────
        for (SafetyGoal sg : model.getSafetyGoals()) {
            int goalRank = asilRank(sg.getAsilLevel());
            String goalAsilStr = asilStr(sg.getAsilLevel());
            List<FunctionalSafetyRequirement> fsrs = sg.getAllocatedTo();

            if (fsrs == null || fsrs.isEmpty()) continue; // covered by chain validator

            if (fsrs.size() == 1) {
                // Single FSR — must carry the same ASIL as the goal (no decomposition)
                FunctionalSafetyRequirement fsr = fsrs.get(0);
                int fsrRank = asilRank(((SafetyGoal) fsr).getAsilLevel());
                if (fsrRank > goalRank) {
                    failures.add(Iso26262Reference.checkRow(
                        "✘ FAIL",
                        "FSR '" + name(fsr) + "' ASIL=" + asilStr(((SafetyGoal) fsr).getAsilLevel())
                            + " is HIGHER than parent Safety Goal '" + name(sg)
                            + "' ASIL=" + goalAsilStr + ".",
                        Iso26262Reference.PART9_ASIL_PROPAGATION,
                        "Child FSR ASIL must not exceed the parent Safety Goal ASIL."
                    ));
                } else {
                    passes.add(Iso26262Reference.checkRow(
                        "✔ PASS",
                        "SG '" + name(sg) + "' [" + goalAsilStr + "] → FSR '"
                            + name(fsr) + "' [" + asilStr(((SafetyGoal) fsr).getAsilLevel()) + "] — propagation OK.",
                        Iso26262Reference.PART9_ASIL_PROPAGATION, null
                    ));
                }
            } else {
                // Multiple FSRs — validate as ASIL decomposition
                // Collect child ASIL ranks
                int minChildRank = Integer.MAX_VALUE;
                StringBuilder childSummary = new StringBuilder();
                for (FunctionalSafetyRequirement fsr : fsrs) {
                    int r = asilRank(((SafetyGoal) fsr).getAsilLevel());
                    minChildRank = Math.min(minChildRank, r);
                    childSummary.append(name(fsr)).append("[").append(asilStr(((SafetyGoal) fsr).getAsilLevel())).append("] ");
                }

                boolean decompositionValid = isValidDecomposition(goalRank, minChildRank, fsrs.size());
                if (!decompositionValid) {
                    failures.add(Iso26262Reference.checkRow(
                        "✘ FAIL",
                        "Safety Goal '" + name(sg) + "' [" + goalAsilStr + "] decomposition to ["
                            + childSummary.toString().trim() + "] violates Table 5.",
                        Iso26262Reference.PART9_ASIL_TABLE5,
                        getDecompositionGuidance(goalRank)
                    ));
                } else {
                    passes.add(Iso26262Reference.checkRow(
                        "✔ PASS",
                        "SG '" + name(sg) + "' [" + goalAsilStr + "] → ASIL decomposition to ["
                            + childSummary.toString().trim() + "] is valid per Table 5.",
                        Iso26262Reference.PART9_ASIL_TABLE5, null
                    ));
                }
            }
        }

        // ── Rule 3: FSR → TSR ASIL propagation ───────────────────────────────
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            if (fsr.getRefinedTo() == null) continue;
            int fsrRank = asilRank(((SafetyGoal) fsr).getAsilLevel());

            for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo()) {
                int tsrRank = asilRank(((SafetyGoal) tsr).getAsilLevel());
                if (tsrRank > fsrRank) {
                    failures.add(Iso26262Reference.checkRow(
                        "✘ FAIL",
                        "TSR '" + name(tsr) + "' ASIL=" + asilStr(((SafetyGoal) tsr).getAsilLevel())
                            + " exceeds parent FSR '" + name(fsr)
                            + "' ASIL=" + asilStr(((SafetyGoal) fsr).getAsilLevel()) + ".",
                        Iso26262Reference.PART9_ASIL_PROPAGATION,
                        "Derived requirements must not escalate the ASIL of their parent."
                    ));
                } else {
                    passes.add(Iso26262Reference.checkRow(
                        "✔ PASS",
                        "FSR '" + name(fsr) + "' [" + asilStr(((SafetyGoal) fsr).getAsilLevel()) + "] → TSR '"
                            + name(tsr) + "' [" + asilStr(((SafetyGoal) tsr).getAsilLevel()) + "] — propagation OK.",
                        Iso26262Reference.PART9_ASIL_PROPAGATION, null
                    ));
                }
            }
        }

        // ── Rule 4: ASIL D TSRs must be realizedBy ASIL D/C blocks ──────────
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            int tsrRank = asilRank(((SafetyGoal) tsr).getAsilLevel());
            if (tsrRank < 3) continue; // Only care about ASIL C and D

            if (tsr.getRealizedBy() == null || tsr.getRealizedBy().isEmpty()) continue;

            for (Object block : tsr.getRealizedBy()) {
                if (block instanceof SafetyCriticalBlock) {
                    SafetyCriticalBlock scb = (SafetyCriticalBlock) block;
                    int blockRank = asilRank(scb.getAsilLevel());
                    if (blockRank < tsrRank) {
                        warnings.add(Iso26262Reference.checkRow(
                            "⚠ WARNING",
                            "TSR '" + name(tsr) + "' [" + asilStr(((SafetyGoal) tsr).getAsilLevel())
                                + "] is realized by block '" + name(scb)
                                + "' with lower ASIL=" + asilStr(scb.getAsilLevel()) + ".",
                            Iso26262Reference.PART4_TSR_ALLOCATION,
                            "Blocks implementing high-ASIL requirements must themselves be classified at equivalent or higher ASIL."
                        ));
                    }
                }
            }
        }

        // ── Build report ─────────────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   ISO 26262 ASIL PROPAGATION & DECOMPOSITION VALIDATION  ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Primary Reference: ").append(Iso26262Reference.PART9_ASIL_DECOMPOSITION).append("\n");
        report.append("║  Decomp. Table:     ").append(Iso26262Reference.PART9_ASIL_TABLE5).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        report.append("ASIL Decomposition Table 5 (Part 9 §5.4.6):\n");
        report.append("  ASIL D → B(D) + B(D)   |  min child ASIL = B\n");
        report.append("  ASIL C → A(C) + B(C)   |  min child ASIL = A\n");
        report.append("  ASIL B → A(B) + A(B)   |  min child ASIL = A\n");
        report.append("  ASIL A → QM(A) + A(A)  |  min child ASIL = QM\n\n");

        appendSection(report, "FAILURES (" + failures.size() + ")", failures);
        appendSection(report, "WARNINGS (" + warnings.size() + ")", warnings);
        appendSection(report, "PASSED  (" + passes.size() + ")", passes);

        report.append("──────────────────────────────────────────────────────────\n");
        report.append("SUMMARY: ")
              .append(failures.size()).append(" failure(s), ")
              .append(warnings.size()).append(" warning(s), ")
              .append(passes.size()).append(" pass(es).\n");

        if (failures.isEmpty() && warnings.isEmpty()) {
            report.append("\n✔ All ASIL levels are correctly propagated and decomposed.\n");
        } else if (failures.isEmpty()) {
            report.append("\n⚠ ASIL propagation is valid but has architectural warnings.\n");
        } else {
            report.append("\n✘ ASIL VIOLATIONS DETECTED — review before functional safety assessment.\n");
        }

        report.append("\n").append(Iso26262Reference.REPORT_DISCLAIMER);
        showInfo("ASIL Propagation Validation", report.toString());
    }

    // ── ASIL helpers ─────────────────────────────────────────────────────────

    private int asilRank(Object asilLevel) {
        if (asilLevel == null) return 0;
        String key = asilLevel.toString().toUpperCase().trim();
        return ASIL_RANK.getOrDefault(key, 0);
    }

    private String asilStr(Object asilLevel) {
        return asilLevel != null ? asilLevel.toString() : "QM/unset";
    }

    /**
     * Per ISO 26262-9:2018 §5.4.6 Table 5, given the parent ASIL rank and
     * the minimum child ASIL rank, determine if decomposition is valid.
     * The minimum child ASIL determines the floor for valid decomposition.
     */
    private boolean isValidDecomposition(int parentRank, int minChildRank, int childCount) {
        if (childCount < 2) return true; // not a decomposition
        switch (parentRank) {
            case 4: return minChildRank >= 2; // ASIL D → children must be ≥ B
            case 3: return minChildRank >= 1; // ASIL C → children must be ≥ A
            case 2: return minChildRank >= 1; // ASIL B → children must be ≥ A
            case 1: return minChildRank >= 0; // ASIL A → children can be QM
            default: return true;
        }
    }

    private String getDecompositionGuidance(int parentRank) {
        switch (parentRank) {
            case 4: return "ASIL D decomposition requires both children to be at least ASIL B (ASIL B(D)).";
            case 3: return "ASIL C decomposition requires children to be ASIL A(C) and ASIL B(C) or higher.";
            case 2: return "ASIL B decomposition requires both children to be at least ASIL A (ASIL A(B)).";
            case 1: return "ASIL A decomposition requires one child to be QM(A) and the other ASIL A(A).";
            default: return "Decomposition of QM or unset ASIL is not meaningful.";
        }
    }

    private void appendSection(StringBuilder sb, String title, List<String> items) {
        sb.append("── ").append(title).append(" ──────────────────────────────────────────\n");
        if (items.isEmpty()) sb.append("   (none)\n");
        else items.forEach(sb::append);
        sb.append("\n");
    }

    private String name(EObject obj) {
        if (obj instanceof UnifiedElement) {
            String n = ((UnifiedElement) obj).getName();
            return n != null ? n : "<unnamed>";
        }
        return obj.eClass().getName();
    }

    private UnifiedSystemModel resolveModel(Collection<? extends EObject> selections) {
        if (selections == null || selections.isEmpty()) return null;
        EObject sel = selections.iterator().next();
        if (sel instanceof DSemanticDecorator) sel = ((DSemanticDecorator) sel).getTarget();
        return walkToModel(sel);
    }

    private UnifiedSystemModel walkToModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        return obj.eContainer() != null ? walkToModel(obj.eContainer()) : null;
    }

    private void showError(String title, String msg) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), title, msg));
    }

    private void showInfo(String title, String msg) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, msg));
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }
}