package com.whoiszxl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.bean.primary.Users;
import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.jdbc_temp.UserServiceRepo;
import com.whoiszxl.repo.primary.UserRepository;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarRepositoryService;
import com.whoiszxl.service.UserRepositoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApTests {

	@Autowired
	private UserServiceRepo userServiceRepo;
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private StarRepositoryService starRepositoryService;
	
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
		
		
		
		//测试多数据源
		//userServiceRepo.createStarUser("崔健");
		userServiceRepo.createUser("王菀之11", 29);
	}
	
	@Test
	public void createAndSelectByJpa() throws Exception {
		Users user = userRepositoryService.createUser("窦唯", 24);
		System.out.println(user);
//		List<Users> selectAllUser = userRepositoryService.selectAllUser();
//		System.out.println(selectAllUser);
	}
	
	
	/**
	 * 测试主从数据源JPA操作
	 * @throws Exception
	 */
	@Test
	public void testPrimaryAndSecondaryDbConnect() throws Exception {
		
		userRepositoryService.createUser("窦唯", 18);
	}
	
	
	/**
	 * 分页测试
	 * @throws Exception
	 */
	@Test
	public void pageTest() throws Exception {
//		List<Star> pageContent = starRepositoryService.getPageContent(1, 3);
//		
//		System.out.println(pageContent);
		
		
		List<Star> pageContentByName = starRepositoryService.getPageContentByName(0, 6, "窦唯");
		System.out.println(pageContentByName);
	}
	

}
