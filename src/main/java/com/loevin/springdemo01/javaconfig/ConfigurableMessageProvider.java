package com.loevin.springdemo01.javaconfig;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default";

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public ConfigurableMessageProvider() {
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
