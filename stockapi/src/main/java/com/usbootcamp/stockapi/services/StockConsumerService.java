package com.usbootcamp.stockapi.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.usbootcamp.stockapi.facades.StockFacade;
import com.usbootcamp.stockapi.models.Payment;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockConsumerService {

	private Payment payment;

	@StreamListener(target = StockFacade.input)
    public void handlePayment(@Payload Payment payment) {
     log.info("invoked.....");   
	 log.info("Received Payment details: {}",payment);
	 this.payment=payment;
    }
	
	

}
