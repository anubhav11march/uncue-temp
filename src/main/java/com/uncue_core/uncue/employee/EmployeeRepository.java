package com.uncue_core.uncue.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findBySaloonidOrderByEmployeeidDesc(int uid);
    @Query(value = "SELECT * FROM employee WHERE email=?1 and canLogin=true ", nativeQuery = true)
    Optional<Employee> findByemail(String username);
    Optional<List<Employee>> findByEmail(String username);
}
