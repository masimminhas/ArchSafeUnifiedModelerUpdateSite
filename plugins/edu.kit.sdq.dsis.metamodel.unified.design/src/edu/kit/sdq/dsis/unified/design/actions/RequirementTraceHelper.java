package edu.kit.sdq.dsis.unified.design.actions;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import unified.*;

/**
 * Helper class that provides reflective EMF access for requirement-related features
 * that may not yet be generated into the compiled metamodel classes.
 *
 * Strategy:
 *  1. Try the generated Java accessor via java.lang.reflect.Method.invoke().
 *     This compiles unconditionally (no compile-time dependency on the missing method)
 *     and succeeds at runtime once the metamodel is regenerated.
 *  2. If the method does not exist yet (NoSuchMethodException), fall back to
 *     EMF's reflective eGet() using the EStructuralFeature name.
 *  3. If the EStructuralFeature does not exist either, return an empty list / null
 *     so the calling code degrades gracefully instead of crashing.
 */
public final class RequirementTraceHelper {

    private RequirementTraceHelper() { /* utility class */ }

    // =========================================================================
    // UnifiedSystemModel helpers
    // =========================================================================

    /**
     * Returns model.getRequirements(), using java.lang.reflect to avoid a
     * compile-time dependency on a method that may not yet exist in the
     * generated code.
     */
    @SuppressWarnings("unchecked")
    public static List<Requirement> getRequirements(UnifiedSystemModel model) {
        if (model == null) return Collections.emptyList();
        try {
            Method m = model.getClass().getMethod("getRequirements");
            Object result = m.invoke(model);
            return result != null ? (List<Requirement>) result : Collections.emptyList();
        } catch (NoSuchMethodException e) {
            // Method not generated yet – fall back to EMF reflective API
            return reflectiveGetList(model, "requirements");
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // =========================================================================
    // Requirement helpers
    // =========================================================================

    /**
     * Returns req.getRequirementType(), falling back to reflective eGet().
     */
    public static Object getRequirementType(Requirement req) {
        if (req == null) return null;
        try {
            Method m = req.getClass().getMethod("getRequirementType");
            return m.invoke(req);
        } catch (NoSuchMethodException e) {
            return reflectiveGetScalar(req, "requirementType");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns req.getPriority(), falling back to reflective eGet().
     */
    public static Object getPriority(Requirement req) {
        if (req == null) return null;
        try {
            Method m = req.getClass().getMethod("getPriority");
            return m.invoke(req);
        } catch (NoSuchMethodException e) {
            return reflectiveGetScalar(req, "priority");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns req.getRelatedBlocks(), falling back to reflective eGet().
     */
    @SuppressWarnings("unchecked")
    public static List<SafetyCriticalBlock> getRelatedBlocks(Requirement req) {
        if (req == null) return Collections.emptyList();
        try {
            Method m = req.getClass().getMethod("getRelatedBlocks");
            Object result = m.invoke(req);
            return result != null ? (List<SafetyCriticalBlock>) result : Collections.emptyList();
        } catch (NoSuchMethodException e) {
            return reflectiveGetList(req, "relatedBlocks");
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    /**
     * Returns req.getRelatedHazards(), falling back to reflective eGet().
     */
    @SuppressWarnings("unchecked")
    public static List<IntegratedHazard> getRelatedHazards(Requirement req) {
        if (req == null) return Collections.emptyList();
        try {
            Method m = req.getClass().getMethod("getRelatedHazards");
            Object result = m.invoke(req);
            return result != null ? (List<IntegratedHazard>) result : Collections.emptyList();
        } catch (NoSuchMethodException e) {
            return reflectiveGetList(req, "relatedHazards");
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // =========================================================================
    // FMEAItem helpers
    // =========================================================================

    /**
     * Returns item.getRelatedRequirements(), falling back to reflective eGet().
     */
    @SuppressWarnings("unchecked")
    public static List<Requirement> getRelatedRequirements(FMEAItem item) {
        if (item == null) return Collections.emptyList();
        try {
            Method m = item.getClass().getMethod("getRelatedRequirements");
            Object result = m.invoke(item);
            return result != null ? (List<Requirement>) result : Collections.emptyList();
        } catch (NoSuchMethodException e) {
            return reflectiveGetList(item, "relatedRequirements");
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // =========================================================================
    // Convenience counting helpers (shared across action classes)
    // =========================================================================

    /**
     * Counts the number of FMEA items that reference the given requirement.
     */
    public static int countFMEALinksForRequirement(UnifiedSystemModel model, Requirement req) {
        int count = 0;
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (getRelatedRequirements(item).contains(req)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns true if any FMEA item references the given requirement.
     */
    public static boolean hasRelatedFMEAItems(UnifiedSystemModel model, Requirement req) {
        for (FMEAAnalysis analysis : model.getFmeaAnalysis()) {
            for (FMEAItem item : analysis.getFmeaItems()) {
                if (getRelatedRequirements(item).contains(req)) {
                    return true;
                }
            }
        }
        return false;
    }

    // =========================================================================
    // Internal EMF reflective accessors
    // =========================================================================

    /**
     * Reflective eGet() for multi-valued (list) features.
     * Returns an empty list if the feature does not exist in the metamodel yet.
     */
    @SuppressWarnings("unchecked")
    private static <T> List<T> reflectiveGetList(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return Collections.emptyList();
        }
        Object value = obj.eGet(feature);
        if (value == null) {
            return Collections.emptyList();
        }
        return (List<T>) value;
    }

    /**
     * Reflective eGet() for single-valued (scalar) features.
     * Returns null if the feature does not exist in the metamodel yet.
     */
    private static Object reflectiveGetScalar(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return null;
        }
        return obj.eGet(feature);
    }
}