// Generated from com\whereq\common\json\schema\expression\javascript\ConstraintExpr.g4 by ANTLR 4.3
package com.whereq.common.json.schema.expression.javascript;
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
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); or();
			setState(44);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(39); match(T__10);
				setState(40); or();
				setState(41); match(T__19);
				setState(42); or();
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

	public static class OrContext extends ParserRuleContext {
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); and();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(47); match(T__16);
				setState(48); and();
				}
				}
				setState(53);
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

	public static class AndContext extends ParserRuleContext {
		public List<EqualContext> equal() {
			return getRuleContexts(EqualContext.class);
		}
		public EqualContext equal(int i) {
			return getRuleContext(EqualContext.class,i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); equal();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(55); match(T__13);
				setState(56); equal();
				}
				}
				setState(61);
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

	public static class EqualContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_equal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); relation();
			setState(65);
			_la = _input.LA(1);
			if (_la==T__20 || _la==T__14) {
				{
				setState(63);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(64); relation();
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

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode IN_OPERATOR() { return getToken(ConstraintExprParser.IN_OPERATOR, 0); }
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); add();
			setState(70);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__15) | (1L << T__11) | (1L << T__8))) != 0)) {
				{
				setState(68);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__15) | (1L << T__11) | (1L << T__8))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(69); add();
				}
			}

			setState(74);
			_la = _input.LA(1);
			if (_la==IN_OPERATOR) {
				{
				setState(72); match(IN_OPERATOR);
				setState(73); array();
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

	public static class AddContext extends ParserRuleContext {
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); mult();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__1) {
				{
				{
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(78); mult();
				}
				}
				setState(83);
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

	public static class MultContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); unary();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==T__4) {
				{
				{
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(86); unary();
				}
				}
				setState(91);
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

	public static class UnaryContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__3) | (1L << T__1))) != 0)) {
				{
				setState(92);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__3) | (1L << T__1))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(95); term();
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
		public TerminalNode INTEGER() { return getToken(ConstraintExprParser.INTEGER, 0); }
		public OptionpathContext optionpath() {
			return getRuleContext(OptionpathContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ConstraintExprParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(ConstraintExprParser.BOOLEAN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(ConstraintExprParser.FLOAT, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public DatapathContext datapath() {
			return getRuleContext(DatapathContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintExprListener ) ((ConstraintExprListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintExprVisitor ) return ((ConstraintExprVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); datapath();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); optionpath();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); match(T__6);
				setState(100); expression();
				setState(101); match(T__5);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103); match(INTEGER);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(104); match(FLOAT);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(105); match(BOOLEAN);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(106); match(STRING);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(107); function();
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
			setState(110); match(T__18);
			setState(111); expression();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(112); match(T__2);
				setState(113); expression();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119); match(T__12);
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
			setState(121); match(T__7);
			setState(122); match(IDENT);
			setState(123); arguments();
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
			setState(125); match(T__6);
			setState(134);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__6) | (1L << T__3) | (1L << T__1) | (1L << BOOLEAN) | (1L << IDENT) | (1L << INTEGER) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				setState(126); expression();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(127); match(T__2);
					setState(128); expression();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(136); match(T__5);
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
			setState(138); datapath_element();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(139); match(T__0);
				setState(140); datapath_element();
				}
				}
				setState(145);
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
			setState(146); match(IDENT);
			setState(150);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(147); match(T__18);
				setState(148); match(INTEGER);
				setState(149); match(T__12);
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
			setState(152); match(T__7);
			setState(153); datapath();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u009e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\7\5\64\n"+
		"\5\f\5\16\5\67\13\5\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\7\3\7\3\7\5"+
		"\7D\n\7\3\b\3\b\3\b\5\bI\n\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\7\tR\n\t\f\t"+
		"\16\tU\13\t\3\n\3\n\3\n\7\nZ\n\n\f\n\16\n]\13\n\3\13\5\13`\n\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fo\n\f\3\r\3\r\3\r\3"+
		"\r\7\ru\n\r\f\r\16\rx\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\7\17\u0084\n\17\f\17\16\17\u0087\13\17\5\17\u0089\n\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\21\3\21\3\21"+
		"\3\21\5\21\u0099\n\21\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"\2\7\4\2\4\4\n\n\6\2\7\7\t\t\r\r\20\20\4\2\25\25"+
		"\27\27\4\2\3\3\24\24\5\2\17\17\25\25\27\27\u00a1\2$\3\2\2\2\4&\3\2\2\2"+
		"\6(\3\2\2\2\b\60\3\2\2\2\n8\3\2\2\2\f@\3\2\2\2\16E\3\2\2\2\20N\3\2\2\2"+
		"\22V\3\2\2\2\24_\3\2\2\2\26n\3\2\2\2\30p\3\2\2\2\32{\3\2\2\2\34\177\3"+
		"\2\2\2\36\u008c\3\2\2\2 \u0094\3\2\2\2\"\u009a\3\2\2\2$%\5\4\3\2%\3\3"+
		"\2\2\2&\'\5\6\4\2\'\5\3\2\2\2(.\5\b\5\2)*\7\16\2\2*+\5\b\5\2+,\7\5\2\2"+
		",-\5\b\5\2-/\3\2\2\2.)\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60\65\5\n\6\2\61\62"+
		"\7\b\2\2\62\64\5\n\6\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\t\3\2\2\2\67\65\3\2\2\28=\5\f\7\29:\7\13\2\2:<\5\f\7\2;9\3"+
		"\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\13\3\2\2\2?=\3\2\2\2@C\5\16\b\2"+
		"AB\t\2\2\2BD\5\16\b\2CA\3\2\2\2CD\3\2\2\2D\r\3\2\2\2EH\5\20\t\2FG\t\3"+
		"\2\2GI\5\20\t\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JK\7\31\2\2KM\5\30\r\2LJ"+
		"\3\2\2\2LM\3\2\2\2M\17\3\2\2\2NS\5\22\n\2OP\t\4\2\2PR\5\22\n\2QO\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\21\3\2\2\2US\3\2\2\2V[\5\24\13\2WX\t"+
		"\5\2\2XZ\5\24\13\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\23\3\2\2"+
		"\2][\3\2\2\2^`\t\6\2\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5\26\f\2b\25\3"+
		"\2\2\2co\5\36\20\2do\5\"\22\2ef\7\22\2\2fg\5\4\3\2gh\7\23\2\2ho\3\2\2"+
		"\2io\7\34\2\2jo\7\35\2\2ko\7\32\2\2lo\7\36\2\2mo\5\32\16\2nc\3\2\2\2n"+
		"d\3\2\2\2ne\3\2\2\2ni\3\2\2\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2"+
		"o\27\3\2\2\2pq\7\6\2\2qv\5\4\3\2rs\7\26\2\2su\5\4\3\2tr\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\f\2\2z\31\3\2\2\2{|\7"+
		"\21\2\2|}\7\33\2\2}~\5\34\17\2~\33\3\2\2\2\177\u0088\7\22\2\2\u0080\u0085"+
		"\5\4\3\2\u0081\u0082\7\26\2\2\u0082\u0084\5\4\3\2\u0083\u0081\3\2\2\2"+
		"\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\7\23\2\2\u008b\35\3\2\2\2\u008c\u0091\5 \21"+
		"\2\u008d\u008e\7\30\2\2\u008e\u0090\5 \21\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\37\3\2\2"+
		"\2\u0093\u0091\3\2\2\2\u0094\u0098\7\33\2\2\u0095\u0096\7\6\2\2\u0096"+
		"\u0097\7\34\2\2\u0097\u0099\7\f\2\2\u0098\u0095\3\2\2\2\u0098\u0099\3"+
		"\2\2\2\u0099!\3\2\2\2\u009a\u009b\7\21\2\2\u009b\u009c\5\36\20\2\u009c"+
		"#\3\2\2\2\21.\65=CHLS[_nv\u0085\u0088\u0091\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
