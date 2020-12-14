// Generated from C:/Users/boris/OneDrive/Poèítaè/mAIN 2019-20/Diplomová práca/unityToJava/src/main/antlr4\UnityGrammar.g4 by ANTLR 4.9
package silny7.uniba.sk;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UnityGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, DECLARE=2, ALWAYS=3, INITIALLY=4, ASSIGN=5, END=6, BOOLEAN=7, 
		INTEGER=8, ARRAY=9, OF=10, IF=11, COLON=12, DOUBLE_COLON=13, SEMI_COLON=14, 
		COMMA=15, OPEN_PARENTHESES=16, CLOSE_PARENTHESES=17, OPEN_BRACKET=18, 
		CLOSE_BRACKET=19, DOT=20, DOUBLE_DOT=21, NONDETERM_SEPARATOR=22, DETERM_SEPARATOR=23, 
		QUANTIFICATION_OPEN=24, QUANTIFICATION_CLOSE=25, ASSIGN_SIGN=26, TILDE=27, 
		LESS_THAN=28, GREATER_THAN=29, LESS_OR_EQUAL=30, GREATER_OR_EQUAL=31, 
		EQUAL=32, NOT_EQUAL=33, AND=34, OR=35, NOT=36, PLUS=37, MINUS=38, TIMES=39, 
		DIV=40, POWER=41, MOD=42, INT=43, BOOL=44, IDENTIFIER=45, WS=46, LINE_COMMENT=47, 
		BLOCK_COMMENT=48, STRING=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAM", "DECLARE", "ALWAYS", "INITIALLY", "ASSIGN", "END", "BOOLEAN", 
			"INTEGER", "ARRAY", "OF", "IF", "COLON", "DOUBLE_COLON", "SEMI_COLON", 
			"COMMA", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"DOT", "DOUBLE_DOT", "NONDETERM_SEPARATOR", "DETERM_SEPARATOR", "QUANTIFICATION_OPEN", 
			"QUANTIFICATION_CLOSE", "ASSIGN_SIGN", "TILDE", "LESS_THAN", "GREATER_THAN", 
			"LESS_OR_EQUAL", "GREATER_OR_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", 
			"NOT", "PLUS", "MINUS", "TIMES", "DIV", "POWER", "MOD", "DIGIT", "LETTER", 
			"INT", "BOOL", "IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "STRING", 
			"ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"':'", "'::'", "';'", "','", "'('", "')'", "'['", "']'", "'.'", "'..'", 
			"'[]'", "'||'", "'<<'", "'>>'", "':='", "'~'", "'<'", "'>'", "'<='", 
			"'>='", "'='", "'!='", null, null, null, "'+'", "'-'", "'*'", null, "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "DECLARE", "ALWAYS", "INITIALLY", "ASSIGN", "END", "BOOLEAN", 
			"INTEGER", "ARRAY", "OF", "IF", "COLON", "DOUBLE_COLON", "SEMI_COLON", 
			"COMMA", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"DOT", "DOUBLE_DOT", "NONDETERM_SEPARATOR", "DETERM_SEPARATOR", "QUANTIFICATION_OPEN", 
			"QUANTIFICATION_CLOSE", "ASSIGN_SIGN", "TILDE", "LESS_THAN", "GREATER_THAN", 
			"LESS_OR_EQUAL", "GREATER_OR_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", 
			"NOT", "PLUS", "MINUS", "TIMES", "DIV", "POWER", "MOD", "INT", "BOOL", 
			"IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public UnityGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UnityGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0081\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0091\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4\u009f\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00b3\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c1\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00c9\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00d9\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u00e9\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00f5\n\n\3\13"+
		"\3\13\3\13\3\13\5\13\u00fb\n\13\3\f\3\f\3\f\3\f\5\f\u0101\n\f\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u013f\n#\3"+
		"$\3$\3$\3$\5$\u0145\n$\3%\3%\3%\3%\3%\3%\5%\u014d\n%\3&\3&\3\'\3\'\3("+
		"\3(\3)\3)\3)\3)\3)\3)\3)\5)\u015c\n)\3*\3*\3+\3+\3+\3+\3+\3+\5+\u0166"+
		"\n+\3,\3,\3-\3-\3.\5.\u016d\n.\3.\6.\u0170\n.\r.\16.\u0171\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0186\n/\3\60\3\60\3\60"+
		"\7\60\u018b\n\60\f\60\16\60\u018e\13\60\3\61\6\61\u0191\n\61\r\61\16\61"+
		"\u0192\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u019b\n\62\f\62\16\62\u019e"+
		"\13\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u01a6\n\63\f\63\16\63\u01a9"+
		"\13\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\7\64\u01b3\n\64\f\64\16"+
		"\64\u01b6\13\64\3\64\3\64\3\65\3\65\3\65\4\u01a7\u01b4\2\66\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W\2Y\2[-]._/a\60c\61e\62g\63i\2\3\2\6\5\2C\\aac|\5"+
		"\2\13\f\17\17\"\"\4\2\f\f\17\17\b\2$$^^ddppttvv\2\u01d6\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\3\u0080\3\2\2\2\5\u0090\3\2\2\2\7\u009e\3\2\2\2\t\u00b2\3\2\2\2\13"+
		"\u00c0\3\2\2\2\r\u00c8\3\2\2\2\17\u00d8\3\2\2\2\21\u00e8\3\2\2\2\23\u00f4"+
		"\3\2\2\2\25\u00fa\3\2\2\2\27\u0100\3\2\2\2\31\u0102\3\2\2\2\33\u0104\3"+
		"\2\2\2\35\u0107\3\2\2\2\37\u0109\3\2\2\2!\u010b\3\2\2\2#\u010d\3\2\2\2"+
		"%\u010f\3\2\2\2\'\u0111\3\2\2\2)\u0113\3\2\2\2+\u0115\3\2\2\2-\u0118\3"+
		"\2\2\2/\u011b\3\2\2\2\61\u011e\3\2\2\2\63\u0121\3\2\2\2\65\u0124\3\2\2"+
		"\2\67\u0127\3\2\2\29\u0129\3\2\2\2;\u012b\3\2\2\2=\u012d\3\2\2\2?\u0130"+
		"\3\2\2\2A\u0133\3\2\2\2C\u0135\3\2\2\2E\u013e\3\2\2\2G\u0144\3\2\2\2I"+
		"\u014c\3\2\2\2K\u014e\3\2\2\2M\u0150\3\2\2\2O\u0152\3\2\2\2Q\u015b\3\2"+
		"\2\2S\u015d\3\2\2\2U\u0165\3\2\2\2W\u0167\3\2\2\2Y\u0169\3\2\2\2[\u016c"+
		"\3\2\2\2]\u0185\3\2\2\2_\u0187\3\2\2\2a\u0190\3\2\2\2c\u0196\3\2\2\2e"+
		"\u01a1\3\2\2\2g\u01af\3\2\2\2i\u01b9\3\2\2\2kl\7R\2\2lm\7T\2\2mn\7Q\2"+
		"\2no\7I\2\2op\7T\2\2pq\7C\2\2q\u0081\7O\2\2rs\7r\2\2st\7t\2\2tu\7q\2\2"+
		"uv\7i\2\2vw\7t\2\2wx\7c\2\2x\u0081\7o\2\2yz\7R\2\2z{\7t\2\2{|\7q\2\2|"+
		"}\7i\2\2}~\7t\2\2~\177\7c\2\2\177\u0081\7o\2\2\u0080k\3\2\2\2\u0080r\3"+
		"\2\2\2\u0080y\3\2\2\2\u0081\4\3\2\2\2\u0082\u0083\7F\2\2\u0083\u0084\7"+
		"G\2\2\u0084\u0085\7E\2\2\u0085\u0086\7N\2\2\u0086\u0087\7C\2\2\u0087\u0088"+
		"\7T\2\2\u0088\u0091\7G\2\2\u0089\u008a\7f\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008c\7e\2\2\u008c\u008d\7n\2\2\u008d\u008e\7c\2\2\u008e\u008f\7t\2\2"+
		"\u008f\u0091\7g\2\2\u0090\u0082\3\2\2\2\u0090\u0089\3\2\2\2\u0091\6\3"+
		"\2\2\2\u0092\u0093\7C\2\2\u0093\u0094\7N\2\2\u0094\u0095\7Y\2\2\u0095"+
		"\u0096\7C\2\2\u0096\u0097\7[\2\2\u0097\u009f\7U\2\2\u0098\u0099\7c\2\2"+
		"\u0099\u009a\7n\2\2\u009a\u009b\7y\2\2\u009b\u009c\7c\2\2\u009c\u009d"+
		"\7{\2\2\u009d\u009f\7u\2\2\u009e\u0092\3\2\2\2\u009e\u0098\3\2\2\2\u009f"+
		"\b\3\2\2\2\u00a0\u00a1\7K\2\2\u00a1\u00a2\7P\2\2\u00a2\u00a3\7K\2\2\u00a3"+
		"\u00a4\7V\2\2\u00a4\u00a5\7K\2\2\u00a5\u00a6\7C\2\2\u00a6\u00a7\7N\2\2"+
		"\u00a7\u00a8\7N\2\2\u00a8\u00b3\7[\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab"+
		"\7p\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7k\2\2\u00ae"+
		"\u00af\7c\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b3\7{\2\2"+
		"\u00b2\u00a0\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b3\n\3\2\2\2\u00b4\u00b5\7"+
		"C\2\2\u00b5\u00b6\7U\2\2\u00b6\u00b7\7U\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9"+
		"\7I\2\2\u00b9\u00c1\7P\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7u\2\2\u00bc"+
		"\u00bd\7u\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7i\2\2\u00bf\u00c1\7p\2\2"+
		"\u00c0\u00b4\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c1\f\3\2\2\2\u00c2\u00c3\7"+
		"G\2\2\u00c3\u00c4\7P\2\2\u00c4\u00c9\7F\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7"+
		"\7p\2\2\u00c7\u00c9\7f\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9"+
		"\16\3\2\2\2\u00ca\u00cb\7D\2\2\u00cb\u00cc\7Q\2\2\u00cc\u00cd\7Q\2\2\u00cd"+
		"\u00ce\7N\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7C\2\2\u00d0\u00d9\7P\2\2"+
		"\u00d1\u00d2\7d\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d9\7p\2\2\u00d8"+
		"\u00ca\3\2\2\2\u00d8\u00d1\3\2\2\2\u00d9\20\3\2\2\2\u00da\u00db\7K\2\2"+
		"\u00db\u00dc\7P\2\2\u00dc\u00dd\7V\2\2\u00dd\u00de\7G\2\2\u00de\u00df"+
		"\7I\2\2\u00df\u00e0\7G\2\2\u00e0\u00e9\7T\2\2\u00e1\u00e2\7k\2\2\u00e2"+
		"\u00e3\7p\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7i\2\2"+
		"\u00e6\u00e7\7g\2\2\u00e7\u00e9\7t\2\2\u00e8\u00da\3\2\2\2\u00e8\u00e1"+
		"\3\2\2\2\u00e9\22\3\2\2\2\u00ea\u00eb\7C\2\2\u00eb\u00ec\7T\2\2\u00ec"+
		"\u00ed\7T\2\2\u00ed\u00ee\7C\2\2\u00ee\u00f5\7[\2\2\u00ef\u00f0\7c\2\2"+
		"\u00f0\u00f1\7t\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f5"+
		"\7{\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f5\24\3\2\2\2\u00f6"+
		"\u00f7\7Q\2\2\u00f7\u00fb\7H\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fb\7h\2\2"+
		"\u00fa\u00f6\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\26\3\2\2\2\u00fc\u00fd"+
		"\7K\2\2\u00fd\u0101\7H\2\2\u00fe\u00ff\7k\2\2\u00ff\u0101\7h\2\2\u0100"+
		"\u00fc\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\30\3\2\2\2\u0102\u0103\7<\2\2"+
		"\u0103\32\3\2\2\2\u0104\u0105\7<\2\2\u0105\u0106\7<\2\2\u0106\34\3\2\2"+
		"\2\u0107\u0108\7=\2\2\u0108\36\3\2\2\2\u0109\u010a\7.\2\2\u010a \3\2\2"+
		"\2\u010b\u010c\7*\2\2\u010c\"\3\2\2\2\u010d\u010e\7+\2\2\u010e$\3\2\2"+
		"\2\u010f\u0110\7]\2\2\u0110&\3\2\2\2\u0111\u0112\7_\2\2\u0112(\3\2\2\2"+
		"\u0113\u0114\7\60\2\2\u0114*\3\2\2\2\u0115\u0116\7\60\2\2\u0116\u0117"+
		"\7\60\2\2\u0117,\3\2\2\2\u0118\u0119\7]\2\2\u0119\u011a\7_\2\2\u011a."+
		"\3\2\2\2\u011b\u011c\7~\2\2\u011c\u011d\7~\2\2\u011d\60\3\2\2\2\u011e"+
		"\u011f\7>\2\2\u011f\u0120\7>\2\2\u0120\62\3\2\2\2\u0121\u0122\7@\2\2\u0122"+
		"\u0123\7@\2\2\u0123\64\3\2\2\2\u0124\u0125\7<\2\2\u0125\u0126\7?\2\2\u0126"+
		"\66\3\2\2\2\u0127\u0128\7\u0080\2\2\u01288\3\2\2\2\u0129\u012a\7>\2\2"+
		"\u012a:\3\2\2\2\u012b\u012c\7@\2\2\u012c<\3\2\2\2\u012d\u012e\7>\2\2\u012e"+
		"\u012f\7?\2\2\u012f>\3\2\2\2\u0130\u0131\7@\2\2\u0131\u0132\7?\2\2\u0132"+
		"@\3\2\2\2\u0133\u0134\7?\2\2\u0134B\3\2\2\2\u0135\u0136\7#\2\2\u0136\u0137"+
		"\7?\2\2\u0137D\3\2\2\2\u0138\u0139\7C\2\2\u0139\u013a\7P\2\2\u013a\u013f"+
		"\7F\2\2\u013b\u013c\7c\2\2\u013c\u013d\7p\2\2\u013d\u013f\7f\2\2\u013e"+
		"\u0138\3\2\2\2\u013e\u013b\3\2\2\2\u013fF\3\2\2\2\u0140\u0141\7Q\2\2\u0141"+
		"\u0145\7T\2\2\u0142\u0143\7q\2\2\u0143\u0145\7t\2\2\u0144\u0140\3\2\2"+
		"\2\u0144\u0142\3\2\2\2\u0145H\3\2\2\2\u0146\u0147\7P\2\2\u0147\u0148\7"+
		"Q\2\2\u0148\u014d\7V\2\2\u0149\u014a\7p\2\2\u014a\u014b\7q\2\2\u014b\u014d"+
		"\7v\2\2\u014c\u0146\3\2\2\2\u014c\u0149\3\2\2\2\u014dJ\3\2\2\2\u014e\u014f"+
		"\7-\2\2\u014fL\3\2\2\2\u0150\u0151\7/\2\2\u0151N\3\2\2\2\u0152\u0153\7"+
		",\2\2\u0153P\3\2\2\2\u0154\u015c\7\61\2\2\u0155\u0156\7F\2\2\u0156\u0157"+
		"\7K\2\2\u0157\u015c\7X\2\2\u0158\u0159\7f\2\2\u0159\u015a\7k\2\2\u015a"+
		"\u015c\7x\2\2\u015b\u0154\3\2\2\2\u015b\u0155\3\2\2\2\u015b\u0158\3\2"+
		"\2\2\u015cR\3\2\2\2\u015d\u015e\7`\2\2\u015eT\3\2\2\2\u015f\u0160\7O\2"+
		"\2\u0160\u0161\7Q\2\2\u0161\u0166\7F\2\2\u0162\u0163\7o\2\2\u0163\u0164"+
		"\7q\2\2\u0164\u0166\7f\2\2\u0165\u015f\3\2\2\2\u0165\u0162\3\2\2\2\u0166"+
		"V\3\2\2\2\u0167\u0168\4\62;\2\u0168X\3\2\2\2\u0169\u016a\t\2\2\2\u016a"+
		"Z\3\2\2\2\u016b\u016d\7/\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u0170\5W,\2\u016f\u016e\3\2\2\2\u0170\u0171\3\2\2"+
		"\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\\\3\2\2\2\u0173\u0174"+
		"\7v\2\2\u0174\u0175\7t\2\2\u0175\u0176\7w\2\2\u0176\u0186\7g\2\2\u0177"+
		"\u0178\7h\2\2\u0178\u0179\7c\2\2\u0179\u017a\7n\2\2\u017a\u017b\7u\2\2"+
		"\u017b\u0186\7g\2\2\u017c\u017d\7V\2\2\u017d\u017e\7T\2\2\u017e\u017f"+
		"\7W\2\2\u017f\u0186\7G\2\2\u0180\u0181\7H\2\2\u0181\u0182\7C\2\2\u0182"+
		"\u0183\7N\2\2\u0183\u0184\7U\2\2\u0184\u0186\7G\2\2\u0185\u0173\3\2\2"+
		"\2\u0185\u0177\3\2\2\2\u0185\u017c\3\2\2\2\u0185\u0180\3\2\2\2\u0186^"+
		"\3\2\2\2\u0187\u018c\5Y-\2\u0188\u018b\5Y-\2\u0189\u018b\5W,\2\u018a\u0188"+
		"\3\2\2\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018d`\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0191\t\3\2\2"+
		"\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193"+
		"\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\b\61\2\2\u0195b\3\2\2\2\u0196"+
		"\u0197\7/\2\2\u0197\u0198\7/\2\2\u0198\u019c\3\2\2\2\u0199\u019b\n\4\2"+
		"\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\b\62\2\2"+
		"\u01a0d\3\2\2\2\u01a1\u01a2\7\61\2\2\u01a2\u01a3\7,\2\2\u01a3\u01a7\3"+
		"\2\2\2\u01a4\u01a6\13\2\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a7\3\2"+
		"\2\2\u01aa\u01ab\7,\2\2\u01ab\u01ac\7\61\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ae\b\63\2\2\u01aef\3\2\2\2\u01af\u01b4\7$\2\2\u01b0\u01b3\5i\65\2"+
		"\u01b1\u01b3\13\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6"+
		"\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01b8\7$\2\2\u01b8h\3\2\2\2\u01b9\u01ba\7^\2\2\u01ba"+
		"\u01bb\t\5\2\2\u01bbj\3\2\2\2\35\2\u0080\u0090\u009e\u00b2\u00c0\u00c8"+
		"\u00d8\u00e8\u00f4\u00fa\u0100\u013e\u0144\u014c\u015b\u0165\u016c\u0171"+
		"\u0185\u018a\u018c\u0192\u019c\u01a7\u01b2\u01b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}