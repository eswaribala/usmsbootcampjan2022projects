package com.virtusa.policyapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.policyapi.models.Vehicle;
import com.virtusa.policyapi.repositories.VehicleRepository;

@Service
public class VehicleService {
    @Autowired
	private VehicleRepository vehicleRepo;
    
    //save
    public Vehicle saveVehilce(Vehicle vehicle) {
    	return this.vehicleRepo.save(vehicle);
    }
    
    public List<Vehicle> getVehicles(){
    	return this.vehicleRepo.findAll();
    }
    
	public Vehicle getVehicleById(String regNo) {
		return this.vehicleRepo.findById(regNo).orElse(null);
	}
	
	public boolean deleteVehileById(String regNo) {
		boolean status=false;
		this.vehicleRepo.deleteById(regNo);
		if(this.getVehicleById(regNo)==null)
			status=true;
		return status;
	}
}
