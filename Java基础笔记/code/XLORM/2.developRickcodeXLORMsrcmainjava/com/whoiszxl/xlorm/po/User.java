package com.whoiszxl.xlorm.po;

import java.sql.*;
import java.util.*;

public class User {

	private Integer id;
	private String username;


	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
