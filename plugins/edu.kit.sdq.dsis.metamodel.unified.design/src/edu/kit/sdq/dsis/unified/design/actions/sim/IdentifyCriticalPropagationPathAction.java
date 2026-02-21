package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;

import java.util.*;

/**
 * Identifies the critical (highest cumulative RPN) propagation path.
 *
 * Builds an adjacency map keyed on XMI fragment IDs — the same keys stored
 * in {@link SimulationState} — so edge membership tests are always correct.
 */
public class IdentifyCriticalPropagationPathAction implements IExternalJavaAction {

    private static final int MAX_DEPTH = 20;

    @Override public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        SimulationState state = SimulationState.getInstance();
        if (!state.isActive() || state.sourceCount() == 0) {
            info("No simulation active. Trigger a failure propagation first."); return;
        }

        // ── Locate model root ─────────────────────────────────────────────────
        EObject modelRoot = null;
        for (EObject sel : selections) {
            EObject s = sem(sel); if (s != null) { modelRoot = root(s); if (modelRoot != null) break; }
        }
        if (modelRoot == null) {
            // Fallback: no selection available — try to reach the model root by
            // finding any block whose fragment matches a source ID in the session.
            // We iterate selections a second time looking for any EObject with a container.
            for (EObject sel : selections) {
                EObject s = (sel instanceof DRepresentationElement)
                    ? ((DRepresentationElement) sel).getTarget() : sel;
                if (s == null) continue;
                modelRoot = root(s);
                if (modelRoot != null) break;
            }
        }
        if (modelRoot == null) { err("Cannot locate UnifiedSystemModel."); return; }

        // ── Build fragment→name and fragment→maxRPN maps ──────────────────────
        Map<String, String>  fragToName = new LinkedHashMap<>();
        Map<String, Integer> fragToRpn  = new LinkedHashMap<>();

        for (String listName : new String[]{"rootBlocks", "systemBlocks"}) {
            for (Object o : listF(modelRoot, listName)) {
                if (!(o instanceof EObject)) continue;
                EObject b = (EObject) o;
                String frag = SimulationState.frag(b);
                if (frag != null) fragToName.put(frag, strF(b, "name"));
            }
        }
        for (Object fa : listF(modelRoot, "fmeaAnalysis")) {
            if (!(fa instanceof EObject)) continue;
            for (Object ri : listF((EObject) fa, "fmeaItems")) {
                if (!(ri instanceof EObject)) continue;
                EObject item = (EObject) ri;
                EObject comp = ref(item, "analyzedComponent");
                if (comp == null) continue;
                String cf = SimulationState.frag(comp);
                if (cf == null) continue;
                int rpn = intF(item, "severity") * intF(item, "occurrence") * intF(item, "detection");
                fragToRpn.merge(cf, rpn, Integer::max);
            }
        }

        // ── Build adjacency from active edge connections ───────────────────────
        // Key: fromFrag → list of toFrag (only for edges in activeEdgeIds)
        Map<String, List<String>> adj = new LinkedHashMap<>();
        for (Object raw : listF(modelRoot, "blockConnections")) {
            if (!(raw instanceof EObject)) continue;
            EObject conn = (EObject) raw;
            if (!state.isActiveEdge(conn)) continue;   // fragment-based check
            // fromBlock and toBlock are upperBound=-1 (EList) in the metamodel.
            // ref() always returns null for multi-valued refs — use listF() + firstOf().
            EObject from = firstOf(listF(conn, "fromBlock"));
            EObject to   = firstOf(listF(conn, "toBlock"));
            if (from == null || to == null) continue;
            String ff = SimulationState.frag(from);
            String tf = SimulationState.frag(to);
            if (ff != null && tf != null)
                adj.computeIfAbsent(ff, k -> new ArrayList<>()).add(tf);
        }

        // ── DFS all simple paths from each source ─────────────────────────────
        List<List<String>> allPaths = new ArrayList<>();
        for (String sf : state.getSourceFragments()) {
            dfs(sf, new ArrayList<>(), adj, allPaths, MAX_DEPTH);
        }

