package com.whoiszxl;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.whoiszxl.config.MainConfig;

public class IOCTest {

	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
		
		System.out.println(context.getBean("userService"));
	}
}
