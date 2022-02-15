package com.virtusa.traderapi.models;

import java.io.Serializable;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
