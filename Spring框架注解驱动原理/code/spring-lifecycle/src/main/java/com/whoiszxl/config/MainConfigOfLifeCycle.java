package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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
@ComponentScan("com.whoiszxl")
public class MainConfigOfLifeCycle {

	@Bean(initMethod="init", destroyMethod="destroy")
	public Girl girl() {
		return new Girl("������");
	}
}
