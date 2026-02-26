package edu.kit.sdq.dsis.unified.design.actions.metrics;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import edu.kit.sdq.dsis.unified.design.services.MetricsService;
import unified.UnifiedSystemModel;

/**
 * ExternalJavaAction that computes all six quality metrics (MCR, HTI, RAR,
 * FLC, TDS, MVR) and writes the results back to the model's AnalysisMetadata.
 *
 * Called from the MetricsDashboard table toolbar via the
 * "⟳ Refresh All Metrics" tool button defined in unified.odesign.
 */
public class RefreshMetricsAction implements IExternalJavaAction {

    // Shared MetricsService instance (stateless — safe to share)
    private final MetricsService metricsService = new MetricsService();

    /**
     * Called by Sirius when the user clicks "⟳ Refresh All Metrics".
     *
     * @param selections  The selected EObjects in the table at the time of
     *                    the button click. Because the button is a CreateLineTool
     *                    on the MD_SummaryLine, the selection will contain the
     *                    UnifiedSystemModel root element.
     * @param parameters  Key-value pairs passed from the odesign
     *                    ExternalJavaAction parameters (none defined here,
     *                    but the map is always provided by Sirius).
     */
    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        // Resolve the UnifiedSystemModel from the selection.
        // The selection arrives as the context of the ChangeContext operation,
        // which browses to 'self' (the UnifiedSystemModel root).
        UnifiedSystemModel model = null;

        for (EObject obj : selections) {
            if (obj instanceof UnifiedSystemModel) {
                model = (UnifiedSystemModel) obj;
                break;
            }
            // Walk up the containment hierarchy in case a child is selected
            EObject candidate = obj;
            while (candidate != null) {
                if (candidate instanceof UnifiedSystemModel) {
                    model = (UnifiedSystemModel) candidate;
                    break;
                }
                candidate = candidate.eContainer();
            }
            if (model != null) break;
        }

        if (model == null) {
            showError("Refresh Metrics failed",
                "Could not locate the UnifiedSystemModel root. " +
                "Please ensure the table is opened on a UnifiedSystemModel instance.");
            return;
        }

        // ── Compute and write back all metrics ────────────────────────────
        // metricsService.refreshAllMetrics() sets:
        //   AnalysisMetadata.traceabilityDensity  ← TDS
        //   AnalysisMetadata.hazardCoverage       ← HTI
        //   AnalysisMetadata.fmeaCoverage         ← FLC
        //   AnalysisMetadata.completenessScore    ← composite (MCR+RAR+MVR)/3
        //   AnalysisMetadata.consistencyScore     ← TDS+HTI threshold check
        metricsService.refreshAllMetrics(model);

        // ── Build summary for user feedback ──────────────────────────────
        double mcr = metricsService.computeMCR(model);
        double hti = metricsService.computeHTI(model);
        double rar = metricsService.computeRAR(model);
        double flc = metricsService.computeFLC(model);
        double tds = metricsService.computeTDS(model);
        double mvr = metricsService.computeMVR(model);

        String summary = String.format(
            "Metrics refreshed successfully.\n\n" +
            "MCR (Metamodel Coverage Ratio)    = %.2f  %s\n" +
            "HTI (Hazard Traceability Index)   = %.2f  %s\n" +
            "RAR (Requirement Allocation Ratio)= %.2f  %s\n" +
            "FLC (FMEA Linkage Completeness)   = %.2f  %s\n" +
            "TDS (Traceability Density Score)  = %.2f  %s\n" +
            "MVR (Mechanism Verification Rate) = %.2f  %s\n\n" +
            "Results written to AnalysisMetadata. Save the model to persist.",
            mcr, statusMark(mcr, 0.90),
            hti, statusMark(hti, 1.00),
            rar, statusMark(rar, 0.95),
            flc, statusMark(flc, 1.00),
            tds, tds >= 0.80 ? "✓" : "~",
            mvr, statusMark(mvr, 0.85)
        );

        // Show the summary in a non-blocking information dialog
        final String finalSummary = summary;
        Display.getDefault().asyncExec(() ->
            MessageDialog.openInformation(
                Display.getDefault().getActiveShell(),
                "Quality Metrics Refreshed",
                finalSummary
            )
        );
    }

    /**
     * Controls whether the tool button is enabled.
     * Returning true always enables the button whenever any EObject is
     * selected (the execute() method handles null-model gracefully).
     */
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
    }

    // ── Private helpers ──────────────────────────────────────────────────────

    private String statusMark(double value, double threshold) {
        return value >= threshold ? "✓" : "✗";
    }

    private void showError(String title, String message) {
        Display.getDefault().asyncExec(() ->
            MessageDialog.openError(
                Display.getDefault().getActiveShell(),
                title,
                message
            )
        );
    }
}