package com.whoiszxl.xlorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.whoiszxl.xlorm.bean.ColumnInfo;
import com.whoiszxl.xlorm.bean.TableInfo;
import com.whoiszxl.xlorm.utils.JavaFileUtils;

/**
 * 负责获取管理数据库所有表结构和类结构的关系,并可以根据表结构生成类结构
 * @author whoiszxl
 *
 */
public class TableContext {
	
	/**
	 * 表名为key,表信息对象为value
	 */
	private static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();
	
	/**
	 * 将po的class对象和表信息关联起来,便于复用
	 */
	public static Map<Class, TableInfo> poClassTableMap = new HashMap<Class, TableInfo>();
	
	/**
	 * 私有化构造器,不允许new
	 */
	private TableContext() {}
	
	/**
	 * 初始化获得表信息
	 */
	static {
		try {
			Connection conn = DBManager.getConnection();
			//通过连接获取到数据库的源信息
			DatabaseMetaData dbmd = conn.getMetaData();
			//查询到所有表信息
			ResultSet tableSet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
			//遍历
			while(tableSet.next()) {
				String tableName = (String) tableSet.getObject("TABLE_NAME");
				
				TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>(),new HashMap<String, ColumnInfo>());
				tables.put(tableName, ti);
				//查询表中的所有字段
				ResultSet columnSet = dbmd.getColumns(null, "%", tableName, "%");
				while(columnSet.next()) {
					ColumnInfo ci = new ColumnInfo(columnSet.getString("COLUMN_NAME"), columnSet.getString("TYPE_NAME"), 0);
					ti.getColumns().put(columnSet.getString("COLUMN_NAME"), ci);
				}
				//查询表中的所有主键
				ResultSet primaryKeys = dbmd.getPrimaryKeys(null, "%", tableName);
				//遍历,获取到columnInfo对象设置主键类型
				while(primaryKeys.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(primaryKeys.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPriKeys().add(ci2);
				}
				
				//设置唯一主键 
				if(ti.getPriKeys().size()>0) {
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		updateJavaPOFile();
	}
	
	/**
	 * 获取到所有的表信息
	 * @return 表信息
	 */
	public static Map<String, TableInfo> getTableInfos() {
		return tables;
	}
	
	/**
	 * 根据表结构更新配置的po包下的Java类源码
	 */
	public static void updateJavaPOFile() {
		Map<String, TableInfo> map = TableContext.getTableInfos();
		for (TableInfo t : map.values()) {
			JavaFileUtils.createJavaPOFile(t, new MySQLTypeConvertor());
		}
	}
	
	
}
