package com.whereq.common.json.schema;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractEditsValidator extends BaseJsonValidator {

	public AbstractEditsValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchama, ValidatorTypeCode type) {
		super(schemaPath, schemaNode, parentSchama, type);
	}

	protected String getCondition(JsonNode node) {
		StringBuilder sb = new StringBuilder();
		if (node.isArray()) {
			for (int i=0; i<node.size(); i++) {
				sb.append(node.get(i).asText());
			}
		} else {
			sb.append(node.asText());
		}
		return sb.toString();
	}
}
