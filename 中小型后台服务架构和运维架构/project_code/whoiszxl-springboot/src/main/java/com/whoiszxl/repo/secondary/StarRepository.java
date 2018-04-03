package com.whoiszxl.repo.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.whoiszxl.bean.secondary.Star;

/**
 * 从数据源的数据库操作
 * @author whoiszxl
 *
 */
@Repository("starRepository")
public interface StarRepository extends JpaRepository<Star, Integer>,JpaSpecificationExecutor<Star>{

	
}
