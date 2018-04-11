package com.whoiszxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoiszxl.entity.ProductCategory;
import com.whoiszxl.repository.ProductCategoryRepository;
import com.whoiszxl.service.CategoryService;

/**
 * 分类服务接口实现
 * @author whoiszxl
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
		return productCategories;
	}

}
