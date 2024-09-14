
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MinLengthValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MinLengthValidator.class);

	private int minLength;

	public MinLengthValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MIN_LENGTH);
		minLength = Integer.MIN_VALUE;
		if (schemaNode != null && schemaNode.isIntegralNumber()) {
			minLength = schemaNode.intValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		JsonType nodeType = TypeFactory.getValueNodeType(node);
		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		if (nodeType != JsonType.STRING) {
			// ignore no-string typs
			return errors;
		}

		if (node.textValue().length() < minLength) {
			errors.add(buildValidationMessage(at, "" + minLength));
		}

		return errors;
	}

}
