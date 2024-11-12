package com.example.Secuirtyservice.security_service.Service;

import com.example.Secuirtyservice.security_service.model.User_access;
import com.example.Secuirtyservice.security_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private jwtService jwtService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User_access user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        userRepo.save(user);
    }

    public String generateToken(String username) {
        return jwtService.generatedToken(username);
    }


    public void validateToken(String token) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        boolean isValid = jwtService.validateToken(token, userDetails);
        if (!isValid) {
            throw new IllegalArgumentException("Invalid token or user mismatch");
        }
    }


}
