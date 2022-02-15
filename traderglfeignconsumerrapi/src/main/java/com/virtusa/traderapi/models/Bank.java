package com.virtusa.traderapi.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank implements Serializable{
   
	private long bankId;
    
	private String bankName;
   
	private String address;
}
