package com.clone.instagram.controllers;

import com.clone.instagram.entities.User;
import com.clone.instagram.models.UserDto;
import com.clone.instagram.services.UserService;
import com.clone.instagram.services.genericServices.GenericService;
import com.clone.instagram.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/public/users")
public class UserController extends GenericController<User>{
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    public UserController(UserService userService) {
        super(userService);
    }


    @GetMapping
    public List<UserDto> findAll() {
        List<User> users = userService.findAll();

        return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UserDto findById(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDto userDto = modelMapper.map(user,UserDto.class);

        return userDto;
    }

    @PostMapping
    public UserDto saveUser(@RequestBody @Valid UserDto userDto){
        User user = modelMapper.map(userDto,User.class);

        User userRes = userService.save(user);

        UserDto userDtoRes = modelMapper.map(userRes,UserDto.class);
        return userDtoRes;
    }
}
