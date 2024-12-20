package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	@Value("${rabbitmq.queue.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.queue.routing_key}")
	private String routing_key;
	
	private RabbitTemplate rt;
	
	private static final Logger log= LoggerFactory.getLogger(RabbitMQProducer.class);
	
	public RabbitMQProducer(RabbitTemplate rt) {
		// TODO Auto-generated constructor stub
		this.rt=rt;
	}
	public void sendMessage(String message) {
		log.info(String.format("Message", message));
		rt.convertAndSend(exchange,routing_key,message);
	}
	
}
