package com.whoiszxl.manager.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whoiszxl.entity.Product;

/**
 * 产品服务
 * 
 * @author whoiszxl
 *
 */
public interface IProductService {
	/**
	 * 添加产品
	 * 
	 * @param product 产品对象
	 * @return
	 */
	Product addProduct(Product product);

	/**
	 * 通过id查询单个产品
	 * 
	 * @param id 产品主键id
	 * @return 产品对象
	 */
	Product findOne(String id);

	/**
	 * 条件查询
	 * @param idList 主键id集合
	 * @param minRewardRate 最小收益率
	 * @param maxRewardRate 最大收益率
	 * @param statusList 状态集合
	 * @param pageable 分页参数
	 * @return 条件查询后的结果
	 */
	Page<Product> query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate,
			List<String> statusList, Pageable pageable);
}
