package org.ptt.spring.service;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class UselessBean {
    private String name;

    public void uselessMethod() {
        System.out.println("Useless method");
    }
}
