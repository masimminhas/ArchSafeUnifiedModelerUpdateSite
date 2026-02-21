/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for all requirements in the safety lifecycle
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.Requirement#getRequirementId <em>Requirement Id</em>}</li>
 *   <li>{@link unified.Requirement#getRequirementText <em>Requirement Text</em>}</li>
 *   <li>{@link unified.Requirement#getStatus <em>Status</em>}</li>
 *   <li>{@link unified.Requirement#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link unified.Requirement#getRationale <em>Rationale</em>}</li>
 *   <li>{@link unified.Requirement#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link unified.Requirement#getSatisfiedBy <em>Satisfied By</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getRequirement()
 * @model abstract="true"
 * @generated
 */
public interface Requirement extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Requirement Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Id</em>' attribute.
	 * @see #setRequirementId(String)
	 * @see unified.UnifiedPackage#getRequirement_RequirementId()
	 * @model
	 * @generated
	 */
	String getRequirementId();

	/**
	 * Sets the value of the '{@link unified.Requirement#getRequirementId <em>Requirement Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Id</em>' attribute.
	 * @see #getRequirementId()
	 * @generated
	 */
	void setRequirementId(String value);

	/**
	 * Returns the value of the '<em><b>Requirement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Text</em>' attribute.
	 * @see #setRequirementText(String)
	 * @see unified.UnifiedPackage#getRequirement_RequirementText()
	 * @model
	 * @generated
	 */
	String getRequirementText();

	/**
	 * Sets the value of the '{@link unified.Requirement#getRequirementText <em>Requirement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Text</em>' attribute.
	 * @see #getRequirementText()
	 * @generated
	 */
	void setRequirementText(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"DRAFT"</code>.
	 * The literals are from the enumeration {@link unified.RequirementStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see unified.RequirementStatus
	 * @see #setStatus(RequirementStatus)
	 * @see unified.UnifiedPackage#getRequirement_Status()
	 * @model default="DRAFT"
	 * @generated
	 */
	RequirementStatus getStatus();

	/**
	 * Sets the value of the '{@link unified.Requirement#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see unified.RequirementStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(RequirementStatus value);

	/**
	 * Returns the value of the '<em><b>Verification Method</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.VerificationMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verification Method</em>' attribute.
	 * @see unified.VerificationMethod
	 * @see #setVerificationMethod(VerificationMethod)
	 * @see unified.UnifiedPackage#getRequirement_VerificationMethod()
	 * @model
	 * @generated
	 */
	VerificationMethod getVerificationMethod();

	/**
	 * Sets the value of the '{@link unified.Requirement#getVerificationMethod <em>Verification Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verification Method</em>' attribute.
	 * @see unified.VerificationMethod
	 * @see #getVerificationMethod()
	 * @generated
	 */
	void setVerificationMethod(VerificationMethod value);

	/**
	 * Returns the value of the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rationale</em>' attribute.
	 * @see #setRationale(String)
	 * @see unified.UnifiedPackage#getRequirement_Rationale()
	 * @model
	 * @generated
	 */
	String getRationale();

	/**
	 * Sets the value of the '{@link unified.Requirement#getRationale <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rationale</em>' attribute.
	 * @see #getRationale()
	 * @generated
	 */
	void setRationale(String value);

	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link unified.Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see unified.UnifiedPackage#getRequirement_DerivedFrom()
	 * @model
	 * @generated
	 */
	EList<Requirement> getDerivedFrom();

	/**
	 * Returns the value of the '<em><b>Satisfied By</b></em>' reference list.
	 * The list contents are of type {@link unified.SystemBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfied By</em>' reference list.
	 * @see unified.UnifiedPackage#getRequirement_SatisfiedBy()
	 * @model
	 * @generated
	 */
	EList<SystemBlock> getSatisfiedBy();

} // Requirement
