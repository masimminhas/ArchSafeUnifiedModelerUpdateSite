package edu.kit.sdq.dsis.unified.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices.ModelMetrics;
import unified.UnifiedSystemModel;

/**
 * Action handler for computing model metrics.
 * Compatible with Sirius IExternalJavaAction interface.
 */
public class MetricsAction implements IExternalJavaAction {
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        computeMetrics(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    /**
     * Public service method that can be called from AQL or other actions.
     */
    public void computeMetrics(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }
            
            AdvancedAnalysisServices service = new AdvancedAnalysisServices();
            ModelMetrics metrics = service.computeModelMetrics(model);
            
            // Format metrics report
            StringBuilder report = new StringBuilder();
            report.append("📊 MODEL METRICS REPORT\n\n");
            
            report.append("=== ARCHITECTURE ===\n");
            report.append("Total Blocks: ").append(metrics.getTotalBlocks()).append("\n");
            report.append("Total Connections: ").append(metrics.getTotalConnections()).append("\n");
            report.append("Cyclomatic Complexity: ").append(metrics.getCyclomaticComplexity()).append("\n");
            report.append(String.format("Average Block Degree: %.2f\n\n", metrics.getAverageBlockDegree()));
            
            report.append("=== SAFETY ===\n");
            report.append("Total Hazards: ").append(metrics.getTotalHazards()).append("\n");
            report.append(String.format("Hazard Coverage: %.1f%%\n\n", metrics.getHazardCoverage() * 100));
            
            report.append("=== FMEA ===\n");
            report.append("Total FMEA Items: ").append(metrics.getTotalFMEAItems()).append("\n");
            report.append(String.format("FMEA Coverage: %.1f%%\n", metrics.getFmeaCoverage() * 100));
            report.append(String.format("Average RPN: %.1f\n", metrics.getAverageRPN()));
            report.append("High Risk Items: ").append(metrics.getHighRiskItems()).append("\n\n");
            
            report.append("=== TRACEABILITY ===\n");
            report.append(String.format("Traceability Density: %.1f%%\n", metrics.getTraceabilityDensity() * 100));
            report.append("Traceability Links: ").append(metrics.getTraceabilityLinks()).append("\n\n");
            
            report.append("=== OVERALL SCORES ===\n");
            report.append("Completeness Score: ").append(metrics.getCompletenessScore()).append("/100\n");
            report.append("Consistency Score: ").append(metrics.getConsistencyScore()).append("/100\n\n");
            
            if (metrics.getCompletenessScore() < 50) {
                report.append("⚠️ Model completeness is low. Consider adding:\n");
                report.append("  • More hazard associations\n");
                report.append("  • FMEA analysis items\n");
                report.append("  • Traceability links");
            } else if (metrics.getCompletenessScore() < 80) {
                report.append("✅ Model completeness is good.\n");
                report.append("💡 Tip: Add more traceability links to improve score.");
            } else {
                report.append("🎉 Excellent model completeness!");
            }
            
            showInfo("Metrics Report", report.toString());
            
        } catch (Exception e) {
            showError("Metrics computation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private UnifiedSystemModel getModelFromSelections(Collection<? extends EObject> selections) {
        if (selections == null || selections.isEmpty()) {
            return null;
        }
        return getModel(selections.iterator().next());
    }
    
    private UnifiedSystemModel getModel(EObject element) {
        EObject current = element;
        while (current != null) {
            if (current instanceof UnifiedSystemModel) {
                return (UnifiedSystemModel) current;
            }
            current = current.eContainer();
        }
        return null;
    }
    
    private void showInfo(String title, String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message);
        });
    }
    
    private void showError(String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", message);
        });
    }
}