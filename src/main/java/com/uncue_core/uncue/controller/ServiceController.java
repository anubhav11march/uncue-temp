package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.collections.Service;
import com.uncue_core.uncue.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private SaloonController saloonController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Service> getService() {

        return repository.findBySaloonId(saloonController.getSaloonId());
    }

    @RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
    public Object getService(@PathVariable("serviceId") String serviceId) {

        if(repository.existsById(serviceId)){
            return repository.findByServiceId(serviceId).get();
        }

        return "Not Found";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Service addService(@RequestBody Service service) {

        service.setSaloonId(saloonController.getSaloonId());
        repository.save(service);
        return service;

    }

    @RequestMapping(value = "/{serviceId}", method = RequestMethod.PUT)
    public Service updateService(@PathVariable("serviceId") String serviceId, @RequestBody Service service){

        service.setServiceId(serviceId);
        service.setSaloonId(saloonController.getSaloonId());

        repository.save(service);
        return repository.findById(serviceId).get();

    }

    @RequestMapping(value = "/{serviceId}", method = RequestMethod.DELETE)
    public String deleteService(@PathVariable("serviceId") String serviceId){

        if(repository.existsById(serviceId)) {
            repository.deleteByServiceId(serviceId);
            return "deleted";
        }

        return "Not Found";
    }
}
