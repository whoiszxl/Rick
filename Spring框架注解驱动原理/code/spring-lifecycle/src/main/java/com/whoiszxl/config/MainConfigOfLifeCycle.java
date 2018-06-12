package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whoiszxl.bean.Girl;

/**
 * bean����������
 * ���̣�bean����-->��ʼ��-->����
 * ���ǿ����Զ����ʼ�������ٷ�����������bean���е���ǰ�������ڵ�ʱ�������������Զ���ĳ�ʼ�������ٷ���
 * @author whoiszxl
 *
 * ���ٵ�ʱ��
 * 	��ʵ����Ҳ���������
 * 	��ʵ������������
 * 
 */
@Configuration
public class MainConfigOfLifeCycle {

	@Bean(initMethod="init", destroyMethod="destroy")
	public Girl girl() {
		return new Girl("������");
	}
}
