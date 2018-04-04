package com.whoiszxl.repo.secondary;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.whoiszxl.bean.secondary.Star;

/**
 * 从数据源的数据库操作
 * @author whoiszxl
 *
 */
@CacheConfig(cacheNames="star_cache1")//缓存会存到star_cache1这个缓存对象中去
@Cacheable
public interface StarRepository extends JpaRepository<Star, Integer>,JpaSpecificationExecutor<Star>{
	
	/**
	 * @Cacheable查询的时候先从缓存中查,查不到就从数据库查询
	 * 
	 */
	List<Star> findByStarname(String starname);
}
