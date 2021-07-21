package com.vvvxdd.project_management_java.rest.dto;

import com.vvvxdd.project_management_java.config.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Проект")
public class ProjectsResponseDto {

    @Schema(description = "Название проекта")
    private String Project_name;

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    public ProjectsResponseDto(String project_name, ProjectStatus status) {
        Project_name = project_name;
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getProject_name() {
        return Project_name;
    }

    public void setProject_name(String project_name) {
        Project_name = project_name;
    }

    public ProjectsResponseDto(String project_name) {
        Project_name = project_name;
    }
}
