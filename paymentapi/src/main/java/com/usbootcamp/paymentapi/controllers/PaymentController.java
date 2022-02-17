package com.usbootcamp.paymentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.paymentapi.models.Payment;
import com.usbootcamp.paymentapi.services.PaymentService;

@RestController
@RequestMapping("/")
public class PaymentController {
    @Autowired
	private PaymentService paymentService;
    
    @PostMapping(value="/",params = "version=1.0")
    public ResponseEntity<?> makePayment(@RequestBody Payment payment){
    	
    	Payment paymentObj=this.paymentService.addPayment(payment);
    	if(paymentObj!=null)
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(payment);
    	else
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Transaction Failed");
    }
    
}
