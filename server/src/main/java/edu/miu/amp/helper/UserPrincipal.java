package edu.miu.amp.helper;


import edu.miu.amp.domain.User;
import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

public class UserPrincipal {

    public static User getAuthUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var principal = (KeycloakPrincipal) authentication.getPrincipal();
        var securityContext = principal.getKeycloakSecurityContext();
        var token = securityContext.getToken();

        var newUser = new User();

        newUser.setEmail(token.getEmail());
        newUser.setUserName(token.getPreferredUsername());
        newUser.setFirstName(token.getName());
        newUser.setLastName(token.getFamilyName());
        newUser.setCreatedAt(new Date());

        return newUser;
    }
}
