package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Checks that the Requirements Diagram is consistent with the Architecture Diagram:
 *
 *  Check A: Every TSR must be realized by at least one SafetyCriticalBlock.
 *           [ISO 26262-4:2018 §6.4.5.g — TSR Allocation to Architecture Elements]
 *
 *  Check B: Every ASIL C/D block must have at least one TSR allocated to it.
 *           [ISO 26262-4:2018 §6.4.5 — Safety Requirements Completeness]
 *
 *  Check C: Every SafetyMechanism must implement at least one TSR.
 *           [ISO 26262-4:2018 §7 — System Design]
 *
 *  Check D: TSRs allocated to a block must have ASIL ≤ the block's ASIL level.
 *           [ISO 26262-9:2018 §5.4.3 — ASIL Propagation]
 *
 *  Check E: Blocks implementing ASIL D safety mechanisms must have ASIL D.
 *           [ISO 26262-4:2018 §6.4.5.g]
 *
 * ISO 26262 References:
 *   ISO 26262-4:2018 §6.4.5   — Safety Requirement Consistency & Completeness
 *   ISO 26262-4:2018 §6.4.5.g — TSR Allocation to Architecture Elements
 *   ISO 26262-4:2018 §7       — System Design
 *   ISO 26262-9:2018 §5.4.3   — ASIL Inheritance & Propagation Rules
 */
public class CheckArchitectureConsistencyAction extends AbstractExternalJavaAction {

    private static final Map<String, Integer> ASIL_RANK = new LinkedHashMap<>();
    static {
        ASIL_RANK.put("QM", 0); ASIL_RANK.put("A", 1); ASIL_RANK.put("B", 2);
        ASIL_RANK.put("C", 3); ASIL_RANK.put("D", 4);
        ASIL_RANK.put("ASIL_A", 1); ASIL_RANK.put("ASIL_B", 2);
        ASIL_RANK.put("ASIL_C", 3); ASIL_RANK.put("ASIL_D", 4);
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

        // ── Check A: every TSR must have a realizedBy block ───────────────────
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            List<?> realizedBy = safeList(tsr, "realizedBy");
            if (realizedBy.isEmpty()) {
                String asil = ((SafetyCriticalBlock) tsr).getAsilLevel() != null ? ((SafetyCriticalBlock) tsr).getAsilLevel().toString() : "unset";
                boolean isHighAsil = asilRank(((SafetyCriticalBlock) tsr).getAsilLevel()) >= 3;
                (isHighAsil ? failures : warnings).add(Iso26262Reference.checkRow(
                    isHighAsil ? "✘ FAIL" : "⚠ WARNING",
                    "TSR '" + name(tsr) + "' [" + tsr.getRequirementId() + "] ASIL=" + asil
                        + " is not allocated to any architecture block.",
                    Iso26262Reference.PART4_TSR_ALLOCATION,
                    "Every TSR must be allocated to a system element in the architecture to close the safety argument."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "TSR '" + name(tsr) + "' allocated to " + realizedBy.size() + " block(s).",
                    Iso26262Reference.PART4_TSR_ALLOCATION, null
                ));

                // ── Check D: ASIL consistency between TSR and block ───────────
                for (Object blockObj : realizedBy) {
                    if (blockObj instanceof SafetyCriticalBlock) {
                        SafetyCriticalBlock block = (SafetyCriticalBlock) blockObj;
                        int tsrRank   = asilRank(tsr.getAllocatedASIL());
                        int blockRank = asilRank(block.getAsilLevel());
                        if (tsrRank > blockRank) {
                            warnings.add(Iso26262Reference.checkRow(
                                "⚠ WARNING",
                                "TSR '" + name(tsr) + "' [ASIL=" + tsr.getAllocatedASIL()
                                    + "] allocated to block '" + name(block)
                                    + "' [ASIL=" + block.getAsilLevel() + "] — ASIL mismatch.",
                                Iso26262Reference.PART9_ASIL_PROPAGATION,
                                "Block ASIL must be at least as high as the TSR ASIL it implements."
                            ));
                        }
                    }
                }
            }
        }

        // ── Check B: every ASIL C/D block must have ≥1 TSR allocated ────────
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            int blockRank = asilRank(block.getAsilLevel());
            if (blockRank < 3) continue; // only ASIL C/D

