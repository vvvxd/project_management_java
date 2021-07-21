package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.config.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        results.add( new ProjectsResponseDto("1", ProjectStatus.ACTIVE));
        results.add(  new ProjectsResponseDto("2",ProjectStatus.ACTIVE));
        results.add(  new ProjectsResponseDto("3",ProjectStatus.ACTIVE));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/project")
    public ResponseEntity<ProjectsResponseDto> createProject(@RequestBody ProjectsRequestDto requestDto) {
        return ResponseEntity.ok().body(new ProjectsResponseDto(requestDto.getProject_name(),requestDto.getStatus()));
    }

    @Operation(summary = "Удаление проекта")
    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}