# ArchSafe Unified Modeler — Evaluation and Comparison

This document positions **ArchSafe Unified Modeler** against the existing landscape of model-based systems engineering (MBSE) and safety-analysis tools. The goal is to give readers (and reviewers) a clear, honest statement of *where ArchSafe sits*, *what it adds*, and *what it does not attempt to do*.

---

## 1. Scope of the Evaluation

We evaluate ArchSafe along two complementary axes:

1. **Feature coverage** — does the tool natively support the artefacts and analyses demanded by ISO 26262 and related functional-safety standards?
2. **Integration** — are those artefacts editable and traceable inside a *single* metamodel and workbench, or does the user have to federate several disjoint models?

The second axis is the key claim of this work: the literature has mature solutions for each individual concern (architecture, hazards, FMEA, requirements), but integrating them in one consistent, modifiable metamodel with inter-model traceability and live failure-propagation simulation remains rare.

We compare against five tools that a typical safety-engineering paper would cite:

| Short name | Full name | Provider | Licence |
|---|---|---|---|
| **Capella** | Capella + Arcadia | Eclipse / Obeo / Thales | EPL 2.0 |
| **Papyrus-SysML** | Papyrus for SysML 1.x | Eclipse / CEA List | EPL 2.0 |
| **CHESS** | CHESS toolset | POLIMI / Intecs / ESA | EPL 2.0 |
| **EAST-ADL** | EAST-ADL / EATOP | EAST-ADL Association | EPL 2.0 |
| **Medini Analyze** | Medini Analyze | ANSYS | Commercial |
| **ArchSafe** | ArchSafe Unified Modeler | KIT – SDQ Group | EPL 2.0 |

Omitted from the table but acknowledged: **safeTbox** (Fraunhofer IESE), **AltaRica 3**, **HiP-HOPS**, **SAFE-RE**, and **Enterprise Architect + safety plug-ins**. These are either narrower in scope (single analysis technique) or not MBSE-grade modelling workbenches.

## 2. Evaluation Criteria

The criteria were derived from ISO 26262-3 (hazard analysis and risk assessment), ISO 26262-4 (product development at the system level), and the FMEA guidance of AIAG-VDA 1st edition. Each criterion maps to at least one concrete artefact a safety engineer must produce during an ISO 26262 work-product audit:

| Criterion | What it asks | Mapped ISO 26262 clause |
|---|---|---|
| **C1. Architecture modelling** | SysML Block Definition / Internal Block diagrams with typed connections | ISO 26262-4 §6.4.4 |
| **C2. Hazard modelling** | HARA — hazards with risk level, hazard category, mitigation status | ISO 26262-3 §6.4 / §7.4 |
| **C3. ASIL allocation** | Per-block ASIL levels and consistency with derived requirements | ISO 26262-3 §7.4.4 / §8 |
| **C4. Requirement traceability chain** | SafetyGoal → FSR → TSR → SafetyMechanism as first-class, linked model objects | ISO 26262-4 §6 / §7 |
| **C5. FMEA** | S-O-D scoring with RPN, recommended actions, owner, links to failure modes | AIAG-VDA 1st ed.; ISO 26262-5 Annex |
| **C6. Failure-propagation simulation** | Interactive, one-click what-if failure with visual propagation and critical-path extraction | ISO 26262-9 §6 (dependent failure analysis) |
| **C7. Semantic validation rules** | Machine-checked rules aligned with standard clauses, with severity levels | ISO 26262-8 §9 (verification) |
| **C8. Reproducibility artefact** | Docker or one-click install; reference models included | Reviewer expectation |
| **C9. Open availability** | Freely downloadable source + update site under an OSI licence | Reviewer expectation |

A tool gets a "✓" for a criterion only when the capability is **native** — provided out-of-the-box without user-written custom code or third-party integrations. A "◐" means the capability is *reachable* through a separate extension, add-on, or manual federation of two models.

## 3. Comparison Summary

