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
		BOOLEAN=1, DOUBLE=2, ID=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'"
	};
	public static final String[] ruleNames = {
		"BOOLEAN", "DOUBLE", "ID", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5\61\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\25\n"+
		"\2\3\3\6\3\30\n\3\r\3\16\3\31\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\3\3"+
		"\3\6\3%\n\3\r\3\16\3&\5\3)\n\3\3\4\6\4,\n\4\r\4\16\4-\3\5\3\5\2\2\6\3"+
		"\3\5\4\7\5\t\2\3\2\4\6\2\62;C\\aac|\3\2\62;\65\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\3\24\3\2\2\2\5(\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\f\7v\2\2"+
		"\f\r\7t\2\2\r\16\7w\2\2\16\25\7g\2\2\17\20\7h\2\2\20\21\7c\2\2\21\22\7"+
		"n\2\2\22\23\7u\2\2\23\25\7g\2\2\24\13\3\2\2\2\24\17\3\2\2\2\25\4\3\2\2"+
		"\2\26\30\5\t\5\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2"+
		"\2\32\33\3\2\2\2\33\37\7\60\2\2\34\36\5\t\5\2\35\34\3\2\2\2\36!\3\2\2"+
		"\2\37\35\3\2\2\2\37 \3\2\2\2 )\3\2\2\2!\37\3\2\2\2\"$\7\60\2\2#%\5\t\5"+
		"\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(\27\3\2\2\2(\""+
		"\3\2\2\2)\6\3\2\2\2*,\t\2\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2"+
		".\b\3\2\2\2/\60\t\3\2\2\60\n\3\2\2\2\t\2\24\31\37&(-\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}