package com.whoiszxl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.whoiszxl.bean.Girl;
import com.whoiszxl.config.MainConfigOfLifeCycle;
import com.whoiszxl.config.MainConfigOfPropertyValues;

public class IOCTest {

	private AnnotationConfigApplicationContext context;
	
	@Before
	public void before() {
		//context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	}
	
	@Test
	public void test() {
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("------------------------");
		System.out.println(context.getBean("girl"));
	}
	
	
}
