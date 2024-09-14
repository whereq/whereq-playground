// Generated from com\whereq\common\json\schema\expression\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConstraintExprParser}.
 */
public interface ConstraintExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code multPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMultPassthrough(@NotNull ConstraintExprParser.MultPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMultPassthrough(@NotNull ConstraintExprParser.MultPassthroughContext ctx);

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
	 * Enter a parse tree produced by the {@code numberTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNumberTerm(@NotNull ConstraintExprParser.NumberTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNumberTerm(@NotNull ConstraintExprParser.NumberTermContext ctx);

	/**
	 * Enter a parse tree produced by the {@code andPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAndPassthrough(@NotNull ConstraintExprParser.AndPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAndPassthrough(@NotNull ConstraintExprParser.AndPassthroughContext ctx);

	/**
	 * Enter a parse tree produced by the {@code functionTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTerm(@NotNull ConstraintExprParser.FunctionTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTerm(@NotNull ConstraintExprParser.FunctionTermContext ctx);

	/**
	 * Enter a parse tree produced by the {@code datapathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDatapathTerm(@NotNull ConstraintExprParser.DatapathTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code datapathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDatapathTerm(@NotNull ConstraintExprParser.DatapathTermContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenTerm(@NotNull ConstraintExprParser.ParenTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenTerm(@NotNull ConstraintExprParser.ParenTermContext ctx);

	/**
	 * Enter a parse tree produced by the {@code orPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOrPassthrough(@NotNull ConstraintExprParser.OrPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOrPassthrough(@NotNull ConstraintExprParser.OrPassthroughContext ctx);

	/**
	 * Enter a parse tree produced by the {@code equalPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqualPassthrough(@NotNull ConstraintExprParser.EqualPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqualPassthrough(@NotNull ConstraintExprParser.EqualPassthroughContext ctx);

	/**
	 * Enter a parse tree produced by the {@code booleanTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTerm(@NotNull ConstraintExprParser.BooleanTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTerm(@NotNull ConstraintExprParser.BooleanTermContext ctx);

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
	 * Enter a parse tree produced by the {@code unaryRule}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryRule(@NotNull ConstraintExprParser.UnaryRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryRule}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryRule(@NotNull ConstraintExprParser.UnaryRuleContext ctx);

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
	 * Enter a parse tree produced by the {@code tenaryRule}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterTenaryRule(@NotNull ConstraintExprParser.TenaryRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tenaryRule}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitTenaryRule(@NotNull ConstraintExprParser.TenaryRuleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code comparisonRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterComparisonRule(@NotNull ConstraintExprParser.ComparisonRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitComparisonRule(@NotNull ConstraintExprParser.ComparisonRuleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code inRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterInRule(@NotNull ConstraintExprParser.InRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inRule}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitInRule(@NotNull ConstraintExprParser.InRuleContext ctx);

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
	 * Enter a parse tree produced by the {@code addPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddPassthrough(@NotNull ConstraintExprParser.AddPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddPassthrough(@NotNull ConstraintExprParser.AddPassthroughContext ctx);

	/**
	 * Enter a parse tree produced by the {@code stringTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterStringTerm(@NotNull ConstraintExprParser.StringTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitStringTerm(@NotNull ConstraintExprParser.StringTermContext ctx);

	/**
	 * Enter a parse tree produced by the {@code multRule}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMultRule(@NotNull ConstraintExprParser.MultRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multRule}
	 * labeled alternative in {@link ConstraintExprParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMultRule(@NotNull ConstraintExprParser.MultRuleContext ctx);

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
	 * Enter a parse tree produced by the {@code relationPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelationPassthrough(@NotNull ConstraintExprParser.RelationPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelationPassthrough(@NotNull ConstraintExprParser.RelationPassthroughContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unaryPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPassthrough(@NotNull ConstraintExprParser.UnaryPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPassthrough(@NotNull ConstraintExprParser.UnaryPassthroughContext ctx);

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
	 * Enter a parse tree produced by the {@code orRule}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOrRule(@NotNull ConstraintExprParser.OrRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orRule}
	 * labeled alternative in {@link ConstraintExprParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOrRule(@NotNull ConstraintExprParser.OrRuleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code andRule}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAndRule(@NotNull ConstraintExprParser.AndRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andRule}
	 * labeled alternative in {@link ConstraintExprParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAndRule(@NotNull ConstraintExprParser.AndRuleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code equalRule}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqualRule(@NotNull ConstraintExprParser.EqualRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalRule}
	 * labeled alternative in {@link ConstraintExprParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqualRule(@NotNull ConstraintExprParser.EqualRuleContext ctx);

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
	 * Enter a parse tree produced by the {@code addRule}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAddRule(@NotNull ConstraintExprParser.AddRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addRule}
	 * labeled alternative in {@link ConstraintExprParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAddRule(@NotNull ConstraintExprParser.AddRuleContext ctx);

	/**
	 * Enter a parse tree produced by the {@code optionpathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterOptionpathTerm(@NotNull ConstraintExprParser.OptionpathTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optionpathTerm}
	 * labeled alternative in {@link ConstraintExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitOptionpathTerm(@NotNull ConstraintExprParser.OptionpathTermContext ctx);

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

	/**
	 * Enter a parse tree produced by the {@code condPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondPassthrough(@NotNull ConstraintExprParser.CondPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condPassthrough}
	 * labeled alternative in {@link ConstraintExprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondPassthrough(@NotNull ConstraintExprParser.CondPassthroughContext ctx);
}
