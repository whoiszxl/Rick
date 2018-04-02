package com.whoiszxl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whoiszxl.bean.Users;

/**
 * spring-data-jpa 持久层操作
 * @author whoiszxl
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
