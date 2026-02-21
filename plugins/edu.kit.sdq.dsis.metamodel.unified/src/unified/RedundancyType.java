/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Redundancy Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getRedundancyType()
 * @model
 * @generated
 */
public enum RedundancyType implements Enumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "NONE", "NONE"),

	/**
	 * The '<em><b>COLD REDUNDANCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLD_REDUNDANCY_VALUE
	 * @generated
	 * @ordered
	 */
	COLD_REDUNDANCY(1, "COLD_REDUNDANCY", "COLD_REDUNDANCY"),

	/**
	 * The '<em><b>HOT REDUNDANCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOT_REDUNDANCY_VALUE
	 * @generated
	 * @ordered
	 */
	HOT_REDUNDANCY(2, "HOT_REDUNDANCY", "HOT_REDUNDANCY"),

	/**
	 * The '<em><b>TMR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TMR_VALUE
	 * @generated
	 * @ordered
	 */
	TMR(3, "TMR", "TMR"),

	/**
	 * The '<em><b>DIVERSIFIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVERSIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	DIVERSIFIED(4, "DIVERSIFIED", "DIVERSIFIED");

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>COLD REDUNDANCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLD_REDUNDANCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLD_REDUNDANCY_VALUE = 1;

	/**
	 * The '<em><b>HOT REDUNDANCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOT_REDUNDANCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOT_REDUNDANCY_VALUE = 2;

	/**
	 * The '<em><b>TMR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TMR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TMR_VALUE = 3;

	/**
	 * The '<em><b>DIVERSIFIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVERSIFIED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIVERSIFIED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Redundancy Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RedundancyType[] VALUES_ARRAY =
		new RedundancyType[] {
			NONE,
			COLD_REDUNDANCY,
			HOT_REDUNDANCY,
			TMR,
			DIVERSIFIED,
		};

	/**
	 * A public read-only list of all the '<em><b>Redundancy Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RedundancyType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redundancy Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedundancyType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redundancy Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedundancyType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redundancy Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyType get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case COLD_REDUNDANCY_VALUE: return COLD_REDUNDANCY;
			case HOT_REDUNDANCY_VALUE: return HOT_REDUNDANCY;
			case TMR_VALUE: return TMR;
			case DIVERSIFIED_VALUE: return DIVERSIFIED;
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
	private RedundancyType(int value, String name, String literal) {
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
	
} //RedundancyType