            boolean hasTSR = model.getTechnicalRequirements().stream()
                .anyMatch(tsr -> safeList(tsr, "realizedBy").contains(block));
            if (!hasTSR) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "ASIL " + block.getAsilLevel() + " block '" + name(block) + "' has no TSR allocated to it.",
                    Iso26262Reference.PART4_REQ_CONSISTENCY,
                    "High-ASIL blocks must implement at least one TSR to demonstrate safety requirement coverage."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "ASIL " + block.getAsilLevel() + " block '" + name(block) + "' has TSR allocation.",
                    Iso26262Reference.PART4_REQ_CONSISTENCY, null
                ));
            }
        }

        // ── Check C: every SafetyMechanism must implement ≥1 TSR ─────────────
        for (SafetyMechanism sm : model.getSafetyMechanisms()) {
            List<?> implements_ = safeList(sm, "implements");
            if (implements_.isEmpty()) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "Safety Mechanism '" + name(sm) + "' [" + sm.getMechanismType() + "] implements no TSR.",
                    Iso26262Reference.PART4_SYSTEM_DESIGN,
                    "Safety mechanisms should be linked to the TSRs they fulfil to close the design traceability."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "Safety Mechanism '" + name(sm) + "' implements " + implements_.size() + " TSR(s).",
                    Iso26262Reference.PART4_SYSTEM_DESIGN, null
                ));

                // ── Check E: ASIL D mechanisms should be on ASIL D blocks ────
                for (Object implObj : implements_) {
                    if (implObj instanceof TechnicalSafetyRequirement) {
                        TechnicalSafetyRequirement tsr = (TechnicalSafetyRequirement) implObj;
                        if (asilRank(((SafetyCriticalBlock) tsr).getAsilLevel()) >= 4) { // ASIL D
                            // verify it's realized on an ASIL D block
                            safeList(tsr, "realizedBy").stream()
                                .filter(b -> b instanceof SafetyCriticalBlock)
                                .map(b -> (SafetyCriticalBlock) b)
                                .filter(b -> asilRank(b.getAsilLevel()) < 4)
                                .forEach(b -> warnings.add(Iso26262Reference.checkRow(
                                    "⚠ WARNING",
                                    "Safety Mechanism '" + name(sm) + "' implements ASIL D TSR '"
                                        + name(tsr) + "' but block '" + name(b)
                                        + "' is only ASIL " + b.getAsilLevel() + ".",
                                    Iso26262Reference.PART4_TSR_ALLOCATION,
                                    "ASIL D mechanisms must be hosted on ASIL D classified elements."
                                )));
                        }
                    }
                }
            }
        }

        // ── Build report ─────────────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   ISO 26262 REQUIREMENTS–ARCHITECTURE CONSISTENCY        ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Primary Reference: ").append(Iso26262Reference.PART4_REQ_CONSISTENCY).append("\n");
        report.append("║  Allocation Ref:    ").append(Iso26262Reference.PART4_TSR_ALLOCATION).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        report.append("Scope: ").append(model.getTechnicalRequirements().size())
              .append(" TSR(s), ").append(model.getRootBlocks().size())
              .append(" safety block(s), ").append(model.getSafetyMechanisms().size())
              .append(" mechanism(s)\n\n");

        appendSection(report, "FAILURES (" + failures.size() + ")", failures);
        appendSection(report, "WARNINGS (" + warnings.size() + ")", warnings);
        appendSection(report, "PASSED  (" + passes.size() + ")", passes);

        report.append("──────────────────────────────────────────────────────────\n");
        if (failures.isEmpty() && warnings.isEmpty()) {
            report.append("✔ Requirements and architecture are FULLY CONSISTENT.\n");
        } else if (failures.isEmpty()) {
            report.append("⚠ Minor consistency gaps — review warnings.\n");
        } else {
            report.append("✘ CONSISTENCY FAILURES detected — safety argument is incomplete.\n");
        }

        report.append("\n").append(Iso26262Reference.REPORT_DISCLAIMER);
        showInfo("Requirements–Architecture Consistency", report.toString());
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
            // Reflective EMF fallback
            org.eclipse.emf.ecore.EStructuralFeature f = obj.eClass().getEStructuralFeature(featureName);
            if (f != null) {
                Object val = obj.eGet(f);
                if (val instanceof List) return (List) val;
            }
        }
        return Collections.emptyList();
    }

    private int asilRank(Object asilLevel) {
        if (asilLevel == null) return 0;
        return ASIL_RANK.getOrDefault(asilLevel.toString().toUpperCase().trim(), 0);
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