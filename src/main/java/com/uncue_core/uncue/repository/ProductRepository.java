package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findBySaloonId(String uid);
    Optional<Product> findByProductId(String id);
    void deleteByProductId(String id);

}
