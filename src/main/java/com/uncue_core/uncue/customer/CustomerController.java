package com.uncue_core.uncue.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class CustomerController {
    @Autowired
    CustomerService service;



    @PostMapping("${insertOrUpdateCustomer}")
    public Customer insertCustomer(@RequestBody Customer customer) {

        return service.insertCustomer(customer);

    }
    @GetMapping("${reteriveCustomers}")
    public List<Customer> getCustomers(@PathVariable("saloonId") int saloonId) {


        return   service.getAllCustomers(saloonId);

    }

    @GetMapping("${reteriveCustomer}")
    public Customer getCustomer(@PathVariable("customerid") int customerid) {
        return   service.getCustomer(customerid);

    }
    @GetMapping("${searchCustomer}")
   public Customer searchCustomer(@PathVariable("searchCustomer") String searchCustomer){
        return service.searchCustomer(searchCustomer);
   }
    @GetMapping("${autosuggestName}")
    public List<Customer> autosuggestName(@PathVariable("searchCustomer") String searchCustomer){
        return service.autosuggestName(searchCustomer);
    }
}
