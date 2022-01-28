package com.virtusa.traderapi.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraderInput {
	
	private long traderId;
	private FullNameInput name;	
	private long tradingLimit;
	private String email;
	private String dob;
	private BankTraderInput bank;
}
