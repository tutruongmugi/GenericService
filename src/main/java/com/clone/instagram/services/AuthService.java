package com.clone.instagram.services;

import com.clone.instagram.entities.User;
import com.clone.instagram.payloads.ApiResponse;
import com.clone.instagram.payloads.JwtAuthenticationResponse;
import com.clone.instagram.payloads.LoginRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthService {
    JwtAuthenticationResponse authenticateUser(@RequestBody @Valid LoginRequest loginRequest);
    ApiResponse registerUser(@RequestBody @Valid User user);
}
