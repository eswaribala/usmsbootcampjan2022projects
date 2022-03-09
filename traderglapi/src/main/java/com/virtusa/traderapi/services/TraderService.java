package com.virtusa.traderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.repositories.BankRepo;
import com.virtusa.traderapi.repositories.TraderRepo;

@Service
public class TraderService {
	@Autowired
	private TraderRepo traderRepo;
	@Autowired
	private BankService bankService;
	
	//insert 	
	public Trader addTrader(long bankId,Trader trader) {
	
		 Bank bank=this.bankService.getBankById(bankId);
		 if(bank!=null) 
			 trader.setBank(bank);		
		 
		 else
			 trader.setBank(null);
		 this.traderRepo.save(trader);
		 return trader;
		 
		}
	
	
	
	//list all the traders
	
	public List<Trader> getAllTraders(){
		return this.traderRepo.findAll();
	}
	
	//list trader by Id
	
	public Trader getTraderById(long traderId) {
		return this.traderRepo.findById(traderId).orElse(null);
	}
	
	//delete

	public boolean deleteTraderById(long traderId) {
		boolean status=false;
		this.traderRepo.deleteById(traderId);
		if(this.getTraderById(traderId)==null)
			status=true;
		return status;
	}
	
	//update
	
public List<Trader> updateBank(long bankId) {
		
		Bank bank=this.bankService.getBankById(bankId);
		
		List<Trader> traderList=this.traderRepo.findByBank(bank);
		
	    for(Trader trader:traderList) {
	    	trader.setBank(null);
	    	this.traderRepo.save(trader);
	    }
		
		return traderList;
	}

   public List<String> getAllDistinctBankNames(){
	   return this.traderRepo.findAllDistinctBanks();
   }

}



