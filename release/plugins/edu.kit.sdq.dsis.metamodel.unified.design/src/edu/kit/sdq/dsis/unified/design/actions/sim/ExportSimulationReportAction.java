package edu.kit.sdq.dsis.unified.design.actions.sim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Exports the failure propagation simulation report to an HTML file.
 *
 * <h2>Shell / FileDialog pattern</h2>
 * Mirrors {@code ExportArchitectureAction} (which works) exactly:
 * <ul>
 *   <li>The {@link FileDialog} and Shell construction are both inside
 *       {@code Display.getDefault().syncExec()} — Shell creation MUST
 *       happen on the SWT UI thread.</li>
 *   <li>The selected path is extracted via a one-element array because
 *       lambdas require effectively-final variables.</li>
 *   <li>File writing happens after syncExec returns, outside the UI thread.</li>
 *   <li>No PlatformUI dependency — only SWT/JFace which are always present.</li>
 * </ul>
 *
 * <h2>Output Format</h2>
 * Generates a self-contained HTML report with embedded CSS.
 * Open in any browser; print to PDF via Ctrl+P → Save as PDF.
 */
public class ExportSimulationReportAction implements IExternalJavaAction {

    // ── Report identity ───────────────────────────────────────────────────────
    private static final String ORG_TAG     = "DSIS · Unified Design";
    private static final String ORG_FULL    = "Karlsruhe Institute of Technology &nbsp;·&nbsp; SDQ";
    private static final String TOOL_VER    = "Simulation Export v2";
    private static final String CONFIDENTIAL = "CONFIDENTIAL — INTERNAL USE ONLY";

    // ── Report ID counter (sequential within JVM session) ────────────────────
    private static final AtomicInteger REPORT_COUNTER = new AtomicInteger(1);

    // =========================================================================

    @Override
    public boolean canExecute(Collection<? extends EObject> selections) { return true; }

