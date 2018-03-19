package com.whoiszxl.xlorm.core;

import java.lang.reflect.Method;
import java.util.List;

import com.whoiszxl.xlorm.bean.ColumnInfo;
import com.whoiszxl.xlorm.bean.TableInfo;
import com.whoiszxl.xlorm.utils.ReflectUtils;
import com.whoiszxl.xlorm.utils.StringUtils;

/**
 * MySQL数据库的查询类
 * @author whoiszxl
 *
 */
public class MySQLQuery implements Query{

	public int executeDML(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insert(Object obj) {
		// TODO Auto-generated method stub
		
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

	public int update(Object obj, String[] fieldNames) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object queryValue(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
