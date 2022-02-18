package com.usbootcamp.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbootcamp.inventoryapi.models.Product;
import com.usbootcamp.inventoryapi.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
	private ProductRepository productRepository;
    
    
    public Product addProduct(Product product) {
    	return this.productRepository.save(product);
    }
    
    public List<Product> getAllProducts(){
    	return this.productRepository.findAll();
    }
    
    public Product getProductById(long productId) {
    	return this.productRepository.findById(productId).orElse(null);
    }
    
}
