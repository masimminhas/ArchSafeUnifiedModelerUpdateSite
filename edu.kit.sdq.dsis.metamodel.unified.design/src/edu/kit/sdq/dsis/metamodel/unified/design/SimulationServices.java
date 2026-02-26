package edu.kit.sdq.dsis.metamodel.unified.design;

import edu.kit.sdq.dsis.unified.design.actions.sim.SimulationState;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

/**
 * Sirius AQL service class for the Failure Propagation Simulation diagram.
 *
 * <p>Registered in the odesign as a java extension so all {@code service:XXX}
 * predicate expressions in conditional styles resolve here.  Every method
 * takes an {@link EObject} as its first parameter — that is the AQL
 * {@code self} object.  Sirius passes the semantic element of each node or
 * edge directly, so no DRepresentationElement unwrapping is needed.</p>
 *
 * <p>All predicates delegate to {@link SimulationState#getInstance()} which
 * holds the fragment-keyed sets written by the engine after propagation.</p>
 */
public class SimulationServices {

    // ── Block node conditional styles ─────────────────────────────────────────

    /**
     * Returns true when {@code self} is the block where the failure was
     * injected (the red SOURCE node style).
     * Called by: FPS_SystemBlock_Node, FPS_SafetyBlock_Node
     */
    public boolean isSimulationSource(EObject self) {
        return SimulationState.getInstance().isSource(self);
    }

    /**
     * Returns true when {@code self} is a block that was reached during
     * propagation (the orange PROPAGATED node style).
     * Called by: FPS_SystemBlock_Node, FPS_SafetyBlock_Node
     */
    public boolean isSimulationPropagated(EObject self) {
        return SimulationState.getInstance().isPropagated(self);
    }

    // ── Connection edge conditional style ─────────────────────────────────────

    /**
     * Returns true when {@code self} (a {@code BlockConnection}) is on an
     * active propagation path (the thick red edge style).
     * Called by: FPS_BlockConnection_Edge
     */
    public boolean isSimulationPropagationEdge(EObject self) {
        return SimulationState.getInstance().isActiveEdge(self);
    }

    // ── Hazard layer conditional styles ───────────────────────────────────────

    /**
     * Returns true when {@code self} (an {@code IntegratedHazard}) is linked
     * to at least one block that was propagated or sourced.
     * Called by: FPS_Hazard_Node (HazardActivation layer)
     */
    public boolean isHazardActivatedBySimulation(EObject self) {
        SimulationState state = SimulationState.getInstance();
        if (!state.isActive()) return false;
        // A hazard is "activated" if any of its relatedBlocks was hit by the sim
        for (Object block : listF(self, "relatedBlocks")) {
            if (!(block instanceof EObject)) continue;
            EObject b = (EObject) block;
            if (state.isSource(b) || state.isPropagated(b)) return true;
        }
        return false;
    }

    /**
     * Returns true when the hazard-to-block edge should be highlighted.
     * The edge domain class is {@code IntegratedHazard} (self = hazard),
     * so the same logic as {@link #isHazardActivatedBySimulation} applies.
     * Called by: FPS_HazardToBlock_Edge
     */
    public boolean isHazardEdgeActivated(EObject self) {
        return isHazardActivatedBySimulation(self);
    }

    // ── FMEA layer conditional style ──────────────────────────────────────────

    /**
     * Returns true when {@code self} (an {@code FMEAItem}) analyses a
     * component that was hit during propagation.
     * Called by: FPS_FMEAItem_Node, FPS_FMEAToBlock_Edge
     */
    public boolean isFMEAItemImplicatedBySimulation(EObject self) {
        SimulationState state = SimulationState.getInstance();
        if (!state.isActive()) return false;
        // FMEAItem.analyzedComponent is a single-valued ref (upper=1)
        EObject comp = ref(self, "analyzedComponent");
        return comp != null && (state.isSource(comp) || state.isPropagated(comp));
    }

    // ── EMF helpers ───────────────────────────────────────────────────────────

    private EObject ref(EObject obj, String feature) {
        try {
            var f = obj.eClass().getEStructuralFeature(feature);
            if (f == null) return null;
            Object v = obj.eGet(f, true);
            return (v instanceof EObject) ? (EObject) v : null;
        } catch (Exception e) { return null; }
    }

    @SuppressWarnings("unchecked")
    private List<?> listF(EObject obj, String feature) {
        try {
            var f = obj.eClass().getEStructuralFeature(feature);
            if (f == null) return java.util.Collections.emptyList();
            Object v = obj.eGet(f);
            return (v instanceof List) ? (List<?>) v : java.util.Collections.emptyList();
        } catch (Exception e) { return java.util.Collections.emptyList(); }
    }
}