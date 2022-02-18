package com.usbootcamp.inventoryapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescription {
   
	private String productName;

  
	private String dop;
   
	private long cost;
}
