package com.minka.optica.services.users;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsersService {

    UserDetails loadUserByUsername(String username);

}
