package org.tw.aml;

import org.junit.Test;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.tw.aml.AMLParserTestHelper.getAmlParser;

public class AMLRuleParserTest {
    @Test
    public void should_get_rule_number() throws IOException {
        final AMLParser.ProductRuleContext rule = getRule("rule rule_0446_HC4_DUCT01");

        assertThat(rule.ID().getText(), is("rule_0446_HC4_DUCT01"));
    }

    private AMLParser.ProductRuleContext getRule(String text) throws IOException {
        return getAmlParser(text).productRule();
    }
}
