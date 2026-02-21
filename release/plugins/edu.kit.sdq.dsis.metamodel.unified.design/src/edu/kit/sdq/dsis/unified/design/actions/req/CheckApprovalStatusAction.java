package edu.kit.sdq.dsis.unified.design.actions.req;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Reports the approval status of all safety work products in the Requirements
 * Diagram, grouped by type and status stage.
 *
 * The ISO 26262 safety lifecycle requires that all safety work products pass
 * through an approval process before a gate review can be passed:
 *
 *   DRAFT → UNDER_REVIEW / IN_REVIEW → APPROVED
 *
 * Items still in DRAFT at a gate review stage are compliance blockers.
 * Items in REJECTED state require rework.
 *
 * ISO 26262 References:
 *   ISO 26262-2:2018 §6.4   — Safety Plan & Work Product Approval
 *   ISO 26262-2:2018 §6.4.9 — Confirmation Review of Safety Work Products
 *   ISO 26262-8:2018 §9     — Configuration Management of Safety Work Products
 */
public class CheckApprovalStatusAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select a UnifiedSystemModel.");
            return;
        }

        // Counts by type
        StatusCount goalCounts = new StatusCount("Safety Goals");
        StatusCount fsrCounts  = new StatusCount("Functional Safety Requirements");
        StatusCount tsrCounts  = new StatusCount("Technical Safety Requirements");

        List<String> blockers = new ArrayList<>();
        List<String> warnings = new ArrayList<>();

        // ── Safety Goals ─────────────────────────────────────────────────────
        for (SafetyGoal sg : model.getSafetyGoals()) {
            String status = statusStr(sg.getStatus());
            goalCounts.add(status);
            if (isDraft(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Safety Goal '" + name(sg) + "' [" + sg.getRequirementId() + "] status = DRAFT.",
                    Iso26262Reference.PART2_SAFETY_PLAN,
                    "Safety Goals must be APPROVED before the functional safety concept gate review."
                ));
            } else if (isRejected(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "Safety Goal '" + name(sg) + "' [" + sg.getRequirementId() + "] status = REJECTED — requires rework.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW,
                    "Rejected work products must be reworked and re-reviewed before gate passage."
                ));
            } else if (isInReview(status)) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "Safety Goal '" + name(sg) + "' [" + sg.getRequirementId() + "] is still UNDER REVIEW.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW,
                    "Review must be completed and approval granted before gate review."
                ));
            }
        }

        // ── Functional Safety Requirements ────────────────────────────────────
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            String status = statusStr(fsr.getStatus());
            fsrCounts.add(status);
            if (isDraft(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "FSR '" + name(fsr) + "' [" + fsr.getRequirementId() + "] status = DRAFT.",
                    Iso26262Reference.PART2_SAFETY_PLAN,
                    "FSRs are key work product [3-9] and must be APPROVED before technical safety concept work begins."
                ));
            } else if (isRejected(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "FSR '" + name(fsr) + "' [" + fsr.getRequirementId() + "] status = REJECTED — requires rework.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW, null
                ));
            } else if (isInReview(status)) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "FSR '" + name(fsr) + "' [" + fsr.getRequirementId() + "] is UNDER REVIEW.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW, null
                ));
            }
        }

        // ── Technical Safety Requirements ─────────────────────────────────────
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            String status = statusStr(tsr.getStatus());
            tsrCounts.add(status);
            if (isDraft(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "TSR '" + name(tsr) + "' [" + tsr.getRequirementId() + "] status = DRAFT.",
                    Iso26262Reference.PART2_SAFETY_PLAN,
                    "TSRs are work product [4-6] and must be APPROVED before system design verification."
                ));
            } else if (isRejected(status)) {
                blockers.add(Iso26262Reference.checkRow(
                    "✘ FAIL",
                    "TSR '" + name(tsr) + "' [" + tsr.getRequirementId() + "] status = REJECTED.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW, null
                ));
            } else if (isInReview(status)) {
                warnings.add(Iso26262Reference.checkRow(
                    "⚠ WARNING",
                    "TSR '" + name(tsr) + "' [" + tsr.getRequirementId() + "] is UNDER REVIEW.",
                    Iso26262Reference.PART2_CONFIRMATION_REVIEW, null
                ));
            }
        }

        // ── Build report ─────────────────────────────────────────────────────
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════════════════════════════════╗\n");
        report.append("║   ISO 26262 SAFETY WORK PRODUCT APPROVAL STATUS          ║\n");
        report.append("╠══════════════════════════════════════════════════════════╣\n");
        report.append("║  Primary Reference: ").append(Iso26262Reference.PART2_SAFETY_PLAN).append("\n");
        report.append("║  Config. Mgmt:      ").append(Iso26262Reference.PART8_CONFIG_MANAGEMENT).append("\n");
        report.append("╚══════════════════════════════════════════════════════════╝\n\n");

        report.append("STATUS SUMMARY:\n");
        report.append(goalCounts.formatTable()).append("\n");
        report.append(fsrCounts.formatTable()).append("\n");
        report.append(tsrCounts.formatTable()).append("\n");

        if (!blockers.isEmpty()) {
            report.append("── GATE REVIEW BLOCKERS (").append(blockers.size()).append(") ──────────────────────────────────\n");
            blockers.forEach(report::append);
            report.append("\n");
        }
        if (!warnings.isEmpty()) {
            report.append("── WARNINGS (").append(warnings.size()).append(") ──────────────────────────────────────────\n");
            warnings.forEach(report::append);
            report.append("\n");
        }

        int totalApproved = goalCounts.approved + fsrCounts.approved + tsrCounts.approved;
        int totalItems    = goalCounts.total    + fsrCounts.total    + tsrCounts.total;

        report.append("──────────────────────────────────────────────────────────\n");
        report.append(String.format("APPROVED: %d / %d work products (%.0f%%)\n",
            totalApproved, totalItems,
            totalItems == 0 ? 0 : (totalApproved * 100.0 / totalItems)));

        if (blockers.isEmpty() && warnings.isEmpty()) {
            report.append("\n✔ All safety work products are APPROVED — gate review may proceed.\n");
        } else if (blockers.isEmpty()) {
            report.append("\n⚠ Some work products are under review — complete before gate review.\n");
        } else {
            report.append("\n✘ Gate review BLOCKED by unapproved or rejected work products.\n");
        }

        report.append("\n").append(Iso26262Reference.REPORT_DISCLAIMER);
        showInfo("Approval Status Check", report.toString());
    }

    // ── Status helpers ────────────────────────────────────────────────────────

    private String statusStr(Object status) {
        return status != null ? status.toString().toUpperCase() : "DRAFT";
    }

    private boolean isDraft(String s)     { return s.contains("DRAFT"); }
    private boolean isRejected(String s)  { return s.contains("REJECT"); }
    private boolean isInReview(String s)  { return s.contains("REVIEW") || s.contains("PENDING"); }

    // ── StatusCount helper ────────────────────────────────────────────────────

    static class StatusCount {
        final String label;
        int draft = 0, inReview = 0, approved = 0, rejected = 0, other = 0, total = 0;

        StatusCount(String label) { this.label = label; }

        void add(String status) {
            total++;
            if (status.contains("DRAFT"))         draft++;
            else if (status.contains("REJECT"))   rejected++;
            else if (status.contains("REVIEW") || status.contains("PENDING")) inReview++;
            else if (status.contains("APPROVED") || status.contains("ACCEPT")) approved++;
            else                                                               other++;
        }

        String formatTable() {
            return String.format(
                "  %-42s  DRAFT=%d  REVIEW=%d  APPROVED=%d  REJECTED=%d  (total=%d)",
                label + ":", draft, inReview, approved, rejected, total);
        }
    }

    // ── standard helpers ──────────────────────────────────────────────────────

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