        if (allPaths.isEmpty()) {
            info("No paths found.\n\nEnsure a simulation has been run and connections exist."); return;
        }

        // ── Score ─────────────────────────────────────────────────────────────
        List<String> best = null; int bestScore = -1;
        for (List<String> path : allPaths) {
            int score = path.stream().mapToInt(f -> fragToRpn.getOrDefault(f, 0)).sum();
            if (score > bestScore) { bestScore = score; best = path; }
        }

        // ── Report ─────────────────────────────────────────────────────────────
        StringBuilder sb = new StringBuilder();
        sb.append("CRITICAL PROPAGATION PATH\n");
        sb.append("─────────────────────────────────────────\n\n");
        sb.append("  Paths evaluated  : ").append(allPaths.size()).append("\n");
        sb.append("  Critical RPN sum : ").append(bestScore).append("\n\n");
        sb.append("PATH:\n");
        for (int i = 0; i < best.size(); i++) {
            String f = best.get(i);
            int rpn  = fragToRpn.getOrDefault(f, 0);
            String name = fragToName.getOrDefault(f, f);
            sb.append(String.format("  %d. %s%s%n", i+1, name,
                rpn > 0 ? "  [max RPN=" + rpn + "]" : ""));
            if (i < best.size()-1) sb.append("      ↓\n");
        }
        sb.append("\n─────────────────────────────────────────\n");
        sb.append("All blocks above are highlighted in the diagram.");
        info(sb.toString());
    }

    private void dfs(String cur, List<String> path, Map<String, List<String>> adj,
                     List<List<String>> results, int max) {
        path.add(cur);
        List<String> nbrs = adj.getOrDefault(cur, Collections.emptyList());
        if (nbrs.isEmpty() || path.size() >= max) {
            results.add(new ArrayList<>(path));
        } else {
            for (String n : nbrs) if (!path.contains(n)) dfs(n, path, adj, results, max);
        }
        path.remove(path.size()-1);
    }

    // ── Helpers ───────────────────────────────────────────────────────────────
    private EObject firstOf(List<?> list) {
        if (list == null || list.isEmpty()) return null;
        Object o = list.get(0); return (o instanceof EObject) ? (EObject) o : null;
    }
    private EObject ref(EObject o, String f) {
        try { var feat = o.eClass().getEStructuralFeature(f); if (feat==null) return null; Object v=o.eGet(feat,true); return (v instanceof EObject)?(EObject)v:null; }
        catch(Exception e){return null;}
    }
    @SuppressWarnings("unchecked")
    private List<?> listF(EObject o, String f) {
        try { var feat=o.eClass().getEStructuralFeature(f); if(feat==null) return List.of(); Object v=o.eGet(feat); return (v instanceof List)?(List<?>)v:List.of(); }
        catch(Exception e){return List.of();}
    }
    private int intF(EObject o, String f) {
        try { var feat=o.eClass().getEStructuralFeature(f); if(feat==null) return 0; Object v=o.eGet(feat); return (v instanceof Number)?((Number)v).intValue():0; }
        catch(Exception e){return 0;}
    }
    private String strF(EObject o, String f) {
        try { var feat=o.eClass().getEStructuralFeature(f); if(feat==null) return "<?>"; Object v=o.eGet(feat); return v!=null?v.toString():"<unnamed>"; }
        catch(Exception e){return "<err>";}
    }
    private EObject sem(EObject v) { return (v instanceof DRepresentationElement)?((DRepresentationElement)v).getTarget():v; }
    private EObject root(EObject o) { while(o!=null){if("UnifiedSystemModel".equals(o.eClass().getName()))return o; o=o.eContainer();} return null; }
    private void info(String m) { try{MessageDialog.openInformation(Display.getDefault().getActiveShell(),"Critical Propagation Path",m);}catch(Exception ignored){} }
    private void err(String m)  { try{MessageDialog.openError(Display.getDefault().getActiveShell(),"Critical Path – Error",m);}catch(Exception ignored){} }
}