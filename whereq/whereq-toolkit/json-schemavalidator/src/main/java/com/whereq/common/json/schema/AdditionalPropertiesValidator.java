
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdditionalPropertiesValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(AdditionalPropertiesValidator.class);

	private boolean allowAdditionalProperties;
	private JsonSchema additionalPropertiesSchema;
	private List<String> allowedProperties;
	private List<Pattern> patternProperties = new ArrayList<Pattern>();

	public AdditionalPropertiesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema,
			ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.ADDITIONAL_PROPERTIES);
		allowAdditionalProperties = false;
		if (schemaNode.isBoolean()) {
			allowAdditionalProperties = schemaNode.booleanValue();
		}
		if (schemaNode.isObject()) {
			allowAdditionalProperties = true;
			additionalPropertiesSchema = new JsonSchema(mapper, getValidatorType().getValue(), schemaNode, parentSchema);
		}

		allowedProperties = new ArrayList<String>();
		JsonNode propertiesNode = parentSchema.getSchemaNode().get(PropertiesValidator.PROPERTY);
		if (propertiesNode != null) {
			for (Iterator<String> it = propertiesNode.fieldNames(); it.hasNext();) {
				allowedProperties.add(it.next());
			}
		}

		JsonNode patternPropertiesNode = parentSchema.getSchemaNode().get(PatternPropertiesValidator.PROPERTY);
		if (patternPropertiesNode != null) {
			for (Iterator<String> it = patternPropertiesNode.fieldNames(); it.hasNext();) {
				patternProperties.add(Pattern.compile(it.next()));
			}
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		if (!node.isObject()) {
			// ignore no object
			return errors;
		}

		for (Iterator<String> it = node.fieldNames(); it.hasNext();) {
			String pname = it.next();
			// skip the context items
			if (pname.startsWith("#")) {
				continue;
			}
			boolean handledByPatternProperties = false;
			for (Pattern pattern : patternProperties) {
				Matcher m = pattern.matcher(pname);
				if (m.find()) {
					handledByPatternProperties = true;
					break;
				}
			}

			if (!allowedProperties.contains(pname) && !handledByPatternProperties) {
				if (!allowAdditionalProperties) {
					errors.add(buildValidationMessage(at, pname));
				} else {
					if (additionalPropertiesSchema != null) {
						errors.addAll(additionalPropertiesSchema.validate(node.get(pname), rootNode, at + "." + pname));
					}
				}
			}
		}
		return errors;
	}

}
