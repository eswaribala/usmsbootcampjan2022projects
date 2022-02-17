package com.usbootcamp.paymentapi.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.usbootcamp.paymentapi.models.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumerService {


    @KafkaListener(topics = "${order.topic.name}", 
			groupId = "${order.topic.group.id}")

	public void consumeOrder(String message) {
		
    	log.info(message);
    	Gson gson = new Gson();
    	Order order = gson.fromJson(message, Order.class);
    	log.info(order.getOrderId()+","+order.getOrderDate().toString()+","+order.getOrderAmount());
	}
}
