package com.virtusa.policyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.policyapi.models.PolicyHolder;
import com.virtusa.policyapi.models.Vehicle;
import com.virtusa.policyapi.repositories.PolicyHolderRepo;

@Service
public class PolicyHolderService {
	@Autowired
	private PolicyHolderRepo policyHolderRepo;
	@Autowired
	private VehicleService vehicleService;
	
	public PolicyHolder addPolicyHolder(String regNo, PolicyHolder policyHolder) {
		
		Vehicle vehicle=this.vehicleService.getVehicleById(regNo);
		policyHolder.setVehicle(vehicle);
		return this.policyHolderRepo.save(policyHolder);
	}
	
	
	public PolicyHolder getPolicyHolderById(long mobileNo) {
		return this.policyHolderRepo.findById(mobileNo).orElse(null);
	}

}
