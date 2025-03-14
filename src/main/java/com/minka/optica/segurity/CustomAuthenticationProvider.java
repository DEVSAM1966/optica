package com.minka.optica.segurity;

import com.minka.optica.services.users.UsersServiceImp;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsersServiceImp userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UsersServiceImp userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        System.out.println("USUARIO: " + username);
        String password = authentication.getCredentials().toString();
        System.out.println("PASSWORD: " + password);

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Entramos en el if. user no es null y he pasado el passwordEncoder");
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new AuthenticationException("Invalid username or password") {};
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
