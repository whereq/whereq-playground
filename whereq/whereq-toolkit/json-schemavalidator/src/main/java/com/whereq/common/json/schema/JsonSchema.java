
package com.whereq.common.json.schema;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * This is the core of json constraint implementation. It parses json constraint
 * file and generates JsonValidators. The class is thread safe, once it is
 * constructed, it can be used to validate multiple json data concurrently.
 * 
 * <p>
 * Usage:
 * </p>
 * 
 * <pre>
 * String jsonSchemaContent = "{"\"type\":\"integer\"}";
 * String jsonData = "5";
 * JsonSchemaFactory factory = new JsonSchemaFactory();
 * JsonSchema schema = factory.getSchema(jsonSchema);
 * 
 * JsonNode node = JsonHelper.unmarshall(jsonData); // JsonHelper is from com.td.wau.webapi project
 * List<ValidationMessage> errors = schema.validate(node);
 * </pre>
 * 
 * @author zhengt
 *
 */
public class JsonSchema extends BaseJsonValidator implements
		ContextAwareJsonValidator {
	private static final Logger LOG = LoggerFactory.getLogger(JsonSchema.class);
	private static final Pattern intPattern = Pattern.compile("^[0-9]+$");

	private ObjectMapper mapper;
	protected Map<String, JsonValidator> validators;
    
	
	JsonSchema(ObjectMapper mapper, JsonNode schemaNode) {
		this(mapper, "#", schemaNode, null);
	}

	JsonSchema(ObjectMapper mapper, String schemaPath, JsonNode schemaNode,
			JsonSchema parent) {
		super(schemaPath, schemaNode, parent, null);
		this.mapper = mapper;

		validators = new LinkedHashMap<String, JsonValidator>();

		read(schemaNode);
	}

	/**
	 * Find the schema node for $ref attribute.
	 * 
	 * @param ref
	 * @return
	 */
	public JsonNode getRefSchemaNode(String ref) {
		JsonSchema schema = findAncestor();
		JsonNode node = schema.getSchemaNode();

		if (ref.startsWith("#/")) {
			// handle local ref
			String[] keys = ref.substring(2).split("/");
			for (String key : keys) {
				try {
					key = URLDecoder.decode(key, "utf-8");
				} catch (UnsupportedEncodingException e) {
				}
				Matcher matcher = intPattern.matcher(key);
				if (matcher.matches()) {
					node = node.get(Integer.parseInt(key));
				} else {
					node = node.get(key);
				}
				if (node == null) {
					break;
				}
			}
		}
		return node;
	}

	public JsonSchema findAncestor() {
		JsonSchema ancestor = this;
		if (this.getParentSchema() != null) {
			ancestor = this.getParentSchema().findAncestor();
		}
		return ancestor;
	}

	@SuppressWarnings("unchecked")
	private void read(JsonNode schemaNode) {
		Iterator<String> pnames = schemaNode.fieldNames();
		while (pnames.hasNext()) {
			String pname = pnames.next();
			JsonNode n = schemaNode.get(pname);

			String shortClassName = pname;
			if (shortClassName.startsWith("$")) {
				// remove "$" from class name for $ref schema
				shortClassName = shortClassName.substring(1);
			}

			try {
				ValidatorTypeCode.fromValue(shortClassName);

				String className = Character.toUpperCase(shortClassName.charAt(0))
					+ shortClassName.substring(1) + "Validator";
				Class<JsonValidator> clazz = (Class<JsonValidator>) Class
						.forName("com.whereq.common.json.schema." + className);
				Constructor<JsonValidator> c = null;
				c = clazz.getConstructor(new Class[] { String.class,
						JsonNode.class, JsonSchema.class, ObjectMapper.class });
				validators.put(getSchemaPath() + "/" + pname, c.newInstance(
						getSchemaPath() + "/" + pname, n, this, mapper));
			} catch (IllegalArgumentException e) {
				// ignore unsupported schema node
			} catch (InvocationTargetException e) {
				if (e.getTargetException() instanceof JsonSchemaException) {
					throw (JsonSchemaException) e.getTargetException();
				} else {
					LOG.info("Could not load validator " + pname);					
				}
			} catch (Exception e) {
				LOG.info("Could not load validator " + pname);
			}
		}
	}

	@Override
	public List<ValidationMessage> validate(JsonNode JsonNode,
			JsonNode rootNode, String at) {
		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		for (JsonValidator v : validators.values()) {
			errors.addAll(v.validate(JsonNode, rootNode, at));
		}
		Collections.reverse(errors);
		Set<ValidationMessage> temp = new LinkedHashSet<ValidationMessage>();
		temp.addAll(errors);
		errors.clear();
		errors.addAll(temp);
		Collections.reverse(errors);
		return errors;
	}

	private void addContextToRootNode(JsonNode rootNode,
			Map<String, JsonNode> context) {
		ObjectNode objNode = (ObjectNode) rootNode;
		try {
			for (String key : context.keySet()) {
				JsonNode contextObj = context.get(key);
				objNode.put("#" + key, contextObj);
			}
		} catch (Exception e) {

		}
	}

	@Override
	public String toString() {
		return "\"" + getSchemaPath() + "\" : " + getSchemaNode().toString();
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node,
			Map<String, JsonNode> context) {
		return validate(node, node, JsonValidator.AT_ROOT, context);
	}

	@Override
	public List<ValidationMessage> validate(JsonNode node, JsonNode rootNode,
			String at, Map<String, JsonNode> context) {
		addContextToRootNode(rootNode, context);
		return validate(node, rootNode, at);
	}

}
