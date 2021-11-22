package com.uncue_core.uncue.Security.jwt;

import com.uncue_core.uncue.AES.AESEncryptionUtilClass;
import com.uncue_core.uncue.ApplicationLevel;
import com.uncue_core.uncue.Security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthTokenFilter  extends OncePerRequestFilter {

	@Autowired
	private JwtProvider tokenProvider;

	@Autowired
	private UserService userDetailsService;

	@Autowired
	ApplicationLevel applicationLevel;
	
//	@Autowired
//	AESEncryptionUtilClass AESEncryption;
	
	
	
	//@Autowired
	//TownshipAccessPermissionRepository townshipAccessPermissionRepository;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			
			String jwt = getJwt(request);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				// System.out.println("token key is:"+jwt);
				applicationLevel.tokenKey = jwt;
				String username = tokenProvider.getUserNameFromJwtToken(jwt);
				CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
				

				if (applicationLevel.LoggedInUsersList.get(jwt) != null) {
					/**
					 * here we are setting the townshipId of current logged in user
					 * if that current logged in users townshipid is not in the hashmap then we will not set the townshipid 
					 * because the requrst is coming from old mobile versions
					 */
//					if(applicationLevel.LoggedinUsersId.containsKey(userDetails.getResidentDetails().getResidentId())) {
//						userDetails.getResidentDetails().setTownshipId(applicationLevel.LoggedinUsersId.get(userDetails.getResidentDetails().getResidentId()));
//					/**
//					 *here i am setting the mobile app access from townshipaccesspermission table in session 
//					 */
//						userDetails.getResidentDetails().setMobileAppAccess(townshipAccessPermissionRepository.checkMobileAccessAccessYesOrNo(userDetails.getResidentDetails().getResidentId(),userDetails.getResidentDetails().getTownshipId()));
//					}
					
					// compare Jwt token came from client side with already logged In user list
					// token by passwing username
					if (applicationLevel.LoggedInUsersList.get(jwt).equals(jwt)) {
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Can NOT set user authentication -> Message: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		
        
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}
		
		if( request.getQueryString()!=null) {
			String[] authParam = request.getQueryString().split("=");
			System.out.println(authParam[1].replace("Bearer", ""));
			if(authParam[1]!=null&&authParam[1].startsWith("Bearer")) {
				
				System.out.println(AESEncryptionUtilClass.decrypt(authParam[1].replace("Bearer", "")));
				return AESEncryptionUtilClass.decrypt(authParam[1].replace("Bearer", ""));
		    	   //return authParam[1].replace("Bearer", "");
		       }
			}
       
		return null;
	}


}
