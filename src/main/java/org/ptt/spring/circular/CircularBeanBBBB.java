package org.ptt.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CircularBeanBBBB {

    @Autowired
    private ApplicationContext context;

    private CircularBeanA circularBeanA;

    public CircularBeanBBBB() {
    }

    @PostConstruct
    public void init() {
        circularBeanA = context.getBean(CircularBeanA.class);
    }

}
