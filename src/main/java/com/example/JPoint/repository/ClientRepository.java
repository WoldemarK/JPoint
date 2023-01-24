package com.example.JPoint.repository;

import com.example.JPoint.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Company, Long> {

}
