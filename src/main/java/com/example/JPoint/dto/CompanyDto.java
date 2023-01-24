package com.example.JPoint.dto;

import com.example.JPoint.model.TypeCompany;
import com.example.JPoint.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data

public class CompanyDto {
    private Long id;

    private String name;
    private String description;
    private List<TypeCompany> typeCompanies;
    private String website;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean independentSearch;
    private User users;
    private LocalDateTime creation;
    private LocalDateTime update;
}
