package com.example.Secuirtyservice.security_service.Service;

import java.security.Key;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Secuirtyservice.security_service.model.User_access;
import com.example.Secuirtyservice.security_service.repo.UserRepo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService {

    private static final String SECRET_KEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    @Autowired
    private UserRepo repo;
    
    @Autowired
    private jwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User_access register(User_access user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return user;
    }

    public String verify(String user) {
        return jwtService.generatedToken(user);
    }

    public boolean validatetoken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static Key getKey() {
        byte[] secretKeyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}
