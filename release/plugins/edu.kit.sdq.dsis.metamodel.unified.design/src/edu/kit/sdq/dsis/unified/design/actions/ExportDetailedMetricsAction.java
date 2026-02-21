package edu.kit.sdq.dsis.unified.design.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices.ModelMetrics;
import unified.*;

/**
 * Export Detailed Metrics Action - UPDATED for Requirements Support
 * Exports comprehensive metrics including requirement statistics.
 */
public class ExportDetailedMetricsAction implements IExternalJavaAction {

    private final AdvancedAnalysisServices analysisService = new AdvancedAnalysisServices();

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        EObject element = selections.iterator().next();
        exportMetrics(element);
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }

    public void exportMetrics(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }

            final String[] filepath = new String[1];
            Display.getDefault().syncExec(() -> {
                FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
                dialog.setFilterExtensions(new String[] { "*.csv" });
                dialog.setFilterNames(new String[] { "CSV Files (*.csv)" });
                dialog.setFileName("Metrics_Report.csv");
                filepath[0] = dialog.open();
            });

            if (filepath[0] == null) return;

            ModelMetrics metrics = analysisService.computeModelMetrics(model);
            exportMetricsToCSV(metrics, model, filepath[0]);

            showInfo("Export Complete",
                "Metrics report exported successfully to:\n" + filepath[0] + "\n\n" +
                "Completeness Score: " + metrics.getCompletenessScore() + "/100\n" +
                "Consistency Score: " + metrics.getConsistencyScore() + "/100");

        } catch (Exception e) {
            showError("Export failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void exportMetricsToCSV(ModelMetrics metrics, UnifiedSystemModel model,
                                     String filepath) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {

            writer.write("=== MODEL METRICS REPORT ===\n");
            writer.write("Generated: " + new java.util.Date().toString() + "\n");
            writer.write("Model: UnifiedSystemModel\n\n\n");

            // Requirements Metrics Section
            writer.write("=== REQUIREMENTS METRICS ===\n");
            writer.write("Metric,Value\n");
            writer.write("Total Requirements," + metrics.getTotalRequirements() + "\n");
            writer.write("Functional Requirements," + metrics.getFunctionalRequirements() + "\n");
            writer.write("Safety Requirements," + metrics.getSafetyRequirements() + "\n");
            writer.write("Performance Requirements," + metrics.getPerformanceRequirements() + "\n");
            writer.write("High Priority Requirements," + metrics.getHighPriorityRequirements() + "\n");
            writer.write("Medium Priority Requirements," + metrics.getMediumPriorityRequirements() + "\n");
            writer.write("Low Priority Requirements," + metrics.getLowPriorityRequirements() + "\n");
            writer.write("Requirements with Traces," + metrics.getRequirementsWithTraces() + "\n");
            writer.write("Requirement Coverage," + String.format("%.1f%%", metrics.getRequirementCoverage() * 100) + "\n");
            writer.write("Avg Traces per Requirement," + String.format("%.2f", metrics.getAvgTracesPerRequirement()) + "\n");
            writer.write("Requirement to Block Links," + metrics.getRequirementToBlockLinks() + "\n");
            writer.write("Requirement to Hazard Links," + metrics.getRequirementToHazardLinks() + "\n");
            writer.write("Requirement to FMEA Links," + metrics.getRequirementToFMEALinks() + "\n");
            writer.write("\n\n");

            // Architecture Metrics Section
            writer.write("=== ARCHITECTURE METRICS ===\n");
            writer.write("Metric,Value\n");
            writer.write("Total Blocks," + metrics.getTotalBlocks() + "\n");
            writer.write("System Blocks," + model.getSystemBlocks().size() + "\n");
            writer.write("Safety Critical Blocks," + model.getRootBlocks().size() + "\n");
            writer.write("Total Connections," + metrics.getTotalConnections() + "\n");
            writer.write("Total Associations," + model.getBlockAssociations().size() + "\n");
            writer.write("Cyclomatic Complexity," + metrics.getCyclomaticComplexity() + "\n");
            writer.write("Average Block Degree," + String.format("%.2f", metrics.getAverageBlockDegree()) + "\n");
            writer.write("\n\n");

            // Safety Metrics Section
            writer.write("=== SAFETY METRICS ===\n");
            writer.write("Metric,Value\n");
            writer.write("Total Hazards," + metrics.getTotalHazards() + "\n");
            writer.write("Catastrophic Hazards," + countCatastrophicHazards(model) + "\n");
            writer.write("Critical Hazards," + countCriticalHazards(model) + "\n");
            writer.write("Mitigated Hazards," + countMitigatedHazards(model) + "\n");
            writer.write("Hazard Coverage," + String.format("%.1f%%", metrics.getHazardCoverage() * 100) + "\n");
            writer.write("Total Failure Modes," + countTotalFailureModes(model) + "\n");
            writer.write("\n\n");

            // FMEA Metrics Section
            writer.write("=== FMEA METRICS ===\n");
            writer.write("Metric,Value\n");
            writer.write("Total FMEA Items," + metrics.getTotalFMEAItems() + "\n");
            writer.write("FMEA Coverage," + String.format("%.1f%%", metrics.getFmeaCoverage() * 100) + "\n");
            writer.write("Average RPN," + String.format("%.1f", metrics.getAverageRPN()) + "\n");
            writer.write("High Risk Items (RPN > 100)," + metrics.getHighRiskItems() + "\n");
            writer.write("Auto-Generated Items," + String.format("%.1f%%", metrics.getAutoGeneratedPercentage()) + "\n");
            writer.write("\n\n");

            // Traceability Metrics Section
            writer.write("=== TRACEABILITY METRICS ===\n");
            writer.write("Metric,Value\n");
            writer.write("Traceability Density," + String.format("%.1f%%", metrics.getTraceabilityDensity() * 100) + "\n");
            writer.write("Total Traceability Links," + metrics.getTraceabilityLinks() + "\n");
            writer.write("Requirement Trace Links," + (metrics.getRequirementToBlockLinks() +
                metrics.getRequirementToHazardLinks() + metrics.getRequirementToFMEALinks()) + "\n");
            writer.write("Hazard-to-Block Links," + countHazardToBlockLinks(model) + "\n");
            writer.write("FMEA-to-Component Links," + countFMEAToComponentLinks(model) + "\n");
            writer.write("\n\n");

            // Overall Quality Scores Section
            writer.write("=== OVERALL QUALITY SCORES ===\n");
            writer.write("Score,Value,Rating\n");
            writer.write("Completeness Score," + metrics.getCompletenessScore() + "/100," +
                getRating(metrics.getCompletenessScore()) + "\n");
            writer.write("Consistency Score," + metrics.getConsistencyScore() + "/100," +
                getRating(metrics.getConsistencyScore()) + "\n");
            writer.write("\n\n");

            // Recommendations Section
            writer.write("=== RECOMMENDATIONS ===\n");
            writer.write(generateRecommendations(metrics, model));
            writer.write("\n\n");

            // Detailed Breakdown Section
            writer.write("=== DETAILED BREAKDOWN ===\n");
            writer.write("Category,Element,Count\n");
            writer.write("Requirements,Total Requirements," + RequirementTraceHelper.getRequirements(model).size() + "\n");
            writer.write("Requirements,Functional Requirements," + metrics.getFunctionalRequirements() + "\n");
            writer.write("Requirements,Safety Requirements," + metrics.getSafetyRequirements() + "\n");
            writer.write("Requirements,Performance Requirements," + metrics.getPerformanceRequirements() + "\n");
            writer.write("Blocks,System Blocks," + model.getSystemBlocks().size() + "\n");
            writer.write("Blocks,Safety Critical Blocks," + model.getRootBlocks().size() + "\n");
            writer.write("Connections,Block Connections," + model.getBlockConnections().size() + "\n");
            writer.write("Connections,Block Associations," + model.getBlockAssociations().size() + "\n");
            writer.write("Safety,Global Hazards," + model.getGlobalHazards().size() + "\n");
            writer.write("Safety,Total Failure Modes," + countTotalFailureModes(model) + "\n");
            writer.write("Analysis,FMEA Analyses," + model.getFmeaAnalysis().size() + "\n");
            writer.write("Analysis,Total FMEA Items," + metrics.getTotalFMEAItems() + "\n");
        }
    }

    private String getRating(int score) {
        if (score >= 90) return "Excellent";
        if (score >= 80) return "Very Good";
        if (score >= 70) return "Good";
        if (score >= 60) return "Fair";
        if (score >= 50) return "Poor";
        return "Critical";
    }

    private String generateRecommendations(ModelMetrics metrics, UnifiedSystemModel model) {
        StringBuilder recommendations = new StringBuilder();
        recommendations.append("Recommendation,Priority,Description\n");

        if (metrics.getCompletenessScore() < 50)
            recommendations.append("Improve Model Completeness,HIGH,\"Model completeness is below 50%. Add more hazard associations FMEA items and traceability links.\"\n");

        if (metrics.getHazardCoverage() < 0.5)
            recommendations.append("Increase Hazard Coverage,HIGH,\"Hazard coverage is below 50%. Link more hazards to safety-critical blocks.\"\n");

        if (metrics.getFmeaCoverage() < 0.8)
            recommendations.append("Expand FMEA Coverage,MEDIUM,\"FMEA coverage is below 80%. Perform FMEA analysis on more safety-critical blocks.\"\n");

        if (metrics.getAverageRPN() > 100)
            recommendations.append("Address High RPN Values,HIGH,\"Average RPN exceeds 100. Review and mitigate high-risk FMEA items.\"\n");

        if (metrics.getTraceabilityDensity() < 0.3)
            recommendations.append("Improve Traceability,MEDIUM,\"Traceability density is below 30%. Add more links between architecture and safety elements.\"\n");

        if (metrics.getRequirementCoverage() < 0.5)
            recommendations.append("Improve Requirement Traceability,HIGH,\"Requirement coverage is below 50%. Link requirements to blocks hazards and FMEA items.\"\n");

        if (metrics.getSafetyRequirements() > 0) {
            int unlinkedSafety = 0;
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                Object reqType = RequirementTraceHelper.getRequirementType(req);
                if (reqType != null && reqType.toString().equals("SAFETY")) {
                    if (RequirementTraceHelper.getRelatedHazards(req).isEmpty() &&
                        !RequirementTraceHelper.hasRelatedFMEAItems(model, req)) {
                        unlinkedSafety++;
                    }
                }
            }
            if (unlinkedSafety > 0)
                recommendations.append("Link Safety Requirements to Hazards,HIGH,\"" + unlinkedSafety +
                    " safety requirement(s) are not linked to hazards or FMEA items.\"\n");
        }

        if (metrics.getHighPriorityRequirements() > 0) {
            int underTraced = 0;
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                Object priority = RequirementTraceHelper.getPriority(req);
                if (priority != null && priority.toString().equals("HIGH")) {
                    int traceCount = RequirementTraceHelper.getRelatedBlocks(req).size()
                                   + RequirementTraceHelper.getRelatedHazards(req).size()
                                   + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                    if (traceCount < 2) underTraced++;
                }
            }
            if (underTraced > 0)
                recommendations.append("Increase High-Priority Requirement Traces,MEDIUM,\"" + underTraced +
                    " high-priority requirement(s) have insufficient traceability (< 2 links).\"\n");
        }

        if (recommendations.toString().equals("Recommendation,Priority,Description\n"))
            recommendations.append("No Critical Issues,INFO,\"Model quality is good. Continue maintaining high standards.\"\n");

        return recommendations.toString();
    }

    // ---- Helper counting methods ----

    private int countCatastrophicHazards(UnifiedSystemModel model) {
        int count = 0;
        for (IntegratedHazard h : model.getGlobalHazards())
            if (h.getRiskLevel() == RiskLevel.CATASTROPHIC) count++;
        return count;
    }

    private int countCriticalHazards(UnifiedSystemModel model) {
        int count = 0;
        for (IntegratedHazard h : model.getGlobalHazards())
            if (h.getRiskLevel() == RiskLevel.CRITICAL_RISK) count++;
        return count;
    }

    private int countMitigatedHazards(UnifiedSystemModel model) {
        int count = 0;
        for (IntegratedHazard h : model.getGlobalHazards())
            if (h.getMitigationStatus() != MitigationStatus.NOT_MITIGATED) count++;
        return count;
    }

    private int countTotalFailureModes(UnifiedSystemModel model) {
        int count = 0;
        for (SafetyCriticalBlock block : model.getRootBlocks())
            count += block.getFailureModes().size();
        return count;
    }

    private int countHazardToBlockLinks(UnifiedSystemModel model) {
        int count = 0;
        for (IntegratedHazard h : model.getGlobalHazards())
            count += h.getRelatedBlocks().size();
        return count;
    }

    private int countFMEAToComponentLinks(UnifiedSystemModel model) {
        int count = 0;
        for (FMEAAnalysis analysis : model.getFmeaAnalysis())
            for (FMEAItem item : analysis.getFmeaItems())
                if (item.getAnalyzedComponent() != null) count++;
        return count;
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