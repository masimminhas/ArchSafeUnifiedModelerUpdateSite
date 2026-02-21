package edu.kit.sdq.dsis.unified.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices.ModelMetrics;
import unified.IntegratedHazard;
import unified.MitigationStatus;
import unified.RiskLevel;
import unified.SafetyCriticalBlock;
import unified.UnifiedSystemModel;

/**
 * Action handler for analyzing hazard coverage in safety models.
 */
public class HazardAnalysisAction implements IExternalJavaAction {
    
    private final AdvancedAnalysisServices analysisService = new AdvancedAnalysisServices();
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        analyzeHazards(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    public void analyzeHazards(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }
            
            ModelMetrics metrics = analysisService.computeModelMetrics(model);
            
            // Analyze hazards
            int totalHazards = model.getGlobalHazards().size();
            int catastrophicHazards = 0;
            int criticalHazards = 0;
            int mitigatedHazards = 0;
            int unmappedBlocks = 0;
            
            for (IntegratedHazard hazard : model.getGlobalHazards()) {
                if (hazard.getRiskLevel() == RiskLevel.CATASTROPHIC) {
                    catastrophicHazards++;
                }
                if (hazard.getRiskLevel() == RiskLevel.CRITICAL_RISK) {
                    criticalHazards++;
                }
                if (hazard.getMitigationStatus() != MitigationStatus.NOT_MITIGATED) {
                    mitigatedHazards++;
                }
            }
            
            // Check blocks without hazards
            for (SafetyCriticalBlock block : model.getRootBlocks()) {
                if (!analysisService.hasAssociatedHazards(block)) {
                    unmappedBlocks++;
                }
            }
            
            // Build report
            StringBuilder report = new StringBuilder();
            report.append("🛡️ HAZARD COVERAGE ANALYSIS\n");
            report.append("═══════════════════════════════\n\n");
            
            report.append(String.format("Total Hazards: %d\n", totalHazards));
            report.append(String.format("  • Catastrophic: %d\n", catastrophicHazards));
            report.append(String.format("  • Critical: %d\n", criticalHazards));
            report.append(String.format("  • Mitigated: %d (%.1f%%)\n\n", 
                mitigatedHazards, totalHazards > 0 ? (mitigatedHazards * 100.0 / totalHazards) : 0));
            
            report.append(String.format("Coverage: %.1f%%\n", metrics.getHazardCoverage() * 100));
            report.append(String.format("Blocks without hazards: %d\n\n", unmappedBlocks));
            
            // Recommendations
            if (catastrophicHazards + criticalHazards > mitigatedHazards) {
                report.append("⚠️ WARNING: Critical hazards require mitigation\n");
            }
            if (unmappedBlocks > 0) {
                report.append("⚠️ WARNING: Some safety blocks lack hazard mapping\n");
            }
            if (metrics.getHazardCoverage() < 0.5) {
                report.append("⚠️ LOW COVERAGE: Add more hazard-block links\n");
            } else if (metrics.getHazardCoverage() >= 0.8) {
                report.append("✅ GOOD COVERAGE: Hazards well-mapped to blocks\n");
            }
            
            showInfo("Hazard Analysis", report.toString());
            
        } catch (Exception e) {
            showError("Hazard analysis failed: " + e.getMessage());
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