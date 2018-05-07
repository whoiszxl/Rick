package com.whoiszxl.enums;

/**
 * 訂單類型枚舉
 * @author whoiszxl
 *
 */
/**
 * @author Administrator
 *
 */
public enum OrderType {
	
	APPLY("申購"),
	REDEEM("贖回");
	
	private String desc;

	OrderType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
