package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.whoiszxl.bean.Person;

/**
 * @ComponentScan
 * value: 指定需要扫描的包
 * excludeFilters:指定需要按照什么filter规则排除哪些组件
 * includeFilters:指定需要按照什么filter规则包含哪些组件,配置这个的时候需要关闭默认扫描所有包的规则useDefaultFilters
 * @author whoiszxl
 *
 */
@Configuration //告诉spring这是一个配置类，配置类==配置文件
@ComponentScans(value = {
		@ComponentScan(value="com.whoiszxl", excludeFilters = {
				@Filter(type=FilterType.ANNOTATION, classes= {Controller.class}),//过滤掉Controller注解的类
				@Filter(type=FilterType.CUSTOM, classes= {MyTypeFilter.class})
		})
})
public class MainConfig {

	/**
	 * 给容器中注册一个Bean
	 * 类型为返回值的类型
	 * id默认是用方法名作为id
	 * 注解后面配置了就取配置的
	 * @return
	 */
	@Bean("zhouer")
	public Person person() {
		return new Person("周二", 22);
	}
}
