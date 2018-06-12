package com.whoiszxl.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 一个Spring定义的FactoryBean
 * @author whoiszxl
 *
 */
public class PeopleFactoryBean implements FactoryBean<Girl>{

	//返回一个Girl对象，并将其添加到容器中
	public Girl getObject() throws Exception {
		return new Girl("明日香");
	}

	//对象类型
	public Class<?> getObjectType() {
		return Girl.class;
	}

	//是否是单例
	public boolean isSingleton() {
		return true;
	}
}
