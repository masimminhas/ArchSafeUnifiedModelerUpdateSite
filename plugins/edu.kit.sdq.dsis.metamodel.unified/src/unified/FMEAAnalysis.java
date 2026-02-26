/**
 */
package unified;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMEA Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.FMEAAnalysis#getRpnThreshold <em>Rpn Threshold</em>}</li>
 *   <li>{@link unified.FMEAAnalysis#getFmeaItems <em>Fmea Items</em>}</li>
 *   <li>{@link unified.FMEAAnalysis#getAnalysisDate <em>Analysis Date</em>}</li>
 *   <li>{@link unified.FMEAAnalysis#getAnalysisStatus <em>Analysis Status</em>}</li>
 *   <li>{@link unified.FMEAAnalysis#getReviewer <em>Reviewer</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getFMEAAnalysis()
 * @model
 * @generated
 */
public interface FMEAAnalysis extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Rpn Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rpn Threshold</em>' attribute.
	 * @see #setRpnThreshold(int)
	 * @see unified.UnifiedPackage#getFMEAAnalysis_RpnThreshold()
	 * @model
	 * @generated
	 */
	int getRpnThreshold();

	/**
	 * Sets the value of the '{@link unified.FMEAAnalysis#getRpnThreshold <em>Rpn Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rpn Threshold</em>' attribute.
	 * @see #getRpnThreshold()
	 * @generated
	 */
	void setRpnThreshold(int value);

	/**
	 * Returns the value of the '<em><b>Fmea Items</b></em>' containment reference list.
	 * The list contents are of type {@link unified.FMEAItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmea Items</em>' containment reference list.
	 * @see unified.UnifiedPackage#getFMEAAnalysis_FmeaItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<FMEAItem> getFmeaItems();

	/**
	 * Returns the value of the '<em><b>Analysis Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Date</em>' attribute.
	 * @see #setAnalysisDate(Date)
	 * @see unified.UnifiedPackage#getFMEAAnalysis_AnalysisDate()
	 * @model
	 * @generated
	 */
	Date getAnalysisDate();

	/**
	 * Sets the value of the '{@link unified.FMEAAnalysis#getAnalysisDate <em>Analysis Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Date</em>' attribute.
	 * @see #getAnalysisDate()
	 * @generated
	 */
	void setAnalysisDate(Date value);

	/**
	 * Returns the value of the '<em><b>Analysis Status</b></em>' attribute.
	 * The default value is <code>"DRAFT"</code>.
	 * The literals are from the enumeration {@link unified.AnalysisStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Status</em>' attribute.
	 * @see unified.AnalysisStatus
	 * @see #setAnalysisStatus(AnalysisStatus)
	 * @see unified.UnifiedPackage#getFMEAAnalysis_AnalysisStatus()
	 * @model default="DRAFT"
	 * @generated
	 */
	AnalysisStatus getAnalysisStatus();

	/**
	 * Sets the value of the '{@link unified.FMEAAnalysis#getAnalysisStatus <em>Analysis Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Status</em>' attribute.
	 * @see unified.AnalysisStatus
	 * @see #getAnalysisStatus()
	 * @generated
	 */
	void setAnalysisStatus(AnalysisStatus value);

	/**
	 * Returns the value of the '<em><b>Reviewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviewer</em>' attribute.
	 * @see #setReviewer(String)
	 * @see unified.UnifiedPackage#getFMEAAnalysis_Reviewer()
	 * @model
	 * @generated
	 */
	String getReviewer();

	/**
	 * Sets the value of the '{@link unified.FMEAAnalysis#getReviewer <em>Reviewer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviewer</em>' attribute.
	 * @see #getReviewer()
	 * @generated
	 */
	void setReviewer(String value);

} // FMEAAnalysis
