
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnyOfValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<JsonSchema> schemas = new ArrayList<JsonSchema>();

	public AnyOfValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.ANY_OF);
		int size = schemaNode.size();
		for (int i = 0; i < size; i++) {
			schemas.add(new JsonSchema(mapper, getValidatorType().getValue(), schemaNode.get(i), parentSchema));
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		int size = schemas.size();
		List<ValidationMessage> allErrors = new ArrayList<ValidationMessage>();

		for (int i = 0; i < size; i++) {
			List<ValidationMessage> errors = schemas.get(i).validate(node, rootNode, at);
			if (errors.isEmpty()) {
				return errors;
			}
			allErrors.addAll(errors);
		}

		return allErrors;
	}

}
