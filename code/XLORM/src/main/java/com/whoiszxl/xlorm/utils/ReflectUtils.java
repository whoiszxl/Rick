package com.whoiszxl.xlorm.utils;

import java.lang.reflect.Method;

/**
 * 反射操作工具类
 * @author whoiszxl
 *
 */
public class ReflectUtils {
	
	/**
	 * 调用obj对象对应属性fieldName的get方法
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		try {
			Class c = obj.getClass();
			Method method = c.getMethod("get"+StringUtils.firstChar2UpperCase(fieldName), null);
			Object priKeyValue = method.invoke(obj, null);
			return priKeyValue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
