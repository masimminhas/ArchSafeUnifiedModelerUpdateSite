package edu.kit.sdq.dsis.unified.design.actions;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import unified.*;

/**
 * Traceability Gap Analysis Action - UPDATED for Requirements Support
 * Identifies missing trace links including requirements gaps.
 */
public class TraceabilityQueryAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No model selected", "Please select a UnifiedSystemModel.");
            return;
        }

        EObject firstSelection = selections.iterator().next();
        UnifiedSystemModel model = getUnifiedSystemModel(firstSelection);

        if (model == null) {
            showError("Invalid Selection", "Please select a valid UnifiedSystemModel.");
            return;
        }

        StringBuilder report = new StringBuilder();
        report.append("=== TRACEABILITY GAP ANALYSIS ===\n\n");

        int totalIssues = 0;

        // 1. Find requirements without any traces
        List<Requirement> orphanedRequirements = new ArrayList<>();
        for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
            if (RequirementTraceHelper.getRelatedBlocks(req).isEmpty() &&
                RequirementTraceHelper.getRelatedHazards(req).isEmpty() &&
                !RequirementTraceHelper.hasRelatedFMEAItems(model, req)) {
                orphanedRequirements.add(req);
            }
        }

        if (!orphanedRequirements.isEmpty()) {
            report.append("REQUIREMENTS WITHOUT ANY TRACES (" + orphanedRequirements.size() + "):\n");
            for (Requirement req : orphanedRequirements) {
                Object reqType  = RequirementTraceHelper.getRequirementType(req);
                Object priority = RequirementTraceHelper.getPriority(req);
                report.append("  - " + req.getId() + ": " + req.getName() +
                    " [" + (reqType  != null ? reqType  : "N/A") +
                    ", Priority: " + (priority != null ? priority : "N/A") + "]\n");
            }
            report.append("\n");
            totalIssues += orphanedRequirements.size();
        }

        // 2. Find high-priority requirements with insufficient traces
        List<Requirement> underTracedRequirements = new ArrayList<>();
        for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
            Object priority = RequirementTraceHelper.getPriority(req);
            if (priority != null && priority.toString().equals("HIGH")) {
                int traceCount = RequirementTraceHelper.getRelatedBlocks(req).size()
                               + RequirementTraceHelper.getRelatedHazards(req).size()
                               + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                if (traceCount < 2) {
                    underTracedRequirements.add(req);
                }
            }
        }

        if (!underTracedRequirements.isEmpty()) {
            report.append("HIGH-PRIORITY REQUIREMENTS WITH INSUFFICIENT TRACES ("
                + underTracedRequirements.size() + "):\n");
            for (Requirement req : underTracedRequirements) {
                int traceCount = RequirementTraceHelper.getRelatedBlocks(req).size()
                               + RequirementTraceHelper.getRelatedHazards(req).size()
                               + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                report.append("  - " + req.getId() + ": " + req.getName() +
                    " (only " + traceCount + " trace link(s))\n");
            }
            report.append("\n");
            totalIssues += underTracedRequirements.size();
        }

        // 3. Find hazards without related blocks
        List<IntegratedHazard> orphanedHazards = new ArrayList<>();
        for (IntegratedHazard hazard : model.getGlobalHazards()) {
            if (hazard.getRelatedBlocks().isEmpty()) {
                orphanedHazards.add(hazard);
            }
        }

        if (!orphanedHazards.isEmpty()) {
            report.append("HAZARDS WITHOUT RELATED BLOCKS (" + orphanedHazards.size() + "):\n");
            for (IntegratedHazard h : orphanedHazards) {
                report.append("  - " + h.getName() + " [" + h.getRiskLevel() + "]\n");
            }
            report.append("\n");
            totalIssues += orphanedHazards.size();
        }

        // 4. Find FMEA items without analyzed components
        List<FMEAItem> orphanedFMEAItems = new ArrayList<>();
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (item.getAnalyzedComponent() == null) {
                    orphanedFMEAItems.add(item);
                }
            }
        }

        if (!orphanedFMEAItems.isEmpty()) {
            report.append("FMEA ITEMS WITHOUT ANALYZED COMPONENTS (" + orphanedFMEAItems.size() + "):\n");
            for (FMEAItem item : orphanedFMEAItems) {
                report.append("  - " + item.getName() + " [RPN: " +
                    (item.getSeverity() * item.getOccurrence() * item.getDetection()) + "]\n");
            }
            report.append("\n");
            totalIssues += orphanedFMEAItems.size();
        }

        // 5. Find FMEA items without failure modes
        List<FMEAItem> itemsWithoutFMs = new ArrayList<>();
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (item.getFailureMode() == null) {
                    itemsWithoutFMs.add(item);
                }
            }
        }

        if (!itemsWithoutFMs.isEmpty()) {
            report.append("FMEA ITEMS WITHOUT FAILURE MODES (" + itemsWithoutFMs.size() + "):\n");
            for (FMEAItem item : itemsWithoutFMs) {
                report.append("  - " + item.getName() + "\n");
            }
            report.append("\n");
            totalIssues += itemsWithoutFMs.size();
        }

        // 6. Find safety-critical blocks without hazards
        List<SafetyCriticalBlock> blocksWithoutHazards = new ArrayList<>();
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            boolean hasHazard = false;
            for (IntegratedHazard hazard : model.getGlobalHazards()) {
                if (hazard.getRelatedBlocks().contains(block)) { hasHazard = true; break; }
            }
            if (!hasHazard && block.getSafetyCriticality() != SafetyCriticalityLevel.LOW) {
                blocksWithoutHazards.add(block);
            }
        }

        if (!blocksWithoutHazards.isEmpty()) {
            report.append("SAFETY-CRITICAL BLOCKS WITHOUT HAZARDS (" + blocksWithoutHazards.size() + "):\n");
            for (SafetyCriticalBlock block : blocksWithoutHazards) {
                report.append("  - " + block.getName() +
                    " [" + block.getSafetyCriticality() + ", " + block.getAsilLevel() + "]\n");
            }
            report.append("\n");
            totalIssues += blocksWithoutHazards.size();
        }

        // 7. Find safety-critical blocks without requirements
        List<SafetyCriticalBlock> blocksWithoutRequirements = new ArrayList<>();
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            boolean hasRequirement = false;
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                if (RequirementTraceHelper.getRelatedBlocks(req).contains(block)) {
                    hasRequirement = true;
                    break;
                }
            }
            if (!hasRequirement && block.getSafetyCriticality() != SafetyCriticalityLevel.LOW) {
                blocksWithoutRequirements.add(block);
            }
        }

        if (!blocksWithoutRequirements.isEmpty()) {
            report.append("SAFETY-CRITICAL BLOCKS WITHOUT REQUIREMENTS ("
                + blocksWithoutRequirements.size() + "):\n");
            for (SafetyCriticalBlock block : blocksWithoutRequirements) {
                report.append("  - " + block.getName() + " [" + block.getAsilLevel() + "]\n");
            }
            report.append("\n");
            totalIssues += blocksWithoutRequirements.size();
        }

        // 8. Find safety-critical blocks without failure modes
        List<SafetyCriticalBlock> blocksWithoutFMs = new ArrayList<>();
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            if (block.getFailureModes().isEmpty() &&
                block.getSafetyCriticality() != SafetyCriticalityLevel.LOW) {
                blocksWithoutFMs.add(block);
            }
        }

        if (!blocksWithoutFMs.isEmpty()) {
            report.append("SAFETY-CRITICAL BLOCKS WITHOUT FAILURE MODES (" + blocksWithoutFMs.size() + "):\n");
            for (SafetyCriticalBlock block : blocksWithoutFMs) {
                report.append("  - " + block.getName() + " [" + block.getAsilLevel() + "]\n");
            }
            report.append("\n");
            totalIssues += blocksWithoutFMs.size();
        }

        // 9. Find blocks without FMEA analysis
        List<SafetyCriticalBlock> blocksWithoutFMEA = new ArrayList<>();
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            boolean hasFMEA = false;
            outer:
            for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
                for (FMEAItem item : analysis.getFmeaItems()) {
                    if (item.getAnalyzedComponent() == block) { hasFMEA = true; break outer; }
                }
            }
            if (!hasFMEA && block.getSafetyCriticality() != SafetyCriticalityLevel.LOW) {
                blocksWithoutFMEA.add(block);
            }
        }

        if (!blocksWithoutFMEA.isEmpty()) {
            report.append("SAFETY-CRITICAL BLOCKS WITHOUT FMEA ITEMS (" + blocksWithoutFMEA.size() + "):\n");
            for (SafetyCriticalBlock block : blocksWithoutFMEA) {
                report.append("  - " + block.getName() + " [" + block.getAsilLevel() + "]\n");
            }
            report.append("\n");
            totalIssues += blocksWithoutFMEA.size();
        }

        // 10. Find isolated blocks (no connections)
        List<SystemBlock> isolatedBlocks = new ArrayList<>();
        for (SystemBlock block : model.getSystemBlocks()) {
            if (block.getConnectionAsSource().isEmpty() && block.getConnectionAsTarget().isEmpty())
                isolatedBlocks.add(block);
        }
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            if (block.getConnectionAsSource().isEmpty() && block.getConnectionAsTarget().isEmpty())
                isolatedBlocks.add(block);
        }

        if (!isolatedBlocks.isEmpty()) {
            report.append("ISOLATED BLOCKS (NO CONNECTIONS) (" + isolatedBlocks.size() + "):\n");
            for (SystemBlock block : isolatedBlocks) {
                report.append("  - " + block.getName() + "\n");
            }
            report.append("\n");
            totalIssues += isolatedBlocks.size();
        }

        // Summary
        report.append("=======================================\n");
        report.append("TOTAL TRACEABILITY ISSUES: " + totalIssues + "\n");

        if (totalIssues == 0) {
            report.append("\nNo traceability gaps found!\n");
            report.append("All model elements have proper trace links.\n");
        } else {
            report.append("\nRecommendation: Address these gaps to improve\n");
            report.append("model completeness and traceability coverage.\n");
            report.append("\nPriority actions:\n");
            report.append("1. Trace all high-priority requirements\n");
            report.append("2. Link requirements to safety-critical blocks\n");
            report.append("3. Link hazards to affected blocks\n");
            report.append("4. Complete FMEA analysis for safety-critical blocks\n");
        }

        showInfo("Traceability Gap Analysis", report.toString());
    }

    private UnifiedSystemModel getUnifiedSystemModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        if (obj instanceof DSemanticDecorator)
            return getUnifiedSystemModel(((DSemanticDecorator) obj).getTarget());
        if (obj.eContainer() != null) return getUnifiedSystemModel(obj.eContainer());
        return null;
    }

    private void showError(String title, String message) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), title, message)
        );
    }

    private void showInfo(String title, String message) {
        Display.getDefault().syncExec(() -> {
            MessageDialog dialog = new MessageDialog(
                Display.getDefault().getActiveShell(),
                title, null, message,
                MessageDialog.INFORMATION,
                new String[] { "OK", "Export Report" }, 0
            );
            int result = dialog.open();
            if (result == 1) exportReport(title, message);
        });
    }

    private void exportReport(String title, String report) {
        Shell shell = Display.getDefault().getActiveShell();
        FileDialog dialog = new FileDialog(shell, SWT.SAVE);
        dialog.setFilterNames(new String[] { "Text Files (*.txt)", "All Files (*.*)" });
        dialog.setFilterExtensions(new String[] { "*.txt", "*.*" });
        dialog.setFileName("TraceabilityGapReport_" +
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt");

        String filePath = dialog.open();
        if (filePath != null) {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(report);
                MessageDialog.openInformation(shell, "Export Successful",
                    "Gap analysis report exported to:\n" + filePath);
            } catch (IOException e) {
                MessageDialog.openError(shell, "Export Failed",
                    "Failed to export report: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }
}