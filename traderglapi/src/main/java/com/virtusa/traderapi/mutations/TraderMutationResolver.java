package com.virtusa.traderapi.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.BankInput;
import com.virtusa.traderapi.models.BankTraderInput;
import com.virtusa.traderapi.models.FullName;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.models.TraderInput;
import com.virtusa.traderapi.services.BankService;
import com.virtusa.traderapi.services.TraderService;

@Component
public class TraderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private TraderService traderService;
	
	public Trader createTrader(TraderInput traderInput) {
		
		
		return this.traderService.addTrader(traderInput.getTraderId(),
				new Trader(0,new FullName(traderInput.getName().getFirstName(),traderInput.getName().getLastName(),
						traderInput.getName().getMiddleName()),traderInput.getTradingLimit(),
				traderInput.getEmail(),LocalDate.parse(traderInput.getDob()),new Bank()));
	}
	
	
}
