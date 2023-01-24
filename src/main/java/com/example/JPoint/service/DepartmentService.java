package com.example.JPoint.service;

import com.example.JPoint.model.Department;
import com.example.JPoint.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department createDepartments(Department department){
        return departmentRepository.save(department);
    }
}
