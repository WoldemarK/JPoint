package com.example.JPoint.dto;

import com.example.JPoint.model.User;
import lombok.Data;


@Data
public class DepartmentDto {
    private  Long id;
    private String name;
    private String description;
    private boolean custom;
    private User user;

}
