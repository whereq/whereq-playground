package com.whereq.common.json.schema;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.json.schema.expression.ConstraintExpressionEvaluator;

public class ConstraintExpressionEvaluatorTest {
	private static ObjectMapper mapper = new ObjectMapper();

	public static JsonNode convertToJsonNode(String json) throws Exception {
		return mapper.readTree(json);
	}

	@Test
	public void testSimpleExpression() throws Exception {
		String json = "{\"a\":5, \"c\":6, \"b\":4}";
		String expression = "true && ((1 + 1 - 2) > 2 || a + 3 * b <= c+b) && a > b";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertFalse(result);
	}

	@Test
	public void testSimpleExpressionWithArray() throws Exception {
		String json = "{\"a\":5, \"c\":20, \"b\":[4]}";
		String expression = "true && ((1 + 1 - 2) > 2 || a + 3 * b[] <= c+b[0]) && a > b[0]";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$.b[0]");
		Assert.assertTrue(result);
	}

	@Test
	public void testMultiLevelsDatapathExpression() throws Exception {
		String json = "{\"a\":5, \"c\":20, \"b\":[{\"d\":4}]}";
		String expression = "true && ((1 + 1 - 2) > 2 || a + 3 * b[].d <= c+b[].d) && a > b[].d";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$.b[0]");
		Assert.assertTrue(result);
	}

	@Ignore
	@Test
	public void testPerformance() throws Exception {
		String json = "{\"a\":5, \"c\":20, \"b\":[4]}";
		String expression = "true && ((1 + 1 - 2) > 2 || a + 3 * b[ ] <= c+b[]) && a > b[]";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
		long start = System.currentTimeMillis();
		for (int i=0; i<100000; i++) {
			new ConstraintExpressionEvaluator(expression).evaluate(convertToJsonNode(json), "$");
		}
		System.out.println("It takes " + (System.currentTimeMillis() - start) + " milliseconds to validate 100,000 expressions");
	}

	@Test
	public void testInExpression1() throws Exception {
		String json = "{\"a\":5, \"c\":20, \"b\":[4]}";
		String expression = "5 in [5, '7', 3, 6]";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testInExpression2() throws Exception {
		String json = "{\"a\":\"7\"}";
		String expression = "a in [5, '7', 3, 6]";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testMulipleAdd() throws Exception {
		String json = "{}";
		String expression = "1-5+2+3+4+5==10";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testMulipleMultiply() throws Exception {
		String json = "{}";
		String expression = "3*5/5*4/3==4";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testMulipleOr() throws Exception {
		String json = "{}";
		String expression = "false||false||3==3";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testMulipleAnd() throws Exception {
		String json = "{}";
		String expression = "true&&3==3&&4==4";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testOptionPath() throws Exception {
		String json = "{\"#d\":5}";
		String expression = "3*#d<15";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertFalse(result);
	}

	@Test
	public void testOptionPath2() throws Exception {
		String json = "{\"#d\":5}";
		String expression = "3*#d==15";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction1_isEmpty() throws Exception {
        String json = "{\"a\":\"\"}";
        String expression = "#isEmpty(a)";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction2_isEmpty() throws Exception {
        String json = "{\"a\":\"\"}";
        String expression = "#isEmpty(b)";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction3_Substring() throws Exception {
        String json = "{\"b\":\"01234\"}";
        String expression = "#substring(b, 2, 4) == '23'";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction4_Substring() throws Exception {
        String json = "{\"b\":\"01234\"}";
        String expression = "#substring(b, 2) == '234'";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction5_MatchPattern() throws Exception {
        String json = "{\"b\":\"0234\"}";
        String expression = "#matchPattern(b, '^\\d{4}$')";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertTrue(result);
	}

	@Test
	public void testFunction6_MatchPattern() throws Exception {
        String json = "{\"b\":\"02345\"}";
        String expression = "#matchPattern(b, '^\\d{4}$')";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertFalse(result);
	}

	@Test
	public void testInRule() throws Exception {
        String json = "{\"orderTypeCd\":\"MARKET\"}";
        String expression = "orderTypeCd in ['LIMIT', 'STOP_MARKET', 'STOP_LIMIT']";
		ConstraintExpressionEvaluator evaluator = new ConstraintExpressionEvaluator(expression);
		boolean result = evaluator.evaluate(convertToJsonNode(json), "$");
		Assert.assertFalse(result);
	}

}
