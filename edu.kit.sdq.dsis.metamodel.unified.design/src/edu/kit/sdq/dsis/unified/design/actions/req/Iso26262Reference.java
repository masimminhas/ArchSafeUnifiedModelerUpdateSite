package edu.kit.sdq.dsis.unified.design.actions.req;

/**
 * ISO 26262:2018 Clause Reference Catalogue.
 *
 * Every public constant here is a fully-formatted citation string that can be
 * embedded directly into dialog messages, report headers, and CSV cells.
 * The format follows the convention used in formal safety assessments:
 *
 *   ISO 26262-<Part>:<Year> §<Clause>.<Sub> — <Title>
 *
 * Using a single source of truth for these strings ensures that all nine
 * action classes produce consistent, auditor-ready references.
 */
public final class Iso26262Reference {

    private Iso26262Reference() {}

    // ── Part 2: Management of Functional Safety ──────────────────────────────

    /** Part 2 §5.4 — Safety lifecycle phases and work products */
    public static final String PART2_SAFETY_LIFECYCLE =
        "ISO 26262-2:2018 §5.4 — Management of Functional Safety / Safety Lifecycle";

    /** Part 2 §6.4 — Safety plan, documentation, and work product approval */
    public static final String PART2_SAFETY_PLAN =
        "ISO 26262-2:2018 §6.4 — Safety Plan & Work Product Approval";

    /** Part 2 §6.4.9 — Confirmation review of safety work products */
    public static final String PART2_CONFIRMATION_REVIEW =
        "ISO 26262-2:2018 §6.4.9 — Confirmation Review of Safety Work Products";

    // ── Part 3: Concept Phase / HARA ─────────────────────────────────────────

    /** Part 3 §7 — Hazard Analysis and Risk Assessment (HARA) */
    public static final String PART3_HARA =
        "ISO 26262-3:2018 §7 — Hazard Analysis and Risk Assessment (HARA)";

    /** Part 3 §7.4.2 — Identification of hazardous events and their classification */
    public static final String PART3_HARA_CLASSIFICATION =
        "ISO 26262-3:2018 §7.4.2 — Hazardous Event Classification (S/E/C)";

    /** Part 3 §8 — Functional safety concept; Safety goals derived from HARA */
    public static final String PART3_SAFETY_GOALS =
        "ISO 26262-3:2018 §8 — Functional Safety Concept & Safety Goal Definition";

    /** Part 3 §8.4.1 — Safety goal with ASIL assignment */
    public static final String PART3_SAFETY_GOAL_ASIL =
        "ISO 26262-3:2018 §8.4.1 — Safety Goal ASIL Assignment";

    // ── Part 4: Product Development — System Level ────────────────────────────

    /** Part 4 §6 — Technical safety concept */
    public static final String PART4_TECHNICAL_SAFETY_CONCEPT =
        "ISO 26262-4:2018 §6 — Technical Safety Concept";

    /** Part 4 §6.4.5 — Consistency and completeness of safety requirements */
    public static final String PART4_REQ_CONSISTENCY =
        "ISO 26262-4:2018 §6.4.5 — Safety Requirement Consistency & Completeness";

    /** Part 4 §6.4.5.g — Every TSR must be allocated to an architecture element */
    public static final String PART4_TSR_ALLOCATION =
        "ISO 26262-4:2018 §6.4.5.g — TSR Allocation to Architecture Elements";

    /** Part 4 §7 — System design (FSR/TSR derivation and verification) */
    public static final String PART4_SYSTEM_DESIGN =
        "ISO 26262-4:2018 §7 — System Design & Safety Requirements Derivation";

    /** Part 4 §7.4 — Verification of the technical safety concept */
    public static final String PART4_TSR_VERIFICATION =
        "ISO 26262-4:2018 §7.4 — Verification of Technical Safety Requirements";

    // ── Part 8: Supporting Processes ─────────────────────────────────────────

    /** Part 8 §6 — Specification and management of safety requirements */
    public static final String PART8_REQ_MANAGEMENT =
        "ISO 26262-8:2018 §6 — Specification & Management of Safety Requirements";

    /** Part 8 §9 — Configuration management of safety work products */
    public static final String PART8_CONFIG_MANAGEMENT =
        "ISO 26262-8:2018 §9 — Configuration Management of Safety Work Products";

    // ── Part 9: ASIL-Oriented and Safety-Oriented Analyses ───────────────────

    /** Part 9 §5 — Requirements for ASIL decomposition */
    public static final String PART9_ASIL_DECOMPOSITION =
        "ISO 26262-9:2018 §5 — ASIL Decomposition Requirements";

    /** Part 9 §5.4.6 — Valid ASIL decomposition combinations (Table 5) */
    public static final String PART9_ASIL_TABLE5 =
        "ISO 26262-9:2018 §5.4.6 Table 5 — Valid ASIL Decomposition Combinations";

    /** Part 9 §5.4.3 — ASIL inheritance and propagation rules */
    public static final String PART9_ASIL_PROPAGATION =
        "ISO 26262-9:2018 §5.4.3 — ASIL Inheritance & Propagation Rules";

    // ── Work Products (normative references used in reports) ─────────────────

    /** Work product [3-8]: HARA report */
    public static final String WP_3_8_HARA_REPORT =
        "Work Product [3-8]: Hazard Analysis and Risk Assessment Report";

    /** Work product [3-9]: Functional safety concept */
    public static final String WP_3_9_FSC =
        "Work Product [3-9]: Functional Safety Concept";

    /** Work product [4-6]: Technical safety concept (safety requirements) */
    public static final String WP_4_6_TSC =
        "Work Product [4-6]: Technical Safety Concept — Safety Requirements Specification";

    /** Work product [4-7]: System design specification */
    public static final String WP_4_7_SYSTEM_DESIGN =
        "Work Product [4-7]: System Design Specification";

    // ── Shared report header/footer helpers ──────────────────────────────────

    /** Standard ISO 26262 disclaimer appended to all exported reports. */
    public static final String REPORT_DISCLAIMER =
        "NOTE: This report is a tool-generated artefact intended to support the safety " +
        "lifecycle defined in ISO 26262:2018. It does not replace formal safety assessment " +
        "or independent confirmation review as required by " + PART2_CONFIRMATION_REVIEW + ".";

    /**
     * Formats a single compliance-check row for display in a result dialog,
     * including the relevant ISO clause.
     *
     * @param status  "✔ PASS", "✘ FAIL", or "⚠ WARNING"
     * @param check   Short description of what was checked
     * @param clause  The Iso26262Reference constant for the relevant clause
     * @param detail  Optional extra detail; may be null or empty
     */
    public static String checkRow(String status, String check, String clause, String detail) {
        StringBuilder sb = new StringBuilder();
        sb.append(status).append("  ").append(check).append("\n");
        sb.append("       Ref: ").append(clause).append("\n");
        if (detail != null && !detail.trim().isEmpty()) {
            sb.append("       ").append(detail).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns a CSV-safe clause string (wraps in quotes if needed).
     */
    public static String csvClause(String clause) {
        return "\"" + clause.replace("\"", "\"\"") + "\"";
    }
}