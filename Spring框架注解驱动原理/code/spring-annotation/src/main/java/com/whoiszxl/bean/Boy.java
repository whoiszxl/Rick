package com.whoiszxl.bean;

public class Boy {

	private String name;

	public Boy() {
		this.name = "¼Á÷Ã÷ÈÕÏã";
	}

	public Boy(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
