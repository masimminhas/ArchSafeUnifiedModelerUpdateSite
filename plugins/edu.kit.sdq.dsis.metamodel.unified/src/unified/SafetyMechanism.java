/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Safety mechanism implementing safety requirements
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.SafetyMechanism#getMechanismType <em>Mechanism Type</em>}</li>
 *   <li>{@link unified.SafetyMechanism#getDiagnosticCoverage <em>Diagnostic Coverage</em>}</li>
 *   <li>{@link unified.SafetyMechanism#getImplements <em>Implements</em>}</li>
 *   <li>{@link unified.SafetyMechanism#getImplementedIn <em>Implemented In</em>}</li>
 *   <li>{@link unified.SafetyMechanism#getValidatedBy <em>Validated By</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getSafetyMechanism()
 * @model
 * @generated
 */
public interface SafetyMechanism extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Mechanism Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.SafetyMechanismType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mechanism Type</em>' attribute.
	 * @see unified.SafetyMechanismType
	 * @see #setMechanismType(SafetyMechanismType)
	 * @see unified.UnifiedPackage#getSafetyMechanism_MechanismType()
	 * @model
	 * @generated
	 */
	SafetyMechanismType getMechanismType();

	/**
	 * Sets the value of the '{@link unified.SafetyMechanism#getMechanismType <em>Mechanism Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mechanism Type</em>' attribute.
	 * @see unified.SafetyMechanismType
	 * @see #getMechanismType()
	 * @generated
	 */
	void setMechanismType(SafetyMechanismType value);

	/**
	 * Returns the value of the '<em><b>Diagnostic Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic Coverage</em>' attribute.
	 * @see #setDiagnosticCoverage(int)
	 * @see unified.UnifiedPackage#getSafetyMechanism_DiagnosticCoverage()
	 * @model
	 * @generated
	 */
	int getDiagnosticCoverage();

	/**
	 * Sets the value of the '{@link unified.SafetyMechanism#getDiagnosticCoverage <em>Diagnostic Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic Coverage</em>' attribute.
	 * @see #getDiagnosticCoverage()
	 * @generated
	 */
	void setDiagnosticCoverage(int value);

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' reference list.
	 * The list contents are of type {@link unified.TechnicalSafetyRequirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' reference list.
	 * @see unified.UnifiedPackage#getSafetyMechanism_Implements()
	 * @model
	 * @generated
	 */
	EList<TechnicalSafetyRequirement> getImplements();

	/**
	 * Returns the value of the '<em><b>Implemented In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented In</em>' reference.
	 * @see #setImplementedIn(SafetyCriticalBlock)
	 * @see unified.UnifiedPackage#getSafetyMechanism_ImplementedIn()
	 * @model
	 * @generated
	 */
	SafetyCriticalBlock getImplementedIn();

	/**
	 * Sets the value of the '{@link unified.SafetyMechanism#getImplementedIn <em>Implemented In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implemented In</em>' reference.
	 * @see #getImplementedIn()
	 * @generated
	 */
	void setImplementedIn(SafetyCriticalBlock value);

	/**
	 * Returns the value of the '<em><b>Validated By</b></em>' reference list.
	 * The list contents are of type {@link unified.FMEAItem}.
	 * It is bidirectional and its opposite is '{@link unified.FMEAItem#getValidatesMechanisms <em>Validates Mechanisms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated By</em>' reference list.
	 * @see unified.UnifiedPackage#getSafetyMechanism_ValidatedBy()
	 * @see unified.FMEAItem#getValidatesMechanisms
	 * @model opposite="validatesMechanisms"
	 * @generated
	 */
	EList<FMEAItem> getValidatedBy();

} // SafetyMechanism
