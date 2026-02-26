package edu.kit.sdq.dsis.unified.design.actions;

import java.util.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;

import unified.*;

/**
 * Validate Traceability Coverage Action - UPDATED for Requirements Support
 * Validates the completeness of traceability coverage including requirements.
 */
public class ValidateTraceabilityCoverageAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No Selection", "Please select an element to validate traceability coverage.");
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

        validateCoverage(model);
    }

    private void validateCoverage(UnifiedSystemModel model) {
        StringBuilder report = new StringBuilder();
        report.append("=== TRACEABILITY COVERAGE VALIDATION ===\n\n");

        List<String> issues   = new ArrayList<>();
        List<String> warnings = new ArrayList<>();
        List<String> passed   = new ArrayList<>();

        // ---- Requirement checks ----
        List<Requirement> allRequirements = RequirementTraceHelper.getRequirements(model);
        int totalReqs = allRequirements.size();

        if (totalReqs == 0) {
            warnings.add("No requirements found in model.");
        } else {
            int tracedReqs = 0;
            List<String> untracedReqNames = new ArrayList<>();

            for (Requirement req : allRequirements) {
                int traces = RequirementTraceHelper.getRelatedBlocks(req).size()
                           + RequirementTraceHelper.getRelatedHazards(req).size()
                           + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                if (traces > 0) {
                    tracedReqs++;
                } else {
                    untracedReqNames.add(req.getId() + ": " + req.getName());
                }
            }

            double reqCoverage = (tracedReqs * 100.0) / totalReqs;
            if (reqCoverage >= 80) {
                passed.add(String.format("Requirement traceability coverage: %.1f%% (%d/%d)",
                    reqCoverage, tracedReqs, totalReqs));
            } else if (reqCoverage >= 50) {
                warnings.add(String.format("Requirement coverage below 80%%: %.1f%% (%d/%d traced)",
                    reqCoverage, tracedReqs, totalReqs));
            } else {
                issues.add(String.format("CRITICAL: Requirement coverage below 50%%: %.1f%% (%d/%d traced)",
                    reqCoverage, tracedReqs, totalReqs));
            }

            if (!untracedReqNames.isEmpty() && untracedReqNames.size() <= 5) {
                for (String name : untracedReqNames) {
                    warnings.add("  Untraced requirement: " + name);
                }
            } else if (untracedReqNames.size() > 5) {
                warnings.add("  " + untracedReqNames.size() + " untraced requirements (see gap analysis for details)");
            }

            // Check high-priority requirements
            int highPriorityCount   = 0;
            int highPriorityTraced  = 0;
            for (Requirement req : allRequirements) {
                Object priority = RequirementTraceHelper.getPriority(req);
                if (priority != null && priority.toString().equals("HIGH")) {
                    highPriorityCount++;
                    int traces = RequirementTraceHelper.getRelatedBlocks(req).size()
                               + RequirementTraceHelper.getRelatedHazards(req).size()
                               + RequirementTraceHelper.countFMEALinksForRequirement(model, req);
                    if (traces >= 2) highPriorityTraced++;
                }
            }

            if (highPriorityCount > 0) {
                if (highPriorityTraced == highPriorityCount) {
                    passed.add("All " + highPriorityCount + " high-priority requirement(s) adequately traced (>= 2 links)");
                } else {
                    issues.add("ISSUE: " + (highPriorityCount - highPriorityTraced) + "/" + highPriorityCount
                        + " high-priority requirement(s) have insufficient traces (< 2 links)");
                }
            }
        }

        // ---- Hazard coverage checks ----
        List<IntegratedHazard> allHazards = model.getGlobalHazards();
        if (allHazards.isEmpty()) {
            warnings.add("No hazards defined in model.");
        } else {
            int tracedHazards = 0;
            for (IntegratedHazard hazard : allHazards) {
                if (!hazard.getRelatedBlocks().isEmpty()) tracedHazards++;
            }
            double hazardCoverage = (tracedHazards * 100.0) / allHazards.size();
            if (hazardCoverage >= 80) {
                passed.add(String.format("Hazard-to-block coverage: %.1f%% (%d/%d)",
                    hazardCoverage, tracedHazards, allHazards.size()));
            } else {
                issues.add(String.format("Hazard-to-block coverage below 80%%: %.1f%% (%d/%d)",
                    hazardCoverage, tracedHazards, allHazards.size()));
            }
        }

        // ---- FMEA coverage checks ----
        List<SafetyCriticalBlock> rootBlocks = model.getRootBlocks();
        if (!rootBlocks.isEmpty()) {
            int blocksWithFMEA = 0;
            for (SafetyCriticalBlock block : rootBlocks) {
                boolean hasFMEA = false;
                outer:
                for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
                    for (FMEAItem item : analysis.getFmeaItems()) {
                        if (item.getAnalyzedComponent() == block) { hasFMEA = true; break outer; }
                    }
                }
                if (hasFMEA) blocksWithFMEA++;
            }
            double fmeaCoverage = (blocksWithFMEA * 100.0) / rootBlocks.size();
            if (fmeaCoverage >= 80) {
                passed.add(String.format("FMEA coverage of safety-critical blocks: %.1f%% (%d/%d)",
                    fmeaCoverage, blocksWithFMEA, rootBlocks.size()));
            } else {
                warnings.add(String.format("FMEA coverage below 80%%: %.1f%% (%d/%d blocks analysed)",
                    fmeaCoverage, blocksWithFMEA, rootBlocks.size()));
            }
        }

        // ---- Safety requirement to hazard check ----
        for (Requirement req : allRequirements) {
            Object reqType = RequirementTraceHelper.getRequirementType(req);
            if (reqType != null && reqType.toString().equals("SAFETY")) {
                if (RequirementTraceHelper.getRelatedHazards(req).isEmpty() &&
                    !RequirementTraceHelper.hasRelatedFMEAItems(model, req)) {
                    issues.add("Safety requirement not linked to any hazard or FMEA: "
                        + req.getId() + ": " + req.getName());
                }
            }
        }

        // ---- FMEA items and requirements check ----
        int fmeaItemsWithReqs = 0;
        int totalFmeaItems    = 0;
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                totalFmeaItems++;
                if (!RequirementTraceHelper.getRelatedRequirements(item).isEmpty()) fmeaItemsWithReqs++;
            }
        }
        if (totalFmeaItems > 0) {
            double fmeaReqCoverage = (fmeaItemsWithReqs * 100.0) / totalFmeaItems;
            if (fmeaReqCoverage >= 50) {
                passed.add(String.format("FMEA items linked to requirements: %.1f%% (%d/%d)",
                    fmeaReqCoverage, fmeaItemsWithReqs, totalFmeaItems));
            } else {
                warnings.add(String.format("Only %.1f%% of FMEA items (%d/%d) are linked to requirements",
                    fmeaReqCoverage, fmeaItemsWithReqs, totalFmeaItems));
            }
        }

        // ---- Build output ----
        if (!passed.isEmpty()) {
            report.append("PASSED (" + passed.size() + "):\n");
            for (String p : passed) report.append("  [OK] " + p + "\n");
            report.append("\n");
        }

        if (!warnings.isEmpty()) {
            report.append("WARNINGS (" + warnings.size() + "):\n");
            for (String w : warnings) report.append("  [WARN] " + w + "\n");
            report.append("\n");
        }

        if (!issues.isEmpty()) {
            report.append("ISSUES (" + issues.size() + "):\n");
            for (String issue : issues) report.append("  [FAIL] " + issue + "\n");
            report.append("\n");
        }

        report.append("=======================================\n");
        if (issues.isEmpty() && warnings.isEmpty()) {
            report.append("RESULT: FULLY COMPLIANT - All traceability checks passed.\n");
        } else if (issues.isEmpty()) {
            report.append("RESULT: COMPLIANT WITH WARNINGS - " + warnings.size() + " warning(s) to address.\n");
        } else {
            report.append("RESULT: NON-COMPLIANT - " + issues.size() + " issue(s) must be resolved.\n");
        }

        showInfo("Traceability Coverage Validation", report.toString());
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