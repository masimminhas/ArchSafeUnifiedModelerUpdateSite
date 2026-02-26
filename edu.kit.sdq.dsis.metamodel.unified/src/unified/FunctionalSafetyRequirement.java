/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Functional safety requirement (ISO 26262-4)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.FunctionalSafetyRequirement#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link unified.FunctionalSafetyRequirement#getAllocatedFrom <em>Allocated From</em>}</li>
 *   <li>{@link unified.FunctionalSafetyRequirement#getRefinedTo <em>Refined To</em>}</li>
 *   <li>{@link unified.FunctionalSafetyRequirement#getImplementedBy <em>Implemented By</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getFunctionalSafetyRequirement()
 * @model
 * @generated
 */
public interface FunctionalSafetyRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Requirement Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.FunctionalRequirementType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Type</em>' attribute.
	 * @see unified.FunctionalRequirementType
	 * @see #setRequirementType(FunctionalRequirementType)
	 * @see unified.UnifiedPackage#getFunctionalSafetyRequirement_RequirementType()
	 * @model
	 * @generated
	 */
	FunctionalRequirementType getRequirementType();

	/**
	 * Sets the value of the '{@link unified.FunctionalSafetyRequirement#getRequirementType <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type</em>' attribute.
	 * @see unified.FunctionalRequirementType
	 * @see #getRequirementType()
	 * @generated
	 */
	void setRequirementType(FunctionalRequirementType value);

	/**
	 * Returns the value of the '<em><b>Allocated From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unified.SafetyGoal#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated From</em>' reference.
	 * @see #setAllocatedFrom(SafetyGoal)
	 * @see unified.UnifiedPackage#getFunctionalSafetyRequirement_AllocatedFrom()
	 * @see unified.SafetyGoal#getAllocatedTo
	 * @model opposite="allocatedTo"
	 * @generated
	 */
	SafetyGoal getAllocatedFrom();

	/**
	 * Sets the value of the '{@link unified.FunctionalSafetyRequirement#getAllocatedFrom <em>Allocated From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated From</em>' reference.
	 * @see #getAllocatedFrom()
	 * @generated
	 */
	void setAllocatedFrom(SafetyGoal value);

	/**
	 * Returns the value of the '<em><b>Refined To</b></em>' reference list.
	 * The list contents are of type {@link unified.TechnicalSafetyRequirement}.
	 * It is bidirectional and its opposite is '{@link unified.TechnicalSafetyRequirement#getRefinesFrom <em>Refines From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined To</em>' reference list.
	 * @see unified.UnifiedPackage#getFunctionalSafetyRequirement_RefinedTo()
	 * @see unified.TechnicalSafetyRequirement#getRefinesFrom
	 * @model opposite="refinesFrom"
	 * @generated
	 */
	EList<TechnicalSafetyRequirement> getRefinedTo();

	/**
	 * Returns the value of the '<em><b>Implemented By</b></em>' reference list.
	 * The list contents are of type {@link unified.SafetyCriticalBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented By</em>' reference list.
	 * @see unified.UnifiedPackage#getFunctionalSafetyRequirement_ImplementedBy()
	 * @model
	 * @generated
	 */
	EList<SafetyCriticalBlock> getImplementedBy();

} // FunctionalSafetyRequirement
