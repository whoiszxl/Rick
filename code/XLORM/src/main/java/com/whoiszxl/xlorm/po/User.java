package com.whoiszxl.xlorm.po;

import java.sql.*;
import java.util.*;

public class User {

	private Timestamp birthday;
	private Integer id;
	private String username;


	public Timestamp getBirthday() {
		return birthday;
	}
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}


	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", id=" + id + ", username=" + username + "]";
	}
	
	
}
