package com.whoiszxl.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.bean.User;

import io.swagger.annotations.ApiOperation;

/**
 * 基础测试用户实例
 * @author whoiszxl
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	static Map<Integer, User> a = Collections.synchronizedMap(new HashMap<Integer, User>());
	
	
	@ApiOperation(value = "获取用户列表") //swagger2的注释
	@GetMapping("/list")
	public List<User> getUserList() {
		a.put(1, new User(1, "chenhuixian", 23));
		a.put(2, new User(2, "long", 22));
		List<User> users = new ArrayList<User>(a.values());
		return users;
	}

}
