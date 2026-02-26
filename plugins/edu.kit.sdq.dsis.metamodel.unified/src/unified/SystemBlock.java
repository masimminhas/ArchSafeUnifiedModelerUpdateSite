/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Regular system components without mandatory safety annotations for non-critical parts
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.SystemBlock#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link unified.SystemBlock#getParentBlock <em>Parent Block</em>}</li>
 *   <li>{@link unified.SystemBlock#getAssociationAsSource <em>Association As Source</em>}</li>
 *   <li>{@link unified.SystemBlock#getAssociationAsTarget <em>Association As Target</em>}</li>
 *   <li>{@link unified.SystemBlock#getConnectionAsSource <em>Connection As Source</em>}</li>
 *   <li>{@link unified.SystemBlock#getConnectionAsTarget <em>Connection As Target</em>}</li>
 *   <li>{@link unified.SystemBlock#getBlockType <em>Block Type</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getSystemBlock()
 * @model
 * @generated
 */
public interface SystemBlock extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Sub Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link unified.SystemBlock}.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getParentBlock <em>Parent Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Blocks</em>' containment reference list.
	 * @see unified.UnifiedPackage#getSystemBlock_SubBlocks()
	 * @see unified.SystemBlock#getParentBlock
	 * @model opposite="parentBlock" containment="true"
	 * @generated
	 */
	EList<SystemBlock> getSubBlocks();

	/**
	 * Returns the value of the '<em><b>Parent Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getSubBlocks <em>Sub Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Block</em>' container reference.
	 * @see #setParentBlock(SystemBlock)
	 * @see unified.UnifiedPackage#getSystemBlock_ParentBlock()
	 * @see unified.SystemBlock#getSubBlocks
	 * @model opposite="subBlocks" transient="false"
	 * @generated
	 */
	SystemBlock getParentBlock();

	/**
	 * Sets the value of the '{@link unified.SystemBlock#getParentBlock <em>Parent Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Block</em>' container reference.
	 * @see #getParentBlock()
	 * @generated
	 */
	void setParentBlock(SystemBlock value);

	/**
	 * Returns the value of the '<em><b>Association As Source</b></em>' reference list.
	 * The list contents are of type {@link unified.BlockAssociation}.
	 * It is bidirectional and its opposite is '{@link unified.BlockAssociation#getSourceBlock <em>Source Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association As Source</em>' reference list.
	 * @see unified.UnifiedPackage#getSystemBlock_AssociationAsSource()
	 * @see unified.BlockAssociation#getSourceBlock
	 * @model opposite="sourceBlock"
	 * @generated
	 */
	EList<BlockAssociation> getAssociationAsSource();

	/**
	 * Returns the value of the '<em><b>Association As Target</b></em>' reference list.
	 * The list contents are of type {@link unified.BlockAssociation}.
	 * It is bidirectional and its opposite is '{@link unified.BlockAssociation#getTargetBlock <em>Target Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association As Target</em>' reference list.
	 * @see unified.UnifiedPackage#getSystemBlock_AssociationAsTarget()
	 * @see unified.BlockAssociation#getTargetBlock
	 * @model opposite="targetBlock"
	 * @generated
	 */
	EList<BlockAssociation> getAssociationAsTarget();

	/**
	 * Returns the value of the '<em><b>Connection As Source</b></em>' reference list.
	 * The list contents are of type {@link unified.BlockConnection}.
	 * It is bidirectional and its opposite is '{@link unified.BlockConnection#getFromBlock <em>From Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection As Source</em>' reference list.
	 * @see unified.UnifiedPackage#getSystemBlock_ConnectionAsSource()
	 * @see unified.BlockConnection#getFromBlock
	 * @model opposite="fromBlock"
	 * @generated
	 */
	EList<BlockConnection> getConnectionAsSource();

	/**
	 * Returns the value of the '<em><b>Connection As Target</b></em>' reference list.
	 * The list contents are of type {@link unified.BlockConnection}.
	 * It is bidirectional and its opposite is '{@link unified.BlockConnection#getToBlock <em>To Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection As Target</em>' reference list.
	 * @see unified.UnifiedPackage#getSystemBlock_ConnectionAsTarget()
	 * @see unified.BlockConnection#getToBlock
	 * @model opposite="toBlock"
	 * @generated
	 */
	EList<BlockConnection> getConnectionAsTarget();

	/**
	 * Returns the value of the '<em><b>Block Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.BlockType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Type</em>' attribute.
	 * @see unified.BlockType
	 * @see #setBlockType(BlockType)
	 * @see unified.UnifiedPackage#getSystemBlock_BlockType()
	 * @model
	 * @generated
	 */
	BlockType getBlockType();

	/**
	 * Sets the value of the '{@link unified.SystemBlock#getBlockType <em>Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Type</em>' attribute.
	 * @see unified.BlockType
	 * @see #getBlockType()
	 * @generated
	 */
	void setBlockType(BlockType value);

} // SystemBlock
