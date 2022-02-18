package com.usbootcamp.inventoryapi.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.usbootcamp.inventoryapi.models.Category;

public interface CategoryRepository extends MongoRepository<Category,Long>{

}
