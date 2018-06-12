package com.whoiszxl.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.whoiszxl.bean.Me;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * ����Ҫ�]�Ե�bean�{��registry�ֹ��]���M��
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//�ж��������Ƿ���com.whoiszxl.bean.Girl��
		boolean hasGirl = registry.containsBeanDefinition("com.whoiszxl.bean.Girl");
		if(hasGirl) {
			//����Girl�Ļ�������registry��MeҲע���ȥ
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Me.class);
			registry.registerBeanDefinition("me", rootBeanDefinition);
		}
	}
}
