package com.whoiszxl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whoiszxl.entity.OrderDetail;

/**
 * 订单详情数据库接口
 * @author whoiszxl
 *
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
