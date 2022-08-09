package com.clone.instagram.controllers;

import com.clone.instagram.entities.User;
import com.clone.instagram.models.UserDto;
import com.clone.instagram.payloads.ApiResponse;
import com.clone.instagram.payloads.JwtAuthenticationResponse;
import com.clone.instagram.payloads.LoginRequest;
import com.clone.instagram.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/public/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signin")
    public JwtAuthenticationResponse authenticateUser(@RequestBody @Valid LoginRequest loginRequest){
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ApiResponse registerUser(@RequestBody @Valid UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        return authService.registerUser(user);
    }
}
