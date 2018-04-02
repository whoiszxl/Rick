package com.whoiszxl.service;

import java.util.List;

import com.whoiszxl.bean.primary.Users;

public interface UserRepositoryService {

	Users createUser(String name, Integer age);
	
	List<Users> selectAllUser();
}
