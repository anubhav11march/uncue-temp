package com.uncue_core.uncue.saloon;

import com.uncue_core.uncue.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaloonService {
    @Autowired
    SaloonRepository repository;
    EmployeeRepository employeeRepository;
    public Saloon insertSaloon(Saloon saloon) {
      return   repository.save(saloon);


    }

    public Saloon getSaloon(int saloonId) {
        return repository.findById(saloonId).get();
    }

    public List<Saloon> getSaloons() {
        return repository.findAllByOrderBySaloonIdDesc();
    }
}
