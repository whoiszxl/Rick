package com.whoiszxl.pattern.factory.simple_factory;

public class Client {
	public static void main(String[] args) {
		
		Phone phone = PhoneFactory.createPhone("小米");
		phone.call();
		
	}
}
