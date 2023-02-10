package com.example.JPoint.mapper;

import com.example.JPoint.dto.TaskDto;
import com.example.JPoint.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto convertTaskToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getTitle())
                .descriptions(task.getDescriptions())
                .creation(task.getCreation())
                .update(task.getUpdate())
                .build();

    }

    public Task convertDtoToTask(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getName())
                .descriptions(taskDto.getDescriptions())
                .creation(taskDto.getCreation())
                .update(taskDto.getUpdate())
                .build();

    }
}
