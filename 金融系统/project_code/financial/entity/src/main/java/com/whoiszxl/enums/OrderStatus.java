package com.whoiszxl.enums;

/**
 * 訂單狀態枚舉
 * @author whoiszxl
 *
 */
public enum OrderStatus {
	
	INIT("初始化"),
	PROCESS("處理中"),
	SUCCESS("成功"),
	FAIL("失敗");
	
	private String desc;
	
	OrderStatus(String desc) {
		this.desc = desc;
	}



	public String getDesc() {
		return desc;
	}	
}
