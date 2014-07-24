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

public class AMLPropertyParserTest {

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
    public void should_get_product_property_value_as_DOUBLE() throws IOException {
        assertNodeText(getProductPropertyValue("12.23"), "12.23");
    }

    @Test
    public void should_get_product_property_value_as_COLOR() throws IOException {
        assertNodeText(getProductPropertyValue("Black"), "Black");
    }

    @Test
    public void should_get_product_property_value_as_array() throws IOException {
        final AMLParser.PropertyValueContext productPropertyValue = getProductPropertyValue("Black, Gray, Green");

        assertNodeText(productPropertyValue, "Black,Gray,Green");
        assertThat(productPropertyValue.array().value().size(), is(3));
        assertThat(productPropertyValue.array().value(0).getText(), is("Black"));
        assertThat(productPropertyValue.array().value(1).getText(), is("Gray"));
        assertThat(productPropertyValue.array().value(2).getText(), is("Green"));
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
