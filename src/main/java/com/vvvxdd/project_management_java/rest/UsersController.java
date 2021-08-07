package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
import com.vvvxdd.project_management_java.servise.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Tag(name = "Пользователи")
@RequestMapping("/api/users")
@RestController
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UsersResponseDto>> getUsers() {
        List<UsersResponseDto> results = usersService.getAll();
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить пользователя")
    @PostMapping(value = "/user")
    public ResponseEntity<UsersResponseDto> createUsers(@RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok().body(new UsersResponseDto(requestDto.getRoleId(), requestDto.getLastName(), requestDto.getFirstMame(), requestDto.getMiddleName(), requestDto.getProjectId()));
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity deleteUsers(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UsersResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok().body(new UsersResponseDto(requestDto.getRoleId(), requestDto.getLastName(), requestDto.getFirstMame(), requestDto.getMiddleName(), requestDto.getProjectId()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}