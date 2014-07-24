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
		BOOLEAN=1, STRING=2, DOUBLE=3, ID=4;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'"
	};
	public static final String[] ruleNames = {
		"BOOLEAN", "STRING", "DOUBLE", "ID", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\6<\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2"+
		"\27\n\2\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\3\3\3\3\4\6\4#\n\4\r\4\16"+
		"\4$\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\6\4\60\n\4\r\4\16\4\61\5\4"+
		"\64\n\4\3\5\6\5\67\n\5\r\5\16\58\3\6\3\6\3\34\2\7\3\3\5\4\7\5\t\6\13\2"+
		"\3\2\4\6\2\62;C\\aac|\3\2\62;A\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\3\26\3\2\2\2\5\30\3\2\2\2\7\63\3\2\2\2\t\66\3\2\2\2\13:\3\2\2"+
		"\2\r\16\7v\2\2\16\17\7t\2\2\17\20\7w\2\2\20\27\7g\2\2\21\22\7h\2\2\22"+
		"\23\7c\2\2\23\24\7n\2\2\24\25\7u\2\2\25\27\7g\2\2\26\r\3\2\2\2\26\21\3"+
		"\2\2\2\27\4\3\2\2\2\30\34\7$\2\2\31\33\13\2\2\2\32\31\3\2\2\2\33\36\3"+
		"\2\2\2\34\35\3\2\2\2\34\32\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7$"+
		"\2\2 \6\3\2\2\2!#\5\13\6\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%"+
		"&\3\2\2\2&*\7\60\2\2\')\5\13\6\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2"+
		"\2\2+\64\3\2\2\2,*\3\2\2\2-/\7\60\2\2.\60\5\13\6\2/.\3\2\2\2\60\61\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\"\3\2\2\2\63-\3\2\2\2"+
		"\64\b\3\2\2\2\65\67\t\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3"+
		"\2\2\29\n\3\2\2\2:;\t\3\2\2;\f\3\2\2\2\n\2\26\34$*\61\638\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}