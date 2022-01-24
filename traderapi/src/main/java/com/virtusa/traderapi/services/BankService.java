package com.virtusa.traderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.repositories.BankRepo;

@Service
public class BankService {
	@Autowired
	private BankRepo bankRepo;
	
	//insert 
	
	public Bank addBank(Bank bank) {
		return this.bankRepo.save(bank);
	}
	
	//list all the banks
	
	public List<Bank> getAllBanks(){
		return this.bankRepo.findAll();
	}
	
	//list bank by Id
	
	public Bank getBankById(long bankId) {
		return this.bankRepo.findById(bankId).orElse(null);
	}
	
	//delete

	public boolean deleteBankById(long bankId) {
		boolean status=false;
		this.bankRepo.deleteById(bankId);
		if(this.getBankById(bankId)==null)
			status=true;
		return status;
	}
	
	//update
	
	public Bank updateBank(Bank bank) {
		return this.bankRepo.save(bank);
	}
	
}
