package com.minka.optica.services.users;

import com.minka.optica.dto.SaveUser;
import com.minka.optica.entities.Role;
import com.minka.optica.entities.User;
import com.minka.optica.exceptions.InvalidPasswordException;
import com.minka.optica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registreOneCustomer(SaveUser newUser) {

        // Método para validar el password recibido.
        validatePassword(newUser);

        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());

        // Solo se da el rol de ROLE_CUSTOMER.
        user.setRole(Role.ROLE_SELLER);

        return userRepository.save(user);

    }

    // Realizamos una validación muy básica, pero puede variar según el negocio a implementar
    private void validatePassword(SaveUser dto) {

        // Verificamos que no sean null Password y RepeatedPassword.
        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }

        // Verificamos que Password y RepeatedPassword sean iguales.
        if(!dto.getPassword().equals(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
    }


}
