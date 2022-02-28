package com.virtusa.restclientdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.restclientdemo.model.Trader;

import java.util.List;

@Service
public class TraderServiceImpl implements TraderService {

    @Autowired
    RemoteTraderServiceClient remoteTraderServiceClient;

   

	@Override
	public List<Trader> getAllTraders() {
		// TODO Auto-generated method stub
		 return remoteTraderServiceClient.getAlTraders();
	}
}
