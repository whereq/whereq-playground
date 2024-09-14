
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnumValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(EnumValidator.class);

	private List<JsonNode> nodes;
	private String error;

	public EnumValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.ENUM);
		nodes = new ArrayList<JsonNode>();
		error = "[none]";

		if (schemaNode != null && schemaNode.isArray()) {
			error = "[";
			int i = 0;
			for (JsonNode n : schemaNode) {
				nodes.add(n);

				String v = n.asText();
				error = error + (i == 0 ? "" : ", ") + v;
				i++;

			}
			error = error + "]";
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (!nodes.contains(node)) {
			errors.add(buildValidationMessage(at, error));
		}

		return errors;
	}

}
