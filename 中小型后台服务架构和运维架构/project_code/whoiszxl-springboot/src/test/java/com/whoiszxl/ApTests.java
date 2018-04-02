package com.whoiszxl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.repo.UserServiceRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApTests {

	@Autowired
	private UserServiceRepo userServiceRepo;
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void createAndDeleteFromDbByJdbcTemplate() throws Exception {
//		for (int i = 0; i < 99; i++) {
//			userServiceRepo.createUser("chenhuixian"+i, i);
//		}
		
		for (int i = 0; i < 99; i++) {
			userServiceRepo.deleteByName("chenhuixian"+i);
		}
		
		
	}

}
