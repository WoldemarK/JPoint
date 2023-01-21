package com.example.JPoint.controller;

import com.example.JPoint.model.User;
import com.example.JPoint.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = adminService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUsers(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(adminService.createNewUsers(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<User>> update(@RequestBody User user, @PathVariable("id") Long id) {
        return ResponseEntity.ok(adminService.update(user, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUsersById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(adminService.getUsersById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserId(@PathVariable("id") Long id) {
        adminService.delete(id);
    }
}
