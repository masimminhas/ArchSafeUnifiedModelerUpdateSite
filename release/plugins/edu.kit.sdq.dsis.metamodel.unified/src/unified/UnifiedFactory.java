/**
 */
package unified;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage
 * @generated
 */
public interface UnifiedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UnifiedFactory eINSTANCE = unified.impl.UnifiedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Model</em>'.
	 * @generated
	 */
	UnifiedSystemModel createUnifiedSystemModel();

	/**
	 * Returns a new object of class '<em>FMEA Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMEA Analysis</em>'.
	 * @generated
	 */
	FMEAAnalysis createFMEAAnalysis();

	/**
	 * Returns a new object of class '<em>FMEA Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMEA Item</em>'.
	 * @generated
	 */
	FMEAItem createFMEAItem();

	/**
	 * Returns a new object of class '<em>Integrated Hazard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integrated Hazard</em>'.
	 * @generated
	 */
	IntegratedHazard createIntegratedHazard();

	/**
	 * Returns a new object of class '<em>Safety Critical Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Critical Block</em>'.
	 * @generated
	 */
	SafetyCriticalBlock createSafetyCriticalBlock();

	/**
	 * Returns a new object of class '<em>System Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Block</em>'.
	 * @generated
	 */
	SystemBlock createSystemBlock();

	/**
	 * Returns a new object of class '<em>Block Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Association</em>'.
	 * @generated
	 */
	BlockAssociation createBlockAssociation();

	/**
	 * Returns a new object of class '<em>Block Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Connection</em>'.
	 * @generated
	 */
	BlockConnection createBlockConnection();

	/**
	 * Returns a new object of class '<em>Block Failure Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Failure Mode</em>'.
	 * @generated
	 */
	BlockFailureMode createBlockFailureMode();

	/**
	 * Returns a new object of class '<em>Analysis Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis Metadata</em>'.
	 * @generated
	 */
	AnalysisMetadata createAnalysisMetadata();

	/**
	 * Returns a new object of class '<em>Safety Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Goal</em>'.
	 * @generated
	 */
	SafetyGoal createSafetyGoal();

	/**
	 * Returns a new object of class '<em>Functional Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional Safety Requirement</em>'.
	 * @generated
	 */
	FunctionalSafetyRequirement createFunctionalSafetyRequirement();

	/**
	 * Returns a new object of class '<em>Technical Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technical Safety Requirement</em>'.
	 * @generated
	 */
	TechnicalSafetyRequirement createTechnicalSafetyRequirement();

	/**
	 * Returns a new object of class '<em>Safety Mechanism</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Mechanism</em>'.
	 * @generated
	 */
	SafetyMechanism createSafetyMechanism();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UnifiedPackage getUnifiedPackage();

} //UnifiedFactory
