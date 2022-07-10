package edu.miu.amp.aspect;

import edu.miu.amp.domain.User;
import edu.miu.amp.repository.UserRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class RegisterNewUser {

    @Autowired
    private UserRepo userRepo;

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping ) ||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ")
    public void registerNewUser(JoinPoint joinPoint) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            var principal = (KeycloakPrincipal) authentication.getPrincipal();
            var securityContext = principal.getKeycloakSecurityContext();
            var token = securityContext.getToken();

            var existingUser = userRepo.findByUserName(token.getPreferredUsername()).orElse( null );

            System.out.println("Checking new user");

            if(existingUser==null){
                System.out.println("Saving new user");
                var newUser = new User();
                newUser.setEmail(token.getEmail());
                newUser.setUserName(token.getPreferredUsername());
                newUser.setFirstName(token.getName());
                newUser.setLastName(token.getFamilyName());
                newUser.setCreatedAt(new Date());
                userRepo.save(newUser);
            }
        }

    }
}


