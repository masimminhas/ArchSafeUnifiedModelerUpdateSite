/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Connection Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getConnectionType()
 * @model
 * @generated
 */
public enum ConnectionType implements Enumerator {
	/**
	 * The '<em><b>DATA FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_FLOW(0, "DATA_FLOW", "DATA_FLOW"),

	/**
	 * The '<em><b>CONTROL FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	CONTROL_FLOW(1, "CONTROL_FLOW", "CONTROL_FLOW"),

	/**
	 * The '<em><b>POWER FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWER_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	POWER_FLOW(2, "POWER_FLOW", "POWER_FLOW"),

	/**
	 * The '<em><b>SIGNAL FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNAL_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNAL_FLOW(3, "SIGNAL_FLOW", "SIGNAL_FLOW"),

	/**
	 * The '<em><b>MECHANICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICAL_VALUE
	 * @generated
	 * @ordered
	 */
	MECHANICAL(4, "MECHANICAL", "MECHANICAL");

	/**
	 * The '<em><b>DATA FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_FLOW_VALUE = 0;

	/**
	 * The '<em><b>CONTROL FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL_FLOW_VALUE = 1;

	/**
	 * The '<em><b>POWER FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWER_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POWER_FLOW_VALUE = 2;

	/**
	 * The '<em><b>SIGNAL FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNAL_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIGNAL_FLOW_VALUE = 3;

	/**
	 * The '<em><b>MECHANICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MECHANICAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MECHANICAL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Connection Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConnectionType[] VALUES_ARRAY =
		new ConnectionType[] {
			DATA_FLOW,
			CONTROL_FLOW,
			POWER_FLOW,
			SIGNAL_FLOW,
			MECHANICAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Connection Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConnectionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionType get(int value) {
		switch (value) {
			case DATA_FLOW_VALUE: return DATA_FLOW;
			case CONTROL_FLOW_VALUE: return CONTROL_FLOW;
			case POWER_FLOW_VALUE: return POWER_FLOW;
			case SIGNAL_FLOW_VALUE: return SIGNAL_FLOW;
			case MECHANICAL_VALUE: return MECHANICAL;
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
	private ConnectionType(int value, String name, String literal) {
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
	
} //ConnectionType
