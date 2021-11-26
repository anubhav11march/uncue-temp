package com.uncue_core.uncue.saloon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class SaloonController {
    @Autowired
    private SaloonService service;

    @GetMapping("${reteriveSaloons}")
    public List<Saloon> getSaloons() {


        return   service.getSaloons();

    }

    @GetMapping("${reteriveSaloon}")
    public Saloon getSaloon(@PathVariable("saloonId") int saloonId) {
        return   service.getSaloon(saloonId);

    }

    @PostMapping("${insertOrUpdateSaloon}")
    public Saloon insertSaloon(@RequestBody Saloon saloon) {

        return service.insertSaloon(saloon);


    }


}
