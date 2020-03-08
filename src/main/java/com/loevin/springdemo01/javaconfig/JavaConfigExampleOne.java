package com.loevin.springdemo01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class JavaConfigExampleOne {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
