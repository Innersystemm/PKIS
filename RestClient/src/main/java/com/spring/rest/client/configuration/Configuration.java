package com.spring.rest.client.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
@ConfigurationProperties(value = "parameters")
public class Configuration {
    private List<String> intKeys = new ArrayList<>();
    private List<String> doubleKeys = new ArrayList<>();
    private List<String> stringKeys = new ArrayList<>();
    private List<String> boolKeys = new ArrayList<>();

    public List<String> getIntKeys() {
        return intKeys;
    }

    public void setIntKeys(List<String> intKeys) {
        this.intKeys = intKeys;
    }

    public List<String> getDoubleKeys() {
        return doubleKeys;
    }

    public void setDoubleKeys(List<String> doubleKeys) {
        this.doubleKeys = doubleKeys;
    }

    public List<String> getStringKeys() {
        return stringKeys;
    }

    public void setStringKeys(List<String> stringKeys) {
        this.stringKeys = stringKeys;
    }

    public List<String> getBoolKeys() {
        return boolKeys;
    }

    public void setBoolKeys(List<String> boolKeys) {
        this.boolKeys = boolKeys;
    }
}
