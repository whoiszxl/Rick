package com.whoiszxl.bean;

public class Me {
	
	private String name;

	public Me() {
		this.name = "me";
	}

	public Me(String name) {
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
