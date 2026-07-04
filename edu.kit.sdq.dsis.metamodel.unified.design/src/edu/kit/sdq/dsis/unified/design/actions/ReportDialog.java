package edu.kit.sdq.dsis.unified.design.actions;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * A resizable, scrollable, monospaced dialog for long analysis and validation
 * reports.
 *
 * <p>The plug-in previously showed reports with {@code MessageDialog.openInformation},
 * which sizes itself to its content and does not scroll, so a long report (for
 * example a full ASIL propagation listing) grows past the screen with no way to
 * reach the bottom. This dialog caps its initial size and adds scroll bars, while
 * short messages still appear compactly. The read-only text uses the JFace text
 * font (monospaced) so the ASCII table and box-drawing headers in the reports
 * line up.</p>
 */
public class ReportDialog extends Dialog {

    private static final int MAX_W = 900;
    private static final int MAX_H = 640;
    private static final int MIN_W = 420;
    private static final int MIN_H = 180;

    private final String title;
    private final String message;

    public ReportDialog(Shell parent, String title, String message) {
        super(parent);
        this.title = title != null ? title : "";
        this.message = message != null ? message : "";
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(title);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        Text text = new Text(container,
                SWT.MULTI | SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        text.setText(message);
        // JFace text font is monospaced across platforms; it is shared and managed,
        // so it must not be disposed here.
        text.setFont(JFaceResources.getTextFont());
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        return container;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    @Override
    protected Point getInitialSize() {
        Point pref = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
        int w = Math.max(MIN_W, Math.min(pref.x, MAX_W));
        int h = Math.max(MIN_H, Math.min(pref.y, MAX_H));
        Rectangle screen = getShell().getDisplay().getClientArea();
        w = Math.min(w, screen.width - 80);
        h = Math.min(h, screen.height - 80);
        return new Point(w, h);
    }

    /**
     * Thread-safe entry point. Safe to call from any thread and from within an
     * existing {@code Display.syncExec} block: when already on the UI thread it
     * opens directly, otherwise it marshals onto the UI thread.
     */
    public static void show(String title, String message) {
        Runnable open = () -> new ReportDialog(
                Display.getDefault().getActiveShell(), title, message).open();
        if (Display.getCurrent() != null) {
            open.run();
        } else {
            Display.getDefault().syncExec(open);
        }
    }
}
