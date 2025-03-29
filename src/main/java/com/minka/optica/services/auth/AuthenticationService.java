package com.minka.optica.services.auth;

import com.minka.optica.dataholders.UsersDh;
import com.minka.optica.dto.RegisteredUser;
import com.minka.optica.dto.auth.AuthenticationRequest;
import com.minka.optica.dto.auth.AuthenticationResponse;
import com.minka.optica.entities.User;
import com.minka.optica.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    // Para el login
    @Autowired
    private AuthenticationManager authenticationManager;


    public RegisteredUser registerOneCustomer(UsersDh newUser) {

        // Damos de alta al usuario en la BD.
        User user = userService.registreOneCustomer(newUser);

        // Devolvemos los datos de alta en un DTO
        RegisteredUser userDto = new RegisteredUser();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().name());

        // Creamos el Token JWT.
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);

        return userDto;

    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getName());
        extraClaims.put("role",user.getRole().name());
        extraClaims.put("authorities",user.getAuthorities());

        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest autRequest) {

        // Creamos el objeto para el login
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            autRequest.getUsername(), autRequest.getPassword());

        // Realizo el proceso del login
        authenticationManager.authenticate(authentication);

        // Obtengo el usuario logueado consultando a la BD.
        UserDetails user = userService.findOneByUsername(autRequest.getUsername()).get();

        // Genero del token jwt con los dattos que contiene user
        // Al invocar al método generateToken() que necesita un generateExtraClaims se reliza un Cast de User
        String jwt = jwtService.generateToken(user, generateExtraClaims((User)user));

        // Crea la respuesta
        AuthenticationResponse authRsp = new AuthenticationResponse();
        authRsp.setJwt(jwt);

        // Devuelvo la respuesta
        return authRsp;
    }

    public boolean validateToken(String jwt) {

        try {
            // Valido el formato del token al pasarlo de base 64 a JSON.
            // Valido el formato del Header, Payload, Firma.
            // Valido la caducidad.
            jwtService.extractUsername(jwt);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}