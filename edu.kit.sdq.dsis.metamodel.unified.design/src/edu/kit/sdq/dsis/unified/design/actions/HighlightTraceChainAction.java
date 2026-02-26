package edu.kit.sdq.dsis.unified.design.actions;

import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Highlight Trace Chain Action — fully updated for all unified metamodel types.
 *
 * Handles all eight element types that appear in the Traceability Diagram:
 *   SafetyGoal, FunctionalSafetyRequirement, TechnicalSafetyRequirement,
 *   SafetyMechanism, IntegratedHazard, SafetyCriticalBlock,
 *   BlockFailureMode, FMEAItem
 *
 * Root cause of previous bug: SafetyGoal, FunctionalSafetyRequirement,
 * TechnicalSafetyRequirement, and SafetyMechanism were completely absent from
 * both computeForwardTraces() and computeBackwardTraces(). Any user click on
 * those element types fell through all instanceof checks, leaving the chain
 * empty and producing the "No trace links found" message.
 */
public class HighlightTraceChainAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No Selection", "Please select an element to highlight its trace chain.");
            return;
        }

        EObject firstSelection = selections.iterator().next();
        EObject semanticElement = getSemanticElement(firstSelection);

        if (semanticElement == null) {
            showError("Invalid Selection", "Could not determine semantic element.");
            return;
        }

        UnifiedSystemModel model = getUnifiedSystemModel(semanticElement);
        if (model == null) {
            showError("Invalid Model", "Could not find UnifiedSystemModel.");
            return;
        }

        int traceDirection = promptTraceDirection();
        if (traceDirection == -1) return; // User cancelled

        Set<EObject> traceChain = computeTraceChain(semanticElement, model, traceDirection);

        if (traceChain.isEmpty()) {
            showInfo("No Traces",
                "No trace links found for: " + getElementName(semanticElement) +
                " [" + semanticElement.eClass().getName() + "]\n\n" +
                "This element has no outgoing or incoming trace links in the model yet.");
            return;
        }

        showTraceChainSummary(semanticElement, traceChain, traceDirection);
    }

    private int promptTraceDirection() {
        final int[] result = new int[1];
        Display.getDefault().syncExec(() -> {
            MessageDialog dialog = new MessageDialog(
                Display.getDefault().getActiveShell(),
                "Select Trace Direction", null,
                "Choose which trace links to highlight:",
                MessageDialog.QUESTION,
                new String[] {
                    "Forward (downstream dependencies)",
                    "Backward (upstream sources)",
                    "Both (complete chain)",
                    "Cancel"
                }, 2  // default: Both
            );
            result[0] = dialog.open();
        });
        if (result[0] == 3) return -1;
        return result[0]; // 0=forward, 1=backward, 2=both
    }

    private Set<EObject> computeTraceChain(EObject element, UnifiedSystemModel model, int direction) {
        Set<EObject> chain   = new HashSet<>();
        Set<EObject> visited = new HashSet<>();

        if (direction == 0 || direction == 2)
            computeForwardTraces(element, model, chain, visited);

        if (direction == 1 || direction == 2) {
            visited.clear();
            computeBackwardTraces(element, model, chain, visited);
        }

        return chain;
    }

    // =========================================================================
    // FORWARD traversal: follow links downstream
    //   SafetyGoal      → FunctionalSafetyRequirement (allocatedTo)
    //   SafetyGoal      → IntegratedHazard (relatedHazard)
    //   FSR             → TechnicalSafetyRequirement (refinedTo)
    //   FSR             → SafetyCriticalBlock (implementedBy)
    //   TSR             → SafetyCriticalBlock (realizedBy)
    //   TSR             → FMEAItem (verifiedBy)
    //   IntegratedHazard→ SafetyCriticalBlock (relatedBlocks)
    //   IntegratedHazard→ SafetyGoal (via model.safetyGoals.relatedHazard)
    //   SafetyCriticalBlock → BlockFailureMode, FMEAItem, connections
    //   FMEAItem        → SafetyMechanism (validatesMechanisms)
    //   FMEAItem        → component, failure mode, related hazards
    //   BlockFailureMode→ FMEAItem
    //   SafetyMechanism → TSR (implements), validated by FMEAItem
    // =========================================================================
    private void computeForwardTraces(EObject element, UnifiedSystemModel model,
                                      Set<EObject> chain, Set<EObject> visited) {
        if (visited.contains(element)) return;
        visited.add(element);

        // ---- SafetyGoal ----
        if (element instanceof SafetyGoal) {
            SafetyGoal sg = (SafetyGoal) element;
            if (sg.getRelatedHazard() != null) {
                chain.add(sg.getRelatedHazard());
                computeForwardTraces(sg.getRelatedHazard(), model, chain, visited);
            }
            for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo()) {
                chain.add(fsr);
                computeForwardTraces(fsr, model, chain, visited);
            }

        // ---- FunctionalSafetyRequirement ----
        } else if (element instanceof FunctionalSafetyRequirement) {
            FunctionalSafetyRequirement fsr = (FunctionalSafetyRequirement) element;
            for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo()) {
                chain.add(tsr);
                computeForwardTraces(tsr, model, chain, visited);
            }
            for (SafetyCriticalBlock block : fsr.getImplementedBy()) {
                chain.add(block);
                computeForwardTraces(block, model, chain, visited);
            }

        // ---- TechnicalSafetyRequirement ----
        } else if (element instanceof TechnicalSafetyRequirement) {
            TechnicalSafetyRequirement tsr = (TechnicalSafetyRequirement) element;
            for (SafetyCriticalBlock block : tsr.getRealizedBy()) {
                chain.add(block);
                computeForwardTraces(block, model, chain, visited);
            }
            for (FMEAItem item : tsr.getVerifiedBy()) {
                chain.add(item);
                computeForwardTraces(item, model, chain, visited);
            }
            // SafetyMechanism.implements is one-directional (no eOpposite on TSR side)
            // so we must scan all mechanisms to find those that implement this TSR
            for (SafetyMechanism sm : model.getSafetyMechanisms()) {
                if (sm.getImplements().contains(tsr)) {
                    chain.add(sm);
                }
            }

        // ---- IntegratedHazard ----
        } else if (element instanceof IntegratedHazard) {
            IntegratedHazard hazard = (IntegratedHazard) element;
            // Hazard → Blocks it threatens
            for (SafetyCriticalBlock block : hazard.getRelatedBlocks()) {
                chain.add(block);
                computeForwardTraces(block, model, chain, visited);
            }
            // Hazard → SafetyGoals that address it
            for (SafetyGoal sg : model.getSafetyGoals()) {
                if (hazard.equals(sg.getRelatedHazard())) {
                    chain.add(sg);
                    computeForwardTraces(sg, model, chain, visited);
                }
            }
            // Hazard → FMEA items that mitigate it
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getRelatedHazards().contains(hazard)) {
                        chain.add(item);
                        computeForwardTraces(item, model, chain, visited);
                    }
                }
            }

        // ---- SafetyCriticalBlock ----
        } else if (element instanceof SafetyCriticalBlock) {
            SafetyCriticalBlock block = (SafetyCriticalBlock) element;
            for (BlockFailureMode fm : block.getFailureModes()) {
                chain.add(fm);
                computeForwardTraces(fm, model, chain, visited);
            }
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getAnalyzedComponent() == block) {
                        chain.add(item);
                        computeForwardTraces(item, model, chain, visited);
                    }
                }
            }
            for (BlockConnection conn : block.getConnectionAsSource()) {
                chain.add(conn);
                for (SystemBlock target : conn.getToBlock()) chain.add(target);
            }

        // ---- BlockFailureMode ----
        } else if (element instanceof BlockFailureMode) {
            BlockFailureMode fm = (BlockFailureMode) element;
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getFailureMode() == fm) {
                        chain.add(item);
                        computeForwardTraces(item, model, chain, visited);
                    }
                }
            }

        // ---- FMEAItem ----
        } else if (element instanceof FMEAItem) {
            FMEAItem item = (FMEAItem) element;
            if (item.getAnalyzedComponent() != null) chain.add(item.getAnalyzedComponent());
            if (item.getFailureMode() != null)       chain.add(item.getFailureMode());
            for (IntegratedHazard h : item.getRelatedHazards()) {
                chain.add(h);
            }
            for (SafetyMechanism sm : item.getValidatesMechanisms()) {
                chain.add(sm);
                computeForwardTraces(sm, model, chain, visited);
            }
            for (Requirement req : RequirementTraceHelper.getRelatedRequirements(item)) {
                chain.add(req);
            }

        // ---- SafetyMechanism ----
        } else if (element instanceof SafetyMechanism) {
            SafetyMechanism sm = (SafetyMechanism) element;
            for (TechnicalSafetyRequirement tsr : sm.getImplements()) {
                chain.add(tsr);
                computeForwardTraces(tsr, model, chain, visited);
            }
            if (sm.getImplementedIn() != null) {
                chain.add(sm.getImplementedIn());
            }
        }
    }

    // =========================================================================
    // BACKWARD traversal: follow links upstream
    // =========================================================================
    private void computeBackwardTraces(EObject element, UnifiedSystemModel model,
                                       Set<EObject> chain, Set<EObject> visited) {
        if (visited.contains(element)) return;
        visited.add(element);

        // ---- SafetyGoal ---- backward: which hazard spawned it
        if (element instanceof SafetyGoal) {
            SafetyGoal sg = (SafetyGoal) element;
            if (sg.getRelatedHazard() != null) {
                chain.add(sg.getRelatedHazard());
                computeBackwardTraces(sg.getRelatedHazard(), model, chain, visited);
            }

        // ---- FunctionalSafetyRequirement ---- backward: SafetyGoals that allocate to it
        } else if (element instanceof FunctionalSafetyRequirement) {
            FunctionalSafetyRequirement fsr = (FunctionalSafetyRequirement) element;
            for (SafetyGoal sg : model.getSafetyGoals()) {
                if (sg.getAllocatedTo().contains(fsr)) {
                    chain.add(sg);
                    computeBackwardTraces(sg, model, chain, visited);
                }
            }

        // ---- TechnicalSafetyRequirement ---- backward: FSRs that refine to it
        } else if (element instanceof TechnicalSafetyRequirement) {
            TechnicalSafetyRequirement tsr = (TechnicalSafetyRequirement) element;
            for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
                if (fsr.getRefinedTo().contains(tsr)) {
                    chain.add(fsr);
                    computeBackwardTraces(fsr, model, chain, visited);
                }
            }

        // ---- IntegratedHazard ---- backward: requirements and FMEA items that address it
        } else if (element instanceof IntegratedHazard) {
            IntegratedHazard hazard = (IntegratedHazard) element;
            for (SafetyGoal sg : model.getSafetyGoals()) {
                if (hazard.equals(sg.getRelatedHazard())) {
                    chain.add(sg);
                    computeBackwardTraces(sg, model, chain, visited);
                }
            }
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getRelatedHazards().contains(hazard)) {
                        chain.add(item);
                        computeBackwardTraces(item, model, chain, visited);
                    }
                }
            }
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                if (RequirementTraceHelper.getRelatedHazards(req).contains(hazard)) {
                    chain.add(req);
                }
            }

        // ---- SafetyCriticalBlock ---- backward: who requires / threatens / analyzes it
        } else if (element instanceof SafetyCriticalBlock) {
            SafetyCriticalBlock block = (SafetyCriticalBlock) element;
            // TSRs that realize this block
            for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                if (tsr.getRealizedBy().contains(block)) {
                    chain.add(tsr);
                    computeBackwardTraces(tsr, model, chain, visited);
                }
            }
            // FSRs that implementedBy this block
            for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
                if (fsr.getImplementedBy().contains(block)) {
                    chain.add(fsr);
                    computeBackwardTraces(fsr, model, chain, visited);
                }
            }
            // Hazards that threaten it
            for (IntegratedHazard hazard : model.getGlobalHazards()) {
                if (hazard.getRelatedBlocks().contains(block)) {
                    chain.add(hazard);
                    computeBackwardTraces(hazard, model, chain, visited);
                }
            }
            // FMEA items that analyze it
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getAnalyzedComponent() == block) {
                        chain.add(item);
                    }
                }
            }
            // Incoming connections
            for (BlockConnection conn : block.getConnectionAsTarget()) {
                chain.add(conn);
                for (SystemBlock source : conn.getFromBlock()) chain.add(source);
            }
            // Generic Requirement traces (legacy)
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                if (RequirementTraceHelper.getRelatedBlocks(req).contains(block)) {
                    chain.add(req);
                }
            }

        // ---- BlockFailureMode ---- backward: the block that owns it
        } else if (element instanceof BlockFailureMode) {
            BlockFailureMode fm = (BlockFailureMode) element;
            if (fm.getAffectedBlock() != null) {
                chain.add(fm.getAffectedBlock());
                computeBackwardTraces(fm.getAffectedBlock(), model, chain, visited);
            }
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getFailureMode() == fm) {
                        chain.add(item);
                        computeBackwardTraces(item, model, chain, visited);
                    }
                }
            }

        // ---- FMEAItem ---- backward: block, failure mode, hazards, requirements
        } else if (element instanceof FMEAItem) {
            FMEAItem item = (FMEAItem) element;
            if (item.getAnalyzedComponent() != null) {
                chain.add(item.getAnalyzedComponent());
                computeBackwardTraces(item.getAnalyzedComponent(), model, chain, visited);
            }
            if (item.getFailureMode() != null) {
                chain.add(item.getFailureMode());
                computeBackwardTraces(item.getFailureMode(), model, chain, visited);
            }
            for (IntegratedHazard h : item.getRelatedHazards()) {
                chain.add(h);
                computeBackwardTraces(h, model, chain, visited);
            }
            for (Requirement req : RequirementTraceHelper.getRelatedRequirements(item)) {
                chain.add(req);
            }
            // TSRs that point verifiedBy to this item
            for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                if (tsr.getVerifiedBy().contains(item)) {
                    chain.add(tsr);
                    computeBackwardTraces(tsr, model, chain, visited);
                }
            }

        // ---- SafetyMechanism ---- backward: TSRs it implements, FMEA items that validate it
        } else if (element instanceof SafetyMechanism) {
            SafetyMechanism sm = (SafetyMechanism) element;
            for (TechnicalSafetyRequirement tsr : sm.getImplements()) {
                chain.add(tsr);
                computeBackwardTraces(tsr, model, chain, visited);
            }
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getValidatesMechanisms().contains(sm)) {
                        chain.add(item);
                        computeBackwardTraces(item, model, chain, visited);
                    }
                }
            }
        }
    }

    // =========================================================================
    // Display
    // =========================================================================
    private void showTraceChainSummary(EObject source, Set<EObject> chain, int direction) {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════\n");
        sb.append("            TRACE CHAIN ANALYSIS\n");
        sb.append("═══════════════════════════════════════════\n\n");
        sb.append("Source Element:\n");
        sb.append("   ").append(getElementName(source))
          .append(" [").append(source.eClass().getName()).append("]\n\n");

        String dir = direction == 0 ? "Forward (downstream)" :
                     direction == 1 ? "Backward (upstream)"  : "Complete Chain (both directions)";
        sb.append("Trace Direction: ").append(dir).append("\n");
        sb.append("Elements in Chain: ").append(chain.size()).append("\n\n");

        // Group by type, ordered logically in the safety V-model
        List<String> typeOrder = Arrays.asList(
            "SafetyGoal", "FunctionalSafetyRequirement", "TechnicalSafetyRequirement",
            "IntegratedHazard", "SafetyCriticalBlock", "SystemBlock",
            "BlockFailureMode", "FMEAItem", "SafetyMechanism",
            "BlockConnection", "Requirement"
        );

        Map<String, List<EObject>> byType = chain.stream()
            .collect(Collectors.groupingBy(e -> e.eClass().getName()));

        sb.append("Elements by Type:\n");
        sb.append("───────────────────────────────────────────\n");

        // Print in V-model order first
        for (String type : typeOrder) {
            List<EObject> elements = byType.remove(type);
            if (elements == null || elements.isEmpty()) continue;
            printTypeGroup(sb, type, elements);
        }
        // Any remaining types not in the ordered list
        for (Map.Entry<String, List<EObject>> entry : byType.entrySet()) {
            if (!entry.getValue().isEmpty())
                printTypeGroup(sb, entry.getKey(), entry.getValue());
        }

        sb.append("\n═══════════════════════════════════════════\n");
        sb.append("ISO 26262 Note: Review all highlighted elements\n");
        sb.append("before modifying the selected element.\n");
        showInfo("Trace Chain: " + getElementName(source), sb.toString());
    }

    private void printTypeGroup(StringBuilder sb, String type, List<EObject> elements) {
        String icon = typeIcon(type);
        sb.append(String.format("\n%s %s (%d):\n", icon, type, elements.size()));
        for (EObject elem : elements) {
            sb.append("  • ").append(getElementName(elem));
            appendDetails(sb, elem);
            sb.append("\n");
        }
    }

    private void appendDetails(StringBuilder sb, EObject elem) {
        if (elem instanceof SafetyGoal) {
            SafetyGoal sg = (SafetyGoal) elem;
            if (sg.getAsilLevel() != null)
                sb.append(" [ASIL ").append(sg.getAsilLevel()).append("]");
        } else if (elem instanceof FunctionalSafetyRequirement) {
            FunctionalSafetyRequirement fsr = (FunctionalSafetyRequirement) elem;
            sb.append(" [").append(fsr.getRequirementId()).append("]");
        } else if (elem instanceof TechnicalSafetyRequirement) {
            TechnicalSafetyRequirement tsr = (TechnicalSafetyRequirement) elem;
            if (tsr.getAllocatedASIL() != null)
                sb.append(" [ASIL ").append(tsr.getAllocatedASIL()).append("]");
        } else if (elem instanceof SafetyCriticalBlock) {
            sb.append(" [").append(((SafetyCriticalBlock) elem).getAsilLevel()).append("]");
        } else if (elem instanceof IntegratedHazard) {
            sb.append(" [").append(((IntegratedHazard) elem).getRiskLevel()).append("]");
        } else if (elem instanceof FMEAItem) {
            FMEAItem item = (FMEAItem) elem;
            int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
            sb.append(" [RPN: ").append(rpn).append("]");
        } else if (elem instanceof SafetyMechanism) {
            SafetyMechanism sm = (SafetyMechanism) elem;
            sb.append(" [").append(sm.getMechanismType()).append("]");
        } else if (elem instanceof Requirement) {
            Requirement req = (Requirement) elem;
            Object type = RequirementTraceHelper.getRequirementType(req);
            if (type != null) sb.append(" [").append(type).append("]");
        }
    }

    private String typeIcon(String type) {
        switch (type) {
            case "SafetyGoal":                    return "🎯";
            case "FunctionalSafetyRequirement":   return "📋";
            case "TechnicalSafetyRequirement":    return "⚙️";
            case "IntegratedHazard":              return "⚠️";
            case "SafetyCriticalBlock":           return "🔲";
            case "SystemBlock":                   return "🔷";
            case "BlockFailureMode":              return "💥";
            case "FMEAItem":                      return "🔬";
            case "SafetyMechanism":               return "🛡️";
            case "BlockConnection":               return "🔗";
            default:                              return "▶";
        }
    }

    private String getElementName(EObject element) {
        if (element instanceof UnifiedElement) {
            String name = ((UnifiedElement) element).getName();
            return name != null && !name.isEmpty() ? name : "<unnamed>";
        }
        return element.eClass().getName();
    }

    private EObject getSemanticElement(EObject obj) {
        if (obj instanceof DDiagramElement) {
            EObject target = ((DDiagramElement) obj).getTarget();
            if (target != null) return target;
        }
        if (obj instanceof DSemanticDecorator)
            return ((DSemanticDecorator) obj).getTarget();
        return obj;
    }

    private UnifiedSystemModel getUnifiedSystemModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        if (obj.eContainer() != null) return getUnifiedSystemModel(obj.eContainer());
        return null;
    }

    private void showError(String title, String message) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), title, message)
        );
    }

    private void showInfo(String title, String message) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message)
        );
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }
}