package com.usbootcamp.stockapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.stockapi.services.StockPublisher;



@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
	private StockPublisher stockPublisher;
	
    @GetMapping(value="/",params = "version=1.0")
    public ResponseEntity<?> publishOrder(){
    	
    	if(stockPublisher.publishStock())
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Stock Published....");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock Not Published....");
    }
}
