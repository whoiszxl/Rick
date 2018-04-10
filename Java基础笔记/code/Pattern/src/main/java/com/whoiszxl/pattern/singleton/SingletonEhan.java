package com.whoiszxl.pattern.singleton;

/**
 * 单例设计模式之饿汉式
 * @author Administrator
 *
 */
public class SingletonEhan {

	//构建当前类的静态对象
	private static SingletonEhan INSTANCE = new SingletonEhan();
	
	//私有化构造函数不允许new当前对象
	private SingletonEhan() {}
	
	//创建访问点来获取当前类的唯一对象
	public static SingletonEhan getInstance(){
		return INSTANCE;
	}
	
}
