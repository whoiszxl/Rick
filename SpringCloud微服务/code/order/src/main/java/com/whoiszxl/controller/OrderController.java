package com.whoiszxl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.converter.OrderForm2OrderDTOConverter;
import com.whoiszxl.dto.OrderDTO;
import com.whoiszxl.enums.ResultEnum;
import com.whoiszxl.exception.OrderException;
import com.whoiszxl.form.OrderForm;
import com.whoiszxl.service.OrderService;
import com.whoiszxl.utils.ResultVOUtil;
import com.whoiszxl.vo.ResultVO;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author whoiszxl
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;


	@RequestMapping("/create")
	@ApiOperation(value = "创建订单")
	public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
            BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
            //log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
		
		// orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            //log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
	}

}
