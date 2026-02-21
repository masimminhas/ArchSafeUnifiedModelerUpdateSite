package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Validates the completeness of the Hazard Analysis and Risk Assessment (HARA)
 * as required by ISO 26262-3:2018 §7.
 *
 * Checks performed:
 *  (a) Every IntegratedHazard has a risk level assigned               [§7.4.2]
 *  (b) HIGH/CRITICAL hazards have exactly one Safety Goal             [§8.4.1]
 *  (c) Every Safety Goal has an ASIL level assigned                   [§8.4.1]
 *  (d) Every Safety Goal references a hazard (no orphaned goals)      [§8.4]
 *  (e) Every Safety Goal has non-empty requirement text                [§8.4]
 *  (f) Model has at least one hazard and one safety goal               [§7, §8]
 *
 * ISO 26262 References:
 *   ISO 26262-3:2018 §7  — Hazard Analysis and Risk Assessment
 *   ISO 26262-3:2018 §8  — Functional Safety Concept
 */
public class ValidateHARACompletenessAction extends AbstractExternalJavaAction {

    // Risk levels considered high enough to require a Safety Goal
    private static final Set<String> HIGH_RISK_LEVELS =
        new HashSet<>(Arrays.asList("HIGH", "CRITICAL", "CATASTROPHIC",
                                    "HIGH_RISK", "VERY_HIGH", "UNACCEPTABLE"));

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

        // ── (f) model-level presence check ───────────────────────────────────
        if (model.getGlobalHazards().isEmpty()) {
            failures.add(Iso26262Reference.checkRow(
                "✘ FAIL", "No hazards defined in the model.",
                Iso26262Reference.PART3_HARA,
                "HARA must identify and classify all relevant hazardous events before safety goals can be derived."
            ));
        }
        if (model.getSafetyGoals().isEmpty()) {
            failures.add(Iso26262Reference.checkRow(
                "✘ FAIL", "No Safety Goals defined in the model.",
                Iso26262Reference.PART3_SAFETY_GOALS,
                "At least one Safety Goal must be derived from the HARA for each relevant hazardous event."
            ));
        }

        // ── (a) every hazard must have a risk level ──────────────────────────
        for (IntegratedHazard hazard : model.getGlobalHazards()) {
            Object riskLevel = hazard.getRiskLevel();
            if (riskLevel == null) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Hazard '" + name(hazard) + "' has no risk level (S/E/C classification missing).",
                    Iso26262Reference.PART3_HARA_CLASSIFICATION,
                    "Risk level must be determined by evaluating Severity, Exposure, and Controllability."
                ));
                continue;
            }

            String riskStr = riskLevel.toString();
            boolean isHighRisk = HIGH_RISK_LEVELS.contains(riskStr.toUpperCase().replace(" ", "_"))
                               || riskStr.toUpperCase().contains("HIGH")
                               || riskStr.toUpperCase().contains("CRITICAL");

            passes.add(Iso26262Reference.checkRow(
                "✔ PASS",
                "Hazard '" + name(hazard) + "' risk level = " + riskStr + ".",
                Iso26262Reference.PART3_HARA_CLASSIFICATION, null
            ));

            // ── (b) high-risk hazards require a Safety Goal ──────────────────
            if (isHighRisk) {
                List<SafetyGoal> linkedGoals = new ArrayList<>();
                for (SafetyGoal sg : model.getSafetyGoals()) {
                    if (sg.getRelatedHazard() == hazard) linkedGoals.add(sg);
                }
                if (linkedGoals.isEmpty()) {
                    failures.add(Iso26262Reference.checkRow(
                        "✘ FAIL",
                        "HIGH/CRITICAL hazard '" + name(hazard) + "' has no Safety Goal.",
                        Iso26262Reference.PART3_SAFETY_GOALS,
                        "Risk level '" + riskStr + "' requires a Safety Goal with an ASIL assignment."
                    ));
                } else {
                    passes.add(Iso26262Reference.checkRow(
                        "✔ PASS",
                        "Hazard '" + name(hazard) + "' → " + linkedGoals.size() + " Safety Goal(s) defined.",
                        Iso26262Reference.PART3_SAFETY_GOALS, null
                    ));
                }
            }
        }

        // ── (c) every Safety Goal must have an ASIL level ────────────────────
        // ── (d) every Safety Goal must reference a hazard ────────────────────
        // ── (e) every Safety Goal must have requirement text ─────────────────
        for (SafetyGoal sg : model.getSafetyGoals()) {

            if (sg.getAsilLevel() == null) {
                failures.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Safety Goal '" + name(sg) + "' [" + sg.getRequirementId() + "] has no ASIL level.",
                    Iso26262Reference.PART3_SAFETY_GOAL_ASIL,
                    "ASIL must be assigned using the HARA risk classification (S, E, C) per Part 3 §7.4.3."
                ));
            } else {
                passes.add(Iso26262Reference.checkRow(
                    "✔ PASS",
                    "Safety Goal '" + name(sg) + "' ASIL=" + sg.getAsilLevel() + " assigned.",
                    Iso26262Reference.PART3_SAFETY_GOAL_ASIL, null
                ));
            }

            if (sg.getRelatedHazard() == null) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "Safety Goal '" + name(sg) + "' is not linked to any hazard.",
                    Iso26262Reference.PART3_HARA,
                    "Orphaned Safety Goals cannot be traced to a hazardous event — traceability gap."
                ));
            }

            String reqText = sg.getRequirementText();
            if (reqText == null || reqText.trim().isEmpty()) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "Safety Goal '" + name(sg) + "' has no requirement text.",
                    Iso26262Reference.PART8_REQ_MANAGEMENT,
                    "Safety goals must be formally stated as requirements to constitute a valid work product."
                ));
            }
        }

        // ── Build report ─────────────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   ISO 26262 HARA COMPLETENESS VALIDATION                 ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Primary Reference: ").append(Iso26262Reference.PART3_HARA).append("\n");
        report.append("║  Work Product:      ").append(Iso26262Reference.WP_3_8_HARA_REPORT).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        report.append("Scope: ").append(model.getGlobalHazards().size()).append(" hazard(s), ")
              .append(model.getSafetyGoals().size()).append(" Safety Goal(s)\n\n");

        appendSection(report, "FAILURES (" + failures.size() + ")", failures);
        appendSection(report, "WARNINGS (" + warnings.size() + ")", warnings);
        appendSection(report, "PASSED  (" + passes.size() + ")", passes);

        report.append("──────────────────────────────────────────────────────────\n");
        report.append("SUMMARY: ")
              .append(failures.size()).append(" failure(s), ")
              .append(warnings.size()).append(" warning(s), ")
              .append(passes.size()).append(" pass(es).\n");

        if (failures.isEmpty() && warnings.isEmpty()) {
            report.append("\n✔ HARA is COMPLETE and satisfies ISO 26262-3:2018 §7 requirements.\n");
        } else if (failures.isEmpty()) {
            report.append("\n⚠ HARA is structurally complete but has quality warnings.\n");
        } else {
            report.append("\n✘ HARA has CRITICAL GAPS — safety assessment cannot proceed.\n");
        }

        report.append("\n").append(Iso26262Reference.REPORT_DISCLAIMER);
        showInfo("HARA Completeness Validation", report.toString());
    }

    // ── helpers ──────────────────────────────────────────────────────────────

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