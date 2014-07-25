package org.tw.aml.api;

import java.util.ArrayList;
import java.util.List;

public class AMLObject {

    private List<AMLProperty> properties = new ArrayList<>();

    public List<AMLProperty> getProperties() {
        return properties;
    }

    public void addProperty(AMLProperty property) {
        properties.add(property);
    }
}
