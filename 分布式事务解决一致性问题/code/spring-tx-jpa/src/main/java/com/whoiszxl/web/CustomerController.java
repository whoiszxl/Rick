package com.whoiszxl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.dao.CustomerRepository;
import com.whoiszxl.domain.Customer;
import com.whoiszxl.service.CustomerServiceInAnnotation;
import com.whoiszxl.service.CustomerServiceInCode;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceInAnnotation customerServiceInAnnotation;
	
	@Autowired 
	private CustomerServiceInCode customerServiceInCode;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@PostMapping("/code")
	public Customer createInCode(@RequestBody Customer customer) {
		return customerServiceInCode.create(customer);
	}
	
	@PostMapping("/annotation")
	public Customer createInAnnotation(@RequestBody Customer customer) {
		return customerServiceInAnnotation.create(customer);
	}
	
	@GetMapping("")
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
}
