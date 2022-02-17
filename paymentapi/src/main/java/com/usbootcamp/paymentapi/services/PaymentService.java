package com.usbootcamp.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbootcamp.paymentapi.models.Order;
import com.usbootcamp.paymentapi.models.Payment;
import com.usbootcamp.paymentapi.repositories.PaymentRepo;

@Service
public class PaymentService {
    @Autowired
	private PaymentRepo paymentRepo;
    @Autowired
    private OrderConsumerService orderConsumerService;
	
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
	
}
