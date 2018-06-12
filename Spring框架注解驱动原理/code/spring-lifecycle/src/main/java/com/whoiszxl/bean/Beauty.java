package com.whoiszxl.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Beauty implements InitializingBean,DisposableBean{

	public void destroy() throws Exception {
		System.out.println("Beauty.destroy()");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Beauty.afterPropertiesSet()");
	}
	
}
