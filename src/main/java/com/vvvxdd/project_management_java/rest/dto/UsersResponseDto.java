package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Пользователи")
public class UsersResponseDto {

    @Schema(description = "ID роли")
    private long Role_id;
    @Schema(description = "Фамилия")
    private String last_name;
    @Schema(description = "Имя")
    private String first_name;
    @Schema(description = "Отчество")
    private String middle_name;
    @Schema(description = "ID проекта")
    private long Project_id;

    public long getRole_id() {
        return Role_id;
    }

    public void setRole_id(long role_id) {
        Role_id = role_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public long getProject_id() {
        return Project_id;
    }

    public void setProject_id(long project_id) {
        Project_id = project_id;
    }

    public UsersResponseDto(long role_id, String last_name, String first_name, String middle_name, long project_id) {
        Role_id = role_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        Project_id = project_id;
    }


}
