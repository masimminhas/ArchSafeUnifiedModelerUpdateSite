# ArchSafe Unified Modeler — User Guide

A step-by-step guide to installing ArchSafe, creating your first model, and using every major view (architecture, safety, FMEA, requirements, traceability, metrics, failure-propagation simulation).

- **Metamodel nsURI:** `http://edu.kit.sdq.dsis.metamodel/unified`
- **Sirius viewpoint:** `UnifiedModeling`
- **Model file extension:** `.unified`
- **Representation file:** `.aird` (Sirius session)

---

## Contents

1. [Installation](#1-installation)
2. [First launch and workspace setup](#2-first-launch-and-workspace-setup)
3. [Opening the bundled case studies](#3-opening-the-bundled-case-studies)
4. [Creating a new model from scratch](#4-creating-a-new-model-from-scratch)
5. [The Architecture Diagram](#5-the-architecture-diagram)
6. [The Safety Diagram](#6-the-safety-diagram)
7. [The Requirements Diagram](#7-the-requirements-diagram)
8. [The FMEA Diagram and FMEA Table](#8-the-fmea-diagram-and-fmea-table)
9. [The Traceability Diagram](#9-the-traceability-diagram)
10. [The Metrics Dashboard](#10-the-metrics-dashboard)
11. [Failure Propagation Simulation](#11-failure-propagation-simulation)
12. [Validation and quality rules](#12-validation-and-quality-rules)
13. [Exporting reports](#13-exporting-reports)
14. [Troubleshooting](#14-troubleshooting)

---

## 1. Installation

Choose one of three distribution channels. All channels bundle the exact same Sirius plug-ins and the two case studies.

### Option A — Pre-built RCP application (recommended for first-time users)

1. Download the archive for your platform from the [latest GitHub release](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/releases):
   - `archsafeunifiedmodeler-linux-gtk-x86_64.zip`
   - `archsafeunifiedmodeler-win32-x86_64.zip`
   - `archsafeunifiedmodeler-macos-x86_64.zip` (Intel) / `-aarch64.zip` (Apple Silicon)
2. Unzip anywhere and launch:
   - Linux: `./ArchSafeUnifiedModeler`
   - Windows: `ArchSafeUnifiedModeler.exe`
   - macOS: `ArchSafeUnifiedModeler.app`
3. Pick a workspace directory when prompted (e.g. `~/archsafe-workspace`).

### Option B — Docker (zero-install, runs in browser)

```bash
docker run -d -p 6080:6080 -p 5900:5900 \
  --name archsafe-modeler \
  ghcr.io/masimminhas/archsafeunifiedmodeler:latest
```

Then open **http://localhost:6080/vnc.html** in any browser. The case-study projects are pre-loaded and already imported into the workspace.

### Option C — Install into an existing Eclipse / Sirius

Requires Eclipse 2023-09 or newer with the *Sirius Specifier Environment*.

1. `Help → Install New Software…`
2. Paste: `https://masimminhas.github.io/ArchSafeUnifiedModelerUpdateSite/`
3. Select **ArchSafe Unified Modeler Feature** and **ArchSafe Unified Modeler Design Feature**, then `Next → Finish → Restart`.

---

## 2. First launch and workspace setup

1. When the workbench opens, switch to the **Modeling perspective**: `Window → Perspective → Open Perspective → Other… → Modeling`.
2. You should now see:
   - **Model Explorer** (left) — browse `.unified` and `.aird` files
   - **Properties** (bottom) — edit the selected element
   - **Palette** (right, once a diagram is open) — contains creation tools
3. Confirm the viewpoint is activated: right-click any `.aird` file in *Model Explorer* → **Viewpoints Selection…** and tick ☑ **UnifiedModeling**.

---

## 3. Opening the bundled case studies

Two ready-to-explore projects ship with ArchSafe:

| Case study | Folder | Domain |
|---|---|---|
| Autonomous Emergency Braking (AEB) | [casestudies/edu.kit.sdq.dsis.unified.casestudy.automotive/](../casestudies/edu.kit.sdq.dsis.unified.casestudy.automotive/) | ISO 26262 automotive |
| Medical Infusion Pump | [casestudies/edu.kit.sdq.dsis.unified.casestudy.medical/](../casestudies/edu.kit.sdq.dsis.unified.casestudy.medical/) | IEC 62304 / ISO 14971 medical |

**Importing them (RCP or plain Eclipse):**

1. `File → Import… → General → Existing Projects into Workspace`
2. Point to the `casestudies/` directory and select both projects
3. Expand the project → double-click the `.aird` file → double-click any representation listed under it (e.g. *AEB System Architecture*).

In the Docker image the projects are already imported; just expand them in *Model Explorer*.

---

## 4. Creating a new model from scratch

1. `File → New → Project… → General → Project` — name it e.g. `my-aeb-study`.
2. Right-click the project → `New → Other… → Unified → Unified Model`. Name the file `system.unified` and pick `UnifiedSystemModel` as the model object. This gives you the root container.
3. Right-click the project → `New → Representations File`. Name it `system.aird` and add `system.unified` as the semantic resource. Tick **UnifiedModeling** in the viewpoint list.
4. In *Model Explorer*, expand `system.aird` → `UnifiedSystemModel` → right-click → `New Representation → ArchitectureDiagram`.

You now have a blank **ArchitectureDiagram** ready for modeling. A typical workflow from this point is:

> Architecture → Safety → Requirements → FMEA → Traceability → Simulation

The next six sections walk through each stage.

---

## 5. The Architecture Diagram

**Purpose:** System Block Definition (BDD)-style view showing `SystemBlock`s, `SafetyCriticalBlock`s, and the connections between them.

### 5.1 Creating blocks

From the palette (tool section **ArchitectureModeling**):

| Tool | Creates |
|---|---|
| `System Block` | `SystemBlock` (generic component) |
| `Safety Critical Block` | `SafetyCriticalBlock` (has ASIL level, redundancy type, failure modes) |
| `Block Connection` | Typed edge: DATA_FLOW / CONTROL_FLOW / POWER_FLOW / SIGNAL_FLOW / MECHANICAL |
| `Block Association` | Typed edge: DEPENDENCY / AGGREGATION / COMPOSITION / ASSOCIATION / REALIZATION |

### 5.2 Filling in properties

Select a block → *Properties* view → set:

- **Name**, **Description**
- **blockType** (`CONTROLLER`, `SENSOR`, `ACTUATOR`, `COMMUNICATION`, `STORAGE`, `PROCESSING_UNIT`, `POWER_SUPPLY`, `USER_INTERFACE`)
- For `SafetyCriticalBlock` also: **asilLevel** (`QM`, `ASIL_A`…`ASIL_D`), **safetyCriticality**, **hasRedundancy**, **redundancyType** (`COLD`, `HOT`, `TMR`, `DIVERSIFIED`)

### 5.3 Running analysis from the Architecture diagram

Right-click the diagram background → **Analysis**:

- **Validate Consistency** — runs the architecture rule set (BlockNameRequired, NoCircularDependencies, CriticalBlockRequiresRedundancy, …)
- **Compute Model Metrics** — populates `analysisMetadata` fields
- **Export Metrics Report** — writes an HTML/CSV report
- **Block Analysis** — impact analysis for the selected block
- **Export Architecture** — exports diagram as image + EMF model listing

---

## 6. The Safety Diagram

**Purpose:** Identify hazards, attach failure modes to blocks, and draw mitigation links.

Open via *Model Explorer* → right-click `UnifiedSystemModel` → `New Representation → SafetyDiagram`.

### 6.1 Palette (tool section **Safety Analysis Tools**)

| Tool | Creates |
|---|---|
| `Safety Critical Block` | `SafetyCriticalBlock` container (shows failure modes as sub-list) |
| `Integrated Hazard` | `IntegratedHazard` node |
| `Failure Mode` | `BlockFailureMode` inside the selected block |
| `Hazard to Block Relation` | Edge linking a hazard to one or more affected blocks |

### 6.2 Hazard properties to set

- **riskLevel**: `NEGLIGIBLE`, `MARGINAL`, `CRITICAL_RISK`, `CATASTROPHIC`
- **hazardCategory**: `LOSS_OF_FUNCTION`, `UNINTENDED_FUNCTION`, `ERRONEOUS_OUTPUT`, `TIMING_FAILURE`, …
- **mitigationStatus**: `UNMITIGATED`, `PARTIALLY_MITIGATED`, `MITIGATED`
- **severityJustification**: free-text rationale (required for audit trail)

### 6.3 One-click actions (tool section **🔬 Safety Analysis**)

Right-click the diagram background:

- **Validate Safety Requirements** — runs the safety rule set
- **Generate FMEA Analysis** — auto-creates FMEA items from every failure mode
- **Analyze Hazard Coverage** — reports hazards not yet linked to a mitigation chain

---

## 7. The Requirements Diagram

**Purpose:** Capture the ISO 26262-4 chain: **Safety Goal → Functional Safety Requirement → Technical Safety Requirement → Safety Mechanism**.

Open via `New Representation → RequirementsDiagram`.

### 7.1 Palette (tool section **Requirements Tools**)

Create `SafetyGoal`, `FunctionalSafetyRequirement`, `TechnicalSafetyRequirement`, `SafetyMechanism` and the refinement edges between them.

Each element must have:

- **requirementId** (e.g. `SG-AEB-001`)
- **requirementText**
- **status** (`DRAFT`, `UNDER_REVIEW`, `APPROVED`, `IMPLEMENTED`, `VERIFIED`, `DEPRECATED`)
- **verificationMethod** (`INSPECTION`, `ANALYSIS`, `SIMULATION`, `TEST`, `FORMAL_PROOF`)
- **asilLevel** (goals) / **allocatedASIL** (TSRs)

### 7.2 ISO 26262 actions

- **ISO 26262 Validation** tool section: validates that every safety goal has at least one FSR, every FSR at least one TSR, every TSR at least one safety mechanism, and that ASIL levels are consistent along the chain.
- **ISO 26262 Reports**: exports a compliance matrix you can paste into a safety case.

---

## 8. The FMEA Diagram and FMEA Table

### 8.1 FMEA Diagram

Open via `New Representation → FMEADiagram`. Each `FMEAItem` is shown as a card with S/O/D and the computed RPN. Color coding:

- **Green**: RPN ≤ 50
- **Yellow**: 51–100
- **Red**: RPN > 100 (mitigation required)

Palette (tool section **FMEA Analysis**): `FMEA Item` creates a new row, then link it to the analyzed component and failure mode via the *Properties* view.

### 8.2 FMEA Table (preferred for bulk editing)

Right-click `UnifiedSystemModel` → `New Representation → FMEATable`. This gives you a spreadsheet-style editor with columns:

| Column | Meaning |
|---|---|
| Name / Description | Free-text |
| Component | Block being analyzed |
| Failure Mode | Linked `BlockFailureMode` |
| Local / System Effect | What happens locally vs. at system level |
| S / O / D | Severity, Occurrence, Detection (1–10) |
| RPN | Auto-computed = S × O × D |
| Recommended Action | Mitigation |
| Action Status | `OPEN`, `IN_PROGRESS`, `COMPLETED` |
| Responsible / Due Date | Ownership |
| Validates Mechanisms | Link back to `SafetyMechanism`s |

### 8.3 Automation (tool section **Automation and Export**)

Right-click the table / diagram background:

- **Generate FMEA Analysis** (from Safety Diagram) — auto-seeds rows from failure modes
- **Export FMEA Report** — CSV / HTML export

---

## 9. The Traceability Diagram

**Purpose:** Visualize cross-cutting links between hazards, requirements, blocks, failure modes, FMEA items, and safety mechanisms.

Open via `New Representation → TraceabilityDiagram`.

### Navigation (tool section **🔍 Navigate Trace Chain**)

Right-click any element:

- **Show full forward chain** — from safety goal down to implementing blocks
- **Show full backward chain** — from a block up to governing safety goals
- Useful for answering reviewer questions like *"which hazards are not covered by an approved safety mechanism?"*

---

## 10. The Metrics Dashboard

Two representations summarize model health:

- **MetricsTableDashboard** (diagram) — colored tiles for each metric
- **MetricsDashboard** (table) — tabular form suitable for export

Metrics computed (stored in `analysisMetadata`):

| Metric | Meaning |
|---|---|
| `completenessScore` | % of required attributes filled |
| `consistencyScore` | % of validation rules passing |
| `hazardCoverage` | fraction of hazards with at least one mitigation |
| `fmeaCoverage` | fraction of failure modes analyzed by an FMEA item |
| `traceabilityDensity` | edges / expected edges across the model |
| `cyclomaticComplexity` | connection-graph complexity |
| `mcr`, `hti`, `rar`, `flc`, `tds`, `mvr` | derived safety indices (see [rules.md](../rules.md)) |

The **📊 Metrics Actions** section provides `Refresh Metrics` and `Export Detailed Metrics Report`.

---

## 11. Failure Propagation Simulation

This is ArchSafe's signature view: execute a **what-if** failure and watch it propagate through the architecture.

Open via `New Representation → FailurePropagationSimulation`.

### 11.1 Visual encoding

| Node style | Meaning |
|---|---|
| Light blue / yellow | Normal (no failure active) |
| 🟥 Red, thick border, `💥 [FAILURE SOURCE]` label | Block you triggered |
| 🟧 Orange, `⚡ [PROPAGATED]` label | Reached by propagation |
| Red thick edge with `⚡` prefix | Connection carrying the propagation |

### 11.2 Running a simulation (tool section **🔴 Simulation Control**)

Right-click a block:

- **💥 Trigger Failure from Selected Block** — forward propagation (downstream)
- **⚙️ Trigger from Failure Mode…** — choose which specific `BlockFailureMode` fires
- **↔ Bidirectional Propagation** — propagate both upstream and downstream
- **↺ Reset Simulation** — clear all highlighting

### 11.3 Analysis after simulation (tool section **📊 Simulation Analysis**)

- **📋 Show Propagation Report** — dialog listing every block and edge reached, in order
- **🔴 Identify Critical Propagation Path** — longest path through safety-critical blocks
- **💾 Export Simulation Report** — write the propagation trace to disk for inclusion in a safety case

### 11.4 Optional layer: Activated Hazards

The diagram has an additional layer **☢ Show Activated Hazards**. Enable it (`Layers` button on the diagram toolbar) to also see which `IntegratedHazard`s are reached by the currently active propagation — directly closing the loop between architecture failures and hazard activation.

---

## 12. Validation and quality rules

ArchSafe ships **45 semantic validation rules** across four rule sets (architecture, safety, FMEA, requirements). The full catalogue with severity levels and ISO 26262 citations is in [rules.md](../rules.md).

Two ways to run validation:

1. **In-diagram** — right-click background → `Analysis → Validate Consistency` (or `Validate Safety Requirements` on the Safety diagram)
2. **On the model** — right-click any `.unified` file → `Validate`

Results appear in the *Problems* view. Double-click a problem to jump to the offending element.

Key rules to watch:

- `CriticalBlockMustHaveHazards` (ERROR) — every `SafetyCriticalBlock` needs at least one hazard link
- `ASILDRequires80PercentFMEA` (ERROR) — ASIL D blocks need ≥ 80% FMEA coverage of their failure modes
- `CriticalHazardMustBeMitigated` (ERROR) — `CATASTROPHIC` hazards must have a safety mechanism
- `CriticalRPNMustBeAddressed` (ERROR) — any FMEA item with RPN > 200 must have an owner and a due date
- `NoCircularDependencies` (ERROR) — block graph must be acyclic for the chosen connection type

---

## 13. Exporting reports

Every major view has an **Export** action in its tool palette:

| From | Produces |
|---|---|
| Architecture Diagram → *Export Architecture* | Diagram PNG + architecture summary |
| Safety Diagram → *Analyze Hazard Coverage* | Hazard coverage report |
| FMEA Table → *Export FMEA Report* | CSV/HTML FMEA worksheet |
| Requirements Diagram → *ISO 26262 Reports* | Compliance matrix |
| Metrics Dashboard → *Export Detailed Metrics Report* | HTML quality report |
| Failure Propagation Simulation → *Export Simulation Report* | Trace + critical-path report |

All exports land in a `reports/` folder under the project by default.

---

## 14. Troubleshooting

| Symptom | Fix |
|---|---|
| Palette is empty | The viewpoint isn't active. Right-click the `.aird` → *Viewpoints Selection…* → tick **UnifiedModeling**. |
| Right-click actions missing | You opened a plain EMF reflective editor, not a Sirius diagram. Always double-click a representation under the `.aird`, not the `.unified` file directly. |
| `Failure Propagation Simulation` shows no highlights after trigger | The simulation state is stored in the `.aird`. Save the session (Ctrl-S) then re-trigger. If still empty, run *Reset Simulation* first. |
| Validation rules don't fire | Verify *Live Validation* is enabled: `Window → Preferences → Model Validation → Constraints`. All ArchSafe constraints should be checked. |
| Docker image shows a black VNC screen | Wait ~20 s for Sirius to finish initializing on first launch; then refresh `http://localhost:6080/vnc.html`. |
| On macOS, the app is "damaged" / cannot be opened | `xattr -cr /Applications/ArchSafeUnifiedModeler.app` once, then re-launch. The release builds are not notarized. |

---

## Further reading

- **Metamodel reference:** [unifiedmetamodel.pdf](unifiedmetamodel.pdf) — full class diagram of the unified metamodel
- **Validation rules:** [rules.md](../rules.md) — all 45 rules with ISO 26262 citations
- **Case studies:** [casestudies/README.md](../casestudies/README.md) — AEB and infusion-pump walk-throughs
- **Issues / questions:** <https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/issues>
