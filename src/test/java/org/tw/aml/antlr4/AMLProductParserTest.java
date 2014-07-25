package org.tw.aml.antlr4;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.antlr4.AMLParserTestHelper.assertNodeText;
import static org.tw.aml.antlr4.AMLParserTestHelper.getAml;
import static org.tw.aml.api.AML.getAmlParser;

public class AMLProductParserTest {

    @Test
    public void should_get_multi_products() throws IOException {
        final AMLParser.AmlContext aml = getAml("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }" +
                "puid 8044 extends Drive {" +
                "type=\"BABA\";" +
                "}");

        assertThat(aml.object().size(), is(2));
    }

    @Test
    public void should_get_product() throws IOException {
        final AMLParser.ObjectContext product = getProduct("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        assertNodeText(product.qualifier(), "puid");
        assertNodeText(product.objectId(), "8033");
        assertNodeText(product.objectClass(), "Drive");

        assertThat(product.property().size(), is(1));
        assertThat(product.property(0).propertyKey().getText(), is("type"));
        assertThat(product.property(0).propertyValue().getText(), is("\"SATA\""));
    }

    private AMLParser.ObjectContext getProduct(String text) throws IOException {
        return getAmlParser(text).object();
    }

}
