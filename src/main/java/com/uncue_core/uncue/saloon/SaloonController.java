package com.uncue_core.uncue.saloon;

import com.uncue_core.uncue.Security.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${BaseUrl}")
public class SaloonController {

    @Autowired
    SaloonRepository saloonRepository;

    @Autowired
    SaloonService service;
    @Autowired
    UserInfo info;

    @PutMapping("${insertOrUpdateSaloon}")
    public Saloon insertSaloon(@RequestBody Saloon saloon){
          return  service.insertSaloon(saloon);
     }








}
