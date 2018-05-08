package com.whoiszxl.manager.exception;

/**
 * 错误种类
 * @author whoiszxl
 *
 */
public enum ErrorEnum {

	ID_NOT_NULL("001", "编号不能为空", false),
	UNKNOWN("000", "位置异常", false);
	
	private String code;
	private String message;
	private boolean canRetry;
	ErrorEnum(String code, String message, boolean canRetry) {
		this.code = code;
		this.message = message;
		this.canRetry = canRetry;
	}
	
	public static ErrorEnum getByCode(String code) {
		for (ErrorEnum errorEnum : ErrorEnum.values()) {
			if(errorEnum.code.equals(code)) {
				return errorEnum;
			}
		}
		return UNKNOWN;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isCanRetry() {
		return canRetry;
	}
}
