/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Block Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getBlockType()
 * @model
 * @generated
 */
public enum BlockType implements Enumerator {
	/**
	 * The '<em><b>SENSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENSOR_VALUE
	 * @generated
	 * @ordered
	 */
	SENSOR(0, "SENSOR", "SENSOR"),

	/**
	 * The '<em><b>ACTUATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTUATOR_VALUE
	 * @generated
	 * @ordered
	 */
	ACTUATOR(1, "ACTUATOR", "ACTUATOR"),

	/**
	 * The '<em><b>CONTROLLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROLLER_VALUE
	 * @generated
	 * @ordered
	 */
	CONTROLLER(2, "CONTROLLER", "CONTROLLER"),

	/**
	 * The '<em><b>COMMUNICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMUNICATION_VALUE
	 * @generated
	 * @ordered
	 */
	COMMUNICATION(3, "COMMUNICATION", "COMMUNICATION"),

	/**
	 * The '<em><b>POWER SUPPLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWER_SUPPLY_VALUE
	 * @generated
	 * @ordered
	 */
	POWER_SUPPLY(4, "POWER_SUPPLY", "POWER_SUPPLY"),

	/**
	 * The '<em><b>PROCESSING UNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESSING_UNIT_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESSING_UNIT(5, "PROCESSING_UNIT", "PROCESSING_UNIT"),

	/**
	 * The '<em><b>STORAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE(6, "STORAGE", "STORAGE"),

	/**
	 * The '<em><b>USER INTERFACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_INTERFACE_VALUE
	 * @generated
	 * @ordered
	 */
	USER_INTERFACE(7, "USER_INTERFACE", "USER_INTERFACE");

	/**
	 * The '<em><b>SENSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SENSOR_VALUE = 0;

	/**
	 * The '<em><b>ACTUATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTUATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTUATOR_VALUE = 1;

	/**
	 * The '<em><b>CONTROLLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROLLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROLLER_VALUE = 2;

	/**
	 * The '<em><b>COMMUNICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMUNICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMMUNICATION_VALUE = 3;

	/**
	 * The '<em><b>POWER SUPPLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWER_SUPPLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POWER_SUPPLY_VALUE = 4;

	/**
	 * The '<em><b>PROCESSING UNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESSING_UNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROCESSING_UNIT_VALUE = 5;

	/**
	 * The '<em><b>STORAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_VALUE = 6;

	/**
	 * The '<em><b>USER INTERFACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_INTERFACE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USER_INTERFACE_VALUE = 7;

	/**
	 * An array of all the '<em><b>Block Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BlockType[] VALUES_ARRAY =
		new BlockType[] {
			SENSOR,
			ACTUATOR,
			CONTROLLER,
			COMMUNICATION,
			POWER_SUPPLY,
			PROCESSING_UNIT,
			STORAGE,
			USER_INTERFACE,
		};

	/**
	 * A public read-only list of all the '<em><b>Block Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BlockType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Block Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BlockType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BlockType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Block Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BlockType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BlockType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Block Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BlockType get(int value) {
		switch (value) {
			case SENSOR_VALUE: return SENSOR;
			case ACTUATOR_VALUE: return ACTUATOR;
			case CONTROLLER_VALUE: return CONTROLLER;
			case COMMUNICATION_VALUE: return COMMUNICATION;
			case POWER_SUPPLY_VALUE: return POWER_SUPPLY;
			case PROCESSING_UNIT_VALUE: return PROCESSING_UNIT;
			case STORAGE_VALUE: return STORAGE;
			case USER_INTERFACE_VALUE: return USER_INTERFACE;
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
	private BlockType(int value, String name, String literal) {
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
	
} //BlockType
