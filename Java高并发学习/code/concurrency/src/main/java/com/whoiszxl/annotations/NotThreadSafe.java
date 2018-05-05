package com.whoiszxl.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记线程不安全的注解
 * @author whoiszxl
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//在编译时候忽略
public @interface NotThreadSafe {

	String value() default "";
}
