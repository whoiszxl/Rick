package com.whoiszxl.xlorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.whoiszxl.xlorm.bean.Configuration;
import com.whoiszxl.xlorm.pool.DBConnPool;

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
	
	private static DBConnPool pool;
	
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
		conf.setQueryClass(pros.getProperty("orm.queryClass"));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("pool.maxSize")));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("pool.minSize")));
		
		
	}

	/**
	 * 创建数据库连接
	 * @return
	 */
	public static Connection createConnection() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),conf.getUsername(),conf.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		if(pool == null) {
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	
	
	/**
	 * 关闭 rs,ps和conn
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(ps!=null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null) {
				//conn.close();
				pool.close(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 直接关闭conn连接
	 * @param conn 数据库连接
	 */
	public static void close(Connection conn) {
		try {
			if(conn!=null) {
				pool.close(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回db配置信息
	 * @return
	 */
	public static Configuration getConfig() {
		return conf;
	}

	/**
	 * 关闭 ps和conn
	 * @param ps
	 * @param conn
	 */
	public static void close(PreparedStatement ps, Connection conn) {
		try {
			if(ps!=null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null) {
				//conn.close();
				pool.close(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
