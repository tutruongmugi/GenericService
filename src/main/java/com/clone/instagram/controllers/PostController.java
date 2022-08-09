package com.clone.instagram.controllers;

import com.clone.instagram.entities.Post;
import com.clone.instagram.entities.User;
import com.clone.instagram.models.PostDto;
import com.clone.instagram.services.PostService;
import com.clone.instagram.services.UserService;
import com.clone.instagram.services.genericServices.GenericService;
import com.clone.instagram.services.impl.PostServiceImpl;
import com.clone.instagram.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/protected/post")
public class PostController extends GenericController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    public PostController(PostService postService) {
        super(postService);
    }


    @GetMapping
    public List<PostDto> findAll() {
        List<Post> posts = postService.findAll();

        return posts.stream().map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
    }


    @GetMapping("{id}")
    public PostDto findById(@PathVariable Long id) {

        Post post = postService.findById(id);
        PostDto postDto = modelMapper.map(post,PostDto.class);

        return  postDto;
    }

    @PostMapping
    public PostDto savePost(@RequestBody @Valid PostDto postDto){

        User user = userService.findById(postDto.getUserId());

        Post post = modelMapper.map(postDto,Post.class);
        post.setUser(user);

        Post postRes = postService.save(post);

        PostDto postDtoRes = modelMapper.map(postRes,PostDto.class);

        return postDtoRes;
    }
}
