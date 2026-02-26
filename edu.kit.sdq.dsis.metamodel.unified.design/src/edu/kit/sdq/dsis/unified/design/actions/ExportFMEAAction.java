package edu.kit.sdq.dsis.unified.design.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.UnifiedSystemModel;

/**
 * Action handler for exporting FMEA analysis to CSV format.
 * Compatible with Sirius IExternalJavaAction interface.
 */
public class ExportFMEAAction implements IExternalJavaAction {
    
    // IExternalJavaAction implementation
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("Please select a model element");
            return;
        }
        
        EObject element = selections.iterator().next();
        exportFMEA(element);
    }
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return !selections.isEmpty() && getModelFromSelections(selections) != null;
    }
    
    // Public service method that can be called from AQL
    public void exportFMEA(EObject element) {
        try {
            UnifiedSystemModel model = getModel(element);
            if (model == null || model.getFmeaAnalysis().isEmpty()) {
                showError("No FMEA analysis found to export");
                return;
            }
            
            // Ask user for file location
            final String[] filepath = new String[1];
            Display.getDefault().syncExec(() -> {
                FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
                dialog.setFilterExtensions(new String[] {"*.csv"});
                dialog.setFilterNames(new String[] {"CSV Files (*.csv)"});
                dialog.setFileName("FMEA_Export.csv");
                filepath[0] = dialog.open();
            });
            
            if (filepath[0] == null) return; // User cancelled
            
            // Export to CSV
            FMEAAnalysis analysis = model.getFmeaAnalysis().get(0);
            exportFMEAToCSV(analysis, filepath[0]);
            
            showInfo("Export Complete", 
                    "✅ FMEA exported successfully to:\n" + filepath[0] + "\n\n" +
                    "Total Items: " + analysis.getFmeaItems().size() + "\n" +
                    "RPN Threshold: " + analysis.getRpnThreshold());
            
        } catch (Exception e) {
            showError("Export failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void exportFMEAToCSV(FMEAAnalysis analysis, String filepath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            
            // Header Information
            writer.write("=== FMEA ANALYSIS REPORT ===\n");
            writer.write("Analysis Name," + escapeCsv(analysis.getName()) + "\n");
            writer.write("RPN Threshold," + analysis.getRpnThreshold() + "\n");
            writer.write("Total Items," + analysis.getFmeaItems().size() + "\n");
            writer.write("\n");
            
            // Count high-risk items
            int highRiskCount = 0;
            for (FMEAItem item : analysis.getFmeaItems()) {
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                if (rpn > analysis.getRpnThreshold()) {
                    highRiskCount++;
                }
            }
            writer.write("High Risk Items (RPN > Threshold)," + highRiskCount + "\n");
            writer.write("\n\n");
            
            // FMEA Items Table Header
            writer.write("=== FMEA ITEMS ===\n");
            writer.write("Item Name,Component,Failure Mode,Severity,Occurrence,Detection,RPN,Risk Level,Action Status,Auto-Generated\n");
            
            // FMEA Items Data
            for (FMEAItem item : analysis.getFmeaItems()) {
                // Item Name
                writer.write(escapeCsv(item.getName()) + ",");
                
                // Component
                String componentName = "";
                if (item.getAnalyzedComponent() != null) {
                    componentName = item.getAnalyzedComponent().getName();
                }
                writer.write(escapeCsv(componentName) + ",");
                
                // Failure Mode
                String failureModeName = "";
                if (item.getFailureMode() != null) {
                    failureModeName = item.getFailureMode().getName();
                }
                writer.write(escapeCsv(failureModeName) + ",");
                
                // Severity, Occurrence, Detection
                writer.write(item.getSeverity() + ",");
                writer.write(item.getOccurrence() + ",");
                writer.write(item.getDetection() + ",");
                
                // RPN (Risk Priority Number)
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                writer.write(rpn + ",");
                
                // Risk Level based on RPN
                String riskLevel;
                if (rpn > analysis.getRpnThreshold()) {
                    riskLevel = "HIGH RISK";
                } else if (rpn > analysis.getRpnThreshold() * 0.5) {
                    riskLevel = "MEDIUM RISK";
                } else {
                    riskLevel = "LOW RISK";
                }
                writer.write(riskLevel + ",");
                
                // Action Status
                String actionStatus = "";
                if (item.getActionStatus() != null) {
                    actionStatus = item.getActionStatus().toString();
                }
                writer.write(escapeCsv(actionStatus) + ",");
                
                // Auto-Generated flag
                writer.write((item.isAutoGenerated() ? "Yes" : "No") + "\n");
            }
            
            writer.write("\n\n");
            
            // Statistics Section
            writer.write("=== STATISTICS ===\n");
            writer.write("Metric,Value\n");
            
            // Calculate statistics
            int totalItems = analysis.getFmeaItems().size();
            int autoGenerated = 0;
            double totalRPN = 0;
            double maxRPN = 0;
            double minRPN = Double.MAX_VALUE;
            
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (item.isAutoGenerated()) autoGenerated++;
                int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
                totalRPN += rpn;
                if (rpn > maxRPN) maxRPN = rpn;
                if (rpn < minRPN) minRPN = rpn;
            }
            
            double avgRPN = totalItems > 0 ? totalRPN / totalItems : 0;
            double autoGenPercentage = totalItems > 0 ? (autoGenerated * 100.0 / totalItems) : 0;
            
            writer.write("Total Items," + totalItems + "\n");
            writer.write("High Risk Items," + highRiskCount + "\n");
            writer.write("Auto-Generated Items," + autoGenerated + "\n");
            writer.write("Auto-Generated Percentage," + String.format("%.1f%%", autoGenPercentage) + "\n");
            writer.write("Average RPN," + String.format("%.2f", avgRPN) + "\n");
            writer.write("Maximum RPN," + (int)maxRPN + "\n");
            writer.write("Minimum RPN," + (totalItems > 0 ? (int)minRPN : 0) + "\n");
            writer.write("RPN Threshold," + analysis.getRpnThreshold() + "\n");
        }
    }
    
    /**
     * Escape special characters for CSV format
     */
    private String escapeCsv(String value) {
        if (value == null) {
            return "";
        }
        
        // If value contains comma, quote, or newline, wrap in quotes
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            // Escape quotes by doubling them
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        
        return value;
    }
    
    // Helper methods
    private UnifiedSystemModel getModelFromSelections(Collection<? extends EObject> selections) {
        if (selections == null || selections.isEmpty()) {
            return null;
        }
        return getModel(selections.iterator().next());
    }
    
    private UnifiedSystemModel getModel(EObject element) {
        EObject current = element;
        while (current != null) {
            if (current instanceof UnifiedSystemModel) {
                return (UnifiedSystemModel) current;
            }
            current = current.eContainer();
        }
        return null;
    }
    
    private Shell getShell() {
        return Display.getDefault().getActiveShell();
    }
    
    private void showInfo(String title, String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openInformation(getShell(), title, message);
        });
    }
    
    private void showError(String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(getShell(), "Error", message);
        });
    }
}