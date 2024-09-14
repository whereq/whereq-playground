package com.whereq.common.json.schema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.whereq.common.json.schema.JsonSchema;
import com.whereq.common.json.schema.ValidationMessage;

public class EnumValidatorTest extends BaseJsonSchemaTest {
	@Test
	public void testCustomEnumErrorCode() throws Exception {
		JsonSchema schema = getJsonSchemaFromStringContent("{\"enum\":[1, 2, 3],\"enumErrorCode\":\"1234\"}");

		JsonNode node = getJsonNodeFromStringContent("4");
		List<ValidationMessage> errors = schema.validate(node);
		assertThat(errors.size(), is(1));
		assertThat(errors.get(0).getCode(), is("1234"));
	}

}
