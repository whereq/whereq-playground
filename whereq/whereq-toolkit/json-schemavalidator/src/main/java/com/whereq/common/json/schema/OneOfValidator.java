
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OneOfValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<JsonSchema> schemas = new ArrayList<JsonSchema>();

	public OneOfValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.ONE_OF);
		int size = schemaNode.size();
		for (int i = 0; i < size; i++) {
			schemas.add(new JsonSchema(mapper, getValidatorType().getValue(), schemaNode.get(i), parentSchema));
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		int numberOfValidSchema = 0;

		for (JsonSchema schema : schemas) {
			List<ValidationMessage> errors = schema.validate(node, rootNode, at);
			if (errors == null || errors.isEmpty()) {
				numberOfValidSchema++;
			}
			if (numberOfValidSchema > 1) {
				break;
			}
		}

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		if (numberOfValidSchema != 1) {
			errors.add(buildValidationMessage(at, ""));
		}
		return errors;
	}

}
