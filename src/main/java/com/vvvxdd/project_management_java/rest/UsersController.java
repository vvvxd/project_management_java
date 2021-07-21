package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
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

    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UsersResponseDto>> getUsers() {
        List<UsersResponseDto> results = new ArrayList<>();
        results.add( new UsersResponseDto(1,"Иванов","Иван","Иванович",1));
        results.add( new UsersResponseDto(2,"Иванов","Иван","Иванович",1));
        results.add( new UsersResponseDto(3,"Иванов","Иван","Иванович",1));
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить пользователя")
    @PostMapping(value = "/user")
    public ResponseEntity<UsersResponseDto> createUsers(@RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok().body(new UsersResponseDto(requestDto.getRole_id(),requestDto.getLast_name(),requestDto.getFirst_name(),requestDto.getMiddle_name(),requestDto.getProject_id()));
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity deleteUsers(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}