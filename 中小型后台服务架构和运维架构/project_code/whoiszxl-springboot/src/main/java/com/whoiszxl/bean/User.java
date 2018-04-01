package com.whoiszxl.bean;

/**
 * User实体类
 * @author whoiszxl
 *
 */
public class User {
	
	private Integer id;
	private String username;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public User(Integer id, String username, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	public User() {
		super();
	}

}
