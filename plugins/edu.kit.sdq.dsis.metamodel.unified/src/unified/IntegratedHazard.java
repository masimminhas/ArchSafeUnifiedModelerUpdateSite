/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integrated Hazard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * System-level dangers that span multiple components with risk level quantification
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.IntegratedHazard#getRiskLevel <em>Risk Level</em>}</li>
 *   <li>{@link unified.IntegratedHazard#getRelatedBlocks <em>Related Blocks</em>}</li>
 *   <li>{@link unified.IntegratedHazard#getMitigationStatus <em>Mitigation Status</em>}</li>
 *   <li>{@link unified.IntegratedHazard#getHazardCategory <em>Hazard Category</em>}</li>
 *   <li>{@link unified.IntegratedHazard#getSeverityJustification <em>Severity Justification</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getIntegratedHazard()
 * @model
 * @generated
 */
public interface IntegratedHazard extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Risk Level</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.RiskLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk Level</em>' attribute.
	 * @see unified.RiskLevel
	 * @see #setRiskLevel(RiskLevel)
	 * @see unified.UnifiedPackage#getIntegratedHazard_RiskLevel()
	 * @model
	 * @generated
	 */
	RiskLevel getRiskLevel();

	/**
	 * Sets the value of the '{@link unified.IntegratedHazard#getRiskLevel <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk Level</em>' attribute.
	 * @see unified.RiskLevel
	 * @see #getRiskLevel()
	 * @generated
	 */
	void setRiskLevel(RiskLevel value);

	/**
	 * Returns the value of the '<em><b>Related Blocks</b></em>' reference list.
	 * The list contents are of type {@link unified.SafetyCriticalBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Blocks</em>' reference list.
	 * @see unified.UnifiedPackage#getIntegratedHazard_RelatedBlocks()
	 * @model
	 * @generated
	 */
	EList<SafetyCriticalBlock> getRelatedBlocks();

	/**
	 * Returns the value of the '<em><b>Mitigation Status</b></em>' attribute.
	 * The default value is <code>"NOT_MITIGATED"</code>.
	 * The literals are from the enumeration {@link unified.MitigationStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigation Status</em>' attribute.
	 * @see unified.MitigationStatus
	 * @see #setMitigationStatus(MitigationStatus)
	 * @see unified.UnifiedPackage#getIntegratedHazard_MitigationStatus()
	 * @model default="NOT_MITIGATED"
	 * @generated
	 */
	MitigationStatus getMitigationStatus();

	/**
	 * Sets the value of the '{@link unified.IntegratedHazard#getMitigationStatus <em>Mitigation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mitigation Status</em>' attribute.
	 * @see unified.MitigationStatus
	 * @see #getMitigationStatus()
	 * @generated
	 */
	void setMitigationStatus(MitigationStatus value);

	/**
	 * Returns the value of the '<em><b>Hazard Category</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.HazardCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazard Category</em>' attribute.
	 * @see unified.HazardCategory
	 * @see #setHazardCategory(HazardCategory)
	 * @see unified.UnifiedPackage#getIntegratedHazard_HazardCategory()
	 * @model
	 * @generated
	 */
	HazardCategory getHazardCategory();

	/**
	 * Sets the value of the '{@link unified.IntegratedHazard#getHazardCategory <em>Hazard Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hazard Category</em>' attribute.
	 * @see unified.HazardCategory
	 * @see #getHazardCategory()
	 * @generated
	 */
	void setHazardCategory(HazardCategory value);

	/**
	 * Returns the value of the '<em><b>Severity Justification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity Justification</em>' attribute.
	 * @see #setSeverityJustification(String)
	 * @see unified.UnifiedPackage#getIntegratedHazard_SeverityJustification()
	 * @model
	 * @generated
	 */
	String getSeverityJustification();

	/**
	 * Sets the value of the '{@link unified.IntegratedHazard#getSeverityJustification <em>Severity Justification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity Justification</em>' attribute.
	 * @see #getSeverityJustification()
	 * @generated
	 */
	void setSeverityJustification(String value);

} // IntegratedHazard
