package com.example.Secuirtyservice.security_service.Service;

import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Secuirtyservice.security_service.model.User_access;
import com.example.Secuirtyservice.security_service.repo.UserRepo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService {
	
	
	private static final String SECERET="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);


    public User_access register(User_access user) {
        user.getPassword();//some action left
         repo.save(user);
        return  user;
    }
    public String verify(String user)
    {

            return jwtService.generatedToken(user);

    }
	public boolean validatetoken(String token) {
		return Jwts.parserBuilder().setSigningKey(getkey()).build().parseClaimsJws(token) != null;
	}
	
private static Key getkey() {
		
		byte[] bytes = Decoders.BASE64.decode(SECERET);
		
		return Keys.hmacShaKeyFor(bytes);
		
	}
}
