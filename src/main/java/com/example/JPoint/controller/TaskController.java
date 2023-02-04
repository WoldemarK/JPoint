package com.example.JPoint.controller;

import com.example.JPoint.model.Task;
import com.example.JPoint.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Task>> getAllTask() {
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
    }

    @PostMapping("/create/new/task")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createNewTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/addendum/person/{personId}")
    public ResponseEntity<Task> addendumPerson(@RequestBody Task _task, @PathVariable("personId") Long userId) {
        return _task == null
                ? new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED)
                : new ResponseEntity<>(taskService.addendumPerson(_task, userId), HttpStatus.CREATED);
    }
}
