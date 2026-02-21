/**
 */
package unified.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import unified.AnalysisMetadata;
import unified.BlockAssociation;
import unified.BlockConnection;
import unified.FMEAAnalysis;
import unified.FunctionalSafetyRequirement;
import unified.IntegratedHazard;
import unified.SafetyCriticalBlock;
import unified.SafetyGoal;
import unified.SafetyMechanism;
import unified.SystemBlock;
import unified.TechnicalSafetyRequirement;
import unified.UnifiedPackage;
import unified.UnifiedSystemModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getFmeaAnalysis <em>Fmea Analysis</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getGlobalHazards <em>Global Hazards</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getRootBlocks <em>Root Blocks</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getSystemBlocks <em>System Blocks</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getBlockAssociations <em>Block Associations</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getBlockConnections <em>Block Connections</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getAnalysisMetadata <em>Analysis Metadata</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getModelVersion <em>Model Version</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getSafetyGoals <em>Safety Goals</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getTechnicalRequirements <em>Technical Requirements</em>}</li>
 *   <li>{@link unified.impl.UnifiedSystemModelImpl#getSafetyMechanisms <em>Safety Mechanisms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnifiedSystemModelImpl extends MinimalEObjectImpl.Container implements UnifiedSystemModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFmeaAnalysis() <em>Fmea Analysis</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmeaAnalysis()
	 * @generated
	 * @ordered
	 */
	protected EList<FMEAAnalysis> fmeaAnalysis;

	/**
	 * The cached value of the '{@link #getGlobalHazards() <em>Global Hazards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalHazards()
	 * @generated
	 * @ordered
	 */
	protected EList<IntegratedHazard> globalHazards;

	/**
	 * The cached value of the '{@link #getRootBlocks() <em>Root Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCriticalBlock> rootBlocks;

	/**
	 * The cached value of the '{@link #getSystemBlocks() <em>System Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemBlock> systemBlocks;

	/**
	 * The cached value of the '{@link #getBlockAssociations() <em>Block Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockAssociation> blockAssociations;

	/**
	 * The cached value of the '{@link #getBlockConnections() <em>Block Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockConnection> blockConnections;

	/**
	 * The cached value of the '{@link #getAnalysisMetadata() <em>Analysis Metadata</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisMetadata()
	 * @generated
	 * @ordered
	 */
	protected AnalysisMetadata analysisMetadata;

	/**
	 * The default value of the '{@link #getModelVersion() <em>Model Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_VERSION_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getModelVersion() <em>Model Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelVersion()
	 * @generated
	 * @ordered
	 */
	protected String modelVersion = MODEL_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected Date lastModified = LAST_MODIFIED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSafetyGoals() <em>Safety Goals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafetyGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyGoal> safetyGoals;

	/**
	 * The cached value of the '{@link #getFunctionalRequirements() <em>Functional Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalSafetyRequirement> functionalRequirements;

	/**
	 * The cached value of the '{@link #getTechnicalRequirements() <em>Technical Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnicalSafetyRequirement> technicalRequirements;

	/**
	 * The cached value of the '{@link #getSafetyMechanisms() <em>Safety Mechanisms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafetyMechanisms()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyMechanism> safetyMechanisms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnifiedSystemModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnifiedPackage.Literals.UNIFIED_SYSTEM_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMEAAnalysis> getFmeaAnalysis() {
		if (fmeaAnalysis == null) {
			fmeaAnalysis = new EObjectContainmentEList<FMEAAnalysis>(FMEAAnalysis.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS);
		}
		return fmeaAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegratedHazard> getGlobalHazards() {
		if (globalHazards == null) {
			globalHazards = new EObjectContainmentEList<IntegratedHazard>(IntegratedHazard.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS);
		}
		return globalHazards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyCriticalBlock> getRootBlocks() {
		if (rootBlocks == null) {
			rootBlocks = new EObjectContainmentEList<SafetyCriticalBlock>(SafetyCriticalBlock.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS);
		}
		return rootBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemBlock> getSystemBlocks() {
		if (systemBlocks == null) {
			systemBlocks = new EObjectContainmentEList<SystemBlock>(SystemBlock.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS);
		}
		return systemBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockAssociation> getBlockAssociations() {
		if (blockAssociations == null) {
			blockAssociations = new EObjectContainmentEList<BlockAssociation>(BlockAssociation.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS);
		}
		return blockAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockConnection> getBlockConnections() {
		if (blockConnections == null) {
			blockConnections = new EObjectContainmentEList<BlockConnection>(BlockConnection.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS);
		}
		return blockConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisMetadata getAnalysisMetadata() {
		return analysisMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisMetadata(AnalysisMetadata newAnalysisMetadata, NotificationChain msgs) {
		AnalysisMetadata oldAnalysisMetadata = analysisMetadata;
		analysisMetadata = newAnalysisMetadata;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA, oldAnalysisMetadata, newAnalysisMetadata);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisMetadata(AnalysisMetadata newAnalysisMetadata) {
		if (newAnalysisMetadata != analysisMetadata) {
			NotificationChain msgs = null;
			if (analysisMetadata != null)
				msgs = ((InternalEObject)analysisMetadata).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA, null, msgs);
			if (newAnalysisMetadata != null)
				msgs = ((InternalEObject)newAnalysisMetadata).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA, null, msgs);
			msgs = basicSetAnalysisMetadata(newAnalysisMetadata, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA, newAnalysisMetadata, newAnalysisMetadata));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelVersion() {
		return modelVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelVersion(String newModelVersion) {
		String oldModelVersion = modelVersion;
		modelVersion = newModelVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION, oldModelVersion, modelVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModified(Date newLastModified) {
		Date oldLastModified = lastModified;
		lastModified = newLastModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED, oldLastModified, lastModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyGoal> getSafetyGoals() {
		if (safetyGoals == null) {
			safetyGoals = new EObjectContainmentEList<SafetyGoal>(SafetyGoal.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS);
		}
		return safetyGoals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalSafetyRequirement> getFunctionalRequirements() {
		if (functionalRequirements == null) {
			functionalRequirements = new EObjectContainmentEList<FunctionalSafetyRequirement>(FunctionalSafetyRequirement.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS);
		}
		return functionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TechnicalSafetyRequirement> getTechnicalRequirements() {
		if (technicalRequirements == null) {
			technicalRequirements = new EObjectContainmentEList<TechnicalSafetyRequirement>(TechnicalSafetyRequirement.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS);
		}
		return technicalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SafetyMechanism> getSafetyMechanisms() {
		if (safetyMechanisms == null) {
			safetyMechanisms = new EObjectContainmentEList<SafetyMechanism>(SafetyMechanism.class, this, UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS);
		}
		return safetyMechanisms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
				return ((InternalEList<?>)getFmeaAnalysis()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
				return ((InternalEList<?>)getGlobalHazards()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
				return ((InternalEList<?>)getRootBlocks()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
				return ((InternalEList<?>)getSystemBlocks()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
				return ((InternalEList<?>)getBlockAssociations()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
				return ((InternalEList<?>)getBlockConnections()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
				return basicSetAnalysisMetadata(null, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
				return ((InternalEList<?>)getSafetyGoals()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<?>)getFunctionalRequirements()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
				return ((InternalEList<?>)getTechnicalRequirements()).basicRemove(otherEnd, msgs);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				return ((InternalEList<?>)getSafetyMechanisms()).basicRemove(otherEnd, msgs);
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
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME:
				return getName();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
				return getFmeaAnalysis();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
				return getGlobalHazards();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
				return getRootBlocks();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
				return getSystemBlocks();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
				return getBlockAssociations();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
				return getBlockConnections();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
				return getAnalysisMetadata();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION:
				return getModelVersion();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED:
				return getLastModified();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
				return getSafetyGoals();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
				return getFunctionalRequirements();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
				return getTechnicalRequirements();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				return getSafetyMechanisms();
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
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME:
				setName((String)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
				getFmeaAnalysis().clear();
				getFmeaAnalysis().addAll((Collection<? extends FMEAAnalysis>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
				getGlobalHazards().clear();
				getGlobalHazards().addAll((Collection<? extends IntegratedHazard>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
				getRootBlocks().clear();
				getRootBlocks().addAll((Collection<? extends SafetyCriticalBlock>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
				getSystemBlocks().clear();
				getSystemBlocks().addAll((Collection<? extends SystemBlock>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
				getBlockAssociations().clear();
				getBlockAssociations().addAll((Collection<? extends BlockAssociation>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
				getBlockConnections().clear();
				getBlockConnections().addAll((Collection<? extends BlockConnection>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
				setAnalysisMetadata((AnalysisMetadata)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION:
				setModelVersion((String)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED:
				setLastModified((Date)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
				getSafetyGoals().clear();
				getSafetyGoals().addAll((Collection<? extends SafetyGoal>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				getFunctionalRequirements().addAll((Collection<? extends FunctionalSafetyRequirement>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
				getTechnicalRequirements().clear();
				getTechnicalRequirements().addAll((Collection<? extends TechnicalSafetyRequirement>)newValue);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				getSafetyMechanisms().clear();
				getSafetyMechanisms().addAll((Collection<? extends SafetyMechanism>)newValue);
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
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
				getFmeaAnalysis().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
				getGlobalHazards().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
				getRootBlocks().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
				getSystemBlocks().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
				getBlockAssociations().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
				getBlockConnections().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
				setAnalysisMetadata((AnalysisMetadata)null);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION:
				setModelVersion(MODEL_VERSION_EDEFAULT);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED:
				setLastModified(LAST_MODIFIED_EDEFAULT);
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
				getSafetyGoals().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
				getTechnicalRequirements().clear();
				return;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				getSafetyMechanisms().clear();
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
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FMEA_ANALYSIS:
				return fmeaAnalysis != null && !fmeaAnalysis.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__GLOBAL_HAZARDS:
				return globalHazards != null && !globalHazards.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ROOT_BLOCKS:
				return rootBlocks != null && !rootBlocks.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SYSTEM_BLOCKS:
				return systemBlocks != null && !systemBlocks.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_ASSOCIATIONS:
				return blockAssociations != null && !blockAssociations.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__BLOCK_CONNECTIONS:
				return blockConnections != null && !blockConnections.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__ANALYSIS_METADATA:
				return analysisMetadata != null;
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__MODEL_VERSION:
				return MODEL_VERSION_EDEFAULT == null ? modelVersion != null : !MODEL_VERSION_EDEFAULT.equals(modelVersion);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__LAST_MODIFIED:
				return LAST_MODIFIED_EDEFAULT == null ? lastModified != null : !LAST_MODIFIED_EDEFAULT.equals(lastModified);
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_GOALS:
				return safetyGoals != null && !safetyGoals.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__FUNCTIONAL_REQUIREMENTS:
				return functionalRequirements != null && !functionalRequirements.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__TECHNICAL_REQUIREMENTS:
				return technicalRequirements != null && !technicalRequirements.isEmpty();
			case UnifiedPackage.UNIFIED_SYSTEM_MODEL__SAFETY_MECHANISMS:
				return safetyMechanisms != null && !safetyMechanisms.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", modelVersion: ");
		result.append(modelVersion);
		result.append(", lastModified: ");
		result.append(lastModified);
		result.append(')');
		return result.toString();
	}

} //UnifiedSystemModelImpl
