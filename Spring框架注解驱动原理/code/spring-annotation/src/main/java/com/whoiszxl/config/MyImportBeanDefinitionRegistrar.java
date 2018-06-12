package com.whoiszxl.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.whoiszxl.bean.Me;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * 把需要註冊的bean調用registry手工註冊進來
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//判断容器中是否含有com.whoiszxl.bean.Girl类
		boolean hasGirl = registry.containsBeanDefinition("com.whoiszxl.bean.Girl");
		if(hasGirl) {
			//存在Girl的话，就用registry把Me也注册进去
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Me.class);
			registry.registerBeanDefinition("me", rootBeanDefinition);
		}
	}
}
