package com.example.Secuirtyservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Secuirtyservice.dto.UserDto;
import com.example.Secuirtyservice.security_service.Service.UserService;
import com.example.Secuirtyservice.security_service.model.User_access;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public User_access register(@RequestBody User_access user)
    {
    	userService.register(user);
    	return user;
    }
    
    
    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
    	System.out.println("token endpoint..." + userDto.getUsername());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        if (authenticate.isAuthenticated()) {
        	System.out.println(userDto.getUsername());
            return userService.generateToken(userDto.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }
    
}
