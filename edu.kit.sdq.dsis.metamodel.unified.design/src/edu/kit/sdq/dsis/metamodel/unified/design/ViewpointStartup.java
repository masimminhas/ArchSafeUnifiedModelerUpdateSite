package edu.kit.sdq.dsis.metamodel.unified.design;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;

/**
 * Workbench startup hook (guaranteed to run when the workbench comes up).
 *
 * <p>Two responsibilities:</p>
 * <ul>
 *   <li>register {@link ViewpointAutoSelector} so the UnifiedModeling viewpoint
 *       is auto-enabled for every opened session (case-study representations are
 *       valid by default);</li>
 *   <li>default the UI to the <em>Light</em> theme on the first launch of a
 *       workspace. This RCP bundles only {@code e4_default} (Light),
 *       {@code e4_dark} and {@code e4_system}; without this, Eclipse&nbsp;4.30
 *       follows the Windows OS dark mode. We do it once (guarded by a marker
 *       preference) so a user who later picks Dark keeps that choice.</li>
 * </ul>
 */
public class ViewpointStartup implements IStartup {

    private static final String LIGHT_THEME_ID = "org.eclipse.e4.ui.css.theme.e4_default";
    private static final String THEME_DEFAULTED_PREF = "themeDefaulted";

    @Override
    public void earlyStartup() {
        // 1) viewpoint auto-selection
        ViewpointAutoSelector selector = new ViewpointAutoSelector();
        SessionManager.INSTANCE.addSessionsListener(selector);
        for (Session session : SessionManager.INSTANCE.getSessions()) {
            selector.ensureSelected(session);
        }
        // 2) default theme (once per workspace)
        applyDefaultThemeOnce();
    }

    private void applyDefaultThemeOnce() {
        final IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
        if (prefs.getBoolean(THEME_DEFAULTED_PREF, false)) {
            return; // already defaulted in this workspace; respect the user's choice
        }
        final Display display = PlatformUI.getWorkbench().getDisplay();
        if (display == null || display.isDisposed()) {
            return;
        }
        display.asyncExec(() -> {
            try {
                IThemeEngine engine = PlatformUI.getWorkbench().getService(IThemeEngine.class);
                if (engine != null) {
                    engine.setTheme(LIGHT_THEME_ID, true); // apply + persist
                }
                prefs.putBoolean(THEME_DEFAULTED_PREF, true);
                prefs.flush();
            } catch (Exception e) {
                System.err.println("ArchSafe: could not set default Light theme: " + e.getMessage());
            }
        });
    }
}
