package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
