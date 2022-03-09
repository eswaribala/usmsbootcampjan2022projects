package com.usbootcamp.orderapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.usbootcamp.orderapi.models.Order;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class OrderService {
   
	@Value("${order.topic.name}")
    private String orderTopicName;
    
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;
 public void  publishOrder(Order order) {
    	
    	
    	
		ListenableFuture<SendResult<String, Order>> future 
			= this.kafkaTemplate.send(orderTopicName, order);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() {
            @Override
            public void onSuccess(SendResult<String, Order> result) {
            	log.info("Sent message: " + order.getOrderId() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            	System.out.println("Sent message: " + order.getOrderAmount()
            			+ " with offset: " + result.getRecordMetadata().offset());
           // status=true;
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	log.error("Unable to send Order Details : " + order.getOrderId(), ex);
              // status=false;
            }
       });
		
	}
    
}
