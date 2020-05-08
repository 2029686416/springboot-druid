package com.demo.web.rabbitmqListener.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
*@author:liuhao
*@version:2020年4月28日上午10:22:24
*@description:
*/
@Component
public class FanoutCustomer {

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时队列，这种模式通过交换机将消息传递给队列
					exchange = @Exchange(value = "logs",type = "fanout"))//绑定交换机，指定类型
	})
	public void receive(String message) {
		System.out.println("接收到的fanout消息1是："+message);
	}
	
	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时对应，这种模式通过交换机将消息传递给队列
					exchange = @Exchange(value = "logs",type = "fanout"))//绑定交换机，指定类型
	})
	public void receive2(String message) {
		System.out.println("接收到的fanout消息2是："+message);
	}
}
