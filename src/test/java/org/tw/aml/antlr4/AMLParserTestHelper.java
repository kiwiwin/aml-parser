package org.tw.aml.antlr4;

import org.antlr.v4.runtime.ParserRuleContext;
import org.tw.aml.api.AML;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AMLParserTestHelper {

    public static AMLParser.AmlContext getAml(String text) throws IOException {
        return AML.getAmlParser(text).aml();
    }


    public static void assertNodeText(ParserRuleContext parseTree, String text) {
        assertThat(parseTree.getText(), is(text));
        assertThat(parseTree.exception, nullValue());
    }

}
