
package com.whereq.common.json.schema;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public enum ValidatorTypeCode {
	ADDITIONAL_PROPERTIES("additionalProperties", "1001", new MessageFormat(
			"{0}.{1}: is not defined in the schema and the schema does not allow additional properties")), 
	ALL_OF("allOf", "1002", new MessageFormat("")), 
	ANY_OF("anyOf", "1003", new MessageFormat("")), 
	CROSS_EDITS("crossEdits", "", new MessageFormat("")), 
	DEPENDENCIES("dependencies", "1007", new MessageFormat("")), 
	EDITS("edits", "", new MessageFormat("")), 
	ENUM("enum", "1008", new MessageFormat("{0}: does not have a value in the enumeration {1}")), 
	FORMAT("format", "1009", new MessageFormat("{0}: does not match the {1} pattern {2}")), 
	ITEMS("items", "1010", new MessageFormat("{0}[{1}]: no validator found at this index")), 
	MAXIMUM("maximum", "1011", new MessageFormat("{0}: must have a maximum value of {1}")), 
	MAX_ITEMS("maxItems", "1012", new MessageFormat("{0}: there must be a maximum of {1} items in the array")), 
	MAX_LENGTH("maxLength", "1013", new MessageFormat("{0}: may only be {1} characters long")), 
	MAX_PROPERTIES("maxProperties", "1014", new MessageFormat("{0}: may only have a maximum of {1} properties")), 
	MINIMUM("minimum", "1015", new MessageFormat("{0}: must have a minimum value of {1}")), 
	MIN_ITEMS("minItems", "1016", new MessageFormat("{0}: there must be a minimum of {1} items in the array")), 
	MIN_LENGTH("minLength", "1017", new MessageFormat("{0}: must be at least {1} characters long")), 
	MIN_PROPERTIES("minProperties", "1018", new MessageFormat("{0}: should have a minimum of {1} properties")), 
	MULTIPLE_OF("multipleOf", "1019", new MessageFormat("{0}: must be multiple of {1}")), 
	NOT_ALLOWED("notAllowed", "1033", new MessageFormat("{0}.{1}: is not allowed but it is in the data")), 
	NOT("not", "1020", new MessageFormat("{0}: should not be valid to the schema {1}")), 
	ONE_OF("oneOf", "1022", new MessageFormat("{0}: should be valid to one and only one of the schemas {1}")), 
	PATTERN_PROPERTIES("patternProperties", "1024", new MessageFormat("")), 
	PATTERN("pattern", "1023", new MessageFormat("{0}: does not match the regex pattern {1}")), 
	PROPERTIES("properties", "1025", new MessageFormat("")), 
	READ_ONLY("readOnly", "1032", new MessageFormat("{0}: is a readonly field, it cannot be changed")), 
	REF("ref", "1026", new MessageFormat("")), 
	REQUIRED("required", "1028", new MessageFormat("{0}.{1}: is missing but it is required")), 
	TYPE("type", "1029", new MessageFormat("{0}: {1} found, {2} expected")), 
	UNION_TYPE("unionType", "1030", new MessageFormat("{0}: {1} found, but {2} is required")), 
	UNIQUE_ITEMS("uniqueItems", "1031", new MessageFormat("{0}: the items in the array must be unique"));

	private final String value;
	private final String errorCode;
	private final MessageFormat messageFormat;
	private final String errorCodeKey;

	private static Map<String, ValidatorTypeCode> constants = new HashMap<String, ValidatorTypeCode>();

	static {
		for (ValidatorTypeCode c : values()) {
			constants.put(c.value, c);
		}
	}

	private ValidatorTypeCode(String value, String errorCode, MessageFormat messageFormat) {
		this.value = value;
		this.errorCode = errorCode;
		this.messageFormat = messageFormat;
		this.errorCodeKey = value + "ErrorCode";
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static ValidatorTypeCode fromValue(String value) {
		ValidatorTypeCode constant = constants.get(value);
		if (constant == null) {
			throw new IllegalArgumentException(value);
		} else {
			return constant;
		}
	}

	public String getValue() {
		return value;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public MessageFormat getMessageFormat() {
		return messageFormat;
	}

	public String getErrorCodeKey() {
		return errorCodeKey;
	}

}
