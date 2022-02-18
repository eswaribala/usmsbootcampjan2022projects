package com.usbootcamp.inventoryapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usbootcamp.inventoryapi.models.Product;

public interface ProductRepository extends MongoRepository<Product,Long>{

}
