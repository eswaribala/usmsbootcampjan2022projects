package com.virtusa.traderapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.services.BankService;
import com.virtusa.traderapi.services.TraderService;
@Component
public class TraderQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private TraderService traderService;
	
	public List<Trader> findAllTraders(){
		return this.traderService.getAllTraders();
	}
	
	public Trader findTrader(long traderId) {
	
		return this.traderService.getTraderById(traderId);
	}

}
