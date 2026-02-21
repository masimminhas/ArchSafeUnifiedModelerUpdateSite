package edu.kit.sdq.dsis.unified.design.actions.req;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import unified.*;

/**
 * Exports a structured Safety Requirement Review Report as a CSV file.
 *
 * This report is the primary work product artefact for a functional safety
 * assessor (FSA) reviewing the Technical Safety Concept.  It covers:
 *
 *   Section 1 — Executive Summary with ISO 26262 references
 *   Section 2 — Safety Goal Review (SafetyGoal, ASIL, hazard link, status)
 *   Section 3 — Functional Safety Requirement Matrix
 *   Section 4 — Technical Safety Requirement Matrix with verification status
 *   Section 5 — Safety Mechanism Coverage
 *   Section 6 — Compliance Gap Summary with exact clause references
 *
 * The report maps directly to:
 *   Work Product [3-9]  — Functional Safety Concept
 *   Work Product [4-6]  — Technical Safety Concept (Safety Requirements Spec.)
 *   ISO 26262-2:2018 §6.4 — Safety Plan / Work Product Approval
 *
 * ISO 26262 References:
 *   ISO 26262-2:2018 §6.4   — Safety Plan & Work Product Approval
 *   ISO 26262-3:2018 §8     — Functional Safety Concept
 *   ISO 26262-4:2018 §6.4.5 — Safety Requirement Consistency & Completeness
 *   ISO 26262-4:2018 §7.4   — Verification of Technical Safety Requirements
 */
public class ExportSafetyRequirementReportAction extends AbstractExternalJavaAction {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String FILE_DATE   = "yyyyMMdd_HHmmss";

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        UnifiedSystemModel model = resolveModel(selections);
        if (model == null) {
            showError("No Model", "Please select a UnifiedSystemModel.");
            return;
        }

        Shell shell = Display.getDefault().getActiveShell();
        FileDialog dialog = new FileDialog(shell, SWT.SAVE);
        dialog.setFilterNames(new String[]{"CSV Files (*.csv)", "All Files (*.*)"});
        dialog.setFilterExtensions(new String[]{"*.csv", "*.*"});
        dialog.setFileName("ISO26262_SafetyRequirementReview_"
            + new SimpleDateFormat(FILE_DATE).format(new Date()) + ".csv");

        String path = dialog.open();
        if (path == null) return;

