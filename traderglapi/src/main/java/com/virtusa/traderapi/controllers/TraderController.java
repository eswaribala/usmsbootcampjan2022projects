package com.virtusa.traderapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;

import com.virtusa.traderapi.services.TraderService;

@RestController
@RequestMapping("/traders")
public class TraderController {
	@Autowired
	private TraderService traderService;
	
	//post
	@PostMapping(value="/{bankId}",params = "version=1.0")
	public ResponseEntity<?> addTrader(@PathVariable("bankId") long bankId,@RequestBody Trader trader){
		Trader traderObj=this.traderService.addTrader(bankId,trader);
		if(traderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(traderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Trader Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Trader> getAllTraders(){
		return this.traderService.getAllTraders();
	}
	
	

	@PutMapping(value="/{bankId}",params = "version=1.0")
	public List<Trader> updateTraderWithFKNull(@PathVariable("bankId") long bankId){
		
		return this.traderService.updateBank(bankId);
		
		
	}
	
	
	//get
			@GetMapping(value="/filters/{traderId}",params = "version=1.0")
			public ResponseEntity<?> getTraderByFields(@PathVariable("traderId") long traderId,
					@RequestParam(name = "fields", required = false) String fields){
				
				Map<Object,Object> model=new HashMap<>();
		    	
		    	Trader trader = this.traderService.getTraderById(traderId);
		    	
		    	if(trader!=null)
		    	{
		    		//fields refers to runtime selection
		    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);  		
					return ResponseEntity.ok(SquigglyUtils.stringify(mapper, trader));

		    	}
		    	else
		    	{
			         model.put("message", "trader not existing");
				        
			         return ResponseEntity.ok(model);
		    	}

				
				
			}
	
	
		
	
	
}
