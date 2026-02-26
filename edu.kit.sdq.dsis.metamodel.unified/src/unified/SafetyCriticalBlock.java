/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Critical Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * System components that require safety analysis with embedded failure modes and criticality levels
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.SafetyCriticalBlock#getSafetyCriticality <em>Safety Criticality</em>}</li>
 *   <li>{@link unified.SafetyCriticalBlock#getFailureModes <em>Failure Modes</em>}</li>
 *   <li>{@link unified.SafetyCriticalBlock#isHasRedundancy <em>Has Redundancy</em>}</li>
 *   <li>{@link unified.SafetyCriticalBlock#getRedundancyType <em>Redundancy Type</em>}</li>
 *   <li>{@link unified.SafetyCriticalBlock#getAsilLevel <em>Asil Level</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getSafetyCriticalBlock()
 * @model
 * @generated
 */
public interface SafetyCriticalBlock extends SystemBlock {
	/**
	 * Returns the value of the '<em><b>Safety Criticality</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.SafetyCriticalityLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safety Criticality</em>' attribute.
	 * @see unified.SafetyCriticalityLevel
	 * @see #setSafetyCriticality(SafetyCriticalityLevel)
	 * @see unified.UnifiedPackage#getSafetyCriticalBlock_SafetyCriticality()
	 * @model
	 * @generated
	 */
	SafetyCriticalityLevel getSafetyCriticality();

	/**
	 * Sets the value of the '{@link unified.SafetyCriticalBlock#getSafetyCriticality <em>Safety Criticality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safety Criticality</em>' attribute.
	 * @see unified.SafetyCriticalityLevel
	 * @see #getSafetyCriticality()
	 * @generated
	 */
	void setSafetyCriticality(SafetyCriticalityLevel value);

	/**
	 * Returns the value of the '<em><b>Failure Modes</b></em>' containment reference list.
	 * The list contents are of type {@link unified.BlockFailureMode}.
	 * It is bidirectional and its opposite is '{@link unified.BlockFailureMode#getAffectedBlock <em>Affected Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Modes</em>' containment reference list.
	 * @see unified.UnifiedPackage#getSafetyCriticalBlock_FailureModes()
	 * @see unified.BlockFailureMode#getAffectedBlock
	 * @model opposite="affectedBlock" containment="true"
	 * @generated
	 */
	EList<BlockFailureMode> getFailureModes();

	/**
	 * Returns the value of the '<em><b>Has Redundancy</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Redundancy</em>' attribute.
	 * @see #setHasRedundancy(boolean)
	 * @see unified.UnifiedPackage#getSafetyCriticalBlock_HasRedundancy()
	 * @model default="false"
	 * @generated
	 */
	boolean isHasRedundancy();

	/**
	 * Sets the value of the '{@link unified.SafetyCriticalBlock#isHasRedundancy <em>Has Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Redundancy</em>' attribute.
	 * @see #isHasRedundancy()
	 * @generated
	 */
	void setHasRedundancy(boolean value);

	/**
	 * Returns the value of the '<em><b>Redundancy Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.RedundancyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redundancy Type</em>' attribute.
	 * @see unified.RedundancyType
	 * @see #setRedundancyType(RedundancyType)
	 * @see unified.UnifiedPackage#getSafetyCriticalBlock_RedundancyType()
	 * @model
	 * @generated
	 */
	RedundancyType getRedundancyType();

	/**
	 * Sets the value of the '{@link unified.SafetyCriticalBlock#getRedundancyType <em>Redundancy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redundancy Type</em>' attribute.
	 * @see unified.RedundancyType
	 * @see #getRedundancyType()
	 * @generated
	 */
	void setRedundancyType(RedundancyType value);

	/**
	 * Returns the value of the '<em><b>Asil Level</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.ASILLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asil Level</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #setAsilLevel(ASILLevel)
	 * @see unified.UnifiedPackage#getSafetyCriticalBlock_AsilLevel()
	 * @model
	 * @generated
	 */
	ASILLevel getAsilLevel();

	/**
	 * Sets the value of the '{@link unified.SafetyCriticalBlock#getAsilLevel <em>Asil Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asil Level</em>' attribute.
	 * @see unified.ASILLevel
	 * @see #getAsilLevel()
	 * @generated
	 */
	void setAsilLevel(ASILLevel value);

} // SafetyCriticalBlock
