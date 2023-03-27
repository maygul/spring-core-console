package org.ptt.spring.circular;

import org.springframework.stereotype.Component;

@Component
public class CircularBeanA {
    private CircularBeanB circularBeanB;

    public CircularBeanA(CircularBeanB circularBeanB) {
        this.circularBeanB = circularBeanB;
    }
}
