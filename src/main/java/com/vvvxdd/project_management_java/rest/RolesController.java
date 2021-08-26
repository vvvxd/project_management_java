package com.vvvxdd.project_management_java.rest;

import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.servise.RolesService;
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

@Tag(name = "Роли")
@RequestMapping("/api/roles")
@RestController
public class RolesController {
    private final RolesService rolesService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Operation(summary = "Получить список ролей")
    @GetMapping(value = "/")
    public ResponseEntity<List<RolesResponseDto>> getRoles() {
        LOGGER.info("All roles requested");
        List<RolesResponseDto> rolesResponseDtoList = rolesService.getAll();
        LOGGER.info("All roles provided");
        return ResponseEntity.ok().body(rolesResponseDtoList);
    }

    @Operation(summary = "Прочитать роль по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<RolesResponseDto> getProject(@PathVariable long id) {
        LOGGER.info("Role info requested for id = {}", id);
        RolesResponseDto rolesResponseDto = rolesService.getById(id);
        LOGGER.info("Role info provided for id = {}", id);
        return ResponseEntity.ok().body(rolesResponseDto);
    }

    @Operation(summary = "Добавить роль")
    @PostMapping(value = "/")
    public ResponseEntity<Long> createRole(@RequestBody RolesRequestDto requestDto) {
        LOGGER.info("Role creation requested.");
        Long id = rolesService.save(requestDto);
        LOGGER.info("Role created with id = {}", id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "Удаление роли")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        LOGGER.info("Role deletion requested for id = {}", id);
        rolesService.deleteById(id);
        LOGGER.info("Role id = {} deleted", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление релиза")
    @PutMapping(value = "/{id}")
    public ResponseEntity<RolesResponseDto> partialUpdateTask(@PathVariable Long id, @RequestBody RolesRequestDto requestDto) {
        LOGGER.info("Role update requested for id = {}", id);
        rolesService.update(requestDto, id);
        LOGGER.info("Role update done for id = {}", id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
