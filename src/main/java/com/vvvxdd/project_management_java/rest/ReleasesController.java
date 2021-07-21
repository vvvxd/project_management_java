package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.config.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Tag(name = "Релизы")
@RequestMapping("/api/releases")
@RestController
public class ReleasesController {

    @Operation(summary = "Получить список релизов")
    @GetMapping(value = "/releases")
    public ResponseEntity<List<ReleasesResponseDto>> getReleases() {
        List<ReleasesResponseDto> results = new ArrayList<>();
        results.add( new ReleasesResponseDto(new Date(), new Date()));
        results.add( new ReleasesResponseDto(new Date(), new Date()));
        results.add( new ReleasesResponseDto(new Date(), new Date()));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping(value = "/release")
    public ResponseEntity<ReleasesResponseDto> createRelease(@RequestBody ReleasesRequestDto requestDto) {
        return ResponseEntity.ok().body(new ReleasesResponseDto(requestDto.getStart_time(),requestDto.getCompletion_time()));
    }

    @Operation(summary = "Удаление релиза")
    @DeleteMapping(value = "/release/{id}")
    public ResponseEntity deleteRelease(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}