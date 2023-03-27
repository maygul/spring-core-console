package org.ptt.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ptt.spring.config.SpringBeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringBeanConfig.class})
public class UselessBeantest {

    @Autowired
    private UselessBean uselessA;

    @Autowired
    private UselessBean uselessB;

    @Test
    void givenUselessBeans_thenTheyAreDifferent() {
        assert (uselessA != uselessB);
    }


}
