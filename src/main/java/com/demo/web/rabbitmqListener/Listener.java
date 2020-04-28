package com.demo.web.rabbitmqListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
*@author:liuhao
*@version:2020年4月27日上午10:02:43
*@description:
*/
@Component
public class Listener {

	@RabbitListener(queues = "test")
	public void getMess(byte[] message) {
		System.out.println("收到的消息："+message);
	}
	
}
