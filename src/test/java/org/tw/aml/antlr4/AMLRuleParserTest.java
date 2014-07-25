package org.tw.aml.antlr4;

import org.junit.Test;
import org.tw.aml.api.AML;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.antlr4.AMLParserTestHelper.*;

public class AMLRuleParserTest {

    @Test
    public void should_get_rules() throws IOException {
        final AMLParser.AmlContext aml = getAml("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}" +
                "rule rule_0555_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 1000, 3432;" +
                "Max = 122;" +
                "}");

        assertThat(aml.object().size(), is(2));
    }

    @Test
    public void should_get_rule_number() throws IOException {
        final AMLParser.ObjectContext rule = getRule("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}");

        assertNodeText(rule.objectId(), "rule_0446_HC4_DUCT01");
        assertNodeText(rule.objectClass(), "MinMax");

        assertThat(rule.property().size(), is(2));
        assertNodeText(rule.property(0).propertyKey(), "ProductPUIDs");
        assertNodeText(rule.property(0).propertyValue(), "989,7393");

        assertNodeText(rule.property(1).propertyKey(), "Max");
        assertNodeText(rule.property(1).propertyValue(), "2");
    }


    private AMLParser.ObjectContext getRule(String text) throws IOException {
        return AML.getAmlParser(text).object();
    }
}
