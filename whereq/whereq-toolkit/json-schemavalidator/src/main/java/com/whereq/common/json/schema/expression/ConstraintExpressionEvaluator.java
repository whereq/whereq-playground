package com.whereq.common.json.schema.expression;

import com.fasterxml.jackson.databind.JsonNode;
import org.antlr.v4.runtime.*;

import java.io.ByteArrayInputStream;

public class ConstraintExpressionEvaluator {
	private String expression;

	public ConstraintExpressionEvaluator(String expression) {
		this.expression = expression;
	}

	public boolean evaluate(JsonNode data, String at) {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes());
			ConstraintExprLexer lexer = new ConstraintExprLexer(new ANTLRInputStream(bais));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ConstraintExprParser parser = new ConstraintExprParser(tokens);

			parser.addErrorListener(new BaseErrorListener() {
				@Override
				public void syntaxError(Recognizer<?, ?> recognizer,
						Object offendingSymbol, int line, int charPositionInLine,
						String msg, RecognitionException e) {
					throw new IllegalArgumentException("Invalid expression string due to " + msg, e);
				}
			});

			ConstraintExpressionVisitor visitor = new ConstraintExpressionVisitor(data, at);
			return (Boolean) visitor.visit(parser.expression());
		} catch (Exception e) {
			throw new IllegalArgumentException(expression, e);
		}
	}
}
