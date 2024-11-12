package com.example.Secuirtyservice.security_service.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Secuirtyservice.security_service.repo.UserRepo;
import com.example.Secuirtyservice.security_service.model.User_access;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepo repo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Received username: " + username);

        if (username == null || username.trim().isEmpty()) {
            throw new UsernameNotFoundException("Username is null or empty");
        }

        User_access user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new UserPrincipal(user);
    }

}
