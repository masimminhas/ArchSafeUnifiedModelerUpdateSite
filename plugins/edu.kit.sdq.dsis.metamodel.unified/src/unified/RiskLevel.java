/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Risk Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getRiskLevel()
 * @model
 * @generated
 */
public enum RiskLevel implements Enumerator {
	/**
	 * The '<em><b>NEGLIGIBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGLIGIBLE_VALUE
	 * @generated
	 * @ordered
	 */
	NEGLIGIBLE(0, "NEGLIGIBLE", "NEGLIGIBLE"),

	/**
	 * The '<em><b>MARGINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARGINAL_VALUE
	 * @generated
	 * @ordered
	 */
	MARGINAL(1, "MARGINAL", "MARGINAL"),

	/**
	 * The '<em><b>CRITICAL RISK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_RISK_VALUE
	 * @generated
	 * @ordered
	 */
	CRITICAL_RISK(2, "CRITICAL_RISK", "CRITICAL_RISK"),

	/**
	 * The '<em><b>CATASTROPHIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CATASTROPHIC_VALUE
	 * @generated
	 * @ordered
	 */
	CATASTROPHIC(3, "CATASTROPHIC", "CATASTROPHIC");

	/**
	 * The '<em><b>NEGLIGIBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEGLIGIBLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEGLIGIBLE_VALUE = 0;

	/**
	 * The '<em><b>MARGINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARGINAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MARGINAL_VALUE = 1;

	/**
	 * The '<em><b>CRITICAL RISK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_RISK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CRITICAL_RISK_VALUE = 2;

	/**
	 * The '<em><b>CATASTROPHIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CATASTROPHIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CATASTROPHIC_VALUE = 3;

	/**
	 * An array of all the '<em><b>Risk Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RiskLevel[] VALUES_ARRAY =
		new RiskLevel[] {
			NEGLIGIBLE,
			MARGINAL,
			CRITICAL_RISK,
			CATASTROPHIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Risk Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RiskLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Risk Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RiskLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RiskLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Risk Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RiskLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RiskLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Risk Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RiskLevel get(int value) {
		switch (value) {
			case NEGLIGIBLE_VALUE: return NEGLIGIBLE;
			case MARGINAL_VALUE: return MARGINAL;
			case CRITICAL_RISK_VALUE: return CRITICAL_RISK;
			case CATASTROPHIC_VALUE: return CATASTROPHIC;
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
	private RiskLevel(int value, String name, String literal) {
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
	
} //RiskLevel
