package com.whoiszxl.enums;

/**
 * 产品销售状态枚举
 * @author whoiszxl
 *
 */
public enum ProductStatus {
	
	AUDITING("审核中"),
	IN_SELL("销售中"),
	LOCKED("暂停销售"),
	FINISHED("已结束");
	
	private String desc;

	ProductStatus(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
