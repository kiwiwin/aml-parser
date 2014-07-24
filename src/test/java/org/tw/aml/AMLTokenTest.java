package org.tw.aml;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import org.tw.aml.antlr4.AMLLexer;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AMLTokenTest {
    @Test
    public void should_get_id_token() throws IOException {
        final List<Token> tokens = getTokens("rule_HX5Scaling");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getText(), is("rule_HX5Scaling"));
        assertThat(tokens.get(0).getType(), is(AMLLexer.ID));
    }

    private List<Token> getTokens(String text) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(new StringReader(text));
        final AMLLexer lexer = new AMLLexer(input);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }
}
