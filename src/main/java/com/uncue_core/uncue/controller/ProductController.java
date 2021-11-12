package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.collections.Product;
import com.uncue_core.uncue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SaloonController saloonController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getProduct() {

        return repository.findBySaloonId(saloonController.getSaloonId());
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Object getProduct(@PathVariable("productId") String productId) {

        if(repository.existsById(productId)){
            return repository.findByProductId(productId).get();
        }

        return "Not Found";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {

        product.setSaloonId(saloonController.getSaloonId());
        repository.save(product);
        return product;

    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable("productId") String productId, @RequestBody Product product){

        product.setProductId(productId);
        product.setSaloonId(saloonController.getSaloonId());

        repository.save(product);
        return repository.findById(productId).get();

    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("productId") String productId){

        if(repository.existsById(productId)) {
            repository.deleteByProductId(productId);
            return "deleted";
        }

        return "Not Found";
    }
}
