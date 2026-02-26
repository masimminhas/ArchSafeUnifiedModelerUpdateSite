/**
 */
package unified.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import unified.ASILLevel;
import unified.ActionStatus;
import unified.AnalysisMetadata;
import unified.AnalysisStatus;
import unified.AssociationType;
import unified.BlockAssociation;
import unified.BlockConnection;
import unified.BlockFailureMode;
import unified.BlockType;
import unified.ConnectionType;
import unified.FMEAAnalysis;
import unified.FMEAItem;
import unified.FunctionalRequirementType;
import unified.FunctionalSafetyRequirement;
import unified.HazardCategory;
import unified.IntegratedHazard;
import unified.MitigationStatus;
import unified.RedundancyType;
import unified.Requirement;
import unified.RequirementStatus;
import unified.RiskLevel;
import unified.SafetyCriticalBlock;
import unified.SafetyCriticalityLevel;
import unified.SafetyGoal;
import unified.SafetyMechanism;
import unified.SafetyMechanismType;
import unified.SystemBlock;
import unified.TechnicalRequirementCategory;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedElement;
import unified.UnifiedFactory;
import unified.UnifiedPackage;
import unified.UnifiedSystemModel;
import unified.VerificationMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnifiedPackageImpl extends EPackageImpl implements UnifiedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unifiedSystemModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmeaAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmeaItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integratedHazardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safetyCriticalBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockFailureModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analysisMetadataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safetyGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalSafetyRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass technicalSafetyRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safetyMechanismEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum safetyCriticalityLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum riskLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum associationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum analysisStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mitigationStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum hazardCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redundancyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum asilLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum blockTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requirementStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum verificationMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum functionalRequirementTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum technicalRequirementCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum safetyMechanismTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see unified.UnifiedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UnifiedPackageImpl() {
		super(eNS_URI, UnifiedFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link UnifiedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UnifiedPackage init() {
		if (isInited) return (UnifiedPackage)EPackage.Registry.INSTANCE.getEPackage(UnifiedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUnifiedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UnifiedPackageImpl theUnifiedPackage = registeredUnifiedPackage instanceof UnifiedPackageImpl ? (UnifiedPackageImpl)registeredUnifiedPackage : new UnifiedPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theUnifiedPackage.createPackageContents();

		// Initialize created meta-data
		theUnifiedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUnifiedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UnifiedPackage.eNS_URI, theUnifiedPackage);
		return theUnifiedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnifiedElement() {
		return unifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedElement_Id() {
		return (EAttribute)unifiedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedElement_Name() {
		return (EAttribute)unifiedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedElement_Description() {
		return (EAttribute)unifiedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnifiedSystemModel() {
		return unifiedSystemModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedSystemModel_Name() {
		return (EAttribute)unifiedSystemModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_FmeaAnalysis() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_GlobalHazards() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_RootBlocks() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_SystemBlocks() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_BlockAssociations() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_BlockConnections() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_AnalysisMetadata() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedSystemModel_ModelVersion() {
		return (EAttribute)unifiedSystemModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnifiedSystemModel_LastModified() {
		return (EAttribute)unifiedSystemModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_SafetyGoals() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_FunctionalRequirements() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_TechnicalRequirements() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnifiedSystemModel_SafetyMechanisms() {
		return (EReference)unifiedSystemModelEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMEAAnalysis() {
		return fmeaAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAAnalysis_RpnThreshold() {
		return (EAttribute)fmeaAnalysisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMEAAnalysis_FmeaItems() {
		return (EReference)fmeaAnalysisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAAnalysis_AnalysisDate() {
		return (EAttribute)fmeaAnalysisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAAnalysis_AnalysisStatus() {
		return (EAttribute)fmeaAnalysisEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAAnalysis_Reviewer() {
		return (EAttribute)fmeaAnalysisEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMEAItem() {
		return fmeaItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_Severity() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_Occurrence() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_Detection() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_LocalEffect() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_SystemEffect() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_RecommendedAction() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_ActionStatus() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMEAItem_FailureMode() {
		return (EReference)fmeaItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMEAItem_AnalyzedComponent() {
		return (EReference)fmeaItemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_AutoGenerated() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMEAItem_RelatedHazards() {
		return (EReference)fmeaItemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_ResponsiblePerson() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMEAItem_DueDate() {
		return (EAttribute)fmeaItemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMEAItem_ValidatesMechanisms() {
		return (EReference)fmeaItemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegratedHazard() {
		return integratedHazardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegratedHazard_RiskLevel() {
		return (EAttribute)integratedHazardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegratedHazard_RelatedBlocks() {
		return (EReference)integratedHazardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegratedHazard_MitigationStatus() {
		return (EAttribute)integratedHazardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegratedHazard_HazardCategory() {
		return (EAttribute)integratedHazardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegratedHazard_SeverityJustification() {
		return (EAttribute)integratedHazardEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafetyCriticalBlock() {
		return safetyCriticalBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCriticalBlock_SafetyCriticality() {
		return (EAttribute)safetyCriticalBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCriticalBlock_FailureModes() {
		return (EReference)safetyCriticalBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCriticalBlock_HasRedundancy() {
		return (EAttribute)safetyCriticalBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCriticalBlock_RedundancyType() {
		return (EAttribute)safetyCriticalBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCriticalBlock_AsilLevel() {
		return (EAttribute)safetyCriticalBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemBlock() {
		return systemBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_SubBlocks() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_ParentBlock() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_AssociationAsSource() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_AssociationAsTarget() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_ConnectionAsSource() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBlock_ConnectionAsTarget() {
		return (EReference)systemBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemBlock_BlockType() {
		return (EAttribute)systemBlockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockAssociation() {
		return blockAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockAssociation_AssociationType() {
		return (EAttribute)blockAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockAssociation_SourceBlock() {
		return (EReference)blockAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockAssociation_TargetBlock() {
		return (EReference)blockAssociationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockConnection() {
		return blockConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockConnection_ConnectionType() {
		return (EAttribute)blockConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockConnection_FromBlock() {
		return (EReference)blockConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockConnection_ToBlock() {
		return (EReference)blockConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockFailureMode() {
		return blockFailureModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockFailureMode_AffectedBlock() {
		return (EReference)blockFailureModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockFailureMode_FailureRate() {
		return (EAttribute)blockFailureModeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockFailureMode_FailureEffect() {
		return (EAttribute)blockFailureModeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnalysisMetadata() {
		return analysisMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_LastAnalysisDate() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_CompletenessScore() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_ConsistencyScore() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_HazardCoverage() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_FmeaCoverage() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_TraceabilityDensity() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_CyclomaticComplexity() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Mcr() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Hti() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Rar() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Flc() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Tds() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisMetadata_Mvr() {
		return (EAttribute)analysisMetadataEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_RequirementId() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_RequirementText() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Status() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_VerificationMethod() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Rationale() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_DerivedFrom() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_SatisfiedBy() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafetyGoal() {
		return safetyGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyGoal_AsilLevel() {
		return (EAttribute)safetyGoalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyGoal_RelatedHazard() {
		return (EReference)safetyGoalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyGoal_SafeState() {
		return (EAttribute)safetyGoalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyGoal_AllocatedTo() {
		return (EReference)safetyGoalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionalSafetyRequirement() {
		return functionalSafetyRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionalSafetyRequirement_RequirementType() {
		return (EAttribute)functionalSafetyRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalSafetyRequirement_AllocatedFrom() {
		return (EReference)functionalSafetyRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalSafetyRequirement_RefinedTo() {
		return (EReference)functionalSafetyRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalSafetyRequirement_ImplementedBy() {
		return (EReference)functionalSafetyRequirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTechnicalSafetyRequirement() {
		return technicalSafetyRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTechnicalSafetyRequirement_TechnicalCategory() {
		return (EAttribute)technicalSafetyRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTechnicalSafetyRequirement_AllocatedASIL() {
		return (EAttribute)technicalSafetyRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTechnicalSafetyRequirement_RefinesFrom() {
		return (EReference)technicalSafetyRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTechnicalSafetyRequirement_RealizedBy() {
		return (EReference)technicalSafetyRequirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTechnicalSafetyRequirement_VerifiedBy() {
		return (EReference)technicalSafetyRequirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafetyMechanism() {
		return safetyMechanismEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyMechanism_MechanismType() {
		return (EAttribute)safetyMechanismEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyMechanism_DiagnosticCoverage() {
		return (EAttribute)safetyMechanismEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyMechanism_Implements() {
		return (EReference)safetyMechanismEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyMechanism_ImplementedIn() {
		return (EReference)safetyMechanismEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyMechanism_ValidatedBy() {
		return (EReference)safetyMechanismEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSafetyCriticalityLevel() {
		return safetyCriticalityLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionStatus() {
		return actionStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRiskLevel() {
		return riskLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionType() {
		return connectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssociationType() {
		return associationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnalysisStatus() {
		return analysisStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMitigationStatus() {
		return mitigationStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHazardCategory() {
		return hazardCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedundancyType() {
		return redundancyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getASILLevel() {
		return asilLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBlockType() {
		return blockTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequirementStatus() {
		return requirementStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVerificationMethod() {
		return verificationMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFunctionalRequirementType() {
		return functionalRequirementTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTechnicalRequirementCategory() {
		return technicalRequirementCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSafetyMechanismType() {
		return safetyMechanismTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedFactory getUnifiedFactory() {
		return (UnifiedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		unifiedElementEClass = createEClass(UNIFIED_ELEMENT);
		createEAttribute(unifiedElementEClass, UNIFIED_ELEMENT__ID);
		createEAttribute(unifiedElementEClass, UNIFIED_ELEMENT__NAME);
		createEAttribute(unifiedElementEClass, UNIFIED_ELEMENT__DESCRIPTION);

		unifiedSystemModelEClass = createEClass(UNIFIED_SYSTEM_MODEL);
		createEAttribute(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__NAME);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA);
		createEAttribute(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__MODEL_VERSION);
		createEAttribute(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__LAST_MODIFIED);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__SAFETY_GOALS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS);
		createEReference(unifiedSystemModelEClass, UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS);

		fmeaAnalysisEClass = createEClass(FMEA_ANALYSIS);
		createEAttribute(fmeaAnalysisEClass, FMEA_ANALYSIS__RPN_THRESHOLD);
		createEReference(fmeaAnalysisEClass, FMEA_ANALYSIS__FMEA_ITEMS);
		createEAttribute(fmeaAnalysisEClass, FMEA_ANALYSIS__ANALYSIS_DATE);
		createEAttribute(fmeaAnalysisEClass, FMEA_ANALYSIS__ANALYSIS_STATUS);
		createEAttribute(fmeaAnalysisEClass, FMEA_ANALYSIS__REVIEWER);

		fmeaItemEClass = createEClass(FMEA_ITEM);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__SEVERITY);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__OCCURRENCE);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__DETECTION);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__LOCAL_EFFECT);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__SYSTEM_EFFECT);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__RECOMMENDED_ACTION);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__ACTION_STATUS);
		createEReference(fmeaItemEClass, FMEA_ITEM__FAILURE_MODE);
		createEReference(fmeaItemEClass, FMEA_ITEM__ANALYZED_COMPONENT);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__AUTO_GENERATED);
		createEReference(fmeaItemEClass, FMEA_ITEM__RELATED_HAZARDS);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__RESPONSIBLE_PERSON);
		createEAttribute(fmeaItemEClass, FMEA_ITEM__DUE_DATE);
		createEReference(fmeaItemEClass, FMEA_ITEM__VALIDATES_MECHANISMS);

		integratedHazardEClass = createEClass(INTEGRATED_HAZARD);
		createEAttribute(integratedHazardEClass, INTEGRATED_HAZARD__RISK_LEVEL);
		createEReference(integratedHazardEClass, INTEGRATED_HAZARD__RELATED_BLOCKS);
		createEAttribute(integratedHazardEClass, INTEGRATED_HAZARD__MITIGATION_STATUS);
		createEAttribute(integratedHazardEClass, INTEGRATED_HAZARD__HAZARD_CATEGORY);
		createEAttribute(integratedHazardEClass, INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION);

		safetyCriticalBlockEClass = createEClass(SAFETY_CRITICAL_BLOCK);
		createEAttribute(safetyCriticalBlockEClass, SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY);
		createEReference(safetyCriticalBlockEClass, SAFETY_CRITICAL_BLOCK__FAILURE_MODES);
		createEAttribute(safetyCriticalBlockEClass, SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY);
		createEAttribute(safetyCriticalBlockEClass, SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE);
		createEAttribute(safetyCriticalBlockEClass, SAFETY_CRITICAL_BLOCK__ASIL_LEVEL);

		systemBlockEClass = createEClass(SYSTEM_BLOCK);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__SUB_BLOCKS);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__PARENT_BLOCK);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__ASSOCIATION_AS_TARGET);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__CONNECTION_AS_SOURCE);
		createEReference(systemBlockEClass, SYSTEM_BLOCK__CONNECTION_AS_TARGET);
		createEAttribute(systemBlockEClass, SYSTEM_BLOCK__BLOCK_TYPE);

		blockAssociationEClass = createEClass(BLOCK_ASSOCIATION);
		createEAttribute(blockAssociationEClass, BLOCK_ASSOCIATION__ASSOCIATION_TYPE);
		createEReference(blockAssociationEClass, BLOCK_ASSOCIATION__SOURCE_BLOCK);
		createEReference(blockAssociationEClass, BLOCK_ASSOCIATION__TARGET_BLOCK);

		blockConnectionEClass = createEClass(BLOCK_CONNECTION);
		createEAttribute(blockConnectionEClass, BLOCK_CONNECTION__CONNECTION_TYPE);
		createEReference(blockConnectionEClass, BLOCK_CONNECTION__FROM_BLOCK);
		createEReference(blockConnectionEClass, BLOCK_CONNECTION__TO_BLOCK);

		blockFailureModeEClass = createEClass(BLOCK_FAILURE_MODE);
		createEReference(blockFailureModeEClass, BLOCK_FAILURE_MODE__AFFECTED_BLOCK);
		createEAttribute(blockFailureModeEClass, BLOCK_FAILURE_MODE__FAILURE_RATE);
		createEAttribute(blockFailureModeEClass, BLOCK_FAILURE_MODE__FAILURE_EFFECT);

		analysisMetadataEClass = createEClass(ANALYSIS_METADATA);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__LAST_ANALYSIS_DATE);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__COMPLETENESS_SCORE);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__CONSISTENCY_SCORE);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__HAZARD_COVERAGE);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__FMEA_COVERAGE);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__TRACEABILITY_DENSITY);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__CYCLOMATIC_COMPLEXITY);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__MCR);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__HTI);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__RAR);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__FLC);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__TDS);
		createEAttribute(analysisMetadataEClass, ANALYSIS_METADATA__MVR);

		requirementEClass = createEClass(REQUIREMENT);
		createEAttribute(requirementEClass, REQUIREMENT__REQUIREMENT_ID);
		createEAttribute(requirementEClass, REQUIREMENT__REQUIREMENT_TEXT);
		createEAttribute(requirementEClass, REQUIREMENT__STATUS);
		createEAttribute(requirementEClass, REQUIREMENT__VERIFICATION_METHOD);
		createEAttribute(requirementEClass, REQUIREMENT__RATIONALE);
		createEReference(requirementEClass, REQUIREMENT__DERIVED_FROM);
		createEReference(requirementEClass, REQUIREMENT__SATISFIED_BY);

		safetyGoalEClass = createEClass(SAFETY_GOAL);
		createEAttribute(safetyGoalEClass, SAFETY_GOAL__ASIL_LEVEL);
		createEReference(safetyGoalEClass, SAFETY_GOAL__RELATED_HAZARD);
		createEAttribute(safetyGoalEClass, SAFETY_GOAL__SAFE_STATE);
		createEReference(safetyGoalEClass, SAFETY_GOAL__ALLOCATED_TO);

		functionalSafetyRequirementEClass = createEClass(FUNCTIONAL_SAFETY_REQUIREMENT);
		createEAttribute(functionalSafetyRequirementEClass, FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE);
		createEReference(functionalSafetyRequirementEClass, FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM);
		createEReference(functionalSafetyRequirementEClass, FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO);
		createEReference(functionalSafetyRequirementEClass, FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY);

		technicalSafetyRequirementEClass = createEClass(TECHNICAL_SAFETY_REQUIREMENT);
		createEAttribute(technicalSafetyRequirementEClass, TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY);
		createEAttribute(technicalSafetyRequirementEClass, TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL);
		createEReference(technicalSafetyRequirementEClass, TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM);
		createEReference(technicalSafetyRequirementEClass, TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY);
		createEReference(technicalSafetyRequirementEClass, TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY);

		safetyMechanismEClass = createEClass(SAFETY_MECHANISM);
		createEAttribute(safetyMechanismEClass, SAFETY_MECHANISM__MECHANISM_TYPE);
		createEAttribute(safetyMechanismEClass, SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE);
		createEReference(safetyMechanismEClass, SAFETY_MECHANISM__IMPLEMENTS);
		createEReference(safetyMechanismEClass, SAFETY_MECHANISM__IMPLEMENTED_IN);
		createEReference(safetyMechanismEClass, SAFETY_MECHANISM__VALIDATED_BY);

		// Create enums
		safetyCriticalityLevelEEnum = createEEnum(SAFETY_CRITICALITY_LEVEL);
		actionStatusEEnum = createEEnum(ACTION_STATUS);
		riskLevelEEnum = createEEnum(RISK_LEVEL);
		connectionTypeEEnum = createEEnum(CONNECTION_TYPE);
		associationTypeEEnum = createEEnum(ASSOCIATION_TYPE);
		analysisStatusEEnum = createEEnum(ANALYSIS_STATUS);
		mitigationStatusEEnum = createEEnum(MITIGATION_STATUS);
		hazardCategoryEEnum = createEEnum(HAZARD_CATEGORY);
		redundancyTypeEEnum = createEEnum(REDUNDANCY_TYPE);
		asilLevelEEnum = createEEnum(ASIL_LEVEL);
		blockTypeEEnum = createEEnum(BLOCK_TYPE);
		requirementStatusEEnum = createEEnum(REQUIREMENT_STATUS);
		verificationMethodEEnum = createEEnum(VERIFICATION_METHOD);
		functionalRequirementTypeEEnum = createEEnum(FUNCTIONAL_REQUIREMENT_TYPE);
		technicalRequirementCategoryEEnum = createEEnum(TECHNICAL_REQUIREMENT_CATEGORY);
		safetyMechanismTypeEEnum = createEEnum(SAFETY_MECHANISM_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fmeaAnalysisEClass.getESuperTypes().add(this.getUnifiedElement());
		fmeaItemEClass.getESuperTypes().add(this.getUnifiedElement());
		integratedHazardEClass.getESuperTypes().add(this.getUnifiedElement());
		safetyCriticalBlockEClass.getESuperTypes().add(this.getSystemBlock());
		systemBlockEClass.getESuperTypes().add(this.getUnifiedElement());
		blockAssociationEClass.getESuperTypes().add(this.getUnifiedElement());
		blockConnectionEClass.getESuperTypes().add(this.getUnifiedElement());
		blockFailureModeEClass.getESuperTypes().add(this.getUnifiedElement());
		requirementEClass.getESuperTypes().add(this.getUnifiedElement());
		safetyGoalEClass.getESuperTypes().add(this.getRequirement());
		functionalSafetyRequirementEClass.getESuperTypes().add(this.getRequirement());
		technicalSafetyRequirementEClass.getESuperTypes().add(this.getRequirement());
		safetyMechanismEClass.getESuperTypes().add(this.getUnifiedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(unifiedElementEClass, UnifiedElement.class, "UnifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnifiedElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, UnifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnifiedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnifiedElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, UnifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unifiedSystemModelEClass, UnifiedSystemModel.class, "UnifiedSystemModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnifiedSystemModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_FmeaAnalysis(), this.getFMEAAnalysis(), null, "fmeaAnalysis", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_GlobalHazards(), this.getIntegratedHazard(), null, "globalHazards", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_RootBlocks(), this.getSafetyCriticalBlock(), null, "rootBlocks", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_SystemBlocks(), this.getSystemBlock(), null, "systemBlocks", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_BlockAssociations(), this.getBlockAssociation(), null, "blockAssociations", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_BlockConnections(), this.getBlockConnection(), null, "blockConnections", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_AnalysisMetadata(), this.getAnalysisMetadata(), null, "analysisMetadata", null, 0, 1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnifiedSystemModel_ModelVersion(), ecorePackage.getEString(), "modelVersion", "1.0", 0, 1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnifiedSystemModel_LastModified(), ecorePackage.getEDate(), "lastModified", null, 0, 1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_SafetyGoals(), this.getSafetyGoal(), null, "safetyGoals", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_FunctionalRequirements(), this.getFunctionalSafetyRequirement(), null, "functionalRequirements", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_TechnicalRequirements(), this.getTechnicalSafetyRequirement(), null, "technicalRequirements", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnifiedSystemModel_SafetyMechanisms(), this.getSafetyMechanism(), null, "safetyMechanisms", null, 0, -1, UnifiedSystemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmeaAnalysisEClass, FMEAAnalysis.class, "FMEAAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFMEAAnalysis_RpnThreshold(), ecorePackage.getEInt(), "rpnThreshold", null, 0, 1, FMEAAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMEAAnalysis_FmeaItems(), this.getFMEAItem(), null, "fmeaItems", null, 0, -1, FMEAAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAAnalysis_AnalysisDate(), ecorePackage.getEDate(), "analysisDate", null, 0, 1, FMEAAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAAnalysis_AnalysisStatus(), this.getAnalysisStatus(), "analysisStatus", "DRAFT", 0, 1, FMEAAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAAnalysis_Reviewer(), ecorePackage.getEString(), "reviewer", null, 0, 1, FMEAAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmeaItemEClass, FMEAItem.class, "FMEAItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFMEAItem_Severity(), ecorePackage.getEInt(), "severity", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_Occurrence(), ecorePackage.getEInt(), "occurrence", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_Detection(), ecorePackage.getEInt(), "detection", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_LocalEffect(), ecorePackage.getEString(), "localEffect", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_SystemEffect(), ecorePackage.getEString(), "systemEffect", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_RecommendedAction(), ecorePackage.getEString(), "recommendedAction", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_ActionStatus(), this.getActionStatus(), "actionStatus", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMEAItem_FailureMode(), this.getBlockFailureMode(), null, "failureMode", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMEAItem_AnalyzedComponent(), this.getSafetyCriticalBlock(), null, "analyzedComponent", null, 1, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_AutoGenerated(), ecorePackage.getEBoolean(), "autoGenerated", "false", 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMEAItem_RelatedHazards(), this.getIntegratedHazard(), null, "relatedHazards", null, 0, -1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_ResponsiblePerson(), ecorePackage.getEString(), "responsiblePerson", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMEAItem_DueDate(), ecorePackage.getEDate(), "dueDate", null, 0, 1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMEAItem_ValidatesMechanisms(), this.getSafetyMechanism(), this.getSafetyMechanism_ValidatedBy(), "validatesMechanisms", null, 0, -1, FMEAItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integratedHazardEClass, IntegratedHazard.class, "IntegratedHazard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegratedHazard_RiskLevel(), this.getRiskLevel(), "riskLevel", null, 0, 1, IntegratedHazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntegratedHazard_RelatedBlocks(), this.getSafetyCriticalBlock(), null, "relatedBlocks", null, 0, -1, IntegratedHazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegratedHazard_MitigationStatus(), this.getMitigationStatus(), "mitigationStatus", "NOT_MITIGATED", 0, 1, IntegratedHazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegratedHazard_HazardCategory(), this.getHazardCategory(), "hazardCategory", null, 0, 1, IntegratedHazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegratedHazard_SeverityJustification(), ecorePackage.getEString(), "severityJustification", null, 0, 1, IntegratedHazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safetyCriticalBlockEClass, SafetyCriticalBlock.class, "SafetyCriticalBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafetyCriticalBlock_SafetyCriticality(), this.getSafetyCriticalityLevel(), "safetyCriticality", null, 0, 1, SafetyCriticalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCriticalBlock_FailureModes(), this.getBlockFailureMode(), this.getBlockFailureMode_AffectedBlock(), "failureModes", null, 0, -1, SafetyCriticalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyCriticalBlock_HasRedundancy(), ecorePackage.getEBoolean(), "hasRedundancy", "false", 0, 1, SafetyCriticalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyCriticalBlock_RedundancyType(), this.getRedundancyType(), "redundancyType", null, 0, 1, SafetyCriticalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyCriticalBlock_AsilLevel(), this.getASILLevel(), "asilLevel", null, 0, 1, SafetyCriticalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemBlockEClass, SystemBlock.class, "SystemBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemBlock_SubBlocks(), this.getSystemBlock(), this.getSystemBlock_ParentBlock(), "subBlocks", null, 0, -1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBlock_ParentBlock(), this.getSystemBlock(), this.getSystemBlock_SubBlocks(), "parentBlock", null, 0, 1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBlock_AssociationAsSource(), this.getBlockAssociation(), this.getBlockAssociation_SourceBlock(), "associationAsSource", null, 0, -1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBlock_AssociationAsTarget(), this.getBlockAssociation(), this.getBlockAssociation_TargetBlock(), "associationAsTarget", null, 0, -1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBlock_ConnectionAsSource(), this.getBlockConnection(), this.getBlockConnection_FromBlock(), "connectionAsSource", null, 0, -1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBlock_ConnectionAsTarget(), this.getBlockConnection(), this.getBlockConnection_ToBlock(), "connectionAsTarget", null, 0, -1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemBlock_BlockType(), this.getBlockType(), "blockType", null, 0, 1, SystemBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockAssociationEClass, BlockAssociation.class, "BlockAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlockAssociation_AssociationType(), this.getAssociationType(), "associationType", null, 0, 1, BlockAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockAssociation_SourceBlock(), this.getSystemBlock(), this.getSystemBlock_AssociationAsSource(), "sourceBlock", null, 0, 1, BlockAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockAssociation_TargetBlock(), this.getSystemBlock(), this.getSystemBlock_AssociationAsTarget(), "targetBlock", null, 0, 1, BlockAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockConnectionEClass, BlockConnection.class, "BlockConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlockConnection_ConnectionType(), this.getConnectionType(), "connectionType", null, 0, 1, BlockConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockConnection_FromBlock(), this.getSystemBlock(), this.getSystemBlock_ConnectionAsSource(), "fromBlock", null, 1, -1, BlockConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockConnection_ToBlock(), this.getSystemBlock(), this.getSystemBlock_ConnectionAsTarget(), "toBlock", null, 1, -1, BlockConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockFailureModeEClass, BlockFailureMode.class, "BlockFailureMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockFailureMode_AffectedBlock(), this.getSafetyCriticalBlock(), this.getSafetyCriticalBlock_FailureModes(), "affectedBlock", null, 0, 1, BlockFailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockFailureMode_FailureRate(), ecorePackage.getEDouble(), "failureRate", null, 0, 1, BlockFailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockFailureMode_FailureEffect(), ecorePackage.getEString(), "failureEffect", null, 0, 1, BlockFailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(analysisMetadataEClass, AnalysisMetadata.class, "AnalysisMetadata", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnalysisMetadata_LastAnalysisDate(), ecorePackage.getEDate(), "lastAnalysisDate", null, 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_CompletenessScore(), ecorePackage.getEInt(), "completenessScore", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_ConsistencyScore(), ecorePackage.getEInt(), "consistencyScore", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_HazardCoverage(), ecorePackage.getEDouble(), "hazardCoverage", "0.0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_FmeaCoverage(), ecorePackage.getEDouble(), "fmeaCoverage", "0.0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_TraceabilityDensity(), ecorePackage.getEDouble(), "traceabilityDensity", "0.0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_CyclomaticComplexity(), ecorePackage.getEInt(), "cyclomaticComplexity", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Mcr(), ecorePackage.getEInt(), "mcr", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Hti(), ecorePackage.getEInt(), "hti", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Rar(), ecorePackage.getEInt(), "rar", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Flc(), ecorePackage.getEInt(), "flc", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Tds(), ecorePackage.getEInt(), "tds", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisMetadata_Mvr(), ecorePackage.getEInt(), "mvr", "0", 0, 1, AnalysisMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequirement_RequirementId(), ecorePackage.getEString(), "requirementId", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_RequirementText(), ecorePackage.getEString(), "requirementText", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Status(), this.getRequirementStatus(), "status", "DRAFT", 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_VerificationMethod(), this.getVerificationMethod(), "verificationMethod", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Rationale(), ecorePackage.getEString(), "rationale", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_DerivedFrom(), this.getRequirement(), null, "derivedFrom", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_SatisfiedBy(), this.getSystemBlock(), null, "satisfiedBy", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safetyGoalEClass, SafetyGoal.class, "SafetyGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafetyGoal_AsilLevel(), this.getASILLevel(), "asilLevel", null, 0, 1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyGoal_RelatedHazard(), this.getIntegratedHazard(), null, "relatedHazard", null, 0, 1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyGoal_SafeState(), ecorePackage.getEString(), "safeState", null, 0, 1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyGoal_AllocatedTo(), this.getFunctionalSafetyRequirement(), this.getFunctionalSafetyRequirement_AllocatedFrom(), "allocatedTo", null, 0, -1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionalSafetyRequirementEClass, FunctionalSafetyRequirement.class, "FunctionalSafetyRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionalSafetyRequirement_RequirementType(), this.getFunctionalRequirementType(), "requirementType", null, 0, 1, FunctionalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalSafetyRequirement_AllocatedFrom(), this.getSafetyGoal(), this.getSafetyGoal_AllocatedTo(), "allocatedFrom", null, 0, 1, FunctionalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalSafetyRequirement_RefinedTo(), this.getTechnicalSafetyRequirement(), this.getTechnicalSafetyRequirement_RefinesFrom(), "refinedTo", null, 0, -1, FunctionalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalSafetyRequirement_ImplementedBy(), this.getSafetyCriticalBlock(), null, "implementedBy", null, 0, -1, FunctionalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(technicalSafetyRequirementEClass, TechnicalSafetyRequirement.class, "TechnicalSafetyRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTechnicalSafetyRequirement_TechnicalCategory(), this.getTechnicalRequirementCategory(), "technicalCategory", null, 0, 1, TechnicalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTechnicalSafetyRequirement_AllocatedASIL(), this.getASILLevel(), "allocatedASIL", null, 0, 1, TechnicalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnicalSafetyRequirement_RefinesFrom(), this.getFunctionalSafetyRequirement(), this.getFunctionalSafetyRequirement_RefinedTo(), "refinesFrom", null, 0, 1, TechnicalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnicalSafetyRequirement_RealizedBy(), this.getSafetyCriticalBlock(), null, "realizedBy", null, 0, -1, TechnicalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnicalSafetyRequirement_VerifiedBy(), this.getFMEAItem(), null, "verifiedBy", null, 0, -1, TechnicalSafetyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safetyMechanismEClass, SafetyMechanism.class, "SafetyMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafetyMechanism_MechanismType(), this.getSafetyMechanismType(), "mechanismType", null, 0, 1, SafetyMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyMechanism_DiagnosticCoverage(), ecorePackage.getEInt(), "diagnosticCoverage", null, 0, 1, SafetyMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyMechanism_Implements(), this.getTechnicalSafetyRequirement(), null, "implements", null, 0, -1, SafetyMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyMechanism_ImplementedIn(), this.getSafetyCriticalBlock(), null, "implementedIn", null, 0, 1, SafetyMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyMechanism_ValidatedBy(), this.getFMEAItem(), this.getFMEAItem_ValidatesMechanisms(), "validatedBy", null, 0, -1, SafetyMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(safetyCriticalityLevelEEnum, SafetyCriticalityLevel.class, "SafetyCriticalityLevel");
		addEEnumLiteral(safetyCriticalityLevelEEnum, SafetyCriticalityLevel.LOW);
		addEEnumLiteral(safetyCriticalityLevelEEnum, SafetyCriticalityLevel.MEDIUM);
		addEEnumLiteral(safetyCriticalityLevelEEnum, SafetyCriticalityLevel.HIGH);
		addEEnumLiteral(safetyCriticalityLevelEEnum, SafetyCriticalityLevel.CRITICAL);

		initEEnum(actionStatusEEnum, ActionStatus.class, "ActionStatus");
		addEEnumLiteral(actionStatusEEnum, ActionStatus.OPEN);
		addEEnumLiteral(actionStatusEEnum, ActionStatus.IN_PROGRESS);
		addEEnumLiteral(actionStatusEEnum, ActionStatus.COMPLETED);
		addEEnumLiteral(actionStatusEEnum, ActionStatus.VERIFIED);

		initEEnum(riskLevelEEnum, RiskLevel.class, "RiskLevel");
		addEEnumLiteral(riskLevelEEnum, RiskLevel.NEGLIGIBLE);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.MARGINAL);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.CRITICAL_RISK);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.CATASTROPHIC);

		initEEnum(connectionTypeEEnum, ConnectionType.class, "ConnectionType");
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.DATA_FLOW);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.CONTROL_FLOW);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.POWER_FLOW);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.SIGNAL_FLOW);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.MECHANICAL);

		initEEnum(associationTypeEEnum, AssociationType.class, "AssociationType");
		addEEnumLiteral(associationTypeEEnum, AssociationType.DEPENDENCY);
		addEEnumLiteral(associationTypeEEnum, AssociationType.AGGREGATION);
		addEEnumLiteral(associationTypeEEnum, AssociationType.COMPOSITION);
		addEEnumLiteral(associationTypeEEnum, AssociationType.ASSOCIATION);
		addEEnumLiteral(associationTypeEEnum, AssociationType.REALIZATION);

		initEEnum(analysisStatusEEnum, AnalysisStatus.class, "AnalysisStatus");
		addEEnumLiteral(analysisStatusEEnum, AnalysisStatus.DRAFT);
		addEEnumLiteral(analysisStatusEEnum, AnalysisStatus.IN_REVIEW);
		addEEnumLiteral(analysisStatusEEnum, AnalysisStatus.APPROVED);
		addEEnumLiteral(analysisStatusEEnum, AnalysisStatus.ARCHIVED);

		initEEnum(mitigationStatusEEnum, MitigationStatus.class, "MitigationStatus");
		addEEnumLiteral(mitigationStatusEEnum, MitigationStatus.NOT_MITIGATED);
		addEEnumLiteral(mitigationStatusEEnum, MitigationStatus.PARTIALLY_MITIGATED);
		addEEnumLiteral(mitigationStatusEEnum, MitigationStatus.FULLY_MITIGATED);
		addEEnumLiteral(mitigationStatusEEnum, MitigationStatus.ACCEPTED);

		initEEnum(hazardCategoryEEnum, HazardCategory.class, "HazardCategory");
		addEEnumLiteral(hazardCategoryEEnum, HazardCategory.FUNCTIONAL_FAILURE);
		addEEnumLiteral(hazardCategoryEEnum, HazardCategory.TIMING_FAILURE);
		addEEnumLiteral(hazardCategoryEEnum, HazardCategory.ERRONEOUS_OUTPUT);
		addEEnumLiteral(hazardCategoryEEnum, HazardCategory.LOSS_OF_FUNCTION);
		addEEnumLiteral(hazardCategoryEEnum, HazardCategory.UNINTENDED_FUNCTION);

		initEEnum(redundancyTypeEEnum, RedundancyType.class, "RedundancyType");
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.NONE);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.COLD_REDUNDANCY);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.HOT_REDUNDANCY);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.TMR);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.DIVERSIFIED);

		initEEnum(asilLevelEEnum, ASILLevel.class, "ASILLevel");
		addEEnumLiteral(asilLevelEEnum, ASILLevel.QM);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.ASIL_A);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.ASIL_B);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.ASIL_C);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.ASIL_D);

		initEEnum(blockTypeEEnum, BlockType.class, "BlockType");
		addEEnumLiteral(blockTypeEEnum, BlockType.SENSOR);
		addEEnumLiteral(blockTypeEEnum, BlockType.ACTUATOR);
		addEEnumLiteral(blockTypeEEnum, BlockType.CONTROLLER);
		addEEnumLiteral(blockTypeEEnum, BlockType.COMMUNICATION);
		addEEnumLiteral(blockTypeEEnum, BlockType.POWER_SUPPLY);
		addEEnumLiteral(blockTypeEEnum, BlockType.PROCESSING_UNIT);
		addEEnumLiteral(blockTypeEEnum, BlockType.STORAGE);
		addEEnumLiteral(blockTypeEEnum, BlockType.USER_INTERFACE);

		initEEnum(requirementStatusEEnum, RequirementStatus.class, "RequirementStatus");
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.DRAFT);
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.UNDER_REVIEW);
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.APPROVED);
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.IMPLEMENTED);
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.VERIFIED);
		addEEnumLiteral(requirementStatusEEnum, RequirementStatus.DEPRECATED);

		initEEnum(verificationMethodEEnum, VerificationMethod.class, "VerificationMethod");
		addEEnumLiteral(verificationMethodEEnum, VerificationMethod.INSPECTION);
		addEEnumLiteral(verificationMethodEEnum, VerificationMethod.ANALYSIS);
		addEEnumLiteral(verificationMethodEEnum, VerificationMethod.SIMULATION);
		addEEnumLiteral(verificationMethodEEnum, VerificationMethod.TEST);
		addEEnumLiteral(verificationMethodEEnum, VerificationMethod.FORMAL_PROOF);

		initEEnum(functionalRequirementTypeEEnum, FunctionalRequirementType.class, "FunctionalRequirementType");
		addEEnumLiteral(functionalRequirementTypeEEnum, FunctionalRequirementType.FAULT_DETECTION);
		addEEnumLiteral(functionalRequirementTypeEEnum, FunctionalRequirementType.FAULT_HANDLING);
		addEEnumLiteral(functionalRequirementTypeEEnum, FunctionalRequirementType.ARBITRATION);
		addEEnumLiteral(functionalRequirementTypeEEnum, FunctionalRequirementType.WARNING_INDICATION);
		addEEnumLiteral(functionalRequirementTypeEEnum, FunctionalRequirementType.SAFE_STATE_TRANSITION);

		initEEnum(technicalRequirementCategoryEEnum, TechnicalRequirementCategory.class, "TechnicalRequirementCategory");
		addEEnumLiteral(technicalRequirementCategoryEEnum, TechnicalRequirementCategory.HARDWARE_REQUIREMENT);
		addEEnumLiteral(technicalRequirementCategoryEEnum, TechnicalRequirementCategory.SOFTWARE_REQUIREMENT);
		addEEnumLiteral(technicalRequirementCategoryEEnum, TechnicalRequirementCategory.SYSTEM_REQUIREMENT);
		addEEnumLiteral(technicalRequirementCategoryEEnum, TechnicalRequirementCategory.INTERFACE_REQUIREMENT);

		initEEnum(safetyMechanismTypeEEnum, SafetyMechanismType.class, "SafetyMechanismType");
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.REDUNDANCY);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.PLAUSIBILITY_CHECK);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.WATCHDOG);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.SELF_TEST);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.GRACEFUL_DEGRADATION);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.ERROR_DETECTION_CODE);
		addEEnumLiteral(safetyMechanismTypeEEnum, SafetyMechanismType.LOCKSTEP);

		// Create resource
		createResource(eNS_URI);
	}

} //UnifiedPackageImpl
