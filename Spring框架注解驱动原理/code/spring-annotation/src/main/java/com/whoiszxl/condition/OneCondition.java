package com.whoiszxl.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OneCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//������Ը���ҵ�����ж��Ƿ�Ҫ���������
		if("One".equals("One")) {
			return true;
		}
		return false;
	}
}
