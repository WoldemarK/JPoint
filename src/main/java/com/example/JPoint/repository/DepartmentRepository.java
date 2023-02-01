package com.example.JPoint.repository;
import com.example.JPoint.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(String name);

    List<Department> findByNameIsStartingWith(String name);


}
