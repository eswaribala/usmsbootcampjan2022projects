package com.usbootcamp.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.usbootcamp.paymentapi.facades.OrderFacade;
import com.usbootcamp.paymentapi.models.Order;

@Service
public class OrderService {
    @Autowired
	private OrderFacade orderFacade;
    
    public boolean publishOrder(Order order) {
    	MessageChannel messageChannel=orderFacade.outChannel();
    	return messageChannel.send(MessageBuilder
                .withPayload(order)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    	
    }
    
}
