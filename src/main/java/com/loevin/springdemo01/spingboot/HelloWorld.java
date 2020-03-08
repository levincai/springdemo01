package com.loevin.springdemo01.spingboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public void sayHi() {
        logger.info("Hellow world");
    }
}
