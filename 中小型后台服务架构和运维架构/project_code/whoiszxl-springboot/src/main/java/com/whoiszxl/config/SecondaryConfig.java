package com.whoiszxl.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 次数据源配置
 * @author whoiszxl
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef="entityManagerFactorysecondary",
		transactionManagerRef="transactionManagersecondary",
		basePackages= {"com.whoiszxl.bean.secondary"}
		)
public class SecondaryConfig {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;
	
	@Primary
	@Bean(name = "entityManagerFactorysecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorysecondary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(secondaryDataSource)
				.properties(getVendorProperties(secondaryDataSource))
				.packages("com.whoiszxl.bean.secondary")
				.persistenceUnit("secondaryPersistenceUnit")
				.build();
		
	}
	
	@Autowired
	private JpaProperties jpaProperties;
	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}
	
	@Primary
	@Bean(name = "transactionManagersecondary")
	public PlatformTransactionManager transactionManagersecondary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorysecondary(builder).getObject());
	}
}
