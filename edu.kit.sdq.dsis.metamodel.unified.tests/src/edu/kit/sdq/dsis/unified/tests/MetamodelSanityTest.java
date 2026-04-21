package edu.kit.sdq.dsis.unified.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import unified.ASILLevel;
import unified.BlockFailureMode;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.IntegratedHazard;
import unified.RiskLevel;
import unified.SafetyCriticalBlock;
import unified.SafetyGoal;
import unified.SystemBlock;
import unified.UnifiedFactory;
import unified.UnifiedPackage;
import unified.UnifiedSystemModel;

/**
 * Smoke tests against the generated EMF metamodel. These verify that the
 * factory wires up the object tree as declared in {@code unified.ecore}
 * and that the key enumerations expose the expected literals.
 */
public class MetamodelSanityTest {

    @Test
    public void packageRegistersWithCanonicalNsUri() {
        assertEquals("http://edu.kit.sdq.dsis.metamodel/unified", UnifiedPackage.eNS_URI);
        assertNotNull(UnifiedPackage.eINSTANCE);
    }

    @Test
    public void factoryCreatesRootUnifiedSystemModel() {
        UnifiedSystemModel m = UnifiedFactory.eINSTANCE.createUnifiedSystemModel();
        assertNotNull(m);
        assertTrue(m.getRootBlocks().isEmpty());
        assertTrue(m.getSystemBlocks().isEmpty());
        assertTrue(m.getGlobalHazards().isEmpty());
        assertTrue(m.getFmeaAnalysis().isEmpty());
    }

    @Test
    public void asilLevelExposesISO26262Literals() {
        assertEquals(5, ASILLevel.values().length);
        assertNotNull(ASILLevel.get("QM"));
        assertNotNull(ASILLevel.get("ASIL_A"));
        assertNotNull(ASILLevel.get("ASIL_B"));
        assertNotNull(ASILLevel.get("ASIL_C"));
        assertNotNull(ASILLevel.get("ASIL_D"));
    }

    @Test
    public void riskLevelExposesMilStd882Literals() {
        assertEquals(4, RiskLevel.values().length);
        assertNotNull(RiskLevel.get("NEGLIGIBLE"));
        assertNotNull(RiskLevel.get("MARGINAL"));
        assertNotNull(RiskLevel.get("CRITICAL_RISK"));
        assertNotNull(RiskLevel.get("CATASTROPHIC"));
    }

    @Test
    public void safetyCriticalBlockSpecialisesSystemBlock() {
        SafetyCriticalBlock scb = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        assertTrue("SafetyCriticalBlock must be-a SystemBlock", scb instanceof SystemBlock);
    }

    @Test
    public void failureModesAreContainedBySafetyCriticalBlock() {
        SafetyCriticalBlock scb = UnifiedFactory.eINSTANCE.createSafetyCriticalBlock();
        BlockFailureMode fm = UnifiedFactory.eINSTANCE.createBlockFailureMode();
        fm.setName("Stuck-at-1");
        scb.getFailureModes().add(fm);
        assertEquals(1, scb.getFailureModes().size());
        assertEquals("containment parent must be the SCB",
            scb, fm.eContainer());
    }

    @Test
    public void hazardsAreContainedByRootModel() {
        UnifiedSystemModel m = UnifiedFactory.eINSTANCE.createUnifiedSystemModel();
        IntegratedHazard h = UnifiedFactory.eINSTANCE.createIntegratedHazard();
        h.setName("H1: Loss of braking");
        h.setRiskLevel(RiskLevel.CATASTROPHIC);
        m.getGlobalHazards().add(h);
        assertEquals(1, m.getGlobalHazards().size());
        assertEquals(RiskLevel.CATASTROPHIC, m.getGlobalHazards().get(0).getRiskLevel());
    }

    @Test
    public void safetyGoalSupportsASILAllocation() {
        SafetyGoal sg = UnifiedFactory.eINSTANCE.createSafetyGoal();
        sg.setAsilLevel(ASILLevel.ASIL_D);
        assertEquals(ASILLevel.ASIL_D, sg.getAsilLevel());
    }

    @Test
    public void fmeaItemStoresSOD() {
        FMEAAnalysis analysis = UnifiedFactory.eINSTANCE.createFMEAAnalysis();
        FMEAItem item = UnifiedFactory.eINSTANCE.createFMEAItem();
        item.setSeverity(10);
        item.setOccurrence(2);
        item.setDetection(3);
        analysis.getFmeaItems().add(item);
        assertEquals(10, item.getSeverity());
        assertEquals(2,  item.getOccurrence());
        assertEquals(3,  item.getDetection());
        int rpn = item.getSeverity() * item.getOccurrence() * item.getDetection();
        assertEquals("RPN formula: S * O * D", 60, rpn);
    }
}
