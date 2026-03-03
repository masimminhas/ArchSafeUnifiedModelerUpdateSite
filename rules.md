# Semantic Validation Rules — `unified.odesign`

Extracted from all `SemanticValidationRule` entries across all `validationSet` blocks in the Sirius ODesign file.

> **Severity Levels:** `ERROR` = must be fixed | `WARNING` = recommended fix | `INFO` = advisory notice

---

## Architecture Diagram (`architectureValidation`)

| Serial # | Model Type | Rule Name | Severity | Rule Description | Rule Purpose |
|----------|------------|-----------|----------|------------------|--------------|
| 1 | `SystemBlock` | `BlockNameRequired` | WARNING | Block name should be defined for better traceability. | Ensures every system block has a non-null, non-empty name to support model traceability. |
| 2 | `BlockConnection` | `ConnectionTypeDefined` | WARNING | Connection type should be specified. | Ensures all block connections carry a typed relationship, preventing ambiguous data/control flow semantics. |
| 3 | `SafetyCriticalBlock` | `CriticalBlockMustHaveHazards` | ERROR | Safety Critical Block must have associated hazards. | Mandates that any block classified as safety-critical is linked to at least one hazard, enforcing the HARA process. |
| 4 | `SafetyCriticalBlock` | `HighCriticalityRequiresFMEA` | ERROR | High Criticality block requires FMEA Analysis. | Ensures that high-criticality safety blocks are covered by an FMEA study before the model is considered complete. |
| 5 | `SystemBlock` | `BlockHasConnections` | INFO | Isolated blocks may indicate incomplete architecture. | Advisory check flagging blocks with no source or target connections as potentially orphaned/incomplete design elements. |
| 6 | `SafetyCriticalBlock` | `ASILDRequires80PercentFMEA` | ERROR | ASIL D blocks require 80% FMEA coverage of failure modes. | Enforces ISO 26262 ASIL D coverage requirements by verifying that at least 80% of failure modes have FMEA entries. |
| 7 | `SystemBlock` | `NoCircularDependencies` | ERROR | Circular dependency detected. This block is part of a cycle that could cause architectural issues. | Detects cyclic dependency chains among system blocks that could lead to unresolvable build or runtime ordering issues. |
| 8 | `SystemBlock` | `BlocksShouldBeConnected` | INFO | This block has no connections. Isolated blocks may indicate incomplete architecture design. | Duplicate advisory (broader message) flagging unconnected blocks across the architecture diagram. |
| 9 | `SystemBlock` | `BlockNameMustBeUnique` | ERROR | Block name must be unique across the model. Duplicate names can cause confusion and traceability issues. | Prevents naming collisions across system blocks to maintain unambiguous element identification and traceability links. |
| 10 | `UnifiedSystemModel` | `ModelTraceabilityAdequate` | WARNING | Model traceability density is below 30%. Consider adding more links between architecture and safety elements. | Monitors overall model-level traceability health, warning when cross-cutting links fall below the 30% density threshold. |
| 11 | `SafetyCriticalBlock` | `CriticalBlockRequiresRedundancy` | ERROR | CRITICAL safety blocks must have redundancy mechanisms defined. | Enforces the architectural safety principle that critical blocks must declare redundancy mechanisms (e.g., dual-channel, fail-safe). |

---

## Safety Diagram (`safetyValidation`)

| Serial # | Model Type | Rule Name | Severity | Rule Description | Rule Purpose |
|----------|------------|-----------|----------|------------------|--------------|
| 12 | `SafetyCriticalBlock` | `SafetyBlockNameRequired` | ERROR | Safety critical block name must be defined. | Enforces that safety-critical blocks carry a valid name, which is a prerequisite for HARA and safety case documentation. |
| 13 | `IntegratedHazard` | `HazardNameRequired` | ERROR | Hazard must have a descriptive name. | Ensures every hazard has a non-null name so it can be uniquely referenced in HARA tables and safety goals. |
| 14 | `IntegratedHazard` | `HazardHasRelatedBlocks` | WARNING | Hazard should be linked to at least one safety-critical block. | Validates that each hazard is traced back to a physical block in the architecture, preventing floating hazard entries. |
| 15 | `BlockFailureMode` | `FailureModeHasEffect` | WARNING | Failure mode should describe its effect. | Requires a non-empty `failureEffect` field on each failure mode to ensure FMEA entries are analytically meaningful. |
| 16 | `IntegratedHazard` | `CriticalHazardMustBeMitigated` | ERROR | Catastrophic hazards must have mitigation strategy. | Mandates that any hazard rated catastrophic (highest severity) is assigned a mitigation strategy before release. |
| 17 | `BlockFailureMode` | `FailureModeHasProperDescription` | WARNING | Failure mode description should be at least 5 characters for clarity and traceability. | Enforces minimum description length to prevent placeholder or one-character failure mode entries. |
| 18 | `SafetyCriticalBlock` | `ASILLevelDefined` | WARNING | Safety-critical blocks should have an ASIL level defined for automotive compliance. | Ensures safety blocks carry an explicit ASIL rating as required by ISO 26262 for automotive functional safety. |
| 19 | `IntegratedHazard` | `CriticalHazardsMustBeMitigated` | ERROR | Critical and catastrophic hazards must have defined mitigation strategies and be linked to safety mechanisms. | Stricter version of rule #16 — also requires a linkage to concrete safety mechanisms, not just a mitigation description. |
| 20 | `IntegratedHazard` | `HazardLinkedToSafetyGoalInDiagram` | WARNING | Hazard is not addressed by any Safety Goal in the Requirements Diagram. [ISO 26262-3 §7.4.3] | Checks cross-diagram traceability: each hazard should be addressed by at least one safety goal in the Requirements Diagram. |

