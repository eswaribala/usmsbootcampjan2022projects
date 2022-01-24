package com.virtusa.traderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.traderapi.models.Trader;

public interface TraderRepo extends JpaRepository<Trader,Long>{

}
