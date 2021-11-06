package com.example.uncue.repository;

import com.example.uncue.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Employee, String> {
}
