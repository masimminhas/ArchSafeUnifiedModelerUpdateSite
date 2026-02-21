package edu.kit.sdq.dsis.unified.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

public class TestAction implements IExternalJavaAction {
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        System.out.println("========================================");
        System.out.println("TEST ACTION EXECUTED!");
        System.out.println("Selections size: " + (selections != null ? selections.size() : "null"));
        System.out.println("========================================");
        
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openInformation(
                Display.getDefault().getActiveShell(),
                "Test Action",
                "TEST ACTION WORKS!\n\nIf you see this, the action infrastructure is working."
            );
        });
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        System.out.println("TEST ACTION canExecute called: " + (selections != null && !selections.isEmpty()));
        return selections != null && !selections.isEmpty();
    }
}