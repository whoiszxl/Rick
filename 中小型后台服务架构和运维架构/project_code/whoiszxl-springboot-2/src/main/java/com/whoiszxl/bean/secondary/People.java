package com.whoiszxl.bean.secondary;

/**
 * mybatis 测试实体类
 * @author whoiszxl
 *
 */
public class People {
	
	private Integer id;
	private String username;
	private String address;
	
	public People() {
		super();
	}
	public People(Integer id, String username, String address) {
		super();
		this.id = id;
		this.username = username;
		this.address = address;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", username=" + username + ", address=" + address + "]";
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
