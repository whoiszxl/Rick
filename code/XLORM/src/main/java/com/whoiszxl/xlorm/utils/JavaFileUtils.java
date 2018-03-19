package com.whoiszxl.xlorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.whoiszxl.xlorm.bean.ColumnInfo;
import com.whoiszxl.xlorm.bean.JavaFieldGetSet;
import com.whoiszxl.xlorm.bean.TableInfo;
import com.whoiszxl.xlorm.core.DBManager;
import com.whoiszxl.xlorm.core.MySQLTypeConvertor;
import com.whoiszxl.xlorm.core.TableContext;
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

	
	/**
	 * 根据表信息生成Java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 类型转换器
	 * @return 类源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {
		//获取到所有的字段信息
		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSrc(c, convertor));
		}
		
		StringBuilder src = new StringBuilder();
		//生成package
		src.append("package "+DBManager.getConfig().getPoPackage()+";\n\n");
		
		//生成import
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		
		//生成类声明语句
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		
		//生成属性列表
		for(JavaFieldGetSet f: javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		
		//生成get方法
		for(JavaFieldGetSet f: javaFields) {
			src.append(f.getGetInfo());
		}
		
		src.append("\n\n");
		
		//生成set方法
		for(JavaFieldGetSet f: javaFields) {
			src.append(f.getSetInfo());
		}
		
		//生成结束语句
		src.append("}\n");
		
		return src.toString();
	};
	
	
	/**
	 * 根据表信息生成Java类的源代码po文件
	 * @param tableInfo 表信息
	 * @param convertor 类型转换器
	 */
	public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo, convertor);
		
		//获取生成代码的路径
		String srcPath = DBManager.getConfig().getSrcPath()+"\\";
		String packagePath = DBManager.getConfig().getPoPackage().replaceAll("\\.", "/");
		File f = new File(srcPath + packagePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()+ "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
			bw.write(src);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Map<String, TableInfo> tableInfos = TableContext.getTableInfos();
		TableInfo tableInfo = tableInfos.get("user");
		createJavaPOFile(tableInfo, new MySQLTypeConvertor());
	}
	
}
