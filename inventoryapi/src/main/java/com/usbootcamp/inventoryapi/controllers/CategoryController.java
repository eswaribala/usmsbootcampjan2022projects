package com.usbootcamp.inventoryapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbootcamp.inventoryapi.models.Category;
import com.usbootcamp.inventoryapi.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")

@Slf4j
public class CategoryController {
   @Autowired
	private CategoryService categoryService;
   
   
   @PostMapping({"/v1.0", "/v1.1"})
   public ResponseEntity<?> saveCategory(@RequestBody Category category) {
	   
	   Category categoryObj=this.categoryService.addCategory(category);
	   if(categoryObj!=null)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryObj);
	   else
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Added");
	   
   }
   @GetMapping({"/v1.0", "/v1.1"})
   public List<Category> fetchAllCategories(){
	  
	   return this.categoryService.getAllCategories();
   }
   
   @GetMapping({"/v1.0/{categoryId}", "/v1.1/{categoryId}"})
   public Category fetchCategoryById(@PathVariable("categoryId") long categoryId){
	   return this.categoryService.getCategoryById(categoryId);
   }
   
}
