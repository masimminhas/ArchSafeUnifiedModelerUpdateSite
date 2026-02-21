/**
 */
package unified;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Failure Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specific failure scenarios attached directly to system components with detectability and severity metrics
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.BlockFailureMode#getAffectedBlock <em>Affected Block</em>}</li>
 *   <li>{@link unified.BlockFailureMode#getFailureRate <em>Failure Rate</em>}</li>
 *   <li>{@link unified.BlockFailureMode#getFailureEffect <em>Failure Effect</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getBlockFailureMode()
 * @model
 * @generated
 */
public interface BlockFailureMode extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Affected Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link unified.SafetyCriticalBlock#getFailureModes <em>Failure Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Block</em>' container reference.
	 * @see #setAffectedBlock(SafetyCriticalBlock)
	 * @see unified.UnifiedPackage#getBlockFailureMode_AffectedBlock()
	 * @see unified.SafetyCriticalBlock#getFailureModes
	 * @model opposite="failureModes" transient="false"
	 * @generated
	 */
	SafetyCriticalBlock getAffectedBlock();

	/**
	 * Sets the value of the '{@link unified.BlockFailureMode#getAffectedBlock <em>Affected Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Block</em>' container reference.
	 * @see #getAffectedBlock()
	 * @generated
	 */
	void setAffectedBlock(SafetyCriticalBlock value);

	/**
	 * Returns the value of the '<em><b>Failure Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Rate</em>' attribute.
	 * @see #setFailureRate(double)
	 * @see unified.UnifiedPackage#getBlockFailureMode_FailureRate()
	 * @model
	 * @generated
	 */
	double getFailureRate();

	/**
	 * Sets the value of the '{@link unified.BlockFailureMode#getFailureRate <em>Failure Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Rate</em>' attribute.
	 * @see #getFailureRate()
	 * @generated
	 */
	void setFailureRate(double value);

	/**
	 * Returns the value of the '<em><b>Failure Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Effect</em>' attribute.
	 * @see #setFailureEffect(String)
	 * @see unified.UnifiedPackage#getBlockFailureMode_FailureEffect()
	 * @model
	 * @generated
	 */
	String getFailureEffect();

	/**
	 * Sets the value of the '{@link unified.BlockFailureMode#getFailureEffect <em>Failure Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Effect</em>' attribute.
	 * @see #getFailureEffect()
	 * @generated
	 */
	void setFailureEffect(String value);

} // BlockFailureMode
