package com.demo.web.rabbitmqListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TesteMq {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Test
	public void testwork() {
		String message = "sms email!";
		rabbitTemplate.convertAndSend("test", message);
		System.out.println("成功！");
	}
	
	@RabbitListener(queues="test")
	public void listener(String msg) {
		System.out.println("接受到的msg:"+msg);
	}
	
	//fanout广播
	//定义一个交换机，类型是fanout，也就是订阅模式
	@Test
	public void testfanout() {
		//如果消息被监听接受，自动创建交换机
		rabbitTemplate.convertAndSend("logs", "", "我是fanout模式！");
		System.out.println("成功！");
	}

	//route 路由模式
	@Test
	public void testRoute() {
		rabbitTemplate.convertAndSend("directs", "error", "发送info的key的路由信息！");
		System.out.println("成功！");
	}
	
	//topic	动态路由	订阅模式
	@Test
	public void testTopic() {
		rabbitTemplate.convertAndSend("topics", "user.save", "user.save路由消息！");
	}
	
}
