package edu.kit.sdq.dsis.unified.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import edu.kit.sdq.dsis.unified.design.actions.sim.FailurePropagationEngine;
import edu.kit.sdq.dsis.unified.design.actions.sim.SimulationState;
import unified.SafetyCriticalBlock;
import unified.SystemBlock;
import unified.UnifiedSystemModel;

/**
 * End-to-end tests for the failure-propagation simulation engine.
 *
 * <p>The AEB fixture has a well-defined connection topology (10 edges,
 * 10 blocks), so propagation counts are deterministic and can be asserted
 * exactly. See the ASCII diagram in {@link #aebTopologyDocumentation()}.</p>
 */
public class FailurePropagationEngineTest {

    private UnifiedSystemModel model;
    private FailurePropagationEngine engine;

    @Before
    public void loadModel() throws Exception {
        model = TestSupport.loadBundledModel(TestSupport.AEB_RESOURCE);
        engine = new FailurePropagationEngine(model);
        SimulationState.getInstance().clear();
    }

    /** Fluent lookup: find a block by its display name in either collection. */
    private SystemBlock block(String name) {
        return Stream.concat(
                model.getRootBlocks().stream().map(b -> (SystemBlock) b),
                model.getSystemBlocks().stream())
            .filter(b -> name.equals(b.getName()))
            .findFirst()
            .orElseThrow(() -> new AssertionError("No block named '" + name + "' in AEB fixture"));
    }

    @Test
    public void forwardFromRadarReachesFusionEcuAndActuators() {
        SystemBlock radar = block("Front Radar Sensor");
        SimulationState state = engine.propagate(radar, "forward");

        assertEquals("Radar itself should be the only source", 1, state.sourceCount());
        assertEquals("Forward from radar reaches fusion, ECU, brake, HMI, memory",
            5, state.propagatedCount());

        assertTrue(state.isSource(radar));
        assertTrue(state.isPropagated(block("Sensor Fusion ECU")));
        assertTrue(state.isPropagated(block("AEB Control ECU")));
        assertTrue(state.isPropagated(block("Hydraulic Brake Actuator")));
        assertTrue(state.isPropagated(block("Driver HMI")));
        assertTrue(state.isPropagated(block("Non-Volatile Memory")));

        assertFalse("Camera is upstream of fusion — not reachable going forward from radar",
            state.isPropagated(block("Front Camera")));
        assertFalse("Power supply is upstream of radar — not reachable going forward",
            state.isPropagated(block("Power Supply Unit")));
    }

    @Test
    public void backwardFromBrakeActuatorReachesAllUpstreamSources() {
        SystemBlock brake = block("Hydraulic Brake Actuator");
        SimulationState state = engine.propagate(brake, "backward");

        assertEquals(1, state.sourceCount());
        // upstream of brake = {ECU, fusion, power, can_bus, radar, camera, vehicle_speed}
        assertEquals("Backward from brake actuator reaches 7 upstream blocks",
            7, state.propagatedCount());

        assertTrue(state.isPropagated(block("AEB Control ECU")));
        assertTrue(state.isPropagated(block("Sensor Fusion ECU")));
        assertTrue(state.isPropagated(block("Power Supply Unit")));
        assertTrue(state.isPropagated(block("CAN Bus Gateway")));
        assertTrue(state.isPropagated(block("Front Radar Sensor")));
        assertTrue(state.isPropagated(block("Front Camera")));
        assertTrue(state.isPropagated(block("Vehicle Speed Sensor")));

        assertFalse("HMI is downstream of ECU — not reachable going backward from brake",
            state.isPropagated(block("Driver HMI")));
        assertFalse("Memory is downstream of ECU — not reachable going backward from brake",
            state.isPropagated(block("Non-Volatile Memory")));
    }

    @Test
    public void bidirectionalFromFusionCoversEntireConnectedGraph() {
        SystemBlock fusion = block("Sensor Fusion ECU");
        SimulationState state = engine.propagate(fusion, "bidirectional");

        assertEquals(1, state.sourceCount());
        // Fusion is centrally connected; bidirectional should reach every other block.
        int totalBlocks = model.getRootBlocks().size() + model.getSystemBlocks().size();
        assertEquals("Bidirectional from fusion reaches every other block in the graph",
            totalBlocks - 1, state.propagatedCount());
    }

    @Test
    public void beginSimulationResetsPreviousState() {
        // First run: forward from radar → 5 propagated blocks
        SimulationState first = engine.propagate(block("Front Radar Sensor"), "forward");
        assertEquals(5, first.propagatedCount());

        // Second run: forward from brake actuator → 0 propagated (no outbound edges)
        SimulationState second = engine.propagate(block("Hydraulic Brake Actuator"), "forward");
        assertEquals("Brake actuator has no outbound connections", 0, second.propagatedCount());
        assertEquals("New source count must be 1, not 2 (state should reset)",
            1, second.sourceCount());
    }

    @Test
    public void propagationLogRecordsDepthAndDirection() {
        SimulationState state = engine.propagate(block("Front Radar Sensor"), "forward");
        assertFalse(state.getLog().isEmpty());
        // First log entry must have depth 1 (fusion is radar's immediate neighbour)
        SimulationState.PropagationStep first = state.getLog().get(0);
        assertEquals(1, first.depth);
        assertNotNull(first.fromBlockName);
        assertNotNull(first.toBlockName);
    }

    @Test
    public void ecuIsAsilD() {
        // Quick schema check that the fixture is shaped as the propagation tests expect.
        SafetyCriticalBlock ecu = (SafetyCriticalBlock) block("AEB Control ECU");
        assertEquals(unified.ASILLevel.ASIL_D, ecu.getAsilLevel());
    }

    /** Informational: the connection graph asserted by this test class. */
    @Test
    public void aebTopologyDocumentation() {
        // ┌─────────┐   ┌────────┐   ┌────────────┐   ┌──────────┐   ┌────────┐
        // │  RADAR  │──▶│ FUSION │──▶│  AEB ECU   │──▶│  BRAKE   │   │  HMI   │
        // └─────────┘   └────────┘   └────────────┘   └──────────┘   └────────┘
        //      ▲             ▲           ▲   │   │
        //      │   ┌────────┐│           │   │   └──▶┌────────┐
        //      │   │ CAMERA │┘           │   └──────▶│ MEMORY │
        //      │   └────────┘            │           └────────┘
        //   ┌──┴───┐                 ┌───┴────┐
        //   │POWER │                 │CAN BUS │
        //   └──────┘                 └────────┘
        assertEquals(10, model.getBlockConnections().size());
    }
}
