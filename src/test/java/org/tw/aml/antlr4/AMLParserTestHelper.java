package org.tw.aml.antlr4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tw.aml.antlr4.AMLLexer;
import org.tw.aml.antlr4.AMLParser;
import org.tw.aml.api.AMLObject;
import org.tw.aml.api.AMLObjectListener;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

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

    public static AMLParser.AmlContext getAml(String text) throws IOException {
        return getAmlParser(text).aml();
    }


    public static void assertNodeText(ParserRuleContext parseTree, String text) {
        assertThat(parseTree.getText(), is(text));
        assertThat(parseTree.exception, nullValue());
    }

    public static List<AMLObject> getAmlObjects(String text) throws IOException {
        final AMLParser amlParser = getAmlParser(text);
        final AMLObjectListener amlListener = new AMLObjectListener();
        final ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(amlListener, amlParser.aml());

        return amlListener.getObjects();
    }
}
