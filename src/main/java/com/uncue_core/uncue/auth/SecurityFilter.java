package com.uncue_core.uncue.auth;

import com.uncue_core.uncue.auth.models.Credentials;
import com.uncue_core.uncue.auth.models.SecurityProperties;
import com.uncue_core.uncue.collections.Saloon;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import com.uncue_core.uncue.controller.SaloonController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    SecurityService securityService;

    @Autowired
    SecurityProperties restSecProps;

    @Autowired
    CookieUtils cookieUtils;

    @Autowired
    SecurityProperties securityProps;

    @Autowired
    SaloonController saloonController;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        verifyToken(request);
        filterChain.doFilter(request, response);
    }

    private void verifyToken(HttpServletRequest request) {
        String session = null;
        FirebaseToken decodedToken = null;
        Credentials.CredentialType type = null;
        boolean strictServerSessionEnabled = securityProps.getFirebaseProps().isEnableStrictServerSession();
        Cookie sessionCookie = cookieUtils.getCookie("session");
        String token = securityService.getBearerToken(request);
        logger.info(token);
        try {
            if (sessionCookie != null) {
                session = sessionCookie.getValue();
                decodedToken = FirebaseAuth.getInstance().verifySessionCookie(session,
                        securityProps.getFirebaseProps().isEnableCheckSessionRevoked());
                type = Credentials.CredentialType.SESSION;
            } else if (!strictServerSessionEnabled) {
                if (token != null && !token.equalsIgnoreCase("undefined")) {
                    decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
                    type = Credentials.CredentialType.ID_TOKEN;
                }
            }
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            log.error("Firebase Exception:: ", e.getLocalizedMessage());
        }
        Saloon saloon = firebaseTokenToUserDto(decodedToken);
        if (saloon != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(saloon,
                    new Credentials(type, decodedToken, token, session), null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private Saloon firebaseTokenToUserDto(FirebaseToken decodedToken) {
        Saloon saloon = null;
        if (decodedToken != null) {
            saloon = new Saloon();
            saloon.setUid(decodedToken.getUid());
            saloon.setName(decodedToken.getName());
            saloon.setEmail(decodedToken.getEmail());
            saloon.setPicture(decodedToken.getPicture());
            saloon.setIssuer(decodedToken.getIssuer());
            saloon.setEmailVerified(decodedToken.isEmailVerified());
            saloonController.findOrCreateSaloonInRepository(saloon);

        }
        return saloon;
    }

}
