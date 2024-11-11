package com.prov.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prov.entity.UserCredentials;

import java.util.Optional;

public interface UserCredentialRepository  extends JpaRepository<UserCredentials,Integer> {
    Optional<UserCredentials> findByName(String username);
}