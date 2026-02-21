package edu.kit.sdq.dsis.unified.design.actions.req;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import unified.*;

/**
 * Exports a structured Safety Case Fragment as a plain-text file.
 *
 * A Safety Case is a structured argument that the system is safe for a given
 * application in a given operating environment (ISO 26262-2 §5.5). This action
 * produces the requirements-layer fragment of that case: for each Safety Goal
 * it traces the complete argument chain down to Safety Mechanisms, and annotates
 * every claim with the relevant ISO 26262 clause.
 *
 * The output format is suitable for:
 *   - Direct import into a GSN (Goal Structuring Notation) tool
 *   - Attachment to a Functional Safety Assessment package
 *   - Review by an independent FSA
 *
 * ISO 26262 References:
 *   ISO 26262-2:2018 §5.5   — Functional Safety Assessment
 *   ISO 26262-2:2018 §6.4   — Safety Plan & Work Product Approval
 *   ISO 26262-3:2018 §8     — Functional Safety Concept
 *   ISO 26262-4:2018 §6.4.5 — Safety Requirement Consistency & Completeness
 */
public class ExportSafetyCaseAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select a UnifiedSystemModel.");
            return;
        }

        Shell shell = Display.getDefault().getActiveShell();
        FileDialog dialog = new FileDialog(shell, SWT.SAVE);
        dialog.setFilterNames(new String[]{"Text Files (*.txt)", "All Files (*.*)"});
        dialog.setFilterExtensions(new String[]{"*.txt", "*.*"});
        dialog.setFileName("SafetyCaseFragment_"
            + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt");

        String path = dialog.open();
        if (path == null) return;

        try {
            writeSafetyCase(model, path);
            showInfo("Export Successful", "Safety Case Fragment exported to:\n" + path);
        } catch (IOException e) {
            showError("Export Failed", e.getMessage());
        }
    }

    private void writeSafetyCase(UnifiedSystemModel model, String path) throws IOException {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {

            pw.println("╔══════════════════════════════════════════════════════════════════╗");
            pw.println("║         ISO 26262:2018 SAFETY CASE FRAGMENT                      ║");
            pw.println("║         Requirements Layer — Goal Structuring Argument            ║");
            pw.println("╠══════════════════════════════════════════════════════════════════╣");
            pw.println("║  Generated:  " + padRight(now, 52) + "║");
            pw.println("║  Standard:   ISO 26262:2018 (Road Vehicles — Functional Safety)  ║");
            pw.println("╚══════════════════════════════════════════════════════════════════╝");
            pw.println();
            pw.println("NORMATIVE BASIS:");
            pw.println("  " + Iso26262Reference.PART2_SAFETY_PLAN);
            pw.println("  " + Iso26262Reference.PART3_SAFETY_GOALS);
            pw.println("  " + Iso26262Reference.PART4_REQ_CONSISTENCY);
            pw.println("  " + Iso26262Reference.PART9_ASIL_DECOMPOSITION);
            pw.println();
            pw.println("TOP-LEVEL CLAIM:");
            pw.println("  G0: The system satisfies all safety goals derived from the HARA");
            pw.println("      as required by " + Iso26262Reference.PART3_HARA + ".");
            pw.println();
            pw.println("SUPPORTING EVIDENCE COUNT:");
            pw.println("  Hazards identified:      " + model.getGlobalHazards().size());
            pw.println("  Safety Goals:            " + model.getSafetyGoals().size());
            pw.println("  Functional Safety Req.:  " + model.getFunctionalRequirements().size());
            pw.println("  Technical Safety Req.:   " + model.getTechnicalRequirements().size());
            pw.println("  Safety Mechanisms:       " + model.getSafetyMechanisms().size());
            pw.println();
            pw.println("═══════════════════════════════════════════════════════════════════");
            pw.println("SAFETY GOAL ARGUMENTS");
            pw.println("═══════════════════════════════════════════════════════════════════");

            int goalIdx = 1;
            for (SafetyGoal sg : model.getSafetyGoals()) {
                writeGoalArgument(pw, sg, model, goalIdx++);
            }

            // Summary of unlinked hazards
            List<IntegratedHazard> unlinkedHazards = new ArrayList<>();
            for (IntegratedHazard h : model.getGlobalHazards()) {
                boolean linked = model.getSafetyGoals().stream()
                    .anyMatch(sg -> sg.getRelatedHazard() == h);
                if (!linked) unlinkedHazards.add(h);
            }

            if (!unlinkedHazards.isEmpty()) {
                pw.println();
                pw.println("═══════════════════════════════════════════════════════════════════");
                pw.println("OPEN ITEMS — HAZARDS WITHOUT SAFETY GOALS");
                pw.println("  Clause: " + Iso26262Reference.PART3_SAFETY_GOALS);
                pw.println("═══════════════════════════════════════════════════════════════════");
                pw.println("  The following hazards are NOT addressed by any Safety Goal.");
                pw.println("  This is a compliance gap that must be resolved:");
                pw.println();
                for (IntegratedHazard h : unlinkedHazards) {
                    pw.println("  ✘ " + name(h) + " [Risk: " + h.getRiskLevel() + "]");
                }
            }

            pw.println();
            pw.println("═══════════════════════════════════════════════════════════════════");
            pw.println("DISCLAIMER");
            pw.println("═══════════════════════════════════════════════════════════════════");
            pw.println(Iso26262Reference.REPORT_DISCLAIMER);
        }
    }

    private void writeGoalArgument(PrintWriter pw, SafetyGoal sg, UnifiedSystemModel model, int idx) {
        pw.println();
        pw.println("───────────────────────────────────────────────────────────────────");
        pw.println("G" + idx + ": " + name(sg) + " [" + sg.getRequirementId() + "]");
        pw.println("───────────────────────────────────────────────────────────────────");
        pw.println("  ASIL Level:  " + asilStr(sg.getAsilLevel()));
        pw.println("  Status:      " + statusStr(sg.getStatus()));
        pw.println("  Clause:      " + Iso26262Reference.PART3_SAFETY_GOAL_ASIL);

        if (sg.getRequirementText() != null && !sg.getRequirementText().trim().isEmpty()) {
            pw.println("  Statement:   " + sg.getRequirementText());
        }

        // Linked hazard
        pw.println();
        pw.println("  CONTEXT — Hazard Addressed:");
        pw.println("  Clause: " + Iso26262Reference.PART3_HARA);
        if (sg.getRelatedHazard() != null) {
            IntegratedHazard h = sg.getRelatedHazard();
            pw.println("    ✔ " + name(h) + " [Risk Level: " + h.getRiskLevel() + "]");
        } else {
            pw.println("    ✘ NOT LINKED — compliance gap per " + Iso26262Reference.PART3_HARA);
        }

        // Allocated FSRs
        pw.println();
        pw.println("  STRATEGY — Functional Safety Requirements (ISO 26262-3:2018 §8.4):");
        pw.println("  Clause: " + Iso26262Reference.PART3_SAFETY_GOALS);
        List<FunctionalSafetyRequirement> fsrs =
            sg.getAllocatedTo() != null ? sg.getAllocatedTo() : Collections.emptyList();
        if (fsrs.isEmpty()) {
            pw.println("    ✘ No FSRs allocated — compliance gap.");
        } else {
            for (FunctionalSafetyRequirement fsr : fsrs) {
                pw.println("    ✔ FSR [" + fsr.getRequirementId() + "] " + name(fsr)
                    + " | ASIL=" + asilStr(((SafetyGoal) fsr).getAsilLevel())
                    + " | Status=" + statusStr(fsr.getStatus()));

                // Derived TSRs
                List<TechnicalSafetyRequirement> tsrs =
                    fsr.getRefinedTo() != null ? fsr.getRefinedTo() : Collections.emptyList();
                if (tsrs.isEmpty()) {
                    pw.println("       ✘ No TSRs derived — compliance gap per "
                        + Iso26262Reference.PART4_TECHNICAL_SAFETY_CONCEPT);
                } else {
                    pw.println("       Derived Technical Safety Requirements:");
                    pw.println("       Clause: " + Iso26262Reference.PART4_REQ_CONSISTENCY);
                    for (TechnicalSafetyRequirement tsr : tsrs) {
                        List<?> realizedBy = safeList(tsr, "realizedBy");
                        int fmeaCount = countFMEAForTSR(model, tsr);

                        pw.println("       ├─ TSR [" + tsr.getRequirementId() + "] " + name(tsr));
                        pw.println("       │   ASIL=" + asilStr(((SafetyGoal) tsr).getAsilLevel())
                            + " | Status=" + statusStr(tsr.getStatus()));

                        if (realizedBy.isEmpty()) {
                            pw.println("       │   ✘ NOT ALLOCATED to any block — gap per "
                                + Iso26262Reference.PART4_TSR_ALLOCATION);
                        } else {
                            String blocks = realizedBy.stream()
                                .filter(b -> b instanceof EObject)
                                .map(b -> name((EObject) b))
                                .reduce((a, b) -> a + ", " + b).orElse("?");
                            pw.println("       │   ✔ Realized by: " + blocks
                                + " [" + Iso26262Reference.PART4_TSR_ALLOCATION + "]");
                        }

                        if (fmeaCount == 0) {
                            pw.println("       │   ⚠ No FMEA verification evidence ["
                                + Iso26262Reference.PART4_TSR_VERIFICATION + "]");
                        } else {
                            pw.println("       │   ✔ " + fmeaCount + " FMEA verification item(s) ["
                                + Iso26262Reference.PART4_TSR_VERIFICATION + "]");
                        }

                        // Safety mechanisms
                        List<SafetyMechanism> mechanisms = getMechanismsForTSR(model, tsr);
                        if (!mechanisms.isEmpty()) {
                            pw.println("       │   Safety Mechanisms [" + Iso26262Reference.PART4_SYSTEM_DESIGN + "]:");
                            for (SafetyMechanism sm : mechanisms) {
                                pw.println("       │     → " + name(sm) + " [" + sm.getMechanismType() + "]");
                            }
                        }
                        pw.println("       │");
                    }
                }
            }
        }
    }

    private int countFMEAForTSR(UnifiedSystemModel model, TechnicalSafetyRequirement tsr) {
        int count = 0;
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (safeList(item, "relatedRequirements").contains(tsr)) count++;
            }
        }
        return count;
    }

    private List<SafetyMechanism> getMechanismsForTSR(UnifiedSystemModel model, TechnicalSafetyRequirement tsr) {
        List<SafetyMechanism> result = new ArrayList<>();
        for (SafetyMechanism sm : model.getSafetyMechanisms()) {
            if (safeList(sm, "implements").contains(tsr)) result.add(sm);
        }
        return result;
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    @SuppressWarnings({"rawtypes"})
    private List<?> safeList(EObject obj, String featureName) {
        try {
            java.lang.reflect.Method m = obj.getClass().getMethod(
                "get" + Character.toUpperCase(featureName.charAt(0)) + featureName.substring(1));
            Object result = m.invoke(obj);
            if (result instanceof List) return (List) result;
        } catch (Exception ignored) {
            org.eclipse.emf.ecore.EStructuralFeature f = obj.eClass().getEStructuralFeature(featureName);
            if (f != null) {
                Object val = obj.eGet(f);
                if (val instanceof List) return (List) val;
            }
        }
        return Collections.emptyList();
    }

    private String asilStr(Object asil)     { return asil != null ? asil.toString() : "unset"; }
    private String statusStr(Object status)  { return status != null ? status.toString() : "DRAFT"; }
    private String padRight(String s, int n) { return String.format("%-" + n + "s", s); }

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