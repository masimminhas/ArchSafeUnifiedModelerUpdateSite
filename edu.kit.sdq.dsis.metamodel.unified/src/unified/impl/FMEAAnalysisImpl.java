/**
 */
package unified.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.AnalysisStatus;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMEA Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.FMEAAnalysisImpl#getRpnThreshold <em>Rpn Threshold</em>}</li>
 *   <li>{@link unified.impl.FMEAAnalysisImpl#getFmeaItems <em>Fmea Items</em>}</li>
 *   <li>{@link unified.impl.FMEAAnalysisImpl#getAnalysisDate <em>Analysis Date</em>}</li>
 *   <li>{@link unified.impl.FMEAAnalysisImpl#getAnalysisStatus <em>Analysis Status</em>}</li>
 *   <li>{@link unified.impl.FMEAAnalysisImpl#getReviewer <em>Reviewer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FMEAAnalysisImpl extends UnifiedElementImpl implements FMEAAnalysis {
	/**
	 * The default value of the '{@link #getRpnThreshold() <em>Rpn Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRpnThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final int RPN_THRESHOLD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRpnThreshold() <em>Rpn Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRpnThreshold()
	 * @generated
	 * @ordered
	 */
	protected int rpnThreshold = RPN_THRESHOLD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFmeaItems() <em>Fmea Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmeaItems()
	 * @generated
	 * @ordered
	 */
	protected EList<FMEAItem> fmeaItems;

	/**
	 * The default value of the '{@link #getAnalysisDate() <em>Analysis Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ANALYSIS_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalysisDate() <em>Analysis Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisDate()
	 * @generated
	 * @ordered
	 */
	protected Date analysisDate = ANALYSIS_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAnalysisStatus() <em>Analysis Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisStatus()
	 * @generated
	 * @ordered
	 */
	protected static final AnalysisStatus ANALYSIS_STATUS_EDEFAULT = AnalysisStatus.DRAFT;

	/**
	 * The cached value of the '{@link #getAnalysisStatus() <em>Analysis Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisStatus()
	 * @generated
	 * @ordered
	 */
	protected AnalysisStatus analysisStatus = ANALYSIS_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getReviewer() <em>Reviewer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewer()
	 * @generated
	 * @ordered
	 */
	protected static final String REVIEWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReviewer() <em>Reviewer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewer()
	 * @generated
	 * @ordered
	 */
	protected String reviewer = REVIEWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMEAAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.FMEA_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRpnThreshold() {
		return rpnThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRpnThreshold(int newRpnThreshold) {
		int oldRpnThreshold = rpnThreshold;
		rpnThreshold = newRpnThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FMEA_ANALYSIS__RPN_THRESHOLD, oldRpnThreshold, rpnThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMEAItem> getFmeaItems() {
		if (fmeaItems == null) {
			fmeaItems = new EObjectContainmentEList<FMEAItem>(FMEAItem.class, this, UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS);
		}
		return fmeaItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getAnalysisDate() {
		return analysisDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisDate(Date newAnalysisDate) {
		Date oldAnalysisDate = analysisDate;
		analysisDate = newAnalysisDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_DATE, oldAnalysisDate, analysisDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisStatus getAnalysisStatus() {
		return analysisStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisStatus(AnalysisStatus newAnalysisStatus) {
		AnalysisStatus oldAnalysisStatus = analysisStatus;
		analysisStatus = newAnalysisStatus == null ? ANALYSIS_STATUS_EDEFAULT : newAnalysisStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_STATUS, oldAnalysisStatus, analysisStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReviewer() {
		return reviewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewer(String newReviewer) {
		String oldReviewer = reviewer;
		reviewer = newReviewer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.FMEA_ANALYSIS__REVIEWER, oldReviewer, reviewer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS:
				return ((InternalEList<?>)getFmeaItems()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.FMEA_ANALYSIS__RPN_THRESHOLD:
				return getRpnThreshold();
			case UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS:
				return getFmeaItems();
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_DATE:
				return getAnalysisDate();
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_STATUS:
				return getAnalysisStatus();
			case UnifiedPackage.FMEA_ANALYSIS__REVIEWER:
				return getReviewer();
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
			case UnifiedPackage.FMEA_ANALYSIS__RPN_THRESHOLD:
				setRpnThreshold((Integer)newValue);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS:
				getFmeaItems().clear();
				getFmeaItems().addAll((Collection<? extends FMEAItem>)newValue);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_DATE:
				setAnalysisDate((Date)newValue);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_STATUS:
				setAnalysisStatus((AnalysisStatus)newValue);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__REVIEWER:
				setReviewer((String)newValue);
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
			case UnifiedPackage.FMEA_ANALYSIS__RPN_THRESHOLD:
				setRpnThreshold(RPN_THRESHOLD_EDEFAULT);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS:
				getFmeaItems().clear();
				return;
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_DATE:
				setAnalysisDate(ANALYSIS_DATE_EDEFAULT);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_STATUS:
				setAnalysisStatus(ANALYSIS_STATUS_EDEFAULT);
				return;
			case UnifiedPackage.FMEA_ANALYSIS__REVIEWER:
				setReviewer(REVIEWER_EDEFAULT);
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
			case UnifiedPackage.FMEA_ANALYSIS__RPN_THRESHOLD:
				return rpnThreshold != RPN_THRESHOLD_EDEFAULT;
			case UnifiedPackage.FMEA_ANALYSIS__FMEA_ITEMS:
				return fmeaItems != null && !fmeaItems.isEmpty();
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_DATE:
				return ANALYSIS_DATE_EDEFAULT == null ? analysisDate != null : !ANALYSIS_DATE_EDEFAULT.equals(analysisDate);
			case UnifiedPackage.FMEA_ANALYSIS__ANALYSIS_STATUS:
				return analysisStatus != ANALYSIS_STATUS_EDEFAULT;
			case UnifiedPackage.FMEA_ANALYSIS__REVIEWER:
				return REVIEWER_EDEFAULT == null ? reviewer != null : !REVIEWER_EDEFAULT.equals(reviewer);
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
		result.append(" (rpnThreshold: ");
		result.append(rpnThreshold);
		result.append(", analysisDate: ");
		result.append(analysisDate);
		result.append(", analysisStatus: ");
		result.append(analysisStatus);
		result.append(", reviewer: ");
		result.append(reviewer);
		result.append(')');
		return result.toString();
	}

} //FMEAAnalysisImpl
