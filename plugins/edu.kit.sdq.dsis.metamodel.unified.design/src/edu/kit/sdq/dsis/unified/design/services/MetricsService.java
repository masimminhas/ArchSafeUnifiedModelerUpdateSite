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
    //     Definition: Counts actual cross-layer reference edges across 6
    //     traceability layers and divides by the theoretical maximum.
    //
    //     Layers and counted references:
    //       L1→L2: SafetyGoal.relatedHazard           (1 per SG)
    //       L2→L3: SafetyGoal.allocatedTo             (N per SG)
    //       L3→L4: FunctionalReq.refinedTo            (N per FSR)
    //       L3→L4: FunctionalReq.implementedBy        (N per FSR)
    //       L4→L5: TechnicalReq.realizedBy            (N per TSR)
    //       L4→L5: TechnicalReq.verifiedBy            (N per TSR)
    //       L5→L6: FMEAItem.validatesMechanisms       (N per item)
    //
    //     Theoretical max = 2 per SG + 2 per FSR + 2 per TSR + 1 per item
    //     Result is capped at 1.0 to handle over-linking.
    //
    //     AQL call in odesign:  aql:self.computeTDS()
    //     self type:            UnifiedSystemModel
    // ════════════════════════════════════════════════════════════════════════
    public double computeTDS(UnifiedSystemModel model) {
        int actualLinks    = 0;
        int theoreticalMax = 0;

        // Safety Goals: 2 possible links each (hazard ref + FSR allocations)
        for (SafetyGoal sg : model.getSafetyGoals()) {
            if (sg.getRelatedHazard() != null) actualLinks++;
            actualLinks += sg.getAllocatedTo().size();
            theoreticalMax += 2;
        }

        // Functional requirements: 2 possible links each (refinedTo + implementedBy)
        for (FunctionalSafetyRequirement fsr : model.getFunctionalRequirements()) {
            actualLinks += fsr.getRefinedTo().size();
            actualLinks += fsr.getImplementedBy().size();
            theoreticalMax += 2;
        }

        // Technical requirements: 2 possible links each (realizedBy + verifiedBy)
        for (TechnicalSafetyRequirement tsr : model.getTechnicalRequirements()) {
            actualLinks += tsr.getRealizedBy().size();
            actualLinks += tsr.getVerifiedBy().size();
            theoreticalMax += 2;
        }

        // FMEA items: 1 possible link each (validatesMechanisms)
        for (FMEAAnalysis fmea : model.getFmeaAnalysis()) {
            for (FMEAItem item : fmea.getFmeaItems()) {
                actualLinks += item.getValidatesMechanisms().size();
                theoreticalMax += 1;
            }
        }

        if (theoreticalMax == 0) return 1.0;
        return Math.min(1.0, (double) actualLinks / theoreticalMax);
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