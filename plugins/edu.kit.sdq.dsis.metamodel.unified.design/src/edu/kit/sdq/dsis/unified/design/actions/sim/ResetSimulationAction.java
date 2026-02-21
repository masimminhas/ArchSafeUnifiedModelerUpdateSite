package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;

import java.util.Collection;
import java.util.Map;

public class ResetSimulationAction implements IExternalJavaAction {

    @Override public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {
        SimulationState.getInstance().clear();
        EObject sem = null;
        for (EObject e : selections) {
            sem = (e instanceof DRepresentationElement) ? ((DRepresentationElement) e).getTarget() : e;
            if (sem != null) break;
        }
        if (sem != null) refresh(sem);
    }

    private void refresh(EObject sem) {
        try {
            Session s = SessionManager.INSTANCE.getSession(sem);
            if (s == null) return;
            TransactionalEditingDomain d = s.getTransactionalEditingDomain();
            d.getCommandStack().execute(new RecordingCommand(d, "FPS Reset") {
                @Override protected void doExecute() {}
            });
            Display.getDefault().syncExec(() -> {
                for (DRepresentation r : DialectManager.INSTANCE.getAllRepresentations(s))
                    try { DialectManager.INSTANCE.refresh(r,
                        new org.eclipse.core.runtime.NullProgressMonitor());
                    } catch (Exception ignored) {}
            });
        } catch (Exception e) { System.err.println("[FPS] reset refresh: " + e.getMessage()); }
    }
}