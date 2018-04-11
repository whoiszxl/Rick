package com.whoiszxl.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.whoiszxl.entity.ProductInfo;

/**
 * 商品信息数据库操作接口
 * @author whoiszxl
 *
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

	List<ProductInfo> findByProductStatus(Integer productStatus);	
}
