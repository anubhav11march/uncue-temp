package com.uncue_core.uncue.service;

import com.uncue_core.uncue.saloon.SaloonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private SaloonController saloonController;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<Service> getService() {
//
//        return repository.findBySaloonId(saloonController.getSaloonId());
//    }
//
//    @RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
//    public Object getService(@PathVariable("serviceId") int serviceId) {
//
//        if(repository.existsById(serviceId)){
//            return repository.findByServiceId(serviceId).get();
//        }
//
//        return "Not Found";
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Service addService(@RequestBody Service service) {
//
//        service.setSaloon_id(saloonController.getSaloonId());
//        repository.save(service);
//        return service;
//
//    }
//
//    @RequestMapping(value = "/{serviceId}", method = RequestMethod.PUT)
//    public Service updateService(@PathVariable("serviceId") int serviceId, @RequestBody Service service){
//
//        service.setService_id(serviceId);
//        service.setSaloon_id(saloonController.getSaloonId());
//
//        repository.save(service);
//        return repository.findById(serviceId).get();
//
//    }
//
//    @RequestMapping(value = "/{serviceId}", method = RequestMethod.DELETE)
//    public String deleteService(@PathVariable("serviceId") int serviceId){
//
//        if(repository.existsById(serviceId)) {
//            repository.deleteByServiceId(serviceId);
//            return "deleted";
//        }
//
//        return "Not Found";
//    }
}
