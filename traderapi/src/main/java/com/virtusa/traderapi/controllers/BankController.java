package com.virtusa.traderapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.services.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {
	@Autowired
	private BankService bankService;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addBank(@RequestBody Bank bank){
		Bank bankObj=this.bankService.addBank(bank);
		if(bankObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Bank> getAllBanks(){
		return this.bankService.getAllBanks();
	}
	
	//get with id
	
	@GetMapping(value="/{bankId}",params = "version=1.0")
	public ResponseEntity<?> getBankById(@PathVariable("bankId") long bankId){
		Bank bankObj=this.bankService.getBankById(bankId);
		if(bankObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> updateBank(@RequestBody Bank bank){
		Bank bankObj=this.bankService.updateBank(bank);
		if(bankObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Created");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{bankId}",params = "version=1.0")
	public ResponseEntity<?> deleteBankById(@PathVariable("bankId") long bankId){
	
		if(this.bankService.deleteBankById(bankId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bank with "+bankId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Found");
		
	}
	

}
