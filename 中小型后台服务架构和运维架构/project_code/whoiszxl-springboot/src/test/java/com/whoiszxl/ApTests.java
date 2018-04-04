package com.whoiszxl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whoiszxl.bean.primary.Users;
import com.whoiszxl.bean.secondary.People;
import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.crontask.AsyncTask;
import com.whoiszxl.jdbc_temp.UserServiceRepo;
import com.whoiszxl.repo.PeopleMapper;
import com.whoiszxl.repo.primary.UserRepository;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarRepositoryService;
import com.whoiszxl.service.UserRepositoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.whoiszxl.repo")
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
	
	@Autowired
	private PeopleMapper peopleMapper;
	
	@Test
	public void testMybatis() throws Exception {
//		peopleMapper.insert("陈慧娴", "香港");
//		peopleMapper.insert("张学友", "香港");
//		peopleMapper.insert("窦唯", "北京");
		People p = peopleMapper.findByUsername("张学友");
		System.out.println(p);
	}
	
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Star> redisTemplate;
	
	@Test
	public void testRedis() throws Exception {
		//stringRedisTemplate.opsForValue().set("username", "whoiszxl");
		
		//System.out.println(stringRedisTemplate.opsForValue().get("username"));
		
		//redis使用实体类
		Star s = new Star(1, "崔健");
		redisTemplate.opsForValue().set("star", s);
		Star star = redisTemplate.opsForValue().get("star");
		System.out.println(star);
		
	}
	
	
	@Test
	public void testTran() throws Exception {
		try {
			starRepositoryService.CreateStar("事务测试");
		} catch (Exception e) {
			//手动回滚,测试的时候没设置这个也实现了回滚..
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
	}
	
	@Autowired
	private AsyncTask asyncTask;
	
	/**
	 * 异步测试
	 * @throws Exception
	 */
	@Test
	public void testAsync() throws Exception {
		//不带返回值调用
//		asyncTask.dealNotReturnTask();
//		System.out.println("main task run....");
//		Thread.sleep(4000);
		
		//带返回值调用
		Future<String> future = asyncTask.dealHaveReturnTask();
		System.out.println("开始调用主任务");
		
		while(true) {
			if(future.isCancelled()) {
				System.out.println("异步任务被取消了");
				break;
			}
			
			if(future.isDone()) {
				System.out.println("异步任务执行完成了");
				System.out.println("异步任务的返回值是:"+future.get());
				break;
			}
			
			System.out.println("等待异步任务结束");
			Thread.sleep(1000);
		}
	}
	
}
