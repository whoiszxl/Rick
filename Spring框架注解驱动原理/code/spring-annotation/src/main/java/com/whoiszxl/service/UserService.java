package com.whoiszxl.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value="prototype") //����ģʽ��ÿ�ε��ö�����һ���¶��󣬳�ʼ��������
//@Scope(value="singleton") ����ģʽ����ʼ������һ������Ͳ�������
public class UserService {
	
	public UserService() {
		System.out.println("UserService.UserService()");
	}
	@Override
	public String toString() {
		return "UserService []";
	}
}
