package org.tw.aml;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.Test;
import org.tw.aml.antlr4.AMLLexer;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AMLTProductParserTest {

    @Test
    public void should_get_multi_products() throws IOException {
        final AMLParser.AmlContext aml = getAml("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }" +
                "puid 8044 extends Drive {" +
                "type=\"BABA\";" +
                "}");

        assertThat(aml.product().size(), is(2));
    }

    @Test
    public void should_get_product() throws IOException {
        final AMLParser.ProductContext product = getProduct("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        assertThat(product.puid().getText(), is("8033"));
        assertThat(product.productType().getText(), is("Drive"));

        assertThat(product.property().size(), is(1));
        assertThat(product.property(0).propertyKey().getText(), is("type"));
        assertThat(product.property(0).propertyValue().getText(), is("\"SATA\""));
    }


    private AMLParser.AmlContext getAml(String text) throws IOException {
        return getAmlParser(text).aml();
    }

    private AMLParser.ProductContext getProduct(String text) throws IOException {
        return getAmlParser(text).product();
    }

    private AMLParser getAmlParser(String text) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(new StringReader(text));
        final AMLLexer lexer = new AMLLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new AMLParser(tokens);
    }

    private void assertNodeText(ParserRuleContext parseTree, String text) {
        assertThat(parseTree.getText(), is(text));
        assertThat(parseTree.exception, nullValue());
    }
}
