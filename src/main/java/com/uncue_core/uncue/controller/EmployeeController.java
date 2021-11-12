package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.collections.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uncue_core.uncue.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private SaloonController saloonController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> getEmployees() {

        return repository.findBySaloonId(saloonController.getSaloonId());
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Object getEmployee(@PathVariable("employeeId") String employeeId) {

        if(repository.existsById(employeeId)){
            return repository.findByEmployeeId(employeeId).get();
        }

        return "Not Found";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setSaloonId(saloonController.getSaloonId());
        repository.save(employee);
        return employee;

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("employeeId") String employeeId, @RequestBody Employee employee){

        employee.setEmployeeId(employeeId);
        employee.setSaloonId(saloonController.getSaloonId());

        repository.save(employee);
        return repository.findById(employeeId).get();

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("employeeId") String employeeId){

        if(repository.existsById(employeeId)) {
            repository.deleteByEmployeeId(employeeId);
            return "deleted";
        }

        return "Not Found";
    }

}
