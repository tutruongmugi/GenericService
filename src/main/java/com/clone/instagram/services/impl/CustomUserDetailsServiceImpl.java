package com.clone.instagram.services.impl;

import com.clone.instagram.entities.User;
import com.clone.instagram.exceptions.ResourceNotFoundException;
import com.clone.instagram.repositories.UserRepository;
import com.clone.instagram.security.UserPrincipal;
import com.clone.instagram.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)  {
        User user =userRepository.findByEmail(usernameOrEmail).orElseThrow(()->new ResourceNotFoundException("User","Email",usernameOrEmail));

        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));

        return UserPrincipal.create(user);
    }
}
