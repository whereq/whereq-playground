package com.whereq.common.json.schema;

import java.io.InputStream;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.json.schema.JsonSchema;
import com.whereq.common.json.schema.JsonSchemaFactory;

public abstract class BaseJsonSchemaTest {
	protected JsonNode getJsonNodeFromClasspath(String name) throws Exception {
		InputStream is1 = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(name);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(is1);
		return node;
	}

	protected JsonNode getJsonNodeFromStringContent(String content) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(content);
		return node;
	}

	protected JsonNode getJsonNodeFromUrl(String url) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(new URL(url));
		return node;
	}

	protected JsonSchema getJsonSchemaFromClasspath(String name) throws Exception {
		JsonSchemaFactory factory = new JsonSchemaFactory();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(name);
		JsonSchema schema = factory.getSchema(is);
		return schema;
	}

	protected JsonSchema getJsonSchemaFromStringContent(String schemaContent) throws Exception {
		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema(schemaContent);
		return schema;
	}

	protected JsonSchema getJsonSchemaFromUrl(String url) throws Exception {
		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema(new URL(url));
		return schema;
	}

}
