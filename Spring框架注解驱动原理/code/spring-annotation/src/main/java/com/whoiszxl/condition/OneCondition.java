package com.whoiszxl.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OneCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//这里可以根据业务来判断是否要加载这个类
		if("One".equals("One")) {
			return true;
		}
		return false;
	}
}
