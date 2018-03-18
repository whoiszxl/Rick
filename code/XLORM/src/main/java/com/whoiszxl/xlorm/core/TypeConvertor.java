package com.whoiszxl.xlorm.core;

/**
 * 负责java数据类型和数据库数据类型互相转换
 * @author whoiszxl
 *
 */
public interface TypeConvertor {
	
	
	/**
	 * 将数据库数据类型转换成java类型
	 * @param columnType 数据库字段数据类型
	 * @return Java数据类型
	 */
	public String databaseType2JavaType(String columnType);
	
	
	/**
	 * 将java数据类型转换成数据库数据类型
	 * @param javaDataTypes java数据类型
	 * @return 数据库字段类型
	 */
	public String javaType2DatabaseType(String javaDataTypes);
}
