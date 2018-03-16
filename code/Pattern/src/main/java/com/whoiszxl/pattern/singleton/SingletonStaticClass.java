package com.whoiszxl.pattern.singleton;

/**
 * 单例模式之静态内部类模式
 * @author Administrator
 *
 */
public class SingletonStaticClass {

	
	private SingletonStaticClass() {}
	
	private static class ClassInstance {
		private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
	}
	
	public static SingletonStaticClass getInstance(){
		return ClassInstance.INSTANCE;
	}
}