---

## FMEA Diagram (`fmeaValidation`)

| Serial # | Model Type | Rule Name | Severity | Rule Description | Rule Purpose |
|----------|------------|-----------|----------|------------------|--------------|
| 21 | `FMEAItem` | `FMEAItemComplete` | ERROR | FMEA item must have valid S/O/D values (1–10). | Validates that Severity, Occurrence, and Detectability scores are all within the valid 1–10 range for RPN computation. |
| 22 | `FMEAItem` | `FMEAItemHasComponent` | ERROR | FMEA item must be linked to a component. | Ensures every FMEA record is anchored to a system component, preventing orphaned analysis items. |
| 23 | `FMEAItem` | `FMEAItemHasFailureMode` | WARNING | FMEA item should reference a specific failure mode for precise analysis. | Encourages linking each FMEA item to a typed `BlockFailureMode` rather than leaving the failure mode unspecified. |
| 24 | `FMEAItem` | `HighRPNRequiresMitigation` | WARNING | High RPN (>100) requires mitigation action. | Flags items where Risk Priority Number exceeds 100 as needing a documented mitigation action before closure. |
| 25 | `FMEAItem` | `CriticalRPNMustBeAddressed` | ERROR | Critical RPN (>200) must have mitigation action and responsible party assigned. | Escalates the RPN check: items above 200 must have both a mitigation and an assigned responsible owner. |
| 26 | `FMEAItem` | `AutoGeneratedItemsNeedReview` | INFO | This FMEA item was auto-generated. Please review and refine values. | Advisory notice prompting engineers to review automatically generated FMEA entries before treating them as validated data. |
| 27 | `FMEAItem` | `NonSafetyCriticalBlockInFMEA` | WARNING | This FMEA item analyzes a non-safety-critical block. Consider if FMEA analysis is necessary. | Alerts analysts when FMEA coverage is applied to non-safety-critical blocks, which may indicate scope creep or misclassification. |

---

## Requirements Diagram (`requirementsValidation`)

