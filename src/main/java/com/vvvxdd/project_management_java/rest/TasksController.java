package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.TaskStatus;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import com.vvvxdd.project_management_java.servise.TasksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Tag(name = "Задачи")
@RequestMapping("/api/tasks")
@RestController
public class TasksController {
    private final TasksService tasksService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/")
    public ResponseEntity<List<TasksResponseDto>> getTasks() {
        LOGGER.info("All tasks requested");
        List<TasksResponseDto> tasksResponseDtoList = tasksService.getAll();
        LOGGER.info("All tasks provided");
        return ResponseEntity.ok().body(tasksResponseDtoList);
    }

    @Operation(summary = "Прочитать задачу по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<TasksResponseDto> getProject(@PathVariable long id) {
        LOGGER.info("Task info requested for id = {}", id);
        TasksResponseDto tasksResponseDto = tasksService.getById(id);
        LOGGER.info("Task info provided for id = {}", id);
        return ResponseEntity.ok().body(tasksResponseDto);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/")
    public ResponseEntity<Long> createTask(@RequestBody TasksRequestDto requestDto) {
        LOGGER.info("Task creation requested.");
        Long id = tasksService.save(requestDto);
        LOGGER.info("Task created with id = {}", id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "Удаление задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        LOGGER.info("Task deletion requested for id = {}", id);
        tasksService.deleteById(id);
        LOGGER.info("Task id = {} deleted", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление задачу")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TasksResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody TasksRequestDto requestDto) {
        LOGGER.info("Task update requested for id = {}", id);
        tasksService.update(requestDto, id);
        LOGGER.info("Task update done for id = {}", id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/uploadByCSV")
    @Operation(summary = "Создать задачу", description = "Позволяет создать новую задачу путем загрузки CSV файла")
    public ResponseEntity<Long> newTaskFromCsv(@RequestParam("file") MultipartFile file){
        LOGGER.info("Creating task from CSV.");
        Long id = tasksService.add(file);
        LOGGER.info("Task with id = {} created", id);
        return ResponseEntity.ok().body(id);

    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}