package com.usbootcamp.stockapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usbootcamp.stockapi.models.Category;

public interface CategoryRepo extends MongoRepository<Category,Long> {

}
