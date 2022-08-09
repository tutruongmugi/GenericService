package com.clone.instagram.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {
    UserDetails loadUserByUsername(String usernameOrEmail)  ;

    UserDetails loadUserById(Long id);
}
