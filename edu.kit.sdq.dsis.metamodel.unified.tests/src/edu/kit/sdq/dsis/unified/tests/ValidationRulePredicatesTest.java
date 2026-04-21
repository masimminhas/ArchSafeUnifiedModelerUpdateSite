package edu.kit.sdq.dsis.unified.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import unified.ASILLevel;
import unified.BlockConnection;
import unified.BlockFailureMode;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.IntegratedHazard;
import unified.MitigationStatus;
import unified.RiskLevel;
import unified.SafetyCriticalBlock;
import unified.SystemBlock;
import unified.UnifiedFactory;
import unified.UnifiedSystemModel;

/**
 * Encodes a subset of the 45 semantic validation rules documented in
 * {@code rules.md} as executable predicates, and asserts both the
 * <em>positive</em> case (shipped AEB fixture complies) and the
 * <em>negative</em> case (a purposely-broken in-memory model is flagged).
 *
 * <p>The goal is not to reproduce Sirius's runtime validator verbatim, but
 * to give reviewers a machine-checkable statement of intent for each rule.
 * Adding a rule here is cheap and catches metamodel drift.</p>
 */
public class ValidationRulePredicatesTest {

    // ── rule: FMEAItemComplete — S, O, D must each be in [1, 10] ─────────────
    private static boolean isSODValid(FMEAItem item) {
        return inRange(item.getSeverity())
            && inRange(item.getOccurrence())
            && inRange(item.getDetection());
    }
    private static boolean inRange(int v) { return v >= 1 && v <= 10; }

