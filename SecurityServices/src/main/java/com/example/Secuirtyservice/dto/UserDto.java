package com.example.Secuirtyservice.dto;

import com.example.Secuirtyservice.security_service.model.User_access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String username;
    private String password;
    
}