| Criterion | Capella | Papyrus-SysML | CHESS | EAST-ADL | Medini Analyze | **ArchSafe** |
|---|---|---|---|---|---|---|
| C1. Architecture modelling | ✓ (Arcadia) | ✓ (SysML 1.x) | ✓ (via Papyrus) | ✓ (EAST-ADL levels) | ◐ (imports) | ✓ (Block/SCB) |
| C2. Hazard modelling | ◐ (viewpoint add-on) | ◐ (profile) | ✓ | ✓ (Safety Annex) | ✓ | ✓ |
| C3. ASIL allocation | ◐ | ◐ (SafeML) | ✓ | ✓ | ✓ | ✓ |
| C4. Requirement traceability chain | ◐ (ReqIF import) | ◐ (SysML Req) | ✓ | ✓ | ✓ | ✓ |
| C5. FMEA (S/O/D + RPN) | ✗ | ✗ | ◐ | ✗ | ✓ | ✓ |
| C6. Failure-propagation simulation | ✗ | ✗ | ◐ (FLA analysis) | ✗ | ◐ (FTA only) | ✓ (interactive) |
| C7. Semantic validation rules | ◐ (DSL-level) | ◐ (OCL) | ✓ | ✓ | ✓ | ✓ (45 rules) |
| C8. Reproducibility artefact | ✗ | ✗ | ✗ | ✗ | ✗ | ✓ (Docker + 2 case studies) |
| C9. Open availability | ✓ | ✓ | ✓ | ✓ | ✗ (commercial) | ✓ |
| **Native coverage** | **3 / 9** | **2 / 9** | **6 / 9** | **5 / 9** | **6 / 9** | **9 / 9** |

> **How to read this table.** A 9/9 does not mean ArchSafe is "better" than Capella — it means ArchSafe *bundles* these nine capabilities into one workbench. Capella is more mature in what it does natively (Arcadia modelling) and integrates with a much larger ecosystem; the gaps above are filled in industrial practice by third-party viewpoint extensions, ReqIF gateways, or commercial FMEA add-ons that ArchSafe does not need.

## 4. Per-tool Discussion

### 4.1 Capella (Arcadia)

**Strengths.** Capella implements the Arcadia method with four layered viewpoints (operational / system / logical / physical), supports allocation and transition between them, and is used in production by Thales, Airbus, and others. Its Sirius-based visualisation layer is the gold standard that ArchSafe follows.

**Gap.** Capella does *not* natively include an FMEA worksheet, nor an ISO 26262 requirement-chain metamodel, nor a failure-propagation simulator. Safety concerns are added through viewpoint extensions (e.g. Kitalpha add-ons) which produce a federation of models rather than a single EMF container. Requirements are typically imported through ReqIF gateways.

**When you would pick Capella over ArchSafe.** When the primary need is structured Arcadia-style architecture modelling at industrial scale, and when safety analysis will be performed in a separate commercial tool.

### 4.2 Papyrus for SysML

**Strengths.** The canonical, UML-2 / SysML 1.6 compliant modeller. Strong profile mechanism allows defining arbitrary domain-specific stereotypes. Large community and extensive documentation.

**Gap.** Bare Papyrus-SysML has no hazard, FMEA, or failure-propagation concepts. These must be added by loading third-party profiles (SafeML, CHESS-ML, EAST-ADL) and manually wiring cross-model references. The resulting setup is powerful but fragile and requires substantial tool-chain expertise.

**When you would pick Papyrus-SysML over ArchSafe.** When the target audience already reads and writes strict SysML 1.6 and the project can afford to integrate multiple profiles manually.

### 4.3 CHESS

**Strengths.** A research toolset (INCOSE–MBSE-recognised) that extends Papyrus with dedicated safety, reliability, and real-time analysis views. Supports Failure Logic Analysis (FLA) and integrates with analysis engines such as xSAP.

**Gap.** CHESS is more capable than ArchSafe on quantitative safety analysis (state-based reliability computation) but its user-facing workflow is heavier: the user models in Papyrus, applies CHESS stereotypes, then invokes external analysis engines. ArchSafe trades the analytical depth of CHESS for a lighter, one-workbench experience and an interactive simulation instead of batch FLA runs.

