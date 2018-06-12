package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whoiszxl.bean.Girl;

@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Girl girl() {
		return new Girl();
	}
	
}
