package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.collections.User;
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

    @Autowired
    private UserController userController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> getEmployees() {

        return repository.findByUid(userController.getUid());
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("employeeId") String employeeId) {
        System.out.println("emp" + employeeId);
        return repository.findById(employeeId).get();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setUid(userController.getUid());
        repository.save(employee);
        return employee;

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") String employeeId, @RequestBody Employee employee){

        employee.setId(employeeId);
        employee.setUid(userController.getUid());

        if(repository.findById(employeeId) == null){
            return (ResponseEntity<Employee>) ResponseEntity.badRequest();
        }

        repository.save(employee);
        return ResponseEntity.ok(employee);

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("employeeId") String employeeId){
        System.out.print("Delete User");
        repository.deleteByid(employeeId);
    }



}
