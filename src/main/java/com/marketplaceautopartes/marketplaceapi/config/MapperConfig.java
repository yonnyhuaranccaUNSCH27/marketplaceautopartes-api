package com.marketplaceautopartes.marketplaceapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "defaultMapper")
    public ModelMapper getDefaultMapper() {
        return new ModelMapper();
    }
}