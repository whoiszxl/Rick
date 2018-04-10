package com.whoiszxl.pattern.factory.method_factory;

import com.whoiszxl.pattern.factory.simple_factory.Phone;
import com.whoiszxl.pattern.factory.simple_factory.Xiaomi;

public class XiaomiFactory implements MethodPhoneFactory{

	public Phone createPhone() {
		return new Xiaomi();
	}

}
