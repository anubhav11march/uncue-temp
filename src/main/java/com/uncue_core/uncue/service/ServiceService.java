package com.uncue_core.uncue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository repository;

    public List<com.uncue_core.uncue.service.Service> getServices(int saloonId) {
        return repository.findBySaloonIdOrderByServiceIdDesc(saloonId);
    }

    public com.uncue_core.uncue.service.Service getService(int serviceId) {
        return repository.findById(serviceId).get();

    }

    public com.uncue_core.uncue.service.Service insertService(com.uncue_core.uncue.service.Service service) {
        return repository.save(service);
    }
}
