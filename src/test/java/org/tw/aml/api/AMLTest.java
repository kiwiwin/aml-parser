package org.tw.aml.api;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AMLTest {
    @Test
    public void should_get_all_objects() throws IOException {
        final AML aml = AML.createAML("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}");

        final List<AMLObject> amlObjects = aml.getObjects();

        assertThat(amlObjects.size(), is(1));

        final AMLObject amlObject = amlObjects.get(0);
        assertThat(amlObject.getQualifier(), is("rule"));
        assertThat(amlObject.getObjectClass(), is("MinMax"));
    }
}
