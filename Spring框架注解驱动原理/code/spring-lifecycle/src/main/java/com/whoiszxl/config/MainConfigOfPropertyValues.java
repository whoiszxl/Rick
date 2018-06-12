package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.whoiszxl.bean.Girl;

@PropertySource(value= {"classpath:/p.properties"})
@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Girl girl() {
		return new Girl();
	}
	
}
