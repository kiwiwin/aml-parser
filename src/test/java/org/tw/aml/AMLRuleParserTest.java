package org.tw.aml;

import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.AMLParserTestHelper.assertNodeText;
import static org.tw.aml.AMLParserTestHelper.getAmlParser;

public class AMLRuleParserTest {
    @Test
    public void should_get_rule_number() throws IOException {
        final AMLParser.ProductRuleContext rule = getRule("rule rule_0446_HC4_DUCT01 extends MinMax {" +
                "ProductPUIDs = 989, 7393;" +
                "Max = 2;" +
                "}");

        assertNodeText(rule.productRuleId(), "rule_0446_HC4_DUCT01");
        assertNodeText(rule.productRuleType(), "MinMax");

        assertThat(rule.property().size(), is(2));
        assertNodeText(rule.property(0).propertyKey(), "ProductPUIDs");
        assertNodeText(rule.property(0).propertyValue(), "989,7393");

        assertNodeText(rule.property(1).propertyKey(), "Max");
        assertNodeText(rule.property(1).propertyValue(), "2");
    }

    private AMLParser.ProductRuleContext getRule(String text) throws IOException {
        return getAmlParser(text).productRule();
    }
}
