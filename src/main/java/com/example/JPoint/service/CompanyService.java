package com.example.JPoint.service;

import com.example.JPoint.model.Company;
import com.example.JPoint.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllClients() {
        return companyRepository.findAll();
    }
    public Optional<Company> findById(Long id){
        return companyRepository.findById(id);
    }
}
