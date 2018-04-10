package com.whoiszxl.xlorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.whoiszxl.xlorm.bean.ColumnInfo;
import com.whoiszxl.xlorm.bean.TableInfo;
import com.whoiszxl.xlorm.po.User;
import com.whoiszxl.xlorm.utils.JDBCUtils;
import com.whoiszxl.xlorm.utils.ReflectUtils;



/**
 * MySQL数据库的查询类
 * @author whoiszxl
 *
 */
public class MySQLQuery extends Query{

	@Override
	public Object queryPagenate(int pageNum, int size) {
		return null;
	}
	
	
	public static void main(String[] args) {
		
		List queryRows = QueryFactory.createQuery().queryRows("select * from user", User.class, null);
		for (Object object : queryRows) {
			System.out.println(object);
		}
	}

}
