package com.loevin.springdemo01.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.swing.*;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope("prototype")
    @DependsOn("messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
