package com.whoiszxl.bean;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PerfectMan {
	
	
	public PerfectMan() {
		System.out.println("PerfectMan.PerfectMan()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("PerfectMan.init(对象创建赋值之后执行)");
	}
	
	@PreDestroy
	public void over() {
		System.out.println("PerfectMan.over(在销毁前执行)");
	}
}
