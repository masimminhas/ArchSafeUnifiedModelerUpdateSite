package edu.kit.sdq.dsis.unified.design.services;


import java.util.List;
import java.util.stream.Collectors;

import unified.AnalysisMetadata;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.FunctionalSafetyRequirement;
import unified.IntegratedHazard;
import unified.SafetyGoal;
import unified.SafetyMechanism;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedSystemModel;

/**
 * AQL-callable Java service class for the Unified Safety Modeling Framework.
 *
 * All public methods whose first parameter is an EMF type are automatically
 * discoverable by the Sirius AQL engine after this class is registered in
 * unified.odesign as an <ownedJavaExtensions> entry.
 *
 * Threshold constants match the GQM plan thresholds defined in the
 * Empirical Validation Plan document.
 */
public class MetricsService {

    // ── Threshold constants (from GQM plan) ─────────────────────────────────
    private static final double THRESHOLD_MCR = 0.90;
    private static final double THRESHOLD_HTI = 1.00;
    private static final double THRESHOLD_RAR = 0.95;
    private static final double THRESHOLD_FLC = 1.00;
    private static final double THRESHOLD_TDS = 0.80;
    private static final double THRESHOLD_MVR = 0.85;

    // Number of required concept categories for MCR denominator.
    // Must match the 9 concept types enumerated in the validation plan:
    // globalHazards, safetyGoals, functionalRequirements, technicalRequirements,
    // safetyMechanisms, fmeaAnalysis, rootBlocks, systemBlocks, analysisMetadata
    private static final int MCR_REQUIRED_CONCEPTS = 9;

    // ════════════════════════════════════════════════════════════════════════
    // 1.  MCR — Metamodel Coverage Ratio
    //
    //     Definition: Checks whether all 9 required concept categories are
    //     populated in this model instance. Each category present = 1 point.
    //     MCR = points_earned / MCR_REQUIRED_CONCEPTS
    //
    //     AQL call in odesign:  aql:self.computeMCR()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeMCR(UnifiedSystemModel model) {
        int present = 0;

        if (!model.getGlobalHazards().isEmpty())           present++; // IntegratedHazard
        if (!model.getSafetyGoals().isEmpty())             present++; // SafetyGoal
        if (!model.getFunctionalRequirements().isEmpty())  present++; // FunctionalSafetyRequirement
        if (!model.getTechnicalRequirements().isEmpty())   present++; // TechnicalSafetyRequirement
        if (!model.getSafetyMechanisms().isEmpty())        present++; // SafetyMechanism
        if (!model.getFmeaAnalysis().isEmpty())            present++; // FMEAAnalysis
        if (!model.getRootBlocks().isEmpty())              present++; // SafetyCriticalBlock
        if (!model.getSystemBlocks().isEmpty())            present++; // SystemBlock
        if (model.getAnalysisMetadata() != null)           present++; // AnalysisMetadata

