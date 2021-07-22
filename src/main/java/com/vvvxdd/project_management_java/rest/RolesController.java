package com.vvvxdd.project_management_java.rest;

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

@Tag(name = "Роли")
@RequestMapping("/api/roles")
@RestController
public class RolesController {

    @Operation(summary = "Получить список ролей")
    @GetMapping(value = "/role")
    public ResponseEntity<List<RolesResponseDto>> getRoles() {
        List<RolesResponseDto> results = new ArrayList<>();
        results.add(new RolesResponseDto("Admin"));
        results.add(new RolesResponseDto("User"));
        results.add(new RolesResponseDto("SuperUser"));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить роль")
    @PostMapping(value = "/role")
    public ResponseEntity<RolesResponseDto> createRole(@RequestBody RolesRequestDto requestDto) {
        return ResponseEntity.ok().body(new RolesResponseDto(requestDto.getName()));
    }

    @Operation(summary = "Удаление роли")
    @DeleteMapping(value = "/role/{id}")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление релиза")
    @PutMapping(value = "/role/{id}")
    public ResponseEntity<RolesResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody RolesRequestDto requestDto) {
        return ResponseEntity.ok().body(new RolesResponseDto(requestDto.getName()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
