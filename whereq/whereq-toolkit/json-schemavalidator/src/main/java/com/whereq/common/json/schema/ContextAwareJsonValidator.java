
package com.whereq.common.json.schema;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * The TD extension json sanitizevalidate interface, for cross editing, the json data itself only may not be
 * enough, some external data is needed, the external data is passed in as context map, each entry in
 * the context map will be inserted into root node as direct children using "#" + key as the property
 * name, and the entry value as the value. The extended properties can then be used in the conditions 
 * of {@link EditsValidator} and {@link CrossEditsValidator}.
 * 
 * This interface is implemented by {@link JsonSchema} only.
 * 
 * @author zhengt
 *
 */
public interface ContextAwareJsonValidator extends JsonValidator {
 
	/**
	 * Validate the given root JsonNode, starting at the root of the data path with extra context data.
	 * 
	 * @param rootNode
	 * @param context
	 * 
	 * @return A list of ValidationMessage if there is any sanitizevalidate error, or an empty
	 * list if there is no error.
	 */
	List<ValidationMessage> validate(JsonNode rootNode, Map<String, JsonNode> context);

	/**
	 * Validate the given JsonNode with extra context data, the given node is the child node of the root 
	 * node at given data path.
	 * 
	 * @param node
	 * @param rootNode
	 * @param at
	 * @param context
	 * 
	 * @return A list of ValidationMessage if there is any sanitizevalidate error, or an empty
	 * list if there is no error.
	 */
 	List<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at, Map<String, JsonNode> context);

}
