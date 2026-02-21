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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.FunctionalRequirementType;
import unified.FunctionalSafetyRequirement;
import unified.SafetyCriticalBlock;
import unified.SafetyGoal;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.FunctionalSafetyRequirementImpl#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link unified.impl.FunctionalSafetyRequirementImpl#getAllocatedFrom <em>Allocated From</em>}</li>
 *   <li>{@link unified.impl.FunctionalSafetyRequirementImpl#getRefinedTo <em>Refined To</em>}</li>
 *   <li>{@link unified.impl.FunctionalSafetyRequirementImpl#getImplementedBy <em>Implemented By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionalSafetyRequirementImpl extends RequirementImpl implements FunctionalSafetyRequirement {
	/**
	 * The default value of the '{@link #getRequirementType() <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementType()
	 * @generated
	 * @ordered
	 */
	protected static final FunctionalRequirementType REQUIREMENT_TYPE_EDEFAULT = FunctionalRequirementType.FAULT_DETECTION;

	/**
	 * The cached value of the '{@link #getRequirementType() <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementType()
	 * @generated
	 * @ordered
	 */
	protected FunctionalRequirementType requirementType = REQUIREMENT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocatedFrom() <em>Allocated From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedFrom()
	 * @generated
	 * @ordered
	 */
	protected SafetyGoal allocatedFrom;

	/**
	 * The cached value of the '{@link #getRefinedTo() <em>Refined To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnicalSafetyRequirement> refinedTo;

	/**
	 * The cached value of the '{@link #getImplementedBy() <em>Implemented By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCriticalBlock> implementedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalSafetyRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.FUNCTIONAL_SAFETY_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirementType getRequirementType() {
		return requirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementType(FunctionalRequirementType newRequirementType) {
		FunctionalRequirementType oldRequirementType = requirementType;
		requirementType = newRequirementType == null ? REQUIREMENT_TYPE_EDEFAULT : newRequirementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE, oldRequirementType, requirementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyGoal getAllocatedFrom() {
		if (allocatedFrom != null && allocatedFrom.eIsProxy()) {
			InternalEObject oldAllocatedFrom = (InternalEObject)allocatedFrom;
			allocatedFrom = (SafetyGoal)eResolveProxy(oldAllocatedFrom);
			if (allocatedFrom != oldAllocatedFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM, oldAllocatedFrom, allocatedFrom));
			}
		}
		return allocatedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyGoal basicGetAllocatedFrom() {
		return allocatedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAllocatedFrom(SafetyGoal newAllocatedFrom, NotificationChain msgs) {
		SafetyGoal oldAllocatedFrom = allocatedFrom;
		allocatedFrom = newAllocatedFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM, oldAllocatedFrom, newAllocatedFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocatedFrom(SafetyGoal newAllocatedFrom) {
		if (newAllocatedFrom != allocatedFrom) {
			NotificationChain msgs = null;
			if (allocatedFrom != null)
				msgs = ((InternalEObject)allocatedFrom).eInverseRemove(this, UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO, SafetyGoal.class, msgs);
			if (newAllocatedFrom != null)
				msgs = ((InternalEObject)newAllocatedFrom).eInverseAdd(this, UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO, SafetyGoal.class, msgs);
			msgs = basicSetAllocatedFrom(newAllocatedFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM, newAllocatedFrom, newAllocatedFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TechnicalSafetyRequirement> getRefinedTo() {
		if (refinedTo == null) {
			refinedTo = new EObjectWithInverseResolvingEList<TechnicalSafetyRequirement>(TechnicalSafetyRequirement.class, this, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM);
		}
		return refinedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyCriticalBlock> getImplementedBy() {
		if (implementedBy == null) {
			implementedBy = new EObjectResolvingEList<SafetyCriticalBlock>(SafetyCriticalBlock.class, this, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY);
		}
		return implementedBy;
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				if (allocatedFrom != null)
					msgs = ((InternalEObject)allocatedFrom).eInverseRemove(this, UnifiedPackage.SAFETY_GOAL__ALLOCATED_TO, SafetyGoal.class, msgs);
				return basicSetAllocatedFrom((SafetyGoal)otherEnd, msgs);
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefinedTo()).basicAdd(otherEnd, msgs);
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				return basicSetAllocatedFrom(null, msgs);
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				return ((InternalEList<?>)getRefinedTo()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE:
				return getRequirementType();
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				if (resolve) return getAllocatedFrom();
				return basicGetAllocatedFrom();
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				return getRefinedTo();
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY:
				return getImplementedBy();
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE:
				setRequirementType((FunctionalRequirementType)newValue);
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				setAllocatedFrom((SafetyGoal)newValue);
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				getRefinedTo().clear();
				getRefinedTo().addAll((Collection<? extends TechnicalSafetyRequirement>)newValue);
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY:
				getImplementedBy().clear();
				getImplementedBy().addAll((Collection<? extends SafetyCriticalBlock>)newValue);
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE:
				setRequirementType(REQUIREMENT_TYPE_EDEFAULT);
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				setAllocatedFrom((SafetyGoal)null);
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				getRefinedTo().clear();
				return;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY:
				getImplementedBy().clear();
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
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE:
				return requirementType != REQUIREMENT_TYPE_EDEFAULT;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM:
				return allocatedFrom != null;
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO:
				return refinedTo != null && !refinedTo.isEmpty();
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY:
				return implementedBy != null && !implementedBy.isEmpty();
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
		result.append(" (requirementType: ");
		result.append(requirementType);
		result.append(')');
		return result.toString();
	}

} //FunctionalSafetyRequirementImpl
