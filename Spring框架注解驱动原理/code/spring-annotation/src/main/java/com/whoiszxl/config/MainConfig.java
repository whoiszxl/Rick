package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;

import com.whoiszxl.bean.Man;
import com.whoiszxl.bean.PeopleFactoryBean;
import com.whoiszxl.bean.Person;
import com.whoiszxl.condition.OneCondition;
import com.whoiszxl.condition.TwoCondition;

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
				//@Filter(type=FilterType.CUSTOM, classes= {MyTypeFilter.class})
		})
})
@Import({Man.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
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
	
	/**
	 * Conditional注解,其按照一定条件进行判断，满足条件才给容器中注册bean
	 * 如果将注解添加在类上的话，作用范围就是整个类
	 * 如果是one，取huang，是two,取zhong
	 * @return
	 */
	@Bean("huang")
	@Conditional({OneCondition.class})
	public Person huang() {
		return new Person("huang",22);
	}
	
	@Bean("zhong")
	@Conditional({TwoCondition.class})
	public Person zhong() {
		return new Person("zhong",23);
	} 
	
	@Bean
	public PeopleFactoryBean peopleFactoryBean() {
		return new PeopleFactoryBean();
	}
}
