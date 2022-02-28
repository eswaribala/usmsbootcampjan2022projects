package com.virtusa.restclientdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.restclientdemo.model.Trader;

import java.util.List;

@Service
public class RemoteTraderServiceClientImpl implements RemoteTraderServiceClient{

    @Value(value = "${remote.url}")
    private String remoteServiceURL;

    private final RestTemplate restTemplate;

    @Autowired
    public RemoteTraderServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
	@Override
	public List<Trader> getAlTraders() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Trader>> responseEntity = restTemplate.exchange(remoteServiceURL, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Trader>>(){});
        return responseEntity.getBody();
	}

	
}
