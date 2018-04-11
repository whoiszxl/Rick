package com.whoiszxl.service;

import com.whoiszxl.dto.OrderDTO;

/**
 * 
 * @author whoiszxl
 *
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
