package com.example.JPoint.service;

import com.example.JPoint.repository.TypeCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeCompanyService {
    private final TypeCompanyRepository typeCompanyRepository;
}
