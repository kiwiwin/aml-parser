package org.tw.aml.antlr4;

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

    @Test
    public void should_get_double_token() throws IOException {
        final List<Token> tokens = getTokens("12.45");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getText(), is("12.45"));
        assertThat(tokens.get(0).getType(), is(AMLLexer.DOUBLE));
    }

    @Test
    public void should_get_boolean_token() throws IOException {
        final List<Token> tokens = getTokens("true");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getText(), is("true"));
        assertThat(tokens.get(0).getType(), is(AMLLexer.BOOLEAN));
    }

    @Test
    public void should_get_string_token() throws IOException {
        final List<Token> tokens = getTokens("\"NA\"");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getText(), is("\"NA\""));
        assertThat(tokens.get(0).getType(), is(AMLLexer.STRING));
    }

    @Test
    public void should_get_int_token() throws IOException {
        final List<Token> tokens = getTokens("500");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getText(), is("500"));
        assertThat(tokens.get(0).getType(), is(AMLLexer.INT));
    }

    @Test
    public void should_skip_comment() throws IOException {
        final List<Token> tokens = getTokens("//500");

        assertThat(tokens.size(), is(1));
    }

    @Test
    public void should_get_color_token() throws IOException {
        final List<Token> tokens = getTokens("Black Gray Orange Green Blue Yellow");

        assertThat(tokens.size(), is(7));

        assertColor(tokens.get(0), "Black");
        assertColor(tokens.get(1), "Gray");
        assertColor(tokens.get(2), "Orange");
        assertColor(tokens.get(3), "Green");
        assertColor(tokens.get(4), "Blue");
        assertColor(tokens.get(5), "Yellow");
    }

    private void assertColor(Token token, String color) {
        assertThat(token.getText(), is(color));
        assertThat(token.getType(), is(AMLLexer.COLOR));
    }

    private List<Token> getTokens(String text) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(new StringReader(text));
        final AMLLexer lexer = new AMLLexer(input);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }
}
