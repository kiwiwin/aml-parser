package org.tw.aml.api;

public class AMLProperty {
    private String key;
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
