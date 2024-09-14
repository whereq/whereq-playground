package com.whereq.common.json.schema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.fasterxml.jackson.databind.JsonNode;
import com.whereq.common.json.schema.JsonSchema;
import com.whereq.common.json.schema.JsonSchemaException;
import com.whereq.common.json.schema.ValidationMessage;

public class JsonSchemaExceptionTest extends BaseJsonSchemaTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInvalidJsonSchemaForMinimumValidator()
			throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchema schema = getJsonSchemaFromStringContent("{\"minimum\":null}");

		JsonNode node = getJsonNodeFromStringContent("1");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

	@Test
	public void testInvalidJsonSchemaForMaximumValidator()
			throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchema schema = getJsonSchemaFromStringContent("{\"maximum\":null}");

		JsonNode node = getJsonNodeFromStringContent("1");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

}
