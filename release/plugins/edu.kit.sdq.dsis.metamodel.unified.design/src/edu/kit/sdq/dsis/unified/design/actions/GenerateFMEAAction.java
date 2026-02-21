package edu.kit.sdq.dsis.unified.design.actions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.AdvancedAnalysisServices;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.UnifiedFactory;
import unified.UnifiedSystemModel;

/**
 * Action handler for automatically generating FMEA items from safety models.
 * Compatible with Sirius IExternalJavaAction interface.
 */
public class GenerateFMEAAction implements IExternalJavaAction {
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        generateFMEA(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    /**
     * Public service method that can be called from AQL or other actions.
     */
    public void generateFMEA(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null) {
                showError("Please select a model element");
                return;
            }
            
            // Confirm with user
            final boolean[] confirmed = {false};
            Display.getDefault().syncExec(() -> {
                confirmed[0] = MessageDialog.openConfirm(
                    Display.getDefault().getActiveShell(),
                    "Generate FMEA Items",
                    "This will automatically generate FMEA items based on your safety models.\n\n" +
                    "Generate items for " + model.getRootBlocks().size() + " safety-critical blocks?"
                );
            });
            
            if (!confirmed[0]) return;
            
            // Generate FMEA items in transaction
            Session session = getSession(model);
            if (session == null) {
                showError("Cannot find active Sirius session");
                return;
            }
            
            TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
            if (domain == null) {
                showError("Cannot access editing domain");
                return;
            }
            
            RecordingCommand command = new RecordingCommand(domain, "Generate FMEA Items") {
                @Override
                protected void doExecute() {
                    AdvancedAnalysisServices service = new AdvancedAnalysisServices();
                    List<FMEAItem> generatedItems = service.generateFMEAItems(model);
                    
                    // Create or get FMEA analysis container
                    FMEAAnalysis analysis;
                    if (model.getFmeaAnalysis().isEmpty()) {
                        analysis = UnifiedFactory.eINSTANCE.createFMEAAnalysis();
                        analysis.setName("Auto-Generated FMEA");
                        analysis.setRpnThreshold(100);
                        model.getFmeaAnalysis().add(analysis);
                    } else {
                        analysis = model.getFmeaAnalysis().get(0);
                    }
                    
                    // Add generated items
                    analysis.getFmeaItems().addAll(generatedItems);
                }
            };
            
            // Execute the command
            domain.getCommandStack().execute(command);
            
            showInfo("FMEA Generation Complete", 
                    "✅ Generated FMEA items successfully\n\n" +
                    "Please review and refine:\n" +
                    "• Severity values\n" +
                    "• Occurrence estimates\n" +
                    "• Detection ratings");
            
        } catch (Exception e) {
            showError("FMEA generation failed: " + e.getMessage());
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
    
    private Session getSession(EObject element) {
        return SessionManager.INSTANCE.getSession(element);
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