package com.whoiszxl.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author whoiszxl
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=MyException.class)//对应处理MyException这个类
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception{
		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("Error Message.");
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;
	}
}
