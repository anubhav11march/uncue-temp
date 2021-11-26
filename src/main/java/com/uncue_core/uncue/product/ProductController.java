package com.uncue_core.uncue.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("${insertOrUpdateProduct}")
    public Product insertProduct(@RequestBody Product product) {

        return productService.insertProduct(product);

    }

    @GetMapping("${reteriveProducts}")
    public List<Product> getProducts(@PathVariable("saloonId") int saloonId) {


        return   productService.getProducts(saloonId);

    }


    @GetMapping("${reteriveProduct}")
    public Product getProduct(@PathVariable("productid") int productid) {
        return   productService.getProduct(productid);

    }


}
