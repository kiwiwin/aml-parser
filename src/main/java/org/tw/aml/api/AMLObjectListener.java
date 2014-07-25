package org.tw.aml.api;

import org.antlr.v4.runtime.misc.NotNull;
import org.tw.aml.antlr4.AMLBaseListener;
import org.tw.aml.antlr4.AMLParser;

import java.util.ArrayList;
import java.util.List;

public class AMLObjectListener extends AMLBaseListener {
    private List<AMLObject> objects = new ArrayList<AMLObject>();
    private AMLObject currentObject;
    private AMLProperty currentProperty;

    public List<AMLObject> getObjects() {
        return objects;
    }

    @Override
    public void enterObject(@NotNull AMLParser.ObjectContext ctx) {
        currentObject = new AMLObject();
    }

    @Override
    public void enterProperty(@NotNull AMLParser.PropertyContext ctx) {
        currentProperty = new AMLProperty();
    }

    @Override
    public void exitPropertyKey(@NotNull AMLParser.PropertyKeyContext ctx) {
        currentProperty.setKey(ctx.getText());
    }

    @Override
    public void exitPropertyValue(@NotNull AMLParser.PropertyValueContext ctx) {
        currentProperty.setValue(ctx.getText());
    }

    @Override
    public void exitProperty(@NotNull AMLParser.PropertyContext ctx) {
        currentObject.addProperty(currentProperty);
    }

    @Override
    public void exitObject(@NotNull AMLParser.ObjectContext ctx) {
        objects.add(currentObject);
    }
}
