package com.example.JPoint.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PersonDto {
    private Long id;

    private String login;
    private String password;

    private String firstName;

    private String lastName;

    private String birth;

    private String phoneNumber;

    private String email;

    private LocalDateTime creation;

    private LocalDateTime update;
}
