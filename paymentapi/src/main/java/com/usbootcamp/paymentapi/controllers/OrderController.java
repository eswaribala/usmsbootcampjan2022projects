package com.usbootcamp.paymentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.paymentapi.models.Order;
import com.usbootcamp.paymentapi.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
	
    @PostMapping(value="/",params = "version=1.0")
    public ResponseEntity<?> publishOrder(@RequestBody Order order){
    	
    	if(orderService.publishOrder(order))
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Order Published....");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order Not Published....");
    }
}
