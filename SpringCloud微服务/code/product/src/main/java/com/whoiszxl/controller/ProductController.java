package com.whoiszxl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.whoiszxl.ResultVoUtil;
import com.whoiszxl.entity.ProductCategory;
import com.whoiszxl.entity.ProductInfo;
import com.whoiszxl.service.CategoryService;
import com.whoiszxl.service.ProductService;
import com.whoiszxl.vo.ProductInfoVO;
import com.whoiszxl.vo.ProductVO;
import com.whoiszxl.vo.ResultVO;

/**
 * 商品接口
 * @author whoiszxl
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public ResultVO<ProductVO> list() {
		//1.查询上架商品
		List<ProductInfo> productInfos = productService.findUpAll();
		System.out.println("productInfos"+productInfos);
		
		//2.查询类目的type列表
		List<Integer> cateIds = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
		
		//3.从数据库查询类目
		List<ProductCategory> categories = categoryService.findByCategoryTypeIn(cateIds);
		
		//4.构造数据
		List<ProductVO> productVOs = new ArrayList<>();
		//遍历分类
		for (ProductCategory category : categories) {
			//构建一个商品vo类添加分类名称和类型
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(category.getCategoryName());
			productVO.setCategoryType(category.getCategoryType());
			
			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productInfos) {
				if(productInfo.getCategoryType().equals(category.getCategoryType())) {
					ProductInfoVO infoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, infoVO);
					productInfoVOList.add(infoVO);
				}
			}
			
			productVO.setProductInfoVOList(productInfoVOList);
			productVOs.add(productVO);
		}
		
		
		return ResultVoUtil.success(productVOs);
	}
	
	
}
