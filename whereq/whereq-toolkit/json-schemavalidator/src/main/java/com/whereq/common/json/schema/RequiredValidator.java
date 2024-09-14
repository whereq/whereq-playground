
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequiredValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<String> fieldNames = new ArrayList<String>();

	public RequiredValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.REQUIRED);
		if (schemaNode.isArray()) {
			int size = schemaNode.size();
			for (int i = 0; i < size; i++) {
				fieldNames.add(schemaNode.get(i).asText());
			}
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (String fieldName : fieldNames) {
			JsonNode propertyNode = node.get(fieldName);

			if (propertyNode == null) {
				errors.add(buildValidationMessage(at, fieldName));
			}
		}

		return errors;
	}

}
