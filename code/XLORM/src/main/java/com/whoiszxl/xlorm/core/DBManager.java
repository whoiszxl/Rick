package com.whoiszxl.xlorm.core;

import java.io.IOException;
import java.util.Properties;

import com.whoiszxl.xlorm.bean.Configuration;

/**
 * 根据配置信息,维持连接对象的管理(具有连接池功能)
 * @author whoiszxl
 *
 */
public class DBManager {
	
	/**
	 * 数据库配置信息
	 */
	private static Configuration conf;
	
	static {//仅加载一次
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conf = new Configuration();
		conf.setDriver(pros.getProperty("datasource.driver-class-name"));
		conf.setPoPackage(pros.getProperty("orm.poPackage"));
		conf.setUsername(pros.getProperty("datasource.username"));
		conf.setPassword(pros.getProperty("datasource.password"));
		conf.setUrl(pros.getProperty("datasource.url"));
		conf.setSrcPath(pros.getProperty("orm.srcPath"));
		conf.setUseDB(pros.getProperty("datasource.dbtype"));
	}

	
}