        return (double) present / MCR_REQUIRED_CONCEPTS;
    }

    /** Display label for MCR column in MetricsDashboard table. */
    public String mcrLabel(UnifiedSystemModel model) {
        double v = computeMCR(model);
        return formatMetric("MCR", v, THRESHOLD_MCR, true);
    }

    // ════════════════════════════════════════════════════════════════════════
    // 2.  HTI — Hazard Traceability Index
    //
    //     Definition: Fraction of globalHazards that have at least one
    //     SafetyGoal pointing to them via SafetyGoal.relatedHazard.
    //     HTI = covered_hazards / total_hazards
    //
    //     AQL call in odesign:  aql:self.computeHTI()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeHTI(UnifiedSystemModel model) {
        List<IntegratedHazard> allHazards = model.getGlobalHazards();
        if (allHazards.isEmpty()) return 1.0; // vacuously true when no hazards exist

        // Collect all hazards that are referenced by at least one SafetyGoal
        List<IntegratedHazard> coveredHazards = model.getSafetyGoals().stream()
            .filter(sg -> sg.getRelatedHazard() != null)
            .map(SafetyGoal::getRelatedHazard)
            .distinct()
            .collect(Collectors.toList());

        return (double) coveredHazards.size() / allHazards.size();
    }

    /** Display label for HTI column in MetricsDashboard table. */
    public String htiLabel(UnifiedSystemModel model) {
        double v = computeHTI(model);
        return formatMetric("HTI", v, THRESHOLD_HTI, true);
    }

    /**
     * Per-hazard helper: returns true if this IntegratedHazard is referenced
     * by at least one SafetyGoal in the model.
     *
     * AQL call in odesign:  aql:self.hazardHasSafetyGoal()
     * self type:            IntegratedHazard
     *
     * Used in the MD_HazardLine section of the MetricsDashboard table to
     * show per-hazard coverage status.
     */
    public boolean hazardHasSafetyGoal(IntegratedHazard hazard) {
        // Navigate to the model root via eContainer chain
        org.eclipse.emf.ecore.EObject container = hazard.eContainer();
        while (container != null && !(container instanceof UnifiedSystemModel)) {
            container = container.eContainer();
        }
        if (!(container instanceof UnifiedSystemModel)) return false;

        UnifiedSystemModel model = (UnifiedSystemModel) container;
        return model.getSafetyGoals().stream()
            .anyMatch(sg -> sg.getRelatedHazard() == hazard);
    }

    /**
     * Per-hazard helper: returns true if this IntegratedHazard is referenced
     * by at least one FMEAItem via FMEAItem.relatedHazards.
     *
     * AQL call in odesign:  aql:self.hazardHasFMEAItem()
     * self type:            IntegratedHazard
     */
    public boolean hazardHasFMEAItem(IntegratedHazard hazard) {
        org.eclipse.emf.ecore.EObject container = hazard.eContainer();
        while (container != null && !(container instanceof UnifiedSystemModel)) {
            container = container.eContainer();
        }
        if (!(container instanceof UnifiedSystemModel)) return false;

        UnifiedSystemModel model = (UnifiedSystemModel) container;
        return model.getFmeaAnalysis().stream()
            .flatMap(fmea -> fmea.getFmeaItems().stream())
            .anyMatch(item -> item.getRelatedHazards().contains(hazard));
    }

    // ════════════════════════════════════════════════════════════════════════
    // 3.  RAR — Requirement Allocation Ratio
    //
    //     Definition: Fraction of TechnicalSafetyRequirements that have at
    //     least one entry in their realizedBy reference list.
    //     RAR = allocated_TSRs / total_TSRs
    //
    //     AQL call in odesign:  aql:self.computeRAR()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeRAR(UnifiedSystemModel model) {
        List<TechnicalSafetyRequirement> allTSR = model.getTechnicalRequirements();
        if (allTSR.isEmpty()) return 1.0;

        long allocated = allTSR.stream()
            .filter(tsr -> !tsr.getRealizedBy().isEmpty())
            .count();

        return (double) allocated / allTSR.size();
    }

    /** Display label for RAR column. */
    public String rarLabel(UnifiedSystemModel model) {
        double v = computeRAR(model);
        return formatMetric("RAR", v, THRESHOLD_RAR, true);
    }

    // ════════════════════════════════════════════════════════════════════════
    // 4.  FLC — FMEA Linkage Completeness
    //
    //     Definition: Fraction of FMEAItems that have a non-null failureMode
    //     reference pointing to a BlockFailureMode.
    //     FLC = linked_items / total_items
    //
    //     AQL call in odesign:  aql:self.computeFLC()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeFLC(UnifiedSystemModel model) {
        List<FMEAItem> allItems = model.getFmeaAnalysis().stream()
            .flatMap(fmea -> fmea.getFmeaItems().stream())
            .collect(Collectors.toList());

        if (allItems.isEmpty()) return 1.0;

        long linked = allItems.stream()
            .filter(item -> item.getFailureMode() != null)
            .count();

        return (double) linked / allItems.size();
    }

    /** Display label for FLC column. */
    public String flcLabel(UnifiedSystemModel model) {
        double v = computeFLC(model);
        return formatMetric("FLC", v, THRESHOLD_FLC, true);
    }

    // ════════════════════════════════════════════════════════════════════════
    // 5.  TDS — Traceability Density Score
    //
    //     Definition: the fraction of the EXPECTED cross-layer trace relations
    //     that are populated. Each element contributes one unit per relation it
    //     is expected to carry, and that unit is earned when the relation holds
    //     at least one link.
    //
    //     Expected relations (one unit each):
    //       SafetyGoal.relatedHazard                  (L1→L2)
    //       SafetyGoal.allocatedTo                    (L2→L3)
    //       FunctionalReq.refinedTo                   (L3→L4)
    //       FunctionalReq.implementedBy               (L3→arch)
    //       TechnicalReq.realizedBy                   (L4→arch)
    //       TechnicalReq.verifiedBy                   (L4→L5)
    //       FMEAItem.validatesMechanisms              (L5→L6)
    //
    //     NOTE: an earlier version divided the NUMBER OF LINKS by a flat slot
    //     count (2 per SG/FSR/TSR, 1 per item). Because refinedTo,
    //     implementedBy, realizedBy and validatesMechanisms are multi-valued,
    //     the numerator counted link multiplicities while the denominator
    //     counted relation slots, so a richly linked model could exceed 1.0
    //     (the AEB case study reached 45/34 = 1.32). Counting populated
    //     relations instead keeps the numerator <= the denominator by
    //     construction, so the result is a genuine ratio in [0,1].
    //
    //     AQL call in odesign:  aql:self.computeTDS()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeTDS(UnifiedSystemModel model) {
        int populated = 0;   // expected relations that carry at least one link
        int expected  = 0;   // expected relations in total

        // Safety goals: hazard reference, and allocation to functional requirements
        for (SafetyGoal sg : model.getSafetyGoals()) {
            expected += 2;
            if (sg.getRelatedHazard() != null)     populated++;
            if (!sg.getAllocatedTo().isEmpty())    populated++;
        }

        // Functional safety requirements: refinement to TSRs, allocation to blocks
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            expected += 2;
            if (!fsr.getRefinedTo().isEmpty())     populated++;
            if (!fsr.getImplementedBy().isEmpty()) populated++;
        }

        // Technical safety requirements: realisation by blocks, verification by FMEA
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            expected += 2;
            if (!tsr.getRealizedBy().isEmpty())    populated++;
            if (!tsr.getVerifiedBy().isEmpty())    populated++;
        }

        // FMEA items: validation of at least one safety mechanism
        for (FMEAAnalysis fmea : model.getFmeaAnalysis()) {
            for (FMEAItem item : fmea.getFmeaItems()) {
                expected += 1;
                if (!item.getValidatesMechanisms().isEmpty()) populated++;
            }
        }

        if (expected == 0) return 1.0;   // vacuously complete
        return (double) populated / expected;   // in [0,1] by construction
    }

    /** Display label for TDS column. */
    public String tdsLabel(UnifiedSystemModel model) {
        double v = computeTDS(model);
        // TDS uses a MONITOR level below threshold rather than hard FAIL
        if (v >= THRESHOLD_TDS) {
            return String.format("TDS = %.2f  ✓ PASS", v);
        } else {
            return String.format("TDS = %.2f  ~ MONITOR", v);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    // 6.  MVR — Mechanism Verification Rate
    //
    //     Definition: Fraction of SafetyMechanisms that have at least one
    //     entry in their validatedBy reference list (pointing to FMEAItems).
    //     MVR = verified_mechanisms / total_mechanisms
    //
    //     AQL call in odesign:  aql:self.computeMVR()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeMVR(UnifiedSystemModel model) {
        List<SafetyMechanism> allMechanisms = model.getSafetyMechanisms();
        if (allMechanisms.isEmpty()) return 1.0;

        long verified = allMechanisms.stream()
            .filter(sm -> !sm.getValidatedBy().isEmpty())
            .count();

        return (double) verified / allMechanisms.size();
    }

    /** Display label for MVR column. */
    public String mvrLabel(UnifiedSystemModel model) {
        double v = computeMVR(model);
        return formatMetric("MVR", v, THRESHOLD_MVR, true);
    }

    // ════════════════════════════════════════════════════════════════════════
    // 7.  OVERALL STATUS — aggregates all six metrics
    //
    //     AQL call in odesign:  aql:self.overallStatusLabel()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public String overallStatusLabel(UnifiedSystemModel model) {
        boolean allPass =
            computeMCR(model) >= THRESHOLD_MCR &&
            computeHTI(model) >= THRESHOLD_HTI &&
            computeRAR(model) >= THRESHOLD_RAR &&
            computeFLC(model) >= THRESHOLD_FLC &&
            computeMVR(model) >= THRESHOLD_MVR;
        // TDS is MONITOR not FAIL so excluded from hard pass/fail
        double tds = computeTDS(model);

        if (allPass && tds >= THRESHOLD_TDS) {
            return "✓ ALL METRICS PASS";
        } else if (allPass) {
            return "~ PASS (TDS needs attention)";
        } else {
            return "✗ METRICS FAILING — see columns";
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    // 7b.  QUALITY METRICS DASHBOARD cell services
    //
    //  The MetricsDashboard table (unified.odesign) calls these with the model
    //  as self and the row's line-mapping name (e.g. 'MD_MCR_Line') so each cell
    //  knows which metric it represents. All thresholds come from the
    //  THRESHOLD_* constants above — change a threshold there and BOTH the
    //  "Threshold" column and the PASS/GAP status update automatically.
    // ════════════════════════════════════════════════════════════════════════

    /** Value cell: the metric as a rounded percentage, e.g. "83%". Empty for the Overall row. */
    public String metricValuePct(UnifiedSystemModel model, String lineMapping) {
        Double v = metricFraction(model, lineMapping);
        return v == null ? "" : pctLabel(v);
    }

    /** Threshold cell: the target for the metric, e.g. ">= 90%" or "= 100%". */
    public String metricThreshold(UnifiedSystemModel model, String lineMapping) {
        switch (metricCode(lineMapping)) {
            case "MCR": return ">= " + pctLabel(THRESHOLD_MCR);
            case "HTI": return "= "  + pctLabel(THRESHOLD_HTI);
            case "RAR": return ">= " + pctLabel(THRESHOLD_RAR);
            case "FLC": return "= "  + pctLabel(THRESHOLD_FLC);
            case "TDS": return ">= " + pctLabel(THRESHOLD_TDS);
            case "MVR": return ">= " + pctLabel(THRESHOLD_MVR);
            default:    return "";
        }
    }

    /** Status cell: "PASS"/"GAP" per metric, or the overall label on the Overall row. */
    public String metricStatus(UnifiedSystemModel model, String lineMapping) {
        if ("OVERALL".equals(metricCode(lineMapping))) return overallStatusLabel(model);
        return metricPass(model, lineMapping) ? "PASS" : "GAP";
    }

    /** True when the metric meets its threshold (drives the green/red status styling). */
    public boolean metricPass(UnifiedSystemModel model, String lineMapping) {
        switch (metricCode(lineMapping)) {
            case "MCR": return computeMCR(model) >= THRESHOLD_MCR;
            case "HTI": return computeHTI(model) >= THRESHOLD_HTI;
            case "RAR": return computeRAR(model) >= THRESHOLD_RAR;
            case "FLC": return computeFLC(model) >= THRESHOLD_FLC;
            case "TDS": return computeTDS(model) >= THRESHOLD_TDS;
            case "MVR": return computeMVR(model) >= THRESHOLD_MVR;
            case "OVERALL": return overallStatusLabel(model).startsWith("✓"); // ✓
            default:    return true;
        }
    }

    private Double metricFraction(UnifiedSystemModel model, String lineMapping) {
        switch (metricCode(lineMapping)) {
            case "MCR": return computeMCR(model);
            case "HTI": return computeHTI(model);
            case "RAR": return computeRAR(model);
            case "FLC": return computeFLC(model);
            case "TDS": return computeTDS(model);
            case "MVR": return computeMVR(model);
            default:    return null; // OVERALL / unknown -> no single value
        }
    }

    /** Maps a line-mapping name like 'MD_MCR_Line' / 'MD_Overall_Line' to 'MCR' / 'OVERALL'. */
    private String metricCode(String lineMapping) {
        if (lineMapping == null) return "";
        String c = lineMapping;
        if (c.startsWith("MD_"))   c = c.substring(3);
        if (c.endsWith("_Line"))   c = c.substring(0, c.length() - 5);
        return c.toUpperCase();
    }

    private String pctLabel(double fraction) {
        return Math.round(fraction * 100) + "%";
    }

    // ════════════════════════════════════════════════════════════════════════
    // 8.  WRITE-BACK — refreshAllMetrics
    //
    //     Computes all metrics and writes them back to the model's
    //     AnalysisMetadata so that:
    //       (a) other diagrams display current scores in tooltips
    //       (b) validation rules that read AnalysisMetadata fields are current
    //       (c) the .unified file can be saved with up-to-date scores
    //
    //     This method is called by RefreshMetricsAction (ExternalJavaAction)
    //     when the user clicks "⟳ Refresh All Metrics" in the table toolbar.
    //
    //     It can also be called directly from AQL if needed:
    //       aql:self.refreshAllMetrics()
    //     but note: AQL calls happen in a read-only transaction by default;
    //     write-back should be done only from an ExternalJavaAction which
    //     opens a write transaction automatically.
    // ════════════════════════════════════════════════════════════════════════
    public UnifiedSystemModel refreshAllMetrics(UnifiedSystemModel model) {
        AnalysisMetadata meta = model.getAnalysisMetadata();
        if (meta == null) return model;

        double tds = computeTDS(model);
        double hti = computeHTI(model);
        double flc = computeFLC(model);
        double mcr = computeMCR(model);
        double rar = computeRAR(model);
        double mvr = computeMVR(model);

        // Write computed values to AnalysisMetadata fields
        // traceabilityDensity maps directly to TDS
        meta.setTraceabilityDensity(tds);

        // hazardCoverage maps to HTI
        meta.setHazardCoverage(hti);

        // fmeaCoverage maps to FLC
        meta.setFmeaCoverage(flc);

        // completenessScore = average of MCR, RAR, MVR (scaled 0-100)
        double compositeCompleteness = (mcr + rar + mvr) / 3.0;
        meta.setCompletenessScore((int) Math.round(compositeCompleteness * 100));

        // consistencyScore = whether TDS and HTI are both above threshold
        int consistency = (tds >= THRESHOLD_TDS && hti >= THRESHOLD_HTI) ? 90 : 60;
        meta.setConsistencyScore(consistency);

        return model;
    }

    // ── Private helper ───────────────────────────────────────────────────────

    /**
     * Formats a metric value as a display string with PASS/FAIL status.
     *
     * @param name       Short metric name (e.g. "HTI")
     * @param value      Computed value (0.0 – 1.0)
     * @param threshold  Minimum passing value
     * @param higherIsBetter  true for all current metrics (higher = better)
     * @return Display string for the table cell
     */
    private String formatMetric(String name, double value,
                                double threshold, boolean higherIsBetter) {
        boolean passes = higherIsBetter
            ? value >= threshold
            : value <= threshold;

        String status = passes ? "✓ PASS" : "✗ FAIL";
        return String.format("%s = %.2f  %s", name, value, status);
    }
}