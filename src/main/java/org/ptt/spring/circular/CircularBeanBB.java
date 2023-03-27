package org.ptt.spring.circular;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CircularBeanBB implements ApplicationContextAware {
    private CircularBeanA circularBeanA;

    public CircularBeanBB() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        circularBeanA = applicationContext.getBean(CircularBeanA.class);
    }
}
