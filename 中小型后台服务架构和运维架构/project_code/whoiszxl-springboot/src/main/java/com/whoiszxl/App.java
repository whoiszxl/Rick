package com.whoiszxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时任务
@EnableAsync //开启异步调用
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
