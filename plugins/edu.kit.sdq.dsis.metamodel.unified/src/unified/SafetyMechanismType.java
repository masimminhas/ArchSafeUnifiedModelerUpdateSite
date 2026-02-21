/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Safety Mechanism Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getSafetyMechanismType()
 * @model
 * @generated
 */
public enum SafetyMechanismType implements Enumerator {
	/**
	 * The '<em><b>REDUNDANCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REDUNDANCY_VALUE
	 * @generated
	 * @ordered
	 */
	REDUNDANCY(0, "REDUNDANCY", "REDUNDANCY"),

	/**
	 * The '<em><b>PLAUSIBILITY CHECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAUSIBILITY_CHECK_VALUE
	 * @generated
	 * @ordered
	 */
	PLAUSIBILITY_CHECK(1, "PLAUSIBILITY_CHECK", "PLAUSIBILITY_CHECK"),

	/**
	 * The '<em><b>WATCHDOG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATCHDOG_VALUE
	 * @generated
	 * @ordered
	 */
	WATCHDOG(2, "WATCHDOG", "WATCHDOG"),

	/**
	 * The '<em><b>SELF TEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELF_TEST_VALUE
	 * @generated
	 * @ordered
	 */
	SELF_TEST(3, "SELF_TEST", "SELF_TEST"),

	/**
	 * The '<em><b>GRACEFUL DEGRADATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRACEFUL_DEGRADATION_VALUE
	 * @generated
	 * @ordered
	 */
	GRACEFUL_DEGRADATION(4, "GRACEFUL_DEGRADATION", "GRACEFUL_DEGRADATION"),

	/**
	 * The '<em><b>ERROR DETECTION CODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_DETECTION_CODE_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_DETECTION_CODE(5, "ERROR_DETECTION_CODE", "ERROR_DETECTION_CODE"),

	/**
	 * The '<em><b>LOCKSTEP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCKSTEP_VALUE
	 * @generated
	 * @ordered
	 */
	LOCKSTEP(6, "LOCKSTEP", "LOCKSTEP");

	/**
	 * The '<em><b>REDUNDANCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REDUNDANCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REDUNDANCY_VALUE = 0;

	/**
	 * The '<em><b>PLAUSIBILITY CHECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAUSIBILITY_CHECK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLAUSIBILITY_CHECK_VALUE = 1;

	/**
	 * The '<em><b>WATCHDOG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATCHDOG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATCHDOG_VALUE = 2;

	/**
	 * The '<em><b>SELF TEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELF_TEST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SELF_TEST_VALUE = 3;

	/**
	 * The '<em><b>GRACEFUL DEGRADATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRACEFUL_DEGRADATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRACEFUL_DEGRADATION_VALUE = 4;

	/**
	 * The '<em><b>ERROR DETECTION CODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_DETECTION_CODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_DETECTION_CODE_VALUE = 5;

	/**
	 * The '<em><b>LOCKSTEP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCKSTEP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOCKSTEP_VALUE = 6;

	/**
	 * An array of all the '<em><b>Safety Mechanism Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SafetyMechanismType[] VALUES_ARRAY =
		new SafetyMechanismType[] {
			REDUNDANCY,
			PLAUSIBILITY_CHECK,
			WATCHDOG,
			SELF_TEST,
			GRACEFUL_DEGRADATION,
			ERROR_DETECTION_CODE,
			LOCKSTEP,
		};

	/**
	 * A public read-only list of all the '<em><b>Safety Mechanism Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SafetyMechanismType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Safety Mechanism Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SafetyMechanismType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SafetyMechanismType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Safety Mechanism Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SafetyMechanismType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SafetyMechanismType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Safety Mechanism Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SafetyMechanismType get(int value) {
		switch (value) {
			case REDUNDANCY_VALUE: return REDUNDANCY;
			case PLAUSIBILITY_CHECK_VALUE: return PLAUSIBILITY_CHECK;
			case WATCHDOG_VALUE: return WATCHDOG;
			case SELF_TEST_VALUE: return SELF_TEST;
			case GRACEFUL_DEGRADATION_VALUE: return GRACEFUL_DEGRADATION;
			case ERROR_DETECTION_CODE_VALUE: return ERROR_DETECTION_CODE;
			case LOCKSTEP_VALUE: return LOCKSTEP;
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
	private SafetyMechanismType(int value, String name, String literal) {
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
	
} //SafetyMechanismType
