package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;

import java.util.Collection;
import java.util.Map;

public class TriggerFailurePropagationAction implements IExternalJavaAction {

    @Override public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        EObject sourceBlock = resolveBlock(selections, parameters);
        if (sourceBlock == null) {
            showError("No valid SystemBlock or SafetyCriticalBlock selected.\n" +
                      "Click a block node first, then trigger the action.");
            return;
        }

        String mode = "forward";
        Object mp = parameters.get("mode");
        if (mp instanceof String && !((String) mp).isBlank()) mode = (String) mp;

        EObject modelRoot = findModelRoot(sourceBlock);
        if (modelRoot == null) {
            showError("Cannot find UnifiedSystemModel root from the selected block.");
            return;
        }

        SimulationState state = new FailurePropagationEngine(modelRoot).propagate(sourceBlock, mode);
        refreshDiagram(sourceBlock);

        showInfo(String.format(
            "Failure Propagation Complete\n\n" +
            "  Source      : %s\n" +
            "  Mode        : %s\n" +
            "  Affected    : %d block(s)\n" +
            "  Active edges: %d\n\n" +
            "Blocks and edges are now highlighted.\n" +
            "Use 'Show Propagation Report' for the full chain.",
            strF(sourceBlock, "name"), mode.toUpperCase(),
            state.propagatedCount(), state.edgeCount()));
    }

    private void refreshDiagram(EObject sem) {
        try {
            Session session = SessionManager.INSTANCE.getSession(sem);
            if (session == null) return;
            TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
            domain.getCommandStack().execute(
                new RecordingCommand(domain, "FPS Refresh") {
                    @Override protected void doExecute() { }
                });
            Display.getDefault().syncExec(() -> {
                for (DRepresentation r : DialectManager.INSTANCE.getAllRepresentations(session))
                    try { DialectManager.INSTANCE.refresh(r,
                        new org.eclipse.core.runtime.NullProgressMonitor());
                    } catch (Exception ignored) { }
            });
        } catch (Exception e) {
            System.err.println("[FPS] refresh failed: " + e.getMessage());
        }
    }

    private EObject resolveBlock(Collection<? extends EObject> sel, Map<String, Object> params) {
        Object p = params.get("sourceBlock");
        if (p instanceof EObject && isBlock((EObject) p)) return (EObject) p;
        for (EObject e : sel) {
            EObject s = sem(e);
            if (s != null && isBlock(s)) return s;
        }
        return null;
    }

    private boolean isBlock(EObject o) {
        String n = o.eClass().getName();
        return "SystemBlock".equals(n) || "SafetyCriticalBlock".equals(n);
    }

    private EObject sem(EObject v) {
        return (v instanceof DRepresentationElement)
            ? ((DRepresentationElement) v).getTarget() : v;
    }

    private EObject findModelRoot(EObject o) {
        while (o != null) {
            if ("UnifiedSystemModel".equals(o.eClass().getName())) return o;
            o = o.eContainer();
        }
        return null;
    }

    private String strF(EObject o, String f) {
        try {
            var feat = o.eClass().getEStructuralFeature(f);
            Object v = feat != null ? o.eGet(feat) : null;
            return v != null ? v.toString() : "<unnamed>";
        } catch (Exception e) { return "<?>"; }
    }

    private void showInfo(String m) {
        try { MessageDialog.openInformation(Display.getDefault().getActiveShell(),
            "Failure Propagation Simulation", m);
        } catch (Exception ignored) { System.out.println("[FPS] " + m); }
    }

    private void showError(String m) {
        try { MessageDialog.openError(Display.getDefault().getActiveShell(),
            "Failure Propagation – Error", m);
        } catch (Exception ignored) { System.err.println("[FPS] " + m); }
    }
}