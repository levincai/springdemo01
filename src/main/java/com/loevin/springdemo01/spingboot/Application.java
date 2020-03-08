package com.loevin.springdemo01.spingboot;

import com.loevin.springdemo01.javaconfig.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        assert (ctx != null);

        logger.info("The bean you were looking for:");

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(logger::info);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

        helloWorld.sayHi();

        System.in.read();

        ctx.close();
    }
}
