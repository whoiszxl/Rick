package com.whoiszxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoiszxl.entity.ProductInfo;
import com.whoiszxl.enums.ProductStatusEnum;
import com.whoiszxl.repository.ProductInfoRepository;
import com.whoiszxl.service.ProductService;

/**
 * 商品服务接口实现
 * @author whoiszxl
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Override
	public List<ProductInfo> findUpAll() {
		List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
		return productInfos;
	}

}
