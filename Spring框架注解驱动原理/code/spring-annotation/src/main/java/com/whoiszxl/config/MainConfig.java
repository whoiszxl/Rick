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
				@Filter(type=FilterType.CUSTOM, classes= {MyTypeFilter.class})
		})
})
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
}
