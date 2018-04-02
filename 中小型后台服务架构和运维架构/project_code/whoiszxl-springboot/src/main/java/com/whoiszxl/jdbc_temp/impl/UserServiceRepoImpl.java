package com.whoiszxl.jdbc_temp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.whoiszxl.jdbc_temp.UserServiceRepo;

/**
 * 用户数据持久层实现类
 * @author whoiszxl
 *
 */
@Repository
public class UserServiceRepoImpl implements UserServiceRepo {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate orm_jdbcTemplate;
	
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate swoole_jdbcTemplate;
	
	@Override
	public void createUser(String name, Integer age) {
		orm_jdbcTemplate.update("insert into users(username, age) values(?,?)",name,age);
	}

	@Override
	public void deleteByName(String name) {
		orm_jdbcTemplate.update("delete from users where username = ?",name);
	}

	@Override
	public void createStarUser(String name) {
		swoole_jdbcTemplate.update("insert into star(starname) value(?)",name);
		
	}

}
