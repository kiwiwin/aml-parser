package org.tw.aml.api;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.tw.aml.api.AML.createAML;

public class AMLTest {
    @Test
    public void should_get_all_objects() throws IOException {
        final AML aml = createAML("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}");

        final List<AMLObject> amlObjects = aml.getObjects();

        assertThat(amlObjects.size(), is(1));

        final AMLObject amlObject = amlObjects.get(0);
        assertThat(amlObject.getQualifier(), is("rule"));
        assertThat(amlObject.getObjectClass(), is("MinMax"));
    }

    @Test
    public void should_get_object_by_qualifier_and_object_id() throws IOException {
        final AML aml = createAML("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}" +
                "rule rule_0555_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 1000, 3432;" +
                "Max = 122;" +
                "}");

        final AMLObject amlObject = aml.getObject("rule", "rule_0446_HC4_DUCT01");

        assertThat(amlObject.getQualifier(), is("rule"));
        assertThat(amlObject.getObjectId(), is("rule_0446_HC4_DUCT01"));
        assertThat(amlObject.getProperties().get(0).getKey(), is("ProductPUIDs"));
    }
}
