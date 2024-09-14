
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PatternPropertiesValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(PatternPropertiesValidator.class);
	public static final String PROPERTY = "patternProperties";

	private Map<Pattern, JsonSchema> schemas = new HashMap<Pattern, JsonSchema>();

	public PatternPropertiesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
			ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.PATTERN_PROPERTIES);
		if (!schemaNode.isObject()) {
			throw new JsonSchemaException("patternProperties must be an object node");
		}
		Iterator<String> names = schemaNode.fieldNames();
		while (names.hasNext()) {
			String name = names.next();
			schemas.put(Pattern.compile(name), new JsonSchema(mapper, name, schemaNode.get(name), parentSchema));
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (!node.isObject()) {
			return errors;
		}

		Iterator<String> names = node.fieldNames();
		while (names.hasNext()) {
			String name = names.next();
			JsonNode n = node.get(name);
			for (Pattern pattern : schemas.keySet()) {
				Matcher m = pattern.matcher(name);
				if (m.find()) {
					errors.addAll(schemas.get(pattern).validate(n, rootNode, at + "." + name));
				}
			}
		}
		return errors;
	}

}
