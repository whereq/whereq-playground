
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PatternValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(PatternValidator.class);

	private String pattern;
	private Pattern p;

	public PatternValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.PATTERN);
		pattern = "";
		if (schemaNode != null && schemaNode.isTextual()) {
			pattern = schemaNode.textValue();
			p = Pattern.compile(pattern);
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		JsonType nodeType = TypeFactory.getValueNodeType(node);
		if (nodeType != JsonType.STRING && nodeType != JsonType.NUMBER && nodeType != JsonType.INTEGER) {
			return errors;
		}

		if (p != null) {
			try {
				Matcher m = p.matcher(node.asText());
				if (!m.matches()) {
					errors.add(buildValidationMessage(at, pattern));
				}
			} catch (PatternSyntaxException pse) {
				// String is considered valid if pattern is invalid
				LOG.error("Failed to apply pattern on " + at + ": Invalid RE syntax [" + pattern + "]", pse);
			}
		}

		return errors;
	}

}
