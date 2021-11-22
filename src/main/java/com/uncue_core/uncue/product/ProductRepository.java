package com.uncue_core.uncue.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findBySaloonId(int uid);
    Optional<Product> findByProductId(int id);
    void deleteByProductId(int id);

}
