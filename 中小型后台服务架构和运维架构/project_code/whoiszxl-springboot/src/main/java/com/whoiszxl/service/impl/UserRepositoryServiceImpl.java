package com.whoiszxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoiszxl.bean.primary.Users;
import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.repo.primary.UserRepository;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.UserRepositoryService;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StarRepository starRepository;
	
	@Override
	public Users createUser(String name, Integer age) {
		Users user = userRepository.save(new Users(name,age));
		return user;
//		starRepository.save(new Star(8, name));
//		return null;
	}

	@Override
	public List<Users> selectAllUser() {
		return userRepository.findAll();
	}
	
}
