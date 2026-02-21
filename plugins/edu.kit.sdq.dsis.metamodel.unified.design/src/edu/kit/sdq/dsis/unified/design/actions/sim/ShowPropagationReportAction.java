package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ShowPropagationReportAction implements IExternalJavaAction {

    @Override public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        SimulationState state = SimulationState.getInstance();
        if (!state.isActive()) {
            runOnUi(() -> MessageDialog.openInformation(activeShell(),
                "Failure Propagation Report",
                "No simulation is currently active.\n\n" +
                "Select a block and use 'Trigger Failure from Selected Block' first."));
            return;
        }
        String text = buildReport(state);
        runOnUi(() -> new ReportDialog(activeShell(), text).open());
    }

    private String buildReport(SimulationState state) {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================\n");
        sb.append("  FAILURE PROPAGATION SIMULATION REPORT\n");
        sb.append("============================================\n\n");
        sb.append("SUMMARY\n--------------------------------------------\n");
        sb.append("  Mode            : ").append(state.getMode().toUpperCase()).append("\n");
        sb.append("  Source block(s) : ").append(state.sourceCount()).append("\n");
        sb.append("  Affected blocks : ").append(state.propagatedCount()).append("\n");
        sb.append("  Active edges    : ").append(state.edgeCount()).append("\n\n");

        List<SimulationState.PropagationStep> log = state.getLog();
        if (log.isEmpty()) {
            sb.append("No propagation steps recorded.\n");
        } else {
            sb.append("PROPAGATION CHAIN  (").append(log.size()).append(" hop(s))\n");
            sb.append("--------------------------------------------\n");
            int lastDepth = -1;
            for (SimulationState.PropagationStep s : log) {
                if (s.depth != lastDepth) {
                    sb.append("\n  -- Depth ").append(s.depth).append(" --\n"); lastDepth = s.depth;
                }
                sb.append("  ").append(s.fromBlockName).append("  -->  ").append(s.toBlockName).append("\n");
                sb.append("     Connection : ").append(s.connectionName).append("  [").append(s.connectionType).append("]\n");
                if (s.failureEffect != null && !s.failureEffect.isBlank())
                    sb.append("     Effect     : ").append(s.failureEffect).append("\n");
                if (s.failureRate > 0)
                    sb.append(String.format("     Fail. Rate : %.2e /hr%n", s.failureRate));
            }
        }
        sb.append("\n============================================\n");
        sb.append("Tip: 'Identify Critical Path' shows the highest-risk chain.\n");
        sb.append("Tip: 'Export Simulation Report' saves this to a .txt file.\n");
        return sb.toString();
    }

    private void runOnUi(Runnable r) {
        var d = org.eclipse.swt.widgets.Display.getDefault();
        if (d.getThread() == Thread.currentThread()) r.run(); else d.syncExec(r);
    }

    private Shell activeShell() {
        Shell s = Display.getDefault().getActiveShell();
        return s != null ? s : new Shell(Display.getDefault());
    }

    private static final class ReportDialog extends TitleAreaDialog {
        private final String text;
        private Font mono;
        ReportDialog(Shell p, String text) { super(p); this.text = text; setShellStyle(getShellStyle()|SWT.RESIZE|SWT.MAX); }
        @Override public void create() { super.create(); setTitle("Failure Propagation Simulation Report"); setMessage("Propagation chain from the selected failure source block."); }
        @Override protected Control createDialogArea(Composite parent) {
            Composite area = (Composite) super.createDialogArea(parent);
            Composite c = new Composite(area, SWT.NONE);
            c.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
            c.setLayout(new GridLayout(1,false));
            mono = new Font(parent.getDisplay(),"Courier New",9,SWT.NORMAL);
            Text t = new Text(c, SWT.MULTI|SWT.BORDER|SWT.READ_ONLY|SWT.H_SCROLL|SWT.V_SCROLL);
            t.setFont(mono); t.setText(text);
            GridData gd = new GridData(SWT.FILL,SWT.FILL,true,true); gd.widthHint=680; gd.heightHint=480;
            t.setLayoutData(gd);
            return area;
        }
        @Override protected void createButtonsForButtonBar(Composite p) { createButton(p,IDialogConstants.CLOSE_ID,IDialogConstants.CLOSE_LABEL,true); }
        @Override protected void buttonPressed(int id) { if(id==IDialogConstants.CLOSE_ID)close(); else super.buttonPressed(id); }
        @Override public boolean close() { if(mono!=null&&!mono.isDisposed())mono.dispose(); return super.close(); }
        @Override protected Point getInitialSize() { return new Point(720,560); }
        @Override protected void configureShell(Shell s) { super.configureShell(s); s.setText("Failure Propagation Report"); }
    }
}