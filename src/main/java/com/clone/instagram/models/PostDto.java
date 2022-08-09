package com.clone.instagram.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;

    @NotEmpty(message = "Caption shouldn't be empty")
    @Size(min= 2, max = 64,message = " Caption should between 2 -> 64 characters")
    private String caption;

    private Long userId;
}
