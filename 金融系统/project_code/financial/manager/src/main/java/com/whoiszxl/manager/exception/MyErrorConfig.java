package com.whoiszxl.manager.exception;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 错误处理config配置
 * @author whoiszxl
 *
 */
@Configuration
public class MyErrorConfig {

	@Bean
	public MyErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
			ObjectProvider<List<ErrorViewResolver>> errorObjectProvider) {
		return new MyErrorController(errorAttributes, serverProperties.getError(),errorObjectProvider.getIfAvailable());
	} 
}
