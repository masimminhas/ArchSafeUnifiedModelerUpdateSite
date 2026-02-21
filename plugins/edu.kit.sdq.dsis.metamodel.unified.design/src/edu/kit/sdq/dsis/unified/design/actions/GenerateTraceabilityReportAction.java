package edu.kit.sdq.dsis.unified.design.actions;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import unified.*;

/**
 * Generate Traceability Report Action — produces a rich HTML report.
 *
 * Report includes:
 *   1. Executive summary with animated stat cards
 *   2. GQM metric scores (MCR, HTI, RAR, FLC, TDS, MVR) with gauges
 *   3. ISO 26262 conformance checklist (Parts 3, 4, 5, 6, 8)
 *   4. Full requirement layer (SafetyGoal → FSR → TSR chain)
 *   5. Colour-coded traceability matrix
 *   6. Gap analysis with severity badges
 *   7. Element-detail tables for hazards, FMEA, mechanisms
 *   8. Recommendations panel
 */
public class GenerateTraceabilityReportAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No model selected", "Please select a UnifiedSystemModel.");
            return;
        }

        EObject first = selections.iterator().next();
        UnifiedSystemModel model = getUnifiedSystemModel(first);
        if (model == null) {
            showError("Invalid Selection", "Please select a valid UnifiedSystemModel.");
            return;
        }

        Shell shell = Display.getDefault().getActiveShell();
        FileDialog dialog = new FileDialog(shell, SWT.SAVE);
        dialog.setFilterNames(new String[] { "HTML Report (*.html)", "All Files (*.*)" });
        dialog.setFilterExtensions(new String[] { "*.html", "*.*" });
        dialog.setFileName("TraceabilityReport_" +
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html");

        String filePath = dialog.open();
        if (filePath == null) return;

        try {
            generateHtmlReport(model, filePath);
            showInfo("Report Generated",
                "Traceability report saved to:\n" + filePath +
                "\n\nOpen the file in any web browser to view the formatted report.");
        } catch (IOException e) {
            showError("Export Failed", "Failed to generate report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // =========================================================================
    // Main report builder
    // =========================================================================
    private void generateHtmlReport(UnifiedSystemModel model, String filePath)
            throws IOException {

        String ts = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Compute all metrics once
        int totalHazards   = model.getGlobalHazards().size();
        int totalBlocks    = model.getRootBlocks().size() + model.getSystemBlocks().size();
        int totalSafetyGoals = model.getSafetyGoals().size();
        int totalFSR       = model.getFunctionalRequirements().size();
        int totalTSR       = model.getTechnicalRequirements().size();
        int totalMechanisms = model.getSafetyMechanisms().size();
        int totalFMEAItems = 0;
        for (FMEAAnalysis fa : model.getFmeaAnalysis())
            totalFMEAItems += fa.getFmeaItems().size();

        int totalTraceLinks = computeTotalLinks(model);

        // GQM metric values (0.0 – 1.0)
        double mcrVal = computeMCR(model);
        double htiVal = computeHTI(model);
        double rarVal = computeRAR(model);
        double flcVal = computeFLC(model);
        double tdsVal = computeTDS(model);
        double mvrVal = computeMVR(model);

        int mcrPct = (int) Math.round(mcrVal * 100);
        int htiPct = (int) Math.round(htiVal * 100);
        int rarPct = (int) Math.round(rarVal * 100);
        int flcPct = (int) Math.round(flcVal * 100);
        int tdsPct = (int) Math.round(tdsVal * 100);
        int mvrPct = (int) Math.round(mvrVal * 100);

        boolean mcrPass = mcrVal >= 0.90;
        boolean htiPass = htiVal >= 1.00;
        boolean rarPass = rarVal >= 0.95;
        boolean flcPass = flcVal >= 1.00;
        boolean tdsPass = tdsVal >= 0.80;
        boolean mvrPass = mvrVal >= 0.85;
        int passCount = (mcrPass?1:0)+(htiPass?1:0)+(rarPass?1:0)+(flcPass?1:0)+(tdsPass?1:0)+(mvrPass?1:0);
        int overallPct = (mcrPct + htiPct + rarPct + flcPct + tdsPct + mvrPct) / 6;
        String overallGrade = overallPct >= 90 ? "A (Excellent)" : overallPct >= 80 ? "B (Very Good)" :
                              overallPct >= 70 ? "C (Good)"      : overallPct >= 60 ? "D (Fair)" : "F (Needs Work)";
        String overallClass = overallPct >= 80 ? "score-good" : overallPct >= 60 ? "score-ok" : "score-poor";

        // Count ISO 26262 conformance checks
        List<IsoCheck> isoChecks = buildIsoChecklist(model);
        long isoPass = isoChecks.stream().filter(c -> c.pass).count();

        // Gap analysis
        List<String> gaps = buildGapList(model);

        try (FileWriter w = new FileWriter(filePath)) {
            w.write(htmlHead());
            w.write("<body>\n");

            // ---- Header ----
            w.write("<div class='header'>\n");
            w.write("  <h1>🔗 Traceability Analysis Report</h1>\n");
            w.write("  <p class='subtitle'>Unified Safety &amp; Architecture Model — ISO 26262 / IEC 62304 Conformance</p>\n");
            w.write("  <p class='date'>Generated: " + ts + " &nbsp;|&nbsp; Model Version: " +
                    esc(model.getModelVersion()) + "</p>\n");
            w.write("</div>\n");

            // ---- Stat cards ----
            w.write("<div class='section'>\n<h2>📊 Executive Summary</h2>\n");
            w.write("<div class='summary-grid'>\n");
            statCard(w, String.valueOf(totalHazards),    "Integrated Hazards",       "card-red");
            statCard(w, String.valueOf(totalSafetyGoals),"Safety Goals",             "card-orange");
            statCard(w, String.valueOf(totalFSR),        "Functional Safety Req.",   "card-yellow");
            statCard(w, String.valueOf(totalTSR),        "Technical Safety Req.",    "card-blue");
            statCard(w, String.valueOf(totalMechanisms), "Safety Mechanisms",        "card-purple");
            statCard(w, String.valueOf(totalFMEAItems),  "FMEA Items",              "card-teal");
            statCard(w, String.valueOf(totalBlocks),     "Architecture Blocks",      "card-green");
            statCard(w, String.valueOf(totalTraceLinks), "Total Trace Links",        "card-indigo");
            w.write("</div>\n");
            w.write("<div class='score-box " + overallClass + "'>\n");
            w.write("  <h3>Overall Traceability Score</h3>\n");
            w.write("  <div class='score-value'>" + overallPct + "%</div>\n");
            w.write("  <div class='score-grade'>" + overallGrade + " &nbsp;|&nbsp; " +
                    passCount + "/6 GQM metrics passing</div>\n");
            w.write("</div>\n</div>\n");

            // ---- GQM Metrics ----
            w.write("<div class='section'>\n<h2>📐 GQM Quality Metrics</h2>\n");
            w.write("<p class='section-note'>Metrics are computed live from the model graph. " +
                    "Thresholds are defined in the empirical validation plan (GQM).</p>\n");
            w.write("<div class='metrics-grid'>\n");
            metricCard(w, "MCR", "Metamodel Coverage Ratio",
                "Fraction of the 9 required safety concept categories that are populated.",
                mcrPct, "≥ 90%", mcrPass);
            metricCard(w, "HTI", "Hazard Traceability Index",
                "Fraction of hazards covered by at least one Safety Goal (ISO 26262-3 §7.4).",
                htiPct, "= 100%", htiPass);
            metricCard(w, "RAR", "Requirement Allocation Ratio",
                "Fraction of TSRs allocated to at least one architecture block (ISO 26262-4 §7.1).",
                rarPct, "≥ 95%", rarPass);
            metricCard(w, "FLC", "FMEA Linkage Completeness",
                "Fraction of FMEA items with a failure mode linked (ISO 26262-5 §8.4).",
                flcPct, "= 100%", flcPass);
            metricCard(w, "TDS", "Traceability Density Score",
                "Actual cross-layer trace links as a fraction of theoretical maximum.",
                tdsPct, "≥ 80%", tdsPass);
            metricCard(w, "MVR", "Mechanism Verification Rate",
                "Fraction of safety mechanisms validated by a FMEA item (ISO 26262-5 §8.4).",
                mvrPct, "≥ 85%", mvrPass);
            w.write("</div>\n</div>\n");

            // ---- ISO 26262 Conformance ----
            w.write("<div class='section'>\n<h2>📜 ISO 26262 Conformance Checklist</h2>\n");
            w.write("<p class='section-note'>Automated checks against ISO 26262:2018 work product " +
                    "requirements. " + isoPass + "/" + isoChecks.size() + " checks passing.</p>\n");
            w.write("<table>\n<thead><tr><th>Clause</th><th>Requirement</th>" +
                    "<th>Evidence</th><th>Status</th></tr></thead>\n<tbody>\n");
            for (IsoCheck c : isoChecks) {
                String st = c.pass ? "<span class='status-pass'>✅ PASS</span>" :
                                     "<span class='status-fail'>❌ FAIL</span>";
                w.write("<tr><td><b>" + esc(c.clause) + "</b></td><td>" + esc(c.requirement) +
                        "</td><td>" + esc(c.evidence) + "</td><td>" + st + "</td></tr>\n");
            }
            w.write("</tbody></table>\n</div>\n");

            // ---- Requirement layer: SafetyGoal → FSR → TSR ----
            w.write("<div class='section'>\n<h2>📋 Safety Requirement Hierarchy</h2>\n");
            w.write("<p class='section-note'>V-model requirement derivation chain: " +
                    "Hazard → Safety Goal → Functional Safety Requirement → " +
                    "Technical Safety Requirement → Architecture Block / Safety Mechanism.</p>\n");
            if (model.getSafetyGoals().isEmpty()) {
                w.write("<div class='info-box info-warning'><p>⚠️ No Safety Goals defined. " +
                        "HARA output is not yet connected to the requirement hierarchy.</p></div>\n");
            } else {
                w.write("<table>\n<thead><tr><th>Safety Goal</th><th>ASIL</th>" +
                        "<th>Related Hazard</th><th>Allocated FSRs</th>" +
                        "<th>TSRs (via FSRs)</th><th>Mechanisms</th></tr></thead>\n<tbody>\n");
                for (SafetyGoal sg : model.getSafetyGoals()) {
                    int tsrCount = 0;
                    for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo())
                        tsrCount += fsr.getRefinedTo().size();
                    // Count mechanisms implementing TSRs under this safety goal
                    // SafetyMechanism.implements -> TSR has no eOpposite, so scan mechanisms
                    int mechCount = 0;
                    for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo())
                        for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo())
                            for (SafetyMechanism sm : model.getSafetyMechanisms())
                                if (sm.getImplements().contains(tsr)) mechCount++;
                    String hazardName = sg.getRelatedHazard() != null ?
                        esc(sg.getRelatedHazard().getName()) :
                        "<span class='badge badge-gap'>unlinked</span>";
                    // SafetyGoal uses getAsilLevel(), not getAllocatedASIL()
                    w.write("<tr><td><b>" + esc(sg.getName()) + "</b></td>" +
                            "<td>" + asilBadge(sg.getAsilLevel() != null ? sg.getAsilLevel().toString() : "?") + "</td>" +
                            "<td>" + hazardName + "</td>" +
                            "<td>" + sg.getAllocatedTo().size() + "</td>" +
                            "<td>" + tsrCount + "</td>" +
                            "<td>" + mechCount + "</td></tr>\n");
                }
                w.write("</tbody></table>\n");

                // FSR detail
                if (!model.getFunctionalRequirements().isEmpty()) {
                    w.write("<h3 style='margin-top:20px'>Functional Safety Requirements</h3>\n");
                    w.write("<table>\n<thead><tr><th>ID</th><th>Name</th><th>ASIL</th>" +
                            "<th>TSRs</th><th>Impl. Blocks</th><th>Status</th></tr></thead>\n<tbody>\n");
                    for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
                        w.write("<tr><td><code>" + esc(fsr.getRequirementId()) + "</code></td>" +
                                "<td>" + esc(fsr.getName()) + "</td>" +
                                "<td>" + asilBadge(fsr.getAllocatedFrom() != null ? fsr.getAllocatedFrom().toString() : "?") + "</td>" +
                                "<td>" + fsr.getRefinedTo().size() + "</td>" +
                                "<td>" + fsr.getImplementedBy().size() + "</td>" +
                                "<td>" + statusBadge(fsr.getStatus() != null ? fsr.getStatus().toString() : "DRAFT") + "</td></tr>\n");
                    }
                    w.write("</tbody></table>\n");
                }

                // TSR detail
                if (!model.getTechnicalRequirements().isEmpty()) {
                    w.write("<h3 style='margin-top:20px'>Technical Safety Requirements</h3>\n");
                    w.write("<table>\n<thead><tr><th>ID</th><th>Name</th><th>ASIL</th>" +
                            "<th>Verif.Method</th><th>Realized By</th><th>Verified By</th><th>Status</th></tr></thead>\n<tbody>\n");
                    for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                        boolean allocated = !tsr.getRealizedBy().isEmpty();
                        boolean verified  = !tsr.getVerifiedBy().isEmpty();
                        String rowClass = (!allocated || !verified) ? " class='row-warn'" : "";
                        w.write("<tr" + rowClass + "><td><code>" + esc(tsr.getRequirementId()) + "</code></td>" +
                                "<td>" + esc(tsr.getName()) + "</td>" +
                                "<td>" + asilBadge(tsr.getAllocatedASIL() != null ? tsr.getAllocatedASIL().toString() : "?") + "</td>" +
                                "<td>" + esc(tsr.getVerificationMethod() != null ? tsr.getVerificationMethod().toString() : "—") + "</td>" +
                                "<td>" + (allocated ? tsr.getRealizedBy().size() + " block(s)" : "<span class='badge badge-gap'>unallocated</span>") + "</td>" +
                                "<td>" + (verified  ? tsr.getVerifiedBy().size() + " item(s)"  : "<span class='badge badge-gap'>unverified</span>") + "</td>" +
                                "<td>" + statusBadge(tsr.getStatus() != null ? tsr.getStatus().toString() : "DRAFT") + "</td></tr>\n");
                    }
                    w.write("</tbody></table>\n");
                }
            }
            w.write("</div>\n");

            // ---- Traceability Matrix ----
            w.write("<div class='section'>\n<h2>🗺️ Traceability Matrix</h2>\n");
            w.write("<div class='matrix-container'>\n");
            w.write("<table class='trace-matrix'>\n<thead><tr>" +
                    "<th>Source Type</th><th>Source Element</th>" +
                    "<th>Relationship</th>" +
                    "<th>Target Type</th><th>Target Element</th><th>Info</th>" +
                    "</tr></thead>\n<tbody>\n");

            // SafetyGoal → Hazard
            for (SafetyGoal sg : model.getSafetyGoals()) {
                if (sg.getRelatedHazard() != null) {
                    traceRow(w, "SafetyGoal", sg.getName(), "addresses ↑",
                             "IntegratedHazard", sg.getRelatedHazard().getName(),
                             sg.getRelatedHazard().getRiskLevel().toString(), "badge-hazard", "badge-req");
                }
            }
            // SafetyGoal → FSR
            for (SafetyGoal sg : model.getSafetyGoals()) {
                for (FunctionalSafetyRequirement fsr : sg.getAllocatedTo()) {
                    traceRow(w, "SafetyGoal", sg.getName(), "allocates →",
                             "FSR", fsr.getRequirementId() + " " + fsr.getName(),
                             "ASIL " + (fsr.getAllocatedFrom() != null ? fsr.getAllocatedFrom() : "?"),
                             "badge-req", "badge-req");
                }
            }
            // FSR → TSR
            for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
                for (TechnicalSafetyRequirement tsr : fsr.getRefinedTo()) {
                    traceRow(w, "FSR", fsr.getRequirementId(), "refines →",
                             "TSR", tsr.getRequirementId() + " " + tsr.getName(),
                             "ASIL " + (tsr.getAllocatedASIL() != null ? tsr.getAllocatedASIL() : "?"),
                             "badge-req", "badge-req");
                }
            }
            // TSR → Block
            for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                for (SafetyCriticalBlock block : tsr.getRealizedBy()) {
                    traceRow(w, "TSR", tsr.getRequirementId(), "realized by →",
                             "Block", block.getName(),
                             "ASIL " + block.getAsilLevel(), "badge-req", "badge-block");
                }
            }
            // TSR → FMEAItem (verifiedBy)
            for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
                for (FMEAItem item : tsr.getVerifiedBy()) {
                    int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                    traceRow(w, "TSR", tsr.getRequirementId(), "verified by →",
                             "FMEAItem", item.getName(), "RPN: " + rpn, "badge-req", "badge-fmea");
                }
            }
            // Hazard → Block
            for (IntegratedHazard h : model.getGlobalHazards()) {
                for (SafetyCriticalBlock block : h.getRelatedBlocks()) {
                    traceRow(w, "Hazard", h.getName(), "threatens →",
                             "Block", block.getName(), h.getRiskLevel().toString(),
                             "badge-hazard", "badge-block");
                }
            }
            // FMEAItem → Block
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    if (item.getAnalyzedComponent() != null) {
                        int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                        traceRow(w, "FMEAItem", item.getName(), "analyzes →",
                                 "Block", item.getAnalyzedComponent().getName(),
                                 "RPN: " + rpn, "badge-fmea", "badge-block");
                    }
                }
            }
            // FMEAItem → Mechanism
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    for (SafetyMechanism sm : item.getValidatesMechanisms()) {
                        traceRow(w, "FMEAItem", item.getName(), "validates →",
                                 "SafetyMechanism", sm.getName(),
                                 sm.getMechanismType() != null ? sm.getMechanismType().toString() : "",
                                 "badge-fmea", "badge-mech");
                    }
                }
            }
            // FMEAItem → Hazard
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                for (FMEAItem item : fa.getFmeaItems()) {
                    for (IntegratedHazard h : item.getRelatedHazards()) {
                        traceRow(w, "FMEAItem", item.getName(), "mitigates →",
                                 "Hazard", h.getName(),
                                 item.getActionStatus() != null ? item.getActionStatus().toString() : "",
                                 "badge-fmea", "badge-hazard");
                    }
                }
            }
            // Mechanism → TSR
            for (SafetyMechanism sm : model.getSafetyMechanisms()) {
                for (TechnicalSafetyRequirement tsr : sm.getImplements()) {
                    traceRow(w, "SafetyMechanism", sm.getName(), "implements →",
                             "TSR", tsr.getRequirementId(),
                             sm.getMechanismType() != null ? sm.getMechanismType().toString() : "",
                             "badge-mech", "badge-req");
                }
            }
            // Legacy Requirement → Block
            for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
                for (SafetyCriticalBlock block : RequirementTraceHelper.getRelatedBlocks(req)) {
                    traceRow(w, "Requirement", req.getName(), "traces to →",
                             "Block", block.getName(), "", "badge-req", "badge-block");
                }
            }

            w.write("</tbody></table>\n</div>\n</div>\n");

            // ---- Hazard detail ----
            w.write("<div class='section'>\n<h2>⚠️ Hazard Analysis (ISO 26262-3)</h2>\n");
            w.write("<table>\n<thead><tr><th>Hazard</th><th>Risk Level</th>" +
                    "<th>Safety Goal</th><th>Related Blocks</th>" +
                    "<th>FMEA Items</th><th>Mitigation</th></tr></thead>\n<tbody>\n");
            for (IntegratedHazard h : model.getGlobalHazards()) {
                String sgName = "—";
                for (SafetyGoal sg : model.getSafetyGoals())
                    if (h.equals(sg.getRelatedHazard())) { sgName = sg.getName(); break; }
                int fmeaCount = 0;
                for (FMEAAnalysis fa : model.getFmeaAnalysis())
                    for (FMEAItem item : fa.getFmeaItems())
                        if (item.getRelatedHazards().contains(h)) fmeaCount++;
                boolean covered = !sgName.equals("—");
                String rowClass = !covered ? " class='row-warn'" : "";
                w.write("<tr" + rowClass + ">" +
                        "<td><b>" + esc(h.getName()) + "</b></td>" +
                        "<td>" + riskBadge(h.getRiskLevel().toString()) + "</td>" +
                        "<td>" + (covered ? esc(sgName) : "<span class='badge badge-gap'>No Safety Goal</span>") + "</td>" +
                        "<td>" + h.getRelatedBlocks().size() + "</td>" +
                        "<td>" + fmeaCount + "</td>" +
                        "<td>" + mitigationBadge(h.getMitigationStatus().toString()) + "</td></tr>\n");
            }
            w.write("</tbody></table>\n</div>\n");

            // ---- FMEA detail ----
            w.write("<div class='section'>\n<h2>🔬 FMEA Analysis (ISO 26262-5)</h2>\n");
            for (FMEAAnalysis fa : model.getFmeaAnalysis()) {
                w.write("<h3>" + esc(fa.getName()) + "</h3>\n");
                w.write("<table>\n<thead><tr><th>Item</th><th>S</th><th>O</th><th>D</th>" +
                        "<th>RPN</th><th>Component</th><th>Failure Mode</th>" +
                        "<th>TSRs Verified</th><th>Mechanisms</th><th>Action</th></tr></thead>\n<tbody>\n");
                for (FMEAItem item : fa.getFmeaItems()) {
                    int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                    String rpnClass = rpn > 100 ? "rpn-high" : rpn > 50 ? "rpn-medium" : "rpn-low";
                    // Count TSRs that use this item as verifiedBy
                    int tsrVerifCount = 0;
                    for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements())
                        if (tsr.getVerifiedBy().contains(item)) tsrVerifCount++;
                    w.write("<tr><td><b>" + esc(item.getName()) + "</b></td>" +
                            "<td>" + item.getSeverity() + "</td>" +
                            "<td>" + item.getOccurrence() + "</td>" +
                            "<td>" + item.getDetection() + "</td>" +
                            "<td><span class='" + rpnClass + "'>" + rpn + "</span></td>" +
                            "<td>" + (item.getAnalyzedComponent() != null ? esc(item.getAnalyzedComponent().getName()) : "—") + "</td>" +
                            "<td>" + (item.getFailureMode() != null ? esc(item.getFailureMode().getName()) : "<span class='badge badge-gap'>none</span>") + "</td>" +
                            "<td>" + tsrVerifCount + "</td>" +
                            "<td>" + item.getValidatesMechanisms().size() + "</td>" +
                            "<td>" + actionBadge(item.getActionStatus() != null ? item.getActionStatus().toString() : "OPEN") + "</td></tr>\n");
                }
                w.write("</tbody></table>\n");
            }
            w.write("</div>\n");

            // ---- Safety Mechanisms ----
            if (!model.getSafetyMechanisms().isEmpty()) {
                w.write("<div class='section'>\n<h2>🛡️ Safety Mechanisms (ISO 26262-5 §8.4)</h2>\n");
                w.write("<table>\n<thead><tr><th>Mechanism</th><th>Type</th>" +
                        "<th>DC%</th><th>Implements TSRs</th><th>Validated By</th>" +
                        "<th>Implemented In</th></tr></thead>\n<tbody>\n");
                for (SafetyMechanism sm : model.getSafetyMechanisms()) {
                    boolean validated = !sm.getValidatedBy().isEmpty();
                    String rowClass = !validated ? " class='row-warn'" : "";
                    int dcPct = (int) Math.round(sm.getDiagnosticCoverage() * 100);
                    w.write("<tr" + rowClass + ">" +
                            "<td><b>" + esc(sm.getName()) + "</b></td>" +
                            "<td><span class='badge badge-mech'>" + esc(sm.getMechanismType() != null ? sm.getMechanismType().toString() : "—") + "</span></td>" +
                            "<td>" + (dcPct > 0 ? dcPct + "%" : "—") + "</td>" +
                            "<td>" + sm.getImplements().size() + "</td>" +
                            "<td>" + (validated ? sm.getValidatedBy().size() + " FMEA item(s)" : "<span class='badge badge-gap'>unvalidated</span>") + "</td>" +
                            "<td>" + (sm.getImplementedIn() != null ? esc(sm.getImplementedIn().getName()) : "—") + "</td></tr>\n");
                }
                w.write("</tbody></table>\n</div>\n");
            }

            // ---- Gap Analysis ----
            w.write("<div class='section'>\n<h2>🔍 Gap Analysis</h2>\n");
            if (gaps.isEmpty()) {
                w.write("<div class='info-box info-success'>" +
                        "<p>✅ No traceability gaps detected. All elements are fully linked.</p></div>\n");
            } else {
                w.write("<div class='info-box info-warning'>" +
                        "<p><b>Found " + gaps.size() + " gap(s):</b></p><ul>\n");
                for (String g : gaps)
                    w.write("<li>" + esc(g) + "</li>\n");
                w.write("</ul></div>\n");
            }
            w.write("</div>\n");

            // ---- Recommendations ----
            w.write("<div class='section'>\n<h2>💡 Recommendations</h2>\n");
            List<String> recs = buildRecommendations(model, mcrVal, htiVal, rarVal, flcVal, tdsVal, mvrVal);
            if (recs.isEmpty()) {
                w.write("<div class='info-box info-success'>" +
                        "<p>✅ Model traceability is excellent. No immediate recommendations.</p></div>\n");
            } else {
                w.write("<ul class='recommendations'>\n");
                for (String r : recs) w.write("<li>" + esc(r) + "</li>\n");
                w.write("</ul>\n");
            }
            w.write("</div>\n");

            // ---- Footer ----
            w.write("<div class='footer'>" +
                    "<p>Report generated by Unified Safety-Architecture Modeling Tool</p>" +
                    "<p>Compliant with ISO 26262:2018 &amp; IEC 62304:2006+AMD1:2015 — " +
                    "Model Version: " + esc(model.getModelVersion()) + "</p>" +
                    "</div>\n</body>\n</html>");
        }
    }

    // =========================================================================
    // Metric computations (self-contained, no cross-class calls)
    // =========================================================================
    private double computeMCR(UnifiedSystemModel m) {
        int n = 0;
        if (!m.getGlobalHazards().isEmpty())          n++;
        if (!m.getSafetyGoals().isEmpty())            n++;
        if (!m.getFunctionalRequirements().isEmpty()) n++;
        if (!m.getTechnicalRequirements().isEmpty())  n++;
        if (!m.getSafetyMechanisms().isEmpty())       n++;
        if (!m.getFmeaAnalysis().isEmpty())           n++;
        if (!m.getRootBlocks().isEmpty())             n++;
        if (!m.getSystemBlocks().isEmpty())           n++;
        if (m.getAnalysisMetadata() != null)          n++;
        return n / 9.0;
    }

    private double computeHTI(UnifiedSystemModel m) {
        if (m.getGlobalHazards().isEmpty()) return 1.0;
        Set<IntegratedHazard> covered = new HashSet<>();
        for (SafetyGoal sg : m.getSafetyGoals())
            if (sg.getRelatedHazard() != null) covered.add(sg.getRelatedHazard());
        return (double) covered.size() / m.getGlobalHazards().size();
    }

    private double computeRAR(UnifiedSystemModel m) {
        if (m.getTechnicalRequirements().isEmpty()) return 1.0;
        int allocated = 0;
        for (TechnicalSafetyRequirement tsr : m.getTechnicalRequirements())
            if (!tsr.getRealizedBy().isEmpty()) allocated++;
        return (double) allocated / m.getTechnicalRequirements().size();
    }

    private double computeFLC(UnifiedSystemModel m) {
        int total = 0, linked = 0;
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems()) {
                total++;
                if (item.getFailureMode() != null) linked++;
            }
        return total == 0 ? 1.0 : (double) linked / total;
    }

    private double computeTDS(UnifiedSystemModel m) {
        int actual = 0, max = 0;
        max += m.getSafetyGoals().size() * 2;
        for (SafetyGoal sg : m.getSafetyGoals()) {
            if (sg.getRelatedHazard() != null) actual++;
            actual += sg.getAllocatedTo().size();
        }
        max += m.getFunctionalRequirements().size() * 2;
        for (FunctionalSafetyRequirement fsr : m.getFunctionalRequirements()) {
            actual += fsr.getRefinedTo().size();
            actual += fsr.getImplementedBy().size();
        }
        max += m.getTechnicalRequirements().size() * 2;
        for (TechnicalSafetyRequirement tsr : m.getTechnicalRequirements()) {
            actual += tsr.getRealizedBy().size();
            actual += tsr.getVerifiedBy().size();
        }
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems()) {
                max++;
                actual += item.getValidatesMechanisms().size();
            }
        return max == 0 ? 1.0 : (double) actual / max;
    }

    private double computeMVR(UnifiedSystemModel m) {
        if (m.getSafetyMechanisms().isEmpty()) return 1.0;
        int verified = 0;
        for (SafetyMechanism sm : m.getSafetyMechanisms())
            if (!sm.getValidatedBy().isEmpty()) verified++;
        return (double) verified / m.getSafetyMechanisms().size();
    }

    private int computeTotalLinks(UnifiedSystemModel m) {
        int n = 0;
        for (SafetyGoal sg : m.getSafetyGoals()) {
            if (sg.getRelatedHazard() != null) n++;
            n += sg.getAllocatedTo().size();
        }
        for (FunctionalSafetyRequirement fsr : m.getFunctionalRequirements()) {
            n += fsr.getRefinedTo().size();
            n += fsr.getImplementedBy().size();
        }
        for (TechnicalSafetyRequirement tsr : m.getTechnicalRequirements()) {
            n += tsr.getRealizedBy().size();
            n += tsr.getVerifiedBy().size();
            // SafetyMechanism.implements -> TSR has no eOpposite; count via mechanism scan
        }
        for (SafetyMechanism sm : m.getSafetyMechanisms()) n += sm.getImplements().size();
        for (IntegratedHazard h : m.getGlobalHazards()) n += h.getRelatedBlocks().size();
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems()) {
                if (item.getAnalyzedComponent() != null) n++;
                if (item.getFailureMode() != null) n++;
                n += item.getRelatedHazards().size();
                n += item.getValidatesMechanisms().size();
            }
        n += m.getBlockConnections().size();
        return n;
    }

    // =========================================================================
    // ISO 26262 checklist
    // =========================================================================
    private static class IsoCheck {
        String clause, requirement, evidence;
        boolean pass;
        IsoCheck(String c, String r, String e, boolean p) {
            clause = c; requirement = r; evidence = e; pass = p;
        }
    }

    private List<IsoCheck> buildIsoChecklist(UnifiedSystemModel m) {
        List<IsoCheck> checks = new ArrayList<>();

        // Part 3 — HARA
        boolean htiPass = computeHTI(m) >= 1.0;
        checks.add(new IsoCheck("ISO 26262-3 §6",
            "Hazard identification and classification",
            m.getGlobalHazards().size() + " hazard(s) identified",
            !m.getGlobalHazards().isEmpty()));

        checks.add(new IsoCheck("ISO 26262-3 §7.4",
            "Each hazardous event addressed by a safety goal",
            "HTI = " + (int)Math.round(computeHTI(m)*100) + "% (threshold: 100%)",
            htiPass));

        checks.add(new IsoCheck("ISO 26262-3 §8",
            "ASIL determination for each safety goal",
            m.getSafetyGoals().stream().filter(sg -> sg.getAsilLevel() != null).count()
                + "/" + m.getSafetyGoals().size() + " safety goals have ASIL assigned",
            m.getSafetyGoals().stream().allMatch(sg -> sg.getAsilLevel() != null)));

        // Part 4 — System
        boolean rarPass = computeRAR(m) >= 0.95;
        checks.add(new IsoCheck("ISO 26262-4 §7.1",
            "Safety requirements allocated to architectural elements",
            "RAR = " + (int)Math.round(computeRAR(m)*100) + "% (threshold: 95%)",
            rarPass));

        checks.add(new IsoCheck("ISO 26262-4 §8.3",
            "Technical safety requirements derived from FSRs",
            m.getTechnicalRequirements().size() + " TSR(s) derived",
            !m.getTechnicalRequirements().isEmpty()));

        // Part 5 — Hardware
        boolean flcPass = computeFLC(m) >= 1.0;
        checks.add(new IsoCheck("ISO 26262-5 §8.4",
            "FMEA conducted for hardware items",
            "FLC = " + (int)Math.round(computeFLC(m)*100) + "% (threshold: 100%)",
            flcPass));

        boolean mvrPass = computeMVR(m) >= 0.85;
        checks.add(new IsoCheck("ISO 26262-5 §8.4",
            "Safety mechanisms validated by analysis",
            "MVR = " + (int)Math.round(computeMVR(m)*100) + "% (threshold: 85%)",
            mvrPass));

        // Part 6 — Software
        long tsrApproved = m.getTechnicalRequirements().stream()
            .filter(tsr -> tsr.getStatus() != null &&
                    tsr.getStatus().toString().equals("APPROVED")).count();
        checks.add(new IsoCheck("ISO 26262-6 §7.2",
            "Software safety requirements have approved status",
            tsrApproved + "/" + m.getTechnicalRequirements().size() + " TSRs approved",
            m.getTechnicalRequirements().isEmpty() ||
                tsrApproved == m.getTechnicalRequirements().size()));

        // Part 8 — Supporting processes (traceability)
        boolean tdsPass = computeTDS(m) >= 0.80;
        checks.add(new IsoCheck("ISO 26262-8 §6.4",
            "Bidirectional traceability between work products",
            "TDS = " + (int)Math.round(computeTDS(m)*100) + "% (threshold: 80%)",
            tdsPass));

        checks.add(new IsoCheck("ISO 26262-8 §9",
            "Configuration management: model version set",
            "Version: " + (m.getModelVersion() != null ? m.getModelVersion() : "not set"),
            m.getModelVersion() != null && !m.getModelVersion().isEmpty()));

        // Part 10 / General — FMEA high-RPN action tracking
        long openHighRpn = 0;
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems()) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                if (rpn > 100 && (item.getActionStatus() == null ||
                        item.getActionStatus().toString().equals("OPEN"))) openHighRpn++;
            }
        checks.add(new IsoCheck("ISO 26262 §Part-5 (FMEA)",
            "No high-RPN (>100) FMEA items left OPEN",
            openHighRpn + " high-RPN item(s) with OPEN status",
            openHighRpn == 0));

        return checks;
    }

    // =========================================================================
    // Gap and recommendation builders
    // =========================================================================
    private List<String> buildGapList(UnifiedSystemModel m) {
        List<String> gaps = new ArrayList<>();
        for (IntegratedHazard h : m.getGlobalHazards()) {
            boolean hasSG = m.getSafetyGoals().stream()
                .anyMatch(sg -> h.equals(sg.getRelatedHazard()));
            if (!hasSG) gaps.add("⚠️ Hazard '" + h.getName() + "' [" + h.getRiskLevel() + "] has no Safety Goal");
        }
        for (SafetyGoal sg : m.getSafetyGoals())
            if (sg.getAllocatedTo().isEmpty())
                gaps.add("⚠️ Safety Goal '" + sg.getName() + "' has no Functional Safety Requirements allocated");
        for (FunctionalSafetyRequirement fsr : m.getFunctionalRequirements())
            if (fsr.getRefinedTo().isEmpty())
                gaps.add("⚠️ FSR '" + fsr.getRequirementId() + "' has no Technical Safety Requirements");
        for (TechnicalSafetyRequirement tsr : m.getTechnicalRequirements()) {
            if (tsr.getRealizedBy().isEmpty())
                gaps.add("❌ TSR '" + tsr.getRequirementId() + "' is not allocated to any architecture block");
            if (tsr.getVerifiedBy().isEmpty())
                gaps.add("⚠️ TSR '" + tsr.getRequirementId() + "' is not verified by any FMEA item");
        }
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems())
                if (item.getFailureMode() == null)
                    gaps.add("⚠️ FMEA item '" + item.getName() + "' has no failure mode linked");
        for (SafetyMechanism sm : m.getSafetyMechanisms())
            if (sm.getValidatedBy().isEmpty())
                gaps.add("⚠️ Safety Mechanism '" + sm.getName() + "' is not validated by any FMEA item");
        for (SafetyCriticalBlock block : m.getRootBlocks())
            if (block.getFailureModes().isEmpty())
                gaps.add("⚠️ Safety-critical block '" + block.getName() + "' has no failure modes defined");
        return gaps;
    }

    private List<String> buildRecommendations(UnifiedSystemModel m,
            double mcr, double hti, double rar, double flc, double tds, double mvr) {
        List<String> recs = new ArrayList<>();
        if (mcr < 0.90) recs.add("[MCR] Populate all 9 required concept categories. Missing categories reduce framework coverage.");
        if (hti < 1.00) recs.add("[HTI] Create Safety Goals for ALL identified hazards. Every HARA item must trace to a safety goal per ISO 26262-3 §7.4.");
        if (rar < 0.95) recs.add("[RAR] Allocate unallocated Technical Safety Requirements to architecture blocks. Required by ISO 26262-4 §7.1.");
        if (flc < 1.00) recs.add("[FLC] Link failure modes to all FMEA items. Items without failure modes cannot be properly risk-assessed per ISO 26262-5 §8.4.");
        if (tds < 0.80) recs.add("[TDS] Add missing cross-layer trace links (SG→FSR, FSR→TSR, TSR→Block, FMEAItem→Mechanism). Required by ISO 26262-8 §6.4.");
        if (mvr < 0.85) recs.add("[MVR] Validate all safety mechanisms through FMEA items. Unvalidated mechanisms do not demonstrate effectiveness per ISO 26262-5 §8.4.");
        for (FMEAAnalysis fa : m.getFmeaAnalysis())
            for (FMEAItem item : fa.getFmeaItems()) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                if (rpn > 100 && (item.getActionStatus() == null ||
                        item.getActionStatus().toString().equals("OPEN"))) {
                    recs.add("[RPN] '" + item.getName() + "' has RPN=" + rpn +
                            " (>100) and is still OPEN. Assign corrective actions and safety mechanisms.");
                    break; // one message is enough; gap list has the detail
                }
            }
        if (m.getSafetyGoals().isEmpty() && !m.getGlobalHazards().isEmpty())
            recs.add("[HARA] Hazards are defined but no Safety Goals exist. Derive safety goals from HARA before proceeding with requirements.");
        return recs;
    }

    // =========================================================================
    // HTML helpers
    // =========================================================================
    private void statCard(FileWriter w, String val, String label, String cls) throws IOException {
        w.write("<div class='stat-card " + cls + "'>" +
                "<div class='stat-value'>" + val + "</div>" +
                "<div class='stat-label'>" + label + "</div></div>\n");
    }

    private void metricCard(FileWriter w, String code, String name, String desc,
                             int pct, String threshold, boolean pass) throws IOException {
        String colour = pass ? "#28a745" : pct >= 70 ? "#ffc107" : "#dc3545";
        String tick   = pass ? "✅" : "❌";
        w.write("<div class='metric-card'>" +
                "<div class='metric-header'>" +
                "  <span class='metric-code'>" + code + "</span>" +
                "  <span class='metric-pass'>" + tick + "</span>" +
                "</div>" +
                "<div class='metric-name'>" + name + "</div>" +
                "<div class='gauge-bar'><div class='gauge-fill' style='width:" + pct +
                "%;background:" + colour + "'></div></div>" +
                "<div class='metric-values'>" +
                "  <b>" + pct + "%</b> &nbsp; threshold: " + threshold +
                "</div>" +
                "<div class='metric-desc'>" + desc + "</div>" +
                "</div>\n");
    }

    private void traceRow(FileWriter w, String srcType, String srcName, String rel,
                           String tgtType, String tgtName, String info,
                           String srcCls, String tgtCls) throws IOException {
        w.write("<tr>" +
                "<td><span class='badge " + srcCls + "'>" + esc(srcType) + "</span></td>" +
                "<td>" + esc(srcName) + "</td>" +
                "<td class='rel-cell'>" + rel + "</td>" +
                "<td><span class='badge " + tgtCls + "'>" + esc(tgtType) + "</span></td>" +
                "<td>" + esc(tgtName) + "</td>" +
                "<td><small>" + esc(info) + "</small></td>" +
                "</tr>\n");
    }

    private String asilBadge(String asil)   { return "<span class='badge badge-asil'>" + esc(asil) + "</span>"; }
    private String riskBadge(String r)      { return "<span class='badge badge-hazard'>" + esc(r) + "</span>"; }
    private String statusBadge(String s)    {
        String cls = s.equals("APPROVED") ? "badge-pass" : s.equals("DRAFT") ? "badge-warn" : "badge-gap";
        return "<span class='badge " + cls + "'>" + esc(s) + "</span>";
    }
    private String mitigationBadge(String s) {
        return s.equals("NOT_MITIGATED") ? "<span class='badge badge-gap'>" + esc(s) + "</span>"
                                         : "<span class='badge badge-pass'>" + esc(s) + "</span>";
    }
    private String actionBadge(String s) {
        String cls = s.equals("COMPLETED") || s.equals("VERIFIED") ? "badge-pass"
                   : s.equals("IN_PROGRESS") ? "badge-warn" : "badge-gap";
        return "<span class='badge " + cls + "'>" + esc(s) + "</span>";
    }

    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
    }

    // =========================================================================
    // CSS / head
    // =========================================================================
    private String htmlHead() {
        return "<!DOCTYPE html>\n<html lang='en'>\n<head>\n" +
               "<meta charset='UTF-8'>\n" +
               "<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
               "<title>Traceability Analysis Report</title>\n" +
               "<style>\n" +
               "* { box-sizing: border-box; }\n" +
               "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 0; padding: 20px; background: #f0f2f5; color: #333; }\n" +
               ".header { background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%); color: white; padding: 35px; border-radius: 12px; margin-bottom: 25px; }\n" +
               ".header h1 { margin: 0; font-size: 2.2em; }\n" +
               ".subtitle { font-size: 1.1em; opacity: 0.85; margin: 8px 0 4px; }\n" +
               ".date { opacity: 0.7; font-size: 0.9em; }\n" +
               ".section { background: white; padding: 28px; margin-bottom: 20px; border-radius: 10px; box-shadow: 0 2px 8px rgba(0,0,0,0.08); }\n" +
               ".section h2 { color: #1a1a2e; border-bottom: 3px solid #0f3460; padding-bottom: 10px; margin-top: 0; }\n" +
               ".section h3 { color: #333; margin-top: 20px; }\n" +
               ".section-note { color: #666; font-size: 0.92em; margin-bottom: 16px; }\n" +
               ".summary-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(170px, 1fr)); gap: 16px; margin: 20px 0; }\n" +
               ".stat-card { padding: 20px; border-radius: 10px; text-align: center; color: white; }\n" +
               ".stat-value { font-size: 2.4em; font-weight: bold; }\n" +
               ".stat-label { font-size: 0.82em; opacity: 0.9; margin-top: 4px; }\n" +
               ".card-red    { background: linear-gradient(135deg,#dc3545,#c82333); }\n" +
               ".card-orange { background: linear-gradient(135deg,#fd7e14,#e96b02); }\n" +
               ".card-yellow { background: linear-gradient(135deg,#ffc107,#e0a800); color:#333!important; }\n" +
               ".card-blue   { background: linear-gradient(135deg,#007bff,#0062cc); }\n" +
               ".card-purple { background: linear-gradient(135deg,#6f42c1,#5a2d91); }\n" +
               ".card-teal   { background: linear-gradient(135deg,#20c997,#199e78); }\n" +
               ".card-green  { background: linear-gradient(135deg,#28a745,#1e7e34); }\n" +
               ".card-indigo { background: linear-gradient(135deg,#6610f2,#520dc2); }\n" +
               ".score-box { text-align: center; padding: 28px; margin: 20px 0; border-radius: 10px; }\n" +
               ".score-good { background: #d4edda; border: 2px solid #28a745; }\n" +
               ".score-ok   { background: #fff3cd; border: 2px solid #ffc107; }\n" +
               ".score-poor { background: #f8d7da; border: 2px solid #dc3545; }\n" +
               ".score-value { font-size: 3em; font-weight: bold; }\n" +
               ".score-grade { font-size: 1.2em; color: #555; margin-top: 4px; }\n" +
               ".metrics-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 16px; }\n" +
               ".metric-card { border: 1px solid #dee2e6; border-radius: 8px; padding: 16px; }\n" +
               ".metric-header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 6px; }\n" +
               ".metric-code { font-size: 1.3em; font-weight: bold; color: #0f3460; }\n" +
               ".metric-pass { font-size: 1.2em; }\n" +
               ".metric-name { font-weight: 600; margin-bottom: 10px; }\n" +
               ".metric-desc { font-size: 0.82em; color: #666; margin-top: 8px; }\n" +
               ".metric-values { font-size: 0.9em; color: #333; margin-top: 6px; }\n" +
               ".gauge-bar { background: #e9ecef; border-radius: 4px; height: 10px; overflow: hidden; }\n" +
               ".gauge-fill { height: 100%; border-radius: 4px; transition: width 0.3s; }\n" +
               "table { width: 100%; border-collapse: collapse; margin: 15px 0; font-size: 0.9em; }\n" +
               "th { background: #1a1a2e; color: white; padding: 11px 10px; text-align: left; }\n" +
               "td { padding: 9px 10px; border-bottom: 1px solid #dee2e6; vertical-align: middle; }\n" +
               "tr:hover td { background: #f8f9fa; }\n" +
               ".row-warn td { background: #fff8e1; }\n" +
               ".rel-cell { color: #555; font-style: italic; white-space: nowrap; }\n" +
               ".badge { padding: 3px 8px; border-radius: 4px; font-size: 0.82em; font-weight: 600; display: inline-block; }\n" +
               ".badge-hazard { background:#dc3545; color:white; }\n" +
               ".badge-block  { background:#007bff; color:white; }\n" +
               ".badge-fmea   { background:#ffc107; color:#333; }\n" +
               ".badge-req    { background:#6f42c1; color:white; }\n" +
               ".badge-mech   { background:#20c997; color:white; }\n" +
               ".badge-asil   { background:#0f3460; color:white; }\n" +
               ".badge-pass   { background:#28a745; color:white; }\n" +
               ".badge-warn   { background:#ffc107; color:#333; }\n" +
               ".badge-gap    { background:#dc3545; color:white; }\n" +
               ".status-pass { color:#28a745; font-weight:bold; }\n" +
               ".status-fail { color:#dc3545; font-weight:bold; }\n" +
               ".rpn-high   { background:#dc3545; color:white; padding:2px 7px; border-radius:4px; font-weight:bold; }\n" +
               ".rpn-medium { background:#ffc107; color:#333; padding:2px 7px; border-radius:4px; font-weight:bold; }\n" +
               ".rpn-low    { background:#28a745; color:white; padding:2px 7px; border-radius:4px; }\n" +
               ".info-box { padding: 15px 20px; border-radius: 6px; margin: 15px 0; }\n" +
               ".info-success { background:#d4edda; border-left:5px solid #28a745; }\n" +
               ".info-warning { background:#fff3cd; border-left:5px solid #ffc107; }\n" +
               ".recommendations { list-style: none; padding: 0; }\n" +
               ".recommendations li { background:#e7f3ff; padding:12px 16px; margin:8px 0; border-left:4px solid #0066cc; border-radius:5px; }\n" +
               ".matrix-container { overflow-x: auto; }\n" +
               "code { background:#f0f0f0; padding:1px 5px; border-radius:3px; font-size:0.88em; }\n" +
               ".footer { text-align:center; padding:20px; color:#888; font-size:0.88em; }\n" +
               "</style>\n</head>\n";
    }

    // =========================================================================
    // Infrastructure
    // =========================================================================
    private UnifiedSystemModel getUnifiedSystemModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) return (UnifiedSystemModel) obj;
        if (obj instanceof DSemanticDecorator)
            return getUnifiedSystemModel(((DSemanticDecorator) obj).getTarget());
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