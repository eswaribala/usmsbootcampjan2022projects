package com.usbootcamp.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication


public class InventoryapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryapiApplication.class, args);
	}

}
