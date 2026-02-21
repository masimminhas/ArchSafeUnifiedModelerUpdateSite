package edu.kit.sdq.dsis.unified.design.actions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import unified.UnifiedSystemModel;

/**
 * Action handler for generating improvement recommendations.
 * Compatible with Sirius IExternalJavaAction interface.
 */
public class RecommendationAction implements IExternalJavaAction {
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        generateRecommendations(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    /**
     * Public service method that can be called from AQL or other actions.
     */
    public void generateRecommendations(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }
            
            AdvancedAnalysisServices service = new AdvancedAnalysisServices();
            List<AdvancedAnalysisServices.Recommendation> recommendations = 
                service.generateRecommendations(model);
            
            if (recommendations.isEmpty()) {
                showInfo("Recommendations", 
                        "✅ Excellent! No improvement recommendations at this time.");
                return;
            }
            
            // Build recommendation message
            StringBuilder message = new StringBuilder();
            message.append("💡 IMPROVEMENT RECOMMENDATIONS\n\n");
            message.append("Found ").append(recommendations.size()).append(" recommendations:\n\n");
            
            // Group by type
            Map<AdvancedAnalysisServices.RecommendationType, List<AdvancedAnalysisServices.Recommendation>> 
                grouped = recommendations.stream()
                    .collect(Collectors.groupingBy(AdvancedAnalysisServices.Recommendation::getType));
            
            for (Map.Entry<AdvancedAnalysisServices.RecommendationType, List<AdvancedAnalysisServices.Recommendation>> 
                 entry : grouped.entrySet()) {
                message.append("▶ ").append(formatRecommendationType(entry.getKey())).append("\n");
                for (AdvancedAnalysisServices.Recommendation rec : entry.getValue()) {
                    message.append("  • ").append(rec.getDescription()).append("\n");
                }
                message.append("\n");
            }
            
            showInfo("Recommendations", message.toString());
            
        } catch (Exception e) {
            showError("Recommendation generation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private String formatRecommendationType(AdvancedAnalysisServices.RecommendationType type) {
        switch (type) {
            case SAFETY_IMPROVEMENT: return "Safety Improvements";
            case RISK_MITIGATION: return "Risk Mitigation";
            case HAZARD_MITIGATION: return "Hazard Mitigation";
            case COMPLETENESS: return "Completeness Improvements";
            case CONSISTENCY: return "Consistency Issues";
            case PERFORMANCE: return "Performance Optimizations";
            default: return type.toString();
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