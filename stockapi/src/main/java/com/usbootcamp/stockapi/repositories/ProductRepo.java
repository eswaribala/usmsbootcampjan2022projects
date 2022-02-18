package com.usbootcamp.stockapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usbootcamp.stockapi.models.Product;

public interface ProductRepo extends MongoRepository<Product,Long>{

}
