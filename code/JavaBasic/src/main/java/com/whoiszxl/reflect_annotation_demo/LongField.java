package com.whoiszxl.reflect_annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LongField {

	//列名
	String columnName();
	
	//字段类型
	String type();
	
	//字段长度
	int length();
}
