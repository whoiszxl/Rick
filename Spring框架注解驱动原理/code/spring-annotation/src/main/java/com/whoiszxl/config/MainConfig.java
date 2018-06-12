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
 * value: ָ����Ҫɨ��İ�
 * excludeFilters:ָ����Ҫ����ʲôfilter�����ų���Щ���
 * includeFilters:ָ����Ҫ����ʲôfilter���������Щ���,���������ʱ����Ҫ�ر�Ĭ��ɨ�����а��Ĺ���useDefaultFilters
 * @author whoiszxl
 *
 */
@Configuration //����spring����һ�������࣬������==�����ļ�
@ComponentScans(value = {
		@ComponentScan(value="com.whoiszxl", excludeFilters = {
				@Filter(type=FilterType.ANNOTATION, classes= {Controller.class}),//���˵�Controllerע�����
				//@Filter(type=FilterType.CUSTOM, classes= {MyTypeFilter.class})
		})
})
@Import({Man.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

	/**
	 * ��������ע��һ��Bean
	 * ����Ϊ����ֵ������
	 * idĬ�����÷�������Ϊid
	 * ע����������˾�ȡ���õ�
	 * @return
	 */
	@Bean("zhouer")
	public Person person() {
		return new Person("�ܶ�", 22);
	}
	
	/**
	 * Conditionalע��,�䰴��һ�����������жϣ����������Ÿ�������ע��bean
	 * �����ע����������ϵĻ������÷�Χ����������
	 * �����one��ȡhuang����two,ȡzhong
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
