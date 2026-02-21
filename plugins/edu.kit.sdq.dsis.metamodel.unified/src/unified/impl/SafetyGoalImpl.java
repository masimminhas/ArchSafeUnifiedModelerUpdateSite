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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.ASILLevel;
import unified.FunctionalSafetyRequirement;
import unified.IntegratedHazard;
import unified.SafetyGoal;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.SafetyGoalImpl#getAsilLevel <em>Asil Level</em>}</li>
 *   <li>{@link unified.impl.SafetyGoalImpl#getRelatedHazard <em>Related Hazard</em>}</li>
 *   <li>{@link unified.impl.SafetyGoalImpl#getSafeState <em>Safe State</em>}</li>
 *   <li>{@link unified.impl.SafetyGoalImpl#getAllocatedTo <em>Allocated To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyGoalImpl extends RequirementImpl implements SafetyGoal {
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
	 * The cached value of the '{@link #getRelatedHazard() <em>Related Hazard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedHazard()
	 * @generated
	 * @ordered
	 */
	protected IntegratedHazard relatedHazard;

	/**
	 * The default value of the '{@link #getSafeState() <em>Safe State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeState()
	 * @generated
	 * @ordered
	 */
	protected static final String SAFE_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSafeState() <em>Safe State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeState()
	 * @generated
	 * @ordered
	 */
	protected String safeState = SAFE_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocatedTo() <em>Allocated To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalSafetyRequirement> allocatedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyGoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.SAFETY_GOAL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_GOAL__ASIL_LEVEL, oldAsilLevel, asilLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegratedHazard getRelatedHazard() {
		if (relatedHazard != null && relatedHazard.eIsProxy()) {
			InternalEObject oldRelatedHazard = (InternalEObject)relatedHazard;
			relatedHazard = (IntegratedHazard)eResolveProxy(oldRelatedHazard);
			if (relatedHazard != oldRelatedHazard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD, oldRelatedHazard, relatedHazard));
			}
		}
		return relatedHazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegratedHazard basicGetRelatedHazard() {
		return relatedHazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedHazard(IntegratedHazard newRelatedHazard) {
		IntegratedHazard oldRelatedHazard = relatedHazard;
		relatedHazard = newRelatedHazard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD, oldRelatedHazard, relatedHazard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSafeState() {
		return safeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafeState(String newSafeState) {
		String oldSafeState = safeState;
		safeState = newSafeState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_GOAL__SAFE_STATE, oldSafeState, safeState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalSafetyRequirement> getAllocatedTo() {
		if (allocatedTo == null) {
			allocatedTo = new EObjectWithInverseResolvingEList<FunctionalSafetyRequirement>(FunctionalSafetyRequirement.class, this, UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM);
		}
		return allocatedTo;
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
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAllocatedTo()).basicAdd(otherEnd, msgs);
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
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				return ((InternalEList<?>)getAllocatedTo()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.SAFETY_GOAL__ASIL_LEVEL:
				return getAsilLevel();
			case UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD:
				if (resolve) return getRelatedHazard();
				return basicGetRelatedHazard();
			case UnifiedPackage.SAFETY_GOAL__SAFE_STATE:
				return getSafeState();
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				return getAllocatedTo();
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
			case UnifiedPackage.SAFETY_GOAL__ASIL_LEVEL:
				setAsilLevel((ASILLevel)newValue);
				return;
			case UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD:
				setRelatedHazard((IntegratedHazard)newValue);
				return;
			case UnifiedPackage.SAFETY_GOAL__SAFE_STATE:
				setSafeState((String)newValue);
				return;
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				getAllocatedTo().clear();
				getAllocatedTo().addAll((Collection<? extends FunctionalSafetyRequirement>)newValue);
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
			case UnifiedPackage.SAFETY_GOAL__ASIL_LEVEL:
				setAsilLevel(ASIL_LEVEL_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD:
				setRelatedHazard((IntegratedHazard)null);
				return;
			case UnifiedPackage.SAFETY_GOAL__SAFE_STATE:
				setSafeState(SAFE_STATE_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				getAllocatedTo().clear();
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
			case UnifiedPackage.SAFETY_GOAL__ASIL_LEVEL:
				return asilLevel != ASIL_LEVEL_EDEFAULT;
			case UnifiedPackage.SAFETY_GOAL__RELATED_HAZARD:
				return relatedHazard != null;
			case UnifiedPackage.SAFETY_GOAL__SAFE_STATE:
				return SAFE_STATE_EDEFAULT == null ? safeState != null : !SAFE_STATE_EDEFAULT.equals(safeState);
			case UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO:
				return allocatedTo != null && !allocatedTo.isEmpty();
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
		result.append(" (asilLevel: ");
		result.append(asilLevel);
		result.append(", safeState: ");
		result.append(safeState);
		result.append(')');
		return result.toString();
	}

} //SafetyGoalImpl