        try {
            writeReport(model, path);
            showInfo("Export Successful",
                "Safety Requirement Review Report exported to:\n" + path
                + "\n\nReport covers:\n"
                + "  • " + Iso26262Reference.WP_3_9_FSC + "\n"
                + "  • " + Iso26262Reference.WP_4_6_TSC + "\n"
                + "  • " + Iso26262Reference.WP_3_8_HARA_REPORT);
        } catch (IOException e) {
            showError("Export Failed", "Failed to write report: " + e.getMessage());
        }
    }

    private void writeReport(UnifiedSystemModel model, String path) throws IOException {
        String now = new SimpleDateFormat(DATE_FORMAT).format(new Date());

        try (BufferedWriter w = new BufferedWriter(new FileWriter(path))) {

            // ── Section 1: Header & Executive Summary ─────────────────────────
            w.write("ISO 26262:2018 SAFETY REQUIREMENT REVIEW REPORT\n");
            w.write("Generated," + csv(now) + "\n");
            w.write("Standard Reference," + csv(Iso26262Reference.PART4_REQ_CONSISTENCY) + "\n");
            w.write("Work Product (FSC)," + csv(Iso26262Reference.WP_3_9_FSC) + "\n");
            w.write("Work Product (TSC)," + csv(Iso26262Reference.WP_4_6_TSC) + "\n");
            w.write("\n");

            w.write("EXECUTIVE SUMMARY\n");
            w.write("Total Safety Goals,"     + model.getSafetyGoals().size() + "\n");
            w.write("Total FSRs,"             + model.getFunctionalRequirements().size() + "\n");
            w.write("Total TSRs,"             + model.getTechnicalRequirements().size() + "\n");
            w.write("Total Safety Mechanisms," + model.getSafetyMechanisms().size() + "\n");
            w.write("Total Hazards,"          + model.getGlobalHazards().size() + "\n");

            // Coverage counts
            long approvedGoals = model.getSafetyGoals().stream()
                .filter(sg -> isApproved(sg.getStatus())).count();
            long approvedFSRs  = model.getFunctionalRequirements().stream()
                .filter(fsr -> isApproved(fsr.getStatus())).count();
            long approvedTSRs  = model.getTechnicalRequirements().stream()
                .filter(tsr -> isApproved(tsr.getStatus())).count();

            w.write("Approved Safety Goals,"  + approvedGoals + " / " + model.getSafetyGoals().size() + "\n");
            w.write("Approved FSRs,"          + approvedFSRs  + " / " + model.getFunctionalRequirements().size() + "\n");
            w.write("Approved TSRs,"          + approvedTSRs  + " / " + model.getTechnicalRequirements().size() + "\n");
            w.write("\n");

            // ── Section 2: Safety Goal Review ─────────────────────────────────
            w.write("SECTION 2: SAFETY GOAL REVIEW\n");
            w.write(csv("ISO 26262 Reference") + "," + csv(Iso26262Reference.PART3_SAFETY_GOALS) + "\n");
            w.write(csv("Work Product") + "," + csv(Iso26262Reference.WP_3_8_HARA_REPORT) + "\n");
            w.write("Goal ID,Goal Name,ASIL Level,Related Hazard,Allocated FSRs,Status,"
                  + "Requirement Text,Clause\n");

            for (SafetyGoal sg : model.getSafetyGoals()) {
                String hazardName = sg.getRelatedHazard() != null ? name(sg.getRelatedHazard()) : "NOT LINKED";
                int fsrCount = sg.getAllocatedTo() != null ? sg.getAllocatedTo().size() : 0;
                String clause = Iso26262Reference.PART3_SAFETY_GOAL_ASIL;

                w.write(csv(sg.getRequirementId()) + ","
                      + csv(name(sg)) + ","
                      + csv(asilStr(sg.getAsilLevel())) + ","
                      + csv(hazardName) + ","
                      + fsrCount + ","
                      + csv(statusStr(sg.getStatus())) + ","
                      + csv(sg.getRequirementText()) + ","
                      + Iso26262Reference.csvClause(clause) + "\n");
            }
            w.write("\n");

            // ── Section 3: Functional Safety Requirement Matrix ───────────────
            w.write("SECTION 3: FUNCTIONAL SAFETY REQUIREMENT MATRIX\n");
            w.write(csv("ISO 26262 Reference") + "," + csv(Iso26262Reference.PART3_SAFETY_GOALS) + "\n");
            w.write(csv("Work Product") + "," + csv(Iso26262Reference.WP_3_9_FSC) + "\n");
            w.write("FSR ID,FSR Name,ASIL Level,Parent Safety Goal,Refined TSRs,Status,"
                  + "Requirement Text,Derivation Compliant,Clause\n");

            for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
                // Find parent safety goal
                String parentGoal = model.getSafetyGoals().stream()
                    .filter(sg -> sg.getAllocatedTo() != null && sg.getAllocatedTo().contains(fsr))
                    .map(sg -> name(sg) + "[" + sg.getRequirementId() + "]")
                    .findFirst().orElse("ORPHANED — no parent Safety Goal");

                int tsrCount = fsr.getRefinedTo() != null ? fsr.getRefinedTo().size() : 0;
                boolean derivationOk = !parentGoal.startsWith("ORPHANED") && tsrCount > 0;
                String clause = Iso26262Reference.PART4_TECHNICAL_SAFETY_CONCEPT;

                w.write(csv(fsr.getRequirementId()) + ","
                      + csv(name(fsr)) + ","
                      + csv(asilStr(((SafetyGoal) fsr).getAsilLevel())) + ","
                      + csv(parentGoal) + ","
                      + tsrCount + ","
                      + csv(statusStr(fsr.getStatus())) + ","
                      + csv(fsr.getRequirementText()) + ","
                      + (derivationOk ? "YES" : "NO — gap") + ","
                      + Iso26262Reference.csvClause(clause) + "\n");
            }
            w.write("\n");

            // ── Section 4: Technical Safety Requirement Matrix ────────────────
            w.write("SECTION 4: TECHNICAL SAFETY REQUIREMENT MATRIX\n");
            w.write(csv("ISO 26262 Reference") + "," + csv(Iso26262Reference.PART4_TSR_VERIFICATION) + "\n");
            w.write(csv("Work Product") + "," + csv(Iso26262Reference.WP_4_6_TSC) + "\n");
            w.write("TSR ID,TSR Name,ASIL Level,Parent FSR,Realized By Block,FMEA Verified,"
                  + "Status,Requirement Text,Allocation Compliant,Clause\n");

            // pre-build FMEA verification lookup
            Map<TechnicalSafetyRequirement, Integer> tsrFMEACount = new HashMap<>();
            for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
                for (FMEAItem item : analysis.getFmeaItems()) {
                    for (Object req : safeList(item, "relatedRequirements")) {
                        if (req instanceof TechnicalSafetyRequirement) {
                            tsrFMEACount.merge((TechnicalSafetyRequirement) req, 1, Integer::sum);
                        }
                    }
                }
            }

            for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                String parentFSR = model.getFunctionalRequirements().stream()
                    .filter(fsr -> fsr.getRefinedTo() != null && fsr.getRefinedTo().contains(tsr))
                    .map(fsr -> name(fsr) + "[" + fsr.getRequirementId() + "]")
                    .findFirst().orElse("ORPHANED");

                List<?> realizedBy = safeList(tsr, "realizedBy");
                String blockNames = realizedBy.isEmpty() ? "NOT ALLOCATED" :
                    realizedBy.stream()
                        .filter(b -> b instanceof EObject)
                        .map(b -> name((EObject) b))
                        .reduce((a, b) -> a + "; " + b).orElse("?");

                int fmeaCount = tsrFMEACount.getOrDefault(tsr, 0);
                boolean allocationOk = !realizedBy.isEmpty() && !parentFSR.startsWith("ORPHANED");
                String clause = Iso26262Reference.PART4_TSR_ALLOCATION;

                w.write(csv(tsr.getRequirementId()) + ","
                      + csv(name(tsr)) + ","
                      + csv(asilStr(((SafetyGoal) tsr).getAsilLevel())) + ","
                      + csv(parentFSR) + ","
                      + csv(blockNames) + ","
                      + fmeaCount + ","
                      + csv(statusStr(tsr.getStatus())) + ","
                      + csv(tsr.getRequirementText()) + ","
                      + (allocationOk ? "YES" : "NO — gap") + ","
                      + Iso26262Reference.csvClause(clause) + "\n");
            }
            w.write("\n");

            // ── Section 5: Safety Mechanism Coverage ──────────────────────────
            w.write("SECTION 5: SAFETY MECHANISM COVERAGE\n");
            w.write(csv("ISO 26262 Reference") + "," + csv(Iso26262Reference.PART4_SYSTEM_DESIGN) + "\n");
            w.write("Mechanism Name,Type,Implements TSRs,TSR IDs,Clause\n");

            for (SafetyMechanism sm : model.getSafetyMechanisms()) {
                List<?> impls = safeList(sm, "implements");
                String tsrIds = impls.stream()
                    .filter(t -> t instanceof TechnicalSafetyRequirement)
                    .map(t -> ((TechnicalSafetyRequirement) t).getRequirementId())
                    .reduce((a, b) -> a + "; " + b).orElse("NONE");

                w.write(csv(name(sm)) + ","
                      + csv(sm.getMechanismType() != null ? sm.getMechanismType().toString() : "unset") + ","
                      + impls.size() + ","
                      + csv(tsrIds) + ","
                      + Iso26262Reference.csvClause(Iso26262Reference.PART4_SYSTEM_DESIGN) + "\n");
            }
            w.write("\n");

            // ── Section 6: Compliance Gap Summary ────────────────────────────
            w.write("SECTION 6: COMPLIANCE GAP SUMMARY\n");
            w.write("Gap Type,Count,ISO 26262 Clause,Severity\n");

            long goalsNoHazard   = model.getSafetyGoals().stream().filter(sg -> sg.getRelatedHazard() == null).count();
            long goalsNoASIL     = model.getSafetyGoals().stream().filter(sg -> sg.getAsilLevel() == null).count();
            long goalsNoFSR      = model.getSafetyGoals().stream()
                                       .filter(sg -> sg.getAllocatedTo() == null || sg.getAllocatedTo().isEmpty()).count();
            long fsrsNoTSR       = model.getFunctionalRequirements().stream()
                                       .filter(fsr -> fsr.getRefinedTo() == null || fsr.getRefinedTo().isEmpty()).count();
            long tsrsNoBlock     = model.getTechnicalRequirements().stream()
                                       .filter(tsr -> safeList(tsr, "realizedBy").isEmpty()).count();
            long tsrsNoFMEA      = model.getTechnicalRequirements().stream()
                                       .filter(tsr -> tsrFMEACount.getOrDefault(tsr, 0) == 0).count();
            long smNoTSR         = model.getSafetyMechanisms().stream()
                                       .filter(sm -> safeList(sm, "implements").isEmpty()).count();

            writeGapRow(w, "Safety Goals without linked hazard", goalsNoHazard,
                Iso26262Reference.PART3_HARA, "CRITICAL");
            writeGapRow(w, "Safety Goals without ASIL level", goalsNoASIL,
                Iso26262Reference.PART3_SAFETY_GOAL_ASIL, "CRITICAL");
            writeGapRow(w, "Safety Goals without allocated FSR", goalsNoFSR,
                Iso26262Reference.PART3_SAFETY_GOALS, "CRITICAL");
            writeGapRow(w, "FSRs without refined TSR", fsrsNoTSR,
                Iso26262Reference.PART4_TECHNICAL_SAFETY_CONCEPT, "CRITICAL");
            writeGapRow(w, "TSRs not allocated to any block", tsrsNoBlock,
                Iso26262Reference.PART4_TSR_ALLOCATION, "CRITICAL");
            writeGapRow(w, "TSRs without FMEA verification evidence", tsrsNoFMEA,
                Iso26262Reference.PART4_TSR_VERIFICATION, "WARNING");
            writeGapRow(w, "Safety Mechanisms not implementing any TSR", smNoTSR,
                Iso26262Reference.PART4_SYSTEM_DESIGN, "WARNING");
            w.write("\n");

            // ── Footer ────────────────────────────────────────────────────────
            w.write("DISCLAIMER\n");
            w.write(csv(Iso26262Reference.REPORT_DISCLAIMER) + "\n");
        }
    }

    private void writeGapRow(BufferedWriter w, String gapType, long count, String clause, String severity)
            throws IOException {
        w.write(csv(gapType) + "," + count + "," + Iso26262Reference.csvClause(clause) + "," + severity + "\n");
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private boolean isApproved(Object status) {
        if (status == null) return false;
        String s = status.toString().toUpperCase();
        return s.contains("APPROVED") || s.contains("ACCEPTED");
    }

    private String statusStr(Object status) {
        return status != null ? status.toString() : "DRAFT";
    }

    private String asilStr(Object asil) {
        return asil != null ? asil.toString() : "unset";
    }

    @SuppressWarnings({"rawtypes"})
    private List<?> safeList(EObject obj, String featureName) {
        try {
            java.lang.reflect.Method m = obj.getClass().getMethod(
                "get" + Character.toUpperCase(featureName.charAt(0)) + featureName.substring(1));
            Object result = m.invoke(obj);
            if (result instanceof List) return (List) result;
        } catch (Exception ignored) {
            org.eclipse.emf.ecore.EStructuralFeature f = obj.eClass().getEStructuralFeature(featureName);
            if (f != null) {
                Object val = obj.eGet(f);
                if (val instanceof List) return (List) val;
            }
        }
        return Collections.emptyList();
    }

    private String csv(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n"))
            return "\"" + s.replace("\"", "\"\"") + "\"";
        return s;
    }

    private String name(EObject obj) {
        if (obj instanceof UnifiedElement) {
            String n = ((UnifiedElement) obj).getName();
            return n != null ? n : "<unnamed>";
        }
        return obj.eClass().getName();
    }

    private UnifiedSystemModel resolveModel(Collection<? extends EObject> selections) {
        if (selections == null || selections.isEmpty()) return null;
        EObject sel = selections.iterator().next();
        if (sel instanceof DSemanticDecorator) sel = ((DSemanticDecorator) sel).getTarget();
        return walkToModel(sel);
    }

    private UnifiedSystemModel walkToModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        return obj.eContainer() != null ? walkToModel(obj.eContainer()) : null;
    }

    private void showError(String title, String msg) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openError(Display.getDefault().getActiveShell(), title, msg));
    }

    private void showInfo(String title, String msg) {
        Display.getDefault().syncExec(() ->
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), title, msg));
    }

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }
}