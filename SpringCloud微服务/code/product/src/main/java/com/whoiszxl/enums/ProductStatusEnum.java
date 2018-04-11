package com.whoiszxl.enums;

import org.springframework.stereotype.Component;

/**
 * 商品状态枚举类
 * @author whoiszxl
 *
 */
public enum ProductStatusEnum {

	UP(0,"上架"),
	DOWN(1,"下架"),
	;
	
	private Integer code;
	private String message;
	ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
