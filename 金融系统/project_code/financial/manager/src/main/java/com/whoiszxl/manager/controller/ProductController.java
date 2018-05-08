package com.whoiszxl.manager.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.Port;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.entity.Product;
import com.whoiszxl.manager.service.IProductService;

/**
 * 产品控制器
 * 
 * @author whoiszxl
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@PostMapping(value = "")
	public Product addProduct(@RequestBody Product product) {
		log.info("controller添加产品，参数：{}", product);
		Product result = productService.addProduct(product);
		log.info("controller添加产品，结果：{}", result);
		return result;
	}

	@GetMapping("/{id}")
	public Product findOne(@PathVariable String id) {
		log.info("查询单个产品，参数：id={}", id);
		Product result = productService.findOne(id);
		log.info("查询单个产品，结果：result={}", result);
		return result;
	}

	@GetMapping("")
	public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewardRate, String status,
			int pageNum, int pageSize) {
		log.info("条件查询多个产品，idList={},minRewardRate={},maxRewardRate={},statusList={},pageNum={},pageSize={}", ids,
				minRewardRate, maxRewardRate, status, pageNum, pageSize);
		List<String> idList = null,statusList = null;
		if(StringUtils.isNotEmpty(ids)) {
			idList = Arrays.asList(ids.split(","));
		}
		
		if(StringUtils.isNotEmpty(status)) {
			statusList = Arrays.asList(status.split(","));
		}
		Pageable pageable = new PageRequest(pageNum, pageSize);
		Page<Product> query = productService.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
		log.info("条件查询多个产品，结果：{}", query);
		return query;
	}
}
