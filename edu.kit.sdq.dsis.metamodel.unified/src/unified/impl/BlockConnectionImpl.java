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

import unified.BlockConnection;
import unified.ConnectionType;
import unified.SystemBlock;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.BlockConnectionImpl#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link unified.impl.BlockConnectionImpl#getFromBlock <em>From Block</em>}</li>
 *   <li>{@link unified.impl.BlockConnectionImpl#getToBlock <em>To Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockConnectionImpl extends UnifiedElementImpl implements BlockConnection {
	/**
	 * The default value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionType CONNECTION_TYPE_EDEFAULT = ConnectionType.DATA_FLOW;

	/**
	 * The cached value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected ConnectionType connectionType = CONNECTION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFromBlock() <em>From Block</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromBlock()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemBlock> fromBlock;

	/**
	 * The cached value of the '{@link #getToBlock() <em>To Block</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToBlock()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemBlock> toBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.BLOCK_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType getConnectionType() {
		return connectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(ConnectionType newConnectionType) {
		ConnectionType oldConnectionType = connectionType;
		connectionType = newConnectionType == null ? CONNECTION_TYPE_EDEFAULT : newConnectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_CONNECTION__CONNECTION_TYPE, oldConnectionType, connectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemBlock> getFromBlock() {
		if (fromBlock == null) {
			fromBlock = new EObjectWithInverseResolvingEList.ManyInverse<SystemBlock>(SystemBlock.class, this, UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK, UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE);
		}
		return fromBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemBlock> getToBlock() {
		if (toBlock == null) {
			toBlock = new EObjectWithInverseResolvingEList.ManyInverse<SystemBlock>(SystemBlock.class, this, UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK, UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET);
		}
		return toBlock;
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
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFromBlock()).basicAdd(otherEnd, msgs);
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getToBlock()).basicAdd(otherEnd, msgs);
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
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				return ((InternalEList<?>)getFromBlock()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				return ((InternalEList<?>)getToBlock()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.BLOCK_CONNECTION__CONNECTION_TYPE:
				return getConnectionType();
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				return getFromBlock();
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				return getToBlock();
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
			case UnifiedPackage.BLOCK_CONNECTION__CONNECTION_TYPE:
				setConnectionType((ConnectionType)newValue);
				return;
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				getFromBlock().clear();
				getFromBlock().addAll((Collection<? extends SystemBlock>)newValue);
				return;
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				getToBlock().clear();
				getToBlock().addAll((Collection<? extends SystemBlock>)newValue);
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
			case UnifiedPackage.BLOCK_CONNECTION__CONNECTION_TYPE:
				setConnectionType(CONNECTION_TYPE_EDEFAULT);
				return;
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				getFromBlock().clear();
				return;
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				getToBlock().clear();
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
			case UnifiedPackage.BLOCK_CONNECTION__CONNECTION_TYPE:
				return connectionType != CONNECTION_TYPE_EDEFAULT;
			case UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK:
				return fromBlock != null && !fromBlock.isEmpty();
			case UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK:
				return toBlock != null && !toBlock.isEmpty();
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
		result.append(" (connectionType: ");
		result.append(connectionType);
		result.append(')');
		return result.toString();
	}

} //BlockConnectionImpl
