package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.servise.ProjectsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/project")
@RestController
public class ProjectsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);
    final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }


    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/")
    public ResponseEntity<List<ProjectsResponseDto>> getProjects() {
        LOGGER.info("All projects requested");
        List<ProjectsResponseDto> projectsServiceAll = projectsService.getAll();
        LOGGER.info("All projects provided");
        return ResponseEntity.ok().body(projectsServiceAll);
    }

    @Operation(summary = "Прочитать проект по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjectsResponseDto> getProject(@PathVariable long id) {
        LOGGER.info("Project info requested for project id = {}", id);
        ProjectsResponseDto projectsResponseDto = projectsService.getById(id);
        LOGGER.info("Project info provided for project id = {}", id);
        return ResponseEntity.ok().body(projectsResponseDto);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/")
    public ResponseEntity<Long> createProject(@RequestBody ProjectsRequestDto requestDto) {
        LOGGER.info("Project creation requested.");
        Long id = projectsService.save(requestDto);
        LOGGER.info("Project created with id = {}", id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "Удаление проекта")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        LOGGER.info("Project deletion requested for id = {}", id);
        projectsService.deleteById(id);
        LOGGER.info("Project id = {} deleted", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление проекта")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectsResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody ProjectsRequestDto requestDto) {
        LOGGER.info("Project update requested for id = {}", id);
        projectsService.update(requestDto, id);
        LOGGER.info("Project update done for id = {}", id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}