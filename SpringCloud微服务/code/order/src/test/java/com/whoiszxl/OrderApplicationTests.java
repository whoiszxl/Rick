package com.whoiszxl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.entity.OrderDetail;
import com.whoiszxl.entity.OrderMaster;
import com.whoiszxl.enums.OrderStatusEnum;
import com.whoiszxl.enums.PayStatusEnum;
import com.whoiszxl.repository.OrderDetailRepository;
import com.whoiszxl.repository.OrderMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	@Autowired
    private OrderDetailRepository orderDetailRepository;
	
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    
	@Test
	public void contextLoads() {
		OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
	}
	
	
	@Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("张学友");
        orderMaster.setBuyerPhone("17688900411");
        orderMaster.setBuyerAddress("香港旺角卡门");
        orderMaster.setBuyerOpenid("100531867979436");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}
