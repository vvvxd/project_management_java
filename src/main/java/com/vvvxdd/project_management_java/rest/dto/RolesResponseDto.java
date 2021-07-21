package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Роль")
public class RolesResponseDto {

    @Schema(description = "Название роли")
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RolesResponseDto(String name) {
        Name = name;
    }
}
