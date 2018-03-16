package com.whoiszxl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value=ElementType.TYPE)//target描述注解使用范围,package描述包,type,描述类接口枚举和annotation类型等等,method修饰方法
@Target(value= {ElementType.TYPE,ElementType.METHOD})//可以使用数组,描述多种类型了
@Retention(RetentionPolicy.RUNTIME)//CLASS 在class文件中有效,SOURCE在源文件中有效,RUNTIME为在运行时有效,可以被反射机制读取
public @interface LongAnnotation {

	/**
	 * 定义一个personName参数,设置了default默认值
	 * 使用注解的时候可以使用默认的,也可以覆盖.
	 * @return
	 */
	String personName() default "default";
	
	/**
	 * 没有设置默认值的参数,使用注解的时候一定要配置.
	 * @return
	 */
	int personAge();
	
	/**
	 * 定义数组
	 * @return
	 */
	String[] books() default {"红拂夜奔", "绿毛水怪"};
}
