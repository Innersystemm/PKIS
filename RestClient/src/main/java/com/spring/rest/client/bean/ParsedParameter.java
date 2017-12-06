package com.spring.rest.client.bean;

import com.spring.rest.client.service.ParameterParserServiceImpl;

public class ParsedParameter {
    private String parameterName;
    private ParameterParserServiceImpl.TOKENS token;
    private Object value;

    public ParsedParameter(String parameterName, ParameterParserServiceImpl.TOKENS token, Object value) {
        this.parameterName = parameterName;
        this.token = token;
        this.value = value;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public ParameterParserServiceImpl.TOKENS getToken() {
        return token;
    }

    public void setToken(ParameterParserServiceImpl.TOKENS token) {
        this.token = token;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer intValue() {
        return Integer.valueOf(stringValue());
    }

    public double doubleValue() {
        return Double.valueOf(stringValue());
    }

    public String stringValue() {
        return (String) value;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%ntoken: %s%nvalue: %s", parameterName, token.TOKEN(), value);
    }
}
