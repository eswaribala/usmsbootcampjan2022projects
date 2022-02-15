package com.virtusa.traderapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.services.TraderConsumer;


@RestController
public class TraderController {
	@Autowired
	private TraderConsumer traderConsumer;
	
	  @GetMapping("/traders")
      public String getBooksInfo() {
         return "Accessing from TRADER-SERVICE ==> " + traderConsumer.getAllTraders();
      }
	
	
}
