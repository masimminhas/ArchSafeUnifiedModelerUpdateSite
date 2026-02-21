/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Top-level safety requirement from HARA (ISO 26262-3)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.SafetyGoal#getAsilLevel <em>Asil Level</em>}</li>
 *   <li>{@link unified.SafetyGoal#getRelatedHazard <em>Related Hazard</em>}</li>
 *   <li>{@link unified.SafetyGoal#getSafeState <em>Safe State</em>}</li>
 *   <li>{@link unified.SafetyGoal#getAllocatedTo <em>Allocated To</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getSafetyGoal()
 * @model
 * @generated
 */
public interface SafetyGoal extends Requirement {
	/**
	 * Returns the value of the '<em><b>Asil Level</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.ASILLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asil Level</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #setAsilLevel(ASILLevel)
	 * @see unified.UnifiedPackage#getSafetyGoal_AsilLevel()
	 * @model
	 * @generated
	 */
	ASILLevel getAsilLevel();

	/**
	 * Sets the value of the '{@link unified.SafetyGoal#getAsilLevel <em>Asil Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asil Level</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #getAsilLevel()
	 * @generated
	 */
	void setAsilLevel(ASILLevel value);

	/**
	 * Returns the value of the '<em><b>Related Hazard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Hazard</em>' reference.
	 * @see #setRelatedHazard(IntegratedHazard)
	 * @see unified.UnifiedPackage#getSafetyGoal_RelatedHazard()
	 * @model
	 * @generated
	 */
	IntegratedHazard getRelatedHazard();

	/**
	 * Sets the value of the '{@link unified.SafetyGoal#getRelatedHazard <em>Related Hazard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Hazard</em>' reference.
	 * @see #getRelatedHazard()
	 * @generated
	 */
	void setRelatedHazard(IntegratedHazard value);

	/**
	 * Returns the value of the '<em><b>Safe State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safe State</em>' attribute.
	 * @see #setSafeState(String)
	 * @see unified.UnifiedPackage#getSafetyGoal_SafeState()
	 * @model
	 * @generated
	 */
	String getSafeState();

	/**
	 * Sets the value of the '{@link unified.SafetyGoal#getSafeState <em>Safe State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safe State</em>' attribute.
	 * @see #getSafeState()
	 * @generated
	 */
	void setSafeState(String value);

	/**
	 * Returns the value of the '<em><b>Allocated To</b></em>' reference list.
	 * The list contents are of type {@link unified.FunctionalSafetyRequirement}.
	 * It is bidirectional and its opposite is '{@link unified.FunctionalSafetyRequirement#getAllocatedFrom <em>Allocated From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated To</em>' reference list.
	 * @see unified.UnifiedPackage#getSafetyGoal_AllocatedTo()
	 * @see unified.FunctionalSafetyRequirement#getAllocatedFrom
	 * @model opposite="allocatedFrom"
	 * @generated
	 */
	EList<FunctionalSafetyRequirement> getAllocatedTo();

} // SafetyGoal
