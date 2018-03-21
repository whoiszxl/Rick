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
import com.whoiszxl.xlorm.utils.JDBCUtils;
import com.whoiszxl.xlorm.utils.ReflectUtils;

/**
 * 负责查询(对外提供服务的核心类)
 * 
 * @author whoiszxl
 *
 */
public abstract class Query implements Cloneable{
	
	
	/**
	 * 采用模板方法模式将jdbc操作封装成模板,使用接口回调的模式去实现
	 * @param sql sql语句
	 * @param params 参数
	 * @param clazz 记录要封装到的Java类
	 * @param back 回调实现类
	 * @return
	 */
	public Object executeQueryTemplate(String sql, Object[] params, Class clazz, CallBack back) {
		Connection conn = DBManager.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// 给sql传参
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();
			
			return back.doExecute(conn, ps, rs);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(ps, conn);
		}

	}
	

	/**
	 * 直接执行一个dml语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            执行参数
	 * @return 执行SQL语句之后影响的记录行数
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		int count = 0;

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);

			// 给sql传参
			JDBCUtils.handleParams(ps, params);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}

		return count;
	}

	/**
	 * 将一个对象存储到数据库中
	 * 
	 * @param obj
	 *            需要存储的对象
	 */
	public void insert(Object obj) {
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
		int countNotNullField = 0;
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			if (fieldValue != null) {
				countNotNullField++;
				sql.append(fieldName + ",");
				params.add(fieldValue);
			}
		}
		sql.setCharAt(sql.length() - 1, ')');
		sql.append(" values (");
		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length() - 1, ')');

		executeDML(sql.toString(), params.toArray());
	}

	/**
	 * 通过主键id删除clazz类对应的表中的记录
	 * 
	 * @param clazz
	 *            对应表的clazz类
	 * @param id
	 *            需要删除内容的id
	 */
	public void delete(Class clazz, Object id) {
		// 通过class找到对应的表信息
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);

		// 获取到主键
		ColumnInfo priKey = tableInfo.getOnlyPriKey();

		// 拼装sql语句
		String sql = "delete from " + tableInfo.getTname() + " where " + priKey.getName() + "=? ";

		executeDML(sql, new Object[] { id });
	}

	/**
	 * 通过对象中的主键id删除表中的记录
	 * 
	 * @param obj
	 *            含有主键id的对象
	 */
	public void delete(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

		// 通过反射获取属性对应的get or set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, priKeyValue);
	}

	/**
	 * 更新对象对应的记录,并且只更新指定字段的值
	 * 
	 * @param obj
	 *            需要更新的对象
	 * @param fieldNames
	 *            需要更新的属性列表
	 * @return 影响的行数
	 */
	public int update(Object obj, String[] fieldNames) {
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");
		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where " + onlyPriKey.getName() + "=? ");
		params.add(ReflectUtils.invokeGet(onlyPriKey.getName(), obj));

		return executeDML(sql.toString(), params.toArray());
	}

	/**
	 * 查询返回多行记录,并将每行记录封装到指定的clazz对象中
	 * 
	 * @param sql
	 *            查询语句
	 * @param clazz
	 *            查询的clazz对象
	 * @param params
	 *            sql参数
	 * @return 查询的List结果
	 */
	public List queryRows(String sql, final Class clazz, Object[] params) {
		return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
			
			public List doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List list = null;
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					while (rs.next()) {
						if(list == null) {
							list = new ArrayList();
						}
						Object rowObj = clazz.newInstance();
						for (int i = 0; i < metaData.getColumnCount(); i++) {
							String columnName = metaData.getColumnLabel(i + 1);
							Object columnValue = rs.getObject(i + 1);

							// 调用rowObj的set方法,将columnValue的值设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						list.add(rowObj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	/**
	 * 查询返回一行记录,并将记录封装到指定的clazz对象中
	 * 
	 * @param sql
	 *            查询语句
	 * @param clazz
	 *            查询的clazz对象
	 * @param params
	 *            sql参数
	 * @return 查询的Object结果
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql, clazz, params);
		return (list == null && list.size() > 0) ? null : list.get(0);
	}

	/**
	 * 查询返回一个值,直接返回
	 * @param sql
	 *            查询语句
	 * @param params
	 *            sql参数
	 * @return 查询的Object结果
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {
			
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null;
				try {
					while (rs.next()) {
						value = rs.getObject(1);
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return value;
			}
		});
	}

	/**
	 * 查询返回一个数字,直接返回
	 * 
	 * @param sql
	 *            查询语句
	 * @param params
	 *            sql参数
	 * @return 查询返回一个数字
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}
	
	
	/**
	 * 分页查询
	 * @param pageNum 第几页数据
	 * @param size 每页显示的数量
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
