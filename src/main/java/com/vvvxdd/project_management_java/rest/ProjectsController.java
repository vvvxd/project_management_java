package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.config.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Проекты")
@RequestMapping("/api/projects")
@RestController
public class ProjectsController {

    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/project")
    public ResponseEntity<List<ProjectsResponseDto>> getProjects() {
        List<ProjectsResponseDto> results = new ArrayList<>();
        results.add(new ProjectsResponseDto("1", ProjectStatus.ACTIVE));
        results.add(new ProjectsResponseDto("2", ProjectStatus.ACTIVE));
        results.add(new ProjectsResponseDto("3", ProjectStatus.ACTIVE));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/project")
    public ResponseEntity<ProjectsResponseDto> createProject(@RequestBody ProjectsRequestDto requestDto) {
        return ResponseEntity.ok().body(new ProjectsResponseDto(requestDto.getProjectName(), requestDto.getStatus()));
    }

    @Operation(summary = "Удаление проекта")
    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление проекта")
    @PutMapping(value = "/project/{id}")
    public ResponseEntity<ProjectsResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody ProjectsRequestDto requestDto) {
        return ResponseEntity.ok().body(new ProjectsResponseDto(requestDto.getProjectName(), requestDto.getStatus()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}