package com.uncue_core.uncue.product;

import com.uncue_core.uncue.Security.service.UserInfo;
import com.uncue_core.uncue.saloon.SaloonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserInfo userInfo;




    @PostMapping("${productInsertOrUpdate}")
    public Product addProduct(@RequestBody Product product) {

        product.setSaloonId(userInfo.getLoggedInUser().getUsers().getSaloonid());
        repository.save(product);
        return product;

    }




}
