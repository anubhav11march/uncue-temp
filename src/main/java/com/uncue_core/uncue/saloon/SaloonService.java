package com.uncue_core.uncue.saloon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaloonService {

    @Autowired
    SaloonRepository repository;

    public Saloon insertSaloon(Saloon saloon) {
       return repository.save(saloon);
    }
}
