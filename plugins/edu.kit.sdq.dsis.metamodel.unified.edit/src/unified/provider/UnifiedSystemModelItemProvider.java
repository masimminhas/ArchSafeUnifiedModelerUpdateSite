/**
 */
package unified.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import unified.UnifiedFactory;
import unified.UnifiedPackage;
import unified.UnifiedSystemModel;

/**
 * This is the item provider adapter for a {@link unified.UnifiedSystemModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UnifiedSystemModelItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedSystemModelItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addModelVersionPropertyDescriptor(object);
			addLastModifiedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UnifiedSystemModel_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UnifiedSystemModel_name_feature", "_UI_UnifiedSystemModel_type"),
				 UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UnifiedSystemModel_modelVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UnifiedSystemModel_modelVersion_feature", "_UI_UnifiedSystemModel_type"),
				 UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__MODEL_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Modified feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastModifiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UnifiedSystemModel_lastModified_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UnifiedSystemModel_lastModified_feature", "_UI_UnifiedSystemModel_type"),
				 UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS);
			childrenFeatures.add(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns UnifiedSystemModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UnifiedSystemModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UnifiedSystemModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_UnifiedSystemModel_type") :
			getString("_UI_UnifiedSystemModel_type") + " " + label;
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

		switch (notification.getFeatureID(UnifiedSystemModel.class)) {
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS,
				 UnifiedFactory.eINSTANCE.createFMEAAnalysis()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS,
				 UnifiedFactory.eINSTANCE.createIntegratedHazard()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS,
				 UnifiedFactory.eINSTANCE.createSafetyCriticalBlock()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS,
				 UnifiedFactory.eINSTANCE.createSystemBlock()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS,
				 UnifiedFactory.eINSTANCE.createSafetyCriticalBlock()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS,
				 UnifiedFactory.eINSTANCE.createBlockAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS,
				 UnifiedFactory.eINSTANCE.createBlockConnection()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA,
				 UnifiedFactory.eINSTANCE.createAnalysisMetadata()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS,
				 UnifiedFactory.eINSTANCE.createSafetyGoal()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS,
				 UnifiedFactory.eINSTANCE.createFunctionalSafetyRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS,
				 UnifiedFactory.eINSTANCE.createTechnicalSafetyRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS,
				 UnifiedFactory.eINSTANCE.createSafetyMechanism()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS ||
			childFeature == UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UnifiedEditPlugin.INSTANCE;
	}

}
