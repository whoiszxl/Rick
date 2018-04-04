package com.whoiszxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启ehcache缓存
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