**When you would pick CHESS over ArchSafe.** When quantitative reliability and safety-analysis results (MTTF, failure probabilities) are the primary deliverable.

### 4.4 EAST-ADL / EATOP

**Strengths.** Purpose-built for automotive E/E architecture modelling across abstraction layers (Vehicle, Analysis, Design, Implementation), with a formal Safety Annex that covers hazards, safety goals, safety requirements, and safety constraints aligned with ISO 26262.

**Gap.** EAST-ADL's strength is also its constraint: the language is specialised to the automotive E/E domain and presumes downstream AUTOSAR tooling. Cross-domain use (medical devices, industrial automation) requires substantial language trimming. Tooling support has varied over the years.

**When you would pick EAST-ADL over ArchSafe.** When the target artefact is automotive E/E architecture feeding directly into AUTOSAR.

### 4.5 Medini Analyze (ANSYS)

**Strengths.** A certified commercial safety-analysis tool with FMEA, FTA, FMEDA, and ISO 26262 compliance reports built-in. Widely used by Tier-1 suppliers.

**Gap.** Commercial licence (not available for open redistribution), closed metamodel (users cannot customise the element types), and a strong safety-analysis focus without equivalent depth in architecture modelling — typically combined with a SysML tool upstream.

**When you would pick Medini over ArchSafe.** When you need audited, certifiable safety-analysis artefacts for an industrial project with budget for a commercial licence.

### 4.6 ArchSafe — Positioning

ArchSafe does not aim to replace the tools above. It addresses a specific gap:

> A single open-source Eclipse/Sirius workbench that contains architecture, hazards, ASIL allocation, the ISO 26262 requirement chain, FMEA, and an *interactive* failure-propagation simulation in **one** EMF metamodel, with **45 machine-checked validation rules** citing the underlying standard clauses, and ships with a Docker image that is ready in under a minute.

Two distinguishing design choices are worth calling out:

1. **One metamodel, not a federation.** All artefacts extend a single `UnifiedSystemModel` root ([unified.ecore](../edu.kit.sdq.dsis.metamodel.unified/model/unified.ecore)). Cross-references are typed EMF references rather than inter-document links, which (a) keeps the model analysable from a single file, (b) lets EMF-wide tools (OCL, ATL, validation) operate over it without bridges, and (c) eliminates entire classes of integration errors that multi-model approaches exhibit.

