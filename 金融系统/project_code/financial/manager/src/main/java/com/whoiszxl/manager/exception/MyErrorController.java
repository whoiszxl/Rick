package com.whoiszxl.manager.exception;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

/**
 * 自定义错误处理
 * @author whoiszxl
 *
 */
public class MyErrorController extends BasicErrorController{

	public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties,
			List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes, errorProperties, errorViewResolvers);
	}

	@Override
	protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		// TODO Auto-generated method stub
		Map<String, Object> attrs = super.getErrorAttributes(request, includeStackTrace);
		attrs.remove("timestamp");
		attrs.remove("status");
		attrs.remove("error");
		attrs.remove("exception");
		attrs.remove("path");
		String errorCode = (String) attrs.get("message");
		ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
		attrs.put("message", errorEnum.getMessage());
		attrs.put("code", errorEnum.getCode());
		attrs.put("canRetry", errorEnum.isCanRetry());
		return attrs;
	}
	
}
