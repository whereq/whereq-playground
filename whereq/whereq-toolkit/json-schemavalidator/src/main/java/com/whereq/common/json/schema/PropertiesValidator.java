
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertiesValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesValidator.class);
	public static final String PROPERTY = "properties";

	private Map<String, JsonSchema> schemas;

	public PropertiesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.PROPERTIES);
		schemas = new HashMap<String, JsonSchema>();
		for (Iterator<String> it = schemaNode.fieldNames(); it.hasNext();) {
			String pname = it.next();
			schemas.put(pname, new JsonSchema(mapper, schemaPath + "/" + pname, schemaNode.get(pname), parentSchema));
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (String key : schemas.keySet()) {
			JsonSchema propertySchema = schemas.get(key);
			JsonNode propertyNode = node.get(key);

			if (propertyNode != null) {
				errors.addAll(propertySchema.validate(propertyNode, rootNode, at + "." + key));
			}
		}

		return errors;
	}

}
