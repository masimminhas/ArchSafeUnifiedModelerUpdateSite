/**
 */
package unified.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import unified.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage
 * @generated
 */
public class UnifiedSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UnifiedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedSwitch() {
		if (modelPackage == null) {
			modelPackage = UnifiedPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UnifiedPackage.UNIFIED_ELEMENT: {
				UnifiedElement unifiedElement = (UnifiedElement)theEObject;
				T result = caseUnifiedElement(unifiedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL: {
				UnifiedSystemModel unifiedSystemModel = (UnifiedSystemModel)theEObject;
				T result = caseUnifiedSystemModel(unifiedSystemModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.FMEA_ANALYSIS: {
				FMEAAnalysis fmeaAnalysis = (FMEAAnalysis)theEObject;
				T result = caseFMEAAnalysis(fmeaAnalysis);
				if (result == null) result = caseUnifiedElement(fmeaAnalysis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.FMEA_ITEM: {
				FMEAItem fmeaItem = (FMEAItem)theEObject;
				T result = caseFMEAItem(fmeaItem);
				if (result == null) result = caseUnifiedElement(fmeaItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.INTEGRATED_HAZARD: {
				IntegratedHazard integratedHazard = (IntegratedHazard)theEObject;
				T result = caseIntegratedHazard(integratedHazard);
				if (result == null) result = caseUnifiedElement(integratedHazard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK: {
				SafetyCriticalBlock safetyCriticalBlock = (SafetyCriticalBlock)theEObject;
				T result = caseSafetyCriticalBlock(safetyCriticalBlock);
				if (result == null) result = caseSystemBlock(safetyCriticalBlock);
				if (result == null) result = caseUnifiedElement(safetyCriticalBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.SYSTEM_BLOCK: {
				SystemBlock systemBlock = (SystemBlock)theEObject;
				T result = caseSystemBlock(systemBlock);
				if (result == null) result = caseUnifiedElement(systemBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.BLOCK_ASSOCIATION: {
				BlockAssociation blockAssociation = (BlockAssociation)theEObject;
				T result = caseBlockAssociation(blockAssociation);
				if (result == null) result = caseUnifiedElement(blockAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.BLOCK_CONNECTION: {
				BlockConnection blockConnection = (BlockConnection)theEObject;
				T result = caseBlockConnection(blockConnection);
				if (result == null) result = caseUnifiedElement(blockConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.BLOCK_FAILURE_MODE: {
				BlockFailureMode blockFailureMode = (BlockFailureMode)theEObject;
				T result = caseBlockFailureMode(blockFailureMode);
				if (result == null) result = caseUnifiedElement(blockFailureMode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.ANALYSIS_METADATA: {
				AnalysisMetadata analysisMetadata = (AnalysisMetadata)theEObject;
				T result = caseAnalysisMetadata(analysisMetadata);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.REQUIREMENT: {
				Requirement requirement = (Requirement)theEObject;
				T result = caseRequirement(requirement);
				if (result == null) result = caseUnifiedElement(requirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.SAFETY_GOAL: {
				SafetyGoal safetyGoal = (SafetyGoal)theEObject;
				T result = caseSafetyGoal(safetyGoal);
				if (result == null) result = caseRequirement(safetyGoal);
				if (result == null) result = caseUnifiedElement(safetyGoal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT: {
				FunctionalSafetyRequirement functionalSafetyRequirement = (FunctionalSafetyRequirement)theEObject;
				T result = caseFunctionalSafetyRequirement(functionalSafetyRequirement);
				if (result == null) result = caseRequirement(functionalSafetyRequirement);
				if (result == null) result = caseUnifiedElement(functionalSafetyRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT: {
				TechnicalSafetyRequirement technicalSafetyRequirement = (TechnicalSafetyRequirement)theEObject;
				T result = caseTechnicalSafetyRequirement(technicalSafetyRequirement);
				if (result == null) result = caseRequirement(technicalSafetyRequirement);
				if (result == null) result = caseUnifiedElement(technicalSafetyRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UnifiedPackage.SAFETY_MECHANISM: {
				SafetyMechanism safetyMechanism = (SafetyMechanism)theEObject;
				T result = caseSafetyMechanism(safetyMechanism);
				if (result == null) result = caseUnifiedElement(safetyMechanism);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnifiedElement(UnifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnifiedSystemModel(UnifiedSystemModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMEA Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMEA Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMEAAnalysis(FMEAAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMEA Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMEA Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMEAItem(FMEAItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integrated Hazard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integrated Hazard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegratedHazard(IntegratedHazard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Safety Critical Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safety Critical Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSafetyCriticalBlock(SafetyCriticalBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemBlock(SystemBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockAssociation(BlockAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockConnection(BlockConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Failure Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Failure Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockFailureMode(BlockFailureMode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Metadata</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisMetadata(AnalysisMetadata object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Safety Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safety Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSafetyGoal(SafetyGoal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Functional Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Functional Safety Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionalSafetyRequirement(FunctionalSafetyRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Technical Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Technical Safety Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTechnicalSafetyRequirement(TechnicalSafetyRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Safety Mechanism</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safety Mechanism</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSafetyMechanism(SafetyMechanism object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UnifiedSwitch
