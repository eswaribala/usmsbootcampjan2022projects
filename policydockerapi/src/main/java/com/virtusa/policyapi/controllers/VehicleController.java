package com.virtusa.policyapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.virtusa.policyapi.models.Vehicle;
import com.virtusa.policyapi.services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired 
	private VehicleService vehicleService;
    
    @PostMapping(value="/",params = "version=1.0")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle){
    	Vehicle vehicleObj=this.vehicleService.saveVehilce(vehicle);
    	Gson gson=new Gson();
    	if(vehicleObj!=null){
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).
    			  body(gson.toJson(vehicleObj));	
    	}
    	else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).
    			  body("Vehicle Not Added");	
    	
    }
    
    @GetMapping(value="/",params="version=1.0")
    public List<Vehicle> getAllVehicles(){
    	return this.vehicleService.getVehicles();
    }
	
}
