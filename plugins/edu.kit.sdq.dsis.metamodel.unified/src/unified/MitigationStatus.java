/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mitigation Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getMitigationStatus()
 * @model
 * @generated
 */
public enum MitigationStatus implements Enumerator {
	/**
	 * The '<em><b>NOT MITIGATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_MITIGATED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_MITIGATED(0, "NOT_MITIGATED", "NOT_MITIGATED"),

	/**
	 * The '<em><b>PARTIALLY MITIGATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIALLY_MITIGATED_VALUE
	 * @generated
	 * @ordered
	 */
	PARTIALLY_MITIGATED(1, "PARTIALLY_MITIGATED", "PARTIALLY_MITIGATED"),

	/**
	 * The '<em><b>FULLY MITIGATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULLY_MITIGATED_VALUE
	 * @generated
	 * @ordered
	 */
	FULLY_MITIGATED(2, "FULLY_MITIGATED", "FULLY_MITIGATED"),

	/**
	 * The '<em><b>ACCEPTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCEPTED_VALUE
	 * @generated
	 * @ordered
	 */
	ACCEPTED(3, "ACCEPTED", "ACCEPTED");

	/**
	 * The '<em><b>NOT MITIGATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_MITIGATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_MITIGATED_VALUE = 0;

	/**
	 * The '<em><b>PARTIALLY MITIGATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIALLY_MITIGATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARTIALLY_MITIGATED_VALUE = 1;

	/**
	 * The '<em><b>FULLY MITIGATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULLY_MITIGATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FULLY_MITIGATED_VALUE = 2;

	/**
	 * The '<em><b>ACCEPTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCEPTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCEPTED_VALUE = 3;

	/**
	 * An array of all the '<em><b>Mitigation Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MitigationStatus[] VALUES_ARRAY =
		new MitigationStatus[] {
			NOT_MITIGATED,
			PARTIALLY_MITIGATED,
			FULLY_MITIGATED,
			ACCEPTED,
		};

	/**
	 * A public read-only list of all the '<em><b>Mitigation Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MitigationStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mitigation Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MitigationStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MitigationStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mitigation Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MitigationStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MitigationStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mitigation Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MitigationStatus get(int value) {
		switch (value) {
			case NOT_MITIGATED_VALUE: return NOT_MITIGATED;
			case PARTIALLY_MITIGATED_VALUE: return PARTIALLY_MITIGATED;
			case FULLY_MITIGATED_VALUE: return FULLY_MITIGATED;
			case ACCEPTED_VALUE: return ACCEPTED;
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
	private MitigationStatus(int value, String name, String literal) {
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
	
} //MitigationStatus
