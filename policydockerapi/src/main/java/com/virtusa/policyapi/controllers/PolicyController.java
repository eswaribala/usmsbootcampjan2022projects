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
import com.virtusa.policyapi.models.Policy;
import com.virtusa.policyapi.services.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
	private PolicyService policyService;
    private Gson gson;
    @PostMapping(value="/{mobileNo}",params="version=1.0")
    public ResponseEntity<String> addPolicy(@PathVariable("mobileNo") long mobileNo,@RequestBody Policy policy){
    	
    	Policy policyObj=this.policyService.addPolicy(mobileNo, policy);
    	gson=new Gson();
    	if(policyObj!=null) {
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(policyObj));
    	}
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Policy Not Added");
    }
    
}
