/**
 */
package unified.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import unified.HazardCategory;
import unified.IntegratedHazard;
import unified.MitigationStatus;
import unified.RiskLevel;
import unified.SafetyCriticalBlock;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integrated Hazard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.IntegratedHazardImpl#getRiskLevel <em>Risk Level</em>}</li>
 *   <li>{@link unified.impl.IntegratedHazardImpl#getRelatedBlocks <em>Related Blocks</em>}</li>
 *   <li>{@link unified.impl.IntegratedHazardImpl#getMitigationStatus <em>Mitigation Status</em>}</li>
 *   <li>{@link unified.impl.IntegratedHazardImpl#getHazardCategory <em>Hazard Category</em>}</li>
 *   <li>{@link unified.impl.IntegratedHazardImpl#getSeverityJustification <em>Severity Justification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegratedHazardImpl extends UnifiedElementImpl implements IntegratedHazard {
	/**
	 * The default value of the '{@link #getRiskLevel() <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected static final RiskLevel RISK_LEVEL_EDEFAULT = RiskLevel.NEGLIGIBLE;

	/**
	 * The cached value of the '{@link #getRiskLevel() <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected RiskLevel riskLevel = RISK_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedBlocks() <em>Related Blocks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCriticalBlock> relatedBlocks;

	/**
	 * The default value of the '{@link #getMitigationStatus() <em>Mitigation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigationStatus()
	 * @generated
	 * @ordered
	 */
	protected static final MitigationStatus MITIGATION_STATUS_EDEFAULT = MitigationStatus.NOT_MITIGATED;

	/**
	 * The cached value of the '{@link #getMitigationStatus() <em>Mitigation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigationStatus()
	 * @generated
	 * @ordered
	 */
	protected MitigationStatus mitigationStatus = MITIGATION_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHazardCategory() <em>Hazard Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardCategory()
	 * @generated
	 * @ordered
	 */
	protected static final HazardCategory HAZARD_CATEGORY_EDEFAULT = HazardCategory.FUNCTIONAL_FAILURE;

	/**
	 * The cached value of the '{@link #getHazardCategory() <em>Hazard Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardCategory()
	 * @generated
	 * @ordered
	 */
	protected HazardCategory hazardCategory = HAZARD_CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverityJustification() <em>Severity Justification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverityJustification()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_JUSTIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverityJustification() <em>Severity Justification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverityJustification()
	 * @generated
	 * @ordered
	 */
	protected String severityJustification = SEVERITY_JUSTIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegratedHazardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.INTEGRATED_HAZARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiskLevel(RiskLevel newRiskLevel) {
		RiskLevel oldRiskLevel = riskLevel;
		riskLevel = newRiskLevel == null ? RISK_LEVEL_EDEFAULT : newRiskLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.INTEGRATED_HAZARD__RISK_LEVEL, oldRiskLevel, riskLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyCriticalBlock> getRelatedBlocks() {
		if (relatedBlocks == null) {
			relatedBlocks = new EObjectResolvingEList<SafetyCriticalBlock>(SafetyCriticalBlock.class, this, UnifiedPackage.INTEGRATED_HAZARD__RELATED_BLOCKS);
		}
		return relatedBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MitigationStatus getMitigationStatus() {
		return mitigationStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMitigationStatus(MitigationStatus newMitigationStatus) {
		MitigationStatus oldMitigationStatus = mitigationStatus;
		mitigationStatus = newMitigationStatus == null ? MITIGATION_STATUS_EDEFAULT : newMitigationStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.INTEGRATED_HAZARD__MITIGATION_STATUS, oldMitigationStatus, mitigationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HazardCategory getHazardCategory() {
		return hazardCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHazardCategory(HazardCategory newHazardCategory) {
		HazardCategory oldHazardCategory = hazardCategory;
		hazardCategory = newHazardCategory == null ? HAZARD_CATEGORY_EDEFAULT : newHazardCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.INTEGRATED_HAZARD__HAZARD_CATEGORY, oldHazardCategory, hazardCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverityJustification() {
		return severityJustification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverityJustification(String newSeverityJustification) {
		String oldSeverityJustification = severityJustification;
		severityJustification = newSeverityJustification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION, oldSeverityJustification, severityJustification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnifiedPackage.INTEGRATED_HAZARD__RISK_LEVEL:
				return getRiskLevel();
			case UnifiedPackage.INTEGRATED_HAZARD__RELATED_BLOCKS:
				return getRelatedBlocks();
			case UnifiedPackage.INTEGRATED_HAZARD__MITIGATION_STATUS:
				return getMitigationStatus();
			case UnifiedPackage.INTEGRATED_HAZARD__HAZARD_CATEGORY:
				return getHazardCategory();
			case UnifiedPackage.INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION:
				return getSeverityJustification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UnifiedPackage.INTEGRATED_HAZARD__RISK_LEVEL:
				setRiskLevel((RiskLevel)newValue);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__RELATED_BLOCKS:
				getRelatedBlocks().clear();
				getRelatedBlocks().addAll((Collection<? extends SafetyCriticalBlock>)newValue);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__MITIGATION_STATUS:
				setMitigationStatus((MitigationStatus)newValue);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__HAZARD_CATEGORY:
				setHazardCategory((HazardCategory)newValue);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION:
				setSeverityJustification((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UnifiedPackage.INTEGRATED_HAZARD__RISK_LEVEL:
				setRiskLevel(RISK_LEVEL_EDEFAULT);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__RELATED_BLOCKS:
				getRelatedBlocks().clear();
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__MITIGATION_STATUS:
				setMitigationStatus(MITIGATION_STATUS_EDEFAULT);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__HAZARD_CATEGORY:
				setHazardCategory(HAZARD_CATEGORY_EDEFAULT);
				return;
			case UnifiedPackage.INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION:
				setSeverityJustification(SEVERITY_JUSTIFICATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UnifiedPackage.INTEGRATED_HAZARD__RISK_LEVEL:
				return riskLevel != RISK_LEVEL_EDEFAULT;
			case UnifiedPackage.INTEGRATED_HAZARD__RELATED_BLOCKS:
				return relatedBlocks != null && !relatedBlocks.isEmpty();
			case UnifiedPackage.INTEGRATED_HAZARD__MITIGATION_STATUS:
				return mitigationStatus != MITIGATION_STATUS_EDEFAULT;
			case UnifiedPackage.INTEGRATED_HAZARD__HAZARD_CATEGORY:
				return hazardCategory != HAZARD_CATEGORY_EDEFAULT;
			case UnifiedPackage.INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION:
				return SEVERITY_JUSTIFICATION_EDEFAULT == null ? severityJustification != null : !SEVERITY_JUSTIFICATION_EDEFAULT.equals(severityJustification);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (riskLevel: ");
		result.append(riskLevel);
		result.append(", mitigationStatus: ");
		result.append(mitigationStatus);
		result.append(", hazardCategory: ");
		result.append(hazardCategory);
		result.append(", severityJustification: ");
		result.append(severityJustification);
		result.append(')');
		return result.toString();
	}

} //IntegratedHazardImpl
