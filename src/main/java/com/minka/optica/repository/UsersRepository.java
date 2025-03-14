package com.minka.optica.repository;

import com.minka.optica.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);

}
