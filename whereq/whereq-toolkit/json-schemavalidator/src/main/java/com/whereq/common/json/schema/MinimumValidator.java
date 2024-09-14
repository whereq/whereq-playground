
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MinimumValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MinimumValidator.class);
	private static final String PROPERTY_EXCLUSIVE_MINIMUM = "exclusiveMinimum";

	private double minimum;
	private boolean excluded = false;

	public MinimumValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MINIMUM);
		if (schemaNode.isNumber()) {
			minimum = schemaNode.doubleValue();
		} else {
			throw new JsonSchemaException("minimum value is not a number");
		}

		JsonNode exclusiveMinimumNode = getParentSchema().getSchemaNode().get(PROPERTY_EXCLUSIVE_MINIMUM);
		if (exclusiveMinimumNode != null && exclusiveMinimumNode.isBoolean()) {
			excluded = exclusiveMinimumNode.booleanValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (!node.isNumber()) {
			// minimum only applies to numbers
			return errors;
		}

		double value = node.doubleValue();
		if (lessThan(value, minimum) || (excluded && equals(value, minimum))) {
			errors.add(buildValidationMessage(at, "" + minimum));
		}
		return errors;
	}

}
