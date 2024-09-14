
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UniqueItemsValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(UniqueItemsValidator.class);

	private boolean unique = false;

	public UniqueItemsValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.UNIQUE_ITEMS);
		if (schemaNode.isBoolean()) {
			unique = schemaNode.booleanValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (unique) {
			Set<JsonNode> set = new HashSet<JsonNode>();
			for (JsonNode n : node) {
				set.add(n);
			}

			if (set.size() < node.size()) {
				errors.add(buildValidationMessage(at));
			}
		}

		return errors;
	}

}
