package com.whoiszxl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo2 {
	
	public static void main(String[] args) {
			
		String path = "com.whoiszxl.reflect.bean.User";
		
		try {
			//对象是表示或封装一些数据,一个类被加载之后,JVM会创建一个对应该类的class对象,类的整个结构信息会放到对应的class对象中
			//就像镜子一样咯
			Class clazz = Class.forName(path);
			
			//获取类名
			System.out.println("获得包名+类名:"+clazz.getName());
			System.out.println("获得类名:"+clazz.getSimpleName());
			
			//获取属性信息
			Field[] fields = clazz.getFields();//只能获取public的field
			Field[] declaredFields = clazz.getDeclaredFields();//获取到所有的field
			Field f = clazz.getDeclaredField("username");//通过名称获取field
			
			
			//获取方法信息
			Method[] methods = clazz.getMethods();//获取public的方法
			Method[] declaredMethods = clazz.getDeclaredMethods();//获取所有的methods
			clazz.getDeclaredMethod("getUsername", null);//第二个参数适合使用在有重载函数上,通过设置参数类型区分
			
			//获取构造器类型
			Constructor[] declaredConstructors = clazz.getDeclaredConstructors();//获取所有构造器
			Constructor declaredConstructor = clazz.getDeclaredConstructor(null);//获得无参构造器
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
