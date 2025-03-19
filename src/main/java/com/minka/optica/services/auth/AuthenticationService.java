package com.minka.optica.services.auth;

import com.minka.optica.dto.RegisteredUser;
import com.minka.optica.dto.SaveUser;
import com.minka.optica.entities.User;
import com.minka.optica.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    public RegisteredUser registerOneCustomer(SaveUser newUser) {

        // Damos de alta al usuario en la BD.
        User user = userService.registreOneCustomer(newUser);

        // Devolvemos los datos de alta en un DTO (el password no se envia)
        RegisteredUser userDto = new RegisteredUser();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().name());

        // Creamos el Token JWT.
        String jwt = jwtService.generateToken(user);
        userDto.setJwt(jwt);

        return userDto;


    }
}