<<<<<<< HEAD
package com.example.Secuirtyservice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.Secuirtyservice.security_service.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Autowired
   private MyUserDetailsService userDetailsService;

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return
                http
                        .csrf(customizer->customizer.disable())
                        .authorizeHttpRequests(request->request.anyRequest().permitAll())
                        .httpBasic(Customizer.withDefaults())
                        .build();

   }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);


        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
}
=======
package com.example.Secuirtyservice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.Secuirtyservice.security_service.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Autowired
   private MyUserDetailsService userDetailsService;

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return
                http
                        .csrf(customizer->customizer.disable())
                        .authorizeHttpRequests(request->request.anyRequest().permitAll())
                        .httpBasic(Customizer.withDefaults())
                        .build();

   }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);


        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
}
>>>>>>> 230ef0bd020b367ac341a9e579bd032067db3aaf
