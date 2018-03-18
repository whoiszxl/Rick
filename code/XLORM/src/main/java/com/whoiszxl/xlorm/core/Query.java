package com.whoiszxl.xlorm.core;

import java.util.List;

/**
 * 负责查询(对外提供服务的核心类)
 * @author whoiszxl
 *
 */
public interface Query {

	
	/**
	 * 直接执行一个dml语句
	 * @param sql SQL语句
	 * @param params 执行参数
	 * @return 执行SQL语句之后影响的记录行数
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * 将一个对象存储到数据库中
	 * @param obj 需要存储的对象
	 */
	public void insert(Object obj);
	
	/**
	 * 通过主键id删除clazz类对应的表中的记录
	 * @param clazz 对应表的clazz类
	 * @param id 需要删除内容的id
	 */
	public void delete(Class clazz, int id);
	
	/**
	 * 通过对象中的主键id删除表中的记录
	 * @param obj 含有主键id的对象
	 */
	public void delete(Object obj);
	
	/**
	 * 更新对象对应的记录,并且只更新指定字段的值
	 * @param obj 需要更新的对象
	 * @param fieldNames 需要更新的属性列表
	 * @return 影响的行数
	 */
	public int update(Object obj, String[] fieldNames);
	
	/**
	 * 查询返回多行记录,并将每行记录封装到指定的clazz对象中
	 * @param sql 查询语句
	 * @param clazz 查询的clazz对象
	 * @param params sql参数
	 * @return 查询的List结果
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	
	
	/**
	 * 查询返回一行记录,并将记录封装到指定的clazz对象中
	 * @param sql 查询语句
	 * @param clazz 查询的clazz对象
	 * @param params sql参数
	 * @return 查询的Object结果
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params);
	
	/**
	 * 查询返回一个值,直接返回
	 * @param sql 查询语句
	 * @param params sql参数
	 * @return 查询的Object结果
	 */
	public Object queryValue(String sql, Object[] params);
	
	
	/**
	 * 查询返回一个数字,直接返回
	 * @param sql 查询语句
	 * @param params sql参数
	 * @return 查询返回一个数字
	 */
	public Number queryNumber(String sql, Object[] params);
}
