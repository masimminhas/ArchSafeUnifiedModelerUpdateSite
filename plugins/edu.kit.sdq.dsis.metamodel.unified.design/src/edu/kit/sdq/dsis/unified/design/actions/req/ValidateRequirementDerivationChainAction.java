package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Validates the complete ISO 26262 safety requirement derivation chain:
 *
 *   IntegratedHazard
 *     └─[addresses]→ SafetyGoal        (Part 3 §8)
 *         └─[allocates to]→ FunctionalSafetyRequirement   (Part 3 §8.4)
 *             └─[refines to]→ TechnicalSafetyRequirement  (Part 4 §6)
 *                 └─[implemented by]→ SafetyMechanism     (Part 4 §7)
 *
 * Every broken link is reported with the exact ISO 26262 clause it violates.
 *
 * ISO 26262 References:
 *   Primary:  ISO 26262-4:2018 §6.4.5 — Safety Requirement Consistency & Completeness
 *   Secondary: ISO 26262-3:2018 §8 — Functional Safety Concept
 *              ISO 26262-4:2018 §7  — System Design & Requirements Derivation
 */
public class ValidateRequirementDerivationChainAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select or open a UnifiedSystemModel.");
            return;
        }

        List<String> failures  = new ArrayList<>();
        List<String> warnings  = new ArrayList<>();
        List<String> passes    = new ArrayList<>();

        // ── 1. Every hazard must have a SafetyGoal ───────────────────────────
        for (IntegratedHazard hazard : model.getGlobalHazards()) {
            boolean hasGoal = model.getSafetyGoals().stream()
                .anyMatch(sg -> sg.getRelatedHazard() == hazard);
            if (!hasGoal) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Hazard '" + name(hazard) + "' has no Safety Goal.",
                    Iso26262Reference.PART3_SAFETY_GOALS,
                    "Every hazardous event must be addressed by at least one Safety Goal."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "Hazard '" + name(hazard) + "' → Safety Goal link exists.",
                    Iso26262Reference.PART3_SAFETY_GOALS, null
                ));
            }
        }

        // ── 2. Every SafetyGoal must have an ASIL level ──────────────────────
        for (SafetyGoal sg : model.getSafetyGoals()) {
            if (sg.getAsilLevel() == null) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Safety Goal '" + name(sg) + "' has no ASIL level.",
                    Iso26262Reference.PART3_SAFETY_GOAL_ASIL,
                    "ASIL must be assigned based on HARA classification (S/E/C)."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "Safety Goal '" + name(sg) + "' ASIL=" + sg.getAsilLevel() + " assigned.",
                    Iso26262Reference.PART3_SAFETY_GOAL_ASIL, null
                ));
            }

            // ── 3. Every SafetyGoal must allocate at least one FSR ───────────
            if (sg.getAllocatedTo() == null || sg.getAllocatedTo().isEmpty()) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Safety Goal '" + name(sg) + "' has no allocated Functional Safety Requirement.",
                    Iso26262Reference.PART3_SAFETY_GOALS,
                    "Safety goals must be allocated to FSRs in the Functional Safety Concept."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "Safety Goal '" + name(sg) + "' → " + sg.getAllocatedTo().size() + " FSR(s) allocated.",
                    Iso26262Reference.PART3_SAFETY_GOALS, null
                ));
            }
        }

        // ── 4. Every FSR must refine to at least one TSR ─────────────────────
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            if (fsr.getRefinedTo() == null || fsr.getRefinedTo().isEmpty()) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "FSR '" + name(fsr) + "' [" + fsr.getRequirementId() + "] has no Technical Safety Requirement.",
                    Iso26262Reference.PART4_TECHNICAL_SAFETY_CONCEPT,
                    "Each FSR must be refined into one or more TSRs in the Technical Safety Concept."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "FSR '" + name(fsr) + "' → " + fsr.getRefinedTo().size() + " TSR(s) refined.",
                    Iso26262Reference.PART4_TECHNICAL_SAFETY_CONCEPT, null
                ));
            }

            // ── 5. FSR must be allocated to a Safety Goal ────────────────────
            boolean allocatedToGoal = model.getSafetyGoals().stream()
                .anyMatch(sg -> sg.getAllocatedTo() != null && sg.getAllocatedTo().contains(fsr));
            if (!allocatedToGoal) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "FSR '" + name(fsr) + "' is not allocated from any Safety Goal.",
                    Iso26262Reference.PART3_SAFETY_GOALS,
                    "Orphaned FSRs cannot be traced back to a hazard — traceability gap."
                ));
            }
        }

        // ── 6. Every TSR must have at least one implementing SafetyMechanism ─
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            boolean hasMechanism = model.getSafetyMechanisms().stream()
                .anyMatch(sm -> sm.getImplements() != null && sm.getImplements().contains(tsr));
            if (!hasMechanism) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "TSR '" + name(tsr) + "' [" + tsr.getRequirementId() + "] has no implementing Safety Mechanism.",
                    Iso26262Reference.PART4_SYSTEM_DESIGN,
                    "TSRs should be implemented by at least one Safety Mechanism in the system design."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "TSR '" + name(tsr) + "' → Safety Mechanism link exists.",
                    Iso26262Reference.PART4_SYSTEM_DESIGN, null
                ));
            }

            // ── 7. TSR must be refined from an FSR ──────────────────────────
            boolean refinedFromFSR = model.getFunctionalRequirements().stream()
                .anyMatch(fsr -> fsr.getRefinedTo() != null && fsr.getRefinedTo().contains(tsr));
            if (!refinedFromFSR) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "TSR '" + name(tsr) + "' is not derived from any FSR.",
                    Iso26262Reference.PART4_REQ_CONSISTENCY,
                    "Every TSR must be traceable to a Functional Safety Requirement."
                ));
            }
        }

        // ── Build and show report ────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   ISO 26262 REQUIREMENT DERIVATION CHAIN VALIDATION      ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Primary Reference: ").append(Iso26262Reference.PART4_REQ_CONSISTENCY).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        report.append("Chain validated:  Hazard → SafetyGoal → FSR → TSR → SafetyMechanism\n\n");

        appendSection(report, "FAILURES (" + failures.size() + ")", failures);
        appendSection(report, "WARNINGS (" + warnings.size() + ")", warnings);
        appendSection(report, "PASSED  (" + passes.size() + ")", passes);

        report.append("──────────────────────────────────────────────────────────\n");
        report.append("SUMMARY: ")
              .append(failures.size()).append(" failure(s), ")
              .append(warnings.size()).append(" warning(s), ")
              .append(passes.size()).append(" pass(es).\n\n");

        if (failures.isEmpty() && warnings.isEmpty()) {
            report.append("✔ Full requirement derivation chain is COMPLETE and CONSISTENT.\n");
        } else if (failures.isEmpty()) {
            report.append("⚠ Chain is traceable but has gaps — review warnings before gate review.\n");
        } else {
            report.append("✘ Chain has BROKEN LINKS — address failures before safety assessment.\n");
        }

        report.append("\n").append(Iso26262Reference.REPORT_DISCLAIMER);

        showInfo("Requirement Derivation Chain Validation", report.toString());
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private void appendSection(StringBuilder sb, String title, List<String> items) {
        sb.append("── ").append(title).append(" ──────────────────────────────────────────\n");
        if (items.isEmpty()) {
            sb.append("   (none)\n");
        } else {
            items.forEach(sb::append);
        }
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