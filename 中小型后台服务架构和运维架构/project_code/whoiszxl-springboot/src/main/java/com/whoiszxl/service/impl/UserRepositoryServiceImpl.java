package com.whoiszxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoiszxl.bean.Users;
import com.whoiszxl.repo.UserRepository;
import com.whoiszxl.service.UserRepositoryService;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users createUser(String name, Integer age) {
		Users user = userRepository.save(new Users(name,age));
		return user;
	}

	@Override
	public List<Users> selectAllUser() {
		return userRepository.findAll();
	}
	
}
