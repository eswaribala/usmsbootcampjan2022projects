package com.virtusa.traderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.traderapi.models.Bank;

public interface BankRepo extends JpaRepository<Bank,Long>{

}
