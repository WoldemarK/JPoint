package com.example.JPoint.service;

import com.example.JPoint.exception.AllException;
import com.example.JPoint.model.Department;
import com.example.JPoint.model.Person;
import com.example.JPoint.model.Task;
import com.example.JPoint.repository.PersonRepository;
import com.example.JPoint.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final PersonRepository personRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task createNewTask(@Validated Task _task) {
        return taskRepository.save(_task);
    }

    @Transactional
    public void deleteById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            taskRepository.deleteById(taskId);
        }
        throw new AllException("Задача с " + taskId + " не найдена");
    }

    @Transactional
    public Task addendumPerson(@Validated Task _task, Long personId) {
        _task.addPerson(personRepository.findById(personId).get());
        return taskRepository.save(_task);
    }
}
