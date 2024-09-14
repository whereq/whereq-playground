
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

public class DependenciesValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(DependenciesValidator.class);

	private Map<String, JsonSchema> schemaDeps = new HashMap<String, JsonSchema>();
	private final Map<String, List<String>> propertyDeps = new HashMap<String, List<String>>();

	public DependenciesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {

		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.DEPENDENCIES);

		for (Iterator<String> it = schemaNode.fieldNames(); it.hasNext();) {
			String pname = it.next();
			JsonNode pvalue = schemaNode.get(pname);
			if (pvalue.isArray()) {
				List<String> depsProps = propertyDeps.get(pname);
				if (depsProps == null) {
					depsProps = new ArrayList<String>();
					propertyDeps.put(pname, depsProps);
				}
				for (int i = 0; i < pvalue.size(); i++) {
					depsProps.add(pvalue.get(i).asText());
				}
			} else if (pvalue.isObject()) {
				schemaDeps.put(pname, new JsonSchema(mapper, pname, pvalue, parentSchema));
			}
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (Iterator<String> it = node.fieldNames(); it.hasNext();) {
			String pname = it.next();
			List<String> deps = propertyDeps.get(pname);
			if (deps != null && !deps.isEmpty()) {
				for (String field : deps) {
					if (node.get(field) == null) {
						errors.add(buildValidationMessage(at, propertyDeps.toString()));
					}
				}
			}
			JsonSchema schema = schemaDeps.get(pname);
			if (schema != null) {
				errors.addAll(schema.validate(node, rootNode, at));
			}
		}

		return errors;
	}

}
