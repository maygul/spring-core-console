package org.ptt.spring.circular;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularBeanB {
    private CircularBeanA circularBeanA;

    public CircularBeanB(@Lazy CircularBeanA circularBeanA) {
        this.circularBeanA = circularBeanA;
    }
}
