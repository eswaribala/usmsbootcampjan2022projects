package com.virtusa.traderapi.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value="Bank")
	public List<Bank> getAllBanks(){
		return this.bankRepo.findAll();
	}
	
	//list bank by Id
	@Cacheable(value="Bank", key="#bankId")
	public Bank getBankById(long bankId) {
		return this.bankRepo.findById(bankId).orElse(null);
	}
	
	//delete
	 @CacheEvict(value="Bank", key="#bankId")
	public boolean deleteBankById(long bankId) {
		boolean status=false;
		this.bankRepo.deleteById(bankId);
		if(this.getBankById(bankId)==null)
			status=true;
		return status;
	}
	
	//update
	 @CachePut(value="Bank", key="#bankId")
	public Bank updateBank(long bankId,String address) {
		
		Bank bank=this.getBankById(bankId);
		if(bank!=null) {
			bank.setAddress(address);
		}
		
		return this.bankRepo.save(bank);
	}
	
}
