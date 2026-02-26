package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Batch-promotes safety requirement work products through the ISO 26262
 * approval lifecycle:
 *
 *   DRAFT  →  IN_REVIEW  →  APPROVED
 *
 * The user selects a target status from a dialog. Only work products in the
 * immediately preceding status are promoted (e.g. selecting "Promote to
 * IN_REVIEW" only advances DRAFT items; it does not skip IN_REVIEW items to
 * APPROVED). Items already at the target status or beyond are not touched.
 * Items in REJECTED status are excluded from automatic promotion and listed
 * for manual rework.
 *
 * After promotion, a summary lists every promoted item with the ISO 26262
 * clause justifying the status change.
 *
 * ISO 26262 References:
 *   ISO 26262-2:2018 §6.4   — Safety Plan & Work Product Approval
 *   ISO 26262-2:2018 §6.4.9 — Confirmation Review of Safety Work Products
 *   ISO 26262-8:2018 §9     — Configuration Management of Safety Work Products
 */
public class PromoteRequirementStatusAction extends AbstractExternalJavaAction {

    // Target status options shown to the user
    private static final String[] TARGETS    = {"IN_REVIEW", "APPROVED"};
    private static final String[] PREREQS    = {"DRAFT",     "IN_REVIEW"};   // predecessor status
    private static final String[] LABELS     = {
        "Promote DRAFT → IN_REVIEW\n(Send for confirmation review — ISO 26262-2:2018 §6.4.9)",
        "Promote IN_REVIEW → APPROVED\n(Mark confirmation review complete — ISO 26262-2:2018 §6.4)"
    };

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select a UnifiedSystemModel.");
            return;
        }

        // ── Ask user which promotion to perform ───────────────────────────────
        final int[] choice = {-1};
        Display.getDefault().syncExec(() -> {
            MessageDialog dlg = new MessageDialog(
                Display.getDefault().getActiveShell(),
                "Promote Requirement Status — ISO 26262-2:2018 §6.4",
                null,
                "Select the status transition to perform.\n\n"
                    + "This operation advances safety work products through the approval\n"
                    + "lifecycle required by ISO 26262-2:2018 §6.4 and §6.4.9.\n\n"
                    + "Only items in the prerequisite status are promoted.\n"
                    + "Rejected items require manual rework and are excluded.",
                MessageDialog.QUESTION,
                new String[]{LABELS[0], LABELS[1], "Cancel"},
                0
            );
            choice[0] = dlg.open();
        });

        if (choice[0] == 2 || choice[0] == -1) return; // cancelled

        String prereqStatus = PREREQS[choice[0]];
        String targetStatus  = TARGETS[choice[0]];
        String clauseRef     = choice[0] == 0
            ? Iso26262Reference.PART2_CONFIRMATION_REVIEW
            : Iso26262Reference.PART2_SAFETY_PLAN;

        // ── Perform promotion ─────────────────────────────────────────────────
        List<String> promoted  = new ArrayList<>();
        List<String> skipped   = new ArrayList<>();
        List<String> rejected  = new ArrayList<>();

        // Safety Goals
        for (SafetyGoal sg : model.getSafetyGoals()) {
            String label = "Safety Goal [" + sg.getRequirementId() + "] " + name(sg);
            String result = tryPromote(sg, "status", prereqStatus, targetStatus);
            categorise(result, label, promoted, skipped, rejected);
        }

        // Functional Safety Requirements
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            String label = "FSR [" + fsr.getRequirementId() + "] " + name(fsr);
            String result = tryPromote(fsr, "status", prereqStatus, targetStatus);
            categorise(result, label, promoted, skipped, rejected);
        }

        // Technical Safety Requirements
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            String label = "TSR [" + tsr.getRequirementId() + "] " + name(tsr);
            String result = tryPromote(tsr, "status", prereqStatus, targetStatus);
            categorise(result, label, promoted, skipped, rejected);
        }

        // Trigger Sirius session save if any changes were made
        if (!promoted.isEmpty()) {
            try {
                Session session = SessionManager.INSTANCE.getSession(model);
                if (session != null) {
                    session.save(new org.eclipse.core.runtime.NullProgressMonitor());
                }
            } catch (Exception ignored) { /* best effort */ }
        }

        // ── Build result summary ──────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   REQUIREMENT STATUS PROMOTION COMPLETE                  ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Transition:   ").append(prereqStatus).append(" → ").append(targetStatus).append("\n");
        report.append("║  ISO Clause:   ").append(clauseRef).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        if (!promoted.isEmpty()) {
            report.append("✔ PROMOTED (").append(promoted.size()).append("):\n");
            promoted.forEach(s -> report.append("   → ").append(s).append("\n"));
            report.append("\n");
        }

        if (!rejected.isEmpty()) {
            report.append("✘ EXCLUDED — REJECTED STATUS — requires rework (").append(rejected.size()).append("):\n");
            report.append("   Ref: ").append(Iso26262Reference.PART2_CONFIRMATION_REVIEW).append("\n");
            rejected.forEach(s -> report.append("   ✘ ").append(s).append("\n"));
            report.append("\n");
        }

        if (!skipped.isEmpty()) {
            report.append("○ SKIPPED — already at or beyond target status (").append(skipped.size()).append("):\n");
            skipped.forEach(s -> report.append("   ○ ").append(s).append("\n"));
            report.append("\n");
        }

        report.append("──────────────────────────────────────────────────────────\n");
        report.append("SUMMARY: ").append(promoted.size()).append(" promoted, ")
              .append(rejected.size()).append(" excluded (REJECTED), ")
              .append(skipped.size()).append(" skipped.\n");

        if (promoted.isEmpty() && rejected.isEmpty()) {
            report.append("\nNo items were in '").append(prereqStatus).append("' status — nothing to promote.\n");
        }

        report.append("\nRef: ").append(Iso26262Reference.PART8_CONFIG_MANAGEMENT);

        showInfo("Status Promotion Complete", report.toString());
    }

    // ── Status promotion logic ────────────────────────────────────────────────

    /**
     * Returns "PROMOTED", "REJECTED", or "SKIPPED".
     * Uses EMF reflective API to set the status feature without needing the
     * generated setter to be compiled.
     */
    private String tryPromote(EObject obj, String featureName, String prereq, String target) {
        org.eclipse.emf.ecore.EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) return "SKIPPED";

        Object currentStatus = obj.eGet(feature);
        String currentStr = currentStatus != null ? currentStatus.toString().toUpperCase() : "DRAFT";

        if (currentStr.contains("REJECT")) return "REJECTED";
        if (!currentStr.contains(prereq.toUpperCase())) return "SKIPPED";

        // Find the enum literal for the target status
        try {
            // Try to resolve the target as an enum literal from the feature's EType
            if (feature.getEType() instanceof org.eclipse.emf.ecore.EEnum) {
                org.eclipse.emf.ecore.EEnum eEnum = (org.eclipse.emf.ecore.EEnum) feature.getEType();
                org.eclipse.emf.ecore.EEnumLiteral literal = null;
                // Try exact name first, then case-insensitive
                for (org.eclipse.emf.ecore.EEnumLiteral l : eEnum.getELiterals()) {
                    if (l.getName().equalsIgnoreCase(target) || l.getLiteral().equalsIgnoreCase(target)) {
                        literal = l;
                        break;
                    }
                }
                // Also try "UNDER_REVIEW", "REVIEW", "APPROVED" variants
                if (literal == null) {
                    for (org.eclipse.emf.ecore.EEnumLiteral l : eEnum.getELiterals()) {
                        if (l.getName().toUpperCase().contains(target.replace("_", ""))
                            || target.contains(l.getName().toUpperCase().replace("_", ""))) {
                            literal = l;
                            break;
                        }
                    }
                }
                if (literal != null) {
                    obj.eSet(feature, literal.getInstance());
                    return "PROMOTED";
                }
            }
        } catch (Exception e) {
            // If reflection fails, we cannot promote
        }
        return "SKIPPED";
    }

    private void categorise(String result, String label,
                             List<String> promoted, List<String> skipped, List<String> rejected) {
        switch (result) {
            case "PROMOTED": promoted.add(label);  break;
            case "REJECTED": rejected.add(label);  break;
            default:         skipped.add(label);   break;
        }
    }

    // ── helpers ──────────────────────────────────────────────────────────────

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