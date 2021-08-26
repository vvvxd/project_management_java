package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import com.vvvxdd.project_management_java.servise.ReleasesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Релизы")
@RequestMapping("/api/releases")
@RestController
public class ReleasesController {
    private final ReleasesService releasesService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);

    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    @Operation(summary = "Получить список релизов")
    @GetMapping(value = "/")
    public ResponseEntity<List<ReleasesResponseDto>> getReleases() {
        LOGGER.info("All releases requested");
        List<ReleasesResponseDto> responseDtoList = releasesService.getAll();
        LOGGER.info("All releases provided");
        return ResponseEntity.ok().body(responseDtoList);
    }

    @Operation(summary = "Прочитать релиз по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ReleasesResponseDto> getProject(@PathVariable long id) {
        LOGGER.info("Release info requested for id = {}", id);
        ReleasesResponseDto releasesResponseDto = releasesService.getById(id);
        LOGGER.info("Release info provided for id = {}", id);
        return ResponseEntity.ok().body(releasesResponseDto);
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping(value = "/")
    public ResponseEntity<Long> createRelease(@RequestBody ReleasesRequestDto requestDto) {
        LOGGER.info("Release creation requested.");
        Long id = releasesService.save(requestDto);
        LOGGER.info("Release created with id = {}", id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "Удаление релиза")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRelease(@PathVariable Long id) {
        LOGGER.info("Release deletion requested for id = {}", id);
        releasesService.deleteById(id);
        LOGGER.info("Release id = {} deleted", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление релиза")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleasesResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody ReleasesRequestDto requestDto) {
        LOGGER.info("Release update requested for id = {}", id);
        releasesService.update(requestDto, id);
        LOGGER.info("Release update done for id = {}", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "получить количество незавершенных задач в релизе")
    @GetMapping(value = "/{id}/tasks/backlog")
    public Integer countUnclosedTasks(@PathVariable("id") Long releaseId) {
        return releasesService.countBacklogTask(releaseId);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}