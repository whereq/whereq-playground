
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MultipleOfValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(MultipleOfValidator.class);

	private double divisor = 0;

	public MultipleOfValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.MULTIPLE_OF);
		if (schemaNode.isNumber()) {
			divisor = schemaNode.doubleValue();
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (node.isNumber()) {
			double nodeValue = node.doubleValue();
			if (divisor != 0) {
				long multiples = Math.round(nodeValue / divisor);
				if (Math.abs(multiples * divisor - nodeValue) > 1e-12) {
					errors.add(buildValidationMessage(at, "" + divisor));
				}
			}
		}

		return errors;
	}

}
