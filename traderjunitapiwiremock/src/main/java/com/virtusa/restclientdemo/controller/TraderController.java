package com.virtusa.restclientdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.restclientdemo.model.Trader;
import com.virtusa.restclientdemo.service.TraderService;

import java.util.List;

@RestController
public class TraderController {

    @Autowired
    private TraderService traderService;

    @GetMapping("/all")
    public List<Trader> getTraders() {
        return traderService.getAllTraders();
    }

}
