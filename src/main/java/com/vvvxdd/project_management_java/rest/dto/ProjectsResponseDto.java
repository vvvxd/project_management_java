package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Проект")
public class ProjectsResponseDto {

    @Schema(description = "Название проекта")
    private String projectName;
    @Schema(description = "Статус проекта")
    private ProjectStatus status;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectsResponseDto(String projectName, ProjectStatus status) {
        this.projectName = projectName;
        this.status = status;
    }
}
