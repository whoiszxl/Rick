package com.whoiszxl.bean;

import org.springframework.beans.factory.annotation.Value;

public class Girl {

	//@Value("Á±≤®¿ˆ")
	@Value("${my.username}")
	private String name;

	public Girl() {
		//this.name = "æc≤®˚ê";
	}

	public Girl(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void init() {
		System.out.println("Girl.init()");
	}
	
	private void destroy() {
		System.out.println("Girl.destroy()");
	}
}
