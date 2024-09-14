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
import com.whereq.common.json.schema.JsonSchemaFactory;
import com.whereq.common.json.schema.ValidationMessage;

public class PatternPropertiesValidatorTest extends BaseJsonSchemaTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInvalidPatternPropertiesValidator() throws Exception {
		thrown.expect(JsonSchemaException.class);

		JsonSchemaFactory factory = new JsonSchemaFactory();
		JsonSchema schema = factory.getSchema("{\"patternProperties\":5}");

		JsonNode node = getJsonNodeFromStringContent("");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(0));
	}

}
