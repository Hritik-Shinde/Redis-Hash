package com.redishash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.redishash.model.Student;

@Configuration
public class RedisConfig {
	
	
	/*
	 * use to set up connection with redis takes properties from application.properties
	 * can be either use with jedis or latest lettuceconnectionfactory
	 */
	@Bean
	public RedisConnectionFactory redisconnectionfactory() {
		return new LettuceConnectionFactory();
		
	}
	
	/*
	 * Use to simplifies operation for redis hash
	 */
	@Bean
	public RedisTemplate<String, Student> redisTemplate(){
		RedisTemplate<String, Student> template = new RedisTemplate<String, Student>();
		template.setConnectionFactory(redisconnectionfactory());
		return template;
	}
}
