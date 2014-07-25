package org.tw.aml.api;

import org.junit.Test;
import org.tw.aml.antlr4.AMLParserTestHelper;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.antlr4.AMLParserTestHelper.getAmlObjects;

public class AMLObjectListenerTest {
    @Test
    public void should_get_one_object() throws IOException {
        final List<AMLObject> amlObjects = getAmlObjects("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }");

        assertThat(amlObjects.size(), is(1));

        final AMLObject amlObject = amlObjects.get(0);
        assertThat(amlObject.getProperties().size(), is(1));
        assertThat(amlObject.getQualifier(), is("puid"));
        assertThat(amlObject.getObjectClass(), is("Drive"));

        final AMLProperty amlProperty = amlObject.getProperties().get(0);
        assertThat(amlProperty.getKey(), is("type"));
        assertThat(amlProperty.getValue(), is("\"SATA\""));
    }

    @Test
    public void should_get_property_value_as_list() throws IOException {
        final List<AMLObject> amlObjects = getAmlObjects("puid 8033 extends Drive {" +
                "numbers=1, 3, 5;" +
                " }");

        final AMLObject amlObject = amlObjects.get(0);

        final AMLProperty amlProperty = amlObject.getProperties().get(0);

        final List value = (List) amlProperty.getValue();

        assertThat(value.size(), is(3));
    }

    @Test
    public void should_get_multi_objects() throws IOException {
        final List<AMLObject> amlObjects = getAmlObjects("puid 8033 extends Drive {" +
                "type=\"SATA\";" +
                " }" +
                "puid 8044 extends Drive {" +
                "type=\"BABA\";" +
                "}");

        assertThat(amlObjects.size(), is(2));
    }
}
