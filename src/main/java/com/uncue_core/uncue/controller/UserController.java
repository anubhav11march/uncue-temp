package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.auth.SecurityService;
import com.uncue_core.uncue.collections.User;
import com.uncue_core.uncue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityService securityService;

    public User findOrCreateUserInRepository(User user){

        Optional<User> userInRepo = userRepository.findByUid(user.getUid());
        if(userInRepo.isPresent()){
            return userInRepo.get();
        } else {
            User newUser = new User();
            newUser.setUid(user.getUid());
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setEmailVerified(user.isEmailVerified());
            newUser.setIssuer(user.getIssuer());
            newUser.setPicture(user.getPicture());

            userRepository.save(newUser);

            return userRepository.findByUid(newUser.getUid()).get();
        }
    }
    public String getUid() {
        return securityService.getUser().getUid();
    }

    @GetMapping
    public User getUser(){
        return securityService.getUser();
    }


}
