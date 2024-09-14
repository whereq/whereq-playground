
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypeValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(TypeValidator.class);

	private JsonType schemaType;
	private UnionTypeValidator unionTypeValidator;

	public TypeValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.TYPE);
		schemaType = TypeFactory.getSchemaNodeType(schemaNode);

		if (schemaType == JsonType.UNION) {
			unionTypeValidator = new UnionTypeValidator(schemaPath, schemaNode, parentSchema, mapper);
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (schemaType == JsonType.UNION) {
			errors.addAll(unionTypeValidator.validate(node, rootNode, at));
			return errors;
		}

		JsonType nodeType = TypeFactory.getValueNodeType(node);
		if (nodeType != schemaType) {
			if (schemaType == JsonType.ANY) {
				return errors;
			}

			if (schemaType == JsonType.NUMBER && nodeType == JsonType.INTEGER) {
				return errors;
			}

			errors.add(buildValidationMessage(at, nodeType.toString(), schemaType.toString()));
		}

		return errors;
	}

}
