package com.art.test.jmailtrap;

public class ApiKeyToken {
    private final String name = "Api-Token";
    private final String value;

    public ApiKeyToken(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
