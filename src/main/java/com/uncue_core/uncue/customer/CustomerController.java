package com.uncue_core.uncue.customer;

import com.uncue_core.uncue.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class CustomerController {
    @Autowired
    CustomerService service;


    @PutMapping("${insertOrUpdateCustomer}")
    public Customer insertCustomer(@RequestBody Customer customer) {

        return service.insertCustomer(customer);

    }
    @GetMapping("${searchCustomer}")
   public Customer searchCustomer(@PathVariable("searchCustomer") String searchCustomer){
        return service.searchCustomer(searchCustomer);
   }
}
