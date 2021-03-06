package org.tw.aml.api;

import org.antlr.v4.runtime.misc.NotNull;
import org.tw.aml.antlr4.AMLBaseListener;
import org.tw.aml.antlr4.AMLParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void exitQualifier(@NotNull AMLParser.QualifierContext ctx) {
        currentObject.setQualifier(ctx.getText());
    }

    @Override
    public void exitObjectId(@NotNull AMLParser.ObjectIdContext ctx) {
        currentObject.setObjectId(ctx.getText());
    }

    @Override
    public void exitObjectClass(@NotNull AMLParser.ObjectClassContext ctx) {
        currentObject.setObjectClass(ctx.getText());
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
        if (ctx.value() != null) {
            currentProperty.setValue(ctx.getText());
        } else {
            final List<String> array = ctx.array().value().stream()
                    .map(val -> val.getText())
                    .collect(Collectors.toList());
            currentProperty.setValue(array);
        }
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
