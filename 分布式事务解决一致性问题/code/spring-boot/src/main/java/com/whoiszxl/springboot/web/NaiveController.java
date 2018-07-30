package com.whoiszxl.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaiveController {

	@GetMapping("/angry")
	public String angry() {
		return "I am angry!";
	}
	
}
