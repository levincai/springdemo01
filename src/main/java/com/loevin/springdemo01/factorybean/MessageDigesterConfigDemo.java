package com.loevin.springdemo01.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigesterConfigDemo {
    @Configuration
    static class MessageDigesterConfig {
        @Bean
        public MessageDigestFactoryBean shaDigest() {
            MessageDigestFactoryBean factoryBean = new MessageDigestFactoryBean();
            factoryBean.setAlgorithmName("SHA1");
            return factoryBean;
        }

        @Bean
        public MessageDigestFactoryBean defaultDigest() {
            return new MessageDigestFactoryBean();
        }

        @Bean
        public MessageDigester digester() throws Exception {
            MessageDigester messageDigester = new MessageDigester();
            messageDigester.setDigest1(shaDigest().getObject());
            messageDigester.setDigest2(defaultDigest().getObject());
            return messageDigester;
        }

        public static void main(String[] args) {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);
            MessageDigester messageDigester = (MessageDigester) ctx.getBean("digester");
            messageDigester.digest("Hello world!");
            ctx.close();
        }
    }
}
