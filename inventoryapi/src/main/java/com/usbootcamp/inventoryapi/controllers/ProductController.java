package com.usbootcamp.inventoryapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.inventoryapi.models.Category;
import com.usbootcamp.inventoryapi.models.Product;
import com.usbootcamp.inventoryapi.services.CategoryService;
import com.usbootcamp.inventoryapi.services.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController {
	 @Autowired
		private ProductService productService;
	   
	   
	   @PostMapping({"/v1.0/{categoryId}"})
	   public ResponseEntity<?> saveCategory(@RequestBody Product product,@PathVariable("categoryId") long categoryId) {
		   
		   Product productObj=this.productService.addProduct(product, categoryId);
		   if(productObj!=null)
			   return ResponseEntity.status(HttpStatus.ACCEPTED).body(productObj);
		   else
			   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Not Added");
		   
	   }
	   @GetMapping({"/v1.0", "/v1.1"})
	   public List<Product> fetchAllProducts(){
		  
		   return this.productService.getAllProducts();
	   }
	   
	 
}
