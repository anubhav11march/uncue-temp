package com.uncue_core.uncue.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Employee> getEmployees(int saloonId) {
       return repository.findBySaloonidOrderByEmployeeidDesc(saloonId);
    }

    public Employee getEmployee(int employeeId) {
        if(repository.existsById(employeeId)){
            return repository.findById(employeeId).get();
        }



    return null;
    }

    public Employee insertEmployee(Employee employee) {
        String getPassword =employee.getPassword();
        employee.setPassword(passwordEncoder.encode(getPassword));
        return repository.save(employee);
    }

    public List<EmployeeHistoryDto> getEmployeeHistory(int employeeid) {
      return   repository.getEmployeeHistory(employeeid);
    }
}
