package com.virtusa.restclientdemo.model;

import java.io.Serializable;
import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Trader implements Serializable{
	
	private long traderId;
	
	//value object
	private FullName name;

	private long tradingLimit;
	
	private String email;
	@DateTimeFormat(iso = ISO.DATE)

	private LocalDate dob;
	
	private Bank bank;

}
