package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.demo.web.dao")
@EnableScheduling
public class SpringbootBruidApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBruidApplication.class, args);
	}

}
