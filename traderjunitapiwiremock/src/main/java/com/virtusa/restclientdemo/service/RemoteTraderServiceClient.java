package com.virtusa.restclientdemo.service;



import java.util.List;

import com.virtusa.restclientdemo.model.Trader;



public interface RemoteTraderServiceClient {

    List<Trader> getAlTraders();
}
