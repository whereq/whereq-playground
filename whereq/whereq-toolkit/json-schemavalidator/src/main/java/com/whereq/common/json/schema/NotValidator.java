
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private JsonSchema schema;

	public NotValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.NOT);
		schema = new JsonSchema(mapper, getValidatorType().getValue(), schemaNode, parentSchema);

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> notValidationError = new ArrayList<ValidationMessage>();
		List<ValidationMessage> errors = schema.validate(node, rootNode, at);
		if (errors.isEmpty()) {
			notValidationError.add(buildValidationMessage(at, schema.toString()));
		}
		return notValidationError;
	}

}
