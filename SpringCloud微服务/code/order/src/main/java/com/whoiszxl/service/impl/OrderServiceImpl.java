package com.whoiszxl.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whoiszxl.dto.OrderDTO;
import com.whoiszxl.entity.OrderDetail;
import com.whoiszxl.entity.OrderMaster;
import com.whoiszxl.enums.OrderStatusEnum;
import com.whoiszxl.enums.PayStatusEnum;
import com.whoiszxl.repository.OrderDetailRepository;
import com.whoiszxl.repository.OrderMasterRepository;
import com.whoiszxl.service.OrderService;
import com.whoiszxl.utils.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author whoiszxl
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		//TODO 计算商品信息(调用商品服务)
		//TODO 计算总价
		//TODO 扣除库存(调用商品服务)
		
		//订单入库
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(KeyUtil.genUniqueKey());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMaster.setOrderId(KeyUtil.genUniqueKey());
		
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}

}
