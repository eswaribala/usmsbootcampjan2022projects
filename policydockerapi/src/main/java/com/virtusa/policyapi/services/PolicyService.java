package com.virtusa.policyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.policyapi.models.Policy;
import com.virtusa.policyapi.models.PolicyHolder;
import com.virtusa.policyapi.repositories.PolicyRepo;

@Service
public class PolicyService {
    @Autowired
	private PolicyRepo policyRepo;
    @Autowired
    private PolicyHolderService policyHolderService;
    
    public Policy addPolicy(long mobileNo,Policy policy) {
    	
    	PolicyHolder policyHolderObj=this.policyHolderService.getPolicyHolderById(mobileNo);
    	if( policyHolderObj!=null)
    	 policy.setPolicyHolder(policyHolderObj);
    	
    	return this.policyRepo.save(policy);
    	
    }
    
    public Policy getPolicyById(long policyId) {
    	return this.policyRepo.findById(policyId).orElse(null);
    }
	
}
