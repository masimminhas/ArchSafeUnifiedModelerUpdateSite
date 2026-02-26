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

import unified.ASILLevel;
import unified.FMEAItem;
import unified.FunctionalSafetyRequirement;
import unified.SafetyCriticalBlock;
import unified.TechnicalRequirementCategory;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technical Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.TechnicalSafetyRequirementImpl#getTechnicalCategory <em>Technical Category</em>}</li>
 *   <li>{@link unified.impl.TechnicalSafetyRequirementImpl#getAllocatedASIL <em>Allocated ASIL</em>}</li>
 *   <li>{@link unified.impl.TechnicalSafetyRequirementImpl#getRefinesFrom <em>Refines From</em>}</li>
 *   <li>{@link unified.impl.TechnicalSafetyRequirementImpl#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link unified.impl.TechnicalSafetyRequirementImpl#getVerifiedBy <em>Verified By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnicalSafetyRequirementImpl extends RequirementImpl implements TechnicalSafetyRequirement {
	/**
	 * The default value of the '{@link #getTechnicalCategory() <em>Technical Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalCategory()
	 * @generated
	 * @ordered
	 */
	protected static final TechnicalRequirementCategory TECHNICAL_CATEGORY_EDEFAULT = TechnicalRequirementCategory.HARDWARE_REQUIREMENT;

	/**
	 * The cached value of the '{@link #getTechnicalCategory() <em>Technical Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalCategory()
	 * @generated
	 * @ordered
	 */
	protected TechnicalRequirementCategory technicalCategory = TECHNICAL_CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllocatedASIL() <em>Allocated ASIL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedASIL()
	 * @generated
	 * @ordered
	 */
	protected static final ASILLevel ALLOCATED_ASIL_EDEFAULT = ASILLevel.QM;

	/**
	 * The cached value of the '{@link #getAllocatedASIL() <em>Allocated ASIL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedASIL()
	 * @generated
	 * @ordered
	 */
	protected ASILLevel allocatedASIL = ALLOCATED_ASIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefinesFrom() <em>Refines From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinesFrom()
	 * @generated
	 * @ordered
	 */
	protected FunctionalSafetyRequirement refinesFrom;

	/**
	 * The cached value of the '{@link #getRealizedBy() <em>Realized By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCriticalBlock> realizedBy;

	/**
	 * The cached value of the '{@link #getVerifiedBy() <em>Verified By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifiedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<FMEAItem> verifiedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TechnicalSafetyRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnicalRequirementCategory getTechnicalCategory() {
		return technicalCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalCategory(TechnicalRequirementCategory newTechnicalCategory) {
		TechnicalRequirementCategory oldTechnicalCategory = technicalCategory;
		technicalCategory = newTechnicalCategory == null ? TECHNICAL_CATEGORY_EDEFAULT : newTechnicalCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY, oldTechnicalCategory, technicalCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILLevel getAllocatedASIL() {
		return allocatedASIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocatedASIL(ASILLevel newAllocatedASIL) {
		ASILLevel oldAllocatedASIL = allocatedASIL;
		allocatedASIL = newAllocatedASIL == null ? ALLOCATED_ASIL_EDEFAULT : newAllocatedASIL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL, oldAllocatedASIL, allocatedASIL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalSafetyRequirement getRefinesFrom() {
		if (refinesFrom != null && refinesFrom.eIsProxy()) {
			InternalEObject oldRefinesFrom = (InternalEObject)refinesFrom;
			refinesFrom = (FunctionalSafetyRequirement)eResolveProxy(oldRefinesFrom);
			if (refinesFrom != oldRefinesFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM, oldRefinesFrom, refinesFrom));
			}
		}
		return refinesFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalSafetyRequirement basicGetRefinesFrom() {
		return refinesFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinesFrom(FunctionalSafetyRequirement newRefinesFrom, NotificationChain msgs) {
		FunctionalSafetyRequirement oldRefinesFrom = refinesFrom;
		refinesFrom = newRefinesFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM, oldRefinesFrom, newRefinesFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinesFrom(FunctionalSafetyRequirement newRefinesFrom) {
		if (newRefinesFrom != refinesFrom) {
			NotificationChain msgs = null;
			if (refinesFrom != null)
				msgs = ((InternalEObject)refinesFrom).eInverseRemove(this, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO, FunctionalSafetyRequirement.class, msgs);
			if (newRefinesFrom != null)
				msgs = ((InternalEObject)newRefinesFrom).eInverseAdd(this, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO, FunctionalSafetyRequirement.class, msgs);
			msgs = basicSetRefinesFrom(newRefinesFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM, newRefinesFrom, newRefinesFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyCriticalBlock> getRealizedBy() {
		if (realizedBy == null) {
			realizedBy = new EObjectResolvingEList<SafetyCriticalBlock>(SafetyCriticalBlock.class, this, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY);
		}
		return realizedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMEAItem> getVerifiedBy() {
		if (verifiedBy == null) {
			verifiedBy = new EObjectResolvingEList<FMEAItem>(FMEAItem.class, this, UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY);
		}
		return verifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				if (refinesFrom != null)
					msgs = ((InternalEObject)refinesFrom).eInverseRemove(this, UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO, FunctionalSafetyRequirement.class, msgs);
				return basicSetRefinesFrom((FunctionalSafetyRequirement)otherEnd, msgs);
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
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				return basicSetRefinesFrom(null, msgs);
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
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY:
				return getTechnicalCategory();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL:
				return getAllocatedASIL();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				if (resolve) return getRefinesFrom();
				return basicGetRefinesFrom();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY:
				return getRealizedBy();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY:
				return getVerifiedBy();
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
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY:
				setTechnicalCategory((TechnicalRequirementCategory)newValue);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL:
				setAllocatedASIL((ASILLevel)newValue);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				setRefinesFrom((FunctionalSafetyRequirement)newValue);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY:
				getRealizedBy().clear();
				getRealizedBy().addAll((Collection<? extends SafetyCriticalBlock>)newValue);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY:
				getVerifiedBy().clear();
				getVerifiedBy().addAll((Collection<? extends FMEAItem>)newValue);
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
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY:
				setTechnicalCategory(TECHNICAL_CATEGORY_EDEFAULT);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL:
				setAllocatedASIL(ALLOCATED_ASIL_EDEFAULT);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				setRefinesFrom((FunctionalSafetyRequirement)null);
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY:
				getRealizedBy().clear();
				return;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY:
				getVerifiedBy().clear();
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
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY:
				return technicalCategory != TECHNICAL_CATEGORY_EDEFAULT;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL:
				return allocatedASIL != ALLOCATED_ASIL_EDEFAULT;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM:
				return refinesFrom != null;
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY:
				return realizedBy != null && !realizedBy.isEmpty();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY:
				return verifiedBy != null && !verifiedBy.isEmpty();
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
		result.append(" (technicalCategory: ");
		result.append(technicalCategory);
		result.append(", allocatedASIL: ");
		result.append(allocatedASIL);
		result.append(')');
		return result.toString();
	}

} //TechnicalSafetyRequirementImpl
