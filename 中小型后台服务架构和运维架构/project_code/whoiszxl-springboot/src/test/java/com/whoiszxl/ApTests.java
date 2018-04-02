package com.whoiszxl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.bean.Users;
import com.whoiszxl.jdbc_temp.UserServiceRepo;
import com.whoiszxl.service.UserRepositoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApTests {

	@Autowired
	private UserServiceRepo userServiceRepo;
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void createAndDeleteFromDbByJdbcTemplate() throws Exception {
//		for (int i = 0; i < 99; i++) {
//			userServiceRepo.createUser("chenhuixian"+i, i);
//		}
		
//		for (int i = 0; i < 99; i++) {
//			userServiceRepo.deleteByName("chenhuixian"+i);
//		}
		
		//userServiceRepo.createUser("王菀之", 29);
		
		//测试多数据源
		userServiceRepo.createStarUser("崔健");
	}
	
	@Test
	public void createAndSelectByJpa() throws Exception {
		Users user = userRepositoryService.createUser("窦唯", 24);
		System.out.println(user);
//		List<Users> selectAllUser = userRepositoryService.selectAllUser();
//		System.out.println(selectAllUser);
	}
	

}
