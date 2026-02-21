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
 * Export Traceability Matrix Action - UPDATED for Requirements Support
 * Generates a comprehensive traceability matrix in CSV format
 * showing all trace links between Requirements, Architecture, Safety, and FMEA elements.
 */
public class ExportTraceabilityAction extends AbstractExternalJavaAction {

    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No model selected", "Please select a UnifiedSystemModel to export traceability matrix.");
            return;
        }

        EObject firstSelection = selections.iterator().next();
        UnifiedSystemModel model = getUnifiedSystemModel(firstSelection);

        if (model == null) {
            showError("Invalid Selection", "Please select a valid UnifiedSystemModel.");
            return;
        }

        Shell shell = Display.getDefault().getActiveShell();
        FileDialog dialog = new FileDialog(shell, SWT.SAVE);
        dialog.setFilterNames(new String[] { "CSV Files (*.csv)", "All Files (*.*)" });
        dialog.setFilterExtensions(new String[] { "*.csv", "*.*" });
        dialog.setFileName("TraceabilityMatrix_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".csv");

        String filePath = dialog.open();
        if (filePath == null) return;

        try {
            exportTraceabilityMatrix(model, filePath);
            showInfo("Export Successful",
                "Traceability matrix exported successfully to:\n" + filePath);
        } catch (IOException e) {
            showError("Export Failed", "Failed to export traceability matrix: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void exportTraceabilityMatrix(UnifiedSystemModel model, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        writer.append("Source Type,Source ID,Source Name,Relationship,Target Type,Target ID,Target Name,Additional Info\n");

        // 1. Requirement -> Block traces
        for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
            for (SafetyCriticalBlock block : RequirementTraceHelper.getRelatedBlocks(req)) {
                Object reqType = RequirementTraceHelper.getRequirementType(req);
                Object priority = RequirementTraceHelper.getPriority(req);
                writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                    "Requirement",
                    escapeCsv(req.getId()),
                    escapeCsv(req.getName()),
                    "traces to",
                    "SafetyCriticalBlock",
                    escapeCsv(block.getId()),
                    escapeCsv(block.getName()),
                    "Type: " + (reqType != null ? reqType : "N/A") +
                    ", Priority: " + (priority != null ? priority : "N/A")
                ));
            }
        }

        // 2. Requirement -> Hazard traces
        for (Requirement req : RequirementTraceHelper.getRequirements(model)) {
            for (IntegratedHazard hazard : RequirementTraceHelper.getRelatedHazards(req)) {
                Object priority = RequirementTraceHelper.getPriority(req);
                writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                    "Requirement",
                    escapeCsv(req.getId()),
                    escapeCsv(req.getName()),
                    "addresses",
                    "Hazard",
                    escapeCsv(hazard.getId()),
                    escapeCsv(hazard.getName()),
                    "Risk: " + hazard.getRiskLevel() + ", Req Priority: " +
                    (priority != null ? priority : "N/A")
                ));
            }
        }

        // 3. FMEA Item -> Requirement traces
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                for (Requirement req : RequirementTraceHelper.getRelatedRequirements(item)) {
                    int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                    Object reqType = RequirementTraceHelper.getRequirementType(req);
                    writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                        "FMEAItem",
                        escapeCsv(item.getId()),
                        escapeCsv(item.getName()),
                        "satisfies",
                        "Requirement",
                        escapeCsv(req.getId()),
                        escapeCsv(req.getName()),
                        "RPN: " + rpn + ", Req Type: " +
                        (reqType != null ? reqType : "N/A")
                    ));
                }
            }
        }

        // 4. Hazard -> Block traces
        for (IntegratedHazard hazard : model.getGlobalHazards()) {
            for (SafetyCriticalBlock block : hazard.getRelatedBlocks()) {
                writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                    "Hazard",
                    escapeCsv(hazard.getId()),
                    escapeCsv(hazard.getName()),
                    "threatens",
                    "SafetyCriticalBlock",
                    escapeCsv(block.getId()),
                    escapeCsv(block.getName()),
                    "Risk: " + hazard.getRiskLevel()
                ));
            }
        }

        // 5. FMEA Item -> Component traces
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (item.getAnalyzedComponent() != null) {
                    SafetyCriticalBlock component = item.getAnalyzedComponent();
                    int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                    writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                        "FMEAItem",
                        escapeCsv(item.getId()),
                        escapeCsv(item.getName()),
                        "analyzes",
                        "SafetyCriticalBlock",
                        escapeCsv(component.getId()),
                        escapeCsv(component.getName()),
                        "RPN: " + rpn
                    ));
                }
            }
        }

        // 6. FMEA Item -> Failure Mode traces
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (item.getFailureMode() != null) {
                    BlockFailureMode fm = item.getFailureMode();
                    writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                        "FMEAItem",
                        escapeCsv(item.getId()),
                        escapeCsv(item.getName()),
                        "addresses",
                        "FailureMode",
                        escapeCsv(fm.getId()),
                        escapeCsv(fm.getName()),
                        "Rate: " + fm.getFailureRate()
                    ));
                }
            }
        }

        // 7. FMEA Item -> Hazard traces
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                for (IntegratedHazard hazard : item.getRelatedHazards()) {
                    writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                        "FMEAItem",
                        escapeCsv(item.getId()),
                        escapeCsv(item.getName()),
                        "mitigates",
                        "Hazard",
                        escapeCsv(hazard.getId()),
                        escapeCsv(hazard.getName()),
                        "Status: " + item.getActionStatus()
                    ));
                }
            }
        }

        // 8. Failure Mode -> Block traces
        for (SafetyCriticalBlock block : model.getRootBlocks()) {
            for (BlockFailureMode fm : block.getFailureModes()) {
                writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                    "FailureMode",
                    escapeCsv(fm.getId()),
                    escapeCsv(fm.getName()),
                    "affects",
                    "SafetyCriticalBlock",
                    escapeCsv(block.getId()),
                    escapeCsv(block.getName()),
                    "ASIL: " + block.getAsilLevel()
                ));
            }
        }

        // 9. Block Connections (Architecture traces)
        for (BlockConnection conn : model.getBlockConnections()) {
            for (SystemBlock from : conn.getFromBlock()) {
                for (SystemBlock to : conn.getToBlock()) {
                    writer.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                        "Block",
                        escapeCsv(from.getId()),
                        escapeCsv(from.getName()),
                        conn.getConnectionType().toString(),
                        "Block",
                        escapeCsv(to.getId()),
                        escapeCsv(to.getName()),
                        "Connection: " + conn.getName()
                    ));
                }
            }
        }

        writer.flush();
        writer.close();
    }

    private String escapeCsv(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }

    private UnifiedSystemModel getUnifiedSystemModel(EObject obj) {
        if (obj instanceof UnifiedSystemModel) {
            return (UnifiedSystemModel) obj;
        }
        if (obj instanceof DSemanticDecorator) {
            return getUnifiedSystemModel(((DSemanticDecorator) obj).getTarget());
        }
        if (obj.eContainer() != null) {
            return getUnifiedSystemModel(obj.eContainer());
        }
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