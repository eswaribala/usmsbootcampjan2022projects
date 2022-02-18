package com.usbootcamp.inventoryapi.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {
	@Id
	
	private long productId;
	
	private ProductDescription productDescription;
	
	private ProductType productType;
	
	private Category category;
}
