package com.whoiszxl.repo.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whoiszxl.bean.primary.Users;

/**
 * 主数据源的 spring-data-jpa 持久层操作
 * @author whoiszxl
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
