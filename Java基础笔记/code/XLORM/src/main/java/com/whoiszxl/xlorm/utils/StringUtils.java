package com.whoiszxl.xlorm.utils;

/**
 * 字符串操作工具
 * @author whoiszxl
 *
 */
public class StringUtils {

	/**
	 * 字符串首字母大写
	 * @param str 需要首字母大写的字符串
	 * @return 首字母大写的字符串
	 */
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
	
}
