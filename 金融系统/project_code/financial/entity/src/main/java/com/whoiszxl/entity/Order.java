package com.whoiszxl.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.whoiszxl.enums.OrderStatus;
import com.whoiszxl.enums.OrderType;

/**
 * 订单实体类
 * @author whoiszxl
 *
 */
@Entity(name="order_t")
public class Order {
	
	@Id
	private String orderId;
	
	private String chanId;
	
	private String productId;
	
	private String chanUserId;
	
	/**
	 * @see OrderType
	 */
	private String orderType;
	
	/**
	 * @see OrderStatus
	 */
	private String orderStatus;
	
	private String outerOrderId;
	
	private BigDecimal amount;
	
	private String memo;
	
	private Date createAt;
	
	private Date updateAt;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getChanId() {
		return chanId;
	}
	public void setChanId(String chanId) {
		this.chanId = chanId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getChanUserId() {
		return chanUserId;
	}
	public void setChanUserId(String chanUserId) {
		this.chanUserId = chanUserId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOuterOrderId() {
		return outerOrderId;
	}
	public void setOuterOrderId(String outerOrderId) {
		this.outerOrderId = outerOrderId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
