
package com.whereq.common.json.schema;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Standard json validator interface, implemented by various validators and JsonSchema.
 *  
 * @author zhengt
 *
 */
public interface JsonValidator {
	public static final String AT_ROOT = "$";

	/**
	 * Validate the given root JsonNode, starting at the root of the data path.
	 * 
	 * @param node
	 * @return A list of ValidationMessage if there is any sanitizevalidate error, or an empty
	 * list if there is no error.
	 */
	List<ValidationMessage> validate(JsonNode rootNode);

	/**
	 * Validate the given JsonNode, the given node is the child node of the root node at given 
	 * data path.
	 * 
	 * @param node
	 * @return A list of ValidationMessage if there is any sanitizevalidate error, or an empty
	 * list if there is no error.
	 */
	List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at);

}
