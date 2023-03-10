package com.example.JPoint.controller;

import com.example.JPoint.model.User;
import com.example.JPoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllPerson() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create/{_depId}/{_postId}")
    public ResponseEntity<User> createPersonAndDepartmentAndPost(
            @RequestBody User _user,
            @PathVariable("_depId") Long _depId,
            @PathVariable("_postId") Long _postId
    ) {
        return _user == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(userService.createUserAndDepartmentAndPost(_user, _depId, _postId),
                HttpStatus.CREATED);
    }

    @PostMapping("/create/new/user")
    public ResponseEntity<User> createNewPerson(@RequestBody User _user) {
        return _user == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(userService.createNewUser(_user), HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public User getPersonById(@PathVariable("id") Long id) {
        return userService.getUsersById(id);
    }

    @PutMapping("/post/{userId}/{postId}")
    public ResponseEntity<Optional<User>> applyPost(@PathVariable("userId") Long userId,
                                                    @PathVariable("postId") Long postId) {
        return new ResponseEntity<>(userService.applyPost(userId, postId), HttpStatus.CREATED);
    }

    @PutMapping("/dep/{userId}/{depId}")
    public ResponseEntity<Optional<User>> applyDepartments
            (
                    @PathVariable("userId") Long userId,
                    @PathVariable("depId") Long depId) {
        return new ResponseEntity<>(userService.applyDepartments(userId, depId), HttpStatus.OK);
    }

    @PutMapping("/dep/{userId}/{depId}/{postId}")
    public ResponseEntity<Optional<User>> applyDepartmentsAddPast
            (
                    @PathVariable("userId") Long userId,
                    @PathVariable("depId") Long depId,
                    @PathVariable("postId") Long postId) {
        return new ResponseEntity<>(userService.applyDepartmentsAddPast(userId, depId, postId),
                HttpStatus.OK);
    }

}
