package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
import com.vvvxdd.project_management_java.servise.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/")
    public ResponseEntity<List<UsersResponseDto>> getUsers() {
        LOGGER.info("All users requested");
        List<UsersResponseDto> usersResponseDtoList = usersService.getAll();
        LOGGER.info("All users provided");
        return ResponseEntity.ok().body(usersResponseDtoList);
    }

    @Operation(summary = "Прочитать пользователя по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UsersResponseDto> getProject(@PathVariable long id) {
        LOGGER.info("User info requested for id = {}", id);
        UsersResponseDto usersResponseDto = usersService.getById(id);
        LOGGER.info("User info provided for id = {}", id);
        return ResponseEntity.ok().body(usersResponseDto);
    }

    @Operation(summary = "Добавить пользователя")
    @PostMapping(value = "/")
    public ResponseEntity<Long> createUsers(@RequestBody UsersRequestDto requestDto) {
        LOGGER.info("User creation requested.");
        Long id = usersService.save(requestDto);
        LOGGER.info("User created with id = {}", id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUsers(@PathVariable Long id) {
        LOGGER.info("User deletion requested for id = {}", id);
        usersService.deleteById(id);
        LOGGER.info("User id = {} deleted", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsersResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody UsersRequestDto requestDto) {
        LOGGER.info("User update requested for id = {}", id);
        usersService.update(requestDto, id);
        LOGGER.info("User update done for id = {}", id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}