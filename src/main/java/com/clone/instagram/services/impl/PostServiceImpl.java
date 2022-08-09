package com.clone.instagram.services.impl;

import com.clone.instagram.entities.Post;
import com.clone.instagram.repositories.IGenericRepository;
import com.clone.instagram.repositories.PostRepository;
import com.clone.instagram.services.PostService;
import com.clone.instagram.services.genericServices.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends GenericService<Post> implements PostService {

    @Autowired
    private PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        super(postRepository);
    }


}
