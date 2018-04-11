package com.whoiszxl.service;

import java.util.List;

import com.whoiszxl.entity.ProductCategory;

/**
 * 分类服务
 * @author whoiszxl
 *
 */
public interface CategoryService {

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
}
