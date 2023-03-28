package org.ptt.spring.config;

import org.ptt.spring.service.NonComponentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan(basePackages = "org.ptt.spring")
public class SpringBeanConfig {

    @Bean
    public NonComponentBean nonComponentBean() {
        return new NonComponentBean("NonComponentBean");
    }
}
