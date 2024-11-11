package com.example.Secuirtyservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Secuirtyservice.security_service.Service.UserService;
import com.example.Secuirtyservice.security_service.model.User_access;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User_access register(@RequestBody User_access user)
    {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User_access user)

    {
        System.out.println(user);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        System.out.println("Authentictaion :"+authentication);
        System.out.println("john");
        if(authentication.isAuthenticated()) {
            return userService.verify(user.getUsername());
        }
        return null;
    }
    
    @GetMapping("/validate")
    public boolean loginuser(@RequestParam String token) {
 	   
 	   return userService.validatetoken(token);
 	  
 	   
    }
    
}
