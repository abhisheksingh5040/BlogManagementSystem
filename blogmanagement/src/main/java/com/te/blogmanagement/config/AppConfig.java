package com.te.blogmanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {

	@Bean
	ModelMapper getMap() {
		return new ModelMapper();
	}
}
