package com.whoiszxl.pattern.singleton;

/**
 * 单例模式之枚举模式(天生单例,没懒加载)
 * @author Administrator
 *
 */
public enum SingletonByEnum {

	INSTANCE;
	
	/**
	 * 自定义操作
	 * @return
	 */
	public String singletonOperation(){
		return "hello wjj";
	}
}
