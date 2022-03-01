package com.virtusa.policyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.policyapi.models.Policy;

public interface PolicyRepo extends JpaRepository<Policy,Long>{

}
