package com.virtusa.traderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableCaching
@EnableEurekaClient
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class TraderapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraderapiApplication.class, args);
	}
	
}
