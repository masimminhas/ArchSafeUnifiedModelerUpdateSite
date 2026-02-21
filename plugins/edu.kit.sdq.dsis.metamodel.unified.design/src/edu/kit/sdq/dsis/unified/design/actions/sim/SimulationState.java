package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;

/**
 * Singleton holding the current failure propagation simulation state.
 *
 * <h2>Key design: XMI fragment ID as the stable identity key</h2>
 *
 * Both URI-string comparison and raw EObject identity (==) have failed in
 * practice because:
 * <ul>
 *   <li>URI strings differ between a containment object and a resolved proxy.</li>
 *   <li>EObject == fails when Sirius resolves a DRepresentationElement target
 *       via a different code path than EMF resolves a cross-reference, yielding
 *       two distinct Java instances for the same logical element.</li>
 * </ul>
 *
 * The only stable, proxy-independent identifier in XMI is the <b>fragment</b>
 * returned by {@code EcoreUtil.getURI(obj).fragment()} — e.g. {@code "scb_radar"}.
 * This is the {@code xmi:id} attribute written in the file and is identical
 * regardless of how the object was reached (containment walk vs. cross-ref
 * resolution vs. Sirius target lookup).
 *
 * All sets in this class are keyed on fragment strings.  The public service
 * predicates accept {@link EObject} and extract the fragment themselves.
 */
public class SimulationState {

    // ── Singleton ─────────────────────────────────────────────────────────────
    private static SimulationState INSTANCE;
    public static SimulationState getInstance() {
        if (INSTANCE == null) INSTANCE = new SimulationState();
        return INSTANCE;
    }

    // ── State — keyed by XMI fragment (e.g. "scb_radar") ────────────────────
    private final Set<String> sourceIds     = new LinkedHashSet<>();
    private final Set<String> propagatedIds = new LinkedHashSet<>();
    private final Set<String> activeEdgeIds = new LinkedHashSet<>();
    private final List<PropagationStep> log = new ArrayList<>();

    private boolean active = false;
    private String  mode   = "forward";

    // ── Lifecycle ─────────────────────────────────────────────────────────────
    public void beginSimulation(String mode) {
        clear();
        this.mode   = mode != null ? mode : "forward";
        this.active = true;
    }

    public void clear() {
        sourceIds.clear();
        propagatedIds.clear();
        activeEdgeIds.clear();
        log.clear();
        active = false;
        mode   = "forward";
    }

    // ── Mutators (called by engine with already-resolved EObjects) ────────────
    public void addSourceBlock(EObject b)     { String id = frag(b); if (id != null) sourceIds.add(id); }
    public void addPropagatedBlock(EObject b) { String id = frag(b); if (id != null) propagatedIds.add(id); }
    public void addActiveEdge(EObject e)      { String id = frag(e); if (id != null) activeEdgeIds.add(id); }
    public void addPropagationStep(PropagationStep s) { log.add(s); }

    // ── Predicates (called by SimulationServices with EObjects from Sirius) ───
    public boolean isActive()              { return active; }
    public String  getMode()               { return mode; }
    public boolean isSource(EObject b)     { String id = frag(b); return id != null && sourceIds.contains(id); }
    public boolean isPropagated(EObject b) { String id = frag(b); return id != null && propagatedIds.contains(id); }
    public boolean isActiveEdge(EObject e) { String id = frag(e); return id != null && activeEdgeIds.contains(id); }

    // ── Counts / accessors for report/export ─────────────────────────────────
    public int sourceCount()               { return sourceIds.size(); }

    /** Returns an unmodifiable view of the XMI fragment IDs of source blocks. */
    public Set<String> getSourceFragments() { return Collections.unmodifiableSet(sourceIds); }
    public int propagatedCount()           { return propagatedIds.size(); }
    public int edgeCount()                 { return activeEdgeIds.size(); }
    public List<PropagationStep> getLog()  { return Collections.unmodifiableList(log); }

    // ── Fragment extraction ───────────────────────────────────────────────────
    /**
     * Returns the XMI fragment (xmi:id) of the object, e.g. "scb_radar".
     * Returns null if the object has no resource or URI.
     */
    public static String frag(EObject obj) {
        if (obj == null) return null;
        try {
            org.eclipse.emf.common.util.URI uri = EcoreUtil.getURI(obj);
            if (uri == null) return null;
            String f = uri.fragment();
            // For objects without an explicit xmi:id the fragment may be a
            // positional path like "//4" — still unique and stable within a run.
            return (f != null && !f.isEmpty()) ? f : null;
        } catch (Exception e) {
            return null;
        }
    }

    // ── PropagationStep ───────────────────────────────────────────────────────
    public static class PropagationStep {
        public final String fromBlockName;
        public final String toBlockName;
        public final String connectionName;
        public final String connectionType;
        public final String failureEffect;
        public final double failureRate;
        public final int    depth;

        public PropagationStep(String fromBlockName, String toBlockName,
                               String connectionName, String connectionType,
                               String failureEffect, double failureRate, int depth) {
            this.fromBlockName  = fromBlockName;
            this.toBlockName    = toBlockName;
            this.connectionName = connectionName;
            this.connectionType = connectionType;
            this.failureEffect  = failureEffect;
            this.failureRate    = failureRate;
            this.depth          = depth;
        }
    }
}