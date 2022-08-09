package com.clone.instagram.repositories;

import com.clone.instagram.entities.User;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface UserRepository extends IGenericRepository<User> {
    Optional<User> findByEmail(@NotBlank String email);
    Optional<User> findByUsername(@NotBlank String username);
    Optional<User> findByUsernameOrEmail(String username,String email);
}