| Serial # | Model Type | Rule Name | Severity | Rule Description | Rule Purpose |
|----------|------------|-----------|----------|------------------|--------------|
| 28 | `SafetyGoal` | `SafetyGoalHasASIL` | ERROR | Safety Goal must have an ASIL level assigned. [ISO 26262-3 §7.4.1] | Enforces ISO 26262-3: every safety goal must carry an ASIL classification derived from HARA. |
| 29 | `Requirement` | `RequirementHasText` | ERROR | Requirement must have requirement text defined. [ISO 26262-2 Annex B] | Prevents requirements with empty text from entering the safety case; text is mandatory per ISO 26262-2. |
| 30 | `SafetyGoal` | `SafetyGoalHasRelatedHazard` | ERROR | Safety Goal must derive from a HARA hazard. No relatedHazard is linked. [ISO 26262-3 §7.4.3.1] | Enforces bi-directional traceability between safety goals and HARA hazards as required by ISO 26262-3. |
| 31 | `SafetyGoal` | `SafetyGoalHasAllocation` | ERROR | Safety Goal must be allocated to at least one Functional Safety Requirement. [ISO 26262-4 §6.4.3] | Ensures the refinement chain from Safety Goal → FSR is present, as required by ISO 26262-4. |
| 32 | `SafetyGoal` | `SafetyGoalHasApprovalStatus` | WARNING | Safety Goal has no approval status. It should be reviewed and approved before baseline. [ISO 26262-2 §6.4.6] | Flags unreviewed safety goals to prevent unvalidated goals from being baselined and released. |
| 33 | `SafetyGoal` | `SafetyGoalNameIsNotEmpty` | ERROR | Safety Goal must have a descriptive name (minimum 3 characters). [ISO 26262-3 §7.4.2] | Ensures safety goals are meaningfully named (at least 3 characters) so they are identifiable in the safety case. |
| 34 | `FunctionalSafetyRequirement` | `FSRMustRefineToTSR` | ERROR | Functional Safety Requirement must be refined to at least one Technical Safety Requirement. [ISO 26262-4 §6.4.5] | Enforces the FSR → TSR derivation chain mandatory by ISO 26262-4 for all functional safety requirements. |
| 35 | `FunctionalSafetyRequirement` | `FSRHasVerificationMethod` | WARNING | Functional Safety Requirement should specify a verification method (test/analysis/inspection). [ISO 26262-4 §7.4.3] | Promotes verification completeness by requiring a designated method (test, analysis, or inspection) for each FSR. |
| 36 | `FunctionalSafetyRequirement` | `FSRASILNotLowerThanGoalWithoutJustification` | ERROR | FSR has a lower ASIL than its parent Safety Goal without ASIL decomposition justification. [ISO 26262-9 §5.3] | Prevents illegal ASIL downgrading: any FSR with a lower ASIL than its parent goal must provide a valid ASIL decomposition rationale per ISO 26262-9. |
| 37 | `TechnicalSafetyRequirement` | `TSRHasSafetyMechanism` | ERROR | Technical Safety Requirement must be implemented by at least one Safety Mechanism. [ISO 26262-4 §7.4.4] | Enforces that every TSR is backed by a concrete safety mechanism, completing the implementation chain. |
| 38 | `TechnicalSafetyRequirement` | `TSRHasVerificationCoverage` | WARNING | Technical Safety Requirement should specify verification coverage (inspection/test-bench/HIL). [ISO 26262-4 §7.4.4] | Encourages specifying the verification method (inspection, test-bench, HIL) for each TSR to support V&V planning. |
| 39 | `TechnicalSafetyRequirement` | `TSRHasASIL` | ERROR | Technical Safety Requirement must have an ASIL level assigned. [ISO 26262-4 §7.4.4] | Ensures ASIL propagation reaches the technical level: every TSR must carry an ASIL rating. |
| 40 | `Requirement` | `RequirementIdMustBeUnique` | ERROR | Requirement ID must be unique across all requirement types (FSR, TSR, SafetyGoal). [ISO 26262-2 §6.4.5.1] | Prevents duplicate requirement identifiers across the entire model, which would break traceability and configuration management. |
| 41 | `Requirement` | `RequirementTextMinLength` | WARNING | Requirement text is too short (minimum 20 characters). Vague requirements create unverifiable safety claims. [ISO 26262-2 Annex B §B.6] | Enforces a 20-character minimum on requirement text to eliminate single-word placeholders that cannot be verified. |
| 42 | `Requirement` | `RequirementHasId` | ERROR | Requirement must have a non-empty identifier (requirementId). [ISO 26262-2 §6.4.5.1] | Mandates that every requirement carries a non-null, non-empty ID as the foundation for traceability. |
| 43 | `SafetyMechanism` | `SafetyMechanismHasDiagnosticCoverage` | ERROR | Safety Mechanism must specify its diagnostic coverage (low/medium/high) for PMHF computation. [ISO 26262-5 §8] | Requires diagnostic coverage classification on safety mechanisms; this value feeds directly into PMHF hardware metric calculations. |
| 44 | `SafetyMechanism` | `SafetyMechanismHasType` | ERROR | Safety Mechanism must have a mechanism type specified (e.g. REDUNDANCY, MONITORING, PLAUSIBILITY_CHECK). [ISO 26262-4 §7.4.4.3] | Ensures each safety mechanism is typed so its effectiveness and applicability can be evaluated during safety assessments. |
| 45 | `SafetyGoal` | `RequirementChainContinuous` | ERROR | The requirement derivation chain from this Safety Goal is broken. Every SafetyGoal must trace SafetyGoal → FSR → TSR → SafetyMechanism without gaps. [ISO 26262-4 §6.4.5] | Validates the full end-to-end requirement chain integrity: SafetyGoal → FSR → TSR → SafetyMechanism must be unbroken. |

---

## Summary

| Validation Set | Diagram | Total Rules | ERRORs | WARNINGs | INFOs |
|----------------|---------|-------------|--------|----------|-------|
| `architectureValidation` | ArchitectureDiagram | 11 | 6 | 3 | 2 |
| `safetyValidation` | SafetyDiagram | 9 | 5 | 4 | 0 |
| `fmeaValidation` | FMEADiagram | 7 | 3 | 3 | 1 |
| `requirementsValidation` | RequirementsDiagram | 18 | 13 | 4 | 1 |  <!-- corrected: 43-45 is 3 more + 28-42 is 15 -->
| **Total** | | **45** | **27** | **14** | **4** |
