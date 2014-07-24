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
    public void should_get_product_puid() throws IOException {
        final AMLParser.ProductContext product = getProduct("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        assertThat(product.puid().getText(), is("8033"));
        assertThat(product.productType().getText(), is("Drive"));

        assertThat(product.property().size(), is(1));
        assertThat(product.property(0).propertyKey().getText(), is("type"));
        assertThat(product.property(0).propertyValue().getText(), is("\"SATA\""));
    }

    @Test
    public void should_get_product_property() throws IOException {
        final AMLParser.PropertyContext productProperty = getProperty("type=\"SATA\";");

        assertThat(productProperty.propertyKey().getText(), is("type"));
        assertThat(productProperty.propertyValue().getText(), is("\"SATA\""));
    }

    @Test
    public void should_get_product_property_key() throws IOException {
        assertNodeText(getProductPropertyKey("type"), "type");
    }

    @Test
    public void should_get_product_property_value_as_INT() throws IOException {
        assertNodeText(getProductPropertyValue("1234"), "1234");
    }

    @Test
    public void should_get_product_property_value_as_STRING() throws IOException {
        assertNodeText(getProductPropertyValue("\"SATA\""), "\"SATA\"");
    }

    @Test
    public void should_get_product_property_value_as_COLOR() throws IOException {
        assertNodeText(getProductPropertyValue("Black"), "Black");
    }

    private AMLParser.ProductContext getProduct(String text) throws IOException {
        return getAmlParser(text).product();
    }

    private AMLParser.PropertyContext getProperty(String text) throws IOException {
        return getAmlParser(text).property();
    }

    private AMLParser.PropertyKeyContext getProductPropertyKey(String text) throws IOException {
        return getAmlParser(text).propertyKey();
    }

    private AMLParser.PropertyValueContext getProductPropertyValue(String text) throws IOException {
        return getAmlParser(text).propertyValue();
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
