/**
 */
package unified;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Requirement Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see unified.UnifiedPackage#getRequirementStatus()
 * @model
 * @generated
 */
public enum RequirementStatus implements Enumerator {
	/**
	 * The '<em><b>DRAFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAFT_VALUE
	 * @generated
	 * @ordered
	 */
	DRAFT(0, "DRAFT", "DRAFT"),

	/**
	 * The '<em><b>UNDER REVIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDER_REVIEW_VALUE
	 * @generated
	 * @ordered
	 */
	UNDER_REVIEW(1, "UNDER_REVIEW", "UNDER_REVIEW"),

	/**
	 * The '<em><b>APPROVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROVED_VALUE
	 * @generated
	 * @ordered
	 */
	APPROVED(2, "APPROVED", "APPROVED"),

	/**
	 * The '<em><b>IMPLEMENTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLEMENTED_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLEMENTED(3, "IMPLEMENTED", "IMPLEMENTED"),

	/**
	 * The '<em><b>VERIFIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	VERIFIED(4, "VERIFIED", "VERIFIED"),

	/**
	 * The '<em><b>DEPRECATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPRECATED_VALUE
	 * @generated
	 * @ordered
	 */
	DEPRECATED(5, "DEPRECATED", "DEPRECATED");

	/**
	 * The '<em><b>DRAFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRAFT_VALUE = 0;

	/**
	 * The '<em><b>UNDER REVIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDER_REVIEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDER_REVIEW_VALUE = 1;

	/**
	 * The '<em><b>APPROVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPROVED_VALUE = 2;

	/**
	 * The '<em><b>IMPLEMENTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLEMENTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPLEMENTED_VALUE = 3;

	/**
	 * The '<em><b>VERIFIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERIFIED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERIFIED_VALUE = 4;

	/**
	 * The '<em><b>DEPRECATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPRECATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPRECATED_VALUE = 5;

	/**
	 * An array of all the '<em><b>Requirement Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RequirementStatus[] VALUES_ARRAY =
		new RequirementStatus[] {
			DRAFT,
			UNDER_REVIEW,
			APPROVED,
			IMPLEMENTED,
			VERIFIED,
			DEPRECATED,
		};

	/**
	 * A public read-only list of all the '<em><b>Requirement Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RequirementStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Requirement Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RequirementStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RequirementStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RequirementStatus get(int value) {
		switch (value) {
			case DRAFT_VALUE: return DRAFT;
			case UNDER_REVIEW_VALUE: return UNDER_REVIEW;
			case APPROVED_VALUE: return APPROVED;
			case IMPLEMENTED_VALUE: return IMPLEMENTED;
			case VERIFIED_VALUE: return VERIFIED;
			case DEPRECATED_VALUE: return DEPRECATED;
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
	private RequirementStatus(int value, String name, String literal) {
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
	
} //RequirementStatus
