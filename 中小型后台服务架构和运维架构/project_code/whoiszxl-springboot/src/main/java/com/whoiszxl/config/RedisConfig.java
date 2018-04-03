package com.whoiszxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.whoiszxl.bean.secondary.Star;

@Configuration
public class RedisConfig {
	
	@Bean
	public RedisTemplate<String, Star> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Star> template = new RedisTemplate<String, Star>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		
		return template;
	}
}
