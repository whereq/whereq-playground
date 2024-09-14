// Generated from com\whereq\common\json\schema\expression\javascript\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression.javascript;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConstraintExprParser}.
 */
public interface ConstraintExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull ConstraintExprParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull ConstraintExprParser.AddContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#datapath}.
	 * @param ctx the parse tree
	 */
	void enterDatapath(@NotNull ConstraintExprParser.DatapathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#datapath}.
	 * @param ctx the parse tree
	 */
	void exitDatapath(@NotNull ConstraintExprParser.DatapathContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull ConstraintExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull ConstraintExprParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull ConstraintExprParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull ConstraintExprParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(@NotNull ConstraintExprParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(@NotNull ConstraintExprParser.MultContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#constraint_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_expression(@NotNull ConstraintExprParser.Constraint_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#constraint_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_expression(@NotNull ConstraintExprParser.Constraint_expressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#datapath_element}.
	 * @param ctx the parse tree
	 */
	void enterDatapath_element(@NotNull ConstraintExprParser.Datapath_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#datapath_element}.
	 * @param ctx the parse tree
	 */
	void exitDatapath_element(@NotNull ConstraintExprParser.Datapath_elementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull ConstraintExprParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull ConstraintExprParser.UnaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(@NotNull ConstraintExprParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(@NotNull ConstraintExprParser.CondContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(@NotNull ConstraintExprParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(@NotNull ConstraintExprParser.RelationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(@NotNull ConstraintExprParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(@NotNull ConstraintExprParser.EqualContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#optionpath}.
	 * @param ctx the parse tree
	 */
	void enterOptionpath(@NotNull ConstraintExprParser.OptionpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#optionpath}.
	 * @param ctx the parse tree
	 */
	void exitOptionpath(@NotNull ConstraintExprParser.OptionpathContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull ConstraintExprParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull ConstraintExprParser.ArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull ConstraintExprParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull ConstraintExprParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull ConstraintExprParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull ConstraintExprParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull ConstraintExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull ConstraintExprParser.TermContext ctx);

	/**
	 * Enter a parse tree produced by {@link ConstraintExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull ConstraintExprParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull ConstraintExprParser.ArgumentsContext ctx);
}
