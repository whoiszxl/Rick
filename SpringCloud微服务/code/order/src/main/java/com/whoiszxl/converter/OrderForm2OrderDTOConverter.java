package com.whoiszxl.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.whoiszxl.dto.OrderDTO;
import com.whoiszxl.entity.OrderDetail;
import com.whoiszxl.enums.ResultEnum;
import com.whoiszxl.exception.OrderException;
import com.whoiszxl.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author whoiszxl
 *
 */
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            //log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
