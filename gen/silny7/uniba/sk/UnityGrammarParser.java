// Generated from C:/Users/boris/OneDrive/Poèítaè/mAIN 2019-20/Diplomová práca/unityToJava/src/main/antlr4\UnityGrammar.g4 by ANTLR 4.7
package silny7.uniba.sk;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UnityGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, DECLARE=2, ALWAYS=3, INITIALLY=4, ASSIGN=5, END=6, BOOLEAN=7, 
		INTEGER=8, ARRAY=9, OF=10, IF=11, COLON=12, DOUBLE_COLON=13, COMMA=14, 
		OPEN_PARENTHESES=15, CLOSE_PARENTHESES=16, OPEN_BRACKET=17, CLOSE_BRACKET=18, 
		DOT=19, DOUBLE_DOT=20, NONDETERM_SEPARATOR=21, DETERM_SEPARATOR=22, QUANTIFICATION_OPEN=23, 
		QUANTIFICATION_CLOSE=24, ASSIGN_SIGN=25, TILDE=26, LESS_THAN=27, GREATER_THAN=28, 
		LESS_OR_EQUAL=29, GREATER_OR_EQUAL=30, EQUAL=31, NOT_EQUAL=32, AND=33, 
		OR=34, NOT=35, PLUS=36, MINUS=37, TIMES=38, DIV=39, POWER=40, MOD=41, 
		INT=42, BOOL=43, IDENTIFIER=44, WS=45, LINE_COMMENT=46, BLOCK_COMMENT=47, 
		STRING=48;
	public static final int
		RULE_program = 0, RULE_declare_section = 1, RULE_declare_component = 2, 
		RULE_variable_declaration_list = 3, RULE_variableID = 4, RULE_baseType = 5, 
		RULE_simpleType = 6, RULE_arrayType = 7, RULE_listRange = 8, RULE_rangeDeclaration = 9, 
		RULE_rangeElement = 10, RULE_always_section = 11, RULE_initially_section = 12, 
		RULE_assign_section = 13, RULE_statement_list = 14, RULE_statement = 15, 
		RULE_assignment_statement = 16, RULE_assign_component = 17, RULE_enumerated_assignment = 18, 
		RULE_variable_list = 19, RULE_simple_expression_list = 20, RULE_conditional_expression_list = 21, 
		RULE_quantified_statement = 22, RULE_quantified_assignment = 23, RULE_quantification = 24, 
		RULE_variable = 25, RULE_expression = 26, RULE_boolean_expression = 27, 
		RULE_value_expression = 28, RULE_mul_div_mod_and_expression = 29, RULE_power_expression = 30, 
		RULE_unary_expression = 31, RULE_primary_expression = 32, RULE_methodDeclaration = 33, 
		RULE_expressionDeclaration = 34, RULE_quantificationDeclaration = 35, 
		RULE_elementListDeclaration = 36, RULE_function = 37, RULE_element_list = 38, 
		RULE_relational_operator = 39, RULE_add_minus_or_operator = 40, RULE_times_div_mod_and_operator = 41, 
		RULE_unary_operator = 42, RULE_quantification_operator = 43, RULE_text = 44, 
		RULE_number = 45, RULE_integerValue = 46, RULE_booleanValue = 47;
	public static final String[] ruleNames = {
		"program", "declare_section", "declare_component", "variable_declaration_list", 
		"variableID", "baseType", "simpleType", "arrayType", "listRange", "rangeDeclaration", 
		"rangeElement", "always_section", "initially_section", "assign_section", 
		"statement_list", "statement", "assignment_statement", "assign_component", 
		"enumerated_assignment", "variable_list", "simple_expression_list", "conditional_expression_list", 
		"quantified_statement", "quantified_assignment", "quantification", "variable", 
		"expression", "boolean_expression", "value_expression", "mul_div_mod_and_expression", 
		"power_expression", "unary_expression", "primary_expression", "methodDeclaration", 
		"expressionDeclaration", "quantificationDeclaration", "elementListDeclaration", 
		"function", "element_list", "relational_operator", "add_minus_or_operator", 
		"times_div_mod_and_operator", "unary_operator", "quantification_operator", 
		"text", "number", "integerValue", "booleanValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"':'", "'::'", "','", "'('", "')'", "'['", "']'", "'.'", "'..'", "'[]'", 
		"'||'", "'<<'", "'>>'", "':='", "'~'", "'<'", "'>'", "'<='", "'>='", "'='", 
		"'!='", null, null, null, "'+'", "'-'", "'*'", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROGRAM", "DECLARE", "ALWAYS", "INITIALLY", "ASSIGN", "END", "BOOLEAN", 
		"INTEGER", "ARRAY", "OF", "IF", "COLON", "DOUBLE_COLON", "COMMA", "OPEN_PARENTHESES", 
		"CLOSE_PARENTHESES", "OPEN_BRACKET", "CLOSE_BRACKET", "DOT", "DOUBLE_DOT", 
		"NONDETERM_SEPARATOR", "DETERM_SEPARATOR", "QUANTIFICATION_OPEN", "QUANTIFICATION_CLOSE", 
		"ASSIGN_SIGN", "TILDE", "LESS_THAN", "GREATER_THAN", "LESS_OR_EQUAL", 
		"GREATER_OR_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", "NOT", "PLUS", 
		"MINUS", "TIMES", "DIV", "POWER", "MOD", "INT", "BOOL", "IDENTIFIER", 
		"WS", "LINE_COMMENT", "BLOCK_COMMENT", "STRING"
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
	public String getGrammarFileName() { return "UnityGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UnityGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TextContext program_name;
		public TerminalNode PROGRAM() { return getToken(UnityGrammarParser.PROGRAM, 0); }
		public Assign_sectionContext assign_section() {
			return getRuleContext(Assign_sectionContext.class,0);
		}
		public TerminalNode END() { return getToken(UnityGrammarParser.END, 0); }
		public Declare_sectionContext declare_section() {
			return getRuleContext(Declare_sectionContext.class,0);
		}
		public Always_sectionContext always_section() {
			return getRuleContext(Always_sectionContext.class,0);
		}
		public Initially_sectionContext initially_section() {
			return getRuleContext(Initially_sectionContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(PROGRAM);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING) {
				{
				setState(97);
				((ProgramContext)_localctx).program_name = text();
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECLARE) {
				{
				setState(100);
				declare_section();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALWAYS) {
				{
				setState(103);
				always_section();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIALLY) {
				{
				setState(106);
				initially_section();
				}
			}

			setState(109);
			assign_section();
			setState(110);
			match(END);
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

	public static class Declare_sectionContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(UnityGrammarParser.DECLARE, 0); }
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public List<Declare_componentContext> declare_component() {
			return getRuleContexts(Declare_componentContext.class);
		}
		public Declare_componentContext declare_component(int i) {
			return getRuleContext(Declare_componentContext.class,i);
		}
		public Declare_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterDeclare_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitDeclare_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitDeclare_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declare_sectionContext declare_section() throws RecognitionException {
		Declare_sectionContext _localctx = new Declare_sectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(DECLARE);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(113);
				match(COLON);
				}
			}

			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				declare_component();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
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

	public static class Declare_componentContext extends ParserRuleContext {
		public Variable_declaration_listContext variable_declaration_list() {
			return getRuleContext(Variable_declaration_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public Declare_componentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterDeclare_component(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitDeclare_component(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitDeclare_component(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declare_componentContext declare_component() throws RecognitionException {
		Declare_componentContext _localctx = new Declare_componentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declare_component);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			variable_declaration_list();
			setState(122);
			match(COLON);
			setState(123);
			baseType();
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

	public static class Variable_declaration_listContext extends ParserRuleContext {
		public List<VariableIDContext> variableID() {
			return getRuleContexts(VariableIDContext.class);
		}
		public VariableIDContext variableID(int i) {
			return getRuleContext(VariableIDContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnityGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnityGrammarParser.COMMA, i);
		}
		public Variable_declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterVariable_declaration_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitVariable_declaration_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitVariable_declaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declaration_listContext variable_declaration_list() throws RecognitionException {
		Variable_declaration_listContext _localctx = new Variable_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			variableID();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(126);
				match(COMMA);
				setState(127);
				variableID();
				}
				}
				setState(132);
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

	public static class VariableIDContext extends ParserRuleContext {
		public Token variableName;
		public TerminalNode IDENTIFIER() { return getToken(UnityGrammarParser.IDENTIFIER, 0); }
		public VariableIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterVariableID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitVariableID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitVariableID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIDContext variableID() throws RecognitionException {
		VariableIDContext _localctx = new VariableIDContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((VariableIDContext)_localctx).variableName = match(IDENTIFIER);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_baseType);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				simpleType();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				arrayType();
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

	public static class SimpleTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(UnityGrammarParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(UnityGrammarParser.INTEGER, 0); }
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitSimpleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simpleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(UnityGrammarParser.ARRAY, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(UnityGrammarParser.OPEN_BRACKET, 0); }
		public ListRangeContext listRange() {
			return getRuleContext(ListRangeContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(UnityGrammarParser.CLOSE_BRACKET, 0); }
		public TerminalNode OF() { return getToken(UnityGrammarParser.OF, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayType);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(ARRAY);
				setState(142);
				match(OPEN_BRACKET);
				setState(143);
				listRange();
				setState(144);
				match(CLOSE_BRACKET);
				setState(145);
				match(OF);
				setState(146);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(ARRAY);
				setState(149);
				match(OPEN_BRACKET);
				setState(150);
				listRange();
				setState(151);
				match(CLOSE_BRACKET);
				setState(152);
				match(OF);
				setState(153);
				simpleType();
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

	public static class ListRangeContext extends ParserRuleContext {
		public RangeDeclarationContext range;
		public List<RangeDeclarationContext> rangeDeclaration() {
			return getRuleContexts(RangeDeclarationContext.class);
		}
		public RangeDeclarationContext rangeDeclaration(int i) {
			return getRuleContext(RangeDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnityGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnityGrammarParser.COMMA, i);
		}
		public ListRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterListRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitListRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitListRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListRangeContext listRange() throws RecognitionException {
		ListRangeContext _localctx = new ListRangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((ListRangeContext)_localctx).range = rangeDeclaration();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				((ListRangeContext)_localctx).range = rangeDeclaration();
				}
				}
				setState(164);
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

	public static class RangeDeclarationContext extends ParserRuleContext {
		public List<RangeElementContext> rangeElement() {
			return getRuleContexts(RangeElementContext.class);
		}
		public RangeElementContext rangeElement(int i) {
			return getRuleContext(RangeElementContext.class,i);
		}
		public TerminalNode DOUBLE_DOT() { return getToken(UnityGrammarParser.DOUBLE_DOT, 0); }
		public RangeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterRangeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitRangeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitRangeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeDeclarationContext rangeDeclaration() throws RecognitionException {
		RangeDeclarationContext _localctx = new RangeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rangeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			rangeElement();
			setState(166);
			match(DOUBLE_DOT);
			setState(167);
			rangeElement();
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

	public static class RangeElementContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(UnityGrammarParser.IDENTIFIER, 0); }
		public RangeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterRangeElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitRangeElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitRangeElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeElementContext rangeElement() throws RecognitionException {
		RangeElementContext _localctx = new RangeElementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rangeElement);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				number();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(IDENTIFIER);
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

	public static class Always_sectionContext extends ParserRuleContext {
		public TerminalNode ALWAYS() { return getToken(UnityGrammarParser.ALWAYS, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public Always_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_always_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterAlways_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitAlways_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitAlways_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Always_sectionContext always_section() throws RecognitionException {
		Always_sectionContext _localctx = new Always_sectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_always_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ALWAYS);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(174);
				match(COLON);
				}
			}

			setState(177);
			statement_list();
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

	public static class Initially_sectionContext extends ParserRuleContext {
		public TerminalNode INITIALLY() { return getToken(UnityGrammarParser.INITIALLY, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public Initially_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initially_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterInitially_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitInitially_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitInitially_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initially_sectionContext initially_section() throws RecognitionException {
		Initially_sectionContext _localctx = new Initially_sectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_initially_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(INITIALLY);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(180);
				match(COLON);
				}
			}

			setState(183);
			statement_list();
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

	public static class Assign_sectionContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(UnityGrammarParser.ASSIGN, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public Assign_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterAssign_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitAssign_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitAssign_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_sectionContext assign_section() throws RecognitionException {
		Assign_sectionContext _localctx = new Assign_sectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assign_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(ASSIGN);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(186);
				match(COLON);
				}
			}

			setState(189);
			statement_list();
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

	public static class Statement_listContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NONDETERM_SEPARATOR() { return getTokens(UnityGrammarParser.NONDETERM_SEPARATOR); }
		public TerminalNode NONDETERM_SEPARATOR(int i) {
			return getToken(UnityGrammarParser.NONDETERM_SEPARATOR, i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitStatement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitStatement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			statement();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONDETERM_SEPARATOR) {
				{
				{
				setState(192);
				match(NONDETERM_SEPARATOR);
				setState(193);
				statement();
				}
				}
				setState(198);
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

	public static class StatementContext extends ParserRuleContext {
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public Quantified_statementContext quantified_statement() {
			return getRuleContext(Quantified_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				assignment_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				quantified_statement();
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

	public static class Assignment_statementContext extends ParserRuleContext {
		public List<Assign_componentContext> assign_component() {
			return getRuleContexts(Assign_componentContext.class);
		}
		public Assign_componentContext assign_component(int i) {
			return getRuleContext(Assign_componentContext.class,i);
		}
		public List<TerminalNode> DETERM_SEPARATOR() { return getTokens(UnityGrammarParser.DETERM_SEPARATOR); }
		public TerminalNode DETERM_SEPARATOR(int i) {
			return getToken(UnityGrammarParser.DETERM_SEPARATOR, i);
		}
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterAssignment_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitAssignment_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitAssignment_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			assign_component();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DETERM_SEPARATOR) {
				{
				{
				setState(204);
				match(DETERM_SEPARATOR);
				setState(205);
				assign_component();
				}
				}
				setState(210);
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

	public static class Assign_componentContext extends ParserRuleContext {
		public Enumerated_assignmentContext enumerated_assignment() {
			return getRuleContext(Enumerated_assignmentContext.class,0);
		}
		public Quantified_assignmentContext quantified_assignment() {
			return getRuleContext(Quantified_assignmentContext.class,0);
		}
		public Assign_componentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterAssign_component(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitAssign_component(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitAssign_component(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_componentContext assign_component() throws RecognitionException {
		Assign_componentContext _localctx = new Assign_componentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assign_component);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				enumerated_assignment();
				}
				break;
			case QUANTIFICATION_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				quantified_assignment();
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

	public static class Enumerated_assignmentContext extends ParserRuleContext {
		public Variable_listContext variable_list() {
			return getRuleContext(Variable_listContext.class,0);
		}
		public TerminalNode ASSIGN_SIGN() { return getToken(UnityGrammarParser.ASSIGN_SIGN, 0); }
		public TerminalNode EQUAL() { return getToken(UnityGrammarParser.EQUAL, 0); }
		public Simple_expression_listContext simple_expression_list() {
			return getRuleContext(Simple_expression_listContext.class,0);
		}
		public Conditional_expression_listContext conditional_expression_list() {
			return getRuleContext(Conditional_expression_listContext.class,0);
		}
		public Enumerated_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerated_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterEnumerated_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitEnumerated_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitEnumerated_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enumerated_assignmentContext enumerated_assignment() throws RecognitionException {
		Enumerated_assignmentContext _localctx = new Enumerated_assignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_enumerated_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			variable_list();
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==ASSIGN_SIGN || _la==EQUAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(217);
				simple_expression_list();
				}
				break;
			case 2:
				{
				setState(218);
				conditional_expression_list();
				}
				break;
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

	public static class Variable_listContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnityGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnityGrammarParser.COMMA, i);
		}
		public Variable_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterVariable_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitVariable_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitVariable_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_listContext variable_list() throws RecognitionException {
		Variable_listContext _localctx = new Variable_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variable_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			variable();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(222);
				match(COMMA);
				setState(223);
				variable();
				}
				}
				setState(228);
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

	public static class Simple_expression_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UnityGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UnityGrammarParser.COMMA, i);
		}
		public Simple_expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterSimple_expression_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitSimple_expression_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitSimple_expression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_expression_listContext simple_expression_list() throws RecognitionException {
		Simple_expression_listContext _localctx = new Simple_expression_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_simple_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			expression();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				expression();
				}
				}
				setState(236);
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

	public static class Conditional_expression_listContext extends ParserRuleContext {
		public List<Simple_expression_listContext> simple_expression_list() {
			return getRuleContexts(Simple_expression_listContext.class);
		}
		public Simple_expression_listContext simple_expression_list(int i) {
			return getRuleContext(Simple_expression_listContext.class,i);
		}
		public List<TerminalNode> IF() { return getTokens(UnityGrammarParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(UnityGrammarParser.IF, i);
		}
		public List<Boolean_expressionContext> boolean_expression() {
			return getRuleContexts(Boolean_expressionContext.class);
		}
		public Boolean_expressionContext boolean_expression(int i) {
			return getRuleContext(Boolean_expressionContext.class,i);
		}
		public List<TerminalNode> TILDE() { return getTokens(UnityGrammarParser.TILDE); }
		public TerminalNode TILDE(int i) {
			return getToken(UnityGrammarParser.TILDE, i);
		}
		public Conditional_expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterConditional_expression_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitConditional_expression_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitConditional_expression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expression_listContext conditional_expression_list() throws RecognitionException {
		Conditional_expression_listContext _localctx = new Conditional_expression_listContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_conditional_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			simple_expression_list();
			setState(238);
			match(IF);
			setState(239);
			boolean_expression();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TILDE) {
				{
				{
				setState(240);
				match(TILDE);
				setState(241);
				simple_expression_list();
				setState(242);
				match(IF);
				setState(243);
				boolean_expression();
				}
				}
				setState(249);
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

	public static class Quantified_statementContext extends ParserRuleContext {
		public TerminalNode QUANTIFICATION_OPEN() { return getToken(UnityGrammarParser.QUANTIFICATION_OPEN, 0); }
		public TerminalNode NONDETERM_SEPARATOR() { return getToken(UnityGrammarParser.NONDETERM_SEPARATOR, 0); }
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode QUANTIFICATION_CLOSE() { return getToken(UnityGrammarParser.QUANTIFICATION_CLOSE, 0); }
		public Quantified_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantified_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterQuantified_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitQuantified_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitQuantified_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quantified_statementContext quantified_statement() throws RecognitionException {
		Quantified_statementContext _localctx = new Quantified_statementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_quantified_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(QUANTIFICATION_OPEN);
			setState(251);
			match(NONDETERM_SEPARATOR);
			setState(252);
			quantification();
			setState(253);
			statement_list();
			setState(254);
			match(QUANTIFICATION_CLOSE);
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

	public static class Quantified_assignmentContext extends ParserRuleContext {
		public TerminalNode QUANTIFICATION_OPEN() { return getToken(UnityGrammarParser.QUANTIFICATION_OPEN, 0); }
		public TerminalNode DETERM_SEPARATOR() { return getToken(UnityGrammarParser.DETERM_SEPARATOR, 0); }
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public TerminalNode QUANTIFICATION_CLOSE() { return getToken(UnityGrammarParser.QUANTIFICATION_CLOSE, 0); }
		public Quantified_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantified_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterQuantified_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitQuantified_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitQuantified_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quantified_assignmentContext quantified_assignment() throws RecognitionException {
		Quantified_assignmentContext _localctx = new Quantified_assignmentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_quantified_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(QUANTIFICATION_OPEN);
			setState(257);
			match(DETERM_SEPARATOR);
			setState(258);
			quantification();
			setState(259);
			assignment_statement();
			setState(260);
			match(QUANTIFICATION_CLOSE);
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

	public static class QuantificationContext extends ParserRuleContext {
		public Variable_listContext variable_list() {
			return getRuleContext(Variable_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(UnityGrammarParser.COLON, 0); }
		public Boolean_expressionContext boolean_expression() {
			return getRuleContext(Boolean_expressionContext.class,0);
		}
		public TerminalNode DOUBLE_COLON() { return getToken(UnityGrammarParser.DOUBLE_COLON, 0); }
		public QuantificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitQuantification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitQuantification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_quantification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			variable_list();
			setState(263);
			match(COLON);
			setState(264);
			boolean_expression();
			setState(265);
			match(DOUBLE_COLON);
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

	public static class VariableContext extends ParserRuleContext {
		public VariableIDContext variableID() {
			return getRuleContext(VariableIDContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(UnityGrammarParser.OPEN_BRACKET, 0); }
		public Simple_expression_listContext simple_expression_list() {
			return getRuleContext(Simple_expression_listContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(UnityGrammarParser.CLOSE_BRACKET, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variable);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				variableID();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				variableID();
				setState(269);
				match(OPEN_BRACKET);
				setState(270);
				simple_expression_list();
				setState(271);
				match(CLOSE_BRACKET);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Relational_operatorContext> relational_operator() {
			return getRuleContexts(Relational_operatorContext.class);
		}
		public Relational_operatorContext relational_operator(int i) {
			return getRuleContext(Relational_operatorContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				value_expression();
				setState(277);
				relational_operator();
				setState(278);
				value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				value_expression();
				setState(281);
				relational_operator();
				setState(282);
				value_expression();
				setState(283);
				relational_operator();
				setState(284);
				value_expression();
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

	public static class Boolean_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Boolean_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterBoolean_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitBoolean_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitBoolean_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_expressionContext boolean_expression() throws RecognitionException {
		Boolean_expressionContext _localctx = new Boolean_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			expression();
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

	public static class Value_expressionContext extends ParserRuleContext {
		public List<Mul_div_mod_and_expressionContext> mul_div_mod_and_expression() {
			return getRuleContexts(Mul_div_mod_and_expressionContext.class);
		}
		public Mul_div_mod_and_expressionContext mul_div_mod_and_expression(int i) {
			return getRuleContext(Mul_div_mod_and_expressionContext.class,i);
		}
		public List<Add_minus_or_operatorContext> add_minus_or_operator() {
			return getRuleContexts(Add_minus_or_operatorContext.class);
		}
		public Add_minus_or_operatorContext add_minus_or_operator(int i) {
			return getRuleContext(Add_minus_or_operatorContext.class,i);
		}
		public Value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterValue_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitValue_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitValue_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_expressionContext value_expression() throws RecognitionException {
		Value_expressionContext _localctx = new Value_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			mul_div_mod_and_expression();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				{
				setState(291);
				add_minus_or_operator();
				setState(292);
				mul_div_mod_and_expression();
				}
				}
				setState(298);
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

	public static class Mul_div_mod_and_expressionContext extends ParserRuleContext {
		public List<Power_expressionContext> power_expression() {
			return getRuleContexts(Power_expressionContext.class);
		}
		public Power_expressionContext power_expression(int i) {
			return getRuleContext(Power_expressionContext.class,i);
		}
		public List<Times_div_mod_and_operatorContext> times_div_mod_and_operator() {
			return getRuleContexts(Times_div_mod_and_operatorContext.class);
		}
		public Times_div_mod_and_operatorContext times_div_mod_and_operator(int i) {
			return getRuleContext(Times_div_mod_and_operatorContext.class,i);
		}
		public Mul_div_mod_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul_div_mod_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterMul_div_mod_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitMul_div_mod_and_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitMul_div_mod_and_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mul_div_mod_and_expressionContext mul_div_mod_and_expression() throws RecognitionException {
		Mul_div_mod_and_expressionContext _localctx = new Mul_div_mod_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_mul_div_mod_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			power_expression();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << TIMES) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(300);
				times_div_mod_and_operator();
				setState(301);
				power_expression();
				}
				}
				setState(307);
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

	public static class Power_expressionContext extends ParserRuleContext {
		public List<Unary_expressionContext> unary_expression() {
			return getRuleContexts(Unary_expressionContext.class);
		}
		public Unary_expressionContext unary_expression(int i) {
			return getRuleContext(Unary_expressionContext.class,i);
		}
		public List<TerminalNode> POWER() { return getTokens(UnityGrammarParser.POWER); }
		public TerminalNode POWER(int i) {
			return getToken(UnityGrammarParser.POWER, i);
		}
		public Power_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterPower_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitPower_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitPower_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Power_expressionContext power_expression() throws RecognitionException {
		Power_expressionContext _localctx = new Power_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_power_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			unary_expression();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POWER) {
				{
				{
				setState(309);
				match(POWER);
				setState(310);
				unary_expression();
				}
				}
				setState(315);
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

	public static class Unary_expressionContext extends ParserRuleContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitUnary_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_unary_expression);
		try {
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				unary_operator();
				setState(317);
				primary_expression();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case OPEN_PARENTHESES:
			case OPEN_BRACKET:
			case QUANTIFICATION_OPEN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				primary_expression();
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ExpressionDeclarationContext expressionDeclaration() {
			return getRuleContext(ExpressionDeclarationContext.class,0);
		}
		public QuantificationDeclarationContext quantificationDeclaration() {
			return getRuleContext(QuantificationDeclarationContext.class,0);
		}
		public ElementListDeclarationContext elementListDeclaration() {
			return getRuleContext(ElementListDeclarationContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitPrimary_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitPrimary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primary_expression);
		try {
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				booleanValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(324);
				integerValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(325);
				methodDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(326);
				expressionDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(327);
				quantificationDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(328);
				elementListDeclaration();
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(UnityGrammarParser.OPEN_PARENTHESES, 0); }
		public Simple_expression_listContext simple_expression_list() {
			return getRuleContext(Simple_expression_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(UnityGrammarParser.CLOSE_PARENTHESES, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			function();
			setState(332);
			match(OPEN_PARENTHESES);
			setState(333);
			simple_expression_list();
			setState(334);
			match(CLOSE_PARENTHESES);
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

	public static class ExpressionDeclarationContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESES() { return getToken(UnityGrammarParser.OPEN_PARENTHESES, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(UnityGrammarParser.CLOSE_PARENTHESES, 0); }
		public ExpressionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterExpressionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitExpressionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitExpressionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionDeclarationContext expressionDeclaration() throws RecognitionException {
		ExpressionDeclarationContext _localctx = new ExpressionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expressionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(OPEN_PARENTHESES);
			setState(337);
			expression();
			setState(338);
			match(CLOSE_PARENTHESES);
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

	public static class QuantificationDeclarationContext extends ParserRuleContext {
		public TerminalNode QUANTIFICATION_OPEN() { return getToken(UnityGrammarParser.QUANTIFICATION_OPEN, 0); }
		public Quantification_operatorContext quantification_operator() {
			return getRuleContext(Quantification_operatorContext.class,0);
		}
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public TerminalNode QUANTIFICATION_CLOSE() { return getToken(UnityGrammarParser.QUANTIFICATION_CLOSE, 0); }
		public QuantificationDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantificationDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterQuantificationDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitQuantificationDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitQuantificationDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantificationDeclarationContext quantificationDeclaration() throws RecognitionException {
		QuantificationDeclarationContext _localctx = new QuantificationDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_quantificationDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(QUANTIFICATION_OPEN);
			setState(341);
			quantification_operator();
			setState(342);
			quantification();
			setState(343);
			match(QUANTIFICATION_CLOSE);
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

	public static class ElementListDeclarationContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(UnityGrammarParser.OPEN_BRACKET, 0); }
		public Element_listContext element_list() {
			return getRuleContext(Element_listContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(UnityGrammarParser.CLOSE_BRACKET, 0); }
		public ElementListDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementListDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterElementListDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitElementListDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitElementListDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementListDeclarationContext elementListDeclaration() throws RecognitionException {
		ElementListDeclarationContext _localctx = new ElementListDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_elementListDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(OPEN_BRACKET);
			setState(346);
			element_list();
			setState(347);
			match(CLOSE_BRACKET);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(UnityGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UnityGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(UnityGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(UnityGrammarParser.DOT, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(IDENTIFIER);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(350);
				match(DOT);
				setState(351);
				match(IDENTIFIER);
				}
				}
				setState(356);
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

	public static class Element_listContext extends ParserRuleContext {
		public Simple_expression_listContext simple_expression_list() {
			return getRuleContext(Simple_expression_listContext.class,0);
		}
		public Element_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterElement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitElement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitElement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_listContext element_list() throws RecognitionException {
		Element_listContext _localctx = new Element_listContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << OPEN_PARENTHESES) | (1L << OPEN_BRACKET) | (1L << QUANTIFICATION_OPEN) | (1L << NOT) | (1L << PLUS) | (1L << MINUS) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(357);
				simple_expression_list();
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

	public static class Relational_operatorContext extends ParserRuleContext {
		public TerminalNode LESS_THAN() { return getToken(UnityGrammarParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(UnityGrammarParser.GREATER_THAN, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(UnityGrammarParser.LESS_OR_EQUAL, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(UnityGrammarParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(UnityGrammarParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(UnityGrammarParser.NOT_EQUAL, 0); }
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitRelational_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitRelational_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_THAN) | (1L << GREATER_THAN) | (1L << LESS_OR_EQUAL) | (1L << GREATER_OR_EQUAL) | (1L << EQUAL) | (1L << NOT_EQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Add_minus_or_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(UnityGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(UnityGrammarParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(UnityGrammarParser.OR, 0); }
		public Add_minus_or_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_minus_or_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterAdd_minus_or_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitAdd_minus_or_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitAdd_minus_or_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_minus_or_operatorContext add_minus_or_operator() throws RecognitionException {
		Add_minus_or_operatorContext _localctx = new Add_minus_or_operatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_add_minus_or_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Times_div_mod_and_operatorContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(UnityGrammarParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(UnityGrammarParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(UnityGrammarParser.MOD, 0); }
		public TerminalNode AND() { return getToken(UnityGrammarParser.AND, 0); }
		public Times_div_mod_and_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_times_div_mod_and_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterTimes_div_mod_and_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitTimes_div_mod_and_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitTimes_div_mod_and_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Times_div_mod_and_operatorContext times_div_mod_and_operator() throws RecognitionException {
		Times_div_mod_and_operatorContext _localctx = new Times_div_mod_and_operatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_times_div_mod_and_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << TIMES) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(UnityGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(UnityGrammarParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(UnityGrammarParser.NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Quantification_operatorContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(UnityGrammarParser.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(UnityGrammarParser.TIMES, 0); }
		public TerminalNode AND() { return getToken(UnityGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(UnityGrammarParser.OR, 0); }
		public Quantification_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterQuantification_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitQuantification_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitQuantification_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quantification_operatorContext quantification_operator() throws RecognitionException {
		Quantification_operatorContext _localctx = new Quantification_operatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_quantification_operator);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				function();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(PLUS);
				}
				break;
			case TIMES:
				enterOuterAlt(_localctx, 3);
				{
				setState(370);
				match(TIMES);
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 4);
				{
				setState(371);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 5);
				{
				setState(372);
				match(OR);
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

	public static class TextContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UnityGrammarParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UnityGrammarParser.IDENTIFIER, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(UnityGrammarParser.INT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(INT);
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

	public static class IntegerValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(UnityGrammarParser.INTEGER, 0); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitIntegerValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitIntegerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerValueContext integerValue() throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_integerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(INTEGER);
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

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(UnityGrammarParser.BOOLEAN, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UnityGrammarListener ) ((UnityGrammarListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UnityGrammarVisitor ) return ((UnityGrammarVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_booleanValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(BOOLEAN);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0182\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\5\2e\n\2\3\2\5\2h\n"+
		"\2\3\2\5\2k\n\2\3\2\5\2n\n\2\3\2\3\2\3\2\3\3\3\3\5\3u\n\3\3\3\6\3x\n\3"+
		"\r\3\16\3y\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\u0083\n\5\f\5\16\5\u0086\13"+
		"\5\3\6\3\6\3\7\3\7\5\7\u008c\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009e\n\t\3\n\3\n\3\n\7\n\u00a3\n\n\f\n"+
		"\16\n\u00a6\13\n\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u00ae\n\f\3\r\3\r\5\r"+
		"\u00b2\n\r\3\r\3\r\3\16\3\16\5\16\u00b8\n\16\3\16\3\16\3\17\3\17\5\17"+
		"\u00be\n\17\3\17\3\17\3\20\3\20\3\20\7\20\u00c5\n\20\f\20\16\20\u00c8"+
		"\13\20\3\21\3\21\5\21\u00cc\n\21\3\22\3\22\3\22\7\22\u00d1\n\22\f\22\16"+
		"\22\u00d4\13\22\3\23\3\23\5\23\u00d8\n\23\3\24\3\24\3\24\3\24\5\24\u00de"+
		"\n\24\3\25\3\25\3\25\7\25\u00e3\n\25\f\25\16\25\u00e6\13\25\3\26\3\26"+
		"\3\26\7\26\u00eb\n\26\f\26\16\26\u00ee\13\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\7\27\u00f8\n\27\f\27\16\27\u00fb\13\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0114\n\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0121\n\34\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\7\36\u0129\n\36\f\36\16\36\u012c\13\36\3\37\3\37\3\37\3\37\7\37"+
		"\u0132\n\37\f\37\16\37\u0135\13\37\3 \3 \3 \7 \u013a\n \f \16 \u013d\13"+
		" \3!\3!\3!\3!\5!\u0143\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014c\n\"\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\7\'\u0163"+
		"\n\'\f\'\16\'\u0166\13\'\3(\5(\u0169\n(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-"+
		"\3-\3-\3-\5-\u0178\n-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\2\2\62\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`\2\t\3\2\t\n\4\2\33\33!!\3\2\35\"\4\2$$&\'\5\2##()++\3\2%\'\4"+
		"\2..\62\62\2\u017a\2b\3\2\2\2\4r\3\2\2\2\6{\3\2\2\2\b\177\3\2\2\2\n\u0087"+
		"\3\2\2\2\f\u008b\3\2\2\2\16\u008d\3\2\2\2\20\u009d\3\2\2\2\22\u009f\3"+
		"\2\2\2\24\u00a7\3\2\2\2\26\u00ad\3\2\2\2\30\u00af\3\2\2\2\32\u00b5\3\2"+
		"\2\2\34\u00bb\3\2\2\2\36\u00c1\3\2\2\2 \u00cb\3\2\2\2\"\u00cd\3\2\2\2"+
		"$\u00d7\3\2\2\2&\u00d9\3\2\2\2(\u00df\3\2\2\2*\u00e7\3\2\2\2,\u00ef\3"+
		"\2\2\2.\u00fc\3\2\2\2\60\u0102\3\2\2\2\62\u0108\3\2\2\2\64\u0113\3\2\2"+
		"\2\66\u0120\3\2\2\28\u0122\3\2\2\2:\u0124\3\2\2\2<\u012d\3\2\2\2>\u0136"+
		"\3\2\2\2@\u0142\3\2\2\2B\u014b\3\2\2\2D\u014d\3\2\2\2F\u0152\3\2\2\2H"+
		"\u0156\3\2\2\2J\u015b\3\2\2\2L\u015f\3\2\2\2N\u0168\3\2\2\2P\u016a\3\2"+
		"\2\2R\u016c\3\2\2\2T\u016e\3\2\2\2V\u0170\3\2\2\2X\u0177\3\2\2\2Z\u0179"+
		"\3\2\2\2\\\u017b\3\2\2\2^\u017d\3\2\2\2`\u017f\3\2\2\2bd\7\3\2\2ce\5Z"+
		".\2dc\3\2\2\2de\3\2\2\2eg\3\2\2\2fh\5\4\3\2gf\3\2\2\2gh\3\2\2\2hj\3\2"+
		"\2\2ik\5\30\r\2ji\3\2\2\2jk\3\2\2\2km\3\2\2\2ln\5\32\16\2ml\3\2\2\2mn"+
		"\3\2\2\2no\3\2\2\2op\5\34\17\2pq\7\b\2\2q\3\3\2\2\2rt\7\4\2\2su\7\16\2"+
		"\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2\2vx\5\6\4\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2"+
		"\2yz\3\2\2\2z\5\3\2\2\2{|\5\b\5\2|}\7\16\2\2}~\5\f\7\2~\7\3\2\2\2\177"+
		"\u0084\5\n\6\2\u0080\u0081\7\20\2\2\u0081\u0083\5\n\6\2\u0082\u0080\3"+
		"\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\t\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7.\2\2\u0088\13\3\2\2\2\u0089"+
		"\u008c\5\16\b\2\u008a\u008c\5\20\t\2\u008b\u0089\3\2\2\2\u008b\u008a\3"+
		"\2\2\2\u008c\r\3\2\2\2\u008d\u008e\t\2\2\2\u008e\17\3\2\2\2\u008f\u0090"+
		"\7\13\2\2\u0090\u0091\7\23\2\2\u0091\u0092\5\22\n\2\u0092\u0093\7\24\2"+
		"\2\u0093\u0094\7\f\2\2\u0094\u0095\5\20\t\2\u0095\u009e\3\2\2\2\u0096"+
		"\u0097\7\13\2\2\u0097\u0098\7\23\2\2\u0098\u0099\5\22\n\2\u0099\u009a"+
		"\7\24\2\2\u009a\u009b\7\f\2\2\u009b\u009c\5\16\b\2\u009c\u009e\3\2\2\2"+
		"\u009d\u008f\3\2\2\2\u009d\u0096\3\2\2\2\u009e\21\3\2\2\2\u009f\u00a4"+
		"\5\24\13\2\u00a0\u00a1\7\20\2\2\u00a1\u00a3\5\24\13\2\u00a2\u00a0\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\23\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\26"+
		"\2\2\u00a9\u00aa\5\26\f\2\u00aa\25\3\2\2\2\u00ab\u00ae\5\\/\2\u00ac\u00ae"+
		"\7.\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\27\3\2\2\2\u00af"+
		"\u00b1\7\5\2\2\u00b0\u00b2\7\16\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\5\36\20\2\u00b4\31\3\2\2\2\u00b5"+
		"\u00b7\7\6\2\2\u00b6\u00b8\7\16\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\5\36\20\2\u00ba\33\3\2\2\2\u00bb"+
		"\u00bd\7\7\2\2\u00bc\u00be\7\16\2\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3"+
		"\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\5\36\20\2\u00c0\35\3\2\2\2\u00c1"+
		"\u00c6\5 \21\2\u00c2\u00c3\7\27\2\2\u00c3\u00c5\5 \21\2\u00c4\u00c2\3"+
		"\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\37\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\5\"\22\2\u00ca\u00cc\5.\30"+
		"\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc!\3\2\2\2\u00cd\u00d2"+
		"\5$\23\2\u00ce\u00cf\7\30\2\2\u00cf\u00d1\5$\23\2\u00d0\u00ce\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3#\3"+
		"\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\5&\24\2\u00d6\u00d8\5\60\31\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8%\3\2\2\2\u00d9\u00da\5(\25\2"+
		"\u00da\u00dd\t\3\2\2\u00db\u00de\5*\26\2\u00dc\u00de\5,\27\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\'\3\2\2\2\u00df\u00e4\5\64\33\2\u00e0"+
		"\u00e1\7\20\2\2\u00e1\u00e3\5\64\33\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5)\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00ec\5\66\34\2\u00e8\u00e9\7\20\2\2\u00e9\u00eb"+
		"\5\66\34\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed+\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\5"+
		"*\26\2\u00f0\u00f1\7\r\2\2\u00f1\u00f9\58\35\2\u00f2\u00f3\7\34\2\2\u00f3"+
		"\u00f4\5*\26\2\u00f4\u00f5\7\r\2\2\u00f5\u00f6\58\35\2\u00f6\u00f8\3\2"+
		"\2\2\u00f7\u00f2\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa-\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7\31\2\2"+
		"\u00fd\u00fe\7\27\2\2\u00fe\u00ff\5\62\32\2\u00ff\u0100\5\36\20\2\u0100"+
		"\u0101\7\32\2\2\u0101/\3\2\2\2\u0102\u0103\7\31\2\2\u0103\u0104\7\30\2"+
		"\2\u0104\u0105\5\62\32\2\u0105\u0106\5\"\22\2\u0106\u0107\7\32\2\2\u0107"+
		"\61\3\2\2\2\u0108\u0109\5(\25\2\u0109\u010a\7\16\2\2\u010a\u010b\58\35"+
		"\2\u010b\u010c\7\17\2\2\u010c\63\3\2\2\2\u010d\u0114\5\n\6\2\u010e\u010f"+
		"\5\n\6\2\u010f\u0110\7\23\2\2\u0110\u0111\5*\26\2\u0111\u0112\7\24\2\2"+
		"\u0112\u0114\3\2\2\2\u0113\u010d\3\2\2\2\u0113\u010e\3\2\2\2\u0114\65"+
		"\3\2\2\2\u0115\u0121\5:\36\2\u0116\u0117\5:\36\2\u0117\u0118\5P)\2\u0118"+
		"\u0119\5:\36\2\u0119\u0121\3\2\2\2\u011a\u011b\5:\36\2\u011b\u011c\5P"+
		")\2\u011c\u011d\5:\36\2\u011d\u011e\5P)\2\u011e\u011f\5:\36\2\u011f\u0121"+
		"\3\2\2\2\u0120\u0115\3\2\2\2\u0120\u0116\3\2\2\2\u0120\u011a\3\2\2\2\u0121"+
		"\67\3\2\2\2\u0122\u0123\5\66\34\2\u01239\3\2\2\2\u0124\u012a\5<\37\2\u0125"+
		"\u0126\5R*\2\u0126\u0127\5<\37\2\u0127\u0129\3\2\2\2\u0128\u0125\3\2\2"+
		"\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b;"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0133\5> \2\u012e\u012f\5T+\2\u012f"+
		"\u0130\5> \2\u0130\u0132\3\2\2\2\u0131\u012e\3\2\2\2\u0132\u0135\3\2\2"+
		"\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134=\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0136\u013b\5@!\2\u0137\u0138\7*\2\2\u0138\u013a\5@!\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c?\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\5V,\2\u013f\u0140"+
		"\5B\"\2\u0140\u0143\3\2\2\2\u0141\u0143\5B\"\2\u0142\u013e\3\2\2\2\u0142"+
		"\u0141\3\2\2\2\u0143A\3\2\2\2\u0144\u014c\5\64\33\2\u0145\u014c\5`\61"+
		"\2\u0146\u014c\5^\60\2\u0147\u014c\5D#\2\u0148\u014c\5F$\2\u0149\u014c"+
		"\5H%\2\u014a\u014c\5J&\2\u014b\u0144\3\2\2\2\u014b\u0145\3\2\2\2\u014b"+
		"\u0146\3\2\2\2\u014b\u0147\3\2\2\2\u014b\u0148\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014b\u014a\3\2\2\2\u014cC\3\2\2\2\u014d\u014e\5L\'\2\u014e\u014f"+
		"\7\21\2\2\u014f\u0150\5*\26\2\u0150\u0151\7\22\2\2\u0151E\3\2\2\2\u0152"+
		"\u0153\7\21\2\2\u0153\u0154\5\66\34\2\u0154\u0155\7\22\2\2\u0155G\3\2"+
		"\2\2\u0156\u0157\7\31\2\2\u0157\u0158\5X-\2\u0158\u0159\5\62\32\2\u0159"+
		"\u015a\7\32\2\2\u015aI\3\2\2\2\u015b\u015c\7\23\2\2\u015c\u015d\5N(\2"+
		"\u015d\u015e\7\24\2\2\u015eK\3\2\2\2\u015f\u0164\7.\2\2\u0160\u0161\7"+
		"\25\2\2\u0161\u0163\7.\2\2\u0162\u0160\3\2\2\2\u0163\u0166\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165M\3\2\2\2\u0166\u0164\3\2\2\2"+
		"\u0167\u0169\5*\26\2\u0168\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169O\3"+
		"\2\2\2\u016a\u016b\t\4\2\2\u016bQ\3\2\2\2\u016c\u016d\t\5\2\2\u016dS\3"+
		"\2\2\2\u016e\u016f\t\6\2\2\u016fU\3\2\2\2\u0170\u0171\t\7\2\2\u0171W\3"+
		"\2\2\2\u0172\u0178\5L\'\2\u0173\u0178\7&\2\2\u0174\u0178\7(\2\2\u0175"+
		"\u0178\7#\2\2\u0176\u0178\7$\2\2\u0177\u0172\3\2\2\2\u0177\u0173\3\2\2"+
		"\2\u0177\u0174\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178Y"+
		"\3\2\2\2\u0179\u017a\t\b\2\2\u017a[\3\2\2\2\u017b\u017c\7,\2\2\u017c]"+
		"\3\2\2\2\u017d\u017e\7\n\2\2\u017e_\3\2\2\2\u017f\u0180\7\t\2\2\u0180"+
		"a\3\2\2\2\"dgjmty\u0084\u008b\u009d\u00a4\u00ad\u00b1\u00b7\u00bd\u00c6"+
		"\u00cb\u00d2\u00d7\u00dd\u00e4\u00ec\u00f9\u0113\u0120\u012a\u0133\u013b"+
		"\u0142\u014b\u0164\u0168\u0177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}