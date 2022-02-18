package com.usbootcamp.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.usbootcamp.paymentapi.models.Order;
import com.usbootcamp.paymentapi.models.Payment;
import com.usbootcamp.paymentapi.repositories.PaymentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
    @Autowired
	private PaymentRepo paymentRepo;
    @Autowired
    private OrderConsumerService orderConsumerService;
	@Value("${payment.topic.name}")
    private String paymentTopicName;
    
    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public Payment addPayment(Payment payment) {
    	Order order=this.orderConsumerService.getOrder();
    	if(order.getOrderId()>0)
    	{
    	    payment.setOrder(order);
    		return this.paymentRepo.save(payment);
    	}
    	else
    		return null;
    }
    
    
    public void  publishPayment(long transactionId) {
    	
    	Payment payment=this.paymentRepo.findById(transactionId).orElse(null);
    	//publish payment
    	
		ListenableFuture<SendResult<String, Payment>> future 
			= this.kafkaTemplate.send(paymentTopicName, payment);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, Payment>>() {
            @Override
            public void onSuccess(SendResult<String, Payment> result) {
            	log.info("Sent message: " + payment.getOrder().getOrderId() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            	System.out.println("Sent message: " + payment.getOrder().getOrderAmount()
            			+ " with offset: " + result.getRecordMetadata().offset());
           // status=true;
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	log.error("Unable to send Payment Details : " + payment.getTransactionId(), ex);
              // status=false;
            }
       });
		
	}


    	
    
	
}
