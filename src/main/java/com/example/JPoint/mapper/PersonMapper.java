package com.example.JPoint.mapper;
import com.example.JPoint.dto.PersonDto;
import com.example.JPoint.model.Person;
import org.springframework.stereotype.Component;
@Component
public class PersonMapper {

    public PersonDto convertPersonToDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .login(person.getLogin())
                .password(person.getPassword())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .birth(person.getBirth())
                .phoneNumber(person.getPhoneNumber())
                .email(person.getEmail())
                .build();
    }
    public Person convertDtoToPerson(PersonDto dto) {
        return Person.builder()
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
