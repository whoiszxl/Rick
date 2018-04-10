package com.whoiszxl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.whoiszxl.reflect.bean.User;

public class Demo3 {
	public static void main(String[] args) {
		
		String path = "com.whoiszxl.reflect.bean.User";
		
		try {
			//对象是表示或封装一些数据,一个类被加载之后,JVM会创建一个对应该类的class对象,类的整个结构信息会放到对应的class对象中
			//就像镜子一样咯
			Class clazz = Class.forName(path);
			
			//动态构造对象
			User u1 = (User) clazz.newInstance();//调用了user的无参构造方法,必须要有无参构造器
			System.out.println(u1);
			
			//通过有参构造方法new出对象来
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,String.class,int.class);
			User u2 = c.newInstance(1, "周二", 20);
			System.out.println(u2.getUsername());
			
			//通过反射api调用普通方法
			User u3 = (User) clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUsername", String.class);
			method.invoke(u3, "周三");
			System.out.println(u3.getUsername());
			
			//通过反射API操作属性
			Field f1 = clazz.getDeclaredField("username");//获取到username的字段
			f1.setAccessible(true);//设置不用安全检查了,可以直接访问
			User u4 = (User) clazz.newInstance();//通过class创建一个u4对象
			f1.set(u4, "周四");//通过字段设置值到对象中
			System.out.println(u4.getUsername());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}