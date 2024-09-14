// Generated from com\whereq\common\json\schema\expression\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConstraintExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConstraintExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code multPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultPassthrough(@NotNull ConstraintExprParser.MultPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#constraint_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_expression(@NotNull ConstraintExprParser.Constraint_expressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code numberTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberTerm(@NotNull ConstraintExprParser.NumberTermContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndPassthrough(@NotNull ConstraintExprParser.AndPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by the {@code functionTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTerm(@NotNull ConstraintExprParser.FunctionTermContext ctx);

	/**
	 * Visit a parse tree produced by the {@code datapathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapathTerm(@NotNull ConstraintExprParser.DatapathTermContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTerm(@NotNull ConstraintExprParser.ParenTermContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrPassthrough(@NotNull ConstraintExprParser.OrPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by the {@code equalPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualPassthrough(@NotNull ConstraintExprParser.EqualPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by the {@code booleanTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTerm(@NotNull ConstraintExprParser.BooleanTermContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ConstraintExprParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by the {@code unaryRule}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRule(@NotNull ConstraintExprParser.UnaryRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull ConstraintExprParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code tenaryRule}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTenaryRule(@NotNull ConstraintExprParser.TenaryRuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code comparisonRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonRule(@NotNull ConstraintExprParser.ComparisonRuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code inRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInRule(@NotNull ConstraintExprParser.InRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#datapath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapath(@NotNull ConstraintExprParser.DatapathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code addPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddPassthrough(@NotNull ConstraintExprParser.AddPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by the {@code stringTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTerm(@NotNull ConstraintExprParser.StringTermContext ctx);

	/**
	 * Visit a parse tree produced by the {@code multRule}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultRule(@NotNull ConstraintExprParser.MultRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull ConstraintExprParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code relationPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationPassthrough(@NotNull ConstraintExprParser.RelationPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by the {@code unaryPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPassthrough(@NotNull ConstraintExprParser.UnaryPassthroughContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#datapath_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapath_element(@NotNull ConstraintExprParser.Datapath_elementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orRule}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrRule(@NotNull ConstraintExprParser.OrRuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andRule}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndRule(@NotNull ConstraintExprParser.AndRuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code equalRule}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualRule(@NotNull ConstraintExprParser.EqualRuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#optionpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionpath(@NotNull ConstraintExprParser.OptionpathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code addRule}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRule(@NotNull ConstraintExprParser.AddRuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code optionpathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionpathTerm(@NotNull ConstraintExprParser.OptionpathTermContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ConstraintExprParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondPassthrough(@NotNull ConstraintExprParser.CondPassthroughContext ctx);
}
