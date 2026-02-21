package edu.kit.sdq.dsis.unified.design.actions;

import java.util.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Validate Traceability Query Action - NEW for Requirements Support
 * Provides query-based validation for requirement traceability.
 */
public class ValidateTraceabilityQueryAction implements IExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        EObject element = selections.iterator().next();
        performQueries(element);
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }

    public void performQueries(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }

            StringBuilder report = new StringBuilder();
            report.append("TRACEABILITY QUERY RESULTS\n");
            report.append("=======================================\n\n");

            List<Requirement> requirements = RequirementTraceHelper.getRequirements(model);

            // Query 1: Requirements by type
            report.append("REQUIREMENTS BY TYPE:\n");
            Map<String, Integer> reqByType = new HashMap<>();
            for (Requirement req : requirements) {
                Object type = RequirementTraceHelper.getRequirementType(req);
                String typeStr = type != null ? type.toString() : "UNSPECIFIED";
                reqByType.put(typeStr, reqByType.getOrDefault(typeStr, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : reqByType.entrySet()) {
                report.append("  - " + entry.getKey() + ": " + entry.getValue() + "\n");
            }
            report.append("\n");

            // Query 2: Requirements by priority
            report.append("REQUIREMENTS BY PRIORITY:\n");
            Map<String, Integer> reqByPriority = new HashMap<>();
            for (Requirement req : requirements) {
                Object priority = RequirementTraceHelper.getPriority(req);
                String prioStr = priority != null ? priority.toString() : "UNSPECIFIED";
                reqByPriority.put(prioStr, reqByPriority.getOrDefault(prioStr, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : reqByPriority.entrySet()) {
                report.append("  - " + entry.getKey() + ": " + entry.getValue() + "\n");
            }
            report.append("\n");

            // Query 3: Top 5 most traced requirements
            report.append("TOP 5 MOST TRACED REQUIREMENTS:\n");
            List<RequirementTraceCount> traceCounts = new ArrayList<>();
            for (Requirement req : requirements) {
                int count = RequirementTraceHelper.getRelatedBlocks(req).size()
                          + RequirementTraceHelper.getRelatedHazards(req).size()
                          + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                traceCounts.add(new RequirementTraceCount(req, count));
            }
            traceCounts.sort((a, b) -> Integer.compare(b.count, a.count));
            int displayCount = Math.min(5, traceCounts.size());
            for (int i = 0; i < displayCount; i++) {
                RequirementTraceCount rtc = traceCounts.get(i);
                report.append("  " + (i + 1) + ". " + rtc.req.getId() + ": "
                    + rtc.req.getName() + " (" + rtc.count + " traces)\n");
            }
            report.append("\n");

            // Query 4: Blocks with most requirement traces
            report.append("BLOCKS WITH MOST REQUIREMENT TRACES:\n");
            Map<SafetyCriticalBlock, Integer> blockReqCount = new HashMap<>();
            for (Requirement req : requirements) {
                for (SafetyCriticalBlock block : RequirementTraceHelper.getRelatedBlocks(req)) {
                    blockReqCount.put(block, blockReqCount.getOrDefault(block, 0) + 1);
                }
            }
            List<Map.Entry<SafetyCriticalBlock, Integer>> sortedBlocks =
                new ArrayList<>(blockReqCount.entrySet());
            sortedBlocks.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
            displayCount = Math.min(5, sortedBlocks.size());
            for (int i = 0; i < displayCount; i++) {
                Map.Entry<SafetyCriticalBlock, Integer> entry = sortedBlocks.get(i);
                report.append("  " + (i + 1) + ". " + entry.getKey().getName()
                    + " (" + entry.getValue() + " requirements)\n");
            }
            report.append("\n");

            // Query 5: Hazards addressed by most requirements
            report.append("HAZARDS ADDRESSED BY MOST REQUIREMENTS:\n");
            Map<IntegratedHazard, Integer> hazardReqCount = new HashMap<>();
            for (Requirement req : requirements) {
                for (IntegratedHazard hazard : RequirementTraceHelper.getRelatedHazards(req)) {
                    hazardReqCount.put(hazard, hazardReqCount.getOrDefault(hazard, 0) + 1);
                }
            }
            List<Map.Entry<IntegratedHazard, Integer>> sortedHazards =
                new ArrayList<>(hazardReqCount.entrySet());
            sortedHazards.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
            displayCount = Math.min(5, sortedHazards.size());
            for (int i = 0; i < displayCount; i++) {
                Map.Entry<IntegratedHazard, Integer> entry = sortedHazards.get(i);
                report.append("  " + (i + 1) + ". " + entry.getKey().getName()
                    + " [" + entry.getKey().getRiskLevel() + "] ("
                    + entry.getValue() + " requirements)\n");
            }
            report.append("\n");

            // Query 6: Coverage statistics
            report.append("COVERAGE STATISTICS:\n");
            int totalReq  = requirements.size();
            int tracedReq = 0;
            for (Requirement req : requirements) {
                int count = RequirementTraceHelper.getRelatedBlocks(req).size()
                          + RequirementTraceHelper.getRelatedHazards(req).size()
                          + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                if (count > 0) tracedReq++;
            }
            double coverage = totalReq > 0 ? (tracedReq * 100.0 / totalReq) : 0;
            report.append("  - Total Requirements: " + totalReq + "\n");
            report.append("  - Traced Requirements: " + tracedReq + "\n");
            report.append("  - Coverage: " + String.format("%.1f%%", coverage) + "\n");

            showInfo("Query Results", report.toString());

        } catch (Exception e) {
            showError("Query failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class RequirementTraceCount {
        Requirement req;
        int count;
        RequirementTraceCount(Requirement req, int count) { this.req = req; this.count = count; }
    }

    private UnifiedSystemModel getModelFromSelections(Collection<? extends EObject> selections) {
        if (selections == null || selections.isEmpty()) return null;
        return getModel(selections.iterator().next());
    }

    private UnifiedSystemModel getModel(EObject element) {
        EObject current = element;
        while (current != null) {
            if (current instanceof UnifiedSystemModel) return (UnifiedSystemModel) current;
            current = current.eContainer();
        }
        return null;
    }

    private void showInfo(String title, String message) {
        Display.getDefault().asyncExec(() ->
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message)
        );
    }

    private void showError(String message) {
        Display.getDefault().asyncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", message)
        );
    }
}