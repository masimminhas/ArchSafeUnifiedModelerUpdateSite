/**
 */
package unified.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import unified.Requirement;
import unified.RequirementStatus;
import unified.SystemBlock;
import unified.UnifiedPackage;
import unified.VerificationMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.RequirementImpl#getRequirementId <em>Requirement Id</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getRequirementText <em>Requirement Text</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link unified.impl.RequirementImpl#getSatisfiedBy <em>Satisfied By</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RequirementImpl extends UnifiedElementImpl implements Requirement {
	/**
	 * The default value of the '{@link #getRequirementId() <em>Requirement Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementId()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirementId() <em>Requirement Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementId()
	 * @generated
	 * @ordered
	 */
	protected String requirementId = REQUIREMENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirementText() <em>Requirement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementText()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirementText() <em>Requirement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementText()
	 * @generated
	 * @ordered
	 */
	protected String requirementText = REQUIREMENT_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementStatus STATUS_EDEFAULT = RequirementStatus.DRAFT;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected RequirementStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerificationMethod() <em>Verification Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationMethod()
	 * @generated
	 * @ordered
	 */
	protected static final VerificationMethod VERIFICATION_METHOD_EDEFAULT = VerificationMethod.INSPECTION;

	/**
	 * The cached value of the '{@link #getVerificationMethod() <em>Verification Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationMethod()
	 * @generated
	 * @ordered
	 */
	protected VerificationMethod verificationMethod = VERIFICATION_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected static final String RATIONALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected String rationale = RATIONALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> derivedFrom;

	/**
	 * The cached value of the '{@link #getSatisfiedBy() <em>Satisfied By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatisfiedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemBlock> satisfiedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequirementId() {
		return requirementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementId(String newRequirementId) {
		String oldRequirementId = requirementId;
		requirementId = newRequirementId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.REQUIREMENT__REQUIREMENT_ID, oldRequirementId, requirementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequirementText() {
		return requirementText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementText(String newRequirementText) {
		String oldRequirementText = requirementText;
		requirementText = newRequirementText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.REQUIREMENT__REQUIREMENT_TEXT, oldRequirementText, requirementText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(RequirementStatus newStatus) {
		RequirementStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.REQUIREMENT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationMethod getVerificationMethod() {
		return verificationMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerificationMethod(VerificationMethod newVerificationMethod) {
		VerificationMethod oldVerificationMethod = verificationMethod;
		verificationMethod = newVerificationMethod == null ? VERIFICATION_METHOD_EDEFAULT : newVerificationMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.REQUIREMENT__VERIFICATION_METHOD, oldVerificationMethod, verificationMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRationale(String newRationale) {
		String oldRationale = rationale;
		rationale = newRationale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.REQUIREMENT__RATIONALE, oldRationale, rationale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDerivedFrom() {
		if (derivedFrom == null) {
			derivedFrom = new EObjectResolvingEList<Requirement>(Requirement.class, this, UnifiedPackage.REQUIREMENT__DERIVED_FROM);
		}
		return derivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemBlock> getSatisfiedBy() {
		if (satisfiedBy == null) {
			satisfiedBy = new EObjectResolvingEList<SystemBlock>(SystemBlock.class, this, UnifiedPackage.REQUIREMENT__SATISFIED_BY);
		}
		return satisfiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_ID:
				return getRequirementId();
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_TEXT:
				return getRequirementText();
			case UnifiedPackage.REQUIREMENT__STATUS:
				return getStatus();
			case UnifiedPackage.REQUIREMENT__VERIFICATION_METHOD:
				return getVerificationMethod();
			case UnifiedPackage.REQUIREMENT__RATIONALE:
				return getRationale();
			case UnifiedPackage.REQUIREMENT__DERIVED_FROM:
				return getDerivedFrom();
			case UnifiedPackage.REQUIREMENT__SATISFIED_BY:
				return getSatisfiedBy();
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
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_ID:
				setRequirementId((String)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_TEXT:
				setRequirementText((String)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__STATUS:
				setStatus((RequirementStatus)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__VERIFICATION_METHOD:
				setVerificationMethod((VerificationMethod)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__RATIONALE:
				setRationale((String)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__DERIVED_FROM:
				getDerivedFrom().clear();
				getDerivedFrom().addAll((Collection<? extends Requirement>)newValue);
				return;
			case UnifiedPackage.REQUIREMENT__SATISFIED_BY:
				getSatisfiedBy().clear();
				getSatisfiedBy().addAll((Collection<? extends SystemBlock>)newValue);
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
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_ID:
				setRequirementId(REQUIREMENT_ID_EDEFAULT);
				return;
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_TEXT:
				setRequirementText(REQUIREMENT_TEXT_EDEFAULT);
				return;
			case UnifiedPackage.REQUIREMENT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case UnifiedPackage.REQUIREMENT__VERIFICATION_METHOD:
				setVerificationMethod(VERIFICATION_METHOD_EDEFAULT);
				return;
			case UnifiedPackage.REQUIREMENT__RATIONALE:
				setRationale(RATIONALE_EDEFAULT);
				return;
			case UnifiedPackage.REQUIREMENT__DERIVED_FROM:
				getDerivedFrom().clear();
				return;
			case UnifiedPackage.REQUIREMENT__SATISFIED_BY:
				getSatisfiedBy().clear();
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
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_ID:
				return REQUIREMENT_ID_EDEFAULT == null ? requirementId != null : !REQUIREMENT_ID_EDEFAULT.equals(requirementId);
			case UnifiedPackage.REQUIREMENT__REQUIREMENT_TEXT:
				return REQUIREMENT_TEXT_EDEFAULT == null ? requirementText != null : !REQUIREMENT_TEXT_EDEFAULT.equals(requirementText);
			case UnifiedPackage.REQUIREMENT__STATUS:
				return status != STATUS_EDEFAULT;
			case UnifiedPackage.REQUIREMENT__VERIFICATION_METHOD:
				return verificationMethod != VERIFICATION_METHOD_EDEFAULT;
			case UnifiedPackage.REQUIREMENT__RATIONALE:
				return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
			case UnifiedPackage.REQUIREMENT__DERIVED_FROM:
				return derivedFrom != null && !derivedFrom.isEmpty();
			case UnifiedPackage.REQUIREMENT__SATISFIED_BY:
				return satisfiedBy != null && !satisfiedBy.isEmpty();
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
		result.append(" (requirementId: ");
		result.append(requirementId);
		result.append(", requirementText: ");
		result.append(requirementText);
		result.append(", status: ");
		result.append(status);
		result.append(", verificationMethod: ");
		result.append(verificationMethod);
		result.append(", rationale: ");
		result.append(rationale);
		result.append(')');
		return result.toString();
	}

} //RequirementImpl
