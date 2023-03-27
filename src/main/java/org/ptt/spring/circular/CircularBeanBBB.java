package org.ptt.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularBeanBBB {
    private CircularBeanA circularBeanA;

    public CircularBeanBBB() {
    }

    @Autowired
    public void setCircularBeanA(CircularBeanA circularBeanA) {
        this.circularBeanA = circularBeanA;
    }
}
