package com.minka.optica.services.users;

//import com.minka.optica.dto.SaveUser;
import com.minka.optica.dataholders.UsersDh;
import com.minka.optica.entities.Role;
import com.minka.optica.entities.User;
import com.minka.optica.exceptions.BdNotSaveException;
import com.minka.optica.exceptions.InvalidPasswordException;
import com.minka.optica.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registreOneCustomer(UsersDh newUser) {

        // Método para validar si existe el usuario.
        final Optional<User> userOptional = this.findOneByUsername(newUser.getUsername());
        if (userOptional.isPresent()){
            throw new BdNotSaveException("POST - There are one user in the BD with name - " + userOptional.get().getUsername());
        }

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

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    // Realizamos una validación muy básica, pero puede variar según el negocio a implementar
    private void validatePassword(UsersDh usersDh) {

        // Verificamos que no sean null Password y RepeatedPassword.
        if(!StringUtils.hasText(usersDh.getPassword()) || !StringUtils.hasText(usersDh.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords contain invalid characters");
        }

        // Verificamos que Password y RepeatedPassword sean iguales.
        if(!usersDh.getPassword().equals(usersDh.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
    }


}
