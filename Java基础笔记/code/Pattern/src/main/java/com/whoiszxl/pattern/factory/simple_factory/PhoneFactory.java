package com.whoiszxl.pattern.factory.simple_factory;

public class PhoneFactory {
	
	public static Phone createPhone(String name) {
		if(name.equals("小米")){
			return new Xiaomi();
		}else if(name.equals("苹果")){
			return new Iphone();
		}
		return null;
	}
	
}
