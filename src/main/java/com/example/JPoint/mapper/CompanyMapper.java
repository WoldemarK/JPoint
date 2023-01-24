package com.example.JPoint.mapper;

import com.example.JPoint.dto.CompanyDto;
import com.example.JPoint.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyDto convertCompanyToDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setDescription(company.getDescription());
        companyDto.setTypeCompanies(company.getTypeCompanies());
        companyDto.setWebsite(company.getWebsite());
        companyDto.setAddress(company.getAddress());
        companyDto.setEmail(company.getEmail());
        companyDto.setIndependentSearch(company.isIndependentSearch());
        companyDto.setUsers(company.getUsers());
        companyDto.setCreation(company.getCreation());
        companyDto.setUpdate(company.getUpdate());
        return companyDto;

    }

    public Company convertDtoToCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        company.setTypeCompanies(companyDto.getTypeCompanies());
        company.setWebsite(companyDto.getWebsite());
        company.setAddress(companyDto.getAddress());
        company.setEmail(companyDto.getEmail());
        company.setIndependentSearch(companyDto.isIndependentSearch());
        company.setUsers(companyDto.getUsers());
        company.setCreation(companyDto.getCreation());
        company.setUpdate(companyDto.getUpdate());
        return company;

    }
}
