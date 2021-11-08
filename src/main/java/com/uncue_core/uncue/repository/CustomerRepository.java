package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Employee, String> {
}
