/**
 */
package unified.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import unified.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage
 * @generated
 */
public class UnifiedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UnifiedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UnifiedPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnifiedSwitch<Adapter> modelSwitch =
		new UnifiedSwitch<Adapter>() {
			@Override
			public Adapter caseUnifiedElement(UnifiedElement object) {
				return createUnifiedElementAdapter();
			}
			@Override
			public Adapter caseUnifiedSystemModel(UnifiedSystemModel object) {
				return createUnifiedSystemModelAdapter();
			}
			@Override
			public Adapter caseFMEAAnalysis(FMEAAnalysis object) {
				return createFMEAAnalysisAdapter();
			}
			@Override
			public Adapter caseFMEAItem(FMEAItem object) {
				return createFMEAItemAdapter();
			}
			@Override
			public Adapter caseIntegratedHazard(IntegratedHazard object) {
				return createIntegratedHazardAdapter();
			}
			@Override
			public Adapter caseSafetyCriticalBlock(SafetyCriticalBlock object) {
				return createSafetyCriticalBlockAdapter();
			}
			@Override
			public Adapter caseSystemBlock(SystemBlock object) {
				return createSystemBlockAdapter();
			}
			@Override
			public Adapter caseBlockAssociation(BlockAssociation object) {
				return createBlockAssociationAdapter();
			}
			@Override
			public Adapter caseBlockConnection(BlockConnection object) {
				return createBlockConnectionAdapter();
			}
			@Override
			public Adapter caseBlockFailureMode(BlockFailureMode object) {
				return createBlockFailureModeAdapter();
			}
			@Override
			public Adapter caseAnalysisMetadata(AnalysisMetadata object) {
				return createAnalysisMetadataAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseSafetyGoal(SafetyGoal object) {
				return createSafetyGoalAdapter();
			}
			@Override
			public Adapter caseFunctionalSafetyRequirement(FunctionalSafetyRequirement object) {
				return createFunctionalSafetyRequirementAdapter();
			}
			@Override
			public Adapter caseTechnicalSafetyRequirement(TechnicalSafetyRequirement object) {
				return createTechnicalSafetyRequirementAdapter();
			}
			@Override
			public Adapter caseSafetyMechanism(SafetyMechanism object) {
				return createSafetyMechanismAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link unified.UnifiedElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.UnifiedElement
	 * @generated
	 */
	public Adapter createUnifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.UnifiedSystemModel <em>System Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.UnifiedSystemModel
	 * @generated
	 */
	public Adapter createUnifiedSystemModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.FMEAAnalysis <em>FMEA Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.FMEAAnalysis
	 * @generated
	 */
	public Adapter createFMEAAnalysisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.FMEAItem <em>FMEA Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.FMEAItem
	 * @generated
	 */
	public Adapter createFMEAItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.IntegratedHazard <em>Integrated Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.IntegratedHazard
	 * @generated
	 */
	public Adapter createIntegratedHazardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.SafetyCriticalBlock <em>Safety Critical Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.SafetyCriticalBlock
	 * @generated
	 */
	public Adapter createSafetyCriticalBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.SystemBlock <em>System Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.SystemBlock
	 * @generated
	 */
	public Adapter createSystemBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.BlockAssociation <em>Block Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.BlockAssociation
	 * @generated
	 */
	public Adapter createBlockAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.BlockConnection <em>Block Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.BlockConnection
	 * @generated
	 */
	public Adapter createBlockConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.BlockFailureMode <em>Block Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.BlockFailureMode
	 * @generated
	 */
	public Adapter createBlockFailureModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.AnalysisMetadata <em>Analysis Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.AnalysisMetadata
	 * @generated
	 */
	public Adapter createAnalysisMetadataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.SafetyGoal <em>Safety Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.SafetyGoal
	 * @generated
	 */
	public Adapter createSafetyGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.FunctionalSafetyRequirement <em>Functional Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.FunctionalSafetyRequirement
	 * @generated
	 */
	public Adapter createFunctionalSafetyRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.TechnicalSafetyRequirement <em>Technical Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.TechnicalSafetyRequirement
	 * @generated
	 */
	public Adapter createTechnicalSafetyRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unified.SafetyMechanism <em>Safety Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unified.SafetyMechanism
	 * @generated
	 */
	public Adapter createSafetyMechanismAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UnifiedAdapterFactory
