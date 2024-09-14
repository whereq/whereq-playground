
package com.whereq.common.json.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.json.schema.ValidationMessage.Builder;
import com.whereq.common.json.schema.expression.ConstraintExpressionEvaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CrossEditsValidator extends AbstractEditsValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<CrossEdit> edits = new ArrayList<CrossEdit>();

	public CrossEditsValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.CROSS_EDITS);
		for (int i = 0; i < schemaNode.size(); i++) {
			JsonNode node = schemaNode.get(i);
			CrossEdit edit = new CrossEdit();
			edit.primeCondition = getCondition(node.get("primeCondition"));
			edit.crossCondition = getCondition(node.get("crossCondition"));
			edit.errorCode = node.get("errorCode").asText();
			edits.add(edit);
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (CrossEdit edit : edits) {
			ConstraintExpressionEvaluator primeEvaluator = new ConstraintExpressionEvaluator(edit.primeCondition);
			ConstraintExpressionEvaluator crossEvaluator = new ConstraintExpressionEvaluator(edit.crossCondition);

			if (primeEvaluator.evaluate(rootNode, at) && !crossEvaluator.evaluate(rootNode, at)) {
				Builder builder = new Builder();
				builder.code(edit.errorCode).path(at).arguments(edit.primeCondition, edit.crossCondition);
				errors.add(builder.build());
			}
		}

		return errors;
	}

	private static class CrossEdit {
		String primeCondition;
		String crossCondition;
		String errorCode;
	}
}
