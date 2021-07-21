package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.config.TaskStatus;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Tag(name = "Задачи")
@RequestMapping("/api/tasks")
@RestController
public class TasksController {

    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TasksResponseDto>> getTasks() {
        List<TasksResponseDto> results = new ArrayList<>();
        results.add( new TasksResponseDto(1, TaskStatus.BACKLOG,2,2,2));
        results.add( new TasksResponseDto(1, TaskStatus.BACKLOG,2,2,2));
        results.add( new TasksResponseDto(1, TaskStatus.BACKLOG,2,2,2));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/task")
    public ResponseEntity<TasksResponseDto> createTask(@RequestBody TasksRequestDto requestDto) {
        return ResponseEntity.ok().body(new TasksResponseDto(requestDto.getRelease_id(),requestDto.getStatus(),requestDto.getProject_id(),requestDto.getExecutor_id(),requestDto.getCustomer_id()));
    }

    @Operation(summary = "Удаление задачу")
    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}