package com.whoiszxl.pattern.singleton;

/**
 * 双重检测锁模式
 * 不推荐使用
 * @author Administrator
 *
 */
public class SingletonDoubleCheckLock {

	private static SingletonDoubleCheckLock INSTANCE = null;
	
	private SingletonDoubleCheckLock() {}
	
	public static SingletonDoubleCheckLock getInstance() {
		//为空的时候就新建一个空对象
		if(INSTANCE == null){
			SingletonDoubleCheckLock s;
			//同步锁住这个类
			synchronized (SingletonDoubleCheckLock.class) {
				//将实例赋值给s
				s = INSTANCE;
				//如果为空
				if(s == null) {
					//同步又锁住
					synchronized (SingletonDoubleCheckLock.class) {
						//为空就赋值
						if(s == null){
							s = new SingletonDoubleCheckLock();
						}
					}
					//再将实例赋值
					INSTANCE = s;
				}
			}
		}
		return INSTANCE;
	}
}
