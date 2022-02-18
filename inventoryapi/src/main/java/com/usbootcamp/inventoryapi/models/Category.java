package com.usbootcamp.inventoryapi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("categories")
public class Category {
    @Id
    
	private long categoryId;
  
	private String categoryName;

    private List<Product> products;
    
	
}
