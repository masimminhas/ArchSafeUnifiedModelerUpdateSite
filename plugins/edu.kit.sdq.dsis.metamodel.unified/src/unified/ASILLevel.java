/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ASIL Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getASILLevel()
 * @model
 * @generated
 */
public enum ASILLevel implements Enumerator {
	/**
	 * The '<em><b>QM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QM_VALUE
	 * @generated
	 * @ordered
	 */
	QM(0, "QM", "QM"),

	/**
	 * The '<em><b>ASIL A</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_A_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_A(1, "ASIL_A", "ASIL_A"),

	/**
	 * The '<em><b>ASIL B</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_B_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_B(2, "ASIL_B", "ASIL_B"),

	/**
	 * The '<em><b>ASIL C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_C_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_C(3, "ASIL_C", "ASIL_C"),

	/**
	 * The '<em><b>ASIL D</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_D_VALUE
	 * @generated
	 * @ordered
	 */
	ASIL_D(4, "ASIL_D", "ASIL_D");

	/**
	 * The '<em><b>QM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QM_VALUE = 0;

	/**
	 * The '<em><b>ASIL A</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_A
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_A_VALUE = 1;

	/**
	 * The '<em><b>ASIL B</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_B
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_B_VALUE = 2;

	/**
	 * The '<em><b>ASIL C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_C
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_C_VALUE = 3;

	/**
	 * The '<em><b>ASIL D</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASIL_D
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASIL_D_VALUE = 4;

	/**
	 * An array of all the '<em><b>ASIL Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ASILLevel[] VALUES_ARRAY =
		new ASILLevel[] {
			QM,
			ASIL_A,
			ASIL_B,
			ASIL_C,
			ASIL_D,
		};

	/**
	 * A public read-only list of all the '<em><b>ASIL Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ASILLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ASIL Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ASILLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ASILLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ASIL Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ASILLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ASILLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ASIL Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ASILLevel get(int value) {
		switch (value) {
			case QM_VALUE: return QM;
			case ASIL_A_VALUE: return ASIL_A;
			case ASIL_B_VALUE: return ASIL_B;
			case ASIL_C_VALUE: return ASIL_C;
			case ASIL_D_VALUE: return ASIL_D;
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
	private ASILLevel(int value, String name, String literal) {
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
	
} //ASILLevel
