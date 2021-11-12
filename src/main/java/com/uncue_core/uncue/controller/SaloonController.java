package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.auth.SecurityService;
import com.uncue_core.uncue.collections.Saloon;
import com.uncue_core.uncue.repository.SaloonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/saloon")
public class SaloonController {

    @Autowired
    SaloonRepository saloonRepository;

    @Autowired
    SecurityService securityService;

    public Saloon findOrCreateSaloonInRepository(Saloon saloon){

        Optional<Saloon> userInRepo = saloonRepository.findByUid(saloon.getUid());
        if(userInRepo.isPresent()){
            return userInRepo.get();
        } else {
            Saloon newSaloon = new Saloon();
            newSaloon.setUid(saloon.getUid());
            newSaloon.setName(saloon.getName());
            newSaloon.setEmail(saloon.getEmail());
            newSaloon.setEmailVerified(saloon.isEmailVerified());
            newSaloon.setIssuer(saloon.getIssuer());
            newSaloon.setPicture(saloon.getPicture());

            saloonRepository.save(newSaloon);

            return saloonRepository.findByUid(newSaloon.getUid()).get();
        }
    }

    @GetMapping("/uid")
    public String getUid() {
        return securityService.getUser().getUid();
    }

    @GetMapping("/id")
    public String getSaloonId() {
        return getSaloon().getSaloonId();
    }

    @GetMapping("/details")
    public Saloon getSaloon(){
        return saloonRepository.findByUid(getUid()).get();
    }


}
