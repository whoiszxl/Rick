package com.whoiszxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.whoiszxl.dao.CustomerRepository;
import com.whoiszxl.domain.Customer;

@Service
public class CustomerServiceInCode {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	
	public Customer create(Customer customer) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
		
		TransactionStatus transaction = transactionManager.getTransaction(def);
		Customer result;
		try {
			result = customerRepository.save(customer);
			int a = 1/0;
			transactionManager.commit(transaction);
		} catch (TransactionException e) {
			transactionManager.rollback(transaction);
			throw e;
		}
		return result;
	}
	
}
