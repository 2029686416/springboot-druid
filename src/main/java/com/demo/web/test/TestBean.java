package com.demo.web.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.demo.web.model.User;

/**
*@author:liuhao
*@version:2020年4月23日上午10:01:29
*@description:
*/
@Configuration
public class TestBean {

	@Autowired
    private Environment env;
	
	@Bean
	public User user() {
		String property = env.getProperty("spring.port");
		User user = new User();
		return user;
		
	}
	
	/*@PostConstruct//项目启动就加载该方法
	public void nm() {
		System.out.println("0---------");
	}*/
	
}
