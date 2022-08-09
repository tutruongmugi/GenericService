package com.clone.instagram.repositories;

import com.clone.instagram.entities.Post;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface PostRepository extends IGenericRepository<Post> {

}
