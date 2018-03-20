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
public class MySQLQuery implements Query{
	
	public static void main(String[] args) {
		List rows = new MySQLQuery().queryRows("select * from user", User.class, new String[] {});
		for (Object object : rows) {
			System.out.println(object);
		}
	}

	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		int count = 0;
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			//给sql传参
			JDBCUtils.handleParams(ps, params);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		
		return count;
	}

	public void delete(Class clazz, Object id) {
		//通过class找到对应的表信息
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		
		//获取到主键
		ColumnInfo priKey = tableInfo.getOnlyPriKey();
		
		//拼装sql语句
		String sql = "delete from "+tableInfo.getTname()+" where "+priKey.getName()+"=? ";
		
		executeDML(sql, new Object[] {id});
	}

	public void delete(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		//通过反射获取属性对应的get or set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, priKeyValue);
	}

	public void insert(Object obj) {
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into "+tableInfo.getTname()+" (");
		int countNotNullField = 0;
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			if(fieldValue != null){
				countNotNullField++;
				sql.append(fieldName + ",");
				params.add(fieldValue);
			}
		}
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values (");
		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')');
		
		executeDML(sql.toString(), params.toArray());
	}
	
	public int update(Object obj, String[] fieldNames) {
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		StringBuilder sql = new StringBuilder("update "+tableInfo.getTname()+" set ");
		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where "+onlyPriKey.getName()+"=? ");
		params.add(ReflectUtils.invokeGet(onlyPriKey.getName(), obj));
		
		return executeDML(sql.toString(), params.toArray());
	}

	public List queryRows(String sql, Class clazz, Object[] params) {
		Connection conn = DBManager.getConnection();
		//存储查询结果
		List list = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql传参
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while(rs.next()) {
				if(list == null) {
					list = new ArrayList();
				}
				Object rowObj = clazz.newInstance();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					
					//调用rowObj的set方法,将columnValue的值设置进去
					ReflectUtils.invokeSet(rowObj, columnName, columnValue);
				}
				list.add(rowObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		
		return list;
	}

	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql, clazz, params);
		return (list==null && list.size()>0)?null:list.get(0);
	}

	public Object queryValue(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		//存储查询结果
		Object value = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql传参
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();
			while(rs.next()) {
				value = rs.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		
		return value;
	}

	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

}
