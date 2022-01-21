package com.virtusa.springcorelab.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Transaction {

	private Customer customer;
	//DI
	@Autowired
	public Transaction(Customer customer) {
		
		this.customer=customer;
	}
	
}
