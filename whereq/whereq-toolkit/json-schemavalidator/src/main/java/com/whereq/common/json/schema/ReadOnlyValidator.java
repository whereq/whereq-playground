
package com.whereq.common.json.schema;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This validator validates certain fields cannot be changed, to do that, it is
 * assumed the original json data is passed in as a json node in the context map
 * with key "original".
 * 
 * @author zhengt
 *
 */
public class ReadOnlyValidator extends BaseJsonValidator implements JsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(RequiredValidator.class);

	private List<String> fieldNames = new ArrayList<String>();

	public ReadOnlyValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ObjectMapper mapper) {
		super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.READ_ONLY);
		if (schemaNode.isArray()) {
			int size = schemaNode.size();
			for (int i = 0; i < size; i++) {
				fieldNames.add(schemaNode.get(i).asText());
			}
		}

		parseErrorCode(getValidatorType().getErrorCodeKey());
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
		debug(LOG, node, rootNode, at);

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		for (String fieldName : fieldNames) {
			JsonNode propertyNode = node.get(fieldName);
			String datapath = "";
			if (at.equals("$")) {
				datapath = datapath + "#original." + fieldName;
			} else {
				datapath = datapath + "#original." + at.substring(2) + "." + fieldName;
			}
			JsonNode originalNode = getNode(datapath, rootNode);

			boolean theSame = propertyNode != null && originalNode != null && propertyNode.equals(originalNode);
			if (!theSame) {
				errors.add(buildValidationMessage(at));
			}
		}

		return errors;
	}

	private JsonNode getNode(String datapath, JsonNode data) {
		String path = datapath;
		if (path.startsWith("$.")) {
			path = path.substring(2);
		}

		String[] parts = path.split("\\.");
		JsonNode result = null;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].contains("[")) {
				int idx1 = parts[i].indexOf("[");
				int idx2 = parts[i].indexOf("]");
				String key = parts[i].substring(0, idx1).trim();
				int idx = Integer.parseInt(parts[i].substring(idx1 + 1, idx2).trim());
				result = data.get(key).get(idx);
			} else {
				result = data.get(parts[i]);
			}
			if (result == null) {
				break;
			}
			data = result;
		}
		return result;
	}

}
