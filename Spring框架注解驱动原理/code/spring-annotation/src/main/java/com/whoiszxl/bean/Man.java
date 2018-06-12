package com.whoiszxl.bean;

public class Man {

	private String name;

	public Man() {
		this.name = "ˆŒWÓÑ";
	}

	public Man(String name) {
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
