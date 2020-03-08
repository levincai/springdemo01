package com.loevin.springdemo01.aop;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroducetionDemo {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setName("Levin Cai");
        IntroductionAdvisor introductionAdvisor = new IsModifiedAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(contact);
        // Add the isModified() method to the Contact instance.
        proxyFactory.addAdvisor(introductionAdvisor);
        proxyFactory.setOptimize(true);
        Contact proxy = (Contact) proxyFactory.getProxy();
        IsModified proxyInterface = (IsModified) proxy;
        System.out.println(proxyInterface.isModified());
        proxy.setName("Levin");
        System.out.println(proxyInterface.isModified());
    }
}
