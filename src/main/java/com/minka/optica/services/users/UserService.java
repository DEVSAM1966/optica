package com.minka.optica.services.users;

import com.minka.optica.dto.SaveUser;
import com.minka.optica.entities.User;

public interface UserService {
    User registreOneCustomer(SaveUser newUser);
}
