package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaximumValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MaximumValidator.class);
	private static final String PROPERTY_EXCLUSIVE_MAXIMUM = "exclusiveMaximum";

	private double maximum;
	private boolean excludeEqual = false;

	public MaximumValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MAXIMUM);
		if (schemaNode.isNumber()) {
			maximum = schemaNode.doubleValue();
		} else {
			throw new JsonSchemaException("maximum value is not a number");
		}

		JsonNode exclusiveMaximumNode = getParentSchema().getSchemaNode().get(PROPERTY_EXCLUSIVE_MAXIMUM);
		if (exclusiveMaximumNode != null && exclusiveMaximumNode.isBoolean()) {
			excludeEqual = exclusiveMaximumNode.booleanValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (!node.isNumber()) {
			// maximum only applies to numbers
			return errors;
		}

		double value = node.doubleValue();
		if (greaterThan(value, maximum) || (excludeEqual && equals(value, maximum))) {
			errors.add(buildValidationMessage(at, "" + maximum));
		}
		return errors;
	}

}
