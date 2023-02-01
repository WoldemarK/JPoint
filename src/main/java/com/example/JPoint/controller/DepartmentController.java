package com.example.JPoint.controller;

import com.example.JPoint.model.Department;
import com.example.JPoint.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/depart")
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping("/create/name")
    public ResponseEntity<Department> createDepartments(@RequestBody Department _department) {
        return _department == null
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(service.createDepartments(_department), HttpStatus.CREATED);
    }


    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAll() {
        List<Department> _departments = new ArrayList<>(service.getAllDepartments());
        if (_departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(_departments, HttpStatus.OK);
    }

    @GetMapping("/departments{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDepartmentId(id), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Department>> getNames(String name) {
        return new ResponseEntity<>(service.getDepartmentsName(name), HttpStatus.OK);

    }

    @GetMapping("/start_name")
    public ResponseEntity<List<Department>> getStartNames(String name) {
        return new ResponseEntity<>(service.startStartingWithNames(name), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Department department, @PathVariable("id") Long id) {
        service.updateDepartments(department, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        service.deleteId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
