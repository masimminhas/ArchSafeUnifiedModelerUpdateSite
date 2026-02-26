package edu.kit.sdq.dsis.metamodel.unified.design;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.IStartup;

import java.util.Set;

public class ViewpointStartup implements IStartup {

    @Override
    public void earlyStartup() {
        System.out.println(">>> ARCHSAFE STARTUP: earlyStartup() called - workspace is ready");
        try {
            Set<Viewpoint> viewpoints = ViewpointRegistry.getInstance()
                .registerFromPlugin(Activator.PLUGIN_ID + "/description/unified.odesign");
            System.out.println(">>> ARCHSAFE STARTUP: Registered "
                + viewpoints.size() + " viewpoint(s):");
            for (Viewpoint vp : viewpoints) {
                System.out.println(">>>   - " + vp.getName());
            }
        } catch (Exception e) {
            System.err.println(">>> ARCHSAFE STARTUP ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}