package com.whoiszxl.manager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.whoiszxl.entity.Product;
import com.whoiszxl.enums.ProductStatus;
import com.whoiszxl.manager.exception.ErrorEnum;
import com.whoiszxl.manager.repositories.ProductRepository;
import com.whoiszxl.manager.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		log.debug("创建产品：参数:{}", product);
		// 数据校验
		checkProduct(product);
		// 設置默認值
		setDefault(product);
		// 保存
		Product result = productRepository.save(product);
		log.debug("创建产品：结果:{}", result);
		return result;
	}
	
	@Override
	public Product findOne(String id) {
		Assert.notNull(id, "产品编号不能为空");
		log.debug("查询单个产品，参数：id={}",id);
		Product result = productRepository.findOne(id);
		log.debug("查询单个产品，结果：result={}",result);
		return result;
	}
	
	@Override
	public Page<Product> query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate,
			List<String> statusList, Pageable pageable) {
		log.debug("条件查询多个产品，idList={},minRewardRate={},maxRewardRate={},statusList={},pageable={}",
				idList,minRewardRate,maxRewardRate,statusList,pageable);
		Specification<Product> specification = new Specification<Product>() {
			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<String> idCol = root.get("id");
				Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
				Expression<String> statusCol = root.get("status");
				List<Predicate> predicates = new ArrayList<>();
				if(idList != null && idList.size() > 0) {
					predicates.add(idCol.in(idList));
				}
				if(minRewardRate != null && BigDecimal.ZERO.compareTo(minRewardRate) < 0) {
					predicates.add(cb.ge(rewardRateCol, minRewardRate));
				}
				if(maxRewardRate != null && BigDecimal.ZERO.compareTo(maxRewardRate) < 0) {
					predicates.add(cb.le(rewardRateCol, maxRewardRate));
				}
				if(statusList != null && statusList.size() > 0) {
					predicates.add(statusCol.in(statusList));
				}
				query.where(predicates.toArray(new Predicate[0]));
				return null;
			}
		};
		Page<Product> page = productRepository.findAll(specification, pageable);
		log.debug("条件查询多个产品，结果：{}", page);
		return page;
	}

	/**
	 * 設置默認值 创建更新时间，投资步长，锁定期，状态
	 * 
	 * @param product
	 */
	private void setDefault(Product product) {
		if (product.getCreateAt() == null) {
			product.setCreateAt(new Date());
		}
		if (product.getUpdateAt() == null) {
			product.setUpdateAt(new Date());
		}
		if (product.getStepAmount() == null) {
			product.setStepAmount(BigDecimal.ZERO);
		}
		if (product.getLockTerm() == null) {
			product.setLockTerm(0);
		}
		if (product.getStatus() == null) {
			product.setStatus(ProductStatus.AUDITING.name());
		}
	}

	/**
	 * 产品数据校验 1. 非空数据 2. 收益率要0-30 3. 投资步长为整数
	 * 
	 * @param product
	 */
	private void checkProduct(Product product) {
		Assert.notNull(product.getId(), ErrorEnum.ID_NOT_NULL.getCode());
		Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate()) < 0
				&& BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >= 0, "收益率要0-30");
		Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0,
				"投资步长为整数");
	}

	

	
}
