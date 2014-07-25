package org.tw.aml.api;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.antlr4.AMLParserTestHelper.getAmlParser;

public class AMLObjectListenerTest {
    @Test
    public void should_get_one_object() throws IOException {
        final List<AMLObject> amlObjects = getAmlObjects("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        assertThat(amlObjects.size(), is(1));

        final AMLObject amlObject = amlObjects.get(0);
        assertThat(amlObject.getProperties().size(), is(1));
    }

    private List<AMLObject> getAmlObjects(String text) throws IOException {
        final AMLParser amlParser = getAmlParser(text);
        final AMLObjectListener amlListener = new AMLObjectListener();
        final ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(amlListener, amlParser.aml());

        return amlListener.getObjects();
    }
}
