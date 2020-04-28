package com.demo.web.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
*@author:liuhao
*@version:2020年4月18日下午2:31:40
*@description:
*/

@Component
public class Schedule {

	public static void main(String[] args) {
		
	}
	
//	@Scheduled(cron="0/10 * * * * ? ")
	public void TestSchedule() {
		System.out.println(new Date());
	}
}
