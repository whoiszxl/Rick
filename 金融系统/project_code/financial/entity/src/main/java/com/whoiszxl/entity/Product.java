package com.whoiszxl.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.whoiszxl.enums.ProductStatus;

import io.swagger.annotations.ApiModel;

/**
 * 产品实体类
 * @author whoiszxl
 *
 */
@Entity
@ApiModel(value = "ppp", description = "产品模型")
public class Product {

	@Id
	private String id;
	private String name;
	
	/**
	 * @see ProductStatus
	 */
	private String status;
	/**
	 * 起投金额
	 */
	private BigDecimal thresholdAmount;
	
	/**
	 * 投资步长
	 */
	private BigDecimal stepAmount;
	
	/**
	 * 锁定期
	 */
	private Integer lockTerm;
	
	/**
	 * 收益率
	 */
	private BigDecimal rewardRate;

	private String memo;
	private Date createAt;
	private Date updateAt;
	private String createUser;
	private String updateUser;
	
	public Product() {
	}

	

	public Product(String id, String name, String status, BigDecimal thresholdAmount, BigDecimal stepAmount,
			BigDecimal rewardRate) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.thresholdAmount = thresholdAmount;
		this.stepAmount = stepAmount;
		this.rewardRate = rewardRate;
	}



	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getThresholdAmount() {
		return thresholdAmount;
	}
	public void setThresholdAmount(BigDecimal thresholdAmount) {
		this.thresholdAmount = thresholdAmount;
	}
	public BigDecimal getStepAmount() {
		return stepAmount;
	}
	public void setStepAmount(BigDecimal stepAmount) {
		this.stepAmount = stepAmount;
	}
	public Integer getLockTerm() {
		return lockTerm;
	}
	public void setLockTerm(Integer lockTerm) {
		this.lockTerm = lockTerm;
	}
	public BigDecimal getRewardRate() {
		return rewardRate;
	}
	public void setRewardRate(BigDecimal rewardRate) {
		this.rewardRate = rewardRate;
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
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
