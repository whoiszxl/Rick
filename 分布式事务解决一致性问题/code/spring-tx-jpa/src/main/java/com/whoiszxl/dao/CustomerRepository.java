package com.whoiszxl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whoiszxl.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findOneByUsername(String username);
}
