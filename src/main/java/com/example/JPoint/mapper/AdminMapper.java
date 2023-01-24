package com.example.JPoint.mapper;

import com.example.JPoint.dto.AdminDto;
import com.example.JPoint.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public AdminDto convertUserToDto(User user) {
        AdminDto dto = AdminDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .department(user.getDepartments())
                .post(user.getPosts())
                .role(user.getRoles())
                .isProject(user.isProject())
                .isTask(user.isTask())
                .creation(user.getCreation())
                .update(user.getUpdate())
                .build();
        return dto;
    }

    public User convertDtoToUser(AdminDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birth(dto.getBirth())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .departments(dto.getDepartment())
                .posts(dto.getPost())
                .roles(dto.getRole())
                .isProject(dto.isProject())
                .isTask(dto.isTask())
                .creation(dto.getCreation())
                .update(dto.getUpdate())
                .build();

        return user;
    }


}
