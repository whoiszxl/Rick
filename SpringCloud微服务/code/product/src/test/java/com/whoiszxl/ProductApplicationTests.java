package com.whoiszxl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.entity.ProductCategory;
import com.whoiszxl.entity.ProductInfo;
import com.whoiszxl.enums.ProductStatusEnum;
import com.whoiszxl.repository.ProductCategoryRepository;
import com.whoiszxl.repository.ProductInfoRepository;
import com.whoiszxl.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private ProductService productService;
	
	
	@Test
	public void contextLoads() {
		List<ProductInfo> products = productInfoRepository.findByProductStatus(0);
		System.out.println(products);
		
		List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
		System.out.println(productCategories);
		
		List<ProductInfo> findUpAll = productService.findUpAll();
		System.out.println(findUpAll);
	}
	
	@Test
	public void testASDs() throws Exception {
		System.out.println(ProductStatusEnum.UP.getCode());
	}

}
