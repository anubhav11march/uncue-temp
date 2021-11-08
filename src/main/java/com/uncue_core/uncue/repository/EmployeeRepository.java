package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

//    Employee findBy_id(String _id);
//
//    List<Employee> findByUserid(String userid);
//
    void deleteByid(String id);

}
