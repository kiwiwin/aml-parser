package org.tw.aml;

import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.AMLParserTestHelper.assertNodeText;
import static org.tw.aml.AMLParserTestHelper.getAmlParser;

public class AMLPropertyParserTest {

    @Test
    public void should_get_property() throws IOException {
        final AMLParser.PropertyContext property = getProperty("type=\"SATA\";");

        assertThat(property.propertyKey().getText(), is("type"));
        assertThat(property.propertyValue().getText(), is("\"SATA\""));
    }

    @Test
    public void should_get_property_key() throws IOException {
        assertNodeText(getPropertyKey("type"), "type");
    }

    @Test
    public void should_get_property_value_as_INT() throws IOException {
        assertNodeText(getPropertyValue("1234"), "1234");
    }

    @Test
    public void should_get_property_value_as_STRING() throws IOException {
        assertNodeText(getPropertyValue("\"SATA\""), "\"SATA\"");
    }

    @Test
    public void should_get_property_value_as_DOUBLE() throws IOException {
        assertNodeText(getPropertyValue("12.23"), "12.23");
    }

    @Test
    public void should_get_property_value_as_COLOR() throws IOException {
        assertNodeText(getPropertyValue("Black"), "Black");
    }

    @Test
    public void should_get_property_value_as_array() throws IOException {
        final AMLParser.PropertyValueContext propertyValue = getPropertyValue("Black, Gray, Green");

        assertNodeText(propertyValue, "Black,Gray,Green");
        assertThat(propertyValue.array().value().size(), is(3));
        assertThat(propertyValue.array().value(0).getText(), is("Black"));
        assertThat(propertyValue.array().value(1).getText(), is("Gray"));
        assertThat(propertyValue.array().value(2).getText(), is("Green"));
    }


    private AMLParser.PropertyContext getProperty(String text) throws IOException {
        return getAmlParser(text).property();
    }

    private AMLParser.PropertyKeyContext getPropertyKey(String text) throws IOException {
        return getAmlParser(text).propertyKey();
    }

    private AMLParser.PropertyValueContext getPropertyValue(String text) throws IOException {
        return getAmlParser(text).propertyValue();
    }
}
