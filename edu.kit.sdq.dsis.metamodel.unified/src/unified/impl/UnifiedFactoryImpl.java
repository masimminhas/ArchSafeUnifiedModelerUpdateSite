/**
 */
package unified.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import unified.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnifiedFactoryImpl extends EFactoryImpl implements UnifiedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnifiedFactory init() {
		try {
			UnifiedFactory theUnifiedFactory = (UnifiedFactory)EPackage.Registry.INSTANCE.getEFactory(UnifiedPackage.eNS_URI);
			if (theUnifiedFactory != null) {
				return theUnifiedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UnifiedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL: return createUnifiedSystemModel();
			case UnifiedPackage.FMEA_ANALYSIS: return createFMEAAnalysis();
			case UnifiedPackage.FMEA_ITEM: return createFMEAItem();
			case UnifiedPackage.INTEGRATED_HAZARD: return createIntegratedHazard();
			case UnifiedPackage.SAFETY_CRITICAL_BLOCK: return createSafetyCriticalBlock();
			case UnifiedPackage.SYSTEM_BLOCK: return createSystemBlock();
			case UnifiedPackage.BLOCK_ASSOCIATION: return createBlockAssociation();
			case UnifiedPackage.BLOCK_CONNECTION: return createBlockConnection();
			case UnifiedPackage.BLOCK_FAILURE_MODE: return createBlockFailureMode();
			case UnifiedPackage.ANALYSIS_METADATA: return createAnalysisMetadata();
			case UnifiedPackage.SAFETY_GOAL: return createSafetyGoal();
			case UnifiedPackage.FUNCTIONAL_SAFETY_REQUIREMENT: return createFunctionalSafetyRequirement();
			case UnifiedPackage.TECHNICAL_SAFETY_REQUIREMENT: return createTechnicalSafetyRequirement();
			case UnifiedPackage.SAFETY_MECHANISM: return createSafetyMechanism();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UnifiedPackage.SAFETY_CRITICALITY_LEVEL:
				return createSafetyCriticalityLevelFromString(eDataType, initialValue);
			case UnifiedPackage.ACTION_STATUS:
				return createActionStatusFromString(eDataType, initialValue);
			case UnifiedPackage.RISK_LEVEL:
				return createRiskLevelFromString(eDataType, initialValue);
			case UnifiedPackage.CONNECTION_TYPE:
				return createConnectionTypeFromString(eDataType, initialValue);
			case UnifiedPackage.ASSOCIATION_TYPE:
				return createAssociationTypeFromString(eDataType, initialValue);
			case UnifiedPackage.ANALYSIS_STATUS:
				return createAnalysisStatusFromString(eDataType, initialValue);
			case UnifiedPackage.MITIGATION_STATUS:
				return createMitigationStatusFromString(eDataType, initialValue);
			case UnifiedPackage.HAZARD_CATEGORY:
				return createHazardCategoryFromString(eDataType, initialValue);
			case UnifiedPackage.REDUNDANCY_TYPE:
				return createRedundancyTypeFromString(eDataType, initialValue);
			case UnifiedPackage.ASIL_LEVEL:
				return createASILLevelFromString(eDataType, initialValue);
			case UnifiedPackage.BLOCK_TYPE:
				return createBlockTypeFromString(eDataType, initialValue);
			case UnifiedPackage.REQUIREMENT_STATUS:
				return createRequirementStatusFromString(eDataType, initialValue);
			case UnifiedPackage.VERIFICATION_METHOD:
				return createVerificationMethodFromString(eDataType, initialValue);
			case UnifiedPackage.FUNCTIONAL_REQUIREMENT_TYPE:
				return createFunctionalRequirementTypeFromString(eDataType, initialValue);
			case UnifiedPackage.TECHNICAL_REQUIREMENT_CATEGORY:
				return createTechnicalRequirementCategoryFromString(eDataType, initialValue);
			case UnifiedPackage.SAFETY_MECHANISM_TYPE:
				return createSafetyMechanismTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UnifiedPackage.SAFETY_CRITICALITY_LEVEL:
				return convertSafetyCriticalityLevelToString(eDataType, instanceValue);
			case UnifiedPackage.ACTION_STATUS:
				return convertActionStatusToString(eDataType, instanceValue);
			case UnifiedPackage.RISK_LEVEL:
				return convertRiskLevelToString(eDataType, instanceValue);
			case UnifiedPackage.CONNECTION_TYPE:
				return convertConnectionTypeToString(eDataType, instanceValue);
			case UnifiedPackage.ASSOCIATION_TYPE:
				return convertAssociationTypeToString(eDataType, instanceValue);
			case UnifiedPackage.ANALYSIS_STATUS:
				return convertAnalysisStatusToString(eDataType, instanceValue);
			case UnifiedPackage.MITIGATION_STATUS:
				return convertMitigationStatusToString(eDataType, instanceValue);
			case UnifiedPackage.HAZARD_CATEGORY:
				return convertHazardCategoryToString(eDataType, instanceValue);
			case UnifiedPackage.REDUNDANCY_TYPE:
				return convertRedundancyTypeToString(eDataType, instanceValue);
			case UnifiedPackage.ASIL_LEVEL:
				return convertASILLevelToString(eDataType, instanceValue);
			case UnifiedPackage.BLOCK_TYPE:
				return convertBlockTypeToString(eDataType, instanceValue);
			case UnifiedPackage.REQUIREMENT_STATUS:
				return convertRequirementStatusToString(eDataType, instanceValue);
			case UnifiedPackage.VERIFICATION_METHOD:
				return convertVerificationMethodToString(eDataType, instanceValue);
			case UnifiedPackage.FUNCTIONAL_REQUIREMENT_TYPE:
				return convertFunctionalRequirementTypeToString(eDataType, instanceValue);
			case UnifiedPackage.TECHNICAL_REQUIREMENT_CATEGORY:
				return convertTechnicalRequirementCategoryToString(eDataType, instanceValue);
			case UnifiedPackage.SAFETY_MECHANISM_TYPE:
				return convertSafetyMechanismTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedSystemModel createUnifiedSystemModel() {
		UnifiedSystemModelImpl unifiedSystemModel = new UnifiedSystemModelImpl();
		return unifiedSystemModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMEAAnalysis createFMEAAnalysis() {
		FMEAAnalysisImpl fmeaAnalysis = new FMEAAnalysisImpl();
		return fmeaAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMEAItem createFMEAItem() {
		FMEAItemImpl fmeaItem = new FMEAItemImpl();
		return fmeaItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegratedHazard createIntegratedHazard() {
		IntegratedHazardImpl integratedHazard = new IntegratedHazardImpl();
		return integratedHazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalBlock createSafetyCriticalBlock() {
		SafetyCriticalBlockImpl safetyCriticalBlock = new SafetyCriticalBlockImpl();
		return safetyCriticalBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBlock createSystemBlock() {
		SystemBlockImpl systemBlock = new SystemBlockImpl();
		return systemBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockAssociation createBlockAssociation() {
		BlockAssociationImpl blockAssociation = new BlockAssociationImpl();
		return blockAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockConnection createBlockConnection() {
		BlockConnectionImpl blockConnection = new BlockConnectionImpl();
		return blockConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockFailureMode createBlockFailureMode() {
		BlockFailureModeImpl blockFailureMode = new BlockFailureModeImpl();
		return blockFailureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisMetadata createAnalysisMetadata() {
		AnalysisMetadataImpl analysisMetadata = new AnalysisMetadataImpl();
		return analysisMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyGoal createSafetyGoal() {
		SafetyGoalImpl safetyGoal = new SafetyGoalImpl();
		return safetyGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalSafetyRequirement createFunctionalSafetyRequirement() {
		FunctionalSafetyRequirementImpl functionalSafetyRequirement = new FunctionalSafetyRequirementImpl();
		return functionalSafetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnicalSafetyRequirement createTechnicalSafetyRequirement() {
		TechnicalSafetyRequirementImpl technicalSafetyRequirement = new TechnicalSafetyRequirementImpl();
		return technicalSafetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyMechanism createSafetyMechanism() {
		SafetyMechanismImpl safetyMechanism = new SafetyMechanismImpl();
		return safetyMechanism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCriticalityLevel createSafetyCriticalityLevelFromString(EDataType eDataType, String initialValue) {
		SafetyCriticalityLevel result = SafetyCriticalityLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSafetyCriticalityLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionStatus createActionStatusFromString(EDataType eDataType, String initialValue) {
		ActionStatus result = ActionStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RiskLevel createRiskLevelFromString(EDataType eDataType, String initialValue) {
		RiskLevel result = RiskLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRiskLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType createConnectionTypeFromString(EDataType eDataType, String initialValue) {
		ConnectionType result = ConnectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationType createAssociationTypeFromString(EDataType eDataType, String initialValue) {
		AssociationType result = AssociationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssociationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisStatus createAnalysisStatusFromString(EDataType eDataType, String initialValue) {
		AnalysisStatus result = AnalysisStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnalysisStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MitigationStatus createMitigationStatusFromString(EDataType eDataType, String initialValue) {
		MitigationStatus result = MitigationStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMitigationStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HazardCategory createHazardCategoryFromString(EDataType eDataType, String initialValue) {
		HazardCategory result = HazardCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHazardCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType createRedundancyTypeFromString(EDataType eDataType, String initialValue) {
		RedundancyType result = RedundancyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedundancyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILLevel createASILLevelFromString(EDataType eDataType, String initialValue) {
		ASILLevel result = ASILLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertASILLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType createBlockTypeFromString(EDataType eDataType, String initialValue) {
		BlockType result = BlockType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBlockTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementStatus createRequirementStatusFromString(EDataType eDataType, String initialValue) {
		RequirementStatus result = RequirementStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationMethod createVerificationMethodFromString(EDataType eDataType, String initialValue) {
		VerificationMethod result = VerificationMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVerificationMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirementType createFunctionalRequirementTypeFromString(EDataType eDataType, String initialValue) {
		FunctionalRequirementType result = FunctionalRequirementType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFunctionalRequirementTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnicalRequirementCategory createTechnicalRequirementCategoryFromString(EDataType eDataType, String initialValue) {
		TechnicalRequirementCategory result = TechnicalRequirementCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTechnicalRequirementCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyMechanismType createSafetyMechanismTypeFromString(EDataType eDataType, String initialValue) {
		SafetyMechanismType result = SafetyMechanismType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSafetyMechanismTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnifiedPackage getUnifiedPackage() {
		return (UnifiedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UnifiedPackage getPackage() {
		return UnifiedPackage.eINSTANCE;
	}

} //UnifiedFactoryImpl
