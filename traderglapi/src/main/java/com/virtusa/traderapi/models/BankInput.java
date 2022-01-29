package com.virtusa.traderapi.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankInput implements Serializable{
	private String bankName;
	private String address;

}
