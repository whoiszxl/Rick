package com.whoiszxl.xlorm.pool;

import java.util.List;

import com.whoiszxl.xlorm.core.Query;
import com.whoiszxl.xlorm.core.QueryFactory;
import com.whoiszxl.xlorm.po.User;

/**
 * 测试连接池效率
 * @author whoiszxl
 * noPool(); 127950毫秒
 * pool();//13022毫秒		
 * 有连接池比没有连接池快了十倍
 */
public class TestPool {

	private static void noPool() {
		Query q = QueryFactory.createQuery();
		String sql = "select * from user";
		List list = q.queryRows(sql, User.class, null);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	private static void pool() {
		Query q = QueryFactory.createQuery();
		String sql = "select * from user";
		List list = q.queryRows(sql, User.class, null);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	public static void main(String[] args) {
		Long a = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			//noPool(); 127950毫秒
			//pool();//13022毫秒
			
		}
		Long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
}
