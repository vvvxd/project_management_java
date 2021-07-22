package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователи")
public class UsersRequestDto {
    @Schema(description = "ID пользователя")
    private long usersId;
    @Schema(description = "ID роли")
    private long roleId;
    @Schema(description = "Фамилия")
    private String lastName;
    @Schema(description = "Имя")
    private String firstMame;
    @Schema(description = "Отчество")
    private String middleName;
    @Schema(description = "ID проекта")
    private long projectId;

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public void setFirstMame(String firstMame) {
        this.firstMame = firstMame;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public UsersRequestDto(long usersId, long roleId, String lastName, String firstMame, String middleName, long projectId) {
        this.usersId = usersId;
        this.roleId = roleId;
        this.lastName = lastName;
        this.firstMame = firstMame;
        this.middleName = middleName;
        this.projectId = projectId;
    }
}
