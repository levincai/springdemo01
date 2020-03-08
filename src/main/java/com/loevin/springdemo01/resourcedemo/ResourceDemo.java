package com.loevin.springdemo01.resourcedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");

        file.deleteOnExit();

        Resource res1 = ctx.getResource("file://" + file.getPath());

        displayInfo(res1);

        Resource res2 = ctx.getResource("http://www.baidu.com");

        displayInfo(res2);
    }

    private static void displayInfo(Resource res) throws IOException {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
