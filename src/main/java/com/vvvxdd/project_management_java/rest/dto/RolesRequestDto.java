package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Роль")
public class RolesRequestDto {

    @Schema(description = "ID роли")
    private long Role_id;

    @Schema(description = "Название роли")
    private String Name;

    public long getRole_id() {
        return Role_id;
    }

    public void setRole_id(long role_id) {
        Role_id = role_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RolesRequestDto(long role_id, String name) {
        Role_id = role_id;
        Name = name;
    }
}
