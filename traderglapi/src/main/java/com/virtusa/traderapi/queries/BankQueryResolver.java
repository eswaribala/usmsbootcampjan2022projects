package com.virtusa.traderapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.services.BankService;

public class BankQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private BankService bankService;
	
	public List<Bank> findAllBanks(){
		return this.bankService.getAllBanks();
	}
	
	public Bank findBank(long bankId) {
	
		return this.bankService.getBankById(bankId);
	}

}
