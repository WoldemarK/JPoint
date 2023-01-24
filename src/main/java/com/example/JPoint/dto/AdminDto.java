package com.example.JPoint.dto;

import com.example.JPoint.model.Department;
import com.example.JPoint.model.Post;
import com.example.JPoint.model.Role;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class AdminDto {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String birth;
    private String phoneNumber;
    private String email;
    private List<Department> department;
    private List<Post> post;
    private Set<Role> role;
    private boolean isProject;
    private boolean isTask;
    private LocalDateTime creation;
    private LocalDateTime update;
}
