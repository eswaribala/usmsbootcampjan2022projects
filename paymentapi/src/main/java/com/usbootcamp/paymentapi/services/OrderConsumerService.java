package com.usbootcamp.paymentapi.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumerService {


    @KafkaListener(topics = "${order.topic.name}", 
			groupId = "${order.topic.group.id}")

	public void consumeOrder(String message) {
		
    	log.info(message);
	}
}
