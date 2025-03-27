package com.minka.optica.services.auth;

import com.minka.optica.dto.RegisteredUser;
import com.minka.optica.dto.SaveUser;
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


    public RegisteredUser registerOneCustomer(SaveUser newUser) {

        // Damos de alta al usuario en la BD.
        System.out.println("1 - Vamos de alta al usuario (Hemos pasado por ello) ");
        User user = userService.registreOneCustomer(newUser);
        System.out.println("1.0 - Damos de alta al usuario (Hemos pasado por ello) ");

        // Devolvemos los datos de alta en un DTO
        System.out.println("2 - Vamos a rellenas los dtos. ");
        RegisteredUser userDto = new RegisteredUser();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().name());
        System.out.println("2.0 -  Rellenados los dtos. ");
        System.out.println(userDto.getId());
        System.out.println(userDto.getName());
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getRole());

        // Creamos el Token JWT.
        System.out.println("3 - Vamos a crear el JWT. ");
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);
        System.out.println("3.0 - Salimos de crear el JWT.  ");
        System.out.println(userDto.getJwt());

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