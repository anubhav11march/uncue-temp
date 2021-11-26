package com.uncue_core.uncue.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product insertProduct(Product product) {
      return  repository.save(product);
    }

    public List<Product> getProducts(int saloonId) {
      return  repository.findBySaloonIdOrderByProductIdDesc(saloonId);
    }

    public Product getProduct(int productid) {
        return repository.findById(productid).get();
    }
}
