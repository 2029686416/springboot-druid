package com.demo.web.rabbitmqListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.client.Channel;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TesteMq {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Test
	public void testmq() {
		String message = "sms email!";
		rabbitTemplate.convertAndSend("test", message);
		System.out.println("成功！");
	}
	
//	@RabbitListener(bindings = @QueueBinding(
//			exchange=@Exchange("test_exc"),
//			value = @Queue("test")))
//	@RabbitListener(queuesToDeclare = @Queue("test"))
	@RabbitListener(queues="test")
	public void listener(String msg) {
		System.out.println("接受到的msg:"+msg);
	}
	
}
