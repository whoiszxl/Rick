package com.whoiszxl.xlorm.utils;

import com.whoiszxl.xlorm.bean.ColumnInfo;
import com.whoiszxl.xlorm.bean.JavaFieldGetSet;
import com.whoiszxl.xlorm.core.MySQLTypeConvertor;
import com.whoiszxl.xlorm.core.TypeConvertor;

/**
 * 生成Java源代码的常用操作工具类
 * @author whoiszxl
 *
 */
public class JavaFileUtils {
	
	
	/**
	 * 根据字段信息生成Java属性信息,如:varchar username --> private String username;以及相应getset方法
	 * @param column 字段信息
	 * @param convertor 类型转换器
	 * @return java属性和getset信息对象
	 */
	public static JavaFieldGetSet createFieldGetSetSrc(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		
		//获取到数据库对应的java数据类型名称
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");
		
		//拼接get
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"() {\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		
		jfgs.setGetInfo(getSrc.toString());
		
		//拼接set
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"("+javaFieldType+" "+column.getName()+") {\n");
		setSrc.append("\t\tthis."+column.getName()+" = "+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		
		return jfgs;
	}
	
	public static void main(String[] args) {
		ColumnInfo ci = new ColumnInfo("username", "varchar", 0);
		
		JavaFieldGetSet src = createFieldGetSetSrc(ci, new MySQLTypeConvertor());
		
		System.out.println(src.getSetInfo());
	}
	
}
