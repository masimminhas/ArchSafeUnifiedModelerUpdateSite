/**
 */
package unified.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.ASILLevel;
import unified.BlockFailureMode;
import unified.RedundancyType;
import unified.SafetyCriticalBlock;
import unified.SafetyCriticalityLevel;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Critical Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.SafetyCriticalBlockImpl#getSafetyCriticality <em>Safety Criticality</em>}</li>
 *   <li>{@link unified.impl.SafetyCriticalBlockImpl#getFailureModes <em>Failure Modes</em>}</li>
 *   <li>{@link unified.impl.SafetyCriticalBlockImpl#isHasRedundancy <em>Has Redundancy</em>}</li>
 *   <li>{@link unified.impl.SafetyCriticalBlockImpl#getRedundancyType <em>Redundancy Type</em>}</li>
 *   <li>{@link unified.impl.SafetyCriticalBlockImpl#getAsilLevel <em>Asil Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyCriticalBlockImpl extends SystemBlockImpl implements SafetyCriticalBlock {
	/**
	 * The default value of the '{@link #getSafetyCriticality() <em>Safety Criticality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafetyCriticality()
	 * @generated
	 * @ordered
	 */
	protected static final SafetyCriticalityLevel SAFETY_CRITICALITY_EDEFAULT = SafetyCriticalityLevel.LOW;

	/**
	 * The cached value of the '{@link #getSafetyCriticality() <em>Safety Criticality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafetyCriticality()
	 * @generated
	 * @ordered
	 */
	protected SafetyCriticalityLevel safetyCriticality = SAFETY_CRITICALITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFailureModes() <em>Failure Modes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModes()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockFailureMode> failureModes;

	/**
	 * The default value of the '{@link #isHasRedundancy() <em>Has Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasRedundancy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_REDUNDANCY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasRedundancy() <em>Has Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasRedundancy()
	 * @generated
	 * @ordered
	 */
	protected boolean hasRedundancy = HAS_REDUNDANCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRedundancyType() <em>Redundancy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancyType()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyType REDUNDANCY_TYPE_EDEFAULT = RedundancyType.NONE;

	/**
	 * The cached value of the '{@link #getRedundancyType() <em>Redundancy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancyType()
	 * @generated
	 * @ordered
	 */
	protected RedundancyType redundancyType = REDUNDANCY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAsilLevel() <em>Asil Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsilLevel()
	 * @generated
	 * @ordered
	 */
	protected static final ASILLevel ASIL_LEVEL_EDEFAULT = ASILLevel.QM;

	/**
	 * The cached value of the '{@link #getAsilLevel() <em>Asil Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsilLevel()
	 * @generated
	 * @ordered
	 */
	protected ASILLevel asilLevel = ASIL_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyCriticalBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.SAFETY_CRITICAL_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalityLevel getSafetyCriticality() {
		return safetyCriticality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafetyCriticality(SafetyCriticalityLevel newSafetyCriticality) {
		SafetyCriticalityLevel oldSafetyCriticality = safetyCriticality;
		safetyCriticality = newSafetyCriticality == null ? SAFETY_CRITICALITY_EDEFAULT : newSafetyCriticality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY, oldSafetyCriticality, safetyCriticality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockFailureMode> getFailureModes() {
		if (failureModes == null) {
			failureModes = new EObjectContainmentWithInverseEList<BlockFailureMode>(BlockFailureMode.class, this, UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES, UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK);
		}
		return failureModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasRedundancy() {
		return hasRedundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasRedundancy(boolean newHasRedundancy) {
		boolean oldHasRedundancy = hasRedundancy;
		hasRedundancy = newHasRedundancy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY, oldHasRedundancy, hasRedundancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType getRedundancyType() {
		return redundancyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancyType(RedundancyType newRedundancyType) {
		RedundancyType oldRedundancyType = redundancyType;
		redundancyType = newRedundancyType == null ? REDUNDANCY_TYPE_EDEFAULT : newRedundancyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE, oldRedundancyType, redundancyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILLevel getAsilLevel() {
		return asilLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsilLevel(ASILLevel newAsilLevel) {
		ASILLevel oldAsilLevel = asilLevel;
		asilLevel = newAsilLevel == null ? ASIL_LEVEL_EDEFAULT : newAsilLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_CRITICAL_BLOCK__ASIL_LEVEL, oldAsilLevel, asilLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFailureModes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				return ((InternalEList<?>)getFailureModes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY:
				return getSafetyCriticality();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				return getFailureModes();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY:
				return isHasRedundancy();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE:
				return getRedundancyType();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__ASIL_LEVEL:
				return getAsilLevel();
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
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY:
				setSafetyCriticality((SafetyCriticalityLevel)newValue);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				getFailureModes().clear();
				getFailureModes().addAll((Collection<? extends BlockFailureMode>)newValue);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY:
				setHasRedundancy((Boolean)newValue);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE:
				setRedundancyType((RedundancyType)newValue);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__ASIL_LEVEL:
				setAsilLevel((ASILLevel)newValue);
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
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY:
				setSafetyCriticality(SAFETY_CRITICALITY_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				getFailureModes().clear();
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY:
				setHasRedundancy(HAS_REDUNDANCY_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE:
				setRedundancyType(REDUNDANCY_TYPE_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__ASIL_LEVEL:
				setAsilLevel(ASIL_LEVEL_EDEFAULT);
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
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY:
				return safetyCriticality != SAFETY_CRITICALITY_EDEFAULT;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES:
				return failureModes != null && !failureModes.isEmpty();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY:
				return hasRedundancy != HAS_REDUNDANCY_EDEFAULT;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE:
				return redundancyType != REDUNDANCY_TYPE_EDEFAULT;
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK__ASIL_LEVEL:
				return asilLevel != ASIL_LEVEL_EDEFAULT;
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
		result.append(" (safetyCriticality: ");
		result.append(safetyCriticality);
		result.append(", hasRedundancy: ");
		result.append(hasRedundancy);
		result.append(", redundancyType: ");
		result.append(redundancyType);
		result.append(", asilLevel: ");
		result.append(asilLevel);
		result.append(')');
		return result.toString();
	}

} //SafetyCriticalBlockImpl
