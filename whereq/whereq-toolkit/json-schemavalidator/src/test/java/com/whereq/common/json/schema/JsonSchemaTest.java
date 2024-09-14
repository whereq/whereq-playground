package com.whereq.common.json.schema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.json.schema.JsonSchema;
import com.whereq.common.json.schema.JsonSchemaException;
import com.whereq.common.json.schema.JsonSchemaFactory;
import com.whereq.common.json.schema.ValidationMessage;

public class JsonSchemaTest extends BaseJsonSchemaTest {
	private static Server server = new Server();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setup() throws Exception {
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(14214);
		server.addConnector(connector);

		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed(true);
		resource_handler.setWelcomeFiles(new String[] { "index.html" });

		resource_handler.setResourceBase("./src/test/resources");

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resource_handler,
				new DefaultHandler() });
		server.setHandler(handlers);

		server.start();
	}

	@AfterClass
	public static void teardown() throws Exception {
		if (server != null) {
			server.stop();
		}
	}

	@Test
	public void testJsonSchemaCreationWithStringContent() throws Exception {
		JsonSchema schema = getJsonSchemaFromStringContent("{}");

		JsonNode node = getJsonNodeFromStringContent("1");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testJsonSchemaCreationWithInputStream() throws Exception {
		JsonSchema schema = getJsonSchemaFromClasspath("schema/empty-schema.json");

		JsonNode node = getJsonNodeFromClasspath("tests/empty.json");
		List<ValidationMessage> errors = schema.validate(node);

		assertThat(errors.size(), is(0));
	}

	@Test
	public void testJsonSchemaCreationWithUrl() throws Exception {
		JsonSchema schema = getJsonSchemaFromUrl("http://localhost:14214/schema/empty-schema.json");

		JsonNode node = getJsonNodeFromUrl("http://localhost:14214/tests/empty.json");
		List<ValidationMessage> errors = schema.validate(node);

		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonSchemaCreationWithStringContent()
			throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchema schema = getJsonSchemaFromStringContent("");

		JsonNode node = getJsonNodeFromStringContent("1");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonSchemaCreationWithInputStream() throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchema schema = getJsonSchemaFromClasspath("schema/invalid.empty.schema.json");

		JsonNode node = getJsonNodeFromStringContent("");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonSchemaCreationWithUrl() throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchemaFactory factory = new JsonSchemaFactory();
		URL url = new URL("http://localhost:14214/schema/invalid.empty.schema.json");
		JsonSchema schema = factory.getSchema(url);

		JsonNode node = getJsonNodeFromStringContent("");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonValidationWithStringContent() throws Exception {
		thrown.expect(JsonMappingException.class);

		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema("{}");

		JsonNode node = getJsonNodeFromStringContent("");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonValidationWithInputStream() throws Exception {
		thrown.expect(JsonMappingException.class);

		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema("{}");

		InputStream is1 = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("tests/invalid.empty.json");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(is1);
		List<ValidationMessage> errors = schema.validate(node);

		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonValidationWithUrl() throws Exception {
		thrown.expect(JsonMappingException.class);

		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema("{}");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(new URL(
				"http://localhost:14214/tests/invalid.empty.json"));
		List<ValidationMessage> errors = schema.validate(node);

		assertThat(errors.size(), is(0));
	}
	
	@Test
	public void testInvalidJsonWithoutDependencies() throws Exception {
		JsonSchemaFactory factory = new JsonSchemaFactory();
		URL url = new URL("http://localhost:14214/schema/simple-schema.json");
		JsonSchema schema = factory.getSchema(url);

		JsonNode node = getJsonNodeFromUrl("http://localhost:14214/tests/simpleSchemaTest.json");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(2));
	}

}