    @Override
    public void execute(Collection<? extends EObject> selections,
                        Map<String, Object> parameters) {

        SimulationState state = SimulationState.getInstance();

        if (!state.isActive()) {
            Display.getDefault().syncExec(() -> {
                try {
                    Shell shell = activeShell();
                    MessageDialog.openInformation(shell,
                        "Export Simulation Report",
                        "No simulation active.\nTrigger a failure propagation first.");
                } catch (Exception e) { e.printStackTrace(); }
            });
            return;
        }

        // Build report on calling thread — pure Java, no SWT needed.
        LocalDateTime now = LocalDateTime.now();
        String ts         = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String reportId   = String.format("RPT-%s-%04d",
                                now.format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                                REPORT_COUNTER.getAndIncrement());
        String report     = buildHtmlReport(state, now, reportId);

        // ── Step 1: open native FileDialog on the UI thread ──────────────────
        final String[] filepath = new String[1];
        Display.getDefault().syncExec(() -> {
            try {
                Shell shell = activeShell();
                FileDialog dlg = new FileDialog(shell, SWT.SAVE);
                dlg.setText("Export Failure Propagation Report");
                dlg.setFilterNames(new String[]{
                    "HTML Report (*.html)",
                    "All Files (*.*)"
                });
                dlg.setFilterExtensions(new String[]{"*.html", "*.*"});
                dlg.setFileName("FailurePropagation_" + ts + ".html");
                dlg.setOverwrite(true);
                filepath[0] = dlg.open();
            } catch (Exception e) { e.printStackTrace(); }
        });

        if (filepath[0] == null) return; // user cancelled

        // ── Step 2: write file outside the UI thread ─────────────────────────
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filepath[0]))) {
            w.write(report);
        } catch (IOException e) {
            e.printStackTrace();
            final String msg = e.getMessage();
            Display.getDefault().asyncExec(() -> {
                try {
                    MessageDialog.openError(activeShell(), "Export Failed",
                        "Could not write report:\n" + msg);
                } catch (Exception ignored) { }
            });
            return;
        }

        // ── Step 3: success confirmation ──────────────────────────────────────
        final String savedPath = filepath[0];
        Display.getDefault().asyncExec(() -> {
            try {
                MessageDialog.openInformation(activeShell(), "Export Complete",
                    "Simulation report saved to:\n" + savedPath
                    + "\n\nOpen in any browser. Use Ctrl+P → Save as PDF to export as PDF.");
            } catch (Exception ignored) { }
        });
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /** Returns the active shell, creating a new one if none is available. */
    private static Shell activeShell() {
        Shell shell = Display.getDefault().getActiveShell();
        return (shell != null) ? shell : new Shell(Display.getDefault());
    }

    // =========================================================================
    //  HTML REPORT BUILDER
    // =========================================================================

    private String buildHtmlReport(SimulationState state,
                                   LocalDateTime now,
                                   String reportId) {

        String dateLabel = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeLabel = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String generated = dateLabel + " &nbsp; " + timeLabel;

        List<SimulationState.PropagationStep> log = state.getLog();

        StringBuilder sb = new StringBuilder(8192);

        // ── head ─────────────────────────────────────────────────────────────
        sb.append("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
        sb.append("<meta charset=\"UTF-8\">\n");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        sb.append("<title>Failure Propagation Report · ").append(reportId).append("</title>\n");
        sb.append("<link href=\"https://fonts.googleapis.com/css2?family=IBM+Plex+Mono:wght@300;400;500;600&family=IBM+Plex+Sans:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">\n");
        sb.append("<style>\n").append(CSS).append("\n</style>\n");
        sb.append("</head>\n<body>\n<div class=\"page\">\n\n");

        // ── header ───────────────────────────────────────────────────────────
        sb.append("<header class=\"report-header\">\n");
        sb.append("  <div class=\"header-top\">\n");
        sb.append("    <div class=\"org-block\">\n");
        sb.append("      <span class=\"org-tag\">").append(ORG_TAG).append("</span>\n");
        sb.append("      <span class=\"org-name\">").append(ORG_FULL).append("</span>\n");
        sb.append("    </div>\n");
        sb.append("    <div class=\"report-meta\">\n");
        sb.append("      <span class=\"meta-id\">").append(reportId).append("</span>\n");
        sb.append("      <span>Generated: ").append(generated).append("</span>\n");
        sb.append("      <span>Format: ").append(TOOL_VER).append("</span>\n");
        sb.append("    </div>\n");
        sb.append("  </div>\n");

        sb.append("  <div class=\"report-title-block\">\n");
        sb.append("    <span class=\"report-label\">Document</span>\n");
        sb.append("    <h1 class=\"report-title\">Failure <span>Propagation</span><br>Simulation Report</h1>\n");
        sb.append("  </div>\n");

        sb.append("  <div class=\"status-bar\">\n");
        sb.append("    <div class=\"status-pill\"><div class=\"status-dot\"></div>SIMULATION COMPLETE</div>\n");
        sb.append("    <div class=\"status-divider\"></div>\n");
        sb.append("    <div class=\"status-item\">Mode: <strong>")
          .append(h(state.getMode().toUpperCase())).append("</strong></div>\n");
        sb.append("    <div class=\"status-divider\"></div>\n");
        sb.append("    <div class=\"status-item\">Steps: <strong>")
          .append(log.size()).append("</strong></div>\n");
        sb.append("  </div>\n");
        sb.append("</header>\n\n");

        // ── section 01 — parameters ───────────────────────────────────────────
        sb.append(sectionHeader("01", "Simulation Parameters"));
        sb.append("<div class=\"params-grid\">\n");
        paramCell(sb, "Propagation Mode", h(state.getMode().toUpperCase()), "mode");
        paramCell(sb, "Max Depth", "Unlimited", "normal");
        paramCell(sb, "Source Blocks",   String.valueOf(state.sourceCount()),     "");
        paramCell(sb, "Affected Blocks", String.valueOf(state.propagatedCount()), "");
        paramCell(sb, "Active Edges",    String.valueOf(state.edgeCount()),        "");
        paramCell(sb, "Propagation Steps", String.valueOf(log.size()),             "");
        sb.append("</div>\n</section>\n\n");

        // ── section 02 — impact overview ─────────────────────────────────────
        sb.append(sectionHeader("02", "Impact Overview"));
        sb.append("<div class=\"summary-bar\">\n");
        summaryCell(sb, state.sourceCount(),     "Source Blocks",      "sources");
        summaryCell(sb, state.propagatedCount(), "Affected Blocks",    "affected");
        summaryCell(sb, log.size(),              "Propagation Steps",  "steps");
        sb.append("</div>\n</section>\n\n");

        // ── section 03 — propagation chain ───────────────────────────────────
        sb.append(sectionHeader("03", "Propagation Chain"));

        if (log.isEmpty()) {
            sb.append("<div class=\"empty-state\">\n");
            sb.append("  <div class=\"empty-icon\">⬡</div>\n");
            sb.append("  <div class=\"empty-text\">\n");
            sb.append("    No propagation steps recorded.<br>\n");
            sb.append("    The source block has no connections in the selected direction.\n");
            sb.append("  </div>\n</div>\n");
        } else {
            sb.append("<div class=\"chain-container\">\n");
            int lastDepth = -1;
            boolean groupOpen = false;

            for (SimulationState.PropagationStep step : log) {

                // open a new depth group when depth changes
                if (step.depth != lastDepth) {
                    if (groupOpen) sb.append("</div><!-- /depth-group -->\n\n");
                    String depthTitle = (step.depth == 0)
                        ? "▸ Depth 0 — Origin"
                        : "▸ Depth " + step.depth;
                    sb.append("<div class=\"depth-group\">\n");
                    sb.append("  <div class=\"depth-label\">\n");
                    sb.append("    <span class=\"depth-tag\">").append(depthTitle).append("</span>\n");
                    sb.append("    <div class=\"depth-line\"></div>\n");
                    sb.append("  </div>\n\n");
                    groupOpen = true;
                    lastDepth = step.depth;
                }

                // step row
                boolean isSource = (step.depth == 0);
                sb.append("  <div class=\"step-row\">\n");
                // from
                sb.append("    <div class=\"step-block from\">\n");
                sb.append("      <div class=\"block-name\">").append(h(step.fromBlockName)).append("</div>\n");
                if (isSource)
                    sb.append("      <div class=\"block-role source\">⬤ failure source</div>\n");
                else
                    sb.append("      <div class=\"block-role\">propagated</div>\n");
                sb.append("    </div>\n");
                // connector
                sb.append("    <div class=\"step-connector\">\n");
                sb.append("      <div class=\"conn-arrow\">⟶</div>\n");
                sb.append("      <div class=\"conn-name\">").append(h(step.connectionName)).append("</div>\n");
                sb.append("      <div class=\"conn-type-badge\">").append(h(step.connectionType)).append("</div>\n");
                sb.append("    </div>\n");
                // to
                sb.append("    <div class=\"step-block to\">\n");
                sb.append("      <div class=\"block-name\">").append(h(step.toBlockName)).append("</div>\n");
                sb.append("      <div class=\"block-role target\">◉ affected</div>\n");
                sb.append("    </div>\n");
                sb.append("  </div>\n");

                // detail row
                boolean hasEffect = step.failureEffect != null && !step.failureEffect.isBlank();
                boolean hasRate   = step.failureRate > 0;
                if (hasEffect || hasRate) {
                    sb.append("  <div class=\"step-details\">\n");
                    if (hasEffect)
                        detailCell(sb, "Fail. Effect", h(step.failureEffect), "effect");
                    detailCell(sb, "Fail. Rate",
                        hasRate ? String.format("%.2e /hr", step.failureRate) : "—",
                        hasRate ? "rate" : "");
                    sb.append("  </div>\n\n");
                } else {
                    sb.append("\n");
                }
            }
            if (groupOpen) sb.append("</div><!-- /depth-group -->\n");
            sb.append("</div><!-- /chain-container -->\n");
        }

        sb.append("</section>\n\n");

        // ── footer ────────────────────────────────────────────────────────────
        sb.append("<footer class=\"report-footer\">\n");
        sb.append("  <div class=\"footer-left\">\n");
        sb.append("    <span class=\"footer-label\">Export Source</span>\n");
        sb.append("    <span class=\"footer-value\">ExportSimulationReportAction &nbsp;·&nbsp; DSIS Unified Design Platform</span>\n");
        sb.append("  </div>\n");
        sb.append("  <div class=\"footer-sig\">\n");
        sb.append("    KIT &nbsp;·&nbsp; SDQ &nbsp;·&nbsp; DSIS Unified Design<br>\n");
        sb.append("    Failure Propagation Simulation Report<br>\n");
        sb.append("    <span style=\"color:var(--accent);letter-spacing:.1em;\">")
          .append(CONFIDENTIAL).append("</span>\n");
        sb.append("  </div>\n");
        sb.append("</footer>\n\n");

        sb.append("</div><!-- /page -->\n</body>\n</html>\n");
        return sb.toString();
    }

    // ── HTML fragment helpers ─────────────────────────────────────────────────

    /** Escapes HTML special characters. */
    private static String h(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String sectionHeader(String num, String title) {
        return "<section class=\"section\">\n"
             + "  <div class=\"section-header\">\n"
             + "    <span class=\"section-num\">" + num + "</span>\n"
             + "    <span class=\"section-title\">" + title + "</span>\n"
             + "    <div class=\"section-rule\"></div>\n"
             + "  </div>\n";
    }

    private static void paramCell(StringBuilder sb, String label, String value, String extraClass) {
        sb.append("  <div class=\"param-cell\">\n");
        sb.append("    <div class=\"param-label\">").append(label).append("</div>\n");
        sb.append("    <div class=\"param-value")
          .append(extraClass.isEmpty() ? "" : " " + extraClass)
          .append("\">").append(value).append("</div>\n");
        sb.append("  </div>\n");
    }

    private static void summaryCell(StringBuilder sb, int num, String label, String numClass) {
        sb.append("  <div class=\"summary-cell\">\n");
        sb.append("    <div class=\"summary-num ").append(numClass).append("\">")
          .append(num).append("</div>\n");
        sb.append("    <div class=\"summary-label\">").append(label).append("</div>\n");
        sb.append("  </div>\n");
    }

    private static void detailCell(StringBuilder sb, String key, String val, String valClass) {
        sb.append("    <div class=\"detail-cell\">\n");
        sb.append("      <div class=\"detail-key\">").append(key).append("</div>\n");
        sb.append("      <div class=\"detail-val")
          .append(valClass.isEmpty() ? "" : " " + valClass)
          .append("\">").append(val).append("</div>\n");
        sb.append("    </div>\n");
    }

    // =========================================================================
    //  EMBEDDED CSS  (single source of truth — no external files required)
    // =========================================================================

    private static final String CSS =
        ":root {\n"
      + "  --bg:       #0b0e14;\n"
      + "  --surface:  #111620;\n"
      + "  --surface2: #161d2b;\n"
      + "  --border:   #1e2d45;\n"
      + "  --accent:   #00c8ff;\n"
      + "  --accent2:  #ff4d6a;\n"
      + "  --accent3:  #ffc246;\n"
      + "  --text:     #d4e3f7;\n"
      + "  --text-dim: #5a7090;\n"
      + "  --text-mid: #8aabcc;\n"
      + "  --green:    #00e5a0;\n"
      + "  --mono:     'IBM Plex Mono', monospace;\n"
      + "  --sans:     'IBM Plex Sans', sans-serif;\n"
      + "}\n"
      + "* { box-sizing: border-box; margin: 0; padding: 0; }\n"
      + "@page { size: A4; margin: 15mm 12mm; }\n"
      + "body {\n"
      + "  background: var(--bg); color: var(--text); font-family: var(--sans);\n"
      + "  font-size: 13px; line-height: 1.6; min-height: 100vh; padding: 0;\n"
      + "}\n"
      + "body::before {\n"
      + "  content: ''; position: fixed; inset: 0; pointer-events: none; z-index: 0;\n"
      + "  background: repeating-linear-gradient(0deg, transparent, transparent 2px,\n"
      + "    rgba(0,200,255,.013) 2px, rgba(0,200,255,.013) 4px);\n"
      + "}\n"
      + ".page { position:relative; z-index:1; max-width:860px; margin:0 auto; padding:48px 40px 60px; }\n"

      // header
      + ".report-header { display:flex; flex-direction:column; gap:0; margin-bottom:40px;\n"
      + "  padding-bottom:28px; border-bottom:1px solid var(--border); }\n"
      + ".header-top { display:flex; justify-content:space-between; align-items:flex-start;\n"
      + "  gap:20px; margin-bottom:20px; }\n"
      + ".org-block { display:flex; flex-direction:column; gap:4px; }\n"
      + ".org-tag { font-family:var(--mono); font-size:9px; letter-spacing:.18em;\n"
      + "  color:var(--accent); text-transform:uppercase; background:rgba(0,200,255,.07);\n"
      + "  border:1px solid rgba(0,200,255,.2); padding:3px 8px; display:inline-block; }\n"
      + ".org-name { font-size:10px; color:var(--text-dim); letter-spacing:.08em; font-family:var(--mono); }\n"
      + ".report-meta { text-align:right; font-family:var(--mono); font-size:10px;\n"
      + "  color:var(--text-dim); display:flex; flex-direction:column; gap:3px; align-items:flex-end; }\n"
      + ".report-meta .meta-id { color:var(--accent3); font-size:11px; font-weight:500; }\n"
      + ".report-title-block { display:flex; align-items:baseline; gap:16px; }\n"
      + ".report-label { font-family:var(--mono); font-size:9px; letter-spacing:.2em;\n"
      + "  color:var(--text-dim); text-transform:uppercase; white-space:nowrap; padding-top:6px; }\n"
      + "h1.report-title { font-size:26px; font-weight:700; letter-spacing:-.02em;\n"
      + "  color:#fff; line-height:1.15; }\n"
      + "h1.report-title span { color:var(--accent); }\n"

      // status bar
      + ".status-bar { display:flex; align-items:center; gap:24px; margin-top:18px;\n"
      + "  padding:10px 16px; background:var(--surface); border:1px solid var(--border);\n"
      + "  border-left:3px solid var(--green); }\n"
      + ".status-pill { display:flex; align-items:center; gap:7px; font-family:var(--mono);\n"
      + "  font-size:11px; color:var(--green); font-weight:500; }\n"
      + ".status-dot { width:7px; height:7px; border-radius:50%; background:var(--green);\n"
      + "  box-shadow:0 0 8px var(--green); animation:pulse 2s infinite; }\n"
      + "@keyframes pulse { 0%,100%{opacity:1;transform:scale(1)} 50%{opacity:.5;transform:scale(.85)} }\n"
      + ".status-divider { width:1px; height:16px; background:var(--border); }\n"
      + ".status-item { font-family:var(--mono); font-size:10px; color:var(--text-dim); }\n"
      + ".status-item strong { color:var(--text-mid); font-weight:500; }\n"

      // section
      + ".section { margin-bottom:36px; }\n"
      + ".section-header { display:flex; align-items:center; gap:12px; margin-bottom:14px; }\n"
      + ".section-num { font-family:var(--mono); font-size:10px; color:var(--accent);\n"
      + "  font-weight:600; letter-spacing:.1em; min-width:28px; }\n"
      + ".section-title { font-size:11px; font-weight:600; letter-spacing:.14em;\n"
      + "  text-transform:uppercase; color:var(--text); }\n"
      + ".section-rule { flex:1; height:1px; background:linear-gradient(90deg,var(--border) 0%,transparent 100%); }\n"

      // params grid
      + ".params-grid { display:grid; grid-template-columns:1fr 1fr; gap:1px;\n"
      + "  background:var(--border); border:1px solid var(--border); }\n"
      + ".param-cell { background:var(--surface); padding:12px 16px;\n"
      + "  display:flex; flex-direction:column; gap:4px; }\n"
      + ".param-label { font-family:var(--mono); font-size:9px; letter-spacing:.12em;\n"
      + "  text-transform:uppercase; color:var(--text-dim); }\n"
      + ".param-value { font-family:var(--mono); font-size:16px; font-weight:600; color:var(--accent3); }\n"
      + ".param-value.mode   { color:var(--accent); font-size:13px; }\n"
      + ".param-value.normal { color:var(--text); font-size:13px; }\n"

      // summary bar
      + ".summary-bar { display:grid; grid-template-columns:repeat(3,1fr); gap:1px;\n"
      + "  background:var(--border); border:1px solid var(--border); margin-bottom:20px; }\n"
      + ".summary-cell { background:var(--surface2); padding:14px 18px; text-align:center; }\n"
      + ".summary-num { font-family:var(--mono); font-size:28px; font-weight:600;\n"
      + "  line-height:1; margin-bottom:5px; }\n"
      + ".summary-num.sources  { color:var(--accent2); }\n"
      + ".summary-num.affected { color:var(--accent3); }\n"
      + ".summary-num.steps    { color:var(--green); }\n"
      + ".summary-label { font-family:var(--mono); font-size:9px; letter-spacing:.14em;\n"
      + "  text-transform:uppercase; color:var(--text-dim); }\n"

      // chain
      + ".chain-container { display:flex; flex-direction:column; gap:0; }\n"
      + ".depth-group { margin-bottom:4px; }\n"
      + ".depth-label { display:flex; align-items:center; gap:10px; padding:6px 12px;\n"
      + "  background:rgba(0,200,255,.05); border-left:2px solid var(--accent); margin-bottom:1px; }\n"
      + ".depth-tag { font-family:var(--mono); font-size:9px; font-weight:600;\n"
      + "  letter-spacing:.16em; text-transform:uppercase; color:var(--accent); }\n"
      + ".depth-line { flex:1; height:1px; background:var(--border); }\n"
      + ".step-row { display:grid; grid-template-columns:1fr auto 1fr; background:var(--surface);\n"
      + "  border:1px solid var(--border); border-top:none; margin-bottom:1px;\n"
      + "  transition:background .15s; }\n"
      + ".step-row:hover { background:var(--surface2); }\n"
      + ".step-block { padding:10px 14px; display:flex; flex-direction:column; justify-content:center; }\n"
      + ".step-block.from { border-right:1px solid var(--border); }\n"
      + ".step-block.to   { border-left:1px solid var(--border); }\n"
      + ".block-name { font-family:var(--mono); font-size:12px; font-weight:500; color:var(--text); }\n"
      + ".block-role { font-size:10px; color:var(--text-dim); margin-top:2px; font-family:var(--mono); }\n"
      + ".block-role.source { color:var(--accent2); }\n"
      + ".block-role.target { color:var(--green); }\n"
      + ".step-connector { display:flex; flex-direction:column; align-items:center;\n"
      + "  justify-content:center; padding:8px 18px; gap:3px; min-width:180px; }\n"
      + ".conn-arrow { font-family:var(--mono); font-size:18px; color:var(--accent3); line-height:1; }\n"
      + ".conn-name { font-family:var(--mono); font-size:9px; color:var(--text-dim);\n"
      + "  text-align:center; max-width:160px; overflow:hidden; text-overflow:ellipsis; white-space:nowrap; }\n"
      + ".conn-type-badge { font-family:var(--mono); font-size:8px; letter-spacing:.1em;\n"
      + "  text-transform:uppercase; padding:2px 6px; border-radius:2px;\n"
      + "  background:rgba(255,194,70,.12); color:var(--accent3); border:1px solid rgba(255,194,70,.25); }\n"
      + ".step-details { display:grid; grid-template-columns:1fr 1fr; gap:1px;\n"
      + "  background:rgba(0,0,0,.3); border:1px solid var(--border); border-top:none; margin-bottom:8px; }\n"
      + ".detail-cell { background:rgba(11,14,20,.8); padding:6px 14px; display:flex; gap:10px; align-items:center; }\n"
      + ".detail-key { font-family:var(--mono); font-size:9px; letter-spacing:.1em;\n"
      + "  text-transform:uppercase; color:var(--text-dim); min-width:80px; }\n"
      + ".detail-val { font-family:var(--mono); font-size:10px; color:var(--text-mid); }\n"
      + ".detail-val.rate   { color:var(--accent2); }\n"
      + ".detail-val.effect { color:#d4b3ff; }\n"

      // empty state
      + ".empty-state { padding:32px 20px; background:var(--surface);\n"
      + "  border:1px dashed var(--border); text-align:center; }\n"
      + ".empty-icon { font-size:32px; margin-bottom:10px; opacity:.4; }\n"
      + ".empty-text { font-family:var(--mono); font-size:11px; color:var(--text-dim); line-height:1.8; }\n"

      // footer
      + ".report-footer { margin-top:48px; padding-top:20px; border-top:1px solid var(--border);\n"
      + "  display:flex; justify-content:space-between; align-items:flex-end; }\n"
      + ".footer-left { display:flex; flex-direction:column; gap:4px; }\n"
      + ".footer-label { font-family:var(--mono); font-size:9px; letter-spacing:.18em;\n"
      + "  text-transform:uppercase; color:var(--text-dim); }\n"
      + ".footer-value { font-family:var(--mono); font-size:10px; color:var(--text-mid); }\n"
      + ".footer-sig { font-family:var(--mono); font-size:9px; color:var(--text-dim);\n"
      + "  text-align:right; letter-spacing:.06em; line-height:1.8; }\n"

      // print
      + "@media print {\n"
      + "  body { background:#fff; color:#111; }\n"
      + "  body::before { display:none; }\n"
      + "  :root {\n"
      + "    --bg:#fff; --surface:#f5f7fa; --surface2:#eef1f6; --border:#d0d8e8;\n"
      + "    --accent:#0066cc; --accent2:#cc2244; --accent3:#996600;\n"
      + "    --text:#111; --text-dim:#666; --text-mid:#444; --green:#007744;\n"
      + "  }\n"
      + "  .status-dot { animation:none; }\n"
      + "  .step-row:hover { background:var(--surface); }\n"
      + "}\n";
}