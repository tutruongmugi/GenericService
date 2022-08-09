package com.clone.instagram.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;

    @NotEmpty(message = "First name shouldn't be empty")
    @Size(min= 2, max = 64,message = " First name should between 2 -> 64 characters")
    private String firstName;

    @NotEmpty(message = "Last name shouldn't be empty")
    @Size(min= 2, max = 64,message = " Last name should between 2 -> 64 characters")
    private String lastName;

    @NotEmpty(message = "Email shouldn't be empty")
    @Size(min = 2, max = 64,message = "email should have more than 2 characters and less than 64 character")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Alias name shouldn't be empty")
    @Size(min= 2, max = 64,message = " Alias name should between 2 -> 64 characters")
    private String aliasName;
    private String username;
    private String password;
    private List<PostDto> posts;
}
