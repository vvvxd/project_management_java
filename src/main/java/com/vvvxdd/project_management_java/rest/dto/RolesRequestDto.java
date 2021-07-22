package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Роль")
public class RolesRequestDto {

    @Schema(description = "ID роли")
    private long roleId;

    @Schema(description = "Название роли")
    private String Name;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RolesRequestDto(long roleId, String name) {
        this.roleId = roleId;
        Name = name;
    }
}
