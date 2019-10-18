package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.demo.web.dao")
public class SpringbootBruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBruidApplication.class, args);
	}

}
