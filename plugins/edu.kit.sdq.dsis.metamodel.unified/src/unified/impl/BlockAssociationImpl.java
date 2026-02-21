/**
 */
package unified.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import unified.AssociationType;
import unified.BlockAssociation;
import unified.SystemBlock;
import unified.UnifiedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.BlockAssociationImpl#getAssociationType <em>Association Type</em>}</li>
 *   <li>{@link unified.impl.BlockAssociationImpl#getSourceBlock <em>Source Block</em>}</li>
 *   <li>{@link unified.impl.BlockAssociationImpl#getTargetBlock <em>Target Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockAssociationImpl extends UnifiedElementImpl implements BlockAssociation {
	/**
	 * The default value of the '{@link #getAssociationType() <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationType()
	 * @generated
	 * @ordered
	 */
	protected static final AssociationType ASSOCIATION_TYPE_EDEFAULT = AssociationType.DEPENDENCY;

	/**
	 * The cached value of the '{@link #getAssociationType() <em>Association Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationType()
	 * @generated
	 * @ordered
	 */
	protected AssociationType associationType = ASSOCIATION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceBlock() <em>Source Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceBlock()
	 * @generated
	 * @ordered
	 */
	protected SystemBlock sourceBlock;

	/**
	 * The cached value of the '{@link #getTargetBlock() <em>Target Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetBlock()
	 * @generated
	 * @ordered
	 */
	protected SystemBlock targetBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.BLOCK_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationType getAssociationType() {
		return associationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationType(AssociationType newAssociationType) {
		AssociationType oldAssociationType = associationType;
		associationType = newAssociationType == null ? ASSOCIATION_TYPE_EDEFAULT : newAssociationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_ASSOCIATION__ASSOCIATION_TYPE, oldAssociationType, associationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock getSourceBlock() {
		if (sourceBlock != null && sourceBlock.eIsProxy()) {
			InternalEObject oldSourceBlock = (InternalEObject)sourceBlock;
			sourceBlock = (SystemBlock)eResolveProxy(oldSourceBlock);
			if (sourceBlock != oldSourceBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK, oldSourceBlock, sourceBlock));
			}
		}
		return sourceBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock basicGetSourceBlock() {
		return sourceBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceBlock(SystemBlock newSourceBlock, NotificationChain msgs) {
		SystemBlock oldSourceBlock = sourceBlock;
		sourceBlock = newSourceBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK, oldSourceBlock, newSourceBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceBlock(SystemBlock newSourceBlock) {
		if (newSourceBlock != sourceBlock) {
			NotificationChain msgs = null;
			if (sourceBlock != null)
				msgs = ((InternalEObject)sourceBlock).eInverseRemove(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE, SystemBlock.class, msgs);
			if (newSourceBlock != null)
				msgs = ((InternalEObject)newSourceBlock).eInverseAdd(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE, SystemBlock.class, msgs);
			msgs = basicSetSourceBlock(newSourceBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK, newSourceBlock, newSourceBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock getTargetBlock() {
		if (targetBlock != null && targetBlock.eIsProxy()) {
			InternalEObject oldTargetBlock = (InternalEObject)targetBlock;
			targetBlock = (SystemBlock)eResolveProxy(oldTargetBlock);
			if (targetBlock != oldTargetBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK, oldTargetBlock, targetBlock));
			}
		}
		return targetBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock basicGetTargetBlock() {
		return targetBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetBlock(SystemBlock newTargetBlock, NotificationChain msgs) {
		SystemBlock oldTargetBlock = targetBlock;
		targetBlock = newTargetBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK, oldTargetBlock, newTargetBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetBlock(SystemBlock newTargetBlock) {
		if (newTargetBlock != targetBlock) {
			NotificationChain msgs = null;
			if (targetBlock != null)
				msgs = ((InternalEObject)targetBlock).eInverseRemove(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET, SystemBlock.class, msgs);
			if (newTargetBlock != null)
				msgs = ((InternalEObject)newTargetBlock).eInverseAdd(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET, SystemBlock.class, msgs);
			msgs = basicSetTargetBlock(newTargetBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK, newTargetBlock, newTargetBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				if (sourceBlock != null)
					msgs = ((InternalEObject)sourceBlock).eInverseRemove(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE, SystemBlock.class, msgs);
				return basicSetSourceBlock((SystemBlock)otherEnd, msgs);
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				if (targetBlock != null)
					msgs = ((InternalEObject)targetBlock).eInverseRemove(this, UnifiedPackage.SYSTEM_BLOCK__ASSOCIATION_AS_TARGET, SystemBlock.class, msgs);
				return basicSetTargetBlock((SystemBlock)otherEnd, msgs);
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
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				return basicSetSourceBlock(null, msgs);
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				return basicSetTargetBlock(null, msgs);
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
			case UnifiedPackage.BLOCK_ASSOCIATION__ASSOCIATION_TYPE:
				return getAssociationType();
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				if (resolve) return getSourceBlock();
				return basicGetSourceBlock();
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				if (resolve) return getTargetBlock();
				return basicGetTargetBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UnifiedPackage.BLOCK_ASSOCIATION__ASSOCIATION_TYPE:
				setAssociationType((AssociationType)newValue);
				return;
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				setSourceBlock((SystemBlock)newValue);
				return;
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				setTargetBlock((SystemBlock)newValue);
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
			case UnifiedPackage.BLOCK_ASSOCIATION__ASSOCIATION_TYPE:
				setAssociationType(ASSOCIATION_TYPE_EDEFAULT);
				return;
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				setSourceBlock((SystemBlock)null);
				return;
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				setTargetBlock((SystemBlock)null);
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
			case UnifiedPackage.BLOCK_ASSOCIATION__ASSOCIATION_TYPE:
				return associationType != ASSOCIATION_TYPE_EDEFAULT;
			case UnifiedPackage.BLOCK_ASSOCIATION__SOURCE_BLOCK:
				return sourceBlock != null;
			case UnifiedPackage.BLOCK_ASSOCIATION__TARGET_BLOCK:
				return targetBlock != null;
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
		result.append(" (associationType: ");
		result.append(associationType);
		result.append(')');
		return result.toString();
	}

} //BlockAssociationImpl
