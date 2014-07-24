package org.tw.aml;

import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;

import static org.tw.aml.AMLParserTestHelper.assertNodeText;
import static org.tw.aml.AMLParserTestHelper.getAmlParser;

public class AMLRuleParserTest {
    @Test
    public void should_get_rule_number() throws IOException {
        final AMLParser.ProductRuleContext rule = getRule("rule rule_0446_HC4_DUCT01 extends MinMax { }");

        assertNodeText(rule.productRuleId(), "rule_0446_HC4_DUCT01");
        assertNodeText(rule.productRuleType(), "MinMax");
    }

    private AMLParser.ProductRuleContext getRule(String text) throws IOException {
        return getAmlParser(text).productRule();
    }
}
