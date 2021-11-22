package com.uncue_core.uncue.Security.service;

import com.uncue_core.uncue.ApplicationLevel;
import com.uncue_core.uncue.Security.jwt.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserInfo {
    @Autowired
    ApplicationLevel applicationLevel;
    public CustomUserDetails getLoggedInUser() {

        return	(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
