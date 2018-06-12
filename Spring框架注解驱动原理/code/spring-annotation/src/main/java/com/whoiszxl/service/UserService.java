package com.whoiszxl.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value="prototype") //多例模式，每次调用都创建一个新对象，初始化不创建
//@Scope(value="singleton") 单例模式，初始化创建一个对象就不创建了
public class UserService {
	
	public UserService() {
		System.out.println("UserService.UserService()");
	}
	@Override
	public String toString() {
		return "UserService []";
	}
}
