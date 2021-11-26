package com.uncue_core.uncue.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class ServiceController {

    @Autowired
    ServiceService service;

    @GetMapping("${reteriveServices}")
    public List<Service> getServices(@PathVariable int saloonId ) {


        return   service.getServices(saloonId);

    }

    @GetMapping("${reteriveService}")
    public Service getService(@PathVariable("serviceid") int serviceId) {
        return   service.getService(serviceId);

    }

    @PostMapping("${insertOrUpdateService}")
    public Service insertService(@RequestBody Service saloon) {

        return service.insertService(saloon);


    }
}
