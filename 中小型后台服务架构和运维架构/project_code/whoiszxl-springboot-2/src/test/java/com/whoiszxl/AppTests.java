package com.whoiszxl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class AppTests {

	@Autowired
	private StarRepository starRepository;
	
	@Autowired
	private StarService starService;
	
	@Test
	public void contextLoads() {
		List<Star> a1 = starRepository.findByStarname("定时");
		System.out.println("第一次查询:"+a1);
		List<Star> a2 = starRepository.findByStarname("定时");
		System.out.println("第二次查询:"+a2);
	}
	
	@Test
	public void ehCacheTest() {
		List<Star> all1 = starService.findAll();
		System.out.println("第一次查询:"+all1);
		List<Star> all2 = starService.findAll();
		System.out.println("第二次查询:"+all2);
	}

}
