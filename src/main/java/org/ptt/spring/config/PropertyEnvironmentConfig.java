package org.ptt.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:database.properties")
@Configuration
public class PropertyEnvironmentConfig {

    @Autowired
    private Environment env;

    public String getUrl() {
        return env.getProperty("jdbc.url");
    }

    public String getUsername() {
        return env.getProperty("jdbc.username");
    }

    public String getPassword() {
        return env.getProperty("jdbc.password");
    }

}
