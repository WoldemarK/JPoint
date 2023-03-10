package com.example.JPoint.mapper;
import com.example.JPoint.dto.UserDto;
import com.example.JPoint.model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public UserDto convertPersonToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .sex(user.getSex())
                .isActive(user.isActive())
                .creation(user.getCreation().atStartOfDay())
                .update(user.getUpdate().atStartOfDay())
                .build();
    }
    public User convertDtoToPerson(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birth(dto.getBirth())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .sex(dto.getSex())
                .isActive(dto.isActive())
                .creation(LocalDate.from(dto.getCreation()))
                .update(LocalDate.from(dto.getUpdate()))
                .build();
    }
}
