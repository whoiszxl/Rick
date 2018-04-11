package com.whoiszxl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whoiszxl.entity.OrderMaster;

/**
 * 订单购买人数据库接口
 * @author whoiszxl
 *
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
