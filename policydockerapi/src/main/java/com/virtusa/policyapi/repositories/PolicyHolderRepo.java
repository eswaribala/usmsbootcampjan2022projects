package com.virtusa.policyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.policyapi.models.PolicyHolder;

public interface PolicyHolderRepo extends JpaRepository<PolicyHolder,Long>{

}
