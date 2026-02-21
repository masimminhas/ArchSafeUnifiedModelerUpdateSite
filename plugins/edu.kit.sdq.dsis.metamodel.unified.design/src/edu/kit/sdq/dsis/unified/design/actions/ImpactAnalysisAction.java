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
 * Impact Analysis Action — updated for all unified metamodel types.
 *
 * Adds handlers for SafetyGoal, FunctionalSafetyRequirement,
 * TechnicalSafetyRequirement, and SafetyMechanism, which were
 * previously missing and caused "Impact analysis not supported" for
 * the most commonly selected diagram elements.
 */
public class ImpactAnalysisAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No Selection", "Please select an element for impact analysis.");
            return;
        }

        EObject first = selections.iterator().next();
        EObject element = getSemanticElement(first);

        if (element == null) {
            showError("Invalid Selection", "Could not determine semantic element.");
            return;
        }

        UnifiedSystemModel model = getUnifiedSystemModel(element);
        if (model == null) {
            showError("Invalid Model", "Could not find UnifiedSystemModel.");
            return;
        }

        analyzeImpact(element, model);
    }

    private void analyzeImpact(EObject element, UnifiedSystemModel model) {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════\n");
        sb.append("            IMPACT ANALYSIS REPORT\n");
        sb.append("═══════════════════════════════════════════\n\n");
        sb.append("Analyzing: ").append(getElementName(element))
          .append(" [").append(element.eClass().getName()).append("]\n\n");

        Set<EObject> impacted = new HashSet<>();

        if      (element instanceof SafetyGoal)                   analyzeSafetyGoalImpact((SafetyGoal) element, model, impacted, sb);
        else if (element instanceof FunctionalSafetyRequirement)  analyzeFSRImpact((FunctionalSafetyRequirement) element, model, impacted, sb);
        else if (element instanceof TechnicalSafetyRequirement)   analyzeTSRImpact((TechnicalSafetyRequirement) element, model, impacted, sb);
        else if (element instanceof SafetyMechanism)              analyzeMechanismImpact((SafetyMechanism) element, model, impacted, sb);
        else if (element instanceof Requirement)                   analyzeRequirementImpact((Requirement) element, model, impacted, sb);
        else if (element instanceof SafetyCriticalBlock)           analyzeBlockImpact((SafetyCriticalBlock) element, model, impacted, sb);
        else if (element instanceof IntegratedHazard)              analyzeHazardImpact((IntegratedHazard) element, model, impacted, sb);
        else if (element instanceof FMEAItem)                      analyzeFMEAItemImpact((FMEAItem) element, model, impacted, sb);
        else if (element instanceof BlockFailureMode)              analyzeFailureModeImpact((BlockFailureMode) element, model, impacted, sb);
        else sb.append("Impact analysis not yet configured for element type: ")
               .append(element.eClass().getName()).append("\n");

        sb.append("\n═══════════════════════════════════════════\n");
        sb.append("Total Impacted Elements: ").append(impacted.size()).append("\n");
        if (!impacted.isEmpty()) {
            sb.append("\nISO 26262 REVIEW NOTE:\n");
            sb.append("Before modifying this element, review all ").append(impacted.size()).append(
                " impacted element(s) listed above.\n");
            sb.append("Update documentation, re-run validation, and obtain change approval\n");
            sb.append("per your functional safety management process (ISO 26262-2 §6.4).\n");
        }

        showInfo("Impact Analysis: " + getElementName(element), sb.toString());
    }

    // ---- SafetyGoal ----
    private void analyzeSafetyGoalImpact(SafetyGoal sg, UnifiedSystemModel model,
                                          Set<EObject> impacted, StringBuilder sb) {
        sb.append("SAFETY GOAL IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        if (sg.getAsilLevel() != null)
            sb.append("Allocated ASIL: ").append(sg.getAsilLevel()).append("\n");
        if (sg.getRelatedHazard() != null)
            sb.append("Related Hazard: ").append(sg.getRelatedHazard().getName())
              .append(" [").append(sg.getRelatedHazard().getRiskLevel()).append("]\n");
        sb.append("\nDIRECTLY IMPACTED ELEMENTS:\n");

        if (!sg.getAllocatedTo().isEmpty()) {
            sb.append("\n  Functional Safety Requirements (").append(sg.getAllocatedTo().size()).append("):\n");
            for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo()) {
                sb.append("    • ").append(fsr.getRequirementId()).append(": ").append(fsr.getName())
                  .append(" [ASIL ").append(fsr.getAllocatedFrom()).append("]\n");
                impacted.add(fsr);
                // Cascade: FSR → TSR → Block
                for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo()) {
                    sb.append("      ↳ TSR ").append(tsr.getRequirementId()).append(": ").append(tsr.getName()).append("\n");
                    impacted.add(tsr);
                    for (SafetyCriticalBlock block : tsr.getRealizedBy()) {
                        sb.append("          ↳ Block ").append(block.getName()).append("\n");
                        impacted.add(block);
                    }
                }
            }
        }
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this Safety Goal's ASIL may require re-derivation of all\n");
        sb.append("  allocated FSRs and TSRs per ISO 26262-4 §6.2 (ASIL decomposition).\n");
    }

    // ---- FunctionalSafetyRequirement ----
    private void analyzeFSRImpact(FunctionalSafetyRequirement fsr, UnifiedSystemModel model,
                                   Set<EObject> impacted, StringBuilder sb) {
        sb.append("FUNCTIONAL SAFETY REQUIREMENT IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        sb.append("ID: ").append(fsr.getRequirementId()).append("\n");
        if (fsr.getAllocatedFrom() != null) sb.append("ASIL: ").append(fsr.getAllocatedFrom()).append("\n");
        sb.append("Status: ").append(fsr.getStatus()).append("\n");
        sb.append("\nDIRECTLY IMPACTED ELEMENTS:\n");

        // Upstream: parent safety goals
        List<SafetyGoal> parentGoals = new ArrayList<>();
        for (SafetyGoal sg : model.getSafetyGoals())
            if (sg.getAllocatedTo().contains(fsr)) parentGoals.add(sg);
        if (!parentGoals.isEmpty()) {
            sb.append("\n  Parent Safety Goals (").append(parentGoals.size()).append("):\n");
            for (SafetyGoal sg : parentGoals) {
                sb.append("    • ").append(sg.getName()).append("\n");
                impacted.add(sg);
            }
        }

        // Downstream: TSRs and blocks
        if (!fsr.getRefinedTo().isEmpty()) {
            sb.append("\n  Technical Safety Requirements (").append(fsr.getRefinedTo().size()).append("):\n");
            for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo()) {
                sb.append("    • ").append(tsr.getRequirementId()).append(": ").append(tsr.getName()).append("\n");
                impacted.add(tsr);
            }
        }
        if (!fsr.getImplementedBy().isEmpty()) {
            sb.append("\n  Implementing Blocks (").append(fsr.getImplementedBy().size()).append("):\n");
            for (SafetyCriticalBlock block : fsr.getImplementedBy()) {
                sb.append("    • ").append(block.getName()).append(" [").append(block.getAsilLevel()).append("]\n");
                impacted.add(block);
            }
        }
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this FSR requires review of ").append(impacted.size()).append(" element(s).\n");
        sb.append("  Re-approval required per ISO 26262-6 §7.2 before implementation.\n");
    }

    // ---- TechnicalSafetyRequirement ----
    private void analyzeTSRImpact(TechnicalSafetyRequirement tsr, UnifiedSystemModel model,
                                   Set<EObject> impacted, StringBuilder sb) {
        sb.append("TECHNICAL SAFETY REQUIREMENT IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        sb.append("ID: ").append(tsr.getRequirementId()).append("\n");
        if (tsr.getAllocatedASIL() != null) sb.append("ASIL: ").append(tsr.getAllocatedASIL()).append("\n");
        sb.append("Verification: ").append(tsr.getVerificationMethod()).append("\n");
        sb.append("Status: ").append(tsr.getStatus()).append("\n");
        sb.append("\nDIRECTLY IMPACTED ELEMENTS:\n");

        // Upstream FSRs
        List<FunctionalSafetyRequirement> parentFSRs = new ArrayList<>();
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements())
            if (fsr.getRefinedTo().contains(tsr)) parentFSRs.add(fsr);
        if (!parentFSRs.isEmpty()) {
            sb.append("\n  Parent FSRs (").append(parentFSRs.size()).append("):\n");
            for (FunctionalSafetyRequirement fsr : parentFSRs) {
                sb.append("    • ").append(fsr.getRequirementId()).append(": ").append(fsr.getName()).append("\n");
                impacted.add(fsr);
            }
        }
        if (!tsr.getRealizedBy().isEmpty()) {
            sb.append("\n  Realizing Blocks (").append(tsr.getRealizedBy().size()).append("):\n");
            for (SafetyCriticalBlock block : tsr.getRealizedBy()) {
                sb.append("    • ").append(block.getName()).append("\n");
                impacted.add(block);
            }
        }
        if (!tsr.getVerifiedBy().isEmpty()) {
            sb.append("\n  Verifying FMEA Items (").append(tsr.getVerifiedBy().size()).append("):\n");
            for (FMEAItem item : tsr.getVerifiedBy()) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                sb.append("    • ").append(item.getName()).append(" [RPN: ").append(rpn).append("]\n");
                impacted.add(item);
            }
        }
        // SafetyMechanism.implements -> TSR has no eOpposite on TSR side.
        // Find mechanisms that implement this TSR by scanning model.getSafetyMechanisms().
        List<SafetyMechanism> implementingMechanisms = new ArrayList<>();
        for (SafetyMechanism sm : model.getSafetyMechanisms())
            if (sm.getImplements().contains(tsr)) implementingMechanisms.add(sm);
        if (!implementingMechanisms.isEmpty()) {
            sb.append("\n  Implementing Safety Mechanisms (").append(implementingMechanisms.size()).append("):\n");
            for (SafetyMechanism sm : implementingMechanisms) {
                sb.append("    • ").append(sm.getName()).append("\n");
                impacted.add(sm);
            }
        }
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this TSR impacts ").append(impacted.size()).append(" element(s).\n");
        sb.append("  Re-verification required (ISO 26262-6 §7.4). Architecture review needed.\n");
    }

    // ---- SafetyMechanism ----
    private void analyzeMechanismImpact(SafetyMechanism sm, UnifiedSystemModel model,
                                         Set<EObject> impacted, StringBuilder sb) {
        sb.append("SAFETY MECHANISM IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        sb.append("Type: ").append(sm.getMechanismType()).append("\n");
        int dcPct = (int) Math.round(sm.getDiagnosticCoverage() * 100);
        sb.append("Diagnostic Coverage: ").append(dcPct).append("%\n");
        if (sm.getImplementedIn() != null)
            sb.append("Implemented In: ").append(sm.getImplementedIn().getName()).append("\n");
        sb.append("\nDIRECTLY IMPACTED ELEMENTS:\n");

        if (!sm.getImplements().isEmpty()) {
            sb.append("\n  Technical Safety Requirements (").append(sm.getImplements().size()).append("):\n");
            for (TechnicalSafetyRequirement tsr : sm.getImplements()) {
                sb.append("    • ").append(tsr.getRequirementId()).append(": ").append(tsr.getName()).append("\n");
                impacted.add(tsr);
            }
        }
        List<FMEAItem> validators = new ArrayList<>();
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (item.getValidatesMechanisms().contains(sm)) validators.add(item);
        if (!validators.isEmpty()) {
            sb.append("\n  Validating FMEA Items (").append(validators.size()).append("):\n");
            for (FMEAItem item : validators) {
                sb.append("    • ").append(item.getName()).append("\n");
                impacted.add(item);
            }
        }
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this mechanism may invalidate ").append(validators.size()).append(
            " FMEA validation(s).\n");
        sb.append("  Re-validation required per ISO 26262-5 §8.4 (hardware safety requirements).\n");
        if (dcPct > 0)
            sb.append("  Diagnostic coverage change must be re-evaluated for PMHF targets.\n");
    }

    // ---- Generic Requirement (legacy) ----
    private void analyzeRequirementImpact(Requirement req, UnifiedSystemModel model,
                                           Set<EObject> impacted, StringBuilder sb) {
        sb.append("REQUIREMENT IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        Object reqType  = RequirementTraceHelper.getRequirementType(req);
        Object priority = RequirementTraceHelper.getPriority(req);
        sb.append("Type: ").append(reqType != null ? reqType : "N/A").append("\n");
        sb.append("Priority: ").append(priority != null ? priority : "N/A").append("\n\n");
        sb.append("DIRECTLY IMPACTED ELEMENTS:\n");

        List<SafetyCriticalBlock> blocks = RequirementTraceHelper.getRelatedBlocks(req);
        if (!blocks.isEmpty()) {
            sb.append("\n  Related Blocks (").append(blocks.size()).append("):\n");
            for (SafetyCriticalBlock block : blocks) {
                sb.append("    • ").append(block.getName()).append("\n");
                impacted.add(block);
            }
        }
        List<IntegratedHazard> hazards = RequirementTraceHelper.getRelatedHazards(req);
        if (!hazards.isEmpty()) {
            sb.append("\n  Related Hazards (").append(hazards.size()).append("):\n");
            for (IntegratedHazard h : hazards) {
                sb.append("    • ").append(h.getName()).append(" [").append(h.getRiskLevel()).append("]\n");
                impacted.add(h);
            }
        }
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (RequirementTraceHelper.getRelatedRequirements(item).contains(req))
                    impacted.add(item);
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this requirement impacts ").append(impacted.size()).append(" element(s).\n");
    }

    // ---- SafetyCriticalBlock ----
    private void analyzeBlockImpact(SafetyCriticalBlock block, UnifiedSystemModel model,
                                     Set<EObject> impacted, StringBuilder sb) {
        sb.append("SAFETY-CRITICAL BLOCK IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        sb.append("ASIL Level: ").append(block.getAsilLevel()).append("\n");
        sb.append("Safety Criticality: ").append(block.getSafetyCriticality()).append("\n\n");
        sb.append("DIRECTLY IMPACTED ELEMENTS:\n");

        // TSRs that realize this block
        List<TechnicalSafetyRequirement> tsrs = new ArrayList<>();
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements())
            if (tsr.getRealizedBy().contains(block)) tsrs.add(tsr);
        if (!tsrs.isEmpty()) {
            sb.append("\n  Technical Safety Requirements (").append(tsrs.size()).append("):\n");
            for (TechnicalSafetyRequirement tsr : tsrs) {
                sb.append("    • ").append(tsr.getRequirementId()).append(": ").append(tsr.getName()).append("\n");
                impacted.add(tsr);
            }
        }

        // Hazards
        List<IntegratedHazard> hazards = new ArrayList<>();
        for (IntegratedHazard h : model.getGlobalHazards())
            if (h.getRelatedBlocks().contains(block)) hazards.add(h);
        if (!hazards.isEmpty()) {
            sb.append("\n  Hazards Threatening This Block (").append(hazards.size()).append("):\n");
            for (IntegratedHazard h : hazards) {
                sb.append("    • ").append(h.getName()).append(" [").append(h.getRiskLevel()).append("]\n");
                impacted.add(h);
            }
        }

        // FMEA items
        List<FMEAItem> fmeaItems = new ArrayList<>();
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (item.getAnalyzedComponent() == block) fmeaItems.add(item);
        if (!fmeaItems.isEmpty()) {
            sb.append("\n  FMEA Items Analyzing This Block (").append(fmeaItems.size()).append("):\n");
            for (FMEAItem item : fmeaItems) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                sb.append("    • ").append(item.getName()).append(" [RPN: ").append(rpn).append("]\n");
                impacted.add(item);
            }
        }

        // Legacy requirements
        List<Requirement> reqs = new ArrayList<>();
        for (Requirement req : RequirementTraceHelper.getRequirements(model))
            if (RequirementTraceHelper.getRelatedBlocks(req).contains(block)) reqs.add(req);
        if (!reqs.isEmpty()) {
            sb.append("\n  Requirements (").append(reqs.size()).append("):\n");
            for (Requirement req : reqs) {
                sb.append("    • ").append(req.getId()).append(": ").append(req.getName()).append("\n");
                impacted.add(req);
            }
        }

        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this block impacts ").append(impacted.size()).append(" element(s).\n");
        if (block.getSafetyCriticality() == SafetyCriticalityLevel.HIGH ||
                block.getSafetyCriticality() == SafetyCriticalityLevel.CRITICAL)
            sb.append("  HIGH/CRITICAL safety criticality — safety review board approval required.\n");
    }

    // ---- IntegratedHazard ----
    private void analyzeHazardImpact(IntegratedHazard hazard, UnifiedSystemModel model,
                                      Set<EObject> impacted, StringBuilder sb) {
        sb.append("HAZARD IMPACT ANALYSIS (ISO 26262-3)\n");
        sb.append("──────────────────────────────────\n");
        sb.append("Risk Level: ").append(hazard.getRiskLevel()).append("\n");
        sb.append("Mitigation: ").append(hazard.getMitigationStatus()).append("\n\n");
        sb.append("DIRECTLY IMPACTED ELEMENTS:\n");

        List<SafetyGoal> goals = new ArrayList<>();
        for (SafetyGoal sg : model.getSafetyGoals())
            if (hazard.equals(sg.getRelatedHazard())) goals.add(sg);
        if (!goals.isEmpty()) {
            sb.append("\n  Safety Goals (").append(goals.size()).append("):\n");
            for (SafetyGoal sg : goals) {
                sb.append("    • ").append(sg.getName()).append("\n");
                impacted.add(sg);
                for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo()) impacted.add(fsr);
            }
        }

        if (!hazard.getRelatedBlocks().isEmpty()) {
            sb.append("\n  Blocks (").append(hazard.getRelatedBlocks().size()).append("):\n");
            for (SafetyCriticalBlock block : hazard.getRelatedBlocks()) {
                sb.append("    • ").append(block.getName()).append(" [").append(block.getAsilLevel()).append("]\n");
                impacted.add(block);
            }
        }

        List<FMEAItem> fmeaItems = new ArrayList<>();
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (item.getRelatedHazards().contains(hazard)) fmeaItems.add(item);
        if (!fmeaItems.isEmpty()) {
            sb.append("\n  FMEA Items (").append(fmeaItems.size()).append("):\n");
            for (FMEAItem item : fmeaItems) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                sb.append("    • ").append(item.getName()).append(" [RPN: ").append(rpn).append("]\n");
                impacted.add(item);
            }
        }

        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing this hazard affects ").append(impacted.size()).append(" element(s).\n");
        if (hazard.getRiskLevel() == RiskLevel.CATASTROPHIC || hazard.getRiskLevel() == RiskLevel.CRITICAL_RISK)
            sb.append("  CATASTROPHIC/CRITICAL risk — requires safety manager approval (ISO 26262-3 §7).\n");
    }

    // ---- FMEAItem ----
    private void analyzeFMEAItemImpact(FMEAItem item, UnifiedSystemModel model,
                                        Set<EObject> impacted, StringBuilder sb) {
        int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
        sb.append("FMEA ITEM IMPACT ANALYSIS (ISO 26262-5)\n");
        sb.append("──────────────────────────────────\n");
        sb.append("RPN: ").append(rpn).append(" (S:").append(item.getSeverity())
          .append(" × O:").append(item.getOccurrence()).append(" × D:").append(item.getDetection()).append(")\n");
        sb.append("Action Status: ").append(item.getActionStatus()).append("\n\n");
        sb.append("DIRECTLY IMPACTED ELEMENTS:\n");

        // TSRs verified by this item
        List<TechnicalSafetyRequirement> verifiedTSRs = new ArrayList<>();
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements())
            if (tsr.getVerifiedBy().contains(item)) verifiedTSRs.add(tsr);
        if (!verifiedTSRs.isEmpty()) {
            sb.append("\n  TSRs Verified By This Item (").append(verifiedTSRs.size()).append("):\n");
            for (TechnicalSafetyRequirement tsr : verifiedTSRs) {
                sb.append("    • ").append(tsr.getRequirementId()).append(": ").append(tsr.getName()).append("\n");
                impacted.add(tsr);
            }
        }
        if (!item.getValidatesMechanisms().isEmpty()) {
            sb.append("\n  Safety Mechanisms Validated (").append(item.getValidatesMechanisms().size()).append("):\n");
            for (SafetyMechanism sm : item.getValidatesMechanisms()) {
                sb.append("    • ").append(sm.getName()).append("\n");
                impacted.add(sm);
            }
        }
        if (item.getAnalyzedComponent() != null) {
            sb.append("\n  Analyzed Component:\n    • ").append(item.getAnalyzedComponent().getName()).append("\n");
            impacted.add(item.getAnalyzedComponent());
        }
        if (item.getFailureMode() != null) {
            sb.append("\n  Failure Mode:\n    • ").append(item.getFailureMode().getName()).append("\n");
            impacted.add(item.getFailureMode());
        }
        for (IntegratedHazard h : item.getRelatedHazards()) {
            sb.append("\n  Hazard: ").append(h.getName()).append("\n");
            impacted.add(h);
        }

        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing S/O/D ratings affects RPN and may change risk classification.\n");
        if (rpn > 100)
            sb.append("  ⚠️ HIGH RPN (>100) — corrective actions must be defined and tracked.\n");
        if (!verifiedTSRs.isEmpty())
            sb.append("  Re-verification of ").append(verifiedTSRs.size()).append(" TSR(s) required.\n");
    }

    // ---- BlockFailureMode ----
    private void analyzeFailureModeImpact(BlockFailureMode fm, UnifiedSystemModel model,
                                           Set<EObject> impacted, StringBuilder sb) {
        sb.append("FAILURE MODE IMPACT ANALYSIS\n");
        sb.append("──────────────────────────────────\n");
        sb.append("Failure Rate: ").append(fm.getFailureRate()).append("\n\n");
        sb.append("DIRECTLY IMPACTED ELEMENTS:\n");

        if (fm.getAffectedBlock() != null) {
            sb.append("\n  Affected Block:\n    • ").append(fm.getAffectedBlock().getName()).append("\n");
            impacted.add(fm.getAffectedBlock());
        }
        List<FMEAItem> fmeaItems = new ArrayList<>();
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (item.getFailureMode() == fm) fmeaItems.add(item);
        if (!fmeaItems.isEmpty()) {
            sb.append("\n  FMEA Items (").append(fmeaItems.size()).append("):\n");
            for (FMEAItem item : fmeaItems) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                sb.append("    • ").append(item.getName()).append(" [RPN: ").append(rpn).append("]\n");
                impacted.add(item);
            }
        }
        sb.append("\nIMPACT SUMMARY:\n");
        sb.append("  Changing failure rate impacts ").append(fmeaItems.size()).append(" FMEA item(s) — RPN values will change.\n");
    }

    // =========================================================================
    // Helpers
    // =========================================================================
    private String getElementName(EObject element) {
        if (element instanceof UnifiedElement) {
            String name = ((UnifiedElement) element).getName();
            return (name != null && !name.isEmpty()) ? name : "<unnamed>";
        }
        return element.eClass().getName();
    }

    private EObject getSemanticElement(EObject obj) {
        if (obj instanceof DDiagramElement) {
            EObject target = ((DDiagramElement) obj).getTarget();
            if (target != null) return target;
        }
        if (obj instanceof DSemanticDecorator) return ((DSemanticDecorator) obj).getTarget();
        return obj;
    }

    private UnifiedSystemModel getUnifiedSystemModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        if (obj.eContainer() != null) return getUnifiedSystemModel(obj.eContainer());
        return null;
    }

    private void showError(String title, String message) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), title, message));
    }

    private void showInfo(String title, String message) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, message));
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }
}