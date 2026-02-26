/**
 */
package unified;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link unified.BlockConnection#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link unified.BlockConnection#getFromBlock <em>From Block</em>}</li>
 *   <li>{@link unified.BlockConnection#getToBlock <em>To Block</em>}</li>
 * </ul>
 *
 * @see unified.UnifiedPackage#getBlockConnection()
 * @model
 * @generated
 */
public interface BlockConnection extends UnifiedElement {
	/**
	 * Returns the value of the '<em><b>Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link unified.ConnectionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Type</em>' attribute.
	 * @see unified.ConnectionType
	 * @see #setConnectionType(ConnectionType)
	 * @see unified.UnifiedPackage#getBlockConnection_ConnectionType()
	 * @model
	 * @generated
	 */
	ConnectionType getConnectionType();

	/**
	 * Sets the value of the '{@link unified.BlockConnection#getConnectionType <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Type</em>' attribute.
	 * @see unified.ConnectionType
	 * @see #getConnectionType()
	 * @generated
	 */
	void setConnectionType(ConnectionType value);

	/**
	 * Returns the value of the '<em><b>From Block</b></em>' reference list.
	 * The list contents are of type {@link unified.SystemBlock}.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getConnectionAsSource <em>Connection As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Block</em>' reference list.
	 * @see unified.UnifiedPackage#getBlockConnection_FromBlock()
	 * @see unified.SystemBlock#getConnectionAsSource
	 * @model opposite="connectionAsSource" required="true"
	 * @generated
	 */
	EList<SystemBlock> getFromBlock();

	/**
	 * Returns the value of the '<em><b>To Block</b></em>' reference list.
	 * The list contents are of type {@link unified.SystemBlock}.
	 * It is bidirectional and its opposite is '{@link unified.SystemBlock#getConnectionAsTarget <em>Connection As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Block</em>' reference list.
	 * @see unified.UnifiedPackage#getBlockConnection_ToBlock()
	 * @see unified.SystemBlock#getConnectionAsTarget
	 * @model opposite="connectionAsTarget" required="true"
	 * @generated
	 */
	EList<SystemBlock> getToBlock();

} // BlockConnection
