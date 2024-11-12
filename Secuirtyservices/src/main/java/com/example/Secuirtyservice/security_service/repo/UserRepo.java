<<<<<<< HEAD
package com.example.Secuirtyservice.security_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.Secuirtyservice.security_service.model.User_access;


@Repository
public interface UserRepo extends JpaRepository<User_access, Long> {
    User_access findByUsername(String username);
}
=======
package com.example.Secuirtyservice.security_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.Secuirtyservice.security_service.model.User_access;


@Repository
public interface UserRepo extends JpaRepository<User_access, Long> {
    User_access findByUsername(String username);
}
>>>>>>> 230ef0bd020b367ac341a9e579bd032067db3aaf
