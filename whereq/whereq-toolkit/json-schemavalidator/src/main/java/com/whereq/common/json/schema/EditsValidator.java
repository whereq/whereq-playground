
package com.whereq.common.json.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.json.schema.expression.ConstraintExpressionEvaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EditsValidator extends AbstractEditsValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<Edit> edits = new ArrayList<Edit>();

	public EditsValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.EDITS);
		for (int i = 0; i < schemaNode.size(); i++) {
			Edit edit = new Edit();
			edit.primeCondition = getCondition(schemaNode.get(i).get("primeCondition"));
			JsonNode crossCondition = schemaNode.get(i).get("crossCondition");
			edit.schema = new JsonSchema(mapper, schemaPath + "/" + i, crossCondition, parentSchema);
			edits.add(edit);
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (Edit edit : edits) {
			ConstraintExpressionEvaluator primeEvaluator = new ConstraintExpressionEvaluator(edit.primeCondition);

			if (primeEvaluator.evaluate(rootNode, at)) {
				errors.addAll(edit.schema.validate(node, rootNode, at));
			}
		}

		return errors;
	}

	private static class Edit {
		String primeCondition;
		JsonSchema schema;
	}
}
