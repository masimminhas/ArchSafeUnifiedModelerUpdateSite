/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Hazard Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getHazardCategory()
 * @model
 * @generated
 */
public enum HazardCategory implements Enumerator {
	/**
	 * The '<em><b>FUNCTIONAL FAILURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL_FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTIONAL_FAILURE(0, "FUNCTIONAL_FAILURE", "FUNCTIONAL_FAILURE"),

	/**
	 * The '<em><b>TIMING FAILURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMING_FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
	TIMING_FAILURE(1, "TIMING_FAILURE", "TIMING_FAILURE"),

	/**
	 * The '<em><b>ERRONEOUS OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERRONEOUS_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	ERRONEOUS_OUTPUT(2, "ERRONEOUS_OUTPUT", "ERRONEOUS_OUTPUT"),

	/**
	 * The '<em><b>LOSS OF FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOSS_OF_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	LOSS_OF_FUNCTION(3, "LOSS_OF_FUNCTION", "LOSS_OF_FUNCTION"),

	/**
	 * The '<em><b>UNINTENDED FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNINTENDED_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	UNINTENDED_FUNCTION(4, "UNINTENDED_FUNCTION", "UNINTENDED_FUNCTION");

	/**
	 * The '<em><b>FUNCTIONAL FAILURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL_FAILURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTIONAL_FAILURE_VALUE = 0;

	/**
	 * The '<em><b>TIMING FAILURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMING_FAILURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMING_FAILURE_VALUE = 1;

	/**
	 * The '<em><b>ERRONEOUS OUTPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERRONEOUS_OUTPUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ERRONEOUS_OUTPUT_VALUE = 2;

	/**
	 * The '<em><b>LOSS OF FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOSS_OF_FUNCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOSS_OF_FUNCTION_VALUE = 3;

	/**
	 * The '<em><b>UNINTENDED FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNINTENDED_FUNCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNINTENDED_FUNCTION_VALUE = 4;

	/**
	 * An array of all the '<em><b>Hazard Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HazardCategory[] VALUES_ARRAY =
		new HazardCategory[] {
			FUNCTIONAL_FAILURE,
			TIMING_FAILURE,
			ERRONEOUS_OUTPUT,
			LOSS_OF_FUNCTION,
			UNINTENDED_FUNCTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Hazard Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HazardCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Hazard Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HazardCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HazardCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hazard Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HazardCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HazardCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hazard Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HazardCategory get(int value) {
		switch (value) {
			case FUNCTIONAL_FAILURE_VALUE: return FUNCTIONAL_FAILURE;
			case TIMING_FAILURE_VALUE: return TIMING_FAILURE;
			case ERRONEOUS_OUTPUT_VALUE: return ERRONEOUS_OUTPUT;
			case LOSS_OF_FUNCTION_VALUE: return LOSS_OF_FUNCTION;
			case UNINTENDED_FUNCTION_VALUE: return UNINTENDED_FUNCTION;
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
	private HazardCategory(int value, String name, String literal) {
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
	
} //HazardCategory
