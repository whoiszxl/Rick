package com.whoiszxl.pattern.factory.method_factory;

import com.whoiszxl.pattern.factory.simple_factory.Phone;

public class Client {
	public static void main(String[] args) {
		Phone phone = new XiaomiFactory().createPhone();
		phone.call();
	}
}
 