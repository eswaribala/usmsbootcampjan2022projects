package com.usbootcamp.stockapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.usbootcamp.stockapi.facades.StockFacade;
import com.usbootcamp.stockapi.models.Payment;
import com.usbootcamp.stockapi.models.Product;
import com.usbootcamp.stockapi.repositories.ProductRepo;

@Service
public class StockPublisher {
    @Autowired
	private ProductRepo productRepo;
    @Autowired
    private StockConsumerService stockConsumerService;
    @Autowired
    private StockFacade stockFacade;
	public boolean publishStock() {
		
		
		Payment payment=this.stockConsumerService.getPayment();
		if(payment!=null) {
			
		 Product product=this.productRepo.findById(payment.getOrder().getProductId()).orElse(null);
	
		 if(product!=null) {
			 
			 
			 MessageChannel messageChannel=stockFacade.outChannel();
		    	return messageChannel.send(MessageBuilder
		                .withPayload(product)
		                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
		                .build());
		 }
		 else
			 return false;
		
		}
		else
			return false;
		
	}
	
}
