package com.usbootcamp.orderapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.orderapi.models.Order;
import com.usbootcamp.orderapi.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
	
    @PostMapping(value="/",params = "version=1.0")
    public ResponseEntity<String> publishOrder(@RequestBody Order order){
    	
    	orderService.publishOrder(order);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body("Order Published...");

    	  }
}
