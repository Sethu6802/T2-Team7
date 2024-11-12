package com.example.Secuirtyservice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import com.example.Secuirtyservice.security_service.Service.MyUserDetailsService;
import com.example.Secuirtyservice.security_service.Service.jwtService;

import java.io.IOException;
import java.util.ArrayList;

@Component
//public class JwtFilter extends OncePerRequestFilter {
public class JwtFilter{
	
    @Autowired
    private jwtService jwtService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    
    
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//      
//    	System.out.println("entered");
//    	String token = extractJwtToken(request);
//        UserDetails user = myUserDetailsService.loadUserByUsername(jwtService.extractUserName(token));
//        
//        if (token != null && jwtService.validateToken(token,user)) {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(
//                jwtService.extractUserName(token), null, new ArrayList<>());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        
//        filterChain.doFilter(request, response);
//    }

    private String extractJwtToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return (header != null && header.startsWith("Bearer ")) ? header.substring(7) : null;
    }
    
}
