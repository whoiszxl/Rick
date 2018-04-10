package com.whoiszxl.pattern.singleton;

import java.io.ObjectStreamException;

/**
 * 单例模式之静态内部类模式
 * @author Administrator
 *
 */
public class SingletonStaticClass {

	
	private SingletonStaticClass() {
		//防止反射创建
		if(ClassInstance.INSTANCE != null){
			throw new RuntimeException();
		}
	}
	
	private static class ClassInstance {
		private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
	}
	
	public static SingletonStaticClass getInstance(){
		return ClassInstance.INSTANCE;
	}
	
	//防止序列化创建多个对象  定义了 readResolve,则反序列化的时候直接返回这个方法的对象
	private Object readResolve() throws ObjectStreamException{
		return ClassInstance.INSTANCE;
	}
}
