package com.whoiszxl.xlorm.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.whoiszxl.xlorm.core.DBManager;

/**
 * 数据库连接池
 * @author whoiszxl
 *
 */
public class DBConnPool {

	/**
	 * 连接池对象
	 */
	private static List<Connection> pool;
	
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConfig().getPoolMaxSize();
	
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConfig().getPoolMinSize();
	

	/**
	 * 初始化连接池,将连接数达到最小值
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList();
		}
		
		while(pool.size()<DBConnPool.POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
			System.out.println("init connection pool .... connection count is:"+pool.size());
		}
	}
	
	/**
	 * 从连接池中获取一个连接
	 * @return 一个连接
	 */
	public synchronized Connection getConnection() {
		int last_index = pool.size() - 1;
		Connection connection = pool.get(last_index);
		pool.remove(last_index);
		return connection;
	}
	
	/**
	 * 将连接放回池中
	 */
	public synchronized void close(Connection conn) {
		if(pool.size() >= POOL_MAX_SIZE) {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			pool.add(conn);
		}
	}
	
	/**
	 * 构造方法
	 */
	public DBConnPool() {
		initPool();
	}
	
	
	
	
}
