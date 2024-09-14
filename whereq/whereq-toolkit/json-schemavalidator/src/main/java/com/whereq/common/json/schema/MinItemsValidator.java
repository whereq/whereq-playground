
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MinItemsValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MinItemsValidator.class);

	private int min = 0;

	public MinItemsValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MIN_ITEMS);
		if (schemaNode.isIntegralNumber()) {
			min = schemaNode.intValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (node.isArray()) {
			if (node.size() < min) {
				errors.add(buildValidationMessage(at, "" + min));
			}
		}

		return errors;
	}

}
