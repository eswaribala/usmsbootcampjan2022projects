package com.virtusa.traderapi.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="TRADER-SERVICE")
public interface TraderConsumer {
	   @GetMapping("/traders/?version=1.0")
	      public String getAllTraders();

	     
}
