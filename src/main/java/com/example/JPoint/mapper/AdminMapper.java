package com.example.JPoint.mapper;

import com.example.JPoint.dto.AdminDto;
import com.example.JPoint.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public AdminDto convertUserToDto(User user) {
        AdminDto dto = AdminDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .birth(user.getBirth())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .role(user.getRole())
                .post(user.getPost())
                .statusRole(user.getStatusRole())
                .department(user.getDepartment())
                .creation(user.getCreation())
                .update(user.getUpdate())
                .build();
        return dto;
    }

    public User convertDtoToUser(AdminDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setBirth(dto.getBirth());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPost(dto.getPost());
        user.setStatusRole(dto.getStatusRole());
        user.setDepartment(dto.getDepartment());
        user.setCreation(dto.getCreation());
        user.setUpdate(dto.getUpdate());
        return user;

    }

}
