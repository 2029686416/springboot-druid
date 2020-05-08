package com.demo.web.rabbitmqListener.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
*@author:liuhao
*@version:2020年4月28日上午10:34:57
*@description:
*/
@Component
public class RouteCustomer {

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时队列
					exchange = @Exchange(value = "directs",type="direct"),//自定交换机名称和类型
					key = {"info","error","warn"}
					)
	})
	public void reciver(String message) {
		System.out.println("得到的route2消息是："+message);
	}
	
	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时队列
					exchange = @Exchange(value = "directs",type="direct"),//自定交换机名称和类型
					key = {"error"}
					)
	})
	public void reciver2(String message) {
		System.out.println("得到的route2消息是："+message);
	}
	
	
}
