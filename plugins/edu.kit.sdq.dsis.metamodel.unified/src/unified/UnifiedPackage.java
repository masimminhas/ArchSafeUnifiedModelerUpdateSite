/**
 */
package unified;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see unified.UnifiedFactory
 * @model kind="package"
 * @generated
 */
public interface UnifiedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "unified";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edu.kit.sdq.dsis.metamodel/unified";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "unified";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UnifiedPackage eINSTANCE = unified.impl.UnifiedPackageImpl.init();

	/**
	 * The meta object id for the '{@link unified.impl.UnifiedElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.UnifiedElementImpl
	 * @see unified.impl.UnifiedPackageImpl#getUnifiedElement()
	 * @generated
	 */
	int UNIFIED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_ELEMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link unified.impl.UnifiedSystemModelImpl <em>System Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.UnifiedSystemModelImpl
	 * @see unified.impl.UnifiedPackageImpl#getUnifiedSystemModel()
	 * @generated
	 */
	int UNIFIED_SYSTEM_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Fmea Analysis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS = 1;

	/**
	 * The feature id for the '<em><b>Global Hazards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS = 2;

	/**
	 * The feature id for the '<em><b>Root Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS = 3;

	/**
	 * The feature id for the '<em><b>System Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS = 4;

	/**
	 * The feature id for the '<em><b>Block Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS = 5;

	/**
	 * The feature id for the '<em><b>Block Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS = 6;

	/**
	 * The feature id for the '<em><b>Analysis Metadata</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA = 7;

	/**
	 * The feature id for the '<em><b>Model Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__MODEL_VERSION = 8;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__LAST_MODIFIED = 9;

	/**
	 * The feature id for the '<em><b>Safety Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__SAFETY_GOALS = 10;

	/**
	 * The feature id for the '<em><b>Functional Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS = 11;

	/**
	 * The feature id for the '<em><b>Technical Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS = 12;

	/**
	 * The feature id for the '<em><b>Safety Mechanisms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS = 13;

	/**
	 * The number of structural features of the '<em>System Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>System Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFIED_SYSTEM_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link unified.impl.FMEAAnalysisImpl <em>FMEA Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.FMEAAnalysisImpl
	 * @see unified.impl.UnifiedPackageImpl#getFMEAAnalysis()
	 * @generated
	 */
	int FMEA_ANALYSIS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Rpn Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__RPN_THRESHOLD = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fmea Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__FMEA_ITEMS = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Analysis Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__ANALYSIS_DATE = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Analysis Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__ANALYSIS_STATUS = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reviewer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS__REVIEWER = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>FMEA Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>FMEA Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ANALYSIS_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.FMEAItemImpl <em>FMEA Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.FMEAItemImpl
	 * @see unified.impl.UnifiedPackageImpl#getFMEAItem()
	 * @generated
	 */
	int FMEA_ITEM = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__SEVERITY = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__OCCURRENCE = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Detection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__DETECTION = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__LOCAL_EFFECT = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>System Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__SYSTEM_EFFECT = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Recommended Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__RECOMMENDED_ACTION = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Action Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__ACTION_STATUS = UNIFIED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Failure Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__FAILURE_MODE = UNIFIED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Analyzed Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__ANALYZED_COMPONENT = UNIFIED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Auto Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__AUTO_GENERATED = UNIFIED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Related Hazards</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__RELATED_HAZARDS = UNIFIED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Responsible Person</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__RESPONSIBLE_PERSON = UNIFIED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Due Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__DUE_DATE = UNIFIED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Validates Mechanisms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM__VALIDATES_MECHANISMS = UNIFIED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>FMEA Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The number of operations of the '<em>FMEA Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMEA_ITEM_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.IntegratedHazardImpl <em>Integrated Hazard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.IntegratedHazardImpl
	 * @see unified.impl.UnifiedPackageImpl#getIntegratedHazard()
	 * @generated
	 */
	int INTEGRATED_HAZARD = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Risk Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__RISK_LEVEL = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Related Blocks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__RELATED_BLOCKS = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mitigation Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__MITIGATION_STATUS = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hazard Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__HAZARD_CATEGORY = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Severity Justification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Integrated Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Integrated Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATED_HAZARD_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.SystemBlockImpl <em>System Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.SystemBlockImpl
	 * @see unified.impl.UnifiedPackageImpl#getSystemBlock()
	 * @generated
	 */
	int SYSTEM_BLOCK = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sub Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__SUB_BLOCKS = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__PARENT_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Association As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Association As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__ASSOCIATION_AS_TARGET = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Connection As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__CONNECTION_AS_SOURCE = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connection As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__CONNECTION_AS_TARGET = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Block Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK__BLOCK_TYPE = UNIFIED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>System Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>System Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BLOCK_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.SafetyCriticalBlockImpl <em>Safety Critical Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.SafetyCriticalBlockImpl
	 * @see unified.impl.UnifiedPackageImpl#getSafetyCriticalBlock()
	 * @generated
	 */
	int SAFETY_CRITICAL_BLOCK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__ID = SYSTEM_BLOCK__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__NAME = SYSTEM_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__DESCRIPTION = SYSTEM_BLOCK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sub Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__SUB_BLOCKS = SYSTEM_BLOCK__SUB_BLOCKS;

	/**
	 * The feature id for the '<em><b>Parent Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__PARENT_BLOCK = SYSTEM_BLOCK__PARENT_BLOCK;

	/**
	 * The feature id for the '<em><b>Association As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__ASSOCIATION_AS_SOURCE = SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE;

	/**
	 * The feature id for the '<em><b>Association As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__ASSOCIATION_AS_TARGET = SYSTEM_BLOCK__ASSOCIATION_AS_TARGET;

	/**
	 * The feature id for the '<em><b>Connection As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__CONNECTION_AS_SOURCE = SYSTEM_BLOCK__CONNECTION_AS_SOURCE;

	/**
	 * The feature id for the '<em><b>Connection As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__CONNECTION_AS_TARGET = SYSTEM_BLOCK__CONNECTION_AS_TARGET;

	/**
	 * The feature id for the '<em><b>Block Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__BLOCK_TYPE = SYSTEM_BLOCK__BLOCK_TYPE;

	/**
	 * The feature id for the '<em><b>Safety Criticality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY = SYSTEM_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failure Modes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__FAILURE_MODES = SYSTEM_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Redundancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY = SYSTEM_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Redundancy Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE = SYSTEM_BLOCK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Asil Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK__ASIL_LEVEL = SYSTEM_BLOCK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Safety Critical Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK_FEATURE_COUNT = SYSTEM_BLOCK_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Safety Critical Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CRITICAL_BLOCK_OPERATION_COUNT = SYSTEM_BLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.BlockAssociationImpl <em>Block Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.BlockAssociationImpl
	 * @see unified.impl.UnifiedPackageImpl#getBlockAssociation()
	 * @generated
	 */
	int BLOCK_ASSOCIATION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Association Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__ASSOCIATION_TYPE = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__SOURCE_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION__TARGET_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Block Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Block Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ASSOCIATION_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.BlockConnectionImpl <em>Block Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.BlockConnectionImpl
	 * @see unified.impl.UnifiedPackageImpl#getBlockConnection()
	 * @generated
	 */
	int BLOCK_CONNECTION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__CONNECTION_TYPE = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Block</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__FROM_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To Block</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION__TO_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Block Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Block Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CONNECTION_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.BlockFailureModeImpl <em>Block Failure Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.BlockFailureModeImpl
	 * @see unified.impl.UnifiedPackageImpl#getBlockFailureMode()
	 * @generated
	 */
	int BLOCK_FAILURE_MODE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Affected Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__AFFECTED_BLOCK = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failure Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__FAILURE_RATE = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Failure Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE__FAILURE_EFFECT = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Block Failure Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Block Failure Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FAILURE_MODE_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.AnalysisMetadataImpl <em>Analysis Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.AnalysisMetadataImpl
	 * @see unified.impl.UnifiedPackageImpl#getAnalysisMetadata()
	 * @generated
	 */
	int ANALYSIS_METADATA = 10;

	/**
	 * The feature id for the '<em><b>Last Analysis Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__LAST_ANALYSIS_DATE = 0;

	/**
	 * The feature id for the '<em><b>Completeness Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__COMPLETENESS_SCORE = 1;

	/**
	 * The feature id for the '<em><b>Consistency Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__CONSISTENCY_SCORE = 2;

	/**
	 * The feature id for the '<em><b>Hazard Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__HAZARD_COVERAGE = 3;

	/**
	 * The feature id for the '<em><b>Fmea Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__FMEA_COVERAGE = 4;

	/**
	 * The feature id for the '<em><b>Traceability Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__TRACEABILITY_DENSITY = 5;

	/**
	 * The feature id for the '<em><b>Cyclomatic Complexity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__CYCLOMATIC_COMPLEXITY = 6;

	/**
	 * The feature id for the '<em><b>Mcr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__MCR = 7;

	/**
	 * The feature id for the '<em><b>Hti</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__HTI = 8;

	/**
	 * The feature id for the '<em><b>Rar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__RAR = 9;

	/**
	 * The feature id for the '<em><b>Flc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__FLC = 10;

	/**
	 * The feature id for the '<em><b>Tds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__TDS = 11;

	/**
	 * The feature id for the '<em><b>Mvr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA__MVR = 12;

	/**
	 * The number of structural features of the '<em>Analysis Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Analysis Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_METADATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link unified.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.RequirementImpl
	 * @see unified.impl.UnifiedPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Requirement Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT_ID = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requirement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT_TEXT = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__STATUS = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Verification Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VERIFICATION_METHOD = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RATIONALE = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DERIVED_FROM = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__SATISFIED_BY = UNIFIED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.SafetyGoalImpl <em>Safety Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.SafetyGoalImpl
	 * @see unified.impl.UnifiedPackageImpl#getSafetyGoal()
	 * @generated
	 */
	int SAFETY_GOAL = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Requirement Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__REQUIREMENT_ID = REQUIREMENT__REQUIREMENT_ID;

	/**
	 * The feature id for the '<em><b>Requirement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__REQUIREMENT_TEXT = REQUIREMENT__REQUIREMENT_TEXT;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__STATUS = REQUIREMENT__STATUS;

	/**
	 * The feature id for the '<em><b>Verification Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__VERIFICATION_METHOD = REQUIREMENT__VERIFICATION_METHOD;

	/**
	 * The feature id for the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__RATIONALE = REQUIREMENT__RATIONALE;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__DERIVED_FROM = REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__SATISFIED_BY = REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Asil Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__ASIL_LEVEL = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Related Hazard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__RELATED_HAZARD = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Safe State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__SAFE_STATE = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__ALLOCATED_TO = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Safety Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Safety Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.FunctionalSafetyRequirementImpl <em>Functional Safety Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.FunctionalSafetyRequirementImpl
	 * @see unified.impl.UnifiedPackageImpl#getFunctionalSafetyRequirement()
	 * @generated
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Requirement Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_ID = REQUIREMENT__REQUIREMENT_ID;

	/**
	 * The feature id for the '<em><b>Requirement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TEXT = REQUIREMENT__REQUIREMENT_TEXT;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__STATUS = REQUIREMENT__STATUS;

	/**
	 * The feature id for the '<em><b>Verification Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__VERIFICATION_METHOD = REQUIREMENT__VERIFICATION_METHOD;

	/**
	 * The feature id for the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__RATIONALE = REQUIREMENT__RATIONALE;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__DERIVED_FROM = REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__SATISFIED_BY = REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocated From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implemented By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Functional Safety Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Functional Safety Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_REQUIREMENT_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.TechnicalSafetyRequirementImpl <em>Technical Safety Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.TechnicalSafetyRequirementImpl
	 * @see unified.impl.UnifiedPackageImpl#getTechnicalSafetyRequirement()
	 * @generated
	 */
	int TECHNICAL_SAFETY_REQUIREMENT = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Requirement Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__REQUIREMENT_ID = REQUIREMENT__REQUIREMENT_ID;

	/**
	 * The feature id for the '<em><b>Requirement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__REQUIREMENT_TEXT = REQUIREMENT__REQUIREMENT_TEXT;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__STATUS = REQUIREMENT__STATUS;

	/**
	 * The feature id for the '<em><b>Verification Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__VERIFICATION_METHOD = REQUIREMENT__VERIFICATION_METHOD;

	/**
	 * The feature id for the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__RATIONALE = REQUIREMENT__RATIONALE;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__DERIVED_FROM = REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__SATISFIED_BY = REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Technical Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocated ASIL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refines From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Verified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY = REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Technical Safety Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Technical Safety Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_REQUIREMENT_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.impl.SafetyMechanismImpl <em>Safety Mechanism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.impl.SafetyMechanismImpl
	 * @see unified.impl.UnifiedPackageImpl#getSafetyMechanism()
	 * @generated
	 */
	int SAFETY_MECHANISM = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__ID = UNIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__NAME = UNIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__DESCRIPTION = UNIFIED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Mechanism Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__MECHANISM_TYPE = UNIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagnostic Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE = UNIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__IMPLEMENTS = UNIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implemented In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__IMPLEMENTED_IN = UNIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Validated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM__VALIDATED_BY = UNIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Safety Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM_FEATURE_COUNT = UNIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Safety Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_MECHANISM_OPERATION_COUNT = UNIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unified.SafetyCriticalityLevel <em>Safety Criticality Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.SafetyCriticalityLevel
	 * @see unified.impl.UnifiedPackageImpl#getSafetyCriticalityLevel()
	 * @generated
	 */
	int SAFETY_CRITICALITY_LEVEL = 16;

	/**
	 * The meta object id for the '{@link unified.ActionStatus <em>Action Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.ActionStatus
	 * @see unified.impl.UnifiedPackageImpl#getActionStatus()
	 * @generated
	 */
	int ACTION_STATUS = 17;

	/**
	 * The meta object id for the '{@link unified.RiskLevel <em>Risk Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.RiskLevel
	 * @see unified.impl.UnifiedPackageImpl#getRiskLevel()
	 * @generated
	 */
	int RISK_LEVEL = 18;

	/**
	 * The meta object id for the '{@link unified.ConnectionType <em>Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.ConnectionType
	 * @see unified.impl.UnifiedPackageImpl#getConnectionType()
	 * @generated
	 */
	int CONNECTION_TYPE = 19;

	/**
	 * The meta object id for the '{@link unified.AssociationType <em>Association Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.AssociationType
	 * @see unified.impl.UnifiedPackageImpl#getAssociationType()
	 * @generated
	 */
	int ASSOCIATION_TYPE = 20;

	/**
	 * The meta object id for the '{@link unified.AnalysisStatus <em>Analysis Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.AnalysisStatus
	 * @see unified.impl.UnifiedPackageImpl#getAnalysisStatus()
	 * @generated
	 */
	int ANALYSIS_STATUS = 21;

	/**
	 * The meta object id for the '{@link unified.MitigationStatus <em>Mitigation Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.MitigationStatus
	 * @see unified.impl.UnifiedPackageImpl#getMitigationStatus()
	 * @generated
	 */
	int MITIGATION_STATUS = 22;

	/**
	 * The meta object id for the '{@link unified.HazardCategory <em>Hazard Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.HazardCategory
	 * @see unified.impl.UnifiedPackageImpl#getHazardCategory()
	 * @generated
	 */
	int HAZARD_CATEGORY = 23;

	/**
	 * The meta object id for the '{@link unified.RedundancyType <em>Redundancy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.RedundancyType
	 * @see unified.impl.UnifiedPackageImpl#getRedundancyType()
	 * @generated
	 */
	int REDUNDANCY_TYPE = 24;

	/**
	 * The meta object id for the '{@link unified.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.ASILLevel
	 * @see unified.impl.UnifiedPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 25;

	/**
	 * The meta object id for the '{@link unified.BlockType <em>Block Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.BlockType
	 * @see unified.impl.UnifiedPackageImpl#getBlockType()
	 * @generated
	 */
	int BLOCK_TYPE = 26;

	/**
	 * The meta object id for the '{@link unified.RequirementStatus <em>Requirement Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.RequirementStatus
	 * @see unified.impl.UnifiedPackageImpl#getRequirementStatus()
	 * @generated
	 */
	int REQUIREMENT_STATUS = 27;

	/**
	 * The meta object id for the '{@link unified.VerificationMethod <em>Verification Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.VerificationMethod
	 * @see unified.impl.UnifiedPackageImpl#getVerificationMethod()
	 * @generated
	 */
	int VERIFICATION_METHOD = 28;

	/**
	 * The meta object id for the '{@link unified.FunctionalRequirementType <em>Functional Requirement Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.FunctionalRequirementType
	 * @see unified.impl.UnifiedPackageImpl#getFunctionalRequirementType()
	 * @generated
	 */
	int FUNCTIONAL_REQUIREMENT_TYPE = 29;

	/**
	 * The meta object id for the '{@link unified.TechnicalRequirementCategory <em>Technical Requirement Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.TechnicalRequirementCategory
	 * @see unified.impl.UnifiedPackageImpl#getTechnicalRequirementCategory()
	 * @generated
	 */
	int TECHNICAL_REQUIREMENT_CATEGORY = 30;

	/**
	 * The meta object id for the '{@link unified.SafetyMechanismType <em>Safety Mechanism Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unified.SafetyMechanismType
	 * @see unified.impl.UnifiedPackageImpl#getSafetyMechanismType()
	 * @generated
	 */
	int SAFETY_MECHANISM_TYPE = 31;


	/**
	 * Returns the meta object for class '{@link unified.UnifiedElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see unified.UnifiedElement
	 * @generated
	 */
	EClass getUnifiedElement();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see unified.UnifiedElement#getId()
	 * @see #getUnifiedElement()
	 * @generated
	 */
	EAttribute getUnifiedElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see unified.UnifiedElement#getName()
	 * @see #getUnifiedElement()
	 * @generated
	 */
	EAttribute getUnifiedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see unified.UnifiedElement#getDescription()
	 * @see #getUnifiedElement()
	 * @generated
	 */
	EAttribute getUnifiedElement_Description();

	/**
	 * Returns the meta object for class '{@link unified.UnifiedSystemModel <em>System Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Model</em>'.
	 * @see unified.UnifiedSystemModel
	 * @generated
	 */
	EClass getUnifiedSystemModel();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedSystemModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see unified.UnifiedSystemModel#getName()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EAttribute getUnifiedSystemModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getFmeaAnalysis <em>Fmea Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fmea Analysis</em>'.
	 * @see unified.UnifiedSystemModel#getFmeaAnalysis()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_FmeaAnalysis();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getGlobalHazards <em>Global Hazards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Hazards</em>'.
	 * @see unified.UnifiedSystemModel#getGlobalHazards()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_GlobalHazards();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getRootBlocks <em>Root Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Blocks</em>'.
	 * @see unified.UnifiedSystemModel#getRootBlocks()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_RootBlocks();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getSystemBlocks <em>System Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Blocks</em>'.
	 * @see unified.UnifiedSystemModel#getSystemBlocks()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_SystemBlocks();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getBlockAssociations <em>Block Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Block Associations</em>'.
	 * @see unified.UnifiedSystemModel#getBlockAssociations()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_BlockAssociations();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getBlockConnections <em>Block Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Block Connections</em>'.
	 * @see unified.UnifiedSystemModel#getBlockConnections()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_BlockConnections();

	/**
	 * Returns the meta object for the containment reference '{@link unified.UnifiedSystemModel#getAnalysisMetadata <em>Analysis Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Metadata</em>'.
	 * @see unified.UnifiedSystemModel#getAnalysisMetadata()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_AnalysisMetadata();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedSystemModel#getModelVersion <em>Model Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Version</em>'.
	 * @see unified.UnifiedSystemModel#getModelVersion()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EAttribute getUnifiedSystemModel_ModelVersion();

	/**
	 * Returns the meta object for the attribute '{@link unified.UnifiedSystemModel#getLastModified <em>Last Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modified</em>'.
	 * @see unified.UnifiedSystemModel#getLastModified()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EAttribute getUnifiedSystemModel_LastModified();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getSafetyGoals <em>Safety Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Safety Goals</em>'.
	 * @see unified.UnifiedSystemModel#getSafetyGoals()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_SafetyGoals();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getFunctionalRequirements <em>Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functional Requirements</em>'.
	 * @see unified.UnifiedSystemModel#getFunctionalRequirements()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_FunctionalRequirements();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getTechnicalRequirements <em>Technical Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Technical Requirements</em>'.
	 * @see unified.UnifiedSystemModel#getTechnicalRequirements()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_TechnicalRequirements();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.UnifiedSystemModel#getSafetyMechanisms <em>Safety Mechanisms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Safety Mechanisms</em>'.
	 * @see unified.UnifiedSystemModel#getSafetyMechanisms()
	 * @see #getUnifiedSystemModel()
	 * @generated
	 */
	EReference getUnifiedSystemModel_SafetyMechanisms();

	/**
	 * Returns the meta object for class '{@link unified.FMEAAnalysis <em>FMEA Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMEA Analysis</em>'.
	 * @see unified.FMEAAnalysis
	 * @generated
	 */
	EClass getFMEAAnalysis();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAAnalysis#getRpnThreshold <em>Rpn Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rpn Threshold</em>'.
	 * @see unified.FMEAAnalysis#getRpnThreshold()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_RpnThreshold();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.FMEAAnalysis#getFmeaItems <em>Fmea Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fmea Items</em>'.
	 * @see unified.FMEAAnalysis#getFmeaItems()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EReference getFMEAAnalysis_FmeaItems();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAAnalysis#getAnalysisDate <em>Analysis Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis Date</em>'.
	 * @see unified.FMEAAnalysis#getAnalysisDate()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_AnalysisDate();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAAnalysis#getAnalysisStatus <em>Analysis Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis Status</em>'.
	 * @see unified.FMEAAnalysis#getAnalysisStatus()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_AnalysisStatus();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAAnalysis#getReviewer <em>Reviewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reviewer</em>'.
	 * @see unified.FMEAAnalysis#getReviewer()
	 * @see #getFMEAAnalysis()
	 * @generated
	 */
	EAttribute getFMEAAnalysis_Reviewer();

	/**
	 * Returns the meta object for class '{@link unified.FMEAItem <em>FMEA Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMEA Item</em>'.
	 * @see unified.FMEAItem
	 * @generated
	 */
	EClass getFMEAItem();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see unified.FMEAItem#getSeverity()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_Severity();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence</em>'.
	 * @see unified.FMEAItem#getOccurrence()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getDetection <em>Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detection</em>'.
	 * @see unified.FMEAItem#getDetection()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_Detection();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getLocalEffect <em>Local Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Effect</em>'.
	 * @see unified.FMEAItem#getLocalEffect()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_LocalEffect();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getSystemEffect <em>System Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Effect</em>'.
	 * @see unified.FMEAItem#getSystemEffect()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_SystemEffect();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getRecommendedAction <em>Recommended Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recommended Action</em>'.
	 * @see unified.FMEAItem#getRecommendedAction()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_RecommendedAction();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getActionStatus <em>Action Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Status</em>'.
	 * @see unified.FMEAItem#getActionStatus()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_ActionStatus();

	/**
	 * Returns the meta object for the reference '{@link unified.FMEAItem#getFailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Failure Mode</em>'.
	 * @see unified.FMEAItem#getFailureMode()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EReference getFMEAItem_FailureMode();

	/**
	 * Returns the meta object for the reference '{@link unified.FMEAItem#getAnalyzedComponent <em>Analyzed Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Analyzed Component</em>'.
	 * @see unified.FMEAItem#getAnalyzedComponent()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EReference getFMEAItem_AnalyzedComponent();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#isAutoGenerated <em>Auto Generated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Generated</em>'.
	 * @see unified.FMEAItem#isAutoGenerated()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_AutoGenerated();

	/**
	 * Returns the meta object for the reference list '{@link unified.FMEAItem#getRelatedHazards <em>Related Hazards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related Hazards</em>'.
	 * @see unified.FMEAItem#getRelatedHazards()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EReference getFMEAItem_RelatedHazards();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getResponsiblePerson <em>Responsible Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Responsible Person</em>'.
	 * @see unified.FMEAItem#getResponsiblePerson()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_ResponsiblePerson();

	/**
	 * Returns the meta object for the attribute '{@link unified.FMEAItem#getDueDate <em>Due Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Due Date</em>'.
	 * @see unified.FMEAItem#getDueDate()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EAttribute getFMEAItem_DueDate();

	/**
	 * Returns the meta object for the reference list '{@link unified.FMEAItem#getValidatesMechanisms <em>Validates Mechanisms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Validates Mechanisms</em>'.
	 * @see unified.FMEAItem#getValidatesMechanisms()
	 * @see #getFMEAItem()
	 * @generated
	 */
	EReference getFMEAItem_ValidatesMechanisms();

	/**
	 * Returns the meta object for class '{@link unified.IntegratedHazard <em>Integrated Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integrated Hazard</em>'.
	 * @see unified.IntegratedHazard
	 * @generated
	 */
	EClass getIntegratedHazard();

	/**
	 * Returns the meta object for the attribute '{@link unified.IntegratedHazard#getRiskLevel <em>Risk Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risk Level</em>'.
	 * @see unified.IntegratedHazard#getRiskLevel()
	 * @see #getIntegratedHazard()
	 * @generated
	 */
	EAttribute getIntegratedHazard_RiskLevel();

	/**
	 * Returns the meta object for the reference list '{@link unified.IntegratedHazard#getRelatedBlocks <em>Related Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related Blocks</em>'.
	 * @see unified.IntegratedHazard#getRelatedBlocks()
	 * @see #getIntegratedHazard()
	 * @generated
	 */
	EReference getIntegratedHazard_RelatedBlocks();

	/**
	 * Returns the meta object for the attribute '{@link unified.IntegratedHazard#getMitigationStatus <em>Mitigation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mitigation Status</em>'.
	 * @see unified.IntegratedHazard#getMitigationStatus()
	 * @see #getIntegratedHazard()
	 * @generated
	 */
	EAttribute getIntegratedHazard_MitigationStatus();

	/**
	 * Returns the meta object for the attribute '{@link unified.IntegratedHazard#getHazardCategory <em>Hazard Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hazard Category</em>'.
	 * @see unified.IntegratedHazard#getHazardCategory()
	 * @see #getIntegratedHazard()
	 * @generated
	 */
	EAttribute getIntegratedHazard_HazardCategory();

	/**
	 * Returns the meta object for the attribute '{@link unified.IntegratedHazard#getSeverityJustification <em>Severity Justification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity Justification</em>'.
	 * @see unified.IntegratedHazard#getSeverityJustification()
	 * @see #getIntegratedHazard()
	 * @generated
	 */
	EAttribute getIntegratedHazard_SeverityJustification();

	/**
	 * Returns the meta object for class '{@link unified.SafetyCriticalBlock <em>Safety Critical Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Critical Block</em>'.
	 * @see unified.SafetyCriticalBlock
	 * @generated
	 */
	EClass getSafetyCriticalBlock();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyCriticalBlock#getSafetyCriticality <em>Safety Criticality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Safety Criticality</em>'.
	 * @see unified.SafetyCriticalBlock#getSafetyCriticality()
	 * @see #getSafetyCriticalBlock()
	 * @generated
	 */
	EAttribute getSafetyCriticalBlock_SafetyCriticality();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.SafetyCriticalBlock#getFailureModes <em>Failure Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failure Modes</em>'.
	 * @see unified.SafetyCriticalBlock#getFailureModes()
	 * @see #getSafetyCriticalBlock()
	 * @generated
	 */
	EReference getSafetyCriticalBlock_FailureModes();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyCriticalBlock#isHasRedundancy <em>Has Redundancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Redundancy</em>'.
	 * @see unified.SafetyCriticalBlock#isHasRedundancy()
	 * @see #getSafetyCriticalBlock()
	 * @generated
	 */
	EAttribute getSafetyCriticalBlock_HasRedundancy();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyCriticalBlock#getRedundancyType <em>Redundancy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redundancy Type</em>'.
	 * @see unified.SafetyCriticalBlock#getRedundancyType()
	 * @see #getSafetyCriticalBlock()
	 * @generated
	 */
	EAttribute getSafetyCriticalBlock_RedundancyType();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyCriticalBlock#getAsilLevel <em>Asil Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asil Level</em>'.
	 * @see unified.SafetyCriticalBlock#getAsilLevel()
	 * @see #getSafetyCriticalBlock()
	 * @generated
	 */
	EAttribute getSafetyCriticalBlock_AsilLevel();

	/**
	 * Returns the meta object for class '{@link unified.SystemBlock <em>System Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Block</em>'.
	 * @see unified.SystemBlock
	 * @generated
	 */
	EClass getSystemBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link unified.SystemBlock#getSubBlocks <em>Sub Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Blocks</em>'.
	 * @see unified.SystemBlock#getSubBlocks()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_SubBlocks();

	/**
	 * Returns the meta object for the container reference '{@link unified.SystemBlock#getParentBlock <em>Parent Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Block</em>'.
	 * @see unified.SystemBlock#getParentBlock()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_ParentBlock();

	/**
	 * Returns the meta object for the reference list '{@link unified.SystemBlock#getAssociationAsSource <em>Association As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association As Source</em>'.
	 * @see unified.SystemBlock#getAssociationAsSource()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_AssociationAsSource();

	/**
	 * Returns the meta object for the reference list '{@link unified.SystemBlock#getAssociationAsTarget <em>Association As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association As Target</em>'.
	 * @see unified.SystemBlock#getAssociationAsTarget()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_AssociationAsTarget();

	/**
	 * Returns the meta object for the reference list '{@link unified.SystemBlock#getConnectionAsSource <em>Connection As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connection As Source</em>'.
	 * @see unified.SystemBlock#getConnectionAsSource()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_ConnectionAsSource();

	/**
	 * Returns the meta object for the reference list '{@link unified.SystemBlock#getConnectionAsTarget <em>Connection As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connection As Target</em>'.
	 * @see unified.SystemBlock#getConnectionAsTarget()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EReference getSystemBlock_ConnectionAsTarget();

	/**
	 * Returns the meta object for the attribute '{@link unified.SystemBlock#getBlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block Type</em>'.
	 * @see unified.SystemBlock#getBlockType()
	 * @see #getSystemBlock()
	 * @generated
	 */
	EAttribute getSystemBlock_BlockType();

	/**
	 * Returns the meta object for class '{@link unified.BlockAssociation <em>Block Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Association</em>'.
	 * @see unified.BlockAssociation
	 * @generated
	 */
	EClass getBlockAssociation();

	/**
	 * Returns the meta object for the attribute '{@link unified.BlockAssociation#getAssociationType <em>Association Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Association Type</em>'.
	 * @see unified.BlockAssociation#getAssociationType()
	 * @see #getBlockAssociation()
	 * @generated
	 */
	EAttribute getBlockAssociation_AssociationType();

	/**
	 * Returns the meta object for the reference '{@link unified.BlockAssociation#getSourceBlock <em>Source Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Block</em>'.
	 * @see unified.BlockAssociation#getSourceBlock()
	 * @see #getBlockAssociation()
	 * @generated
	 */
	EReference getBlockAssociation_SourceBlock();

	/**
	 * Returns the meta object for the reference '{@link unified.BlockAssociation#getTargetBlock <em>Target Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Block</em>'.
	 * @see unified.BlockAssociation#getTargetBlock()
	 * @see #getBlockAssociation()
	 * @generated
	 */
	EReference getBlockAssociation_TargetBlock();

	/**
	 * Returns the meta object for class '{@link unified.BlockConnection <em>Block Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Connection</em>'.
	 * @see unified.BlockConnection
	 * @generated
	 */
	EClass getBlockConnection();

	/**
	 * Returns the meta object for the attribute '{@link unified.BlockConnection#getConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Type</em>'.
	 * @see unified.BlockConnection#getConnectionType()
	 * @see #getBlockConnection()
	 * @generated
	 */
	EAttribute getBlockConnection_ConnectionType();

	/**
	 * Returns the meta object for the reference list '{@link unified.BlockConnection#getFromBlock <em>From Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Block</em>'.
	 * @see unified.BlockConnection#getFromBlock()
	 * @see #getBlockConnection()
	 * @generated
	 */
	EReference getBlockConnection_FromBlock();

	/**
	 * Returns the meta object for the reference list '{@link unified.BlockConnection#getToBlock <em>To Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To Block</em>'.
	 * @see unified.BlockConnection#getToBlock()
	 * @see #getBlockConnection()
	 * @generated
	 */
	EReference getBlockConnection_ToBlock();

	/**
	 * Returns the meta object for class '{@link unified.BlockFailureMode <em>Block Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Failure Mode</em>'.
	 * @see unified.BlockFailureMode
	 * @generated
	 */
	EClass getBlockFailureMode();

	/**
	 * Returns the meta object for the container reference '{@link unified.BlockFailureMode#getAffectedBlock <em>Affected Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Affected Block</em>'.
	 * @see unified.BlockFailureMode#getAffectedBlock()
	 * @see #getBlockFailureMode()
	 * @generated
	 */
	EReference getBlockFailureMode_AffectedBlock();

	/**
	 * Returns the meta object for the attribute '{@link unified.BlockFailureMode#getFailureRate <em>Failure Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Rate</em>'.
	 * @see unified.BlockFailureMode#getFailureRate()
	 * @see #getBlockFailureMode()
	 * @generated
	 */
	EAttribute getBlockFailureMode_FailureRate();

	/**
	 * Returns the meta object for the attribute '{@link unified.BlockFailureMode#getFailureEffect <em>Failure Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Effect</em>'.
	 * @see unified.BlockFailureMode#getFailureEffect()
	 * @see #getBlockFailureMode()
	 * @generated
	 */
	EAttribute getBlockFailureMode_FailureEffect();

	/**
	 * Returns the meta object for class '{@link unified.AnalysisMetadata <em>Analysis Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis Metadata</em>'.
	 * @see unified.AnalysisMetadata
	 * @generated
	 */
	EClass getAnalysisMetadata();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getLastAnalysisDate <em>Last Analysis Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Analysis Date</em>'.
	 * @see unified.AnalysisMetadata#getLastAnalysisDate()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_LastAnalysisDate();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getCompletenessScore <em>Completeness Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completeness Score</em>'.
	 * @see unified.AnalysisMetadata#getCompletenessScore()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_CompletenessScore();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getConsistencyScore <em>Consistency Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consistency Score</em>'.
	 * @see unified.AnalysisMetadata#getConsistencyScore()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_ConsistencyScore();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getHazardCoverage <em>Hazard Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hazard Coverage</em>'.
	 * @see unified.AnalysisMetadata#getHazardCoverage()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_HazardCoverage();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getFmeaCoverage <em>Fmea Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmea Coverage</em>'.
	 * @see unified.AnalysisMetadata#getFmeaCoverage()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_FmeaCoverage();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getTraceabilityDensity <em>Traceability Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traceability Density</em>'.
	 * @see unified.AnalysisMetadata#getTraceabilityDensity()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_TraceabilityDensity();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getCyclomaticComplexity <em>Cyclomatic Complexity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cyclomatic Complexity</em>'.
	 * @see unified.AnalysisMetadata#getCyclomaticComplexity()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_CyclomaticComplexity();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getMcr <em>Mcr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mcr</em>'.
	 * @see unified.AnalysisMetadata#getMcr()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Mcr();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getHti <em>Hti</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hti</em>'.
	 * @see unified.AnalysisMetadata#getHti()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Hti();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getRar <em>Rar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rar</em>'.
	 * @see unified.AnalysisMetadata#getRar()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Rar();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getFlc <em>Flc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flc</em>'.
	 * @see unified.AnalysisMetadata#getFlc()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Flc();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getTds <em>Tds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tds</em>'.
	 * @see unified.AnalysisMetadata#getTds()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Tds();

	/**
	 * Returns the meta object for the attribute '{@link unified.AnalysisMetadata#getMvr <em>Mvr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mvr</em>'.
	 * @see unified.AnalysisMetadata#getMvr()
	 * @see #getAnalysisMetadata()
	 * @generated
	 */
	EAttribute getAnalysisMetadata_Mvr();

	/**
	 * Returns the meta object for class '{@link unified.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see unified.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link unified.Requirement#getRequirementId <em>Requirement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Id</em>'.
	 * @see unified.Requirement#getRequirementId()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_RequirementId();

	/**
	 * Returns the meta object for the attribute '{@link unified.Requirement#getRequirementText <em>Requirement Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Text</em>'.
	 * @see unified.Requirement#getRequirementText()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_RequirementText();

	/**
	 * Returns the meta object for the attribute '{@link unified.Requirement#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see unified.Requirement#getStatus()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Status();

	/**
	 * Returns the meta object for the attribute '{@link unified.Requirement#getVerificationMethod <em>Verification Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verification Method</em>'.
	 * @see unified.Requirement#getVerificationMethod()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_VerificationMethod();

	/**
	 * Returns the meta object for the attribute '{@link unified.Requirement#getRationale <em>Rationale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rationale</em>'.
	 * @see unified.Requirement#getRationale()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Rationale();

	/**
	 * Returns the meta object for the reference list '{@link unified.Requirement#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see unified.Requirement#getDerivedFrom()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_DerivedFrom();

	/**
	 * Returns the meta object for the reference list '{@link unified.Requirement#getSatisfiedBy <em>Satisfied By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied By</em>'.
	 * @see unified.Requirement#getSatisfiedBy()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_SatisfiedBy();

	/**
	 * Returns the meta object for class '{@link unified.SafetyGoal <em>Safety Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Goal</em>'.
	 * @see unified.SafetyGoal
	 * @generated
	 */
	EClass getSafetyGoal();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyGoal#getAsilLevel <em>Asil Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asil Level</em>'.
	 * @see unified.SafetyGoal#getAsilLevel()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EAttribute getSafetyGoal_AsilLevel();

	/**
	 * Returns the meta object for the reference '{@link unified.SafetyGoal#getRelatedHazard <em>Related Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Hazard</em>'.
	 * @see unified.SafetyGoal#getRelatedHazard()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_RelatedHazard();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyGoal#getSafeState <em>Safe State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Safe State</em>'.
	 * @see unified.SafetyGoal#getSafeState()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EAttribute getSafetyGoal_SafeState();

	/**
	 * Returns the meta object for the reference list '{@link unified.SafetyGoal#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allocated To</em>'.
	 * @see unified.SafetyGoal#getAllocatedTo()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_AllocatedTo();

	/**
	 * Returns the meta object for class '{@link unified.FunctionalSafetyRequirement <em>Functional Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Safety Requirement</em>'.
	 * @see unified.FunctionalSafetyRequirement
	 * @generated
	 */
	EClass getFunctionalSafetyRequirement();

	/**
	 * Returns the meta object for the attribute '{@link unified.FunctionalSafetyRequirement#getRequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Type</em>'.
	 * @see unified.FunctionalSafetyRequirement#getRequirementType()
	 * @see #getFunctionalSafetyRequirement()
	 * @generated
	 */
	EAttribute getFunctionalSafetyRequirement_RequirementType();

	/**
	 * Returns the meta object for the reference '{@link unified.FunctionalSafetyRequirement#getAllocatedFrom <em>Allocated From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocated From</em>'.
	 * @see unified.FunctionalSafetyRequirement#getAllocatedFrom()
	 * @see #getFunctionalSafetyRequirement()
	 * @generated
	 */
	EReference getFunctionalSafetyRequirement_AllocatedFrom();

	/**
	 * Returns the meta object for the reference list '{@link unified.FunctionalSafetyRequirement#getRefinedTo <em>Refined To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refined To</em>'.
	 * @see unified.FunctionalSafetyRequirement#getRefinedTo()
	 * @see #getFunctionalSafetyRequirement()
	 * @generated
	 */
	EReference getFunctionalSafetyRequirement_RefinedTo();

	/**
	 * Returns the meta object for the reference list '{@link unified.FunctionalSafetyRequirement#getImplementedBy <em>Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implemented By</em>'.
	 * @see unified.FunctionalSafetyRequirement#getImplementedBy()
	 * @see #getFunctionalSafetyRequirement()
	 * @generated
	 */
	EReference getFunctionalSafetyRequirement_ImplementedBy();

	/**
	 * Returns the meta object for class '{@link unified.TechnicalSafetyRequirement <em>Technical Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technical Safety Requirement</em>'.
	 * @see unified.TechnicalSafetyRequirement
	 * @generated
	 */
	EClass getTechnicalSafetyRequirement();

	/**
	 * Returns the meta object for the attribute '{@link unified.TechnicalSafetyRequirement#getTechnicalCategory <em>Technical Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Technical Category</em>'.
	 * @see unified.TechnicalSafetyRequirement#getTechnicalCategory()
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 */
	EAttribute getTechnicalSafetyRequirement_TechnicalCategory();

	/**
	 * Returns the meta object for the attribute '{@link unified.TechnicalSafetyRequirement#getAllocatedASIL <em>Allocated ASIL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allocated ASIL</em>'.
	 * @see unified.TechnicalSafetyRequirement#getAllocatedASIL()
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 */
	EAttribute getTechnicalSafetyRequirement_AllocatedASIL();

	/**
	 * Returns the meta object for the reference '{@link unified.TechnicalSafetyRequirement#getRefinesFrom <em>Refines From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refines From</em>'.
	 * @see unified.TechnicalSafetyRequirement#getRefinesFrom()
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 */
	EReference getTechnicalSafetyRequirement_RefinesFrom();

	/**
	 * Returns the meta object for the reference list '{@link unified.TechnicalSafetyRequirement#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized By</em>'.
	 * @see unified.TechnicalSafetyRequirement#getRealizedBy()
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 */
	EReference getTechnicalSafetyRequirement_RealizedBy();

	/**
	 * Returns the meta object for the reference list '{@link unified.TechnicalSafetyRequirement#getVerifiedBy <em>Verified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Verified By</em>'.
	 * @see unified.TechnicalSafetyRequirement#getVerifiedBy()
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 */
	EReference getTechnicalSafetyRequirement_VerifiedBy();

	/**
	 * Returns the meta object for class '{@link unified.SafetyMechanism <em>Safety Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Mechanism</em>'.
	 * @see unified.SafetyMechanism
	 * @generated
	 */
	EClass getSafetyMechanism();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyMechanism#getMechanismType <em>Mechanism Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mechanism Type</em>'.
	 * @see unified.SafetyMechanism#getMechanismType()
	 * @see #getSafetyMechanism()
	 * @generated
	 */
	EAttribute getSafetyMechanism_MechanismType();

	/**
	 * Returns the meta object for the attribute '{@link unified.SafetyMechanism#getDiagnosticCoverage <em>Diagnostic Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic Coverage</em>'.
	 * @see unified.SafetyMechanism#getDiagnosticCoverage()
	 * @see #getSafetyMechanism()
	 * @generated
	 */
	EAttribute getSafetyMechanism_DiagnosticCoverage();

	/**
	 * Returns the meta object for the reference list '{@link unified.SafetyMechanism#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implements</em>'.
	 * @see unified.SafetyMechanism#getImplements()
	 * @see #getSafetyMechanism()
	 * @generated
	 */
	EReference getSafetyMechanism_Implements();

	/**
	 * Returns the meta object for the reference '{@link unified.SafetyMechanism#getImplementedIn <em>Implemented In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implemented In</em>'.
	 * @see unified.SafetyMechanism#getImplementedIn()
	 * @see #getSafetyMechanism()
	 * @generated
	 */
	EReference getSafetyMechanism_ImplementedIn();

	/**
	 * Returns the meta object for the reference list '{@link unified.SafetyMechanism#getValidatedBy <em>Validated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Validated By</em>'.
	 * @see unified.SafetyMechanism#getValidatedBy()
	 * @see #getSafetyMechanism()
	 * @generated
	 */
	EReference getSafetyMechanism_ValidatedBy();

	/**
	 * Returns the meta object for enum '{@link unified.SafetyCriticalityLevel <em>Safety Criticality Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Safety Criticality Level</em>'.
	 * @see unified.SafetyCriticalityLevel
	 * @generated
	 */
	EEnum getSafetyCriticalityLevel();

	/**
	 * Returns the meta object for enum '{@link unified.ActionStatus <em>Action Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Status</em>'.
	 * @see unified.ActionStatus
	 * @generated
	 */
	EEnum getActionStatus();

	/**
	 * Returns the meta object for enum '{@link unified.RiskLevel <em>Risk Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk Level</em>'.
	 * @see unified.RiskLevel
	 * @generated
	 */
	EEnum getRiskLevel();

	/**
	 * Returns the meta object for enum '{@link unified.ConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Type</em>'.
	 * @see unified.ConnectionType
	 * @generated
	 */
	EEnum getConnectionType();

	/**
	 * Returns the meta object for enum '{@link unified.AssociationType <em>Association Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Association Type</em>'.
	 * @see unified.AssociationType
	 * @generated
	 */
	EEnum getAssociationType();

	/**
	 * Returns the meta object for enum '{@link unified.AnalysisStatus <em>Analysis Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Analysis Status</em>'.
	 * @see unified.AnalysisStatus
	 * @generated
	 */
	EEnum getAnalysisStatus();

	/**
	 * Returns the meta object for enum '{@link unified.MitigationStatus <em>Mitigation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mitigation Status</em>'.
	 * @see unified.MitigationStatus
	 * @generated
	 */
	EEnum getMitigationStatus();

	/**
	 * Returns the meta object for enum '{@link unified.HazardCategory <em>Hazard Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Hazard Category</em>'.
	 * @see unified.HazardCategory
	 * @generated
	 */
	EEnum getHazardCategory();

	/**
	 * Returns the meta object for enum '{@link unified.RedundancyType <em>Redundancy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redundancy Type</em>'.
	 * @see unified.RedundancyType
	 * @generated
	 */
	EEnum getRedundancyType();

	/**
	 * Returns the meta object for enum '{@link unified.ASILLevel <em>ASIL Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ASIL Level</em>'.
	 * @see unified.ASILLevel
	 * @generated
	 */
	EEnum getASILLevel();

	/**
	 * Returns the meta object for enum '{@link unified.BlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Block Type</em>'.
	 * @see unified.BlockType
	 * @generated
	 */
	EEnum getBlockType();

	/**
	 * Returns the meta object for enum '{@link unified.RequirementStatus <em>Requirement Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Requirement Status</em>'.
	 * @see unified.RequirementStatus
	 * @generated
	 */
	EEnum getRequirementStatus();

	/**
	 * Returns the meta object for enum '{@link unified.VerificationMethod <em>Verification Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Verification Method</em>'.
	 * @see unified.VerificationMethod
	 * @generated
	 */
	EEnum getVerificationMethod();

	/**
	 * Returns the meta object for enum '{@link unified.FunctionalRequirementType <em>Functional Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Functional Requirement Type</em>'.
	 * @see unified.FunctionalRequirementType
	 * @generated
	 */
	EEnum getFunctionalRequirementType();

	/**
	 * Returns the meta object for enum '{@link unified.TechnicalRequirementCategory <em>Technical Requirement Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Technical Requirement Category</em>'.
	 * @see unified.TechnicalRequirementCategory
	 * @generated
	 */
	EEnum getTechnicalRequirementCategory();

	/**
	 * Returns the meta object for enum '{@link unified.SafetyMechanismType <em>Safety Mechanism Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Safety Mechanism Type</em>'.
	 * @see unified.SafetyMechanismType
	 * @generated
	 */
	EEnum getSafetyMechanismType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UnifiedFactory getUnifiedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link unified.impl.UnifiedElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.UnifiedElementImpl
		 * @see unified.impl.UnifiedPackageImpl#getUnifiedElement()
		 * @generated
		 */
		EClass UNIFIED_ELEMENT = eINSTANCE.getUnifiedElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_ELEMENT__ID = eINSTANCE.getUnifiedElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_ELEMENT__NAME = eINSTANCE.getUnifiedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_ELEMENT__DESCRIPTION = eINSTANCE.getUnifiedElement_Description();

		/**
		 * The meta object literal for the '{@link unified.impl.UnifiedSystemModelImpl <em>System Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.UnifiedSystemModelImpl
		 * @see unified.impl.UnifiedPackageImpl#getUnifiedSystemModel()
		 * @generated
		 */
		EClass UNIFIED_SYSTEM_MODEL = eINSTANCE.getUnifiedSystemModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_SYSTEM_MODEL__NAME = eINSTANCE.getUnifiedSystemModel_Name();

		/**
		 * The meta object literal for the '<em><b>Fmea Analysis</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS = eINSTANCE.getUnifiedSystemModel_FmeaAnalysis();

		/**
		 * The meta object literal for the '<em><b>Global Hazards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS = eINSTANCE.getUnifiedSystemModel_GlobalHazards();

		/**
		 * The meta object literal for the '<em><b>Root Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS = eINSTANCE.getUnifiedSystemModel_RootBlocks();

		/**
		 * The meta object literal for the '<em><b>System Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS = eINSTANCE.getUnifiedSystemModel_SystemBlocks();

		/**
		 * The meta object literal for the '<em><b>Block Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS = eINSTANCE.getUnifiedSystemModel_BlockAssociations();

		/**
		 * The meta object literal for the '<em><b>Block Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS = eINSTANCE.getUnifiedSystemModel_BlockConnections();

		/**
		 * The meta object literal for the '<em><b>Analysis Metadata</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA = eINSTANCE.getUnifiedSystemModel_AnalysisMetadata();

		/**
		 * The meta object literal for the '<em><b>Model Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_SYSTEM_MODEL__MODEL_VERSION = eINSTANCE.getUnifiedSystemModel_ModelVersion();

		/**
		 * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFIED_SYSTEM_MODEL__LAST_MODIFIED = eINSTANCE.getUnifiedSystemModel_LastModified();

		/**
		 * The meta object literal for the '<em><b>Safety Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__SAFETY_GOALS = eINSTANCE.getUnifiedSystemModel_SafetyGoals();

		/**
		 * The meta object literal for the '<em><b>Functional Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS = eINSTANCE.getUnifiedSystemModel_FunctionalRequirements();

		/**
		 * The meta object literal for the '<em><b>Technical Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS = eINSTANCE.getUnifiedSystemModel_TechnicalRequirements();

		/**
		 * The meta object literal for the '<em><b>Safety Mechanisms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS = eINSTANCE.getUnifiedSystemModel_SafetyMechanisms();

		/**
		 * The meta object literal for the '{@link unified.impl.FMEAAnalysisImpl <em>FMEA Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.FMEAAnalysisImpl
		 * @see unified.impl.UnifiedPackageImpl#getFMEAAnalysis()
		 * @generated
		 */
		EClass FMEA_ANALYSIS = eINSTANCE.getFMEAAnalysis();

		/**
		 * The meta object literal for the '<em><b>Rpn Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__RPN_THRESHOLD = eINSTANCE.getFMEAAnalysis_RpnThreshold();

		/**
		 * The meta object literal for the '<em><b>Fmea Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ANALYSIS__FMEA_ITEMS = eINSTANCE.getFMEAAnalysis_FmeaItems();

		/**
		 * The meta object literal for the '<em><b>Analysis Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__ANALYSIS_DATE = eINSTANCE.getFMEAAnalysis_AnalysisDate();

		/**
		 * The meta object literal for the '<em><b>Analysis Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__ANALYSIS_STATUS = eINSTANCE.getFMEAAnalysis_AnalysisStatus();

		/**
		 * The meta object literal for the '<em><b>Reviewer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ANALYSIS__REVIEWER = eINSTANCE.getFMEAAnalysis_Reviewer();

		/**
		 * The meta object literal for the '{@link unified.impl.FMEAItemImpl <em>FMEA Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.FMEAItemImpl
		 * @see unified.impl.UnifiedPackageImpl#getFMEAItem()
		 * @generated
		 */
		EClass FMEA_ITEM = eINSTANCE.getFMEAItem();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__SEVERITY = eINSTANCE.getFMEAItem_Severity();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__OCCURRENCE = eINSTANCE.getFMEAItem_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Detection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__DETECTION = eINSTANCE.getFMEAItem_Detection();

		/**
		 * The meta object literal for the '<em><b>Local Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__LOCAL_EFFECT = eINSTANCE.getFMEAItem_LocalEffect();

		/**
		 * The meta object literal for the '<em><b>System Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__SYSTEM_EFFECT = eINSTANCE.getFMEAItem_SystemEffect();

		/**
		 * The meta object literal for the '<em><b>Recommended Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__RECOMMENDED_ACTION = eINSTANCE.getFMEAItem_RecommendedAction();

		/**
		 * The meta object literal for the '<em><b>Action Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__ACTION_STATUS = eINSTANCE.getFMEAItem_ActionStatus();

		/**
		 * The meta object literal for the '<em><b>Failure Mode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ITEM__FAILURE_MODE = eINSTANCE.getFMEAItem_FailureMode();

		/**
		 * The meta object literal for the '<em><b>Analyzed Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ITEM__ANALYZED_COMPONENT = eINSTANCE.getFMEAItem_AnalyzedComponent();

		/**
		 * The meta object literal for the '<em><b>Auto Generated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__AUTO_GENERATED = eINSTANCE.getFMEAItem_AutoGenerated();

		/**
		 * The meta object literal for the '<em><b>Related Hazards</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ITEM__RELATED_HAZARDS = eINSTANCE.getFMEAItem_RelatedHazards();

		/**
		 * The meta object literal for the '<em><b>Responsible Person</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__RESPONSIBLE_PERSON = eINSTANCE.getFMEAItem_ResponsiblePerson();

		/**
		 * The meta object literal for the '<em><b>Due Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMEA_ITEM__DUE_DATE = eINSTANCE.getFMEAItem_DueDate();

		/**
		 * The meta object literal for the '<em><b>Validates Mechanisms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMEA_ITEM__VALIDATES_MECHANISMS = eINSTANCE.getFMEAItem_ValidatesMechanisms();

		/**
		 * The meta object literal for the '{@link unified.impl.IntegratedHazardImpl <em>Integrated Hazard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.IntegratedHazardImpl
		 * @see unified.impl.UnifiedPackageImpl#getIntegratedHazard()
		 * @generated
		 */
		EClass INTEGRATED_HAZARD = eINSTANCE.getIntegratedHazard();

		/**
		 * The meta object literal for the '<em><b>Risk Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRATED_HAZARD__RISK_LEVEL = eINSTANCE.getIntegratedHazard_RiskLevel();

		/**
		 * The meta object literal for the '<em><b>Related Blocks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGRATED_HAZARD__RELATED_BLOCKS = eINSTANCE.getIntegratedHazard_RelatedBlocks();

		/**
		 * The meta object literal for the '<em><b>Mitigation Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRATED_HAZARD__MITIGATION_STATUS = eINSTANCE.getIntegratedHazard_MitigationStatus();

		/**
		 * The meta object literal for the '<em><b>Hazard Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRATED_HAZARD__HAZARD_CATEGORY = eINSTANCE.getIntegratedHazard_HazardCategory();

		/**
		 * The meta object literal for the '<em><b>Severity Justification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRATED_HAZARD__SEVERITY_JUSTIFICATION = eINSTANCE.getIntegratedHazard_SeverityJustification();

		/**
		 * The meta object literal for the '{@link unified.impl.SafetyCriticalBlockImpl <em>Safety Critical Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.SafetyCriticalBlockImpl
		 * @see unified.impl.UnifiedPackageImpl#getSafetyCriticalBlock()
		 * @generated
		 */
		EClass SAFETY_CRITICAL_BLOCK = eINSTANCE.getSafetyCriticalBlock();

		/**
		 * The meta object literal for the '<em><b>Safety Criticality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_CRITICAL_BLOCK__SAFETY_CRITICALITY = eINSTANCE.getSafetyCriticalBlock_SafetyCriticality();

		/**
		 * The meta object literal for the '<em><b>Failure Modes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CRITICAL_BLOCK__FAILURE_MODES = eINSTANCE.getSafetyCriticalBlock_FailureModes();

		/**
		 * The meta object literal for the '<em><b>Has Redundancy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_CRITICAL_BLOCK__HAS_REDUNDANCY = eINSTANCE.getSafetyCriticalBlock_HasRedundancy();

		/**
		 * The meta object literal for the '<em><b>Redundancy Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_CRITICAL_BLOCK__REDUNDANCY_TYPE = eINSTANCE.getSafetyCriticalBlock_RedundancyType();

		/**
		 * The meta object literal for the '<em><b>Asil Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_CRITICAL_BLOCK__ASIL_LEVEL = eINSTANCE.getSafetyCriticalBlock_AsilLevel();

		/**
		 * The meta object literal for the '{@link unified.impl.SystemBlockImpl <em>System Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.SystemBlockImpl
		 * @see unified.impl.UnifiedPackageImpl#getSystemBlock()
		 * @generated
		 */
		EClass SYSTEM_BLOCK = eINSTANCE.getSystemBlock();

		/**
		 * The meta object literal for the '<em><b>Sub Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__SUB_BLOCKS = eINSTANCE.getSystemBlock_SubBlocks();

		/**
		 * The meta object literal for the '<em><b>Parent Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__PARENT_BLOCK = eINSTANCE.getSystemBlock_ParentBlock();

		/**
		 * The meta object literal for the '<em><b>Association As Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__ASSOCIATION_AS_SOURCE = eINSTANCE.getSystemBlock_AssociationAsSource();

		/**
		 * The meta object literal for the '<em><b>Association As Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__ASSOCIATION_AS_TARGET = eINSTANCE.getSystemBlock_AssociationAsTarget();

		/**
		 * The meta object literal for the '<em><b>Connection As Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__CONNECTION_AS_SOURCE = eINSTANCE.getSystemBlock_ConnectionAsSource();

		/**
		 * The meta object literal for the '<em><b>Connection As Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BLOCK__CONNECTION_AS_TARGET = eINSTANCE.getSystemBlock_ConnectionAsTarget();

		/**
		 * The meta object literal for the '<em><b>Block Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_BLOCK__BLOCK_TYPE = eINSTANCE.getSystemBlock_BlockType();

		/**
		 * The meta object literal for the '{@link unified.impl.BlockAssociationImpl <em>Block Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.BlockAssociationImpl
		 * @see unified.impl.UnifiedPackageImpl#getBlockAssociation()
		 * @generated
		 */
		EClass BLOCK_ASSOCIATION = eINSTANCE.getBlockAssociation();

		/**
		 * The meta object literal for the '<em><b>Association Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ASSOCIATION__ASSOCIATION_TYPE = eINSTANCE.getBlockAssociation_AssociationType();

		/**
		 * The meta object literal for the '<em><b>Source Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ASSOCIATION__SOURCE_BLOCK = eINSTANCE.getBlockAssociation_SourceBlock();

		/**
		 * The meta object literal for the '<em><b>Target Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ASSOCIATION__TARGET_BLOCK = eINSTANCE.getBlockAssociation_TargetBlock();

		/**
		 * The meta object literal for the '{@link unified.impl.BlockConnectionImpl <em>Block Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.BlockConnectionImpl
		 * @see unified.impl.UnifiedPackageImpl#getBlockConnection()
		 * @generated
		 */
		EClass BLOCK_CONNECTION = eINSTANCE.getBlockConnection();

		/**
		 * The meta object literal for the '<em><b>Connection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_CONNECTION__CONNECTION_TYPE = eINSTANCE.getBlockConnection_ConnectionType();

		/**
		 * The meta object literal for the '<em><b>From Block</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_CONNECTION__FROM_BLOCK = eINSTANCE.getBlockConnection_FromBlock();

		/**
		 * The meta object literal for the '<em><b>To Block</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_CONNECTION__TO_BLOCK = eINSTANCE.getBlockConnection_ToBlock();

		/**
		 * The meta object literal for the '{@link unified.impl.BlockFailureModeImpl <em>Block Failure Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.BlockFailureModeImpl
		 * @see unified.impl.UnifiedPackageImpl#getBlockFailureMode()
		 * @generated
		 */
		EClass BLOCK_FAILURE_MODE = eINSTANCE.getBlockFailureMode();

		/**
		 * The meta object literal for the '<em><b>Affected Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_FAILURE_MODE__AFFECTED_BLOCK = eINSTANCE.getBlockFailureMode_AffectedBlock();

		/**
		 * The meta object literal for the '<em><b>Failure Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_FAILURE_MODE__FAILURE_RATE = eINSTANCE.getBlockFailureMode_FailureRate();

		/**
		 * The meta object literal for the '<em><b>Failure Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_FAILURE_MODE__FAILURE_EFFECT = eINSTANCE.getBlockFailureMode_FailureEffect();

		/**
		 * The meta object literal for the '{@link unified.impl.AnalysisMetadataImpl <em>Analysis Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.AnalysisMetadataImpl
		 * @see unified.impl.UnifiedPackageImpl#getAnalysisMetadata()
		 * @generated
		 */
		EClass ANALYSIS_METADATA = eINSTANCE.getAnalysisMetadata();

		/**
		 * The meta object literal for the '<em><b>Last Analysis Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__LAST_ANALYSIS_DATE = eINSTANCE.getAnalysisMetadata_LastAnalysisDate();

		/**
		 * The meta object literal for the '<em><b>Completeness Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__COMPLETENESS_SCORE = eINSTANCE.getAnalysisMetadata_CompletenessScore();

		/**
		 * The meta object literal for the '<em><b>Consistency Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__CONSISTENCY_SCORE = eINSTANCE.getAnalysisMetadata_ConsistencyScore();

		/**
		 * The meta object literal for the '<em><b>Hazard Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__HAZARD_COVERAGE = eINSTANCE.getAnalysisMetadata_HazardCoverage();

		/**
		 * The meta object literal for the '<em><b>Fmea Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__FMEA_COVERAGE = eINSTANCE.getAnalysisMetadata_FmeaCoverage();

		/**
		 * The meta object literal for the '<em><b>Traceability Density</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__TRACEABILITY_DENSITY = eINSTANCE.getAnalysisMetadata_TraceabilityDensity();

		/**
		 * The meta object literal for the '<em><b>Cyclomatic Complexity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__CYCLOMATIC_COMPLEXITY = eINSTANCE.getAnalysisMetadata_CyclomaticComplexity();

		/**
		 * The meta object literal for the '<em><b>Mcr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__MCR = eINSTANCE.getAnalysisMetadata_Mcr();

		/**
		 * The meta object literal for the '<em><b>Hti</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__HTI = eINSTANCE.getAnalysisMetadata_Hti();

		/**
		 * The meta object literal for the '<em><b>Rar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__RAR = eINSTANCE.getAnalysisMetadata_Rar();

		/**
		 * The meta object literal for the '<em><b>Flc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__FLC = eINSTANCE.getAnalysisMetadata_Flc();

		/**
		 * The meta object literal for the '<em><b>Tds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__TDS = eINSTANCE.getAnalysisMetadata_Tds();

		/**
		 * The meta object literal for the '<em><b>Mvr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_METADATA__MVR = eINSTANCE.getAnalysisMetadata_Mvr();

		/**
		 * The meta object literal for the '{@link unified.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.RequirementImpl
		 * @see unified.impl.UnifiedPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Requirement Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQUIREMENT_ID = eINSTANCE.getRequirement_RequirementId();

		/**
		 * The meta object literal for the '<em><b>Requirement Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQUIREMENT_TEXT = eINSTANCE.getRequirement_RequirementText();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__STATUS = eINSTANCE.getRequirement_Status();

		/**
		 * The meta object literal for the '<em><b>Verification Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__VERIFICATION_METHOD = eINSTANCE.getRequirement_VerificationMethod();

		/**
		 * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__RATIONALE = eINSTANCE.getRequirement_Rationale();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__DERIVED_FROM = eINSTANCE.getRequirement_DerivedFrom();

		/**
		 * The meta object literal for the '<em><b>Satisfied By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__SATISFIED_BY = eINSTANCE.getRequirement_SatisfiedBy();

		/**
		 * The meta object literal for the '{@link unified.impl.SafetyGoalImpl <em>Safety Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.SafetyGoalImpl
		 * @see unified.impl.UnifiedPackageImpl#getSafetyGoal()
		 * @generated
		 */
		EClass SAFETY_GOAL = eINSTANCE.getSafetyGoal();

		/**
		 * The meta object literal for the '<em><b>Asil Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_GOAL__ASIL_LEVEL = eINSTANCE.getSafetyGoal_AsilLevel();

		/**
		 * The meta object literal for the '<em><b>Related Hazard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_GOAL__RELATED_HAZARD = eINSTANCE.getSafetyGoal_RelatedHazard();

		/**
		 * The meta object literal for the '<em><b>Safe State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_GOAL__SAFE_STATE = eINSTANCE.getSafetyGoal_SafeState();

		/**
		 * The meta object literal for the '<em><b>Allocated To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_GOAL__ALLOCATED_TO = eINSTANCE.getSafetyGoal_AllocatedTo();

		/**
		 * The meta object literal for the '{@link unified.impl.FunctionalSafetyRequirementImpl <em>Functional Safety Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.FunctionalSafetyRequirementImpl
		 * @see unified.impl.UnifiedPackageImpl#getFunctionalSafetyRequirement()
		 * @generated
		 */
		EClass FUNCTIONAL_SAFETY_REQUIREMENT = eINSTANCE.getFunctionalSafetyRequirement();

		/**
		 * The meta object literal for the '<em><b>Requirement Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_SAFETY_REQUIREMENT__REQUIREMENT_TYPE = eINSTANCE.getFunctionalSafetyRequirement_RequirementType();

		/**
		 * The meta object literal for the '<em><b>Allocated From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_SAFETY_REQUIREMENT__ALLOCATED_FROM = eINSTANCE.getFunctionalSafetyRequirement_AllocatedFrom();

		/**
		 * The meta object literal for the '<em><b>Refined To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_SAFETY_REQUIREMENT__REFINED_TO = eINSTANCE.getFunctionalSafetyRequirement_RefinedTo();

		/**
		 * The meta object literal for the '<em><b>Implemented By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_SAFETY_REQUIREMENT__IMPLEMENTED_BY = eINSTANCE.getFunctionalSafetyRequirement_ImplementedBy();

		/**
		 * The meta object literal for the '{@link unified.impl.TechnicalSafetyRequirementImpl <em>Technical Safety Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.TechnicalSafetyRequirementImpl
		 * @see unified.impl.UnifiedPackageImpl#getTechnicalSafetyRequirement()
		 * @generated
		 */
		EClass TECHNICAL_SAFETY_REQUIREMENT = eINSTANCE.getTechnicalSafetyRequirement();

		/**
		 * The meta object literal for the '<em><b>Technical Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TECHNICAL_SAFETY_REQUIREMENT__TECHNICAL_CATEGORY = eINSTANCE.getTechnicalSafetyRequirement_TechnicalCategory();

		/**
		 * The meta object literal for the '<em><b>Allocated ASIL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TECHNICAL_SAFETY_REQUIREMENT__ALLOCATED_ASIL = eINSTANCE.getTechnicalSafetyRequirement_AllocatedASIL();

		/**
		 * The meta object literal for the '<em><b>Refines From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNICAL_SAFETY_REQUIREMENT__REFINES_FROM = eINSTANCE.getTechnicalSafetyRequirement_RefinesFrom();

		/**
		 * The meta object literal for the '<em><b>Realized By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNICAL_SAFETY_REQUIREMENT__REALIZED_BY = eINSTANCE.getTechnicalSafetyRequirement_RealizedBy();

		/**
		 * The meta object literal for the '<em><b>Verified By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNICAL_SAFETY_REQUIREMENT__VERIFIED_BY = eINSTANCE.getTechnicalSafetyRequirement_VerifiedBy();

		/**
		 * The meta object literal for the '{@link unified.impl.SafetyMechanismImpl <em>Safety Mechanism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.impl.SafetyMechanismImpl
		 * @see unified.impl.UnifiedPackageImpl#getSafetyMechanism()
		 * @generated
		 */
		EClass SAFETY_MECHANISM = eINSTANCE.getSafetyMechanism();

		/**
		 * The meta object literal for the '<em><b>Mechanism Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_MECHANISM__MECHANISM_TYPE = eINSTANCE.getSafetyMechanism_MechanismType();

		/**
		 * The meta object literal for the '<em><b>Diagnostic Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFETY_MECHANISM__DIAGNOSTIC_COVERAGE = eINSTANCE.getSafetyMechanism_DiagnosticCoverage();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_MECHANISM__IMPLEMENTS = eINSTANCE.getSafetyMechanism_Implements();

		/**
		 * The meta object literal for the '<em><b>Implemented In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_MECHANISM__IMPLEMENTED_IN = eINSTANCE.getSafetyMechanism_ImplementedIn();

		/**
		 * The meta object literal for the '<em><b>Validated By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_MECHANISM__VALIDATED_BY = eINSTANCE.getSafetyMechanism_ValidatedBy();

		/**
		 * The meta object literal for the '{@link unified.SafetyCriticalityLevel <em>Safety Criticality Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.SafetyCriticalityLevel
		 * @see unified.impl.UnifiedPackageImpl#getSafetyCriticalityLevel()
		 * @generated
		 */
		EEnum SAFETY_CRITICALITY_LEVEL = eINSTANCE.getSafetyCriticalityLevel();

		/**
		 * The meta object literal for the '{@link unified.ActionStatus <em>Action Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.ActionStatus
		 * @see unified.impl.UnifiedPackageImpl#getActionStatus()
		 * @generated
		 */
		EEnum ACTION_STATUS = eINSTANCE.getActionStatus();

		/**
		 * The meta object literal for the '{@link unified.RiskLevel <em>Risk Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.RiskLevel
		 * @see unified.impl.UnifiedPackageImpl#getRiskLevel()
		 * @generated
		 */
		EEnum RISK_LEVEL = eINSTANCE.getRiskLevel();

		/**
		 * The meta object literal for the '{@link unified.ConnectionType <em>Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.ConnectionType
		 * @see unified.impl.UnifiedPackageImpl#getConnectionType()
		 * @generated
		 */
		EEnum CONNECTION_TYPE = eINSTANCE.getConnectionType();

		/**
		 * The meta object literal for the '{@link unified.AssociationType <em>Association Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.AssociationType
		 * @see unified.impl.UnifiedPackageImpl#getAssociationType()
		 * @generated
		 */
		EEnum ASSOCIATION_TYPE = eINSTANCE.getAssociationType();

		/**
		 * The meta object literal for the '{@link unified.AnalysisStatus <em>Analysis Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.AnalysisStatus
		 * @see unified.impl.UnifiedPackageImpl#getAnalysisStatus()
		 * @generated
		 */
		EEnum ANALYSIS_STATUS = eINSTANCE.getAnalysisStatus();

		/**
		 * The meta object literal for the '{@link unified.MitigationStatus <em>Mitigation Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.MitigationStatus
		 * @see unified.impl.UnifiedPackageImpl#getMitigationStatus()
		 * @generated
		 */
		EEnum MITIGATION_STATUS = eINSTANCE.getMitigationStatus();

		/**
		 * The meta object literal for the '{@link unified.HazardCategory <em>Hazard Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.HazardCategory
		 * @see unified.impl.UnifiedPackageImpl#getHazardCategory()
		 * @generated
		 */
		EEnum HAZARD_CATEGORY = eINSTANCE.getHazardCategory();

		/**
		 * The meta object literal for the '{@link unified.RedundancyType <em>Redundancy Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.RedundancyType
		 * @see unified.impl.UnifiedPackageImpl#getRedundancyType()
		 * @generated
		 */
		EEnum REDUNDANCY_TYPE = eINSTANCE.getRedundancyType();

		/**
		 * The meta object literal for the '{@link unified.ASILLevel <em>ASIL Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.ASILLevel
		 * @see unified.impl.UnifiedPackageImpl#getASILLevel()
		 * @generated
		 */
		EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

		/**
		 * The meta object literal for the '{@link unified.BlockType <em>Block Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.BlockType
		 * @see unified.impl.UnifiedPackageImpl#getBlockType()
		 * @generated
		 */
		EEnum BLOCK_TYPE = eINSTANCE.getBlockType();

		/**
		 * The meta object literal for the '{@link unified.RequirementStatus <em>Requirement Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.RequirementStatus
		 * @see unified.impl.UnifiedPackageImpl#getRequirementStatus()
		 * @generated
		 */
		EEnum REQUIREMENT_STATUS = eINSTANCE.getRequirementStatus();

		/**
		 * The meta object literal for the '{@link unified.VerificationMethod <em>Verification Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.VerificationMethod
		 * @see unified.impl.UnifiedPackageImpl#getVerificationMethod()
		 * @generated
		 */
		EEnum VERIFICATION_METHOD = eINSTANCE.getVerificationMethod();

		/**
		 * The meta object literal for the '{@link unified.FunctionalRequirementType <em>Functional Requirement Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.FunctionalRequirementType
		 * @see unified.impl.UnifiedPackageImpl#getFunctionalRequirementType()
		 * @generated
		 */
		EEnum FUNCTIONAL_REQUIREMENT_TYPE = eINSTANCE.getFunctionalRequirementType();

		/**
		 * The meta object literal for the '{@link unified.TechnicalRequirementCategory <em>Technical Requirement Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.TechnicalRequirementCategory
		 * @see unified.impl.UnifiedPackageImpl#getTechnicalRequirementCategory()
		 * @generated
		 */
		EEnum TECHNICAL_REQUIREMENT_CATEGORY = eINSTANCE.getTechnicalRequirementCategory();

		/**
		 * The meta object literal for the '{@link unified.SafetyMechanismType <em>Safety Mechanism Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unified.SafetyMechanismType
		 * @see unified.impl.UnifiedPackageImpl#getSafetyMechanismType()
		 * @generated
		 */
		EEnum SAFETY_MECHANISM_TYPE = eINSTANCE.getSafetyMechanismType();

	}

} //UnifiedPackage
