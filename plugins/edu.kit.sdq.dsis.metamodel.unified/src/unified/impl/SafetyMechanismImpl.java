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
import unified.FMEAItem;
import unified.SafetyCriticalBlock;
import unified.SafetyMechanism;
import unified.SafetyMechanismType;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.SafetyMechanismImpl#getMechanismType <em>Mechanism Type</em>}</li>
 *   <li>{@link unified.impl.SafetyMechanismImpl#getDiagnosticCoverage <em>Diagnostic Coverage</em>}</li>
 *   <li>{@link unified.impl.SafetyMechanismImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link unified.impl.SafetyMechanismImpl#getImplementedIn <em>Implemented In</em>}</li>
 *   <li>{@link unified.impl.SafetyMechanismImpl#getValidatedBy <em>Validated By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyMechanismImpl extends UnifiedElementImpl implements SafetyMechanism {
	/**
	 * The default value of the '{@link #getMechanismType() <em>Mechanism Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanismType()
	 * @generated
	 * @ordered
	 */
	protected static final SafetyMechanismType MECHANISM_TYPE_EDEFAULT = SafetyMechanismType.REDUNDANCY;

	/**
	 * The cached value of the '{@link #getMechanismType() <em>Mechanism Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanismType()
	 * @generated
	 * @ordered
	 */
	protected SafetyMechanismType mechanismType = MECHANISM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagnosticCoverage() <em>Diagnostic Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final int DIAGNOSTIC_COVERAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDiagnosticCoverage() <em>Diagnostic Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticCoverage()
	 * @generated
	 * @ordered
	 */
	protected int diagnosticCoverage = DIAGNOSTIC_COVERAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnicalSafetyRequirement> implements_;

	/**
	 * The cached value of the '{@link #getImplementedIn() <em>Implemented In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedIn()
	 * @generated
	 * @ordered
	 */
	protected SafetyCriticalBlock implementedIn;

	/**
	 * The cached value of the '{@link #getValidatedBy() <em>Validated By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidatedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<FMEAItem> validatedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyMechanismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.SAFETY_MECHANISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyMechanismType getMechanismType() {
		return mechanismType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMechanismType(SafetyMechanismType newMechanismType) {
		SafetyMechanismType oldMechanismType = mechanismType;
		mechanismType = newMechanismType == null ? MECHANISM_TYPE_EDEFAULT : newMechanismType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_MECHANISM__MECHANISM_TYPE, oldMechanismType, mechanismType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDiagnosticCoverage() {
		return diagnosticCoverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticCoverage(int newDiagnosticCoverage) {
		int oldDiagnosticCoverage = diagnosticCoverage;
		diagnosticCoverage = newDiagnosticCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE, oldDiagnosticCoverage, diagnosticCoverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TechnicalSafetyRequirement> getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectResolvingEList<TechnicalSafetyRequirement>(TechnicalSafetyRequirement.class, this, UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalBlock getImplementedIn() {
		if (implementedIn != null && implementedIn.eIsProxy()) {
			InternalEObject oldImplementedIn = (InternalEObject)implementedIn;
			implementedIn = (SafetyCriticalBlock)eResolveProxy(oldImplementedIn);
			if (implementedIn != oldImplementedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN, oldImplementedIn, implementedIn));
			}
		}
		return implementedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalBlock basicGetImplementedIn() {
		return implementedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementedIn(SafetyCriticalBlock newImplementedIn) {
		SafetyCriticalBlock oldImplementedIn = implementedIn;
		implementedIn = newImplementedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN, oldImplementedIn, implementedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMEAItem> getValidatedBy() {
		if (validatedBy == null) {
			validatedBy = new EObjectWithInverseResolvingEList.ManyInverse<FMEAItem>(FMEAItem.class, this, UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY, UnifiedPackage.FMEA_ITEM__VALIDATES_MECHANISMS);
		}
		return validatedBy;
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
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValidatedBy()).basicAdd(otherEnd, msgs);
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
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				return ((InternalEList<?>)getValidatedBy()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.SAFETY_MECHANISM__MECHANISM_TYPE:
				return getMechanismType();
			case UnifiedPackage.SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE:
				return getDiagnosticCoverage();
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTS:
				return getImplements();
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN:
				if (resolve) return getImplementedIn();
				return basicGetImplementedIn();
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				return getValidatedBy();
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
			case UnifiedPackage.SAFETY_MECHANISM__MECHANISM_TYPE:
				setMechanismType((SafetyMechanismType)newValue);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE:
				setDiagnosticCoverage((Integer)newValue);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection<? extends TechnicalSafetyRequirement>)newValue);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN:
				setImplementedIn((SafetyCriticalBlock)newValue);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				getValidatedBy().clear();
				getValidatedBy().addAll((Collection<? extends FMEAItem>)newValue);
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
			case UnifiedPackage.SAFETY_MECHANISM__MECHANISM_TYPE:
				setMechanismType(MECHANISM_TYPE_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE:
				setDiagnosticCoverage(DIAGNOSTIC_COVERAGE_EDEFAULT);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTS:
				getImplements().clear();
				return;
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN:
				setImplementedIn((SafetyCriticalBlock)null);
				return;
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				getValidatedBy().clear();
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
			case UnifiedPackage.SAFETY_MECHANISM__MECHANISM_TYPE:
				return mechanismType != MECHANISM_TYPE_EDEFAULT;
			case UnifiedPackage.SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE:
				return diagnosticCoverage != DIAGNOSTIC_COVERAGE_EDEFAULT;
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case UnifiedPackage.SAFETY_MECHANISM__IMPLEMENTED_IN:
				return implementedIn != null;
			case UnifiedPackage.SAFETY_MECHANISM__VALIDATED_BY:
				return validatedBy != null && !validatedBy.isEmpty();
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
		result.append(" (mechanismType: ");
		result.append(mechanismType);
		result.append(", diagnosticCoverage: ");
		result.append(diagnosticCoverage);
		result.append(')');
		return result.toString();
	}

} //SafetyMechanismImpl
