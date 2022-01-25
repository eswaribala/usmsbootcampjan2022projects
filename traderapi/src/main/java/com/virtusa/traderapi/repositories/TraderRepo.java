package com.virtusa.traderapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;

public interface TraderRepo extends JpaRepository<Trader,Long>{

	//JPA refers class and fields not table
		@Query("select trader from Trader trader where trader.bank=:bank")
		public List<Trader> findByBank(@Param("bank") Bank bank);

}
