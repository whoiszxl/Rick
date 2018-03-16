package com.whoiszxl.reflect_annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)//注解表,设置只能注解到类上
@Retention(RetentionPolicy.RUNTIME)//设置在运行时有效,可以反射解析
public @interface LongTable {

	String value();
}
