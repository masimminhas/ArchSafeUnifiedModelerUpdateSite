package edu.kit.sdq.dsis.unified.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import unified.UnifiedSystemModel;

/**
 * Verifies that the bundled AEB and medical infusion-pump case studies
 * round-trip through EMF/XMI cleanly and expose the expected headline counts.
 * These tests are intentionally coupled to the shipped reference models — if
 * the fixtures change, update the expected values here too.
 */
public class CaseStudyLoadingTest {

    @Test
    public void aebModelLoadsWithExpectedShape() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        assertNotNull(m);
        assertEquals("Automotive AEB Model", m.getName());
        assertEquals("AEB ships with 6 safety-critical blocks", 6, m.getRootBlocks().size());
        assertEquals("AEB ships with 4 auxiliary system blocks", 4, m.getSystemBlocks().size());
        assertEquals("AEB ships with 4 global hazards",           4, m.getGlobalHazards().size());
        assertEquals("AEB ships with 1 FMEA analysis",            1, m.getFmeaAnalysis().size());
        assertEquals("AEB ships with 4 safety goals",             4, m.getSafetyGoals().size());
        assertEquals("AEB ships with 4 FSRs",                     4, m.getFunctionalRequirements().size());
        assertEquals("AEB ships with 6 TSRs",                     6, m.getTechnicalRequirements().size());
        assertEquals("AEB ships with 6 safety mechanisms",        6, m.getSafetyMechanisms().size());
        assertEquals("AEB ships with 10 block connections",       10, m.getBlockConnections().size());
    }

    @Test
    public void medicalModelLoadsAsUnifiedSystemModel() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.MEDICAL_RESOURCE);
        assertNotNull(m);
        assertFalse("medical model should ship with root blocks",  m.getRootBlocks().isEmpty());
        assertFalse("medical model should ship with hazards",      m.getGlobalHazards().isEmpty());
        assertFalse("medical model should ship with safety goals", m.getSafetyGoals().isEmpty());
    }

    @Test
    public void aebFmeaHasAtLeastOneItemPerSafetyCriticalBlock() throws Exception {
        UnifiedSystemModel m = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        assertTrue("FMEA analysis must contain items",
            !m.getFmeaAnalysis().get(0).getFmeaItems().isEmpty());
    }
}
