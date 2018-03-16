package com.whoiszxl.reflect_annotation_demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息,模拟处理注解信息的流程
 * @author whoiszxl
 *
 */
public class App {

	public static void main(String[] args) {
		
		try {
			Class<?> clazz = Class.forName("com.whoiszxl.reflect_annotation_demo.LongStudent");
			
			//获取类的所有有效注解
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation.toString());
			}
			
			//获取类的指定注解
			LongTable annotation = clazz.getAnnotation(LongTable.class);
			System.out.println(annotation.value());
			
			//获取类的属性的注解
			Field fStudentName = clazz.getDeclaredField("studentName");
			LongField longField = fStudentName.getAnnotation(LongField.class);
			System.out.println(longField.columnName()+"--"+longField.length());
			
			//可以通过获取的表名字段拼接出SQL语句,使用JDBC可以生成相关的表
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
