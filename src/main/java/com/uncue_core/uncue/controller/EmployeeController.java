package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.auth.models.User;
import com.uncue_core.uncue.collections.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.uncue_core.uncue.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("user-details")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<Employee> getEmployees() {

        Employee employee  = new Employee();
        employee.setName("Uday");
        employee.getName();
        return repository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        repository.save(employee);
        return employee;

    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String id){

    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable String id){
        repository.deleteByid(id);
    }



}
