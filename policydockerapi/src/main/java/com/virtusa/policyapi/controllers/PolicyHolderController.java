package com.virtusa.policyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.virtusa.policyapi.models.PolicyHolder;
import com.virtusa.policyapi.services.PolicyHolderService;

@RestController
@RequestMapping("/policyholders")
public class PolicyHolderController {
    @Autowired
	private PolicyHolderService policyHolderService;
    
	@PostMapping(value="/{regNo}",params = "version=1.0")
    public ResponseEntity<String> addPolicyHolder(@PathVariable("regNo") String regNo,@RequestBody PolicyHolder policyHolder){
    	PolicyHolder policyHolderObj=this.policyHolderService.addPolicyHolder(regNo, policyHolder);
    	Gson gson=new Gson();
    	if(policyHolderObj!=null){
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).
    			  body(gson.toJson(policyHolderObj));	
    	}
    	else
    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).
    			  body("PolicyHolder Not Added");	
    	
    }
}
