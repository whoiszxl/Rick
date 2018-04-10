package com.whoiszxl.pattern.singleton;

/**
 * 单例设计模式之懒汉式
 * @author Administrator
 *
 */
public class SingletonLanhan {

	//构建当前类的静态对象,初始为null
	private static SingletonLanhan INSTANCE;
	
	//私有化构造函数不允许new当前对象
	private SingletonLanhan() {}
	
	//创建访问点来获取当前类的唯一对象
	public static synchronized SingletonLanhan getInstance(){
		//在访问点中判断是否加载了,没加载就去加载,可以实现懒加载,但是sync了之后效率很低了
		if(INSTANCE == null){
			INSTANCE = new SingletonLanhan();
		}
		return INSTANCE;
	}
	
}
