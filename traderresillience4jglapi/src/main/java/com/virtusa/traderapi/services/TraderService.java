package com.virtusa.traderapi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.FullName;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.repositories.BankRepo;
import com.virtusa.traderapi.repositories.TraderRepo;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class TraderService {
	@Autowired
	private TraderRepo traderRepo;
	@Autowired
	private BankService bankService;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${nasdaqUrl}")
	private String nasdaqUrl;
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
	@Retry(name = "traderSearch",fallbackMethod = "localTraderSearch")
	public List<Trader> getAllTraders(){
		
		return traderRepo.findAll();
		
	}
	
	//fallback method should have exception as additional parameter
	 public List<Trader> localTraderSearch(RuntimeException re){
	  
		List<Trader> traderList=new ArrayList<Trader>(); 
	    for(int i=0;i<10;i++) {
	    	
	    	traderList.add(new Trader(new Random().nextInt(100000),
	    			new FullName("FirstName"+i,"LastName"+i,""),new Random().nextInt(100000),
	    			"virtusatrader"+i+"@gmail.com",LocalDate.of(1980+new Random().nextInt(10), 
	    					1+new Random().nextInt(11) , 
	    					1+new Random().nextInt(26)), new Bank()));
	    }
	    
	    return traderList;
		 
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
}
