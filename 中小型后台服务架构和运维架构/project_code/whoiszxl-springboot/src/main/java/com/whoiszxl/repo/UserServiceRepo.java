package com.whoiszxl.repo;

/**
 * 用户数据持久层接口
 * @author whoiszxl
 *
 */
public interface UserServiceRepo {

	/**
	 * 新增用户
	 * @param name
	 * @param age
	 */
	void createUser(String name, Integer age);
	
	/**
	 * 删除用户 
	 * @param name
	 */
	void deleteByName(String name);
	
	
	
	
}
