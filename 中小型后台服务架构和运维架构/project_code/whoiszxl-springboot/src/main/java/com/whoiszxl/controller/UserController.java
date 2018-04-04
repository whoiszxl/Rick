package com.whoiszxl.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.bean.primary.Users;
import com.whoiszxl.exception.MyException;

import io.swagger.annotations.ApiOperation;

/**
 * 基础测试用户实例
 * @author whoiszxl
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	static Map<Integer, Users> a = Collections.synchronizedMap(new HashMap<Integer, Users>());
	private static Logger logger = Logger.getLogger(UserController.class); 
	
	@ApiOperation(value = "获取用户列表") //swagger2的注释
	@GetMapping("/list")
	public List<Users> getUserList() {
		logger.info("info logger");
		logger.error("info error");
		a.put(1, new Users("chenhuixian", 23));
		a.put(2, new Users("long", 22));
		List<Users> users = new ArrayList<Users>(a.values());
		return users;
	}
	
	@GetMapping("/error")
	public String hello() throws MyException {
		try {
			int a = 1/0;
		} catch (Exception e) {
			throw new MyException("hello this is my demo exception");
		}
		return "11";
	}

}
