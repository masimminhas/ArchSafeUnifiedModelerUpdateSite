/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technical Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Technical safety requirement at system level (ISO 26262-4)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.TechnicalSafetyRequirement#getTechnicalCategory <em>Technical Category</em>}</li>
 *   <li>{@link unified.TechnicalSafetyRequirement#getAllocatedASIL <em>Allocated ASIL</em>}</li>
 *   <li>{@link unified.TechnicalSafetyRequirement#getRefinesFrom <em>Refines From</em>}</li>
 *   <li>{@link unified.TechnicalSafetyRequirement#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link unified.TechnicalSafetyRequirement#getVerifiedBy <em>Verified By</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement()
 * @model
 * @generated
 */
public interface TechnicalSafetyRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Technical Category</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.TechnicalRequirementCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technical Category</em>' attribute.
	 * @see unified.TechnicalRequirementCategory
	 * @see #setTechnicalCategory(TechnicalRequirementCategory)
	 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement_TechnicalCategory()
	 * @model
	 * @generated
	 */
	TechnicalRequirementCategory getTechnicalCategory();

	/**
	 * Sets the value of the '{@link unified.TechnicalSafetyRequirement#getTechnicalCategory <em>Technical Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technical Category</em>' attribute.
	 * @see unified.TechnicalRequirementCategory
	 * @see #getTechnicalCategory()
	 * @generated
	 */
	void setTechnicalCategory(TechnicalRequirementCategory value);

	/**
	 * Returns the value of the '<em><b>Allocated ASIL</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.ASILLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated ASIL</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #setAllocatedASIL(ASILLevel)
	 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement_AllocatedASIL()
	 * @model
	 * @generated
	 */
	ASILLevel getAllocatedASIL();

	/**
	 * Sets the value of the '{@link unified.TechnicalSafetyRequirement#getAllocatedASIL <em>Allocated ASIL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated ASIL</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #getAllocatedASIL()
	 * @generated
	 */
	void setAllocatedASIL(ASILLevel value);

	/**
	 * Returns the value of the '<em><b>Refines From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unified.FunctionalSafetyRequirement#getRefinedTo <em>Refined To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines From</em>' reference.
	 * @see #setRefinesFrom(FunctionalSafetyRequirement)
	 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement_RefinesFrom()
	 * @see unified.FunctionalSafetyRequirement#getRefinedTo
	 * @model opposite="refinedTo"
	 * @generated
	 */
	FunctionalSafetyRequirement getRefinesFrom();

	/**
	 * Sets the value of the '{@link unified.TechnicalSafetyRequirement#getRefinesFrom <em>Refines From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refines From</em>' reference.
	 * @see #getRefinesFrom()
	 * @generated
	 */
	void setRefinesFrom(FunctionalSafetyRequirement value);

	/**
	 * Returns the value of the '<em><b>Realized By</b></em>' reference list.
	 * The list contents are of type {@link unified.SafetyCriticalBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized By</em>' reference list.
	 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement_RealizedBy()
	 * @model
	 * @generated
	 */
	EList<SafetyCriticalBlock> getRealizedBy();

	/**
	 * Returns the value of the '<em><b>Verified By</b></em>' reference list.
	 * The list contents are of type {@link unified.FMEAItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verified By</em>' reference list.
	 * @see unified.UnifiedPackage#getTechnicalSafetyRequirement_VerifiedBy()
	 * @model
	 * @generated
	 */
	EList<FMEAItem> getVerifiedBy();

	

} // TechnicalSafetyRequirement
