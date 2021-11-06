package com.example.uncue.repository;

import com.example.uncue.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

//    Employee findBy_id(String _id);
//
//    List<Employee> findByUserid(String userid);
//
//    void deleteBy_id(String _id);

}
