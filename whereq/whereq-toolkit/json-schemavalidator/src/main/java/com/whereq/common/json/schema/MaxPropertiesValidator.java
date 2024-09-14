
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaxPropertiesValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MaxPropertiesValidator.class);

	private int max;

	public MaxPropertiesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
			ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MAX_PROPERTIES);
		if (schemaNode.isIntegralNumber()) {
			max = schemaNode.intValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (node.isObject()) {
			if (node.size() > max) {
				errors.add(buildValidationMessage(at, "" + max));
			}
		}

		return errors;
	}

}
