package com.whoiszxl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whoiszxl.bean.Girl;
import com.whoiszxl.bean.Person;
import com.whoiszxl.config.MainConfig;

public class Test {
	
	/**
	 * ���y��ʽ��ȡ�����еĶ���
	 */
	private static void configDi1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person per = (Person) context.getBean("person1");
		System.out.println(per);
	}
	
	/**
	 * ͨ��java�������ȡ��������
	 */
	private static void configDi2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		//ͨ�����ͻ�ȡ��bean
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
		
		//ͨ��id��ȡ��bean
		Person person2 = (Person) context.getBean("zhouer");
		System.out.println(person2);
	}
	
	
	
	public static void main(String[] args) {
		
		//configDi1();
		//configDi2();
	}



	

	
}
