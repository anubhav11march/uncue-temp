package com.uncue_core.uncue.Security.jwt;

import com.uncue_core.uncue.employee.Employee;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@Data
public class CustomUserDetails implements UserDetails {


    private static final long serialVersionUID = 1L;
    private Employee users;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;

    }


    @Override
    public String getPassword() {

        return users.getPassword();
    }

    @Override
    public String getUsername() {

        return users.getEmail();
    }



    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

}
