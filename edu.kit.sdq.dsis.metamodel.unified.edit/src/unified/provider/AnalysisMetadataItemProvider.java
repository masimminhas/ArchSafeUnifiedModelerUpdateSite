/**
 */
package unified.provider;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import unified.AnalysisMetadata;
import unified.UnifiedPackage;

/**
 * This is the item provider adapter for a {@link unified.AnalysisMetadata} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisMetadataItemProvider 
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
	public AnalysisMetadataItemProvider(AdapterFactory adapterFactory) {
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

			addLastAnalysisDatePropertyDescriptor(object);
			addCompletenessScorePropertyDescriptor(object);
			addConsistencyScorePropertyDescriptor(object);
			addHazardCoveragePropertyDescriptor(object);
			addFmeaCoveragePropertyDescriptor(object);
			addTraceabilityDensityPropertyDescriptor(object);
			addCyclomaticComplexityPropertyDescriptor(object);
			addMcrPropertyDescriptor(object);
			addHtiPropertyDescriptor(object);
			addRarPropertyDescriptor(object);
			addFlcPropertyDescriptor(object);
			addTdsPropertyDescriptor(object);
			addMvrPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Last Analysis Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastAnalysisDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_lastAnalysisDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_lastAnalysisDate_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__LAST_ANALYSIS_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Completeness Score feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompletenessScorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_completenessScore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_completenessScore_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__COMPLETENESS_SCORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Consistency Score feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConsistencyScorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_consistencyScore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_consistencyScore_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__CONSISTENCY_SCORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hazard Coverage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHazardCoveragePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_hazardCoverage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_hazardCoverage_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__HAZARD_COVERAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fmea Coverage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFmeaCoveragePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_fmeaCoverage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_fmeaCoverage_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__FMEA_COVERAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Traceability Density feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceabilityDensityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_traceabilityDensity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_traceabilityDensity_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__TRACEABILITY_DENSITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cyclomatic Complexity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCyclomaticComplexityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_cyclomaticComplexity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_cyclomaticComplexity_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__CYCLOMATIC_COMPLEXITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mcr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMcrPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_mcr_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_mcr_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__MCR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hti feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHtiPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_hti_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_hti_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__HTI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rar feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRarPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_rar_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_rar_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__RAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Flc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFlcPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_flc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_flc_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__FLC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tds feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTdsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_tds_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_tds_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__TDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mvr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMvrPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnalysisMetadata_mvr_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnalysisMetadata_mvr_feature", "_UI_AnalysisMetadata_type"),
				 UnifiedPackage.Literals.ANALYSIS_METADATA__MVR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AnalysisMetadata.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AnalysisMetadata"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Date labelValue = ((AnalysisMetadata)object).getLastAnalysisDate();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AnalysisMetadata_type") :
			getString("_UI_AnalysisMetadata_type") + " " + label;
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

		switch (notification.getFeatureID(AnalysisMetadata.class)) {
			case UnifiedPackage.ANALYSIS_METADATA__LAST_ANALYSIS_DATE:
			case UnifiedPackage.ANALYSIS_METADATA__COMPLETENESS_SCORE:
			case UnifiedPackage.ANALYSIS_METADATA__CONSISTENCY_SCORE:
			case UnifiedPackage.ANALYSIS_METADATA__HAZARD_COVERAGE:
			case UnifiedPackage.ANALYSIS_METADATA__FMEA_COVERAGE:
			case UnifiedPackage.ANALYSIS_METADATA__TRACEABILITY_DENSITY:
			case UnifiedPackage.ANALYSIS_METADATA__CYCLOMATIC_COMPLEXITY:
			case UnifiedPackage.ANALYSIS_METADATA__MCR:
			case UnifiedPackage.ANALYSIS_METADATA__HTI:
			case UnifiedPackage.ANALYSIS_METADATA__RAR:
			case UnifiedPackage.ANALYSIS_METADATA__FLC:
			case UnifiedPackage.ANALYSIS_METADATA__TDS:
			case UnifiedPackage.ANALYSIS_METADATA__MVR:
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
