package com.minka.optica.services.users;

import com.minka.optica.entities.Users;
import com.minka.optica.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersServiceImp implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Mapear las autoridades desde la clave primaria compuesta (AuthorityId)
        Set<GrantedAuthority> authorities = users.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getId().getAuthority())) // Usamos getId().getAuthority()
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), authorities);
    }
}
