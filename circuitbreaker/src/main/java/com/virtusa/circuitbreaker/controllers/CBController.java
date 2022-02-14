package com.virtusa.circuitbreaker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.circuitbreaker.handlers.CBHandler;

@RestController
public class CBController {

	@Autowired
	private CBHandler cbHandler;
	@GetMapping("/traders")
	public ResponseEntity<?> callCBHandler(){
		
		cbHandler.requestHandler();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Circuit Closed");
	}
}
