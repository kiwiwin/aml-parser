package org.tw.aml.api;

import org.antlr.v4.runtime.misc.NotNull;
import org.tw.aml.antlr4.AMLBaseListener;
import org.tw.aml.antlr4.AMLParser;

import java.util.ArrayList;
import java.util.List;

public class AMLObjectListener extends AMLBaseListener {
    private List<AMLObject> objects = new ArrayList<AMLObject>();
    private AMLObject currentObject;

    public List<AMLObject> getObjects() {
        return objects;
    }

    @Override
    public void enterObject(@NotNull AMLParser.ObjectContext ctx) {
        currentObject = new AMLObject();
    }

    @Override
    public void exitObject(@NotNull AMLParser.ObjectContext ctx) {
        objects.add(currentObject);
    }
}
