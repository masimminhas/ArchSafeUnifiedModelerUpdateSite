/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Functional Requirement Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getFunctionalRequirementType()
 * @model
 * @generated
 */
public enum FunctionalRequirementType implements Enumerator {
	/**
	 * The '<em><b>FAULT DETECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_DETECTION_VALUE
	 * @generated
	 * @ordered
	 */
	FAULT_DETECTION(0, "FAULT_DETECTION", "FAULT_DETECTION"),

	/**
	 * The '<em><b>FAULT HANDLING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_HANDLING_VALUE
	 * @generated
	 * @ordered
	 */
	FAULT_HANDLING(1, "FAULT_HANDLING", "FAULT_HANDLING"),

	/**
	 * The '<em><b>ARBITRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARBITRATION_VALUE
	 * @generated
	 * @ordered
	 */
	ARBITRATION(2, "ARBITRATION", "ARBITRATION"),

	/**
	 * The '<em><b>WARNING INDICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WARNING_INDICATION_VALUE
	 * @generated
	 * @ordered
	 */
	WARNING_INDICATION(3, "WARNING_INDICATION", "WARNING_INDICATION"),

	/**
	 * The '<em><b>SAFE STATE TRANSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAFE_STATE_TRANSITION_VALUE
	 * @generated
	 * @ordered
	 */
	SAFE_STATE_TRANSITION(4, "SAFE_STATE_TRANSITION", "SAFE_STATE_TRANSITION");

	/**
	 * The '<em><b>FAULT DETECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_DETECTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAULT_DETECTION_VALUE = 0;

	/**
	 * The '<em><b>FAULT HANDLING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_HANDLING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAULT_HANDLING_VALUE = 1;

	/**
	 * The '<em><b>ARBITRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARBITRATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARBITRATION_VALUE = 2;

	/**
	 * The '<em><b>WARNING INDICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WARNING_INDICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WARNING_INDICATION_VALUE = 3;

	/**
	 * The '<em><b>SAFE STATE TRANSITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAFE_STATE_TRANSITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAFE_STATE_TRANSITION_VALUE = 4;

	/**
	 * An array of all the '<em><b>Functional Requirement Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FunctionalRequirementType[] VALUES_ARRAY =
		new FunctionalRequirementType[] {
			FAULT_DETECTION,
			FAULT_HANDLING,
			ARBITRATION,
			WARNING_INDICATION,
			SAFE_STATE_TRANSITION,
		};

	/**
	 * A public read-only list of all the '<em><b>Functional Requirement Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FunctionalRequirementType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Functional Requirement Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionalRequirementType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionalRequirementType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Functional Requirement Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionalRequirementType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionalRequirementType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Functional Requirement Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionalRequirementType get(int value) {
		switch (value) {
			case FAULT_DETECTION_VALUE: return FAULT_DETECTION;
			case FAULT_HANDLING_VALUE: return FAULT_HANDLING;
			case ARBITRATION_VALUE: return ARBITRATION;
			case WARNING_INDICATION_VALUE: return WARNING_INDICATION;
			case SAFE_STATE_TRANSITION_VALUE: return SAFE_STATE_TRANSITION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FunctionalRequirementType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FunctionalRequirementType
