// Generated from AML.g4 by ANTLR 4.3
package org.tw.aml.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, INT=2, STRING=3, DOUBLE=4, ID=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'"
	};
	public static final String[] ruleNames = {
		"BOOLEAN", "INT", "STRING", "DOUBLE", "ID", "DIGIT"
	};


	public AMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AML.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7C\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\31\n\2\3\3\6\3\34\n\3\r\3\16\3\35\3\4\3\4\7\4\"\n\4\f\4\16\4"+
		"%\13\4\3\4\3\4\3\5\6\5*\n\5\r\5\16\5+\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13"+
		"\5\3\5\3\5\6\5\67\n\5\r\5\16\58\5\5;\n\5\3\6\6\6>\n\6\r\6\16\6?\3\7\3"+
		"\7\3#\2\b\3\3\5\4\7\5\t\6\13\7\r\2\3\2\4\6\2\62;C\\aac|\3\2\62;I\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\30\3\2\2\2\5"+
		"\33\3\2\2\2\7\37\3\2\2\2\t:\3\2\2\2\13=\3\2\2\2\rA\3\2\2\2\17\20\7v\2"+
		"\2\20\21\7t\2\2\21\22\7w\2\2\22\31\7g\2\2\23\24\7h\2\2\24\25\7c\2\2\25"+
		"\26\7n\2\2\26\27\7u\2\2\27\31\7g\2\2\30\17\3\2\2\2\30\23\3\2\2\2\31\4"+
		"\3\2\2\2\32\34\5\r\7\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36"+
		"\3\2\2\2\36\6\3\2\2\2\37#\7$\2\2 \"\13\2\2\2! \3\2\2\2\"%\3\2\2\2#$\3"+
		"\2\2\2#!\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7$\2\2\'\b\3\2\2\2(*\5\r\7\2)"+
		"(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-\61\7\60\2\2.\60\5\r"+
		"\7\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62;\3\2\2\2\63"+
		"\61\3\2\2\2\64\66\7\60\2\2\65\67\5\r\7\2\66\65\3\2\2\2\678\3\2\2\28\66"+
		"\3\2\2\289\3\2\2\29;\3\2\2\2:)\3\2\2\2:\64\3\2\2\2;\n\3\2\2\2<>\t\2\2"+
		"\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\f\3\2\2\2AB\t\3\2\2B\16\3"+
		"\2\2\2\13\2\30\35#+\618:?\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}