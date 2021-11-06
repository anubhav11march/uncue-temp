package com.example.uncue.controller;

import com.example.uncue.collections.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.uncue.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getEmployees() {

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
        repository.deleteBy_id(id);
    }



}
