package com.learning.springboot.learning.configuraion;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.springboot.learning.DB;
import com.learning.springboot.learning.DevDB;
import com.learning.springboot.learning.ProdDB;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "live")
    public DB getProdDB() {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "dev")
    public DB getDevDB() {
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
