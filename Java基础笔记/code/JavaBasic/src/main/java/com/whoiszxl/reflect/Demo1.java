package com.whoiszxl.reflect;


public class Demo1 {
	
	public static void main(String[] args) {
		
		String path = "com.whoiszxl.reflect.bean.User";
		
		try {
			//对象是表示或封装一些数据,一个类被加载之后,JVM会创建一个对应该类的class对象,类的整个结构信息会放到对应的class对象中
			//就像镜子一样咯
			Class clazz = Class.forName(path);
			System.out.println(clazz.hashCode());
			
			//同一个类反射多次还是同一对象
			Class clazz2 = Class.forName(path);
			System.out.println(clazz.hashCode() == clazz2.hashCode()); //true 只有一个对象
			
			//String反射也是同一个对象
			Class strClazz = String.class;
			System.out.println(strClazz.hashCode() == path.getClass().hashCode());// true String也只有一个对象
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
