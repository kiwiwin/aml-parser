package org.tw.aml;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.tw.aml.antlr4.AMLLexer;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AMLParserTestHelper {

    public static AMLParser getAmlParser(String text) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(new StringReader(text));
        final AMLLexer lexer = new AMLLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new AMLParser(tokens);
    }

    public static void assertNodeText(ParserRuleContext parseTree, String text) {
        assertThat(parseTree.getText(), is(text));
        assertThat(parseTree.exception, nullValue());
    }

}
