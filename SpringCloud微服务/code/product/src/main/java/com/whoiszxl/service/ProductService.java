package com.whoiszxl.service;

import java.util.List;

import com.whoiszxl.entity.ProductInfo;

/**
 * 商品 service
 * @author whoiszxl
 *
 */
public interface ProductService {

	List<ProductInfo> findUpAll();
	
}
