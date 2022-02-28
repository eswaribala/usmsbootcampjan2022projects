package com.virtusa.restclientdemo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Bank implements Serializable{
  
	private long bankId;
    
	private String bankName;

	private String address;
}
