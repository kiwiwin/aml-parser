package org.tw.aml.api;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tw.aml.antlr4.AMLLexer;
import org.tw.aml.antlr4.AMLParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class AML {
    private List<AMLObject> objects;

    public AML(List<AMLObject> objects) {
        this.objects = objects;
    }

    public static AML createAML(String text) throws IOException {
        return new AML(getAmlObjects(text));
    }

    public List<AMLObject> getObjects() {
        return objects;
    }

    public AMLObject getObject(String qualifier, String objectId) {
        return objects.stream()
                .filter(object -> object.getQualifier().equals(qualifier) && object.getObjectId().equals(objectId))
                .findFirst().get();
    }

    public static AMLParser getAmlParser(String text) throws IOException {
        final ANTLRInputStream input = new ANTLRInputStream(new StringReader(text));
        final AMLLexer lexer = new AMLLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new AMLParser(tokens);
    }

    public static List<AMLObject> getAmlObjects(String text) throws IOException {
        final AMLParser amlParser = getAmlParser(text);
        final AMLObjectListener amlListener = new AMLObjectListener();
        final ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(amlListener, amlParser.aml());

        return amlListener.getObjects();
    }
}
