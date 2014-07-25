package org.tw.aml.api;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.antlr4.AMLParserTestHelper.getAmlParser;

public class AMLObjectListenerTest {
    @Test
    public void should_get_one_object() throws IOException {
        final AMLParser amlParser = getAmlParser("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        final AMLObjectListener amlListener = new AMLObjectListener();

        final ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(amlListener, amlParser.aml());

        amlListener.getObjects();

        assertThat(amlListener.getObjects().size(), is(1));
    }
}
