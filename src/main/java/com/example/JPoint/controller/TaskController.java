package com.example.JPoint.controller;

import com.example.JPoint.model.Task;
import com.example.JPoint.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/get/all")
    public ResponseEntity<List<Task>>getAllTask(){
        return new ResponseEntity<>(taskService.getAllTask(),HttpStatus.OK);
    }
}
