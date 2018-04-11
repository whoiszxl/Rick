package com.whoiszxl.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.whoiszxl.entity.ProductCategory;

/**
 * 商品数据库操作接口
 * @author whoiszxl
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>{

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
