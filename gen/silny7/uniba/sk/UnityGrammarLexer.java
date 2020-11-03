// Generated from C:/Users/boris/OneDrive/Poèítaè/mAIN 2019-20/Diplomová práca/unityToJava/src/main/antlr4\UnityGrammar.g4 by ANTLR 4.7
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PROGRAM", "DECLARE", "ALWAYS", "INITIALLY", "ASSIGN", "END", "BOOLEAN", 
		"INTEGER", "ARRAY", "OF", "IF", "COLON", "DOUBLE_COLON", "COMMA", "OPEN_PARENTHESES", 
		"CLOSE_PARENTHESES", "OPEN_BRACKET", "CLOSE_BRACKET", "DOT", "DOUBLE_DOT", 
		"NONDETERM_SEPARATOR", "DETERM_SEPARATOR", "QUANTIFICATION_OPEN", "QUANTIFICATION_CLOSE", 
		"ASSIGN_SIGN", "TILDE", "LESS_THAN", "GREATER_THAN", "LESS_OR_EQUAL", 
		"GREATER_OR_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", "NOT", "PLUS", 
		"MINUS", "TIMES", "DIV", "POWER", "MOD", "DIGIT", "LETTER", "INT", "BOOL", 
		"IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "ESC"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u01b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2x\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0088\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0096\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00aa"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b8\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u00c0\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00d0\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u00e0\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u00ec\n\n\3\13\3\13\3\13\3\13\5\13\u00f2\n\13\3\f\3\f\3\f\3\f"+
		"\5\f\u00f8\n\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u0134\n\"\3#\3#\3#\3#\5#\u013a\n#\3$\3$\3$\3$\3$\3$\5$\u0142"+
		"\n$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\5(\u0151\n(\3)\3)\3*\3*\3"+
		"*\3*\3*\3*\5*\u015b\n*\3+\3+\3,\3,\3-\5-\u0162\n-\3-\6-\u0165\n-\r-\16"+
		"-\u0166\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u017b"+
		"\n.\3/\3/\3/\7/\u0180\n/\f/\16/\u0183\13/\3\60\6\60\u0186\n\60\r\60\16"+
		"\60\u0187\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0190\n\61\f\61\16\61\u0193"+
		"\13\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u019b\n\62\f\62\16\62\u019e"+
		"\13\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\7\63\u01a8\n\63\f\63\16"+
		"\63\u01ab\13\63\3\63\3\63\3\64\3\64\3\64\4\u019c\u01a9\2\65\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U\2W\2Y,[-]._/a\60c\61e\62g\2\3\2\6\5\2C\\aac|\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\b\2$$^^ddppttvv\2\u01ca\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2"+
		"]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3w\3\2\2\2\5\u0087"+
		"\3\2\2\2\7\u0095\3\2\2\2\t\u00a9\3\2\2\2\13\u00b7\3\2\2\2\r\u00bf\3\2"+
		"\2\2\17\u00cf\3\2\2\2\21\u00df\3\2\2\2\23\u00eb\3\2\2\2\25\u00f1\3\2\2"+
		"\2\27\u00f7\3\2\2\2\31\u00f9\3\2\2\2\33\u00fb\3\2\2\2\35\u00fe\3\2\2\2"+
		"\37\u0100\3\2\2\2!\u0102\3\2\2\2#\u0104\3\2\2\2%\u0106\3\2\2\2\'\u0108"+
		"\3\2\2\2)\u010a\3\2\2\2+\u010d\3\2\2\2-\u0110\3\2\2\2/\u0113\3\2\2\2\61"+
		"\u0116\3\2\2\2\63\u0119\3\2\2\2\65\u011c\3\2\2\2\67\u011e\3\2\2\29\u0120"+
		"\3\2\2\2;\u0122\3\2\2\2=\u0125\3\2\2\2?\u0128\3\2\2\2A\u012a\3\2\2\2C"+
		"\u0133\3\2\2\2E\u0139\3\2\2\2G\u0141\3\2\2\2I\u0143\3\2\2\2K\u0145\3\2"+
		"\2\2M\u0147\3\2\2\2O\u0150\3\2\2\2Q\u0152\3\2\2\2S\u015a\3\2\2\2U\u015c"+
		"\3\2\2\2W\u015e\3\2\2\2Y\u0161\3\2\2\2[\u017a\3\2\2\2]\u017c\3\2\2\2_"+
		"\u0185\3\2\2\2a\u018b\3\2\2\2c\u0196\3\2\2\2e\u01a4\3\2\2\2g\u01ae\3\2"+
		"\2\2ij\7R\2\2jk\7T\2\2kl\7Q\2\2lm\7I\2\2mn\7T\2\2no\7C\2\2ox\7O\2\2pq"+
		"\7r\2\2qr\7t\2\2rs\7q\2\2st\7i\2\2tu\7t\2\2uv\7c\2\2vx\7o\2\2wi\3\2\2"+
		"\2wp\3\2\2\2x\4\3\2\2\2yz\7F\2\2z{\7G\2\2{|\7E\2\2|}\7N\2\2}~\7C\2\2~"+
		"\177\7T\2\2\177\u0088\7G\2\2\u0080\u0081\7f\2\2\u0081\u0082\7g\2\2\u0082"+
		"\u0083\7e\2\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7t\2\2"+
		"\u0086\u0088\7g\2\2\u0087y\3\2\2\2\u0087\u0080\3\2\2\2\u0088\6\3\2\2\2"+
		"\u0089\u008a\7C\2\2\u008a\u008b\7N\2\2\u008b\u008c\7Y\2\2\u008c\u008d"+
		"\7C\2\2\u008d\u008e\7[\2\2\u008e\u0096\7U\2\2\u008f\u0090\7c\2\2\u0090"+
		"\u0091\7n\2\2\u0091\u0092\7y\2\2\u0092\u0093\7c\2\2\u0093\u0094\7{\2\2"+
		"\u0094\u0096\7u\2\2\u0095\u0089\3\2\2\2\u0095\u008f\3\2\2\2\u0096\b\3"+
		"\2\2\2\u0097\u0098\7K\2\2\u0098\u0099\7P\2\2\u0099\u009a\7K\2\2\u009a"+
		"\u009b\7V\2\2\u009b\u009c\7K\2\2\u009c\u009d\7C\2\2\u009d\u009e\7N\2\2"+
		"\u009e\u009f\7N\2\2\u009f\u00aa\7[\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2"+
		"\7p\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7k\2\2\u00a5"+
		"\u00a6\7c\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7n\2\2\u00a8\u00aa\7{\2\2"+
		"\u00a9\u0097\3\2\2\2\u00a9\u00a0\3\2\2\2\u00aa\n\3\2\2\2\u00ab\u00ac\7"+
		"C\2\2\u00ac\u00ad\7U\2\2\u00ad\u00ae\7U\2\2\u00ae\u00af\7K\2\2\u00af\u00b0"+
		"\7I\2\2\u00b0\u00b8\7P\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7u\2\2\u00b3"+
		"\u00b4\7u\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7i\2\2\u00b6\u00b8\7p\2\2"+
		"\u00b7\u00ab\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b8\f\3\2\2\2\u00b9\u00ba\7"+
		"G\2\2\u00ba\u00bb\7P\2\2\u00bb\u00c0\7F\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7p\2\2\u00be\u00c0\7f\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0"+
		"\16\3\2\2\2\u00c1\u00c2\7D\2\2\u00c2\u00c3\7Q\2\2\u00c3\u00c4\7Q\2\2\u00c4"+
		"\u00c5\7N\2\2\u00c5\u00c6\7G\2\2\u00c6\u00c7\7C\2\2\u00c7\u00d0\7P\2\2"+
		"\u00c8\u00c9\7d\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc"+
		"\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7c\2\2\u00ce\u00d0\7p\2\2\u00cf"+
		"\u00c1\3\2\2\2\u00cf\u00c8\3\2\2\2\u00d0\20\3\2\2\2\u00d1\u00d2\7K\2\2"+
		"\u00d2\u00d3\7P\2\2\u00d3\u00d4\7V\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6"+
		"\7I\2\2\u00d6\u00d7\7G\2\2\u00d7\u00e0\7T\2\2\u00d8\u00d9\7k\2\2\u00d9"+
		"\u00da\7p\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7i\2\2"+
		"\u00dd\u00de\7g\2\2\u00de\u00e0\7t\2\2\u00df\u00d1\3\2\2\2\u00df\u00d8"+
		"\3\2\2\2\u00e0\22\3\2\2\2\u00e1\u00e2\7C\2\2\u00e2\u00e3\7T\2\2\u00e3"+
		"\u00e4\7T\2\2\u00e4\u00e5\7C\2\2\u00e5\u00ec\7[\2\2\u00e6\u00e7\7c\2\2"+
		"\u00e7\u00e8\7t\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7c\2\2\u00ea\u00ec"+
		"\7{\2\2\u00eb\u00e1\3\2\2\2\u00eb\u00e6\3\2\2\2\u00ec\24\3\2\2\2\u00ed"+
		"\u00ee\7Q\2\2\u00ee\u00f2\7H\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f2\7h\2\2"+
		"\u00f1\u00ed\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\26\3\2\2\2\u00f3\u00f4"+
		"\7K\2\2\u00f4\u00f8\7H\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f8\7h\2\2\u00f7"+
		"\u00f3\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\30\3\2\2\2\u00f9\u00fa\7<\2\2"+
		"\u00fa\32\3\2\2\2\u00fb\u00fc\7<\2\2\u00fc\u00fd\7<\2\2\u00fd\34\3\2\2"+
		"\2\u00fe\u00ff\7.\2\2\u00ff\36\3\2\2\2\u0100\u0101\7*\2\2\u0101 \3\2\2"+
		"\2\u0102\u0103\7+\2\2\u0103\"\3\2\2\2\u0104\u0105\7]\2\2\u0105$\3\2\2"+
		"\2\u0106\u0107\7_\2\2\u0107&\3\2\2\2\u0108\u0109\7\60\2\2\u0109(\3\2\2"+
		"\2\u010a\u010b\7\60\2\2\u010b\u010c\7\60\2\2\u010c*\3\2\2\2\u010d\u010e"+
		"\7]\2\2\u010e\u010f\7_\2\2\u010f,\3\2\2\2\u0110\u0111\7~\2\2\u0111\u0112"+
		"\7~\2\2\u0112.\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115\7>\2\2\u0115\60"+
		"\3\2\2\2\u0116\u0117\7@\2\2\u0117\u0118\7@\2\2\u0118\62\3\2\2\2\u0119"+
		"\u011a\7<\2\2\u011a\u011b\7?\2\2\u011b\64\3\2\2\2\u011c\u011d\7\u0080"+
		"\2\2\u011d\66\3\2\2\2\u011e\u011f\7>\2\2\u011f8\3\2\2\2\u0120\u0121\7"+
		"@\2\2\u0121:\3\2\2\2\u0122\u0123\7>\2\2\u0123\u0124\7?\2\2\u0124<\3\2"+
		"\2\2\u0125\u0126\7@\2\2\u0126\u0127\7?\2\2\u0127>\3\2\2\2\u0128\u0129"+
		"\7?\2\2\u0129@\3\2\2\2\u012a\u012b\7#\2\2\u012b\u012c\7?\2\2\u012cB\3"+
		"\2\2\2\u012d\u012e\7C\2\2\u012e\u012f\7P\2\2\u012f\u0134\7F\2\2\u0130"+
		"\u0131\7c\2\2\u0131\u0132\7p\2\2\u0132\u0134\7f\2\2\u0133\u012d\3\2\2"+
		"\2\u0133\u0130\3\2\2\2\u0134D\3\2\2\2\u0135\u0136\7Q\2\2\u0136\u013a\7"+
		"T\2\2\u0137\u0138\7q\2\2\u0138\u013a\7t\2\2\u0139\u0135\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013aF\3\2\2\2\u013b\u013c\7P\2\2\u013c\u013d\7Q\2\2\u013d"+
		"\u0142\7V\2\2\u013e\u013f\7p\2\2\u013f\u0140\7q\2\2\u0140\u0142\7v\2\2"+
		"\u0141\u013b\3\2\2\2\u0141\u013e\3\2\2\2\u0142H\3\2\2\2\u0143\u0144\7"+
		"-\2\2\u0144J\3\2\2\2\u0145\u0146\7/\2\2\u0146L\3\2\2\2\u0147\u0148\7,"+
		"\2\2\u0148N\3\2\2\2\u0149\u0151\7\61\2\2\u014a\u014b\7F\2\2\u014b\u014c"+
		"\7K\2\2\u014c\u0151\7X\2\2\u014d\u014e\7f\2\2\u014e\u014f\7k\2\2\u014f"+
		"\u0151\7x\2\2\u0150\u0149\3\2\2\2\u0150\u014a\3\2\2\2\u0150\u014d\3\2"+
		"\2\2\u0151P\3\2\2\2\u0152\u0153\7`\2\2\u0153R\3\2\2\2\u0154\u0155\7O\2"+
		"\2\u0155\u0156\7Q\2\2\u0156\u015b\7F\2\2\u0157\u0158\7o\2\2\u0158\u0159"+
		"\7q\2\2\u0159\u015b\7f\2\2\u015a\u0154\3\2\2\2\u015a\u0157\3\2\2\2\u015b"+
		"T\3\2\2\2\u015c\u015d\4\62;\2\u015dV\3\2\2\2\u015e\u015f\t\2\2\2\u015f"+
		"X\3\2\2\2\u0160\u0162\7/\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0164\3\2\2\2\u0163\u0165\5U+\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2"+
		"\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167Z\3\2\2\2\u0168\u0169"+
		"\7v\2\2\u0169\u016a\7t\2\2\u016a\u016b\7w\2\2\u016b\u017b\7g\2\2\u016c"+
		"\u016d\7h\2\2\u016d\u016e\7c\2\2\u016e\u016f\7n\2\2\u016f\u0170\7u\2\2"+
		"\u0170\u017b\7g\2\2\u0171\u0172\7V\2\2\u0172\u0173\7T\2\2\u0173\u0174"+
		"\7W\2\2\u0174\u017b\7G\2\2\u0175\u0176\7H\2\2\u0176\u0177\7C\2\2\u0177"+
		"\u0178\7N\2\2\u0178\u0179\7U\2\2\u0179\u017b\7G\2\2\u017a\u0168\3\2\2"+
		"\2\u017a\u016c\3\2\2\2\u017a\u0171\3\2\2\2\u017a\u0175\3\2\2\2\u017b\\"+
		"\3\2\2\2\u017c\u0181\5W,\2\u017d\u0180\5W,\2\u017e\u0180\5U+\2\u017f\u017d"+
		"\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182^\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\t\3\2\2"+
		"\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\60\2\2\u018a`\3\2\2\2\u018b"+
		"\u018c\7/\2\2\u018c\u018d\7/\2\2\u018d\u0191\3\2\2\2\u018e\u0190\n\4\2"+
		"\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192"+
		"\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\b\61\2\2"+
		"\u0195b\3\2\2\2\u0196\u0197\7\61\2\2\u0197\u0198\7,\2\2\u0198\u019c\3"+
		"\2\2\2\u0199\u019b\13\2\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2"+
		"\2\2\u019f\u01a0\7,\2\2\u01a0\u01a1\7\61\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a3\b\62\2\2\u01a3d\3\2\2\2\u01a4\u01a9\7$\2\2\u01a5\u01a8\5g\64\2"+
		"\u01a6\u01a8\13\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ac\u01ad\7$\2\2\u01adf\3\2\2\2\u01ae\u01af\7^\2\2\u01af"+
		"\u01b0\t\5\2\2\u01b0h\3\2\2\2\35\2w\u0087\u0095\u00a9\u00b7\u00bf\u00cf"+
		"\u00df\u00eb\u00f1\u00f7\u0133\u0139\u0141\u0150\u015a\u0161\u0166\u017a"+
		"\u017f\u0181\u0187\u0191\u019c\u01a7\u01a9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}