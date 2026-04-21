package edu.kit.sdq.dsis.unified.tests;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import unified.UnifiedFactory;
import unified.UnifiedPackage;
import unified.UnifiedSystemModel;

/**
 * Shared helpers for loading bundled .unified models and walking the
 * metamodel. Keeps the individual test classes small and focused.
 */
public final class TestSupport {

    // Paths match where the bundle build copies the files (see build.properties:
    // bin.includes = resources/ → jar entries are /resources/<name>).
    public static final String AEB_RESOURCE     = "/resources/aeb.unified";
    public static final String MEDICAL_RESOURCE = "/resources/medical.unified";

    private TestSupport() {}

    /**
     * Configures a fresh ResourceSet that can load ArchSafe .unified files
     * without requiring an OSGi extension registry. Safe to call from plain
     * JUnit or from inside a Tycho eclipse-test-plugin.
     */
    public static ResourceSet newResourceSet() {
        UnifiedPackage.eINSTANCE.eClass(); // force EMF package registration
        ResourceSet rs = new ResourceSetImpl();
        rs.getPackageRegistry().put(UnifiedPackage.eNS_URI, UnifiedPackage.eINSTANCE);
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
          .put("unified", new XMIResourceFactoryImpl());
        return rs;
    }

    /**
     * Loads one of the bundled case-study models from the test-bundle's
     * classpath (e.g. {@link #AEB_RESOURCE}) and returns its root
     * {@link UnifiedSystemModel}.
     */
    public static UnifiedSystemModel loadBundledModel(String classpathResource) throws Exception {
        Path tempFile = Files.createTempFile("archsafe-test-", ".unified");
        tempFile.toFile().deleteOnExit();
        try (InputStream in = Objects.requireNonNull(
                TestSupport.class.getResourceAsStream(classpathResource),
                "Bundled test resource not found: " + classpathResource)) {
            Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }
        ResourceSet rs = newResourceSet();
        Resource resource = rs.getResource(
            URI.createFileURI(tempFile.toAbsolutePath().toString()), true);
        EObject root = resource.getContents().get(0);
        return (UnifiedSystemModel) root;
    }

    /** Creates an empty in-memory UnifiedSystemModel, useful for positive/negative rule tests. */
    public static UnifiedSystemModel newEmptyModel() {
        UnifiedPackage.eINSTANCE.eClass();
        return UnifiedFactory.eINSTANCE.createUnifiedSystemModel();
    }
}
