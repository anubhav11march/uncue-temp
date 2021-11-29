package com.uncue_core.uncue.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("${reteriveEmployees}")
    public List<Employee> getEmployees(@PathVariable("saloonId") int saloonId) {


     return   employeeService.getEmployees(saloonId);

    }

    @GetMapping("${reteriveEmployee}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
         return   employeeService.getEmployee(employeeId);

    }

    @PostMapping("${insertOrUpdateEmployee}")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.insertEmployee(employee);

    }

    @GetMapping("${getEmployeeHistory}")
    public List<EmployeeHistoryDto>  getEmployeeHistory(@PathVariable("employeeid") int employeeid){
        return employeeService.getEmployeeHistory(employeeid);
    }



}
