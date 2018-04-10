package com.whoiszxl.annotation;

@LongAnnotation(personAge = 1,books = {}) //type类型,可以修饰方法
public class Demo {
	
	//@LongAnnotation type无法修饰方法,所以会报错
	public String add() {
		return "";
	}
}
