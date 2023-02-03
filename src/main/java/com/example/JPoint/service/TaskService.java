package com.example.JPoint.service;

import com.example.JPoint.model.Task;
import com.example.JPoint.repository.PersonRepository;
import com.example.JPoint.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final PersonRepository personRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
//    public Task createTaskPerson(Task task, Long _personId){
//
//    }
}
