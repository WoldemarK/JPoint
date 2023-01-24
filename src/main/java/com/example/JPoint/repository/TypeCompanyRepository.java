package com.example.JPoint.repository;

import com.example.JPoint.model.TypeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompanyRepository extends JpaRepository<TypeCompany,Long> {
}
