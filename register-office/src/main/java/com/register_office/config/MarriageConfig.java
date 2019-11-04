package com.register_office.config;

import com.register_office.dao.PersonDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/register.properties")
public class MarriageConfig {

    @Bean
    public PersonDAO buildPersonDAO () {
        System.out.println("PersonDAO is created");
        return new PersonDAO();
    }
}
