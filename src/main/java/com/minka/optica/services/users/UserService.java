package com.minka.optica.services.users;

import com.minka.optica.dataholders.UsersDh;
import com.minka.optica.dto.SaveUser;
import com.minka.optica.entities.User;
import java.util.Optional;

public interface UserService {
    // User registreOneCustomer(SaveUser newUser);
    User registreOneCustomer(UsersDh usersDh);

    Optional<User> findOneByUsername(String username);
}
