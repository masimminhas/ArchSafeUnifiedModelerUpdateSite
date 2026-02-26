package edu.kit.sdq.dsis.unified.design.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import unified.SafetyCriticalBlock;
import unified.UnifiedSystemModel;

public class ValidateConsistencyAction implements IExternalJavaAction {
    
    // IExternalJavaAction implementation
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        validateModel(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    // Public service method that can be called from AQL
    public void validateModel(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }
            
            AdvancedAnalysisServices service = new AdvancedAnalysisServices();
            
            // Run validation
            List<String> violations = new ArrayList<>();
            
            // Check each safety-critical block
            for (SafetyCriticalBlock block : model.getRootBlocks()) {
                if (!service.hasAssociatedHazards(block)) {
                    violations.add("✗ Block '" + block.getName() + "' has no associated hazards");
                }
                if (!service.requiresFMEAValidation(block)) {
                    violations.add("⚠️ High-criticality block '" + block.getName() + "' missing FMEA");
                }
            }
            
            // Show results
            if (violations.isEmpty()) {
                showInfo("✅ Validation Passed", "No consistency violations found!");
            } else {
                String message = "Found " + violations.size() + " issues:\n\n" +
                               String.join("\n", violations);
                showWarning("Validation Results", message);
            }
            
        } catch (Exception e) {
            showError("Validation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Helper methods
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
    
    private void showWarning(String title, String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openWarning(Display.getDefault().getActiveShell(), title, message);
        });
    }
    
    private void showError(String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", message);
        });
    }
}