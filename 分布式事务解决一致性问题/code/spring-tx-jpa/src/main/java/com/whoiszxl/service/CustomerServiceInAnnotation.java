package com.whoiszxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whoiszxl.dao.CustomerRepository;
import com.whoiszxl.domain.Customer;

@Service
public class CustomerServiceInAnnotation {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}
	
}
