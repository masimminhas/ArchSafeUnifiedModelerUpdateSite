/**
 */
package unified.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import unified.TechnicalSafetyRequirement;
import unified.UnifiedPackage;

/**
 * This is the item provider adapter for a {@link unified.TechnicalSafetyRequirement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TechnicalSafetyRequirementItemProvider extends RequirementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnicalSafetyRequirementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTechnicalCategoryPropertyDescriptor(object);
			addAllocatedASILPropertyDescriptor(object);
			addRefinesFromPropertyDescriptor(object);
			addRealizedByPropertyDescriptor(object);
			addVerifiedByPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Technical Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTechnicalCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TechnicalSafetyRequirement_technicalCategory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TechnicalSafetyRequirement_technicalCategory_feature", "_UI_TechnicalSafetyRequirement_type"),
				 UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Allocated ASIL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllocatedASILPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TechnicalSafetyRequirement_allocatedASIL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TechnicalSafetyRequirement_allocatedASIL_feature", "_UI_TechnicalSafetyRequirement_type"),
				 UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Refines From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinesFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TechnicalSafetyRequirement_refinesFrom_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TechnicalSafetyRequirement_refinesFrom_feature", "_UI_TechnicalSafetyRequirement_type"),
				 UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Realized By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TechnicalSafetyRequirement_realizedBy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TechnicalSafetyRequirement_realizedBy_feature", "_UI_TechnicalSafetyRequirement_type"),
				 UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Verified By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerifiedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TechnicalSafetyRequirement_verifiedBy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TechnicalSafetyRequirement_verifiedBy_feature", "_UI_TechnicalSafetyRequirement_type"),
				 UnifiedPackage.Literals.TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns TechnicalSafetyRequirement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TechnicalSafetyRequirement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TechnicalSafetyRequirement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TechnicalSafetyRequirement_type") :
			getString("_UI_TechnicalSafetyRequirement_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TechnicalSafetyRequirement.class)) {
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY:
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
