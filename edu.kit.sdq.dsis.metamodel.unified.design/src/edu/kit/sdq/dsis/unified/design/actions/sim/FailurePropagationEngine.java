package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;

import java.util.*;

/**
 * BFS failure propagation engine.
 *
 * <p>Uses XMI fragment IDs (via {@link SimulationState#frag}) as the
 * visited-set key so that the same logical block is recognised regardless
 * of whether it was reached as a containment child, a resolved cross-ref,
 * or a Sirius DRepresentationElement target.</p>
 *
 * <p>Connection traversal still uses {@code EObject ==} for the
 * "is this block the current node?" check — but the source block passed
 * in is first <em>canonicalised</em>: we look it up in the model-root's
 * own containment list by fragment ID, guaranteeing we use the exact same
 * Java instance that the connections' fromBlock/toBlock cross-refs resolve to.</p>
 */
public class FailurePropagationEngine {

    private final EObject modelRoot;

    public FailurePropagationEngine(EObject modelRoot) {
        this.modelRoot = modelRoot;
    }

    public SimulationState propagate(EObject sourceBlock, String mode) {

        // ── Canonicalise the source block ─────────────────────────────────────
        // The sourceBlock arrives from Sirius (via DRepresentationElement.getTarget()).
        // The BlockConnection fromBlock/toBlock cross-refs resolve through EMF's
        // resource set.  On some Eclipse versions these are DIFFERENT Java instances
        // even for the same logical element.  Fix: find the object in the model
        // containment tree by fragment ID and use THAT instance for BFS.
        String sourceFrag = SimulationState.frag(sourceBlock);
        EObject canonical = findByFragment(sourceFrag);
        if (canonical != null) sourceBlock = canonical;

        SimulationState state = SimulationState.getInstance();
        state.beginSimulation(mode);
        state.addSourceBlock(sourceBlock);

        boolean forward  = !"backward".equals(mode);
        boolean backward = !"forward".equals(mode);

        // BFS visited set: fragment ID → depth
        Map<String, Integer> visited = new LinkedHashMap<>();
        // BFS queue carries the actual EObject instances from the model
        Queue<EObject> queue = new LinkedList<>();

        String srcFrag = SimulationState.frag(sourceBlock);
        visited.put(srcFrag, 0);
        queue.add(sourceBlock);

        List<?> connections = listF(modelRoot, "blockConnections");

        while (!queue.isEmpty()) {
            EObject current     = queue.poll();
            String  currentFrag = SimulationState.frag(current);
            int     depth       = visited.getOrDefault(currentFrag, 0);

            for (Object raw : connections) {
                if (!(raw instanceof EObject)) continue;
                EObject conn = (EObject) raw;

                // fromBlock and toBlock are upperBound=-1 (EList) in the metamodel —
                // ref() returns null for multi-valued refs because EList is not EObject.
                // Use listF() and take the first element (lowerBound=1 guarantees one exists).
                EObject from = firstOf(listF(conn, "fromBlock"));
                EObject to   = firstOf(listF(conn, "toBlock"));
                if (from == null || to == null) continue;

                String fromFrag = SimulationState.frag(from);
                String toFrag   = SimulationState.frag(to);
                if (fromFrag == null || toFrag == null) continue;

                boolean fromIsCurrent = fromFrag.equals(currentFrag);
                boolean toIsCurrent   = toFrag.equals(currentFrag);
                boolean toVisited     = visited.containsKey(toFrag);
                boolean fromVisited   = visited.containsKey(fromFrag);

                if (forward && fromIsCurrent && !toVisited) {
                    visited.put(toFrag, depth + 1);
                    state.addPropagatedBlock(to);
                    state.addActiveEdge(conn);
                    state.addPropagationStep(buildStep(from, to, conn, depth + 1, true));
                    queue.add(to);

                } else if (backward && toIsCurrent && !fromVisited) {
                    visited.put(fromFrag, depth + 1);
                    state.addPropagatedBlock(from);
                    state.addActiveEdge(conn);
                    state.addPropagationStep(buildStep(to, from, conn, depth + 1, false));
                    queue.add(from);

                } else if ((fromIsCurrent && toVisited) || (toIsCurrent && fromVisited)) {
                    state.addActiveEdge(conn);
                }
            }
        }

        return state;
    }

    // ── Find canonical EObject by XMI fragment ────────────────────────────────
    /**
     * Walks all containment lists that hold blocks/connections and returns
     * the EObject whose fragment matches {@code frag}.  This gives us the
     * exact same Java instance that EMF's cross-reference resolution returns
     * for fromBlock/toBlock, preventing false == mismatches.
     * Also recurses into SystemBlock.subBlocks so nested blocks are found.
     */
    private EObject findByFragment(String frag) {
        if (frag == null) return null;
        for (String listName : new String[]{"rootBlocks", "systemBlocks", "blockConnections"}) {
            for (Object o : listF(modelRoot, listName)) {
                if (!(o instanceof EObject)) continue;
                EObject e = (EObject) o;
                if (frag.equals(SimulationState.frag(e))) return e;
                // Recurse into subBlocks for nested SystemBlock hierarchies
                EObject nested = findInSubBlocks(e, frag);
                if (nested != null) return nested;
            }
        }
        return null;
    }

    private EObject findInSubBlocks(EObject block, String frag) {
        for (Object o : listF(block, "subBlocks")) {
            if (!(o instanceof EObject)) continue;
            EObject sub = (EObject) o;
            if (frag.equals(SimulationState.frag(sub))) return sub;
            EObject nested = findInSubBlocks(sub, frag);
            if (nested != null) return nested;
        }
        return null;
    }

    // ── Step builder ──────────────────────────────────────────────────────────
    private SimulationState.PropagationStep buildStep(
            EObject from, EObject to, EObject conn, int depth, boolean fwd) {
        String connType = strF(conn, "connectionType");
        String effect   = null;
        double rate     = 0.0;
        EObject src = fwd ? from : to;
        List<?> modes = listF(src, "failureModes");
        if (!modes.isEmpty() && modes.get(0) instanceof EObject) {
            EObject fm = (EObject) modes.get(0);
            effect = strF(fm, "failureEffect");
            Object r = fm.eGet(fm.eClass().getEStructuralFeature("failureRate"));
            if (r instanceof Number) rate = ((Number) r).doubleValue();
        }
        return new SimulationState.PropagationStep(
            strF(from, "name"), strF(to, "name"),
            strF(conn, "name"), connType,
            effect, rate, depth);
    }

    // ── EMF helpers ───────────────────────────────────────────────────────────

    /** Returns the first element of a list, or null if empty. */
    private EObject firstOf(List<?> list) {
        if (list == null || list.isEmpty()) return null;
        Object first = list.get(0);
        return (first instanceof EObject) ? (EObject) first : null;
    }

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
            if (f == null) return Collections.emptyList();
            Object v = obj.eGet(f);
            return (v instanceof List) ? (List<?>) v : Collections.emptyList();
        } catch (Exception e) { return Collections.emptyList(); }
    }

    private String strF(EObject obj, String feature) {
        try {
            var f = obj.eClass().getEStructuralFeature(feature);
            if (f == null) return "<unknown>";
            Object v = obj.eGet(f);
            return v != null ? v.toString() : "<unnamed>";
        } catch (Exception e) { return "<err>"; }
    }
}