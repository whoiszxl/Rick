package com.whoiszxl.bean;

public class Girl {

	private String name;

	public Girl() {
		this.name = "æc≤®˚ê";
	}

	public Girl(String name) {
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
