package com.whoiszxl.xlorm.core;

/**
 * 创建query的对象工厂
 * @author whoiszxl
 * 1.使用单例模式
 * 2.使用克隆模式
 */
public class QueryFactory {
	
	private static QueryFactory factory = new QueryFactory();
	
	private static Query prototypeObj; //原型对象
	
	static {
		try {
			Class c = Class.forName(DBManager.getConfig().getQueryClass());
			prototypeObj = (Query) c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {}
	 
	
	public Query createQuery() {
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