2. **Interactive simulation, not batch analysis.** The [Failure Propagation Simulation](USER_GUIDE.md#11-failure-propagation-simulation) view runs BFS propagation in Java (see [FailurePropagationEngine.java](../edu.kit.sdq.dsis.metamodel.unified.design/src/edu/kit/sdq/dsis/unified/design/actions/sim/FailurePropagationEngine.java)) and colours nodes and edges in the Sirius diagram in real time. This trades analytical sophistication (we do not compute MTTF) for immediacy of insight during design review.

## 5. Evaluation on the AEB and Medical Infusion Pump Case Studies

Both case studies were modelled end-to-end in ArchSafe and are shipped with the distribution for reproducibility.

| Metric | AEB | Medical Infusion Pump |
|---|---|---|
| Safety-critical blocks | 6 | 7 |
| System blocks | 4 | 5 |
| Global hazards | 4 | 5 |
| Safety goals | 4 | 4 |
| Functional safety requirements | 4 | 5 |
| Technical safety requirements | 6 | 7 |
| Safety mechanisms | 6 | 6 |
| FMEA items | 6 | 7 |
| Block connections | 10 | 11 |
| Validation rules triggered | 0 ERRORs | 0 ERRORs |
| Failure-propagation simulation verified | ✓ (forward / backward / bidirectional) | ✓ |

The counts above are asserted by the automated test suite in [CaseStudyLoadingTest](../edu.kit.sdq.dsis.metamodel.unified.tests/src/edu/kit/sdq/dsis/unified/tests/CaseStudyLoadingTest.java) and [FailurePropagationEngineTest](../edu.kit.sdq.dsis.metamodel.unified.tests/src/edu/kit/sdq/dsis/unified/tests/FailurePropagationEngineTest.java), so regressions in either the metamodel or the simulation engine are caught by CI.

### What the case studies demonstrate

- **AEB** exercises the ASIL-D path: every primary sensor, fusion ECU, and brake actuator is linked to a `SafetyGoal` through the full SG→FSR→TSR→SafetyMechanism chain, with all `CATASTROPHIC` hazards at least partially mitigated.
- **Medical Infusion Pump** exercises a different safety standard context (IEC 62304 / ISO 14971 framing mapped onto the same metamodel), demonstrating that the concepts are not automotive-specific despite the ASIL vocabulary.

### What they do *not* demonstrate

- **No user study.** We have not measured modelling time, error rates, or learning curve against a control group. This is listed as future work.
- **No scaling evaluation.** The case studies are deliberately small (10–20 blocks) to stay human-readable. We have not exercised ArchSafe on models with hundreds of blocks.
- **No comparative experiment.** We have not asked a group of engineers to model the same system in ArchSafe and in a competitor tool and compared artefacts.

## 6. Threats to Validity

We flag the following limitations so readers can calibrate claims in this document:

- **Feature-based comparison, not user-experience comparison.** The table in §3 reflects tool capabilities as documented by each vendor / project at time of writing. It is not a usability study. A 9/9 row means "covers these concerns natively"; it does not mean "easiest for a novice to learn".
- **Criterion selection bias.** We selected the criteria from ISO 26262 work products, which is the application domain ArchSafe targets. A different domain (e.g. IEC 61508 for process industry, ARP 4761 for aerospace) would motivate a different criterion set and possibly a different ordering.
- **Moving targets.** Capella, Papyrus, CHESS, and EAST-ADL are actively developed; specific features listed as "◐ extension" today may become "✓ native" in future releases.
- **Small case-study sample.** Two case studies cannot establish generality. We plan an industrial study with a Tier-1 automotive supplier as future work.
- **Author involvement.** The evaluation is conducted by the tool authors. We mitigate this by grounding every ArchSafe claim in a public artefact (metamodel file, Sirius descriptor, Java source, validation rule document, test assertion) that a reviewer can inspect directly.

## 7. Conclusion

ArchSafe's contribution is **not** a new safety-analysis algorithm, nor a more expressive architectural language, nor a replacement for Capella or Medini. It is an **integration story**: assemble concepts that the community has scattered across SysML profiles, RAAML, ISO 26262 practice, and FMEA worksheets into a single open, Sirius-based workbench that a graduate engineer can run in Docker in under a minute, and that ships with two case studies, 45 validation rules, and an interactive failure-propagation simulator.

For systems-engineering research groups that want a platform on which to prototype *new* safety viewpoints, or for industrial teams that want a free baseline tool to evaluate internally before investing in a commercial chain, ArchSafe offers a self-contained starting point.

---

## References

- ISO 26262:2018. *Road vehicles — Functional safety*. Parts 1–12.
- AIAG-VDA. *Failure Mode and Effects Analysis (FMEA) Handbook*, 1st ed., 2019.
- OMG. *Risk Analysis and Assessment Modeling Language (RAAML)*, v1.0, 2022.
- OMG. *Systems Modeling Language (SysML)*, v1.6, 2019.
- Voirin, J.-L. *Model-based System and Architecture Engineering with the Arcadia Method*. ISTE Press, 2018. (Capella / Arcadia)
- Lanusse, A., Tanguy, Y., Espinoza, H. et al. *Papyrus UML: an open source toolset for MDA*. ECMFA 2009.
- Mazzini, S., Puri, S., Vardanega, T. *Component-based Architecture Modelling with CHESS*. ISORC 2009.
- Cuenot, P., Frey, P., Johansson, R. et al. *The EAST-ADL Architecture Description Language for Automotive Embedded Software*. MoDELS 2007.
- ANSYS Medini Analyze product documentation. <https://www.ansys.com/products/embedded-software/ansys-medini-analyze>
