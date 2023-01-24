package com.example.JPoint.dto;

import com.example.JPoint.model.User;
import lombok.Data;


@Data
public class PostDto {
    private  Long id;
    private String name;
    private String description;
    private boolean isCustom;
    private User user;
}
