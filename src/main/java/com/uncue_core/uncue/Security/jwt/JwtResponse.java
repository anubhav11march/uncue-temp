package com.uncue_core.uncue.Security.jwt;

import com.uncue_core.uncue.employee.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Setter
@Getter
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String message;
	private Employee users;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, Employee users, String message,
					   Collection<? extends GrantedAuthority> authorities) {
		this.token = accessToken;
		this.authorities = authorities;
		this.message = message;
		this.users=users;

	}

}
