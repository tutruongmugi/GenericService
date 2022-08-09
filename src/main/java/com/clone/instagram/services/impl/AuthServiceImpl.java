package com.clone.instagram.services.impl;

import com.clone.instagram.entities.User;
import com.clone.instagram.entities.role.Role;
import com.clone.instagram.entities.role.RoleName;
import com.clone.instagram.exceptions.ResourceIsAlreadyTakenException;
import com.clone.instagram.exceptions.ResourceNotFoundException;
import com.clone.instagram.models.UserDto;
import com.clone.instagram.payloads.ApiResponse;
import com.clone.instagram.payloads.JwtAuthenticationResponse;
import com.clone.instagram.payloads.LoginRequest;
import com.clone.instagram.repositories.RoleRepository;
import com.clone.instagram.repositories.UserRepository;
import com.clone.instagram.security.JwtTokenProvider;
import com.clone.instagram.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    @Transactional
    public ApiResponse registerUser(User user) {
        if(!userRepository.findByEmail(user.getEmail()).isEmpty()){
            throw new ResourceIsAlreadyTakenException("User","email",user.getEmail());
        }
        if(!userRepository.findByUsername(user.getUsername()).isEmpty()){
            throw new ResourceIsAlreadyTakenException("User","username",user.getUsername());
        }
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(()->new ResourceNotFoundException("Role","Role Name","ROLE_USER"));
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);

        return new ApiResponse(true,"User registered successfully");
    }
}
