// Generated from com\whereq\common\json\schema\expression\javascript\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression.javascript;
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
	 * Visit a parse tree produced by {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull ConstraintExprParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#datapath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapath(@NotNull ConstraintExprParser.DatapathContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull ConstraintExprParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull ConstraintExprParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull ConstraintExprParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#constraint_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_expression(@NotNull ConstraintExprParser.Constraint_expressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#datapath_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapath_element(@NotNull ConstraintExprParser.Datapath_elementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(@NotNull ConstraintExprParser.UnaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(@NotNull ConstraintExprParser.CondContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(@NotNull ConstraintExprParser.RelationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(@NotNull ConstraintExprParser.EqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#optionpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionpath(@NotNull ConstraintExprParser.OptionpathContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ConstraintExprParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull ConstraintExprParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull ConstraintExprParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull ConstraintExprParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link ConstraintExprParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ConstraintExprParser.ArgumentsContext ctx);
}
