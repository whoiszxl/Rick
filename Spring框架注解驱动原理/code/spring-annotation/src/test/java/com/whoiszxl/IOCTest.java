package com.whoiszxl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.whoiszxl.bean.Girl;
import com.whoiszxl.bean.Man;
import com.whoiszxl.bean.Person;
import com.whoiszxl.config.MainConfig;

public class IOCTest {

	private AnnotationConfigApplicationContext context;
	
	@Before
	public void before() {
		context = new AnnotationConfigApplicationContext(MainConfig.class);
	}
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
		
		System.out.println("工厂对象："+context.getBean("peopleFactoryBean"));
		//System.out.println(context.getBean("userService"));
	}
	
	@Test
	public void test2() throws Exception {
		//获取到容器中所有Person的类
		String[] names = context.getBeanNamesForType(Person.class);
		System.out.println("spring容器中所有的Person对象");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("====================");
		
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment.getSystemProperties());
		
		Man bean = context.getBean(Man.class);
		System.out.println(bean);
		
		Girl g = (Girl) context.getBean("com.whoiszxl.bean.Girl");
		System.out.println(g);
	}
}
