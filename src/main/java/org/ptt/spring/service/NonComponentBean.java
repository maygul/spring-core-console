package org.ptt.spring.service;

import lombok.Data;

@Data
public class NonComponentBean {
    private String name;

    public NonComponentBean(String name) {
        this.name = name;
    }
}
