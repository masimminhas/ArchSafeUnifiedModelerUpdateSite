package edu.kit.sdq.dsis.metamodel.unified.design;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.business.api.session.ViewpointSelector;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * Auto-selects the ArchSafe {@code UnifiedModeling} viewpoint whenever a Sirius
 * session is opened.
 *
 * <p>Sirius registers a viewpoint (here via the
 * {@code org.eclipse.sirius.componentization} extension) but does <em>not</em>
 * automatically enable it for a session. When a case-study {@code .aird} is
 * opened in a fresh workspace and the stored selection does not re-apply,
 * Sirius parks all representations under "Invalid representations" with the
 * viewpoint greyed out, forcing the user to enable it manually via
 * <em>Viewpoints Selection</em>. This listener performs that selection
 * automatically so the diagrams are available by default.</p>
 */
public class ViewpointAutoSelector extends SessionManagerListener.Stub {

    private static final String VIEWPOINT_NAME = "UnifiedModeling";

    @Override
    public void notifyAddSession(Session session) {
        ensureSelected(session);
    }

    @Override
    public void notify(Session session, int changeKind) {
        // A session may be added before it is fully open; also react on OPENED.
        if (changeKind == SessionListener.OPENED) {
            ensureSelected(session);
        }
    }

    /** Selects the UnifiedModeling viewpoint for {@code session} if not already enabled. */
    public void ensureSelected(Session session) {
        if (session == null || !session.isOpen()) {
            return;
        }
        Viewpoint viewpoint = findViewpoint(VIEWPOINT_NAME);
        if (viewpoint == null) {
            return; // viewpoint not registered (should not happen in the product)
        }
        for (Viewpoint selected : session.getSelectedViewpoints(false)) {
            if (VIEWPOINT_NAME.equals(selected.getName())) {
                return; // already enabled for this session
            }
        }
        try {
            // 'false' => enable the viewpoint without creating new blank
            // representations; the existing case-study representations become valid.
            new ViewpointSelector(session).selectViewpoint(viewpoint, false, new NullProgressMonitor());
        } catch (Exception e) {
            System.err.println("ArchSafe: could not auto-select viewpoint '"
                + VIEWPOINT_NAME + "': " + e.getMessage());
        }
    }

    private Viewpoint findViewpoint(String name) {
        for (Viewpoint viewpoint : ViewpointRegistry.getInstance().getViewpoints()) {
            if (name.equals(viewpoint.getName())) {
                return viewpoint;
            }
        }
        return null;
    }
}
