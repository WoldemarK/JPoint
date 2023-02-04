package com.example.JPoint.mapper;
import com.example.JPoint.dto.PersonDto;
import com.example.JPoint.model.User;
import org.springframework.stereotype.Component;
@Component
public class PersonMapper {

    public PersonDto convertPersonToDto(User user) {
        return PersonDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
    public User convertDtoToPerson(PersonDto dto) {
        return User.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birth(dto.getBirth())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .build();
    }
}
