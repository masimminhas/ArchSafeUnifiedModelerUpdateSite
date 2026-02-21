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

import unified.BlockConnection;
import unified.SafetyCriticalBlock;
import unified.SystemBlock;
import unified.UnifiedSystemModel;

public class ExportArchitectureAction implements IExternalJavaAction {
    
    @Override
    public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
        if (selections == null || selections.isEmpty()) {
            showError("No selection");
            return;
        }
        
        EObject element = selections.iterator().next();
        UnifiedSystemModel model = getModel(element);
        
        if (model == null) {
            showError("Could not find UnifiedSystemModel");
            return;
        }
        
        // Show file dialog
        final String[] filepath = new String[1];
        Display.getDefault().syncExec(() -> {
            try {
                Shell shell = Display.getDefault().getActiveShell();
                if (shell == null) {
                    shell = new Shell(Display.getDefault());
                }
                
                FileDialog dialog = new FileDialog(shell, SWT.SAVE);
                dialog.setFilterExtensions(new String[] {"*.csv"});
                dialog.setFilterNames(new String[] {"CSV Files (*.csv)"});
                dialog.setFileName("Architecture_Export.csv");
                filepath[0] = dialog.open();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        if (filepath[0] == null) {
            showInfo("Cancelled", "File export cancelled by user");
            return;
        }
        
        // Export to CSV
        try {
            exportArchitectureToCSV(model, filepath[0]);
            
            showInfo("Export Complete", 
                    "✅ Architecture exported successfully to:\n" + filepath[0] + "\n\n" +
                    "System Blocks: " + model.getSystemBlocks().size() + "\n" +
                    "Safety Blocks: " + model.getRootBlocks().size() + "\n" +
                    "Connections: " + model.getBlockConnections().size());
            
        } catch (Exception e) {
            showError("Export failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void exportArchitectureToCSV(UnifiedSystemModel model, String filepath) 
            throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            
            // Summary Section
            writer.write("=== ARCHITECTURE SUMMARY ===\n");
            writer.write("Metric,Value\n");
            writer.write("Total System Blocks," + model.getSystemBlocks().size() + "\n");
            writer.write("Total Safety Critical Blocks," + model.getRootBlocks().size() + "\n");
            writer.write("Total Connections," + model.getBlockConnections().size() + "\n");
            writer.write("Total Associations," + model.getBlockAssociations().size() + "\n");
            writer.write("Total Hazards," + model.getGlobalHazards().size() + "\n");
            
            // Count failure modes
            int totalFailureModes = 0;
            for (SafetyCriticalBlock block : model.getRootBlocks()) {
                totalFailureModes += block.getFailureModes().size();
            }
            writer.write("Total Failure Modes," + totalFailureModes + "\n");
            writer.write("\n\n");
            
            // System Blocks Section
            writer.write("=== SYSTEM BLOCKS ===\n");
            writer.write("Name,Block Type,Description\n");
            for (SystemBlock block : model.getSystemBlocks()) {
                writer.write(escapeCsv(block.getName()) + ",");
                writer.write(escapeCsv(block.getBlockType() != null ? 
                    block.getBlockType().toString() : "") + ",");
                writer.write(escapeCsv(block.getDescription()) + "\n");
            }
            writer.write("\n\n");
            
            // Safety Critical Blocks Section
            writer.write("=== SAFETY CRITICAL BLOCKS ===\n");
            writer.write("Name,Safety Criticality,ASIL Level,Has Redundancy,Failure Modes Count\n");
            for (SafetyCriticalBlock block : model.getRootBlocks()) {
                writer.write(escapeCsv(block.getName()) + ",");
                writer.write(escapeCsv(block.getSafetyCriticality() != null ? 
                    block.getSafetyCriticality().toString() : "") + ",");
                writer.write(escapeCsv(block.getAsilLevel() != null ? 
                    block.getAsilLevel().toString() : "") + ",");
                writer.write((block.isHasRedundancy() ? "Yes" : "No") + ",");
                writer.write(block.getFailureModes().size() + "\n");
            }
            writer.write("\n\n");
            
            // Connections Section
            writer.write("=== CONNECTIONS ===\n");
            writer.write("Connection Name,From Block,To Block,Connection Type\n");
            for (BlockConnection conn : model.getBlockConnections()) {
                writer.write(escapeCsv(conn.getName()) + ",");
                
                // From Block
                String fromBlock = "";
                if (!conn.getFromBlock().isEmpty()) {
                    fromBlock = conn.getFromBlock().get(0).getName();
                }
                writer.write(escapeCsv(fromBlock) + ",");
                
                // To Block
                String toBlock = "";
                if (!conn.getToBlock().isEmpty()) {
                    toBlock = conn.getToBlock().get(0).getName();
                }
                writer.write(escapeCsv(toBlock) + ",");
                
                writer.write(escapeCsv(conn.getConnectionType() != null ? 
                    conn.getConnectionType().toString() : "") + "\n");
            }
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
    
    @Override
    public boolean canExecute(Collection<? extends EObject> selections) {
        return selections != null && !selections.isEmpty();
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
    
    private void showInfo(String title, String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openInformation(
                Display.getDefault().getActiveShell(),
                title,
                message
            );
        });
    }
    
    private void showError(String message) {
        Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(
                Display.getDefault().getActiveShell(),
                "Error",
                message
            );
        });
    }
}