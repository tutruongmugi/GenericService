package com.clone.instagram.services.impl;

import com.clone.instagram.entities.Post;
import com.clone.instagram.entities.User;
import com.clone.instagram.exceptions.ResourceIsAlreadyTakenException;
import com.clone.instagram.repositories.IGenericRepository;
import com.clone.instagram.repositories.UserRepository;
import com.clone.instagram.services.UserService;
import com.clone.instagram.services.genericServices.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends GenericService<User> implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User save(User entity) {
        if(!userRepository.findByEmail(entity.getEmail()).isEmpty()){
            throw new ResourceIsAlreadyTakenException("User","email",entity.getEmail());
        }
        if(!userRepository.findByUsername(entity.getUsername()).isEmpty()){
            throw new ResourceIsAlreadyTakenException("User","username",entity.getUsername());
        }

        return userRepository.save(entity);
    }
}
