package com.usbootcamp.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbootcamp.inventoryapi.models.Category;
import com.usbootcamp.inventoryapi.models.Product;
import com.usbootcamp.inventoryapi.repositories.CategoryRepository;

@Service
public class CategoryService {
   @Autowired
	private CategoryRepository categoryRepository;   
   
   public Category addCategory(Category category) {
	 
	   return this.categoryRepository.save(category);
   }
   
   public List<Category> getAllCategories(){
   	return this.categoryRepository.findAll();
   }
   
   public Category getCategoryById(long categoryId) {
   	return this.categoryRepository.findById(categoryId).orElse(null);
   }
   
   
}
