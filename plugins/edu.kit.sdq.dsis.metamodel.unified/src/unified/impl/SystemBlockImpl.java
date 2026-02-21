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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.BlockAssociation;
import unified.BlockConnection;
import unified.BlockType;
import unified.SystemBlock;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.SystemBlockImpl#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getParentBlock <em>Parent Block</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getAssociationAsSource <em>Association As Source</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getAssociationAsTarget <em>Association As Target</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getConnectionAsSource <em>Connection As Source</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getConnectionAsTarget <em>Connection As Target</em>}</li>
 *   <li>{@link unified.impl.SystemBlockImpl#getBlockType <em>Block Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemBlockImpl extends UnifiedElementImpl implements SystemBlock {
	/**
	 * The cached value of the '{@link #getSubBlocks() <em>Sub Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemBlock> subBlocks;

	/**
	 * The cached value of the '{@link #getAssociationAsSource() <em>Association As Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationAsSource()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockAssociation> associationAsSource;

	/**
	 * The cached value of the '{@link #getAssociationAsTarget() <em>Association As Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationAsTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockAssociation> associationAsTarget;

	/**
	 * The cached value of the '{@link #getConnectionAsSource() <em>Connection As Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionAsSource()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockConnection> connectionAsSource;

	/**
	 * The cached value of the '{@link #getConnectionAsTarget() <em>Connection As Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionAsTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockConnection> connectionAsTarget;

	/**
	 * The default value of the '{@link #getBlockType() <em>Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockType()
	 * @generated
	 * @ordered
	 */
	protected static final BlockType BLOCK_TYPE_EDEFAULT = BlockType.SENSOR;

	/**
	 * The cached value of the '{@link #getBlockType() <em>Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockType()
	 * @generated
	 * @ordered
	 */
	protected BlockType blockType = BLOCK_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.SYSTEM_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemBlock> getSubBlocks() {
		if (subBlocks == null) {
			subBlocks = new EObjectContainmentWithInverseEList<SystemBlock>(SystemBlock.class, this, UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS, UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK);
		}
		return subBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock getParentBlock() {
		if (eContainerFeatureID() != UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK) return null;
		return (SystemBlock)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentBlock(SystemBlock newParentBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentBlock, UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentBlock(SystemBlock newParentBlock) {
		if (newParentBlock != eInternalContainer() || (eContainerFeatureID() != UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK && newParentBlock != null)) {
			if (EcoreUtil.isAncestor(this, newParentBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentBlock != null)
				msgs = ((InternalEObject)newParentBlock).eInverseAdd(this, UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS, SystemBlock.class, msgs);
			msgs = basicSetParentBlock(newParentBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK, newParentBlock, newParentBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockAssociation> getAssociationAsSource() {
		if (associationAsSource == null) {
			associationAsSource = new EObjectWithInverseResolvingEList<BlockAssociation>(BlockAssociation.class, this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE, UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK);
		}
		return associationAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockAssociation> getAssociationAsTarget() {
		if (associationAsTarget == null) {
			associationAsTarget = new EObjectWithInverseResolvingEList<BlockAssociation>(BlockAssociation.class, this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET, UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK);
		}
		return associationAsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockConnection> getConnectionAsSource() {
		if (connectionAsSource == null) {
			connectionAsSource = new EObjectWithInverseResolvingEList.ManyInverse<BlockConnection>(BlockConnection.class, this, UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE, UnifiedPackage.BLOCK_CONNECTION__FROM_BLOCK);
		}
		return connectionAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockConnection> getConnectionAsTarget() {
		if (connectionAsTarget == null) {
			connectionAsTarget = new EObjectWithInverseResolvingEList.ManyInverse<BlockConnection>(BlockConnection.class, this, UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET, UnifiedPackage.BLOCK_CONNECTION__TO_BLOCK);
		}
		return connectionAsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType getBlockType() {
		return blockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockType(BlockType newBlockType) {
		BlockType oldBlockType = blockType;
		blockType = newBlockType == null ? BLOCK_TYPE_EDEFAULT : newBlockType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.SYSTEM_BLOCK__BLOCK_TYPE, oldBlockType, blockType));
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
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubBlocks()).basicAdd(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentBlock((SystemBlock)otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationAsSource()).basicAdd(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationAsTarget()).basicAdd(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionAsSource()).basicAdd(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionAsTarget()).basicAdd(otherEnd, msgs);
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
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				return ((InternalEList<?>)getSubBlocks()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				return basicSetParentBlock(null, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				return ((InternalEList<?>)getAssociationAsSource()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				return ((InternalEList<?>)getAssociationAsTarget()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				return ((InternalEList<?>)getConnectionAsSource()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				return ((InternalEList<?>)getConnectionAsTarget()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				return eInternalContainer().eInverseRemove(this, UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS, SystemBlock.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				return getSubBlocks();
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				return getParentBlock();
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				return getAssociationAsSource();
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				return getAssociationAsTarget();
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				return getConnectionAsSource();
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				return getConnectionAsTarget();
			case UnifiedPackage.SYSTEM_BLOCK__BLOCK_TYPE:
				return getBlockType();
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
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				getSubBlocks().clear();
				getSubBlocks().addAll((Collection<? extends SystemBlock>)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				setParentBlock((SystemBlock)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				getAssociationAsSource().clear();
				getAssociationAsSource().addAll((Collection<? extends BlockAssociation>)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				getAssociationAsTarget().clear();
				getAssociationAsTarget().addAll((Collection<? extends BlockAssociation>)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				getConnectionAsSource().clear();
				getConnectionAsSource().addAll((Collection<? extends BlockConnection>)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				getConnectionAsTarget().clear();
				getConnectionAsTarget().addAll((Collection<? extends BlockConnection>)newValue);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__BLOCK_TYPE:
				setBlockType((BlockType)newValue);
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
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				getSubBlocks().clear();
				return;
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				setParentBlock((SystemBlock)null);
				return;
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				getAssociationAsSource().clear();
				return;
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				getAssociationAsTarget().clear();
				return;
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				getConnectionAsSource().clear();
				return;
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				getConnectionAsTarget().clear();
				return;
			case UnifiedPackage.SYSTEM_BLOCK__BLOCK_TYPE:
				setBlockType(BLOCK_TYPE_EDEFAULT);
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
			case UnifiedPackage.SYSTEM_BLOCK__SUB_BLOCKS:
				return subBlocks != null && !subBlocks.isEmpty();
			case UnifiedPackage.SYSTEM_BLOCK__PARENT_BLOCK:
				return getParentBlock() != null;
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE:
				return associationAsSource != null && !associationAsSource.isEmpty();
			case UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET:
				return associationAsTarget != null && !associationAsTarget.isEmpty();
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_SOURCE:
				return connectionAsSource != null && !connectionAsSource.isEmpty();
			case UnifiedPackage.SYSTEM_BLOCK__CONNECTION_AS_TARGET:
				return connectionAsTarget != null && !connectionAsTarget.isEmpty();
			case UnifiedPackage.SYSTEM_BLOCK__BLOCK_TYPE:
				return blockType != BLOCK_TYPE_EDEFAULT;
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
		result.append(" (blockType: ");
		result.append(blockType);
		result.append(')');
		return result.toString();
	}

} //SystemBlockImpl
