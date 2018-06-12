package com.whoiszxl.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * һ��Spring�����FactoryBean
 * @author whoiszxl
 *
 */
public class PeopleFactoryBean implements FactoryBean<Girl>{

	//����һ��Girl���󣬲�������ӵ�������
	public Girl getObject() throws Exception {
		return new Girl("������");
	}

	//��������
	public Class<?> getObjectType() {
		return Girl.class;
	}

	//�Ƿ��ǵ���
	public boolean isSingleton() {
		return true;
	}
}
