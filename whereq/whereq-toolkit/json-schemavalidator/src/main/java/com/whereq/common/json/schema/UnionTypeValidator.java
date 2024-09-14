
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnionTypeValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(UnionTypeValidator.class);

	private List<JsonValidator> schemas;
	private String error;

	public UnionTypeValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.UNION_TYPE);
		schemas = new ArrayList<JsonValidator>();
		String sep = "";
		error = "[";

		if (!schemaNode.isArray())
			throw new JsonSchemaException("Expected array for type property on Union Type Definition.");

		int i = 0;
		for (JsonNode n : schemaNode) {
			JsonType t = TypeFactory.getSchemaNodeType(n);
			error += sep + t;
			sep = ", ";

			if (n.isObject())
				schemas.add(new JsonSchema(mapper, ValidatorTypeCode.TYPE.getValue(), n, parentSchema));
			else
				schemas.add(new TypeValidator(schemaPath + "/" + i, n, parentSchema, mapper));

			i++;
		}

		error += "]";
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		JsonType nodeType = TypeFactory.getValueNodeType(node);

		List<ValidationMessage> _return = new ArrayList<ValidationMessage>();
		boolean valid = false;

		for (JsonValidator schema : schemas) {
			List<ValidationMessage> errors = schema.validate(node, rootNode, at);
			if (errors == null || errors.size() == 0) {
				valid = true;
				break;
			}
		}

		if (!valid) {
			_return.add(buildValidationMessage(at, nodeType.toString(), error));
		}

		return _return;
	}

}
