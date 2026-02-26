package edu.kit.sdq.dsis.metamodel.unified.design;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID =
        "edu.kit.sdq.dsis.metamodel.unified.design";

    private static Activator plugin;

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        System.out.println(">>> ARCHSAFE ACTIVATOR: start() called - workspace not ready yet, deferring viewpoint registration");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static Activator getDefault() {
        return plugin;
    }
}