package com.uncue_core.uncue.customer;

import com.uncue_core.uncue.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findBySaloonidOrderByCustomeridDesc(int saloonId);

    @Query(value="select * from `customer` where `customer`.`mailid`= ?1 or `customer`.`contactno` =?1",nativeQuery =true)
    Customer searchCustomer(String searchCustomer);


   List<Customer> findByNameStartingWith(String searchCustomer);
}
