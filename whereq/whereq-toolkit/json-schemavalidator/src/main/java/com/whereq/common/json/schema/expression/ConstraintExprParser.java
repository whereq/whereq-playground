// Generated from com\whereq\common\json\schema\expression\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConstraintExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, IN_OPERATOR=23, 
		BOOLEAN=24, IDENT=25, INTEGER=26, FLOAT=27, STRING=28, WS=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "':'", "'['", "'>='", "'||'", "'<'", "'=='", 
		"'&&'", "']'", "'>'", "'?'", "'!'", "'<='", "'#'", "'('", "')'", "'*'", 
		"'+'", "','", "'-'", "'.'", "'in'", "BOOLEAN", "IDENT", "INTEGER", "FLOAT", 
		"STRING", "WS"
	};
	public static final int
		RULE_constraint_expression = 0, RULE_expression = 1, RULE_cond = 2, RULE_or = 3, 
		RULE_and = 4, RULE_equal = 5, RULE_relation = 6, RULE_add = 7, RULE_mult = 8, 
		RULE_unary = 9, RULE_term = 10, RULE_array = 11, RULE_function = 12, RULE_arguments = 13, 
		RULE_datapath = 14, RULE_datapath_element = 15, RULE_optionpath = 16;
	public static final String[] ruleNames = {
		"constraint_expression", "expression", "cond", "or", "and", "equal", "relation", 
		"add", "mult", "unary", "term", "array", "function", "arguments", "datapath", 
		"datapath_element", "optionpath"
	};

	@Override
	public String getGrammarFileName() { return "ConstraintExpr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConstraintExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Constraint_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Constraint_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterConstraint_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitConstraint_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitConstraint_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_expressionContext constraint_expression() throws RecognitionException {
		Constraint_expressionContext _localctx = new Constraint_expressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_constraint_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); cond();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TenaryRuleContext extends CondContext {
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public TenaryRuleContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterTenaryRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitTenaryRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitTenaryRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondPassthroughContext extends CondContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public CondPassthroughContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterCondPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitCondPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitCondPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cond);
		try {
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new CondPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38); or();
				}
				break;

			case 2:
				_localctx = new TenaryRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39); or();
				setState(40); match(T__10);
				setState(41); or();
				setState(42); match(T__19);
				setState(43); or();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
	 
		public OrContext() { }
		public void copyFrom(OrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrPassthroughContext extends OrContext {
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public OrPassthroughContext(OrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterOrPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitOrPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitOrPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrRuleContext extends OrContext {
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public OrRuleContext(OrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterOrRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitOrRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitOrRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_or);
		int _la;
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new OrPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47); and();
				}
				break;

			case 2:
				_localctx = new OrRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48); and();
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(49); match(T__16);
					setState(50); and();
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__16 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
	 
		public AndContext() { }
		public void copyFrom(AndContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndRuleContext extends AndContext {
		public List<EqualContext> equal() {
			return getRuleContexts(EqualContext.class);
		}
		public EqualContext equal(int i) {
			return getRuleContext(EqualContext.class,i);
		}
		public AndRuleContext(AndContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAndRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAndRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAndRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndPassthroughContext extends AndContext {
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public AndPassthroughContext(AndContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAndPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAndPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAndPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_and);
		int _la;
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AndPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57); equal();
				}
				break;

			case 2:
				_localctx = new AndRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58); equal();
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59); match(T__13);
					setState(60); equal();
					}
					}
					setState(63); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__13 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualContext extends ParserRuleContext {
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
	 
		public EqualContext() { }
		public void copyFrom(EqualContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualPassthroughContext extends EqualContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public EqualPassthroughContext(EqualContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterEqualPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitEqualPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitEqualPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualRuleContext extends EqualContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public EqualRuleContext(EqualContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterEqualRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitEqualRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitEqualRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_equal);
		int _la;
		try {
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new EqualPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67); relation();
				}
				break;

			case 2:
				_localctx = new EqualRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68); relation();
				setState(69);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(70); relation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InRuleContext extends RelationContext {
		public TerminalNode IN_OPERATOR() { return getToken(ConstraintExprParser.IN_OPERATOR, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public InRuleContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterInRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitInRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitInRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationPassthroughContext extends RelationContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public RelationPassthroughContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterRelationPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitRelationPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitRelationPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonRuleContext extends RelationContext {
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public ComparisonRuleContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterComparisonRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitComparisonRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitComparisonRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relation);
		int _la;
		try {
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RelationPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74); add();
				}
				break;

			case 2:
				_localctx = new ComparisonRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75); add();
				setState(76);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__15) | (1L << T__11) | (1L << T__8))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(77); add();
				}
				break;

			case 3:
				_localctx = new InRuleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79); add();
				setState(80); match(IN_OPERATOR);
				setState(81); array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
	 
		public AddContext() { }
		public void copyFrom(AddContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddPassthroughContext extends AddContext {
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public AddPassthroughContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAddPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAddPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAddPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddRuleContext extends AddContext {
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public AddRuleContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAddRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAddRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAddRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_add);
		int _la;
		try {
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AddPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85); mult();
				}
				break;

			case 2:
				_localctx = new AddRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86); mult();
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==T__1) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(88); mult();
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 || _la==T__1 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultContext extends ParserRuleContext {
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
	 
		public MultContext() { }
		public void copyFrom(MultContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultPassthroughContext extends MultContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public MultPassthroughContext(MultContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterMultPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitMultPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitMultPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultRuleContext extends MultContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public MultRuleContext(MultContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterMultRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitMultRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitMultRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mult);
		int _la;
		try {
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new MultPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95); unary();
				}
				break;

			case 2:
				_localctx = new MultRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); unary();
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(97);
					_la = _input.LA(1);
					if ( !(_la==T__21 || _la==T__4) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(98); unary();
					}
					}
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__21 || _la==T__4 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryPassthroughContext extends UnaryContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryPassthroughContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterUnaryPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitUnaryPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitUnaryPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryRuleContext extends UnaryContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryRuleContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterUnaryRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitUnaryRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitUnaryRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unary);
		int _la;
		try {
			setState(108);
			switch (_input.LA(1)) {
			case T__7:
			case T__6:
			case BOOLEAN:
			case IDENT:
			case INTEGER:
			case FLOAT:
			case STRING:
				_localctx = new UnaryPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105); term();
				}
				break;
			case T__9:
			case T__3:
			case T__1:
				_localctx = new UnaryRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__3) | (1L << T__1))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(107); term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringTermContext extends TermContext {
		public TerminalNode STRING() { return getToken(ConstraintExprParser.STRING, 0); }
		public StringTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterStringTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitStringTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitStringTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTermContext extends TermContext {
		public TerminalNode BOOLEAN() { return getToken(ConstraintExprParser.BOOLEAN, 0); }
		public BooleanTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterBooleanTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitBooleanTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitBooleanTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OptionpathTermContext extends TermContext {
		public OptionpathContext optionpath() {
			return getRuleContext(OptionpathContext.class,0);
		}
		public OptionpathTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterOptionpathTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitOptionpathTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitOptionpathTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberTermContext extends TermContext {
		public TerminalNode INTEGER() { return getToken(ConstraintExprParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(ConstraintExprParser.FLOAT, 0); }
		public NumberTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterNumberTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitNumberTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitNumberTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionTermContext extends TermContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterFunctionTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitFunctionTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitFunctionTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DatapathTermContext extends TermContext {
		public DatapathContext datapath() {
			return getRuleContext(DatapathContext.class,0);
		}
		public DatapathTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterDatapathTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitDatapathTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitDatapathTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenTermContext extends TermContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterParenTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitParenTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitParenTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new DatapathTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110); datapath();
				}
				break;

			case 2:
				_localctx = new OptionpathTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111); optionpath();
				}
				break;

			case 3:
				_localctx = new ParenTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112); match(T__6);
				setState(113); expression();
				setState(114); match(T__5);
				}
				break;

			case 4:
				_localctx = new NumberTermContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116); match(INTEGER);
				}
				break;

			case 5:
				_localctx = new NumberTermContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117); match(FLOAT);
				}
				break;

			case 6:
				_localctx = new BooleanTermContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(118); match(BOOLEAN);
				}
				break;

			case 7:
				_localctx = new StringTermContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(119); match(STRING);
				}
				break;

			case 8:
				_localctx = new FunctionTermContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(120); function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(T__18);
			setState(124); expression();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(125); match(T__2);
				setState(126); expression();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132); match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(ConstraintExprParser.IDENT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(T__7);
			setState(135); match(IDENT);
			setState(136); arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(T__6);
			setState(147);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__6) | (1L << T__3) | (1L << T__1) | (1L << BOOLEAN) | (1L << IDENT) | (1L << INTEGER) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				setState(139); expression();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(140); match(T__2);
					setState(141); expression();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(149); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapathContext extends ParserRuleContext {
		public List<Datapath_elementContext> datapath_element() {
			return getRuleContexts(Datapath_elementContext.class);
		}
		public Datapath_elementContext datapath_element(int i) {
			return getRuleContext(Datapath_elementContext.class,i);
		}
		public DatapathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterDatapath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitDatapath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitDatapath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapathContext datapath() throws RecognitionException {
		DatapathContext _localctx = new DatapathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_datapath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); datapath_element();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(152); match(T__0);
				setState(153); datapath_element();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datapath_elementContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ConstraintExprParser.INTEGER, 0); }
		public TerminalNode IDENT() { return getToken(ConstraintExprParser.IDENT, 0); }
		public Datapath_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapath_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterDatapath_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitDatapath_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitDatapath_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Datapath_elementContext datapath_element() throws RecognitionException {
		Datapath_elementContext _localctx = new Datapath_elementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_datapath_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(IDENT);
			setState(165);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(160); match(T__18);
				setState(162);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(161); match(INTEGER);
					}
				}

				setState(164); match(T__12);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionpathContext extends ParserRuleContext {
		public DatapathContext datapath() {
			return getRuleContext(DatapathContext.class,0);
		}
		public OptionpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterOptionpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitOptionpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitOptionpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionpathContext optionpath() throws RecognitionException {
		OptionpathContext _localctx = new OptionpathContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_optionpath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(T__7);
			setState(168); datapath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00ad\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5\3"+
		"\5\6\5\66\n\5\r\5\16\5\67\5\5:\n\5\3\6\3\6\3\6\3\6\6\6@\n\6\r\6\16\6A"+
		"\5\6D\n\6\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bV\n\b\3\t\3\t\3\t\3\t\6\t\\\n\t\r\t\16\t]\5\t`\n\t\3\n\3\n\3\n"+
		"\3\n\6\nf\n\n\r\n\16\ng\5\nj\n\n\3\13\3\13\3\13\5\13o\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f|\n\f\3\r\3\r\3\r\3\r\7\r\u0082\n"+
		"\r\f\r\16\r\u0085\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\7\17\u0091\n\17\f\17\16\17\u0094\13\17\5\17\u0096\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\3\21\3\21\3\21\5\21"+
		"\u00a5\n\21\3\21\5\21\u00a8\n\21\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"\2\7\4\2\4\4\n\n\6\2\7\7\t\t\r\r\20\20"+
		"\4\2\25\25\27\27\4\2\3\3\24\24\5\2\17\17\25\25\27\27\u00b5\2$\3\2\2\2"+
		"\4&\3\2\2\2\6/\3\2\2\2\b9\3\2\2\2\nC\3\2\2\2\fJ\3\2\2\2\16U\3\2\2\2\20"+
		"_\3\2\2\2\22i\3\2\2\2\24n\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2\32\u0088\3\2"+
		"\2\2\34\u008c\3\2\2\2\36\u0099\3\2\2\2 \u00a1\3\2\2\2\"\u00a9\3\2\2\2"+
		"$%\5\4\3\2%\3\3\2\2\2&\'\5\6\4\2\'\5\3\2\2\2(\60\5\b\5\2)*\5\b\5\2*+\7"+
		"\16\2\2+,\5\b\5\2,-\7\5\2\2-.\5\b\5\2.\60\3\2\2\2/(\3\2\2\2/)\3\2\2\2"+
		"\60\7\3\2\2\2\61:\5\n\6\2\62\65\5\n\6\2\63\64\7\b\2\2\64\66\5\n\6\2\65"+
		"\63\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\61\3\2"+
		"\2\29\62\3\2\2\2:\t\3\2\2\2;D\5\f\7\2<?\5\f\7\2=>\7\13\2\2>@\5\f\7\2?"+
		"=\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2C;\3\2\2\2C<\3\2\2\2"+
		"D\13\3\2\2\2EK\5\16\b\2FG\5\16\b\2GH\t\2\2\2HI\5\16\b\2IK\3\2\2\2JE\3"+
		"\2\2\2JF\3\2\2\2K\r\3\2\2\2LV\5\20\t\2MN\5\20\t\2NO\t\3\2\2OP\5\20\t\2"+
		"PV\3\2\2\2QR\5\20\t\2RS\7\31\2\2ST\5\30\r\2TV\3\2\2\2UL\3\2\2\2UM\3\2"+
		"\2\2UQ\3\2\2\2V\17\3\2\2\2W`\5\22\n\2X[\5\22\n\2YZ\t\4\2\2Z\\\5\22\n\2"+
		"[Y\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_W\3\2\2\2_X\3\2\2"+
		"\2`\21\3\2\2\2aj\5\24\13\2be\5\24\13\2cd\t\5\2\2df\5\24\13\2ec\3\2\2\2"+
		"fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ia\3\2\2\2ib\3\2\2\2j\23\3\2\2"+
		"\2ko\5\26\f\2lm\t\6\2\2mo\5\26\f\2nk\3\2\2\2nl\3\2\2\2o\25\3\2\2\2p|\5"+
		"\36\20\2q|\5\"\22\2rs\7\22\2\2st\5\4\3\2tu\7\23\2\2u|\3\2\2\2v|\7\34\2"+
		"\2w|\7\35\2\2x|\7\32\2\2y|\7\36\2\2z|\5\32\16\2{p\3\2\2\2{q\3\2\2\2{r"+
		"\3\2\2\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\27\3\2\2\2"+
		"}~\7\6\2\2~\u0083\5\4\3\2\177\u0080\7\26\2\2\u0080\u0082\5\4\3\2\u0081"+
		"\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\f\2\2\u0087\31"+
		"\3\2\2\2\u0088\u0089\7\21\2\2\u0089\u008a\7\33\2\2\u008a\u008b\5\34\17"+
		"\2\u008b\33\3\2\2\2\u008c\u0095\7\22\2\2\u008d\u0092\5\4\3\2\u008e\u008f"+
		"\7\26\2\2\u008f\u0091\5\4\3\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2"+
		"\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u008d\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\7\23\2\2\u0098\35\3\2\2\2\u0099\u009e\5 \21\2\u009a\u009b\7\30"+
		"\2\2\u009b\u009d\5 \21\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\37\3\2\2\2\u00a0\u009e\3\2\2"+
		"\2\u00a1\u00a7\7\33\2\2\u00a2\u00a4\7\6\2\2\u00a3\u00a5\7\34\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\7\f"+
		"\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8!\3\2\2\2\u00a9\u00aa"+
		"\7\21\2\2\u00aa\u00ab\5\36\20\2\u00ab#\3\2\2\2\25/\679ACJU]_gin{\u0083"+
		"\u0092\u0095\u009e\u00a4\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
