package com.whoiszxl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whoiszxl.bean.Girl;
import com.whoiszxl.bean.Person;
import com.whoiszxl.config.MainConfig;

public class Test {
	
	/**
	 * 傳統方式获取容器中的对象
	 */
	private static void configDi1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person per = (Person) context.getBean("person1");
		System.out.println(per);
	}
	
	/**
	 * 通过java配置类获取容器对象
	 */
	private static void configDi2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		//通过类型获取到bean
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
		
		//通过id获取到bean
		Person person2 = (Person) context.getBean("zhouer");
		System.out.println(person2);
	}
	
	
	
	public static void main(String[] args) {
		
		//configDi1();
		//configDi2();
	}



	

	
}
