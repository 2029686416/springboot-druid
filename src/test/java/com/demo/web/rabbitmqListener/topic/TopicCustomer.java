package com.demo.web.rabbitmqListener.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
*@author:liuhao
*@version:2020年4月28日上午10:48:18
*@description:
*/
@Component
public class TopicCustomer {

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时队列
					exchange = @Exchange(value = "topics",type="topic"),//自定交换机名称和类型
					key = {"user.save","user.*"}
					)
	})
	public void receive(String message) {
		System.out.println("topic模式接受的消息1："+message);
	}
	
	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,//创建临时队列
					exchange = @Exchange(value = "topics",type="topic"),//自定交换机名称和类型
					key = {"order.#","produce.#","user.*"}
					)
	})
	public void receive2(String message) {
		System.out.println("topic模式接受的消息2："+message);
	}
	
}