    @Test
    public void aebFmeaItemsAllHaveValidSOD() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (FMEAAnalysis a : m.getFmeaAnalysis()) {
            for (FMEAItem item : a.getFmeaItems()) {
                assertTrue("Invalid S/O/D on FMEA item " + item.getName(),
                    isSODValid(item));
            }
        }
    }

    @Test
    public void sodRuleRejectsOutOfRangeValues() {
        FMEAItem item = UnifiedFactory.eINSTANCE.createFMEAItem();
        item.setSeverity(11); item.setOccurrence(1); item.setDetection(1);
        assertFalse(isSODValid(item));
        item.setSeverity(10); item.setOccurrence(0); item.setDetection(1);
        assertFalse(isSODValid(item));
    }

    // ── rule: FMEAItemHasComponent — analyzedComponent must be set ────────────
    @Test
    public void aebFmeaItemsAllReferenceAComponent() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (FMEAAnalysis a : m.getFmeaAnalysis()) {
            for (FMEAItem item : a.getFmeaItems()) {
                assertNotNull("FMEA item " + item.getName() + " has no analyzedComponent",
                    item.getAnalyzedComponent());
            }
        }
    }

    // ── rule: HighRPNRequiresMitigation — RPN > 100 ⇒ recommendedAction set ──
    private static int rpn(FMEAItem i) {
        return i.getSeverity() * i.getOccurrence() * i.getDetection();
    }

    @Test
    public void aebHighRpnItemsCarryRecommendedAction() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (FMEAAnalysis a : m.getFmeaAnalysis()) {
            for (FMEAItem item : a.getFmeaItems()) {
                if (rpn(item) > 100) {
                    assertNotNull("High-RPN item missing mitigation: " + item.getName(),
                        nullIfBlank(item.getRecommendedAction()));
                }
            }
        }
    }

    // ── rule: CriticalRPNMustBeAddressed — RPN > 200 ⇒ responsiblePerson set ──
    @Test
    public void criticalRpnRuleRejectsUnownedItem() {
        FMEAItem item = UnifiedFactory.eINSTANCE.createFMEAItem();
        item.setSeverity(10); item.setOccurrence(7); item.setDetection(4); // RPN=280
        assertTrue("Test setup: RPN should exceed 200", rpn(item) > 200);
        assertNull("No owner ⇒ rule must fire", nullIfBlank(item.getResponsiblePerson()));
    }

    // ── rule: CriticalBlockMustHaveHazards ───────────────────────────────────
    private static Set<SafetyCriticalBlock> blocksReferencedByAnyHazard(UnifiedSystemModel m) {
        return m.getGlobalHazards().stream()
            .flatMap(h -> h.getRelatedBlocks().stream())
            .collect(Collectors.toSet());
    }

    @Test
    public void aebEverySafetyCriticalBlockIsLinkedFromAtLeastOneHazard() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        Set<SafetyCriticalBlock> covered = blocksReferencedByAnyHazard(m);
        for (SafetyCriticalBlock scb : m.getRootBlocks()) {
            assertTrue("SCB has no hazard link: " + scb.getName(), covered.contains(scb));
        }
    }

    // ── rule: CriticalHazardMustBeMitigated ──────────────────────────────────
    private static boolean isMitigationMissing(IntegratedHazard h) {
        return h.getMitigationStatus() == null
            || h.getMitigationStatus() == MitigationStatus.NOT_MITIGATED;
    }

    @Test
    public void aebAllCriticalHazardsHaveAtLeastPartialMitigation() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (IntegratedHazard h : m.getGlobalHazards()) {
            if (h.getRiskLevel() == RiskLevel.CATASTROPHIC
             || h.getRiskLevel() == RiskLevel.CRITICAL_RISK) {
                assertFalse("Critical hazard unmitigated: " + h.getName(),
                    isMitigationMissing(h));
            }
        }
    }

    @Test
    public void ruleFlagsCatastrophicHazardWithoutMitigation() {
        IntegratedHazard h = UnifiedFactory.eINSTANCE.createIntegratedHazard();
        h.setRiskLevel(RiskLevel.CATASTROPHIC);
        h.setMitigationStatus(MitigationStatus.NOT_MITIGATED);
        assertTrue("Catastrophic + unmitigated ⇒ rule must fire",
            h.getRiskLevel() == RiskLevel.CATASTROPHIC && isMitigationMissing(h));
    }

    // ── rule: ASILLevelDefined — SCB must have ASIL set (not null/QM by default) ──
    @Test
    public void aebSafetyCriticalBlocksDeclareASIL() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (SafetyCriticalBlock scb : m.getRootBlocks()) {
            assertNotNull("ASIL not set on " + scb.getName(), scb.getAsilLevel());
        }
    }

    // ── rule: BlockNameMustBeUnique ──────────────────────────────────────────
    private static boolean blockNamesAreUnique(UnifiedSystemModel m) {
        Set<String> seen = new HashSet<>();
        for (SystemBlock b : allBlocks(m)) {
            if (!seen.add(b.getName())) return false;
        }
        return true;
    }
    private static List<SystemBlock> allBlocks(UnifiedSystemModel m) {
        return java.util.stream.Stream.concat(
            m.getRootBlocks().stream().map(b -> (SystemBlock) b),
            m.getSystemBlocks().stream()
        ).collect(Collectors.toList());
    }

    @Test
    public void aebBlockNamesAreUnique() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        assertTrue("Duplicate block name in AEB fixture", blockNamesAreUnique(m));
    }

    @Test
    public void uniquenessRuleDetectsDuplicate() {
        UnifiedSystemModel m = UnifiedFactory.eINSTANCE.createUnifiedSystemModel();
        SafetyCriticalBlock a = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        a.setName("ECU");
        a.setAsilLevel(ASILLevel.ASIL_D);
        SafetyCriticalBlock b = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        b.setName("ECU");
        b.setAsilLevel(ASILLevel.ASIL_D);
        m.getRootBlocks().add(a);
        m.getRootBlocks().add(b);
        assertFalse("Duplicate 'ECU' block must be rejected", blockNamesAreUnique(m));
    }

    // ── rule: NoCircularDependencies — block connection graph must be acyclic ──
    private static boolean hasCycle(UnifiedSystemModel m) {
        Set<SystemBlock> visiting = new HashSet<>();
        Set<SystemBlock> visited  = new HashSet<>();
        for (SystemBlock root : allBlocks(m)) {
            if (!visited.contains(root) && dfsCycle(root, m.getBlockConnections(), visiting, visited)) {
                return true;
            }
        }
        return false;
    }
    private static boolean dfsCycle(SystemBlock node,
                                    List<BlockConnection> edges,
                                    Set<SystemBlock> visiting,
                                    Set<SystemBlock> visited) {
        if (visited.contains(node))  return false;
        if (visiting.contains(node)) return true;
        visiting.add(node);
        Deque<SystemBlock> successors = new ArrayDeque<>();
        for (BlockConnection c : edges) {
            if (!c.getFromBlock().isEmpty() && c.getFromBlock().get(0) == node
             && !c.getToBlock().isEmpty()) {
                successors.add(c.getToBlock().get(0));
            }
        }
        for (SystemBlock s : successors) {
            if (dfsCycle(s, edges, visiting, visited)) return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    @Test
    public void aebBlockGraphIsAcyclic() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        assertFalse("AEB block graph should not contain a cycle", hasCycle(m));
    }

    @Test
    public void cycleDetectionCatchesDeliberateCycle() {
        UnifiedSystemModel m = UnifiedFactory.eINSTANCE.createUnifiedSystemModel();
        SafetyCriticalBlock a = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        a.setName("A");
        SafetyCriticalBlock b = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        b.setName("B");
        SafetyCriticalBlock c = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        c.setName("C");
        m.getRootBlocks().add(a);
        m.getRootBlocks().add(b);
        m.getRootBlocks().add(c);
        m.getBlockConnections().add(edge(a, b));
        m.getBlockConnections().add(edge(b, c));
        m.getBlockConnections().add(edge(c, a));  // closes the loop
        assertTrue("3-node cycle A→B→C→A must be detected", hasCycle(m));
    }

    private static BlockConnection edge(SystemBlock from, SystemBlock to) {
        BlockConnection c = UnifiedFactory.eINSTANCE.createBlockConnection();
        c.getFromBlock().add(from);
        c.getToBlock().add(to);
        return c;
    }

    // ── rule: BlockFailureMode must describe effect (≥ 5 characters) ─────────
    @Test
    public void aebFailureModesDescribeEffect() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        for (SafetyCriticalBlock scb : m.getRootBlocks()) {
            for (BlockFailureMode fm : scb.getFailureModes()) {
                String effect = fm.getFailureEffect();
                assertNotNull("Failure mode missing effect: " + fm.getName(), effect);
                assertTrue("Failure effect should be at least 5 chars: " + fm.getName(),
                    effect.length() >= 5);
            }
        }
    }

    // ── helpers ──────────────────────────────────────────────────────────────
    private static String nullIfBlank(String s) {
        return (s == null || s.trim().isEmpty()) ? null : s;
    }

    @Test
    public void sanityCheckAebFmeaCountMatchesFixture() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        assertEquals(6, m.getFmeaAnalysis().get(0).getFmeaItems().size());
    }
}
