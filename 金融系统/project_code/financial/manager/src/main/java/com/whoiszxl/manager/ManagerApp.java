package com.whoiszxl.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * manager start app
 * @author whoiszxl
 *
 */
@SpringBootApplication
@EntityScan("com.whoiszxl.entity")
public class ManagerApp {

	public static void main(String[] args) {
		
		SpringApplication.run(ManagerApp.class);
		
	}
}
