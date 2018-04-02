package com.whoiszxl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User实体类
 * @author whoiszxl
 *
 */
@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
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
	public Users(String username, Integer age) {
		this.username = username;
		this.age = age;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + "]";
	}

	
}
