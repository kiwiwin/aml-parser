package org.tw.aml.api;

public class AMLProperty {
    private String key;
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
