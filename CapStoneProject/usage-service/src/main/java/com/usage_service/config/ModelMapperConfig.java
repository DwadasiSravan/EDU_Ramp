package com.usage_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
//@EnableScheduling
public class ModelMapperConfig {
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}  
  