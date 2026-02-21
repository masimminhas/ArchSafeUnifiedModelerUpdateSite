/**
 */
package unified;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.BlockAssociation#getAssociationType <em>Association Type</em>}</li>
 *   <li>{@link unified.BlockAssociation#getSourceBlock <em>Source Block</em>}</li>
 *   <li>{@link unified.BlockAssociation#getTargetBlock <em>Target Block</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getBlockAssociation()
 * @model
 * @generated
 */
public interface BlockAssociation extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Association Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.AssociationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Type</em>' attribute.
	 * @see unified.AssociationType
	 * @see #setAssociationType(AssociationType)
	 * @see unified.UnifiedPackage#getBlockAssociation_AssociationType()
	 * @model
	 * @generated
	 */
	AssociationType getAssociationType();

	/**
	 * Sets the value of the '{@link unified.BlockAssociation#getAssociationType <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Type</em>' attribute.
	 * @see unified.AssociationType
	 * @see #getAssociationType()
	 * @generated
	 */
	void setAssociationType(AssociationType value);

	/**
	 * Returns the value of the '<em><b>Source Block</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getAssociationAsSource <em>Association As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Block</em>' reference.
	 * @see #setSourceBlock(SystemBlock)
	 * @see unified.UnifiedPackage#getBlockAssociation_SourceBlock()
	 * @see unified.SystemBlock#getAssociationAsSource
	 * @model opposite="associationAsSource"
	 * @generated
	 */
	SystemBlock getSourceBlock();

	/**
	 * Sets the value of the '{@link unified.BlockAssociation#getSourceBlock <em>Source Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Block</em>' reference.
	 * @see #getSourceBlock()
	 * @generated
	 */
	void setSourceBlock(SystemBlock value);

	/**
	 * Returns the value of the '<em><b>Target Block</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getAssociationAsTarget <em>Association As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Block</em>' reference.
	 * @see #setTargetBlock(SystemBlock)
	 * @see unified.UnifiedPackage#getBlockAssociation_TargetBlock()
	 * @see unified.SystemBlock#getAssociationAsTarget
	 * @model opposite="associationAsTarget"
	 * @generated
	 */
	SystemBlock getTargetBlock();

	/**
	 * Sets the value of the '{@link unified.BlockAssociation#getTargetBlock <em>Target Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Block</em>' reference.
	 * @see #getTargetBlock()
	 * @generated
	 */
	void setTargetBlock(SystemBlock value);

} // BlockAssociation
