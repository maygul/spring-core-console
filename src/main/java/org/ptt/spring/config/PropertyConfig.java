package org.ptt.spring.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:database.properties")
@Configuration
@Data
public class PropertyConfig {

    private String url;
    private String username;
    private String password;

    public PropertyConfig(@Value("${jdbc.url}") String url,
                          @Value("${jdbc.username}") String username,
                          @Value("${jdbc.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
