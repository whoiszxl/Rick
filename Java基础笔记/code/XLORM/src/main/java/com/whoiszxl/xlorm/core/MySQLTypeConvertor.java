package com.whoiszxl.xlorm.core;

/**
 * mysql数据类型和java数据类型互转工具
 * @author whoiszxl
 *
 */
public class MySQLTypeConvertor implements TypeConvertor{

	/**
	 * 数据库类型转Java数据类型
	 */
	public String databaseType2JavaType(String columnType) {
		
		if("varchar".equalsIgnoreCase(columnType) 
				|| "char".equalsIgnoreCase(columnType)) {
			return "String";
		}else if("int".equalsIgnoreCase(columnType) 
				|| "tinyint".equalsIgnoreCase(columnType)
				|| "smallint".equalsIgnoreCase(columnType)
				|| "integer".equalsIgnoreCase(columnType)) {
			return "Integer";
		}else if("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		}else if("double".equalsIgnoreCase(columnType)
				|| "float".equalsIgnoreCase(columnType)) {
			return "Double";
		}else if("clob".equalsIgnoreCase(columnType)) {
			return "Clob";
		}else if("blob".equalsIgnoreCase(columnType)) {
			return "Blob";
		}else if("date".equalsIgnoreCase(columnType)) {
			return "Date";
		}else if("time".equalsIgnoreCase(columnType)) {
			return "Time";
		}else if("timestamp".equalsIgnoreCase(columnType)) {
			return "Timestamp";
		}
		
		return null;
	}

	/**
	 * Java数据类型转数据库类型
	 */
	public String javaType2DatabaseType(String javaDataTypes) {
		
		return null;
	}

}
