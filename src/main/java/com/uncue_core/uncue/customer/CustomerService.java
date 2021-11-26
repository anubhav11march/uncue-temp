package com.uncue_core.uncue.customer;

import com.uncue_core.uncue.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
   @Autowired
   CustomerRepository repository;
   public List<Customer> getAllCustomers(int saloonId){
     return  repository.findBySaloonidOrderByCustomeridDesc(saloonId);
   }

    public Customer insertCustomer(Customer customer) {
      return  repository.save(customer);
    }

    public Customer searchCustomer(String searchCustomer) {
       return repository.searchCustomer(searchCustomer);
    }

    public List<Customer> autosuggestName(String searchCustomer) {
       return repository.findByNameStartingWith(searchCustomer);
    }

    public Customer getCustomer(int customerid) {
       return repository.findById(customerid).get();
    }
}
