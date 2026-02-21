package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Shows a failure-mode picker dialog for the selected SafetyCriticalBlock,
 * then runs propagation via the fixed engine and refreshes the diagram.
 */
public class TriggerFromFailureModeAction implements IExternalJavaAction {

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        EObject sourceBlock = resolveBlock(selections, parameters);
        if (sourceBlock == null) { showError("No valid SafetyCriticalBlock selected."); return; }

        List<EObject> modes = failureModes(sourceBlock);
        if (modes.isEmpty()) { showError("Selected block has no failure modes defined."); return; }

        EObject chosen = pickMode(modes, str(sourceBlock, "name"));
        if (chosen == null) return;

        EObject modelRoot = findModelRoot(sourceBlock);
        if (modelRoot == null) { showError("Cannot find UnifiedSystemModel root."); return; }

        SimulationState state = new FailurePropagationEngine(modelRoot)
                .propagate(sourceBlock, "forward");

        refreshDiagram(sourceBlock);

        showInfo(String.format(
            "Failure Mode Propagation Complete\n\n" +
            "  Block        : %s\n" +
            "  Failure Mode : %s  (\u03bb=%.2e /hr)\n" +
            "  Effect       : %s\n\n" +
            "  Affected     : %d block(s)\n" +
            "  Active edges : %d\n\n" +
            "Use 'Show Propagation Report' for details.",
            str(sourceBlock, "name"),
            str(chosen, "name"), dbl(chosen, "failureRate"),
            str(chosen, "failureEffect") != null ? str(chosen, "failureEffect") : "(not set)",
            state.propagatedCount(),
            state.edgeCount()));
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private EObject pickMode(List<EObject> modes, String blockName) {
        String[] labels = modes.stream()
            .map(m -> str(m, "name") +
                      String.format("  [\u03bb=%.2e/hr]", dbl(m, "failureRate")) +
                      "  — " + (str(m, "failureEffect") != null
                                 ? str(m, "failureEffect") : "(no effect defined)"))
            .toArray(String[]::new);
        ListDialog dlg = new ListDialog(Display.getDefault().getActiveShell());
        dlg.setTitle("Select Failure Mode — " + blockName);
        dlg.setMessage("Choose the failure mode to inject:");
        dlg.setContentProvider(new ArrayContentProvider());
        dlg.setLabelProvider(new LabelProvider());
        dlg.setInput(labels);
        dlg.setInitialSelections(new Object[]{ labels[0] });
        if (dlg.open() != org.eclipse.jface.window.Window.OK) return null;
        Object[] result = dlg.getResult();
        if (result == null || result.length == 0) return null;
        for (int i = 0; i < labels.length; i++)
            if (labels[i].equals(result[0])) return modes.get(i);
        return null;
    }

    private List<EObject> failureModes(EObject block) {
        List<EObject> out = new ArrayList<>();
        try {
            var f = block.eClass().getEStructuralFeature("failureModes");
            if (f == null) return out;
            Object v = block.eGet(f);
            if (v instanceof List<?>) for (Object o : (List<?>) v)
                if (o instanceof EObject) out.add((EObject) o);
        } catch (Exception ignored) { }
        return out;
    }

    private void refreshDiagram(EObject sem) {
        try {
            Session s = SessionManager.INSTANCE.getSession(sem);
            if (s == null) return;
            TransactionalEditingDomain d = s.getTransactionalEditingDomain();
            d.getCommandStack().execute(new RecordingCommand(d, "Simulation State Change") {
                @Override protected void doExecute() { }
            });
            Display.getDefault().syncExec(() -> {
                for (DRepresentation r : DialectManager.INSTANCE.getAllRepresentations(s))
                    try { DialectManager.INSTANCE.refresh(r,
                        new org.eclipse.core.runtime.NullProgressMonitor());
                    } catch (Exception ignored) { }
            });
        } catch (Exception e) { System.err.println("[FPS] refresh failed: " + e.getMessage()); }
    }

    private EObject resolveBlock(Collection<? extends EObject> sel,
                                  Map<String, Object> params) {
        Object p = params.get("sourceBlock");
        if (p instanceof EObject && isBlock((EObject) p)) return (EObject) p;
        for (EObject e : sel) { EObject s = toSem(e); if (s != null && isBlock(s)) return s; }
        return null;
    }

    private boolean isBlock(EObject o) {
        String n = o.eClass().getName();
        return "SystemBlock".equals(n) || "SafetyCriticalBlock".equals(n);
    }

    private EObject toSem(EObject v) {
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

    private String str(EObject o, String f) {
        try {
            var feat = o.eClass().getEStructuralFeature(f);
            if (feat == null) return null;
            Object v = o.eGet(feat);
            return v != null ? v.toString() : null;
        } catch (Exception e) { return null; }
    }

    private double dbl(EObject o, String f) {
        try {
            var feat = o.eClass().getEStructuralFeature(f);
            if (feat == null) return 0;
            Object v = o.eGet(feat);
            return (v instanceof Number) ? ((Number) v).doubleValue() : 0;
        } catch (Exception e) { return 0; }
    }

    private void showInfo(String msg) {
        try { MessageDialog.openInformation(Display.getDefault().getActiveShell(),
            "Failure Mode Propagation", msg);
        } catch (Exception ignored) { System.out.println("[FPS] " + msg); }
    }

    private void showError(String msg) {
        try { MessageDialog.openError(Display.getDefault().getActiveShell(),
            "Failure Mode Propagation — Error", msg);
        } catch (Exception ignored) { System.err.println("[FPS ERROR] " + msg); }
    }
}