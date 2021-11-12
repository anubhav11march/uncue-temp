package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findBySaloonId(String uid);
    Optional<Employee> findByEmployeeId(String id);
    void deleteByEmployeeId(String id);

}
