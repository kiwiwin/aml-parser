package org.tw.aml.api;

import java.util.ArrayList;
import java.util.List;

public class AMLObject {
    private List<AMLProperty> properties = new ArrayList<>();
    private String qualifier;
    private String objectClass;
    private String objectId;

    public List<AMLProperty> getProperties() {
        return properties;
    }

    public void addProperty(AMLProperty property) {
        properties.add(property);
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
