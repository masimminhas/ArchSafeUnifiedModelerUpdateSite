/**
 */
package unified.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import unified.BlockFailureMode;
import unified.SafetyCriticalBlock;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Failure Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.BlockFailureModeImpl#getAffectedBlock <em>Affected Block</em>}</li>
 *   <li>{@link unified.impl.BlockFailureModeImpl#getFailureRate <em>Failure Rate</em>}</li>
 *   <li>{@link unified.impl.BlockFailureModeImpl#getFailureEffect <em>Failure Effect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockFailureModeImpl extends UnifiedElementImpl implements BlockFailureMode {
	/**
	 * The default value of the '{@link #getFailureRate() <em>Failure Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureRate()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureRate() <em>Failure Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureRate()
	 * @generated
	 * @ordered
	 */
	protected double failureRate = FAILURE_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailureEffect() <em>Failure Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureEffect()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_EFFECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureEffect() <em>Failure Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureEffect()
	 * @generated
	 * @ordered
	 */
	protected String failureEffect = FAILURE_EFFECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockFailureModeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.BLOCK_FAILURE_MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalBlock getAffectedBlock() {
		if (eContainerFeatureID() != UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK) return null;
		return (SafetyCriticalBlock)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAffectedBlock(SafetyCriticalBlock newAffectedBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAffectedBlock, UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedBlock(SafetyCriticalBlock newAffectedBlock) {
		if (newAffectedBlock != eInternalContainer() || (eContainerFeatureID() != UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK && newAffectedBlock != null)) {
			if (EcoreUtil.isAncestor(this, newAffectedBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAffectedBlock != null)
				msgs = ((InternalEObject)newAffectedBlock).eInverseAdd(this, UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES, SafetyCriticalBlock.class, msgs);
			msgs = basicSetAffectedBlock(newAffectedBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK, newAffectedBlock, newAffectedBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureRate() {
		return failureRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureRate(double newFailureRate) {
		double oldFailureRate = failureRate;
		failureRate = newFailureRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_RATE, oldFailureRate, failureRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureEffect() {
		return failureEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureEffect(String newFailureEffect) {
		String oldFailureEffect = failureEffect;
		failureEffect = newFailureEffect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_EFFECT, oldFailureEffect, failureEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAffectedBlock((SafetyCriticalBlock)otherEnd, msgs);
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
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				return basicSetAffectedBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				return eInternalContainer().eInverseRemove(this, UnifiedPackage.SAFETY_CRITICAL_BLOCK__FAILURE_MODES, SafetyCriticalBlock.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				return getAffectedBlock();
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_RATE:
				return getFailureRate();
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_EFFECT:
				return getFailureEffect();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				setAffectedBlock((SafetyCriticalBlock)newValue);
				return;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_RATE:
				setFailureRate((Double)newValue);
				return;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_EFFECT:
				setFailureEffect((String)newValue);
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
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				setAffectedBlock((SafetyCriticalBlock)null);
				return;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_RATE:
				setFailureRate(FAILURE_RATE_EDEFAULT);
				return;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_EFFECT:
				setFailureEffect(FAILURE_EFFECT_EDEFAULT);
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
			case UnifiedPackage.BLOCK_FAILURE_MODE__AFFECTED_BLOCK:
				return getAffectedBlock() != null;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_RATE:
				return failureRate != FAILURE_RATE_EDEFAULT;
			case UnifiedPackage.BLOCK_FAILURE_MODE__FAILURE_EFFECT:
				return FAILURE_EFFECT_EDEFAULT == null ? failureEffect != null : !FAILURE_EFFECT_EDEFAULT.equals(failureEffect);
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
		result.append(" (failureRate: ");
		result.append(failureRate);
		result.append(", failureEffect: ");
		result.append(failureEffect);
		result.append(')');
		return result.toString();
	}

} //BlockFailureModeImpl
