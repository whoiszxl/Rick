package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whoiszxl.bean.Girl;

/**
 * bean的生命周期
 * 过程：bean创建-->初始化-->销毁
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * @author whoiszxl
 *
 * 销毁的时候：
 * 	单实例：也会跟着销毁
 * 	多实例：不会销毁
 * 
 */
@Configuration
public class MainConfigOfLifeCycle {

	@Bean(initMethod="init", destroyMethod="destroy")
	public Girl girl() {
		return new Girl("明日香");
	}
}
