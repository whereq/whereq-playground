
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaxLengthValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MaxLengthValidator.class);

	private int maxLength;

	public MaxLengthValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MAX_LENGTH);
		maxLength = Integer.MAX_VALUE;
		if (schemaNode != null && schemaNode.isIntegralNumber()) {
			maxLength = schemaNode.intValue();
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

		if (node.textValue().length() > maxLength) {
			errors.add(buildValidationMessage(at, "" + maxLength));
		}

		return errors;
	}

}
