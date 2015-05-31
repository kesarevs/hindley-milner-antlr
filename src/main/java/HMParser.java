// Generated from HM.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, WS=9;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'let'", "'='", "'in'", "'\\'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AppContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AppContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitApp(this);
		}
	}
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitParenthesis(this);
		}
	}
	public static class AbsContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterAbs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitAbs(this);
		}
	}
	public static class VarContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitVar(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitLet(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			switch (_input.LA(1)) {
			case T__5:
				{
				_localctx = new AbsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(T__5);
				setState(4);
				match(ID);
				setState(5);
				match(T__6);
				setState(6);
				expr(1);
				}
				break;
			case T__0:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(T__0);
				setState(8);
				expr(0);
				setState(9);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(T__2);
				setState(12);
				match(ID);
				setState(13);
				match(T__3);
				setState(14);
				expr(0);
				setState(15);
				match(T__4);
				setState(16);
				expr(0);
				}
				break;
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AppContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(21);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(22);
					expr(4);
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\37\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\26"+
		"\n\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\2\3\2\3\2\2\2!\2\25\3\2\2"+
		"\2\4\5\b\2\1\2\5\6\7\b\2\2\6\7\7\n\2\2\7\b\7\t\2\2\b\26\5\2\2\3\t\n\7"+
		"\3\2\2\n\13\5\2\2\2\13\f\7\4\2\2\f\26\3\2\2\2\r\16\7\5\2\2\16\17\7\n\2"+
		"\2\17\20\7\6\2\2\20\21\5\2\2\2\21\22\7\7\2\2\22\23\5\2\2\2\23\26\3\2\2"+
		"\2\24\26\7\n\2\2\25\4\3\2\2\2\25\t\3\2\2\2\25\r\3\2\2\2\25\24\3\2\2\2"+
		"\26\33\3\2\2\2\27\30\f\5\2\2\30\32\5\2\2\6\31\27\3\2\2\2\32\35\3\2\2\2"+
		"\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2\2\2\4\25\33";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}