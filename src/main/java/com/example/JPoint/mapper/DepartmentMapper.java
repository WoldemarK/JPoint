package com.example.JPoint.mapper;

import com.example.JPoint.dto.DepartmentDto;
import com.example.JPoint.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentDto convertDepartmentToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(departmentDto.getId());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        departmentDto.setCustom(department.isCustom());
        departmentDto.setUser(department.getUser());// Нужно сюда засовывать User его нет в конструкторе
        return departmentDto;

    }

    public Department convertDtoToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setCustom(departmentDto.isCustom());
        department.setUser(departmentDto.getUser());
        return department;

    }
}
